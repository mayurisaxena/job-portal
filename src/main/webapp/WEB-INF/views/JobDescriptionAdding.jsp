
<div class="panel panel-info">
	<div class="panel-heading">
		<div class="panel-title">Add your Job Desciption Here</div>
		
	</div>
	<div class="panel-body">
		<form method="post" action="/JobAdd.do">
			<input type='hidden' name='csrfmiddlewaretoken'
				value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />


			<form class="form-horizontal" method="post">
				<input type='hidden' name='csrfmiddlewaretoken'
					value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S' />

				<div id="div_id_jobtitle" class="form-group required">
					<label for="id_jobtitle"
						class="control-label col-md-4  requiredField">Job Title<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-lg-12">
						<input class="input-md textinput textInput form-control"
							id="id_jobtitle" name="jobtitle"
							placeholder="Enter the Job Title" style="margin-bottom: 10px"
							type="text" />
					</div>
				</div>

				<div id="div_id_company" class="form-group required">
					<label for="id_jobdesc"
						class="control-label col-md-10  requiredField"> Job
						Description<span class="asteriskField">*</span>
					</label>
					<div class="controls row-lg-12 col-lg-12">
						<textarea class="input-md textinput textInput form-control"
							id="id_jobdesc" name="jobdesc"
							placeholder="Enter the Job Description"
							style="margin-bottom: 20px" type="text" rows="10"></textarea>
					</div>

					<div class="col-md-10 col-lg-11">&nbsp;</div>
				</div>

				<div id="div_id_company" class="form-group required">
					<label for="id_jobskills"
						class="control-label col-md-4  requiredField"> Job Skills<span
						class="asteriskField">*</span>
					</label>
					<div class="controls col-lg-12 row-lg-12">
						<textarea class="input-md textinput textInput form-control"
							id="id_jobskills" name="jobskills"
							placeholder="Enter the Job Skills with comma separated"
							style="margin-bottom: 20px" type="text" rows="5"></textarea>
					</div>
					<div class="controls col-md-10 col-lg-12"></div>
				</div>

				<div class="form-group">
					<div class="aab controls col-md-4 "></div>
					<div class="controls col-md-8 ">
						<input type="submit" name="Submit Job" value="Submit Job"
							class="btn btn-primary btn btn-info row" id="submit-id-submitjob" />
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

					});
</script>
<!-- </body> -->
<!-- </html> -->
