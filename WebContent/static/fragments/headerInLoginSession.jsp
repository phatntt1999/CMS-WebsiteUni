<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="homepage.css">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
        integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
        integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
        crossorigin="anonymous"></script>
    <title>Homepage</title>
</head>

<header>
	<div class="container">
		<div class="row">
			<div class="col">
				<img src="static/images/Logo-Greenwich.png" alt="Greenwich Logo"
					width="20%" style="padding-top: 15px;">
			</div>
			<div class="col" style="text-align: right; margin-top: 20px;">
				<input id="search-input" type="text" placeholder="Search...">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path
						d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                    </svg>
				<span style="margin-left: 10px"><%=(String) session.getAttribute("accountInfor")%></span>
				<img src="static/images/avatar.jpg" width=70px  alt="" id="role-avatar"> <a
					href="LogoutServlet">Logout</a>
				<button id="add-post">New Contribution</button>
			</div>
		</div>
		<div class="row" id="add-new-contribution" style="margin-top: 30px">
            <div class="col" style="text-align: right;">
                <hr><span style="font-size: larger; font-weight: bold;">Add New Contribution</span><br>
                <div style="margin-top: 20px;">
                    <span style="font-weight: bold;">Title:</span>
                    <input type="text" class="title-input"><br>
                </div>
                <div style="margin: 20px 0px 20px 0px;">
                    <span style="font-weight: bold;">Description:</span>
                    <input type="text" class="title-input"><br>
                </div>
                <button id="choose-file">Choose file</button>
                <span style="margin-left: 15px;">File Name</span><br>
                <button id="submit">Submit</button><button id="close">Close</button>
            </div>
            <hr>
        </div>
		<div class="row" style="text-align: right; margin-bottom: 70px;">
			<div class="col" style="margin-top: 20px;">
				<a href="#" class="menu">HOME</a> <a href="#" class="menu">BUSINESS</a>
				<a href="#" class="menu">DESIGN</a> <a href="#" class="menu">INFORMATION
					TECHNOLOGY</a> <a href="#" class="menu">MORE</a>
			</div>
		</div>
	</div>
</header>
</html>



