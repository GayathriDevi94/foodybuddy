<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 0.5;
	text-align: left;
	background-image: url("${cr}/resources/images/image30.jpg");
}

.float {
	z-index: 1;
}

.box {
	margin-top: 15%;
}

.form {
	margin-top: 100px;
	margin-left: 100px;
}

input[type=text], input[type=password] {
	width: 70%;
	padding: 15px;
	margin: 20px 10px 50px 10px;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type="submit"] {
	width: 25%;
	padding: 5px;
	margin: 10px 55px;
	background-color: dark;
	color: red;
}

.btn {
	margin-left: 15%;
	padding: 5px;
}
</style>

<div class="container">
	<div id="login-row"
		class="row justify-content-center align-items-center">
		<div id="login-column" class="col-md-6">
			<div class="box">
				<div class="float">
				<c:if test="${error}">
						<div class="alert alert-danger" role="alert">UserName or Password is incorrect</div>
					</c:if>
					<form class="form" action="perform_login" method="post">
						<div class="form-group">
							<label for="username" class="text-white"><font
								color="red" size="5"> Username:</font></label><br> <input
								type="text" name="user_name" id="username" class="form-control">
						</div>
						<div class="form-group">
							<label for="password" class="text-white"><font
								color="red" size="5">Password:</font></label><br> <input
								type="text" name="user_password" id="password" class="form-control">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Sign Up</button>
							<button type="submit" class="btn btn-danger">Cancel</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>