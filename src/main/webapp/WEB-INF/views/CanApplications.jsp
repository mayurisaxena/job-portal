<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Job Applications</title>

<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
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
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="header">
		<jsp:include page="CandidateHeader.jsp" />
	</div>
	
	<div class="wrapper-content" style="margin-top: 200px; display:block;">

		<div class="container-fluid">
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
			var getAllRequest = $.ajax({
				url : "http://localhost:8080/canApplications.do",
				type : "POST",
				dataType : "json"
			});
			getAllRequest.done(function(response) {
				setSearchResult(response)
			});
			
		});
	</script>
</body>
</html>