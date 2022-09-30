<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>
</head>
<form method="post" action = "${path}/modify?bno=${boardVO.bno}">
<body>
<p><label>제목</label><input type="text" name="title" value ="${boardVO.title}"></p>
<p><label>작성자</label><input type="text" name="writer" size="15"value ="${boardVO.writer}" readonly="readonly"></p>
<label>내용</label>
<p><textarea rows = "15" cols="65" name="content" >${boardVO.content}</textarea></p>

<button type="submit">수정</button>
</form>
</body>
</html>