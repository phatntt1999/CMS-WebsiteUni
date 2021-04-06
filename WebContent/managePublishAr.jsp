<%@page import="model.bean.Article"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="homepage.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
	integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
	integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
	crossorigin="anonymous"></script>
<title>Manage</title>
</head>
<header>
	<jsp:include page="static/fragments/headerCoordinator.jsp"></jsp:include>
</header>

<body>
	<%
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
	%>
	<%
		ArrayList<Article> listArticle = (ArrayList<Article>) request.getAttribute("publicArticle");
	%>


	<div class="container">
		<div class="row">
			<div class="col">
				<span
					style="font-weight: bold; font-size: larger; color: rgb(94, 94, 94);">Manage
					publish article</span>
			</div>

		</div>

		<!-- Each row of post -->
		<%
			for (Article Ar : listArticle) {
		%>
		<form action="ManagePublishArticleServlet" method="POST">
			<div class="row"
				style="border: 1px solid gray; margin-top: 20px; text-align: center; background: rgb(156, 245, 156);">
				<div class="col" style="margin-top: 23px;">
					<input type="button"
						Onclick="location.href='DownloadArticleServlet?arId=<%=Ar.getid_Articles()%>'"
						value="Download PDF">

				</div>
				<div class="col" style="margin-top: 23px;">
					<span style="font-weight: bold;">ID Student</span><br> <span><%=Ar.getId_Author()%></span>
				</div>
				<div class="col" style="margin-top: 23px;">
					<span style="font-weight: bold;">Name</span><br> <span><%=Ar.getArticleName()%></span>
					<input type="hidden" value="<%=Ar.getid_Articles()%>" name="ArId">
				</div>
				<div class="col" style="margin-top: 23px;">
					<span style="font-weight: bold;">Course</span><br> <span><%=Ar.getId_Faculty()%></span>
				</div>

				<div class="col" style="margin-top: 23px;">
					<span style="font-weight: bold;">Public</span><br> <input
						type="checkbox" name="Public" value="x">
				</div>
				<div class="col" style="margin-top: 23px;">
					<input type="submit" value="submit" />
				</div>

				<div class="col" style="margin-top: 35px;"></div>
			</div>
		</form>
		<%
			}
		%>
	</div>
	<%
		}
	%>
</body>

<footer>
	<jsp:include page="static/fragments/footerLogin.jsp"></jsp:include>
</footer>
</html>