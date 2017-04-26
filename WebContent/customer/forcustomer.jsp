<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>고객센터 페이지</title>
</head>
<body>
<h3>고객센터</h3>
<button>자무 묻는 질문</button>
<button>문의 게시판</button>
	<table border="1px solid">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<!-- <th>답변 여부</th> -->
				<th>대상 쇼핑몰</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<c:forEach var="board" items="${list }">
		<tbody>
			<tr>
				<td>${board.q_Num }</td>
				<!-- <td>답변 여부</td> -->
				<td>${board.s_Name }</td>
				<td><a href = "detail.a?q_num=${board.q_Num }">${board.q_Title }</a></td>
				<td>${board.c_Id }</td>
				<td>${board.q_Date }</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	<form action="listAction.a" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 
						<select id="searchCat" name = "area">
							<option value="q_title">제목</option>
							<option value="q_name">작성자</option>
						</select>
					
		 <!-- <input type="checkbox" name="area" value="q_title">제목</input>
		 <input type="checkbox" name="area" value="q_name">작성자</input> -->
		 <input type="text" name="searchKey" size="10"></input>
		 <input type="submit" value="검색">
	</form>
	
	<button type="button"><a href="write.jsp">글쓰기</a> </button>
	<button type="button"><a href="forcustomer.jsp">내글보기</a> </button>
	
</body>
</html>