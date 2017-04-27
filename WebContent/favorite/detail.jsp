<%@page import="favorite.model.Favorite"%>
<%@page import="favorite.model.FavoriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%

	request.setCharacterEncoding("utf-8");

	String f_num = request.getParameter("f_num");

	FavoriteService service = FavoriteService.getInstance();
	Favorite favorite = service.detailComentService(f_num); 
	
	request.setAttribute("favorite", favorite);
	

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/favorite/detail.css" />
<title>Insert title here</title>
<script type="text/javascript">
	
	function fn_update(){
		location.href = "updateForm.jsp?f_num=${favorite.f_num}";
	}
	
	function fn_favorite(){
		history.go(-1);
	}

</script>
</head>
<body>
<h1><img src="../resources/images/favoriteImg/032-star.png" alt= "쇼핑몰 즐겨찾기페이지" >&nbsp;즐겨찾기</h1>
	<br>
	<br>
	
	<h3><img src="../resources/images/favoriteImg/coment.png" alt= "쇼핑몰 코멘트 달기" >&nbsp;Comment</h3>
	<table class="detailTable">
		<tr class="favoriteNum">
			<td width="150">즐겨찾기 번호</td>
			<td width="150">${favorite.f_num }</td>
		</tr>
		<tr class="favoriteDate">
			<td width="150">즐겨찾기 추가 날짜</td>
			<td width="150">
				<fmt:formatDate value="${favorite.f_date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>			
		<tr class="favoritComent">			
			<td colspan="2">${favorite.f_coment }</td>			
		</tr>
		<tr class="favoriteBt">			
			<td colspan="2">
				<input type="button" value="수정" onclick="fn_update()">
				<input type="button" value="즐겨찾기" onclick="fn_favorite()">
			</td>			
		</tr>
	</table>

</body>
</html>