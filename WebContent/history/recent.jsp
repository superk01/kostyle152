<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div> <!-- 최근본 상품정보 컨터이너 -->
		<table border="1px solid"> <!-- 최근 본 상품정보 테이블 -->
			<caption>최근 본 상품 정보</caption>
			<colgroup>
				<col width = "">
				<col width = "">
				<col width = "">
				<col width = "">
				<col width = "">
			</colgroup>
			<thead>
				<tr>
					<th class = "first" scope="col" abbr="상품선택 체크박스">
						<div class = "th_checkall">
							<label for="chkAll">
								<input id="chkAll" name ="chkAll"type="checkbox">
								<!-- 온클릭 이벤트(체크박스 전부 체크되는 거)있음 -->
							</label>
						</div>
						상품명
					</th>
					<th scope="col">이미지</th>
					<th scope="col">상품이름</th>
					<th scope="col">날짜</th>
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
					<td>이미지</td>
					<td>상품이름</td>
					<td>날짜</td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>