<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���Ǳ� �ۼ� ��</title>
<link rel="stylesheet" type="text/css" href="write.css">
</head>
<body>

	<form action="insertAction.a" method = "post">
		<table border="1px solid">
			<tr>
				<td id = "category">���θ� ����</td>
				<td>
					<div style="width: 95px">
						<select id="cboClass_0" name = "cboClass_0">
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select>
					</div> 
				</td>
				<td id = "category">���� ���� ����</td>
				<td>
					<div style="width: 100px">
						<select id="" name = "">
							<option>����</option>
							<option>�ֹ�/����</option>
							<option>���</option>
							<option>���</option>
							<option>��ǰ</option>
							<option>��ȯ</option>
						</select> 
					</div>
				</td>
			</tr>
			<tr>
				<td id = "category">���� ����</td>
				<td colspan="3">
					<input type="text" name="title" style="width:305px">
				</td>
				
				
			</tr>
			<tr>
				<td id = "category">���� ����</td>
				<td colspan="3"><textarea rows="7" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				<input type="submit" value="��  ��">
				<input type="reset" value="�������">
				 
				</td>
			</tr>
		</table>	
		<a href = "listAction.a"><button>��Ϻ���</button></a>

	</form>

</body>
</html>