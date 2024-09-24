<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인화면</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <style>
       
        .preview {
            position: absolute;
            top: -200px;
            left: 50%;
            transform: translateX(-50%);
            max-width: 200px;
            height: auto;
            border: 1px solid #ddd;
            background: white;
            padding: 10px;
            display: none; /* 기본적으로 숨김 처리 */
            z-index: 1000;
        }
        .product-card {
            text-align: center;
            margin-bottom: 30px;
        }
        .product-card img {
            max-width: 100%;
            height: auto;
        }
        .product-card h5 {
            margin-top: 10px;
        }
        .product-card p {
            font-weight: bold;
        }
    </style>
	</head>
	<body>

		<div class="container1">
      	<!-- Include header a-->
        <jsp:include page="/WEB-INF/views/head.jsp" />
        </div>

    <div class="container">
        <h1>제품 목록</h1>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-3 product-card">
                <a href="/product/${product.id}">
                    <!-- 이미지 경로를 DB에서 가져와 화면에 표시 -->
                    <img src="${product.imageUrl}" alt="${product.name}" class="img-fluid">
                </a>
                <h5>${product.name}</h5>
                <p>${product.price}원</p>
            </div>
        </c:forEach>
    </div>
</div>

    <!-- 미리보기 이미지를 표시할 영역 -->
    <div id="image-preview" class="preview"></div>

    <footer class="text-center">
        <p>© 2024 Dog Meal Kit Shop</p>
    </footer>

    <script>
        function showPreview(image) {
            const preview = document.getElementById('image-preview');
            preview.style.display = 'block'; // 미리보기 이미지 표시
            preview.innerHTML = `<img src="${image.src}" alt="미리보기 이미지" class="img-fluid">`; // 이미지 설정

            // 이미지의 위치와 크기를 계산하여 미리보기 위치를 설정
            const rect = image.getBoundingClientRect();
            preview.style.top = (window.scrollY + rect.top - preview.offsetHeight) + 'px';
            preview.style.left = (rect.left + (rect.width / 2) - (preview.offsetWidth / 2)) + 'px';
        }

        function hidePreview() {
            const preview = document.getElementById('image-preview');
            preview.style.display = 'none'; // 미리보기 숨김
        }
    </script>

</body>
</html>