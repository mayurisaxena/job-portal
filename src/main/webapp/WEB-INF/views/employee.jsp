
<div class="panel panel-info">
	<div class="panel-heading">
		<div class="panel-title">Sign Up As Employer</div>
		<div
			style="float: right; font-size: 85%; position: relative; top: -10px">
			<a id="signinlink" href="/accounts/login/">Sign In</a>
		</div>
	</div>
	<div class="panel-body">
		<form method="post" action="/employeeAdd.do">
			<input type='hidden' name='csrfmiddlewaretoken'
				value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />

			<form class="form-horizontal" method="post" action="/employeeAdd.do"
				onsubmit="validateForm();">
				<input type='hidden' name='csrfmiddlewaretoken'
					value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />
				<div id="div_id_aliasname" class="form-group required">
					<label for="id_aliasname"
						class="control-label col-md-4  requiredField"> Alias Name<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md form-control textInput required_entry_employer" id="id_aliasname"
							maxlength="30" name="aliasname"
							 style="margin-bottom: 10px;"
							type="text" />
					</div>
				</div>
				<div id="div_id_email" class="form-group required">
					<label for="id_email" class="control-label col-md-4  requiredField">
						E-mail<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md emailinput form-control" id="id_email"
							name="email" 
							style="margin-bottom: 10px" type="email" />
					</div>
				</div>
				<div id="div_id_password1" class="form-group required">
					<label for="id_password1"
						class="control-label col-md-4  requiredField">Password<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control required_entry_employer"
							id="id_password1" name="password" style="margin-bottom: 10px"
							type="password" />
					</div>
				</div>
				<div id="div_id_password2" class="form-group required">
					<label for="id_password2"
						class="control-label col-md-4  requiredField"> Re:password<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 "> 
						<input class="input-md textinput textInput form-control required_entry_employer"
							id="id_password2" name="password2"
							 style="margin-bottom: 10px"
							type="password" />
					</div>
				</div>

				<div id="div_id_company" class="form-group required">
					<label for="id_company"
						class="control-label col-md-4  requiredField"> Company
						Name<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control required_entry_employer"
							id="id_company" name="company" 
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>

				<div id="div_id_number" class="form-group required">
					<label for="id_number"
						class="control-label col-md-4  requiredField"> Contact
						Number<span class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control required_entry_employer"
							id="id_number" name="number" 
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				<div id="div_id_address" class="form-group required">
					<label for="id_address"
						class="control-label col-md-4  requiredField"> Address<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-md-8 ">
						<input class="input-md textinput textInput form-control required_entry_employer"
							id="id_address" name="Address" 
							style="margin-bottom: 10px" type="text" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="aab controls col-md-4 "></div>
					<div class="controls col-md-8 ">
						<input type="submit" name="Signup" value="Signup"
							class="btn btn-primary btn btn-info requiredSubmitEmployer"  id="submit-id-signup" />
					</div>
				</div>

			</form>

		</form>
	</div>
</div>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var enrollType;
						//  $("#div_id_As").hide();
						$("input[name='As']")
								.change(
										function() {
											memberType = $(
													"input[name='select']:checked")
													.val();
											providerType = $(
													"input[name='As']:checked")
													.val();
											//toggleIndividInfo();
										});

						$("input[name='select']").change(
								function() {
									memberType = $(
											"input[name='select']:checked")
											.val();
									//toggleIndividInfo();
									//toggleLearnerTrainer();
								});

						function toggleLearnerTrainer() {

							if (memberType == 'P' || enrollType == 'company') {
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

						function validateForm() {
							
						}
					});
</script>