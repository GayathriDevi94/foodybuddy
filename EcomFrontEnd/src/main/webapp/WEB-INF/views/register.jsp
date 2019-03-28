<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 0.5;
	text-align: left;
	background-image: url("resources/images/image30.jpg");
}

.float {
	z-index: 1;
}

.box {
	margin-top: 15%;
}

.form {
	margin-top: 100px;
	margin-left: 145px;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

.btn {
	margin-left: 25%;
	padding:5px;
}

.container signin {
	margin-left: 25%;
		padding:5px;
	
}
</style>

<div class="container">
	<div id="login-row"
		class="row justify-content-center align-items-center">
		<div id="login-column" class="col-md-6">
			<div class="box">
				<div class="float">

					<form action="/action_page.php">
						<div class="container">
							<h1 align="center">
								<font color="red">Register</font>
							</h1>
							
							<hr>
							<div>
								<label for="email"><b><font color="red">Email</font></b></label>
								<input type="text" placeholder="Enter Email" name="email"
									required>
							</div>
							<div>
								<label for="psw"><b><font color="red">Password</font></b></label>
								<input type="password" placeholder="Enter Password" name="psw"
									required>
							</div>
							<div>
								<label for="psw-repeat"><b><font color="red">Repeat
											Password</font></b></label> <input type="password" placeholder="Repeat Password"
									name="psw-repeat" required>
								<hr>
							</div>
							<button type="submit" class="btn btn-success">Sign Up</button>
							<button type="submit" class="btn btn-danger">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
