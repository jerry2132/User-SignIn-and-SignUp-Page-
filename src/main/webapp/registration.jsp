<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required="required"/>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" required="required"/>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" required="required"/>
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" maxlength="10" pattern="[1-9]{1}[0-9]{9}" title="Please use a 10 digit telephone number with no dashes or dots" required="required"/>
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" title="Please indicate that you have accepted terms amd condition" required/> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="terms.html" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status=="success")
		{
		swal("CONGRATS","ACCOUNT CREATED SUCCESSFULY","success");
		}
	
	if(status=="invaliduname")
	{
	swal("ERROR","PLEASE ENTER YOUR NAME","error");
	}
	
	 if(status=="invalidemail")
	{
	swal("ERROR","PLEASE ENTER YOUR MAIL","error");
	}
	
	 if(status=="invalidpwd")
	{
	swal("ERROR","PLEASE ENTER YOUR PASSWORD","error");
	}
	
	 if(status=="invalidrepwd")
	{
	swal("ERROR","PASSWORD MISMATCH","error");
	}
	 if(status=="invalidmobile")
	{
	swal("ERROR","INVALID MOBILE LENGTH","error");
	}
	if(status=="invalidlength")
	{
	swal("ERROR","INVALID MOBILE LENGTH","error");
	}
	
	</script>
	



</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>