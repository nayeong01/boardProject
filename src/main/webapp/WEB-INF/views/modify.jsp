<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>�� ����</title>
</head>
<form method="post" action = "${path}/modify?bno=${boardVO.bno}">
<body>
<p><label>����</label><input type="text" name="title" value ="${boardVO.title}"></p>
<p><label>�ۼ���</label><input type="text" name="writer" size="15"value ="${boardVO.writer}" readonly="readonly"></p>
<label>����</label>
<p><textarea rows = "15" cols="65" name="content" >${boardVO.content}</textarea></p>

<button type="submit">����</button>
</form>
</body>
</html>