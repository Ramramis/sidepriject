<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>제품 등록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .preview-img {
            max-width: 100%;
            height: auto;
            display: none; /* 기본적으로 미리보기 이미지는 숨김 */
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container1">
      	<!-- Include header a-->
        <jsp:include page="/WEB-INF/views/head.jsp" />
        </div>

<div class="container">
    <h1>제품 등록</h1>
    <form action="/product/new" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">제품명</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="제품명을 입력하세요" required>
        </div>

        <div class="form-group">
            <label for="description">설명</label>
            <textarea class="form-control" id="description" name="description" rows="3" placeholder="제품 설명을 입력하세요" required></textarea>
        </div>

        <div class="form-group">
            <label for="file">이미지 업로드</label>
            <input type="file" class="form-control" id="file" name="file" accept="image/*" onchange="previewImage(event)">
            <!-- 미리보기 이미지 태그 -->
            <img id="preview" class="preview-img" src="#" alt="이미지 미리보기">
        </div>

        <div class="form-group">
            <label for="price">가격</label>
            <input type="number" class="form-control" id="price" name="price" placeholder="가격을 입력하세요" required>
        </div>
        
          <div class="form-group">
            <label for="memo">상세내용</label>
         <textarea class="form-control"  id="memo" name="memo" placeholder="내용을 입력하세요" required></textarea>
        </div>
        

        <button type="submit" class="btn btn-primary">등록하기</button>
    </form>
</div>

<script>
    // 이미지 미리보기 함수
    function previewImage(event) {
        const reader = new FileReader();
        reader.onload = function(){
            const output = document.getElementById('preview');
            output.src = reader.result;  // 파일 읽은 결과를 이미지의 src로 설정
            output.style.display = 'block';  // 미리보기 이미지를 보이게 설정
        };
        reader.readAsDataURL(event.target.files[0]);  // 선택된 파일을 읽어옴
    }
</script>

</body>
</html>