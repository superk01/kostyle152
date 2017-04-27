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
<<<<<<< HEAD
		<div id="TotalCategoryResult_Box">
			<c:forEach var="product" items="${product_list}">
				<div class="CategoryResult_oneItemBox">
					<div class="CategoryResult_oneItemBox_child"><img src="http://${product.product_ImageLink}" class="CategoryResultImgSize"></div>
					<div class="CategoryResult_oneItemBox_child"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_name}</a></div>
					<div class="CategoryResult_oneItemBox_child"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_price}</a></div>
				</div>
			</c:forEach>
		</div>
=======
	
		<div id="TotalCategoryResult_Box">
			<c:forEach var="product" items="${product_list}">
				<div class="CategoryResult_oneItemBox">
					<div class="CategoryResult_oneItemBox_child_Img"><a href="http://${product.product_link}" class="countShoppingmall"><img src="http://${product.product_ImageLink}" class="CategoryResultImgSize"></a></div>
					<div class="CategoryResult_oneItemBox_child_Name"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_name}</a></div>
					<div class="CategoryResult_oneItemBox_child_price"><a href="http://${product.product_link}" class="countShoppingmall">${product.product_price}</a></div>
				</div>
			</c:forEach>
		</div>
	
>>>>>>> 62eeeb7de3131d04c7ac2df03cae7c54e3e4f9f9
	</div>
</body>
</html>