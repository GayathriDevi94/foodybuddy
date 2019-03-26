<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 0.5;
	text-align: left;
	background-image:url("resources/images/image30.jpg");
}

.container {
	
}

.float {
	z-index: 1;
}

.form {
	margin-left: 145px;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
}

.registerbtn {
	margin-left: 25%;
}

.container signin {
	margin-left: 25%;
}

.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}
</style>

<div class="container">
	<c:if test="${success}">
		<div class="alert alert-success" role="alert">Inserted
			Successfully</div>
	</c:if>
	<c:if test="${error}">
		<div class="alert alert-danger" role="alert">${message}</div>
	</c:if>
	<div id="login-row">
		<div id="login-column" class="col-md-12">
			<div class="box">
				<div class="float">
					<div class="row">
						<form:form action="addseller" modelAttribute="sellobject">
							<div class="container">
								<h1>
									<font color="red">Seller name</font>
								</h1>

								<hr>
								<div>
									<label for="seller"><b><font color="red">Seller
												name</font></b></label>
									<form:input type="text" placeholder="Enter seller name"
										name="sellername" path="sellername" />
								</div>
								<div>
									<label for="sellerdesc"><b><font color="red">Seller
												description</font></b></label>
									<form:input type="text" placeholder="Enter seller description"
										name="sellerdesc" path="sellerdesc" />
								</div>


								<button type="submit" class="registerbtn">submit</button>


							</div>

						</form:form>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<table class="table table-striped custab">
								<thead>

									<tr>
										<th>SELLER ID</th>
										<th>SELLER NAME</th>
										<th>SELLER DESCRIPTION</th>
										<td class="text-center"><a class='btn btn-info btn-xs'
											href="#"><span class="glyphicon glyphicon-edit"></span>
												Edit</a> <a href="#" class="btn btn-danger btn-xs"><span
												class="glyphicon glyphicon-remove"></span> Del</a></td>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sellerlist}" var="sel">
										<tr>
											<td>${sel.sellerid}</td>
											<td>${sel.sellername}</td>
											<td>${sel.sellerdesc}</td>
											<td></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
