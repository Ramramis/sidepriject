<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${product.name} 상세 정보</title>
</head>
<body>

 <h1>${product.name}</h1>
    <p>가격: ${product.price} 원</p>
    <p>${product.description}</p>
    <img src="${product.imageUrl}" alt="${product.name}" />

</body>
</html>