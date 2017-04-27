<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/CategoryResult/CategoryResult.css" />
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="TotalCategoryResult_Box">
			<c:forEach var="product" items="${product_list}">
				<div class="CategoryResult_oneItemBox">
					<div class="CategoryResult_oneItemBox_child"><img src="http://${product.product_ImageLink}" class="CategoryResultImgSize"></div>
					<div class="CategoryResult_oneItemBox_child"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_name}</a></div>
					<div class="CategoryResult_oneItemBox_child"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_price}</a></div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>