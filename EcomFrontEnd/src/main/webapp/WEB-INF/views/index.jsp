<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="icon" href="resources/images/capture1.PNG" type="image/gif"
	size="16*16">
<title>Foody buddy</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<div>
		<c:if test="${sliderPage}">
			<jsp:include page="slider.jsp" />
		</c:if>
		<c:if test="${aboutPage}">
			<jsp:include page="aboutus.jsp" />
		</c:if>
		<c:if test="${contactPage}">
			<jsp:include page="contactus.jsp" />
		</c:if>
		<c:if test="${loginPage}">
			<jsp:include page="login.jsp" />
		</c:if>
		<c:if test="${registerPage}">
			<jsp:include page="register.jsp" />
		</c:if>
		<c:if test="${categoryPage}">
			<jsp:include page="category.jsp" />
		</c:if>
		<c:if test="${sellerPage}">
			<jsp:include page="seller.jsp" />
		</c:if>
		<c:if test="${productPage}">
			<jsp:include page="product.jsp" />
		</c:if>
		<c:if test="${viewproductPage}">
			<jsp:include page="viewproducts.jsp" />
		</c:if>
		<c:if test="${viewoneproductPage}">
			<jsp:include page="viewoneproduct.jsp" />
		</c:if>
		<c:if test="${cartPage}">
			<jsp:include page="cart.jsp" />
		</c:if>
		<c:if test="${addressPage}">
			<jsp:include page="Address.jsp" />
		</c:if>
		<c:if test="${orderPage}">
			<jsp:include page="order.jsp" />
		</c:if>
		<c:if test="${receiptPage}">
			<jsp:include page="receipt.jsp" />
		</c:if>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>