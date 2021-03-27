<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=UTF-8">
		<title>Welcome Manager</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
       	%>
	
		<div style="background-color: yellow; width: 100px"><a href="ShowArticleServlet">List articles</a></div>
		<div><%=(String)session.getAttribute("accountInfor")%></div>
		<div style="text-color: blue; width: 100px"><a href="LogoutServlet">Logout</a></div>
	</body>
</html>