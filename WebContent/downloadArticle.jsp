<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dowload</title>
</head>
<body style="position: relative;">

	<%
		ArrayList<Article> detailArticle = (ArrayList<Article>) request.getAttribute("detailArticle");
	%>
	<%
			for (Article DeAr : detailArticle) {
	%>
	<object
		data="${pageContext.request.contextPath}/Linkfile/<%=DeAr.getFileUpload() %>"
		type="application/pdf"
		style="width: 80%; height: 830px; position: absolute; left: 12%;">
		<a
			href="${pageContext.request.contextPath}./Linkfile/<%=DeAr.getFileUpload() %>">Download
			file.pdf</a>
	</object>
	<%
			}
	%>
</body>
</html>