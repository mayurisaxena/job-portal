<!doctype html>
<html lang="en" class="no-js">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<title>ITJobsSG Landing Page | Freeze Theme</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="shortcut icon" href="favicon.png">

<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" href="js/rs-plugin/css/settings.css">

<link rel="stylesheet" href="css/freeze.css">
<link rel="stylesheet" href="css/custom.css">
<style type="text/css">
.table-row {
	display: table-row;
}

.left-panel {
	float: right !important;
	display: table-cell;
}

.right-panel {
	float: left !important;
	display: table-cell;
}
</style>
<script type="text/javascript" src="js/modernizr.custom.32033.js"></script>
</head>

<body>

	<div class="pre-loader">
		<div class="overlay"></div>
		<div class="load-con">
			<img src="img/freeze/logo.png" class="animated fadeInDown" alt="">

			<div class="spinner">
				<div class="bounce1"></div>
				<div class="bounce2"></div>
				<div class="bounce3"></div>
			</div>

		</div>
	</div>

	<div id="header">
	<%
		String myVariable = (String) session.getAttribute("userRole");
		pageContext.setAttribute("myVariable", myVariable);
	%>
		<c:choose>
			<c:when test="${myVariable eq 'candidate'}">
				<jsp:include page="views/CandidateHeader.jsp" />
			</c:when>
			<c:when test="${myVariable eq 'employer'}">
				<jsp:include page="views/CandidateHeader.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="views/headerNobanner.jsp" />
			</c:otherwise>
		</c:choose>


	</div>

	<div class="wrapper-content">

		<div class="container-fluid">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="searchContainer">
					<div class="input-group">
						<input type="text" class="form-control" style="height: 44px"
							placeholder="Job Title, Keywords" name="skills" id="skills"
							required> <span class="input-group-btn">
							<button type="submit" class="btn btn-danger" id="searchSubmit">Search</button>
						</span>
					</div>
				</div>
			</div>

			<div id="searchResults" class="col-sm-8 col-sm-offset-2"></div>
			<div class="col-sm-8 col-sm-offset-2">
				<nav aria-label="Page navigation">
					<ul id="pagination" class="pagination">
					</ul>
				</nav>
			</div>
		</div>
		<footer>
			<div class="overlay"></div>
			<div class="container">
				<a href="#" class="scrollpoint sp-effect3"> <img
					src="img/freeze/logo.png" alt="" class="logo">
				</a>
				<div class="social">
					<a href="#" class="scrollpoint sp-effect3"><i
						class="fa fa-twitter fa-lg"></i></a> <a href="#"
						class="scrollpoint sp-effect3"><i
						class="fa fa-google-plus fa-lg"></i></a> <a href="#"
						class="scrollpoint sp-effect3"><i class="fa fa-facebook fa-lg"></i></a>
				</div>
				<div class="rights">
					<p>Copyright &copy; 2017</p>
				</div>
			</div>
		</footer>

	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/placeholdem.min.js"></script>
	<script src="js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
	<script src="js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/app.js"></script>
	<script>
		$(document).ready(function() {
			appMaster.preLoader();
			//TODO set the session.getAttribute("skills") to the input text
			$("#skills").val("<%=session.getAttribute("skills")%>");
			var getAllRequest = $.ajax({
				url : "http://localhost:8080/jobSearch.do",
				type : "POST",
				dataType : "json"
			});
			getAllRequest.done(function(response) {
				setSearchResult(response)
			});
			//setSearchResult(response);
			
			$("#searchSubmit").click(function() {
				searchJobsForSkilles();
			});
			
		});
	</script>

</body>