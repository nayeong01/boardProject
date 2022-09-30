package com.myp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardVO;
import com.myp.service.BoardService;


@Controller
@RequestMapping(value="/")
public class BoardController {
	
	@Inject  // 주입(심부름꾼) 명시 
	private BoardService service; // Service 호출을 위한 객체생성
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) // 주소호출 명시. 호출하려는 주소와 REST 방식설정
	public void listAll(Model model) throws Exception { // 메소드 인자값은 model 인터페이스 (jsp전달 심부름꾼)
		model.addAttribute("list",service.listAll()); // jsp에 심부름할 내역 (서비스 호출)
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET) // GET 방식으로 페이지 호출
	public void registerGET(BoardVO board, Model model) throws Exception {
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST) // POST방식으로 내용 전송
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용
		service.regist(board); // 글작성 서비스 호출
		return "redirect:/listAll"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	
	@RequestMapping(value="/read", method= RequestMethod.GET) // GET 방식으로 페이지 호출
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		//인자값은 파라미터 값으로 기본키인 글번호를 기준으로 Model을 사용하여 불러옴
		model.addAttribute(service.read(bno)); // read 서비스 호출
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET) //GET 방식으로 페이지 호출
	public String modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
		return "/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST) // POST 방식으로 내용 전송
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		service.modify(board);
		return "redirect:/listAll";
	}
	

}
