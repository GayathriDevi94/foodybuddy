<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 0.5;
	text-align: left;
	background-image: url("resources/images/image30.jpg");
}

.Product_Button {
	padding: 20px;
	border: 1px solid #fff;
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
</style>
<div class="container">
	<div></div>
	<div class="clearfix"></div>
	<div class="row">
		<div class="clearfix"></div>
		<div class="Product_Content tab-content">
			<div id="Product_main" class="tab-pane active">
				<form:form class="form-horizontal" action="" method="POST"
					modelAttribute="prodobject">
					<fieldset>
						<div class="col-lg-12 form-group margin50">
							<label class="col-lg-12" for="Name">Product Name</label>
							<div class="col-lg-12">
								<form:input type="text" id="name" name="Name" path="prodname" />
							</div>
						</div>

						<div class="col-lg-12 form-group margin50">
							<label class="col-lg-12" for="Name">Product Description</label>
							<div class="col-lg-12">
								<form:input type="text" id="description" name="description"
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
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</div>

