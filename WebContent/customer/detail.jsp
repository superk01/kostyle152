<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �󼼺���</title>
<script src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
/* $(function(){
	$('.update').on('click',function(){
		location.href = "updateForm.a?q_num=${board.q_Num}";
	});
	
	
} */
function fn_update(){
	location.href = "updateForm.a?q_num=${board.q_Num}";
}
function fn_delete(){
	location.href = "deleteAction.a?q_num=${board.q_Num}";
}

</script>
</head>
<body>
	<h2>�� �󼼺���</h2>
			<table border="1">
		<tr height="30">
			<td width="150">�۹�ȣ</td>
			<td width="150">${board.q_Num }</td>
	
		</tr>
		<tr height="30">
			<td width="150">�ۼ���</td>
			<td width="150">${board.c_Id }</td>
			<td width="150">�ۼ���</td>
			<td width="150">
				<fmt:formatDate value="${board.q_Date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>			
		<%-- <tr height="30">
			<td width="150">����</td>
			<td colspan="3">
				<a href="download.jsp?filename=${board.b_fname }">${board.b_fname }</a>
			</td>			
		</tr> --%>
		<tr height="30">
			<td width="150">����</td>
			<td colspan="3">${board.q_Title }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">${board.q_Content }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">
				<input type="button" value="�亯��" >
				<input type="button" value="����" onclick="fn_update()">
				<input type="button" value="����" onclick="fn_delete()">
			</td>			
		</tr>
		
		<c:forEach var="reply" items="${list }">
		<tr height="30">
			<td align="center">${reply.r_name }</td>
			<td align="center">${reply.r_content }</td>
		</tr>		
		</c:forEach>
		
		<tr height="30">
			<td colspan="3">
			<form action="detailAction.a" method="post">
				<textarea rows="3" cols="70" name="as_content"></textarea>
				<input type="hidden" name = "q_num" value="${board.q_Num }">
				<input type="text" name = "as_writer">
				<input type="submit" value="��۴ޱ�" >
				</form>
				</td>
				
				
	</table>

</table>
</body>
</html>