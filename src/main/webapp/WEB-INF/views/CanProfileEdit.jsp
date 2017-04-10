<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
<title>AddingCandidateDesciption - ITJobsSG.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="wrapper-content">
	<div class="container">

		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add your Profile Here</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="/accounts/login/">For Candidates</a>
					</div>
				</div>
				<div class="panel-body">
					<form method="post" action="/candidateUpdate.do">
						<input type='hidden' name='csrfmiddlewaretoken'
							value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />


						<form class="form-horizontal" method="post">
							<input type='hidden' name='csrfmiddlewaretoken'
								value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />
							<div id="div_id_aliasname" class="form-group required">
								<label for="id_aliasname"
									class="control-label col-md-4  requiredField"> Full
									Name<span class="asteriskField">*</span>
								</label>
								<div class="controls col-md-8 ">
									<input class="input-md  textinput textInput form-control"
										id="id_aliasname" maxlength="30" name="firstname"
										placeholder="Enter Your Full Name" value="${firstname}"
										style="margin-bottom: 10px" type="text" />
								</div>
							</div>
							
							<div id="div_id_jobtitle" class="form-group required">
								<label for="id_jobtitle"
									class="control-label col-md-4  requiredField">Highest Educational Qualification<span class="asteriskField">*</span>
								</label>
								<div class="controls col-md-8 ">
									<input class="input-md textinput textInput form-control"
										id="id_jobtitle" name="qualification" value="${qualification}" placeholder="Enter the Highest Educational Qualification"
										style="margin-bottom: 10px" type="text" />
								</div>
							</div>
							
							<div id="div_id_company" class="form-group required">
								<label for="id_jobdesc"
									class="control-label col-md-10  requiredField">Description<span class="asteriskField">*</span>
								</label>
								<div class="controls row-lg-12 col-lg-12">
									<textarea class="input-md textinput textInput form-control"
										id="id_jobdesc" name="description" placeholder="Enter the Your Description and Experience"
											  style="margin-bottom: 20px" type="text" rows= "10">${description}</textarea>
								</div>
							
								<div class="col-md-10 col-lg-11">&nbsp;</div>
							</div>
							
							<div id="div_id_company" class="form-group required">
								<label for="id_jobskills"
									class="control-label col-md-4  requiredField"> Your Skills<span class="asteriskField">*</span>
								</label>
							  <div class="controls col-lg-12 row-lg-12">
									<textarea class="input-md textinput textInput form-control"
										id="id_jobskills" name="skills" placeholder="Enter the Your Software Skills with comma seperated"
										style="margin-bottom: 20px" type="text" rows= "3" >${skills}</textarea>
								</div>
							  <div class="controls col-md-10 col-lg-12"> </div>
							 </div>
							 
							<div class="form-group">
								<div class="aab controls col-md-4 "></div>
								<div class="controls col-md-8 ">
									<input type="submit" name="Save Profile" value="Save Profile"
										class="btn btn-primary btn btn-info row" id="submit-id-saveProfile" />
								</div>
							</div>
					
						</form>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>

	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							var enrollType;
							//  $("#div_id_As").hide();
							$("input[name='As']").change(
									function() {
										memberType = $(
												"input[name='select']:checked")
												.val();
										providerType = $(
												"input[name='As']:checked")
												.val();
										toggleIndividInfo();
									});

							$("input[name='select']").change(
									function() {
										memberType = $(
												"input[name='select']:checked")
												.val();
										toggleIndividInfo();
										toggleLearnerTrainer();
									});

							function toggleLearnerTrainer() {

								if (memberType == 'P'
										|| enrollType == 'company') {
									$("#cityField").hide();
									$("#providerType").show();
									$(".provider").show();
									$(".locationField").show();
									if (enrollType == 'INSTITUTE') {
										$(".individ").hide();
									}

								} else {
									$("#providerType").hide();
									$(".provider").hide();
									$('#name').show();
									$("#cityField").hide();
									$(".locationField").show();
									$("#instituteName").hide();
									$("#cityField").show();

								}
							}
							function toggleIndividInfo() {

								if (((typeof memberType !== 'undefined' && memberType == 'TRAINER') || enrollType == 'INSTITUTE')
										&& providerType == 'INDIVIDUAL') {
									$("#instituteName").hide();
									$(".individ").show();
									$('#name').show();
								} else if ((typeof memberType !== 'undefined' && memberType == 'TRAINER')
										|| enrollType == 'INSTITUTE') {
									$('#name').hide();
									$("#instituteName").show();
									$(".individ").hide();
								}
							}

						});
	</script>
</body>
</html>
