<%@page import="favorite.model.ListModel"%>
<%@page import="favorite.model.Favorite"%>
<%@page import="java.util.List"%>
<%@page import="favorite.model.FavoriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum="1";
	}
	int requestPage = Integer.parseInt(pageNum);

	FavoriteService service1 = FavoriteService.getInstance();
	ListModel listModel = service1.listFavoriteService(request, requestPage);
	request.setAttribute("listModel", listModel);
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/favorite/favorite.css" />
<title>Insert title here</title>
</head>
<body>
	
	<h1><img src="../resources/images/favoriteImg/032-star.png" alt= "쇼핑몰 즐겨찾기페이지" >&nbsp;즐겨찾기</h1>
	<br>
	<br>
	<form action="favorit.jsp?f_num=${favorite.f_num }">
	 <table id="favoriteTb">
		<tr>
			<th>이미지</th>
			<th>쇼핑몰이름</th>
			<th>코멘트</th>
			<th>홈</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="Favorite" items="${listModel.list}">
			<tr>
				<td><img src="">${Favorite.s_image}</td>
				<td><a href="#">${Favorite.s_sname }</a></td>
				<td><a id="comentlink" href="detail.jsp?f_num=${Favorite.f_num}"><img src="../resources/images/favoriteImg/coment.png"></a></td>
				<td><a id="shoplink" href="http://${Favorite.s_shopurl }">
					<img src="../resources/images/favoriteImg/home2.png" onmouseover='this.src="../resources/images/favoriteImg/home1.png"' onmouseout='this.src="../resources/images/favoriteImg/home2.png"'>
					</a></td>
				<td><a id="deleteRow" href="deleteAction.jsp?f_num=${Favorite.f_num}"><img src="../resources/images/favoriteImg/del.png"></a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>

	</form>
	
	<br>
	<br> 
	<section>
	<!-- 이전 -->
	<c:if test="${listModel.startPage > 5 }">
		<a href="favorite.jsp?pageNum=${listModel.startPage-5 }">[이전]</a>
	</c:if>
	
	<!-- 페이지목록 -->
	<c:forEach var="pageNo" begin="${listModel.startPage }" end="${listModel.endPage }">
		<c:if test="${listModel.requestPage == pageNo }"><b></c:if>
			<a id=pageNo href="favorite.jsp?pageNum=${pageNo }">${pageNo }</a>
		<c:if test="${listModel.requestPage == pageNo }"></b></c:if>
	</c:forEach>
	
	<!-- 이후 -->
	<c:if test="${listModel.endPage < listModel.totalPageCount }">
		<a href="favorite.jsp?pageNum=${listModel.startPage+5 }">[이후]</a>
	</c:if>
	</section>


</body>
</html>


 