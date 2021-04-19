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


<link rel="stylesheet" href="./static/css/heart.css">
<link rel="stylesheet" href="bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
	integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="static/css/homepage.css">
<script src="bootstrap.min.js"></script>
<script src="static/js/welcome.js"></script>

<title>Manager Home page</title>
</head>
<header>
	<jsp:include page="static/fragments/headerInLoginSession.jsp"></jsp:include>
</header>


<body>
	<%
		ArrayList<Article> listArticle = (ArrayList<Article>) request.getAttribute("listArticleUser");
	%>
	<%
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
	%>
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
					<img src="./Linkfile/<%=listArticle.get(0).getArImage()%>"
						class="d-block w-100" alt="..."> <a
						href="ShowDetailArticleServlet?arId=<%=listArticle.get(0).getid_Articles()%>"
						class="post"><span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">
							<%=listArticle.get(0).getArticleName()%>
					</span></a> <br> <span><%=listArticle.get(0).getDate_upload()%> </span><br>
					<span><%=listArticle.get(0).getId_Author()%> </span><br>
				</div>
				<div class="carousel-item">
					<img src="./Linkfile/<%=listArticle.get(1).getArImage()%>"
						class="d-block w-100" alt="..."> <a
						href="ShowDetailArticleServlet?arId=<%=listArticle.get(1).getid_Articles()%>"
						class="post"><span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">
							<%=listArticle.get(1).getArticleName()%>
					</span></a> <br> <span><%=listArticle.get(1).getDate_upload()%> </span><br>
					<span><%=listArticle.get(1).getId_Author()%> </span><br>
				</div>
				<div class="carousel-item">
					<img src="./Linkfile/<%=listArticle.get(2).getArImage()%>"
						class="d-block w-100" alt="..."> <a
						href="ShowDetailArticleServlet?arId=<%=listArticle.get(2).getid_Articles()%>"
						class="post"><span
						style="font-size: larger; font-weight: bold; padding-top: 20px;">
							<%=listArticle.get(2).getArticleName()%>
					</span></a> <br> <span><%=listArticle.get(2).getDate_upload()%> </span><br>
					<span><%=listArticle.get(2).getId_Author()%> </span><br>
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
			<div class="container" style="display: flex; flex-flow: row wrap;">
				<%
					for (Article Ar : listArticle) {
				%>

				<div class="box">
					<a
						href="ShowDetailArticleServlet?arId=<%=Ar.getid_Articles()%>&&auId=<%=(String) session.getAttribute("userName")%>"
						class="post"> <img src="./Linkfile/<%=Ar.getArImage()%>"
						alt="" class="post-image">
					</a><br> <a
						href="ShowDetailArticleServlet?arId=<%=Ar.getid_Articles()%>&&auId=<%=(String) session.getAttribute("userName")%>"
						class="post"> <span
						style="font-size: larger; font-weight: bold;"><%=Ar.getArticleName()%></span></a><br>
					<span>Date Upload: <%=Ar.getDate_upload()%></span><br> <img
						src="./Linkfile/<%=Ar.getAvatarUser()%>" alt=""
						class="avatar-image"> <span class="author-text">Author:
						<%=Ar.getId_Author()%></span><br> </a>

					<div class="content" id="<%=Ar.getid_Articles()%>">
						<span class="heart <%=Ar.getid_Articles()%>"></span> <span
							class="text <%=Ar.getid_Articles()%>">Like</span> <span
							class="numb <%=Ar.getid_Articles()%>"> <span
							class="val <%=Ar.getid_Articles()%>"></span>
						</span>

					</div>
					<script>
      $(document).ready(function(){
        $('#<%=Ar.getid_Articles()%>').click(function(){
          $('.content .<%=Ar.getid_Articles()%>').toggleClass("heart-active")
          $('.text .<%=Ar.getid_Articles()%>').toggleClass("heart-active")
          $('.numb .<%=Ar.getid_Articles()%>').toggleClass("heart-active")
          $('.heart .<%=Ar.getid_Articles()%>
						')
																		.toggleClass(
																				"heart-active")
															});
										});
					</script>

				</div>


				<%
					}
				%>
			</div>
			<%-- Close for loop --%>
			<%-- //End Logic handling show product list --%>
		</div>

	</div>
	<%
		}
	%>
</body>

<jsp:include page="static/fragments/footerLogin.jsp"></jsp:include>
</html>