<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>반려견 밀키트 목록</title>
</head>
<body>

  <h1>반려견 밀키트 목록</h1>
    <ul>
        <c:forEach var="product" items="${products}">
            <li>
                <a href="/product/${product.id}">${product.name}</a> - ${product.price} 원
            </li>
        </c:forEach>
    </ul>

</body>
</html>