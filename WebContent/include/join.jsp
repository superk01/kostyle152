<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div id="bodys">
	<h1>회원가입 페이지</h1>
	<form action ="sumResult.jsp" method="post"> 								
			아이디:<input type="text" name="name" size="20"><br>
			비밀번호:<input type="text" name="title" size="20"><br>
			<input type="submit" value="전송">
	</form>
	
	<jsp:forward page="module/template.jsp">
		<jsp:param value="../sumResult.jsp" name="body"/>
	</jsp:forward>
</div>
</body>
</html>