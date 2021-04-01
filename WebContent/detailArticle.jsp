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
		ArrayList<Comment> comment = (ArrayList<Comment>) request.getAttribute("listComment");
	%>
	<%
		ArrayList<Article> detailArticle = (ArrayList<Article>) request.getAttribute("detailArticle");
	%>
	<%
		for (Article DeAr : detailArticle) {
	%>
	<h1><%=DeAr.getArticleName() %></h1>
	<object
		data="${pageContext.request.contextPath}/Linkfile/<%=DeAr.getFileUpload()%>"
		type="application/pdf" style="width: 80%; height: 700px">
		<a
			href="${pageContext.request.contextPath}/Linkfile/<%=DeAr.getFileUpload() %>">Download
			file.pdf</a>
	</object>
	

	<h1>Comment in here</h1>
	<div>--------------------------------------</div>
	<div class="comments-container">
		<%
			if (DeAr.getStatusComment() == true) {
		%>
		<form action="AddCommentServlet" method="post">
			<input type="hidden" name="id_Author"
				value="<%=(String) session.getAttribute("userName")%>"></input> <input
				type="hidden" name="arId"
				value="<%=(String) session.getAttribute("arId")%>"></input> <input
				type="text" name="comment" placeholder="Your comment"> <input
				type="submit" value="Add Comment" />
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
						<img
							src="http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg"
							alt="">
					</div>
					<!-- Contenedor del Comentario -->
					<div class="comment-box">
						<div class="comment-head">
							<h6 class="comment-name">
								<a><%=cm.getid_Author()%></a>
							</h6>
							<i class="fa fa-reply"></i> <i class="fa fa-heart"></i>
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
		<center>
			<div>----------------------------COMMENT----------------------------</div>
		</center>
	</div>

</body>
<footer>
	<jsp:include page="static/fragments/footerLogin.jsp"></jsp:include>
</footer>
</html>