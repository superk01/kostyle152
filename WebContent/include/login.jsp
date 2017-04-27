<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<div id="bodys">
	<h1>로그인 페이지</h1>
		<form action ="/JSP/FormServlet" method="post"> 								
			아이디: <input type="text" name="name" size="20"><br>
			비밀번호  : <input type="password" name="password" size="20"><br>
			<input type="submit" value="전송">
	</form>
</div>
</body>
</html>