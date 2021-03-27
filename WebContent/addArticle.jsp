<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=UTF-8">
		<title>Add Article</title>
	</head>
	<body>
		Adding...
		<br>
		<%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
           else { 
       	%>
       	
       <%-- <% String error = request.getParameter("message"); %>
       <%=("1".equals(error)) ? "Lỗi trùng mã hàng hóa, bạn vui lòng thao tác lại!" : "" %>
       <%=("2".equals(error)) ? "Đã có lỗi không xác định được nguyên nhân, bạn thử vui lòng thao tác lại, hoặc liên hệ với người quản trị hệ thống!" : "" %>
       <%=("3".equals(error)) ? "Lỗi chưa nhập đầy đủ tên hàng hóa, đơn vị tính, đơn giá tham khảo!" : "" %>
       <%=("4".equals(error)) ? "Đơn giá tham khảo phải là số!" : "" %> --%>
       
       
		<%-- <% String tenHH = request.getParameter("tenHH") != null ? request.getParameter("tenHH") : ""; %>
		<% String dvt = request.getParameter("dvt") != null ? request.getParameter("dvt") : ""; %>
		<% String donGiaTK = request.getParameter("donGiaTK") != null ? request.getParameter("donGiaTK") : ""; %>
		<% String ghiChu = request.getParameter("ghiChu") != null ? request.getParameter("ghiChu") : ""; %> --%>
		
	    <form action="AddingArticleServlet" method="post">
	        <!-- Mã hàng: <input type="text" name="maHH"> -->
	        Article Name: <input type="text" name="articleName" id="articleName">
	        Upload File: <input type="text" name="fileUpload" id="fileUpload">
	        <input type="submit" value="Submit">
	        <input type="reset" value="Cancel">
	    </form>
	    
	    <script>
	    /* $(document).ready( function() {
	        $('#dateupload').val(new Date().toDateInputValue());
	    }); */​
	    </script>
	    <% } %>
	</body>
</html>