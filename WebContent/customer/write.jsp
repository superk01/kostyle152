<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>문의글 작성 폼</title>
<link rel="stylesheet" type="text/css" href="write.css">
</head>
<body>

	<form action="insertAction.a" method = "post">
		<table border="1px solid">
			<tr>
				<td id = "category">쇼핑몰 선택</td>
				<td>
					<div style="width: 95px">
						<select id="cboClass_0" name = "cboClass_0">
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select>
					</div> 
				</td>
				<td id = "category">문의 종류 선택</td>
				<td>
					<div style="width: 100px">
						<select id="" name = "">
							<option>선택</option>
							<option>주문/결제</option>
							<option>배송</option>
							<option>취소</option>
							<option>반품</option>
							<option>교환</option>
						</select> 
					</div>
				</td>
			</tr>
			<tr>
				<td id = "category">문의 제목</td>
				<td colspan="3">
					<input type="text" name="title" style="width:305px">
				</td>
				
				
			</tr>
			<tr>
				<td id = "category">문의 내용</td>
				<td colspan="3"><textarea rows="7" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				<input type="submit" value="제  출">
				<input type="reset" value="내용삭제">
				 
				</td>
			</tr>
		</table>	
		<a href = "listAction.a"><button>목록보기</button></a>

	</form>

</body>
</html>