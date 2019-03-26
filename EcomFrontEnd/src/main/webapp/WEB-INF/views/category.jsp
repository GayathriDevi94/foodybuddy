<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	margin: 0;
	font-size: .9rem; font-weight : 400;
	line-height: 0.5;
	text-align: left;
	background-image: url("resources/images/image30.jpg");
	font-weight: 400;
}

.box {
	
}

.float {
	z-index: 1;
}

.form {
	margin-left: 145px;
}

input[type=text], input[type=password] {
	width: 75%;
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
		<div class="alert alert-success" role="alert">changes updated
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
						<c:if test="${!editmode}">
							<h1 class="title">Category</</h1>
							<c:set var="action" value="addcategory"></c:set>
						</c:if>
						<c:if test="${editmode}">
							<h1 class="title">Edit Category</</h1>
							<c:set var="action" value="updatecategory"></c:set>
						</c:if>
						<form:form action="${action}" modelAttribute="catobject">
							<c:if test="${editmode}">
								<form:hidden path="categid" />
							</c:if>
							<div class="container">
								<div>
									<label for="category"><b><font color="red">Category
												name</font></b></label>
									<form:input type="text" placeholder="Enter category name"
										name="categoryname" path="categname" />
								</div>
								<div>
									<label for="categdesc"><b><font color="red">Category
												description</font></b></label>
									<form:input type="text"
										placeholder="Enter category description" name="categorydesc"
										path="categdesc" />
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
										<th>CATEGORY ID</th>
										<th>CATEGORY NAME</th>
										<th>CATEGORY DESCRIPTION</th>
										<th class="text-center">EDIT/DELETE</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${categorylist}" var="cat">
										<tr>
											<td>${cat.categid}</td>
											<td>${cat.categname}</td>
											<td>${cat.categdesc}</td>
											<td class="text-center"><a class='btn btn-info btn-xs'
												href="editcategory?catname=${cat.categname}"><span
													class="glyphicon glyphicon-edit"></span> Edit</a> <a
												href="deletecategory?catname=${cat.categname}"
												class="btn btn-danger btn-xs"><span
													class="glyphicon glyphicon-remove"></span> Del</a></td>
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
