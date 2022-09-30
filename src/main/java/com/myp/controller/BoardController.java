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
	
	@Inject  // ����(�ɺθ���) ��� 
	private BoardService service; // Service ȣ���� ���� ��ü����
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) // �ּ�ȣ�� ���. ȣ���Ϸ��� �ּҿ� REST ��ļ���
	public void listAll(Model model) throws Exception { // �޼ҵ� ���ڰ��� model �������̽� (jsp���� �ɺθ���)
		model.addAttribute("list",service.listAll()); // jsp�� �ɺθ��� ���� (���� ȣ��)
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET) // GET ������� ������ ȣ��
	public void registerGET(BoardVO board, Model model) throws Exception {
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST) // POST������� ���� ����
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception { // ���ڰ����� REDIRECT ���
		service.regist(board); // ���ۼ� ���� ȣ��
		return "redirect:/listAll"; // �ۼ��� �Ϸ�� ��, ����������� ����
	}
	
	@RequestMapping(value="/read", method= RequestMethod.GET) // GET ������� ������ ȣ��
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		//���ڰ��� �Ķ���� ������ �⺻Ű�� �۹�ȣ�� �������� Model�� ����Ͽ� �ҷ���
		model.addAttribute(service.read(bno)); // read ���� ȣ��
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET) //GET ������� ������ ȣ��
	public String modifyGET(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
		return "/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST) // POST ������� ���� ����
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		service.modify(board);
		return "redirect:/listAll";
	}
	

}
