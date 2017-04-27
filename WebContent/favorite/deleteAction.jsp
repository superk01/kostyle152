<%@page import="favorite.model.FavoriteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="favorite" class="favorite.model.Favorite"></jsp:useBean>
<jsp:setProperty property="*" name="favorite"/>

<%
	String num = request.getParameter("f_num"); //b_id 파라미터값 가져오기 
	System.out.println("1:"+num);
	String f_num=null;
	if (num != null) {
		f_num = num;
	}
	System.out.println("2:"+num);
	FavoriteService service = FavoriteService.getInstance();
	System.out.println("3:"+num);
	int re = service.deleteFavoriteService(favorite);
	System.out.println("4:"+num);
	System.out.println(re);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%
	if(re>0){%>
		 if(confirm("정말 삭제하시겠습니까?")){
				location.href="favorite.jsp";
	 	 }else{
	 		history.go(-2);
		 }
		location.reload();
	<%
	}else{
		response. sendRedirect("favorite.jsp");
	}
	%>
</script>
	
	
	
	
</head>
<body>

</body>
</html>