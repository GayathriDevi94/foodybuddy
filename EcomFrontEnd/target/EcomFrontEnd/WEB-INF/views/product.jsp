<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 0.5;
	text-align: left;
	background-image: url("${cr}/admin/resources/images/image30.jpg");
}
.style
{
	color:white;

}

.Product_Button {
	padding: 20px;
	border: 1px solid #fff;
}

.btn {
	margin-left: 50%;
	padding: 5px;
}

.margin50 {
	margin-top: 50px
}

.productbtn:after {
	font-family: "Glyphicons Halflings";
	content: "\e114";
	float: right;
	margin-left: 15px;
}
/* Icon when the collapsible content is hidden */
.productbtn.collapsed:after {
	content: "\e080";
}

.width450 {
	width: 450px
}

.margin50 {
	margin-top: 50px;
}

input[type=radio], input[type=checkbox] {
	margin: 4px !important;
}

.dimentions-width, .dimentions-height {
	width: 90%;
	display: initial;
}

input[type=text], select, textarea, input[type=file] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
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
	<c:if test="${!editmode}">
		<h1 class="title">Product</h1>
		<c:set var="action" value="${cr}/admin/addproduct"></c:set>
	</c:if>
	<c:if test="${editmode}">
		<h1 class="title">Edit Product</h1>
		<c:set var="action" value="${cr}/admin/updateproduct"></c:set>
	</c:if>
	<form:form class="form-horizontal" action="${action}" method="POST"
		modelAttribute="prodobject" enctype="multipart/form-data">
		<c:if test="${editmode}">
			<form:hidden path="prodid" />
		</c:if>
		<fieldset>
			<div class="col-lg-12 form-group margin50">
				<label class="col-lg-12" for="Name">Product Name</label>
				<div class="col-lg-12">
					<form:input id="name" name="Name" path="prodname" />
				</div>
			</div>

			<div class="col-lg-12 form-group margin50">
				<label class="col-lg-12" for="Name">Product Description</label>
				<div class="col-lg-12">
					<form:textarea type="text" id="description" name="description"
						path="proddesc" />
				</div>
			</div>
			<div class="col-lg-12 form-group margin50">
				<label class="col-lg-12" for="stock">Stock</label>
				<div class="col-lg-12">
					<form:input type="text" id="stock" name="stock" path="prodstock" />
				</div>
			</div>

			<div class="col-lg-12 form-group margin50">
				<label class="col-lg-12" for="price">Price</label>
				<div class="col-lg-12">
					<form:input type="text" id="price" name="price" path="prodprice" />
				</div>
			</div>
			<div class="col-lg-12 form-group">
				<label class="col-lg-12" for="Distributor">Category</label>
				<div class="col-lg-12">
					<form:select path="prodcateg.categid">
						<c:forEach items="${categorylist}" var="cat">
							<form:option value="${cat.categid}">${cat.categname}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="col-lg-12 form-group">
				<label class="col-lg-12" for="Distributor">Seller</label>
				<div class="col-lg-12">
					<form:select path="prodsell.sellerid">
						<c:forEach items="${sellerlist}" var="sel">
							<form:option value="${sel.sellerid}">${sel.sellername}</form:option>
						</c:forEach>
					</form:select>
					<label for="pimage"><b>Product Image</b></label>
					<form:input type="file" name="fileToUpload" id="fileToUpload"
						path="pimage" required="true" />
					<button type="submit" class="btn btn-success">submit</button>

				</div>
			</div>
		</fieldset>
	</form:form>
</div>
<div class="row">
	<div class="col-lg-12">
		<table class="table table-striped custab style" style="border-color: black;border-style: solid; border-width: 2px">
			<thead style="color: black; background-color: #00FF00;">

				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT DESCRIPTION</th>
					<th>STOCK</th>
					<th>PRICE</th>
					<th>CATEGORY</th>
					<th>SELLER</th>
					<th>Product Image</th>
					<th class="text-center">EDIT/DELETE</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productlist}" var="prod">
					<tr>
						<td>${prod.prodid}</td>
						<td>${prod.prodname}</td>
						<td>${prod.proddesc}</td>
						<td>${prod.prodstock}</td>
						<td>${prod.prodprice}</td>
						<td>${prod.prodcateg.categname}</td>
						<td>${prod.prodsell.sellername}</td>
						<td><img src="${cr}/admin/resources/productimages/${prod.prodid}.jpg"
							width="50" height="50" /></td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							href="${cr}/admin/editproduct?prodid=${prod.prodid}"><span
								class="glyphicon glyphicon-edit"></span> Edit</a> <a
							href="${cr}/admin/deleteproduct?prodid=${prod.prodid}"
							class="btn btn-danger btn-xs"><span
								class="glyphicon glyphicon-remove"></span> Del</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>