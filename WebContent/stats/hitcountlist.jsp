<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>		
				<th>s_num</th>
				<th>prdurl</th>
				<th>date</th>
				<th>c_num</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="count" items="${list }">
			<tr>
				<td>${count.s_num }</td>
				<td>${count.cnt_prdurl }</td>
				<td>${count.cnt_date }</td>
				<td>${count.c_num }</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>

</body>
</html>