<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style type="text/css">
/*
	** Style Simple Ecommerce Theme for Bootstrap 4
	** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
	*/
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: blink;
	font-size: 170%;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}

</style>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<div class="container" style="margin-top: 5%">
	<div class="row">
		<!-- Image -->
		<div class="col-12 col-lg-6">
			<div class="card bg-light mb-3" style="width: 80%;">
				<div class="card-body">
					<img class="img-fluid"
						src="${cr}/resources/productimages/${myproduct.prodid}.jpg"
						height="450" style="max-height: 500px;" width="100%" />
				</div>
			</div>
		</div>
		<!-- Add to cart -->
		<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3" style="width: 80%;">
				<div class="card-body">
					<p class="price">${myproduct.prodname}</p>
					<p class="price_discounted"
						style="color: #0762ff; font-size: 110%;">${myproduct.prodsell.sellername}</p>
					<p class="price_discounted ">Rs.${myproduct.prodprice}</p>
					<form method="get" action="cart.html">
						<div class="form-group">

							<label>Quantity :</label>
							<div class="input-group mb-3">
								<input type="text" class="form-control" id="quantity"
									name="quantity" min="1" max="100" value="1">
							</div>
						</div>
						<a href="cart.html"
							class="btn btn-success btn-lg btn-block text-uppercase"> <i
							class="fa fa-shopping-cart"></i> Add To Cart
						</a>
					</form>

				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- Description -->
		<div class="col-12">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-align-justify"></i> Description
				</div>
				<div class="card-body">
					<p class="card-text">${myproduct.proddesc}</p>
				</div>
			</div>
		</div>

		<!-- Reviews -->
	</div>
</div>
