<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인화면</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="stylesheet" type="text/css" href="/css/main.css" />
</head>
<body>

<header class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"><img src="/css/logo.png" alt="Logo"></a>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="/register">회원가입</a></li>
            <li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
            <li class="nav-item"><a class="nav-link" href="#">장바구니</a></li>
        </ul>
    </nav>
</header>


<div class="container1">
    <div class="category-bar">
        <button class="btn btn-dark">전체</button>
        <button class="btn btn-light">Leash</button>
        <button class="btn btn-light">Collar</button>
        <button class="btn btn-light">Harness</button>
        <button class="btn btn-light">Outerwear</button>
        <button class="btn btn-light">Set</button>
        <button class="btn btn-light">Essentials</button>
    </div>
    

<div class="container">
    <h1>제품 목록</h1>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-3">
                <div class="product-card">
                    <img src="${product.imageUrl}" alt="${product.name}">
                    <h5>${product.name}</h5>
                    <p>${product.price}원</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-3">
                <div class="product-card">
                    <img src="${product.imageUrl}" alt="${product.name}">
                    <h5>${product.name}</h5>
                    <p>${product.price}원</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<footer class="text-center">
    <p>© 2024 Dog Meal Kit Shop</p>
</footer>



</body>
</html>