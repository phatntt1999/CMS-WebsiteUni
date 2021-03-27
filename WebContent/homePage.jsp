<%@page import="model.bean.Article"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- <link rel="stylesheet" href="static/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="static/css/homepage.css">
<!-- <script src="static/js/bootstrap.min.js"></script> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
	integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
	integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>Home page</title>
</head>

<%@ include file="static/fragments/header.html"%>

<body>
	<div class="container" style="padding-bottom: 30px;">
		<div class="row"
			style="background-color: rgb(191, 225, 248); padding: 70px;">
			<div class="col">
				<span style="font-weight: bold; font-size: x-large;">Welcome
					to CMS Greenwich University</span><br> <br> <span>Lorem
					ipsum dolor sit amet, consectetur adipiscing elit.</span><br> <br>
				<button id="learn-more">Learn more</button>
				<br>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="featured-post" style="padding-top: 20px;">
			<span style="font-weight: bold; font-size: x-large;">Featured
				Posts</span>
			<hr>
		</div>
	</div>
	<div class="container"
		style="width: 70%; height: 40%; padding-bottom: 30px;">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner" style="text-align: center;">
				<div class="carousel-item active">
					<img src="static/images/post.jpg" class="d-block w-100" alt="...">
					<span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">Lorem
						Ipsum</span><br> <span>Lorem ipsum dolor sit amet,
						consectetur adipiscing elit.</span><br>
				</div>
				<div class="carousel-item">
					<img src="static/images/post.jpg" class="d-block w-100" alt="...">
					<span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">Lorem
						Ipsum</span><br> <span>Lorem ipsum dolor sit amet,
						consectetur adipiscing elit.</span><br>
				</div>
				<div class="carousel-item">
					<img src="static/images/post.jpg" class="d-block w-100" alt="...">
					<span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">Lorem
						Ipsum</span><br> <span>Lorem ipsum dolor sit amet,
						consectetur adipiscing elit.</span><br>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	<div class="container">
		<div id="latest-post" style="padding-top: 20px;">
			<span style="font-weight: bold; font-size: x-large;">Latest
				posts on CMS</span>
			<hr>
			<input type="button" onclick="location.href='ShowAddingServlet'"
				value="Add" />
			<% ArrayList<Article> listArticle = (ArrayList<Article>)request.getAttribute("listArticle"); %>
			<%-- Logic handling show product list --%>
			<%int count = 0; %>
			<%-- <% for (Article Ar : listArticle) { %> --%>
			<% for (int j = 1; j < 4; j++) { %>
			<div class="row" style="padding-bottom: 30px;">
				<% for (int i = 1; i < 4; i++) { %>
				<div class="col">
					<a href="#" class="post"> <img src="static/images/post.jpg"
						alt="" class="post-image">
					</a><br> <a href="#" class="post"> <span
						style="font-size: larger; font-weight: bold;"><%=listArticle.get(count).getArticleName()%></span>
					</a> <br> <span>Date upload: <%=listArticle.get(count).getDate_upload()%></span>
					<br> <img src="static/images/avatar.jpg" alt=""
						class="avatar-image"> <span class="author-text">Author:
						<%=listArticle.get(count).getId_Author()%></span><br>
					<br> <input type="button"
						Onclick="location.href='ShowEditProductServlet?arId=<%=listArticle.get(count).getid_Articles()%>'"
						value="Chỉnh sửa" /> <a
						href="DeleteArticleServlet?arId=<%=listArticle.get(count).getid_Articles()%>"
						Onclick="return confirm('Do you want to delete?')">Delete</a> <br>
					<br>
				</div>
				<% count++; %>
				<%
					}
				%>
				<%
					}
				%>


				<%-- Close for loop --%>
				<%-- //End Logic handling show product list --%>
			</div>

		</div>
	</div>
</body>

<%@ include file="static/fragments/footer.html"%>
</html>