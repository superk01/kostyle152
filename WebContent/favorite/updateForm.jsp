<%@page import="favorite.model.Favorite"%>
<%@page import="favorite.model.FavoriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String num = request.getParameter("f_num"); //b_id 파라미터값 가져오기 
	String f_num=null;
	if (num != null) {
		f_num = num;
	}
	FavoriteService service = FavoriteService.getInstance();
	Favorite favorite = service.detailComentService(f_num);

	//el태크 사용시 꼭 넣으세요.
	request.setAttribute("favorite", favorite);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/favorite/update.css" />
<title>Insert title here</title>
<script type="text/javascript">
/*
' ------------------------------------------------------------------
' Function : fc_chk_byte(aro_name)
' Description : 입력한 글자수를 체크
' Argument : Object Name(글자수를 제한할 컨트롤)
' Return : 
' ------------------------------------------------------------------
*/
	function fc_chk_byte(aro_name,ari_max){
		var ls_str = aro_name.value; // 이벤트가 일어난 컨트롤의 value 값
		var li_str_len = ls_str.length; // 전체길이

		// 변수초기화
		var li_max = ari_max; // 제한할 글자수 크기
		var i = 0; // for문에 사용
		var li_byte = 0; // 한글일경우는 2 그밗에는 1을 더함
		var li_len = 0; // substring하기 위해서 사용
		var ls_one_char = ""; // 한글자씩 검사한다
		var ls_str2 = ""; // 글자수를 초과하면 제한할수 글자전까지만 보여준다.

		for(i=0; i< li_str_len; i++){
			// 한글자추출
			ls_one_char = ls_str.charAt(i);
			// 한글이면 2를 더한다.
			if (escape(ls_one_char).length > 4){
				li_byte += 2;
			}else{// 그 밖의 경우는 1을 더한다.
				li_byte++;
			}

			// 전체 크기가 li_max를 넘지않으면
			if(li_byte <= li_max){
				li_len = i + 1;
			}
		}

		// 전체길이를 초과하면
		if(li_byte > li_max){
			alert( li_max + " 글자를 초과 입력할수 없습니다. \n 초과된 내용은 자동으로 삭제 됩니다. ");
			ls_str2 = ls_str.substr(0, li_len);
			aro_name.value = ls_str2;
		}
		aro_name.focus(); 
	}

/*
' ------------------------------------------------------------------
' Function : fc_chk2()
' Description : Enter키를 못치게한다.
' Argument : 
' Return : 
' ------------------------------------------------------------------
*/
	function fc_chk2(){
		if(event.keyCode == 13)
		event.returnValue=false;
	}


</script>
</head>
<body>
	<h1><img src="../resources/images/favoriteImg/032-star.png" alt= "쇼핑몰 즐겨찾기페이지" >&nbsp;즐겨찾기</h1>
	<br>
	<br>
	
	<form action="updateAction.jsp?f_num=${favorite.f_num}" method="post">
	<h3><img src="../resources/images/favoriteImg/coment.png" alt= "쇼핑몰 코멘트 달기" >&nbsp;Comment</h3>
	<table class="updateTable">
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
			<td colspan="2"><textarea id="f_coment" name="f_coment" onkeyup="fc_chk_byte(this,500);" onkeypress="fc_chk2()">${favorite.f_coment }</textarea></td>			
		</tr>
		<tr class="favoriteBt">			
			<td colspan="2">
				<input type="submit" value="수정완료">
			</td>			
		</tr>
	</table>
	</form>

</body>
</html>