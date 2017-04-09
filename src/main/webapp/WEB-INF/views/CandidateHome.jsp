<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en" class="no-js">

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
		<jsp:include page="header.jsp" />
	</div>

	<div class="wrapper">
		<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/placeholdem.min.js"></script>
	<script src="js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
	<script src="js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/basic.js"></script>

	<script>
		$(document).ready(function() {
			appMaster.preLoader();
		});
	</script>

</body>

</html>