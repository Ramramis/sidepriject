<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <!-- Bootstrap CSS 추가 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Arial', sans-serif;
        }
        .container {
            max-width: 500px;
            margin-top: 50px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .form-group label {
            font-weight: bold;
        }
        
        /* 버튼 스타일 */
        .btn-primary2 {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            margin-top: 20px;
        }
        .btn-custom {
            padding: 10px 20px;
            border-radius: 25px;
            font-weight: bold;
            border: none;
            transition: background-color 0.3s ease;
        }
        .btn-signup {
            background-color: #007bff;
            color: white;
        }
        .btn-signup:hover {
            background-color: #0056b3;
        }
        .btn-close {
            background-color: #6c757d;
            color: white;
        }
        .btn-close:hover {
            background-color: #5a6268;
        }
        .address-btn {
            margin-top: 10px;
            background-color: #6c757d;
            color: white;
            border-radius: 25px;
            border: none;
            padding: 8px 16px;
            transition: background-color 0.3s ease;
        }
        .address-btn:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>

  <div class="container">
    <h1>회원가입</h1>
    <form action="/register" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <div class="form-group">
            <label for="userid">아이디:</label>
            <input type="text" id="userid" name="userid" class="form-control" required placeholder="아이디를 입력하세요">
        </div>

        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" class="form-control" required placeholder="비밀번호를 입력하세요">
        </div>

        <div class="form-group">
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" class="form-control" required placeholder="이메일을 입력하세요">
        </div>
        
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" class="form-control" required placeholder="이름을 입력하세요">
        </div>
        
        <div class="form-group">
            <label for="phone">연락처:</label>
            <input type="text" id="phone" name="phone" class="form-control" required placeholder="010-1234-5678" pattern="\d{3}-\d{4}-\d{4}">
        </div>
        
        <div class="form-group">
            <label for="address">주소:</label>
            <input type="text" id="zipcode" name="zipcode" class="form-control" placeholder="우편번호" readonly>
            <button type="button" class="address-btn" onclick="execDaumPostcode()">주소 검색</button>
        </div>

        <div class="form-group">
            <input type="text" id="address" name="address" class="form-control" placeholder="주소" required>
        </div>

        <div class="btn-primary2">
            <button type="submit" class="btn btn-custom btn-signup">회원가입</button>
            <button type="button" class="btn btn-custom btn-close" onclick="location.href='/products'">닫기</button>
        </div>
        
        <c:if test="${not empty error}">
            <p style="color: red; text-align: center;">${error}</p>
        </c:if>
    </form>
  </div>

  <!-- Daum 주소 검색 API 스크립트 추가 -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
      function execDaumPostcode() {
          new daum.Postcode({
              oncomplete: function(data) {
                  var roadAddr = data.roadAddress;
                  var jibunAddr = data.jibunAddress;
                  document.getElementById('zipcode').value = data.zonecode;
                  document.getElementById("address").value = roadAddr || jibunAddr;
              }
          }).open();
      }
  </script>

  <!-- Bootstrap JS와 jQuery 추가 (필수 아님) -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>