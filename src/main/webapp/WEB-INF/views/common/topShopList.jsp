<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html  lang='ko' ng-controller='base_controller'>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.98.0">
    <title>shopCategory</title>

    


    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
      
      .container{
height:auto; 
border: 1px solid gray;
}
.container ul{
margin-left: 30%;
margin-right: auto;
text-align:center;
font-size: 15px;
}
.container a:link { text-decoration:none; color:black;}
.container a:link { text-decoration:none; color:black;}
.container a:visited { text-decoration:none;color:black;}
.container a:active {text-decoration:none; color:black; }
.container a:hover { text-decoration:none; color:black;}
a.active-color { color:#000; }
    </style>
<link rel='stylesheet' href='/resources/css/app.css?v=f14e8a427fe8485dcf13ba1ff6767123d268bd3b'></script>

<script src="//cdn.optimizely.com/js/9026702317.js"></script>
<script type="text/javascript">
function windowload(){
	
}
window.onload = windowload;
</script>
<title>Insert title here</title>
</head>

<body>


<div class="container" style="width: 100%;">
    <header class="d-flex justify-content-center py-3">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="/shopCategory?category_num=1" class="nav-link active" aria-current="page">치킨</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=2" class="nav-link">피자</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=3" class="nav-link">중국집</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=4" class="nav-link">한식</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=5" class="nav-link">일식/돈까스</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=6" class="nav-link">족발/보쌈</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=7" class="nav-link">분식</a></li>
        <li class="nav-item"><a href="/shopCategory?category_num=100" class="nav-link">기타</a></li>
      </ul>
 
  
    </header>
  </div>
 

</body>
</html>