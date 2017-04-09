<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Job Portal</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/jobs.css">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>
	
	<div class="container-fluid bg-grey">
		<form class="form-horizontal" action="/login.do" method="post">
			
			<div id="div_id_email_login" class="form-group required">
					<label for="id_email_login" class="control-label col-md-2  requiredField">
						E-mail<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md emailinput form-control required_entry_Login" id="id_email_login" 
							name="email" placeholder="Your Current email Address"
							style="margin-bottom: 10px" type="email" />
					</div>
				</div>
			
			<div id="div_id_password_login" class="form-group required">
					<label for="id_password_login"
						class="control-label col-md-2  requiredField">Password<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control required_entry_Login" required
							id="id_password_login" name="password1"
							placeholder="Enter the Password" style="margin-bottom: 10px"
							type="password" />
					</div>
					<p>
						<font color="red">${errorMessage}</font>
					</p>
				</div>
				<div class="form-group">
					<div class="aab controls col-md-5 "></div>
					<div class="controls col-md-4 ">
						<input type="submit" name="Login" value="Login" 
							class="btn btn-primary btn btn-info requiredSubmitLogin" id="submit-id-login" />
					</div>
				</div>
		</form>

	</div>



</body>

</html>