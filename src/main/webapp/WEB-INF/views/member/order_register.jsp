<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.review_RegisterBox{
position: relative;
margin: 10px 0 10px 5%;
border: 1px solid black;
width: 90%;
overflow:hidden;
height:350px;
padding-bottom:100px;/* footer height */
}
.review{
width:100%;
height: auto;
}

.uploadbox{
width:100%;
height: auto;
}

.writebox{
height: 110px;
width: 100%;
}

.imagePreview{
height: auto;
width: 30%;

}

li {
     list-style: none;
}

img {
      width: 200px;
      height: 200px;
}

.real-upload {
 display: none;
 }

.upload {
position: absolute;
margin-left:5px;
width: 100px;
height: 50px;
background-color: white;
border: 1px solid gray;
}

.image-preview {
width: 100%;
      height: 200px;
      background-color: gray;
      display: flex;
      gap: 10px;
}
    
.t_write{
margin : 0 0 0 10px;
width: 300px;
height: 100px;
}

.registerBtn{
margin : 10px 0 0 40%;
border : 1px solid #B7F0B1;
background-color : #B7F0B1;
width: 50px;
height: 40px;
}   
</style>
<meta charset="UTF-8">
<title>리뷰등록</title>
</head>
<script type="text/javascript">
	function reviewRegister(){
	var member_id = document.getElementById('member_id').value;
	var shop_id = document.getElementById('shop_id').value;
	var order_num = document.getElementById('order_num').value;
	console.log(member_id,shop_id,order_num);
}
</script>
<body>
	<c:set target="orderRe" var="Re"></c:set>
	<div class="review_RegisterBox">
		<div class="review">
		
			<input type="text" id="member_id" value="회원아이디<c:out value="${orderRe.member_id }" />">
			<input type="text" id="shop_id" value="샵아이디<c:out value="${orderRe.shop_id }" /> ">
			<input type="hidden" id="order_num" value="주문번호<c:out value="${orderRe.order_num }" />">
			<input type="text" value="지점이름"><br>
			<input type="text" value="주문내용">
			
		<div id="uploadbox">
			<ul class="image-preview"></ul>
		</div>
		<div class="writebox">
			<textarea class="t_write" placeholder="리뷰 작성"></textarea>
			<button class="upload">사진업로드</button>
			<input type="file" class="real-upload" accept="img/*" required multiple>
		</div>
			<input type="button" class="registerBtn" onclick="reviewRegister()" value="등록">
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript">

function getImageFiles(e) {
  const uploadFiles = [];
  const files = e.currentTarget.files;
  const imagePreview = document.querySelector('.image-preview');
  const docFrag = new DocumentFragment();

  if ([...files].length >= 4) {
    alert('이미지는 최대 3개 까지 업로드가 가능합니다.');
    return;
  }

  // 파일 타입 검사
  [...files].forEach(file => {
    if (!file.type.match("image/.*")) {
      alert('이미지 파일만 업로드가 가능합니다.');
      return
    }

    // 파일 갯수 검사
    if ([...files].length < 4) {
      uploadFiles.push(file);
      const reader = new FileReader();
      reader.onload = (e) => {
        const preview = createElement(e, file);
        imagePreview.appendChild(preview);
      };
      reader.readAsDataURL(file);
    }
  });
}

function createElement(e, file) {
  const li = document.createElement('li');
  const img = document.createElement('img');
  img.setAttribute('src', e.target.result);
  img.setAttribute('data-file', file.name);
  li.appendChild(img);

  return li;
}

const realUpload = document.querySelector('.real-upload');
const upload = document.querySelector('.upload');

upload.addEventListener('click', () => realUpload.click());

realUpload.addEventListener('change', getImageFiles);
</script>
</body>



</html>