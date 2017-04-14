
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

