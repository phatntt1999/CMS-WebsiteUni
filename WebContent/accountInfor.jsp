<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.AccountInfor"%>

<%@ page import="java.util.Random"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/jvectormap/2.0.4/jquery-jvectormap.min.css'>
<link rel="stylesheet" href="./static/css/accountInfor.css">
<script src="https://kit.fontawesome.com/19b91c275f.js"
	crossorigin="anonymous"></script>
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
</head>

<header>
	<%-- <%@ include file="static/fragments/header.html"%> --%>
	<jsp:include page="static/fragments/headerInLoginSession.jsp"></jsp:include>
</header>

<body>
	<%
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
	%>
	<%
		ArrayList<AccountInfor> accInfor = (ArrayList<AccountInfor>) request.getAttribute("AccInfor");
	
	%>
	<%
		int AmountContribution = (int) request.getAttribute("AmountContribution");
		Random generator = new Random();
	%>

	<!--start container-->
	<div class="container">
		<!-- //////////////////////////////////////////////////////////////////////////// -->
		<div id="work-collections">
			<div class="row">
				<div class="col s12 m6 4">
					<div id="profile-card" class="card">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator"
								src="http://demo.geekslabs.com/materialize/v2.1/layout03/images/user-bg.jpg"
								alt="user background">
						</div>
						<div class="card-content">
							<img src="./Linkfile/<%=(String)session.getAttribute("avatar")%>" alt=""
								class="circle responsive-img activator card-profile-image">

							<span class="card-title activator grey-text text-darken-4"
								style="font-weight: 800;"> Name: <%=accInfor.get(0).getNameUser()%>
							</span>
							<p>
								<span style="padding-right: 10px; font-weight: 700;">Faculty:</span>
								<span class="task-cat purple accent-2"><%=accInfor.get(0).getFaculty()%></span>
							</p>
							<p>
								<span style="padding-right: 22px; font-weight: 700;">Email:</span>
								<span><%=accInfor.get(0).getEmail()%></span>
							</p>
							<p>
								<span style="font-weight: 700;">Amount Contribution:</span> <span><i
									class="fas fa-chart-pie"
									style="color: #009688; font-size: 35px;"> <%=AmountContribution%>
								</i></span>

							</p>

						</div>
					</div>
				</div>

				<div class="col s12 m12 l8">
					<ul id="projects-collection" class="collection">
						<li class="collection-item avatar"><i
							class="mdi-file-folder circle light-blue darken-2"></i> <span
							class="collection-header">Job</span>
							<p>2017-2021</p> <a href="#" class="secondary-content"><i
								class="mdi-action-grade"></i></a></li>
						<li class="collection-item">
							<div class="row">
								<div class="col s6">
									<p class="collections-title">Web App</p>
									<p class="collections-content">Greenwich university</p>
								</div>
								<div class="col s3">
									<span class="task-cat cyan">Development</span>
								</div>
								<div class="col s3">
									<div id="project-line-1">
										<canvas width="135" height="30"
											style="display: inline-block; width: 135px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s6">
									<p class="collections-title">Design Web developer</p>
									<p class="collections-content">FPT university</p>
								</div>
								<div class="col s3">
									<span class="task-cat grey darken-3">UI/UX</span>
								</div>
								<div class="col s3">
									<div id="project-line-2">
										<canvas width="135" height="30"
											style="display: inline-block; width: 135px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>
						</li>
						<li class="collection-item">
							<div class="row">
								<div class="col s6">
									<p class="collections-title">Junior Developer</p>
									<p class="collections-content">???????</p>
								</div>
								<div class="col s3">
									<span class="task-cat teal">Back-end developer</span>
								</div>
								<div class="col s3">
									<div id="project-line-3">
										<canvas width="135" height="30"
											style="display: inline-block; width: 135px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</div>
							</div>
						</li>

					</ul>
				</div>

			</div>
		</div>
		<!--work collections end-->

		<div class="col s12 m12 l4">
			<ul id="issues-collection" class="collection">
				<li class="collection-item avatar"><i
					class="mdi-action-bug-report circle red darken-2"></i> <span
					class="collection-header">Issues</span>
					<p>Assigned to you</p> <a href="#" class="secondary-content"><i
						class="mdi-action-grade"></i></a></li>
				<% int count = 0; %>
				<%
					for (AccountInfor accInf : accInfor) {
				%>
				
				
				<li class="collection-item">
					<div class="row">
						<div class="col s5">
							<p class="collections-title"><%=accInf.getArticleName()%></p>
							<%
								if (accInf.getPublished()) {
							%>
							<p class="collections-content" style="color: #0DAB49">PUBLISHED</p>
							<%
								} else {
							%>
							<p class="collections-content" style="color: red">NOT
								PUBLISHED</p>
							<%
								}
							%>

						</div>
						<div class="col s2">
							<br> <span class="task-cat pink accent-2"><%=accInf.getFaculty()%></span>
						</div>
						<div class="col s2">
							<p class="collections-title">Date Upload</p>
							<p class="collections-content"><%=accInf.getDate_upload()%></p>
						</div>
						<div class="col s2">
							<br> <i class="fa fa-heart"
								style="color: #ed2553; font-size: 25px;"> 0 </i>
						</div>
					</div>
				</li>
				<% count = count + generator.nextInt(3) + 1; %>
				
				<%
					}
				%>

			</ul>
		</div>
	</div>

	</section>
	<!-- END CONTENT -->

	<!-- //////////////////////////////////////////////////////////////////////////// -->

	<!-- START RIGHT SIDEBAR NAV-->
	<aside id="right-sidebar-nav">
		<ul id="chat-out"
			class="side-nav rightside-navigation right-aligned ps-container ps-active-y"
			style="width: 300px; right: -310px; height: 729px;">
			<li class="li-hover"><a href="#" data-activates="chat-out"
				class="chat-close-collapse right"><i
					class="mdi-navigation-close"></i></a>
				<div id="right-search" class="row">
					<form class="col s12">
						<div class="input-field">
							<i class="mdi-action-search prefix"></i> <input id="icon_prefix"
								type="text" class="validate"> <label for="icon_prefix">Search</label>
						</div>
					</form>
				</div></li>
			<li class="li-hover">
				<ul class="chat-collapsible" data-collapsible="expandable">
					<li class="active">
						<div class="collapsible-header teal white-text active">
							<i class="mdi-social-whatshot"></i>Recent Activity
						</div>
						<div class="collapsible-body recent-activity"
							style="display: block;">
							<div class="recent-activity-list chat-out-list row">
								<div class="col s3 recent-activity-list-icon">
									<i class="mdi-action-add-shopping-cart"></i>
								</div>
								<div class="col s9 recent-activity-list-text">
									<a href="#">just now</a>
									<p>Jim Doe Purchased new equipments for zonal office.</p>
								</div>
							</div>
							<div class="recent-activity-list chat-out-list row">
								<div class="col s3 recent-activity-list-icon">
									<i class="mdi-device-airplanemode-on"></i>
								</div>
								<div class="col s9 recent-activity-list-text">
									<a href="#">Yesterday</a>
									<p>Your Next flight for USA will be on 15th August 2015.</p>
								</div>
							</div>
							<div class="recent-activity-list chat-out-list row">
								<div class="col s3 recent-activity-list-icon">
									<i class="mdi-action-settings-voice"></i>
								</div>
								<div class="col s9 recent-activity-list-text">
									<a href="#">5 Days Ago</a>
									<p>Natalya Parker Send you a voice mail for next
										conference.</p>
								</div>
							</div>
							<div class="recent-activity-list chat-out-list row">
								<div class="col s3 recent-activity-list-icon">
									<i class="mdi-action-store"></i>
								</div>
								<div class="col s9 recent-activity-list-text">
									<a href="#">Last Week</a>
									<p>Jessy Jay open a new store at S.G Road.</p>
								</div>
							</div>
							<div class="recent-activity-list chat-out-list row">
								<div class="col s3 recent-activity-list-icon">
									<i class="mdi-action-settings-voice"></i>
								</div>
								<div class="col s9 recent-activity-list-text">
									<a href="#">5 Days Ago</a>
									<p>Natalya Parker Send you a voice mail for next
										conference.</p>
								</div>
							</div>
						</div>
					</li>
					<li class="active">
						<div class="collapsible-header light-blue white-text active">
							<i class="mdi-editor-attach-money"></i>Sales Repoart
						</div>
						<div class="collapsible-body sales-repoart"
							style="display: block;">
							<div class="sales-repoart-list  chat-out-list row">
								<div class="col s8">Target Salse</div>
								<div class="col s4">
									<span id="sales-line-1"><canvas width="33" height="30"
											style="display: inline-block; width: 33px; height: 30px; vertical-align: top;"></canvas></span>
								</div>
							</div>
							<div class="sales-repoart-list chat-out-list row">
								<div class="col s8">Payment Due</div>
								<div class="col s4">
									<span id="sales-bar-1"><canvas width="32" height="25"
											style="display: inline-block; width: 32px; height: 25px; vertical-align: top;"></canvas></span>
								</div>
							</div>
							<div class="sales-repoart-list chat-out-list row">
								<div class="col s8">Total Delivery</div>
								<div class="col s4">
									<span id="sales-line-2"><canvas width="33" height="30"
											style="display: inline-block; width: 33px; height: 30px; vertical-align: top;"></canvas></span>
								</div>
							</div>
							<div class="sales-repoart-list chat-out-list row">
								<div class="col s8">Total Progress</div>
								<div class="col s4">
									<span id="sales-bar-2"><canvas width="32" height="25"
											style="display: inline-block; width: 32px; height: 25px; vertical-align: top;"></canvas></span>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="collapsible-header red white-text">
							<i class="mdi-action-stars"></i>Favorite Associates
						</div>
						<div class="collapsible-body favorite-associates">
							<div class="favorite-associate-list chat-out-list row">
								<div class="col s4">
									<img src="images/avatar.jpg" alt=""
										class="circle responsive-img online-user valign profile-image">
								</div>
								<div class="col s8">
									<p>Eileen Sideways</p>
									<p class="place">Los Angeles, CA</p>
								</div>
							</div>
							<div class="favorite-associate-list chat-out-list row">
								<div class="col s4">
									<img src="images/avatar.jpg" alt=""
										class="circle responsive-img online-user valign profile-image">
								</div>
								<div class="col s8">
									<p>Zaham Sindil</p>
									<p class="place">San Francisco, CA</p>
								</div>
							</div>
							<div class="favorite-associate-list chat-out-list row">
								<div class="col s4">
									<img src="images/avatar.jpg" alt=""
										class="circle responsive-img offline-user valign profile-image">
								</div>
								<div class="col s8">
									<p>Renov Leongal</p>
									<p class="place">Cebu City, Philippines</p>
								</div>
							</div>
							<div class="favorite-associate-list chat-out-list row">
								<div class="col s4">
									<img src="images/avatar.jpg" alt=""
										class="circle responsive-img online-user valign profile-image">
								</div>
								<div class="col s8">
									<p>Weno Carasbong</p>
									<p>Tokyo, Japan</p>
								</div>
							</div>
							<div class="favorite-associate-list chat-out-list row">
								<div class="col s4">
									<img src="images/avatar.jpg" alt=""
										class="circle responsive-img offline-user valign profile-image">
								</div>
								<div class="col s8">
									<p>Nusja Nawancali</p>
									<p class="place">Bangkok, Thailand</p>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</li>
			<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 3px;">
				<div class="ps-scrollbar-x" style="left: 0px; width: 0px;"></div>
			</div>
			<div class="ps-scrollbar-y-rail"
				style="top: 0px; height: 669px; right: 3px;">
				<div class="ps-scrollbar-y" style="top: 0px; height: 613px;"></div>
			</div>
		</ul>
	</aside>
	<!-- LEFT RIGHT SIDEBAR NAV-->

	</div>
	<!-- END WRAPPER -->

	</div>
	<!-- END MAIN -->


	<!-- //////////////////////////////////////////////////////////////////////////// -->


	<!-- END FOOTER -->


	<!-- ================================================
    Scripts
    ================================================ -->

	<!-- jQuery Library -->
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<!--materialize js-->
	<script type="text/javascript" src="js/materialize.js"></script>
	<!--scrollbar-->
	<script type="text/javascript"
		src="js/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>


	<!-- chartist -->
	<script type="text/javascript"
		src="js/plugins/chartist-js/chartist.min.js"></script>

	<!-- chartjs -->
	<script type="text/javascript" src="js/plugins/chartjs/chart.min.js"></script>
	<script type="text/javascript" src="js/plugins/chartjs/chart-script.js"></script>

	<!-- sparkline -->
	<script type="text/javascript"
		src="js/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript"
		src="js/plugins/sparkline/sparkline-script.js"></script>

	<!-- google map api -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAZnaZBXLqNBRXjd-82km_NO7GUItyKek"></script>

	<!--jvectormap-->
	<script type="text/javascript"
		src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script type="text/javascript"
		src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script type="text/javascript"
		src="js/plugins/jvectormap/vectormap-script.js"></script>
	<div class="jvectormap-label"></div>


	<div class="hiddendiv common"></div>
	<div class="drag-target"
		style="left: 0px; touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); right: 0px;"></div>
	<div class="drag-target"
		style="left: 0px; touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); right: 0px;"></div>
	<div class="drag-target"
		style="right: 0px; touch-action: pan-y; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></div>
	<div id="toast-container"></div>
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script>
	<script src="./static/js/script.js"></script>
	<%
		}
	%>
</body>
</html>