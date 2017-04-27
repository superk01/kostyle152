<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ������</title>
</head>
<body>
<h3>������</h3>
<button>�ڹ� ���� ����</button>
<button>���� �Խ���</button>
	<table border="1px solid">
		<thead>
			<tr>
				<th>�Խñ� ��ȣ</th>
				<!-- <th>�亯 ����</th> -->
				<th>��� ���θ�</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
			</tr>
		</thead>
		<c:forEach var="board" items="${list }">
		<tbody>
			<tr>
				<td>${board.q_Num }</td>
				<!-- <td>�亯 ����</td> -->
				<td>${board.s_Name }</td>
				<td><a href = "detailAction.a?q_num=${board.q_Num }">${board.q_Title }</a></td>
				<td>${board.c_Id }</td>
				<td>${board.q_Date }</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	<form action="listAction.a" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 
						<select id="searchCat" name = "area">
							<option value="q_title">����</option>
							<option value="q_name">�ۼ���</option>
						</select>
					
		 <!-- <input type="checkbox" name="area" value="q_title">����</input>
		 <input type="checkbox" name="area" value="q_name">�ۼ���</input> -->
		 <input type="text" name="searchKey" size="10"></input>
		 <input type="submit" value="�˻�">
	</form>
	
	<button type="button"><a href="write.jsp">�۾���</a> </button>
	<button type="button"><a href="forcustomer.jsp">���ۺ���</a> </button>
	
</body>
</html>