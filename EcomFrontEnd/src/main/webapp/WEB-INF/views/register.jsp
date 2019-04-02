<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	padding: 5px;
}

.container signin {
	margin-left: 25%;
	padding: 5px;
}
</style>

<div class="container">
	<div id="login-row"
		class="row justify-content-center align-items-center">
		<div id="login-column" class="col-md-6">
			<div class="box">
				<div class="float">
					<c:if test="${success}">
						<div class="alert alert-success" role="alert">changes
							updated Successfully</div>
					</c:if>
					<c:if test="${error}">
						<div class="alert alert-danger" role="alert">${message}</div>
					</c:if>

					<form:form action="addcustomer" modelAttribute="regobject">
						<div class="container">
							<h1 align="center">
								<font color="red">Register</font>
							</h1>

							<hr>
							<div>
								<label for="name"><b><font color="red">Name</font></b></label>
								<form:input type="text" placeholder="Enter name" name="name"
									path="custname" />
									<form:errors path="custname" cssStyle="color:Red"></form:errors>
							</div>

							<div>
								<label for="psw"><b><font color="red">Password</font></b></label>
								<form:input type="password" placeholder="Enter Password"
									name="psw" path="custpass" />
									<form:errors path="custpass" cssStyle="color:Red"></form:errors>
							</div>
							<div>
								<label for="email"><b><font color="red">Email</font></b></label>
								<form:input type="text" placeholder="Enter Email" name="email"
									path="custemailid" />
									<form:errors path="custemailid" cssStyle="color:Red"></form:errors>
							</div>
							<div>
								<label for="Phone number"><b><font color="red">Phone
											number</font></b></label>
								<form:input type="text" placeholder="Enter Phone Number"
									name="Phone number" path="custphonenumber" />
									<form:errors path="custphonenumber" cssStyle="color:Red"></form:errors>
							</div>
							<hr>

							<button type="submit" class="btn btn-success">Register</button>
							<button type="submit" class="btn btn-danger">Cancel</button>
						</div>
					</form:form>
				</div>
			</div>

		</div>

	</div>


</div>
