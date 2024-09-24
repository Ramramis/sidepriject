<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제품 상세</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .product-detail {
            text-align: center;
        }
        .product-detail img {
            max-width: 100%;
            height: auto;
        }
        .product-detail h1 {
            margin-top: 20px;
        }
    </style>
</head>
<body>

		<div class="container1">
      	<!-- Include header a-->
        <jsp:include page="/WEB-INF/views/head.jsp" />
        </div>


<div class="container">
    <div class="product-detail">
        <img src="${product.imageUrl}" alt="${product.name}">
        <h1>${product.name}</h1>
        <p>${product.description}</p>
        <p><strong>가격: ${product.price}원</strong></p>
    </div>
</div>

</body>
</html>