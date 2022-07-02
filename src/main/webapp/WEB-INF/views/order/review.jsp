<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.select_box{
position: relative;
margin: 10px 0 0 5%;
width: 50%;
overflow:hidden;
height:auto;
padding-bottom:100px;/* footer height */
}
.menu_name{
font-size: 30px;
float: left;
margin : 5px 0 5px 5%;
width: 90%;
height: 50px;
text-align: center;
border: 1px solid #DCDCDC;
}

.review_list{
float: left;
border: 1px solid #DCDCDC; 
width: 90%;
height: auto;
margin: 10px 0px 10px 5%; 
cursor: pointer;
}

.review{
font-size: 30px;
float: left;
margin : 5px 0 5px 2.5%;
width: 95%;
height: auto;
text-align: left;
border: 1px solid black;
}

.review input{
border: none;
font-size: 15px;
margin-left: 20px;
}

.review textarea {
    width: 100%;
    height: 4em;
    border: none;
    resize: none;
    font-size: 20px;
  }

.cart{
position:fixed;
top: inherit;
margin-left: 61%;
width: 400px;
height: auto;
border: 1px solid green;
text-align: center;
cursor: pointer;
}


.menu_box {

}
.h11{margin-left: 50px;
}
ul{
width: 700px;
}
.select{
width : 30%;
margin-left : 5%;
height : 50px;
float :left;
cursor: pointer;
text-align: center;
font-size : 30px;
border: 2px groove #DCDCDC;
border-right-width: 0;
}

.select2{
width : 30%;
height : 50px;
float :left;
cursor: pointer;
text-align: center;
font-size : 30px;
border: 2px groove #DCDCDC;
border-right-width: 0;
}
.select3{
width : 30%;
height : 50px;
float :left;
cursor: pointer;
text-align: center;
font-size : 30px;
border: 2px groove #DCDCDC;
}

.select_box a:link { text-decoration:none; color:black;}
.select_box a:link { text-decoration:none; color:black;}
.select_box a:visited { text-decoration:none;color:black;}
.select_box a:active {text-decoration:none; color:black; }
.select_box a:hover { text-decoration:none; color:black;}
</style>

<script type="text/javascript">
	
</script>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>저기요</title>

</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<%@ include file="../common/topLocation.jsp" %>
	<%@ include file="../common/topShopList.jsp" %>
	<div class ="select_box">
		<div class="menu_name">
			${shop_name }</div>
		<div class="select">
			<a href="/order?shop_id=${shop_id }&shop_name=${shop_name}">메뉴</a>
		</div>
		<div class="select2">
			리뷰
		</div>
		<div class="select3">
			정보
		</div>
		<div class="review_list">
		<c:if test="${empty sReview}" >
			<label>등록된 리뷰가 없습니다.</label>
		</c:if>
		 <c:forEach items="${sReview}" var="sr">
		   	<div class="review">
		  	 <input type="text" value="" disabled="disabled"><br>
		  	 <label>메뉴네임</label>
		  	 	<img style="width: 150px; height: 150px;" alt="" src="${contextPath }/download?imageFileName=${sr.upload_filename }" >
		  
		  	 <textarea disabled="disabled">${sr.review_content }</textarea>	
		  	</div>
		   </c:forEach>
		</div>
	<div class="cart">
		<h3>장바구니</h3>
	</div>
		</div>
		
	

<%@ include file="../common/footer.jsp" %>
</body>
</html>