<%@page import="favorite.model.FavoriteService"%>
<%@page import="favorite.model.Favorite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="favorite" class="favorite.model.Favorite"></jsp:useBean>
<jsp:setProperty property="*" name="favorite"/>

<%
	FavoriteService service = FavoriteService.getInstance();
	int re = service.updateComentService(favorite);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%
	if(re>0){%>
		alert("즐겨찾기 코멘트가 저장되었습니다.");
		history.go(-3);
	<%
	}else{
		response. sendRedirect("updateForm.jsp");
	}
	%>
</script>
	
</head>
<body>

</body>
</html>