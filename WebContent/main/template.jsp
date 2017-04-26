<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String body = request.getParameter("body");
	if(body==null){
		body = "main.jsp";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript"  src="../resources/js/sidebar/sidebar.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#bodys{
		position: relative ;
		width: 100%;
		height : 600px;
		border: 1px solid black;
		float: none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	<jsp:include page="<%= body %>"/> 
	
</body>
</html>