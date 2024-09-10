<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>

  <h1>회원가입</h1>

   <form action="/register" method="post">
        <div>
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" required  placeholder="공백없이 입력하세요">
        </div>

        <div>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required  placeholder="공백없이 입력하세요">
        </div>

        <div>
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" required  placeholder="공백없이 입력하세요">
        </div>
        
         <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required  placeholder="공백없이 입력하세요">
        </div>
        
         <div>
            <label for="phone">연락처:</label>
            <input type="text" id="phone" name="phone" required placeholder="010-1234-5678" pattern="\d{3}-\d{4}-\d{4}">
        </div>
        
          <div>
            <label for="address">주소:</label>
            <input type="text" id="zipcode" name="zipcode" placeholder="우편번호"  readonly >
             <button type="button" onclick="execDaumPostcode()">주소 검색</button>
        </div>
         <input type="text" id="address" name="address" required>

        <div>
            <button type="submit">회원가입</button>
        </div>
        
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
    </form>
    
    
     <!-- Daum 주소 검색 API 스크립트 추가 -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode;
                    document.getElementById("address").value = roadAddr || jibunAddr;
                }
            }).open();
        }
    </script>
</body>
</html>