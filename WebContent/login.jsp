<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=UTF-8">
		<title>Login</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<%-- <body>
		
		<% String error = request.getParameter("error"); %>
       	<%=("1".equals(error)) ? "Please login!" : "" %>
       	<%=("2".equals(error)) ? "Not correct account or password! " : "" %>
	
		<!-- <h1>Đăng Nhập</h1>
	    <form action="login" method="post">
	        Tên đăng nhập: <input type="text" name="userName">
	        Mật khẩu: <input type="password" name="passWord">
	        <input type="submit" value="Đăng nhập">
	        <input type="button" value="Quay về Trang chủ">
	    </form> -->
	
	</body> --%>
	
	<body>
		<% String error = request.getParameter("error"); %>
       	<%=("1".equals(error)) ? "Please login!" : "" %>
       	<%=("2".equals(error)) ? "Not correct account or password! " : "" %>
       	
       	
		<div class="container-fluid">
			<div class="row">
				<div class="col align-self-start"></div>
				<div class="col align-self-center ">
					<div class="position-absolute top-50 start-50 translate-middle">
						<div class=""><img src="static/images/LogoGreenwich.png" height="200px"/></div>
						<div class="text-center">
							<h1> Please sign in</h1>
						</div>
						<form action="login" method="post">
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label"></label>
								<label for="exampleInputPassword1" class="form-label">Email address</label>
								<input class="form-control" id="exampleFormControlInput1" type="text" name="userName"
									placeholder="Email address">
							</div>
							<div class="mb-3">
								<label for="exampleFormControlInput1" class="form-label"></label>
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input class="form-control" id="exampleFormControlInput1" type="password" name="passWord"
									placeholder="Password">
							</div>
							<div class="text-center ">
								<input class="btn btn-primary " type="submit" value="Sign in" />
							</div>
						</form>
					</div>
				</div>
				<div class="col align-self-end"></div>
			</div>
		</div>
	</body>
</html>