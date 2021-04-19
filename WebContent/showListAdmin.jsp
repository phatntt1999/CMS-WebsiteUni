<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.Article"%>
<%@ page import="model.bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">

<link rel="stylesheet" href="homepage.css">

</head>

<header>
	<div class="container">
		<div class="row">
			<div class="col">
				<img src="static/images/Logo-Greenwich.png" alt="Greenwich Logo"
					width="20%" style="padding-top: 15px;">
			</div>
			<div class="col" style="text-align: right; margin-top: 20px;">

				<span style="margin-left: 10px">Hello, Admin</span> <img
					src="static/images/avatar.jpg" alt="" id="role-avatar"> <input
					id="logout"
					style="border: 1px solid; border-radius: 5px; padding: 5px 15px 5px 15px; margin-left: 10px; background: white; color: black;"
					type="button" onclick="location.href='LogoutServlet'"
					value="Logout" />

			</div>
		</div>

		<!-- <div class="row" style="text-align: right; margin-bottom: 70px;">
			<div class="col" style="margin-top: 20px;">
				<a href="#" class="menu">HOME</a> <a href="#" class="menu">BUSINESS</a>
				<a href="#" class="menu">DESIGN</a> <a href="#" class="menu">INFORMATION
					TECHNOLOGY</a> <a href="#" class="menu">MORE</a>
			</div>
		</div> -->
	</div>
</header>

<body>
	<%-- <%
		String Message = request.getParameter("message");
	%>
	<%=("1".equals(Message)) ? "Post comment succesful" : "Unknown error"%> --%>
	<%
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
	%>
	<%
		ArrayList<Article> listArticle = (ArrayList<Article>) request.getAttribute("listArticle");
	%>
	<h1>Admin Page</h1>
	<%
		int stt = 1;
	%>
	<table border="1" style="margin-bottom: 60px;">
		<tr>
			<th>STT</th>
			<th>Id Article</th>
			<th>Article Name</th>
			<th>Author</th>
			<th>Faculty</th>
			<th>Date Upload</th>
			<th>Article Image</th>
			<th>Modify</th>
		</tr>
		<%
			for (Article Ar : listArticle) {
		%>
		<tr>
			<td><%=stt%></td>
			<td><%=Ar.getid_Articles()%></td>
			<td><%=Ar.getArticleName()%></td>
			<td><%=Ar.getId_Author()%></td>
			<td><%=Ar.getId_Faculty()%></td>
			<td><%=Ar.getDate_upload()%></td>
			<td><%=Ar.getArImage()%></td>
			<td><input type="button"
				Onclick="deleteProduct('<%=Ar.getid_Articles()%>')" value="Delete" />
			</td>
			<%
				stt += 1;
			%>
		</tr>
		<%
			}
		%>
		<%-- Close for loop --%>

		<%
			}
		%>
		<script>
			function deleteProduct(ArId) {
				if (confirm('Are you sure to delete?')) {
					location.href = "DeleteArticleServlet?ArId=" + ArId;
				}
			}
		</script>
<%-- 		<footer>
			<jsp:include page="static/fragments/footerLogin.jsp"></jsp:include>
		</footer> --%>
</body>

</html>