<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���θ��� ���ǻ��� Ȯ��</title>
</head>
<body>
	<table border="1px solid">
		<thead>
			<tr>
				<th>�Խñ� ��ȣ</th>
				<th>���� ����</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>�亯��</th>
			</tr>
		</thead>
		<!-- �Խ��� ���  foreach�ʿ�-->
		<tbody>
			<tr>
				<td>�Խñ� ��ȣ</td>
				<td>���� ����</td>
				<td>����</td>
				<td>�ۼ���</td>
				<td>�ۼ���</td>
				<td>�亯��</td>
			</tr>
		</tbody>
	</table>
	
	<form action="" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 <input type="checkbox" name="area" value="b_title">����</input>
		 <input type="checkbox" name="area" value="b_name">�ۼ���</input>
		 <input type="text" name="searchKey" size="10"></input>
		 <input type="submit" value="�˻�">
	</form>
</body>
</html>