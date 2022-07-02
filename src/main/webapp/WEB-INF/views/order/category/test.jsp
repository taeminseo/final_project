<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<title>전체</title>
<style type="text/css">
.shop_box{
position: relative;
border: 1px solid #DCDCDC;
margin: 10px 0 10px 10%;
width: 80%;
overflow:hidden;
height:auto;
padding-bottom:100px;/* footer height */
}

.shops{
border: 1px groove #DCDCDC;
width: 400px; 
height: 100px; 
float: left; 
margin: 20px 50px 30px 10%;
cursor: pointer;
}

.info{
margin: 10px 0 0 100px;
}


</style>
  <meta charset="UTF-8">
  <script>
/* 	var req;
	function idSend(){
	req = new XMLHttpRequest();
	req.open('get', 'order');
	req.send(document.getElementById('shop_id').value);
	//location.href = "order";
	}
*/
	</script>
  
 
</head>
<%@ include file="../../common/top.jsp" %> 
<%@ include file="../../common/topLocation.jsp" %>
<%@ include file="../../common/topShopList.jsp" %>
<body>
   
<div class="shop_box">
		<h6 class="info">등록된 음식점</h6>
	 <c:forEach var="db" items="${list }" varStatus="vs">
		<div class="shops" onclick="location.href='order?shop_id=${db.shop_id}&shop_name=${db.shop_name }'">
		<img alt="" src="../resources/images/shop_logo/${db.shop_logo }" style="float: left;" width="150px;" height="98px;" >
		
			<label style="width: 140px; float: left; margin: 20px 0 0 10px"> ${db.shop_name }<br>
			<c:forEach var="re" items="${reList }">
				리뷰
				<c:if test="${re.shop_num == db.shop_num}">
				 (<c:out value="${re.cnt }" />)
				</c:if>
				<br>
			</c:forEach>
			<c:forEach var="evl" items="${valueList }">
				별점
				<c:if test="${evl.shop_num == db.shop_num}">
				 (<c:out value="${evl.evalute}" />)<br>
				</c:if>
				<br>
			</c:forEach>
			</label>
			</div>
	</c:forEach>
	 </div>
 
<%@ include file="../../common/footer.jsp" %>
</body>

</html>