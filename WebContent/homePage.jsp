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

<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/homepage.css">
<script src="static/js/bootstrap.min.js"></script>

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

			<% for (int i = 1; i < 5; i++) { %>
			<div class="row" style="padding-bottom: 30px;">
			<% for (Article Ar : listArticle) { %>
				<% for (int count = 1; count < 4; count++) { %>
				<div class="col">
					<a href="#" class="post"> <img src="static/images/post.jpg"
						alt="" class="post-image">
					</a><br> <a href="#" class="post"> <span
						style="font-size: larger; font-weight: bold;"><%=Ar.getArticleName()%></span>
					</a> <br> <span>Date upload: <%=Ar.getDate_upload()%></span> <br>
					<img src="static/images/avatar.jpg" alt="" class="avatar-image">
					<span class="author-text">Author: <%=Ar.getId_Author()%></span><br><br>
					<input type="button"
						Onclick="location.href='ShowEditProductServlet?arId=<%=Ar.getid_Articles()%>'"
						value="Chỉnh sửa" /> <a
						href="DeleteArticleServlet?arId=<%=Ar.getid_Articles()%>"
						Onclick="return confirm('Do you want to delete?')">Delete</a>
					<br>
					<br>

				</div>
				<%
					}
				%>
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