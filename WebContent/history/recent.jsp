<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div> <!-- �ֱٺ� ��ǰ���� �����̳� -->
		<table border="1px solid"> <!-- �ֱ� �� ��ǰ���� ���̺� -->
			<caption>�ֱ� �� ��ǰ ����</caption>
			<colgroup>
				<col width = "">
				<col width = "">
				<col width = "">
				<col width = "">
				<col width = "">
			</colgroup>
			<thead>
				<tr>
					<th class = "first" scope="col" abbr="��ǰ���� üũ�ڽ�">
						<div class = "th_checkall">
							<label for="chkAll">
								<input id="chkAll" name ="chkAll"type="checkbox">
								<!-- ��Ŭ�� �̺�Ʈ(üũ�ڽ� ���� üũ�Ǵ� ��)���� -->
							</label>
						</div>
						��ǰ��
					</th>
					<th scope="col">�̹���</th>
					<th scope="col">��ǰ�̸�</th>
					<th scope="col">��¥</th>
				</tr>
			</thead>
			<tbody>
				<tr class="first">
					<td class="first">
						<div class="orderProdInfo_v2">
							<label class="chk" for="prd_0">
								<input id="pro_0" name="prdList" type="checkbox">
								<input name="history_no" type="hidden">
							</label>
						</div>
					</td>
					<td>�̹���</td>
					<td>��ǰ�̸�</td>
					<td>��¥</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>