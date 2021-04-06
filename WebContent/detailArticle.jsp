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
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
	integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="static/css/homepage.css">
<script src="bootstrap.min.js"></script>
<script src="static/js/welcome.js"></script>
<link rel="stylesheet" href="static/css/DetailArticle.css">
</head>

<header>
	<jsp:include page="static/fragments/headerInLoginSession.jsp"></jsp:include>
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
		ArrayList<Comment> comment = (ArrayList<Comment>) request.getAttribute("listComment");
	%>
	<%
		ArrayList<Article> detailArticle = (ArrayList<Article>) request.getAttribute("detailArticle");
	%>

	<%
		for (Article DeAr : detailArticle) {
	%>
	<div class="container">
		<div class="row">
			<!-- image of post here -->
			<div class="col" style="text-align: center;">
				<img src="./Linkfile/<%=DeAr.getArImage()%>" width="80%" alt="">
			</div>
		</div>
	</div>
	<!--Show PDF -->
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8">

			<h1 style="margin-top: 20px; font-weight: bold;"><%=DeAr.getArticleName()%></h1>
			<img src="./Linkfile/<%=DeAr.getAvatarUser()%>" alt=""
				class="avatar-image"> <span class="author-text"><%=DeAr.getId_Author()%></span>
			<span> - </span> <span class="author-text"><%=DeAr.getDate_upload()%></span>
			<object
				data="${pageContext.request.contextPath}/Linkfile/<%=DeAr.getFileUpload()%>"
				type="application/pdf" style="width: 100%; height: 700px">

			</object>

			<!--bài viết của người dùng để vào đây hen -->
		</div>
		<div class="col-2"></div>
	</div>
	<!--End Show PDF -->

	<!--Comment -->
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<hr>
			<img src="./Linkfile/<%=(String) session.getAttribute("avatar")%>"
				alt="" class="avatar-image"> <span class="author-text"
				style=""><%=(String) session.getAttribute("userName")%></span>

			<!--bài viết của người dùng để vào đây hen -->
			<h5>
				Comment in here
				</h2>
		</div>
		<div class="col-3"></div>
	</div>
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<hr>
			<%
				if (DeAr.getStatusComment() == true) {
			%>
			<form action="AddCommentServlet" method="post">
				<div class="row mb-3"></div>
				<div class="row mb-3">
					<label for="comments" class="col-sm-2 col-form-label">Comment</label>
					<div class="col-sm-10">
						<textarea name="comment" class="form-control"
							id="exampleFormControlTextarea1" rows="2"></textarea>
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-sm-10 offset-sm-2">
						<div class="form-check">
							<input type="hidden" name="id_Author"
								value="<%=(String) session.getAttribute("userName")%>"></input>
							<input type="hidden" name="arId"
								value="<%=(String) session.getAttribute("arId")%>"></input>
							<!-- <input
								class="col-sm-2 col-form-label" type="text" name="comment"
								placeholder="Your comment"> -->
						</div>
					</div>
				</div>
				<center>
					<button type="submit" class="btn btn-primary"
						style="padding: 5px 25px 5px 25px;">Add Comment</button>
				</center>
				<hr>
			</form>
			<%
				} else {
			%>
			<h2><%=session.getAttribute("checkday")%></h2>
			<h2><%=DeAr.getStatusComment()%></h2>
			<h5>ko comment duoc nua ban oi</h5>
			<%
				}
			%>
			<%
				}
			%>
			<!-- đóng for -->
		</div>
		<div class="col-3"></div>
	</div>

	<div class="comments-container">

		<ul id="comments-list" class="comments-list">
			<%
				if (comment.isEmpty()) {
			%>
			<li><span>This article has no comment</span></li>
			<%
				} else {
			%>
			<%
				for (Comment cm : comment) {
			%>
			<li>
				<div class="comment-main-level">
					<!-- Avatar -->
					<div class="comment-avatar">
						<img src="./Linkfile/<%=cm.getAvatarCommenter()%>" alt="">
					</div>
					<!-- Contenedor del Comentario -->
					<div class="comment-box">
						<div class="comment-head">
							<h5 class="comment-name">
								<a><%=cm.getid_Author()%></a>
							</h5>
							<span><%=cm.getDateComment()%></span> <i class="fa fa-reply"></i>
							<i class="fa fa-heart"></i>
						</div>
						<div class="comment-content">
							<%=cm.getContentComment()%>
						</div>
					</div>
				</div>
			</li>
			<%
				}
			%>
			<!-- đóng for -->

			<%
				}
			%>
			<!-- đóng else -->


		</ul>
		<br>
		<hr>
	</div>
	<%
		}
	%>
</body>
<footer>
	<jsp:include page="static/fragments/footerLogin.jsp"></jsp:include>
</footer>
</html>