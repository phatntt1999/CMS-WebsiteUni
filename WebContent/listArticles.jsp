<%@page import="model.bean.Article"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=UTF-8">
<title>List Articles</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<%-- Check login status --%>
	   <%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
           else {
       %>
       <%-- //End check login status --%>


	<div class="container-fluid">
		<div class="row">
			<div class="col align-self-start"></div>
			<div class="col align-self-center ">
				<div class="position-absolute top-50 start-50 translate-middle">
					<div class="">
						<img src="static/images/LogoGreenwich.png" height="200px" />
					</div>
					<div class="text-center">
						<h1>List articles</h1>
					</div>
					<%-- Logic handling show product list --%>
					<% ArrayList<Article> listArticle = (ArrayList<Article>)request.getAttribute("listArticle"); %>
					
					<input type="button"
						onclick="location.href='ShowAddingServlet'" value="Add" />

					<%-- <% String searchText=request.getParameter("searchText") !=null ?
                                                    request.getParameter("searchText") : "" ; %>
					<form action="SearchProductServlet" method="post">
						<input type="text" name="searchText" value="<%=searchText%>" /> <input
							type="submit" name="Search" />
					</form> --%>

					<% int stt=1; %>
					<table border="1">
						<tr>
							<th>STT</th>
							<th>ID Article</th>
							<th>ArticleName</th>
							<th>Date upload</th>
							<th>Author</th>
							<th>Coordinator</th>
						</tr>
						<% for (Article Ar : listArticle) { %>
						<tr>
							<td><%= stt %></td>
							<td><%= Ar.getid_Articles() %></td>
							<td><%= Ar.getArticleName() %></td>
							<td><%= Ar.getDate_upload() %></td>
							<td><%= Ar.getId_Author() %></td>
							<td><%= Ar.getId_Coordinator() %></td>
							<td><input type="button"
								Onclick="location.href='ShowEditProductServlet?arId=<%=Ar.getid_Articles()%>'"
								value="Chỉnh sửa" /> <input type="button"
								Onclick="deleteProduct('<%=Ar.getid_Articles()%>')" value="Xóa" /> <a
								href="DeleteProductServlet?proId=<%= Ar.getid_Articles()%>"
								Onclick="return confirm('Do you want to delete?')">Delete</a></td>
							<% stt +=1; %>
						</tr>
						<% } %>
						<%-- Close for loop --%>
						<% } %>
						<%-- Close else condition --%>
					</table>
					<%-- //End Logic handling show product list --%>
				</div>
			</div>
			<div class="col align-self-end"></div>
		</div>
	</div>
</body>
</html>