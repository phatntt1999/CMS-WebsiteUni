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
</head>
<header>
	<div class="container">
		<div class="row">
			<div class="col">
				<a href="ShowArticleServlet"> <img
					src="static/images/Logo-Greenwich.png" alt="Greenwich Logo"
					width="30%" style="padding-top: 15px;">
				</a>
			</div>
			<div class="col" style="text-align: right; margin-top: 20px;">

				<a
					href="ShowAccountInforServlet?AccId=<%=(String)session.getAttribute("userName")%>">
					<span style="margin-left: 10px"><%=(String)session.getAttribute("accountInfor")%></span>
				</a>
				<img src="./Linkfile/<%=(String)session.getAttribute("avatar")%>"
					width=70px alt="" id="role-avatar">
				 <input
					id="logout"
					style="border: 1px solid; border-radius: 5px; padding: 5px 15px 5px 15px; margin-left: 10px; background: white; color: black;"
					type="button" onclick="location.href='LogoutServlet'"
					value="Logout" />

			</div>
		</div>

		<div class="row" style="text-align: right; margin-bottom: 70px;">
			<div class="col" style="margin-top: 20px;">
				<a href="ShowArticleServlet" class="menu">HOME</a> <a
					href="ShowManagePublishArServlet" class="menu">MANAGE PULISH
					ARTICLE</a> <a href="#" class="menu">MORE</a>
			</div>
		</div>
	</div>
</header>
<script src="static/js/welcome.js"></script>
</html>