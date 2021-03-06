<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html  lang='ko' ng-controller='base_controller'>
<head>
<meta charset='utf-8'><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'>
<meta name='apple-mobile-web-app-capable' content='yes'><meta name='apple-mobile-web-app-status-bar-style' content='black-translucent'>
<meta name="google-site-verification" content="U4GhkkNiUMneDT6RC-apM8m8D6hZJfAXVfXi2_SuyWU">
<meta name="keywords" content="치킨, 요기요, 중국집, 피자, 치킨추천, 배달음식, 야식, 내주변맛집, 짜장면, 근처중국집, 배달, 뭐먹지, 맛있는치킨추천, 여기요, 점심메뉴추천, 요기요첫주문할인, 중화요리, 피자추천, 맛있는음식, 치킨배달, 피자배달, 근처중국집배달, 맛있는치킨순위, 야식추천, 근처치킨집, 후라이드치킨순위, 족발집, 낙지소면, 요기요쿠폰, 짜장면집, 배달앱, 족발배달, 피자집, 피자할인, 식사, 요기요할인, 낙지볶음배달, 곱창배달, 배달어플할인, 24시중국집, 배달어플, 치킨할인, 떡볶이배달, 야식배달, 낙지소면배달, 중국집배달, 냉면배달, 점심배달음식, 치킨집, 요기요첫주문, 요기요쿠폰코드, 배달떡볶이, 피자치킨세트, 야식어플, 배달피자, 배달앱추천, 보쌈, 요기요할인쿠폰, 배달요기요, 초밥배달, 근처피자집, 맛있는치킨, 배달야식추천, 24시간중국집, 족발, 돈까스배달, 배달맛집, 배달음식순위, 비비큐할인, 삼계탕배달, 24시간피자배달, 집들이음식배달, 맛있는피자, 분식배달, 24시치킨, 배달사이트, 저녁메뉴추천, 요기오, 부대찌개배달, 혼자배달음식, 배달음식추천, 요기요배달, 요기요치킨, 배달서비스, 스파게티배달, 아침식사배달, 24시야식배달, 24시배달, 배달할인, 여기요할인, 24시간배달, 24시간치킨, 요기여, 1인분배달, yogiyo, 치킨배달할인, 강남역배달, 배달죽, 요기요플러스, 플러스요기요">
<meta name="description" content="우리 동네 맛집이 그 맛 그대로 빠르게! 다양한 인기 브랜드 할인도 놓치지 마세요.">
<meta name="theme-color" content="#fa0050">
<meta property="og:title" content="기다림없는 맛집 배달, 요기요">
<meta property="og:url" content="http://www.yogiyo.co.kr/">
<meta property="og:image" content="https://www.yogiyo.co.kr/mobile/image/app_img_560x292_v2.png">
<meta property="og:description" content="우리 동네 맛집이 그 맛 그대로 빠르게! 다양한 인기 브랜드 할인도 놓치지 마세요.">
<link rel="apple-touch-icon-precomposed" href="https://www.yogiyo.co.kr/mobile/image/app_128x128.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="https://www.yogiyo.co.kr/mobile/image/app_144x144.png">
<link rel="icon" type="image/x-icon" href="https://www.yogiyo.co.kr/mobile/image/favicon.ico">
<title ng-if="! page.title">저기요</title>
<title ng-if="page.title" ng-bind='page.title + " - 요기요"'></title>
<script>
	var is_yogiyo = window.location.hostname.indexOf('yogiyo.co.kr') >= 0;
	var is_11st = window.location.hostname.indexOf('yogiyo.m.11st.co.kr') >= 0;
</script>
<link rel='stylesheet' href='/resources/css/app.css?v=f14e8a427fe8485dcf13ba1ff6767123d268bd3b'></script>
<!-- Start location.search generate Code for Naver 검색 유입 -->
<script type='text/javascript'>
	if (is_yogiyo) {
		(function() {
			function beginsWith(begin, whole) {
				if (whole.indexOf(begin) === 0) {
					return whole.substr(begin.length);
				}
			}
			function urlResolve(url) {
				var href = url;if (msie) {
					urlParsingNode.setAttribute('href', href);
					href = urlParsingNode.href;
				}
				urlParsingNode.setAttribute('href', href);
				return {
					href: urlParsingNode.href,protocol: urlParsingNode.protocol ? urlParsingNode.protocol.replace(/:$/, '') : ''
							,host: urlParsingNode.host,search: urlParsingNode.search ? urlParsingNode.search.replace(/^\?/, '') : ''
									,hash: urlParsingNode.hash ? urlParsingNode.hash.replace(/^#/, '') : ''
											,hostname: urlParsingNode.hostname
											,port: urlParsingNode.port
											,pathname: (urlParsingNode.pathname.charAt(0) === '/')? urlParsingNode.pathname: '/' + urlParsingNode.pathname
				};
			}
			var msie = document.documentMode;
			var urlParsingNode = document.createElement('a');
			var originUrl = urlResolve(window.location.href);var originSearchUrl = originUrl.search;
			var withoutHashUrl = originUrl.hash;
			if (withoutHashUrl !== '') {
				if (withoutHashUrl.charAt(0) === '#') {
					withoutHashUrl = beginsWith('#', withoutHashUrl);
				}
				var hashUrl = urlResolve(withoutHashUrl);
				if (hashUrl.search !== '' && originSearchUrl === '') {
					window.location.search = hashUrl.search;
				}
			}
		})
		();
	} 
	else {
		if (document.styleSheets.length > 0 && document.styleSheets[document.styleSheets.length-1].cssRules) {
			document.styleSheets[document.styleSheets.length-1].insertRule(
					'.asp_check .fake-header, 
					.asp_check .category-list, 
					.asp_check .footer { display: none; }',
					document.styleSheets[document.styleSheets.length-1].cssRules.length);
		}
	}
</script>
<!-- End location.search generate Code -->
<!-- Start optimizely Code -->
<script src="//cdn.optimizely.com/js/9026702317.js"></script>
<!-- End optimizely Code -->
<!--Start Facebook  Pixel  Code -->
<script>
	/* eslint-disable */
	!function(f,b,e,v,n,t,s){if(f.fbq)return;n=f.fbq=function(){n.callMethod?n.callMethod.apply(n,arguments):n.queue.push(arguments)};if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';n.queue=[];t=b.createElement(e);t.async=!0;t.src=v;s=b.getElementsByTagName(e)[0];s.parentNode.insertBefore(t,s)}(window,document,'script','//connect.facebook.net/en_US/fbevents.js');fbq('init', '1041485915908980');
	/* eslint-enable */
</script>
<!-- 
	<noscript> 태그는 브라우저에서 <script> 태그가 작동하지 않을 때 대신 내보낼 내용을 담기 위해 쓰인다.
 -->
<noscript>
	<img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=1041485915908980&ev=PageView&noscript=1"/>
</noscript>
<!--End Facebook  Pixel  Code --><!-- Google Analytics -->
<script>
	/* eslint-disable */
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-42635603-1', 'auto');ga('require', 'ec');/* eslint-enable */</script><!-- // --><!-- End Google Analytics --><!-- Google Tag Manager --><script>var dataLayer = [];</script><noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-NSQ8BP"height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript><script>/* eslint-disable */(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src='//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);})(window,document,'script','dataLayer','GTM-NSQ8BP');
	/* eslint-enable */
</script>
<!-- End Google Tag Manager -->
</head>

<body class="asp_check">
<%@ include file="common/top.jsp" %>
<%@ include file="common/topLocation.jsp" %>
<!--  ngview -->
<div class="category-list" ng-hide='$location.path() != "/"'>
	<div class="row">
	<!-- 이부분 까지햇음 -->
	
		<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
			<a href="/shoplist" class="thumbnail" ng-click="select_home_category('all')">
				<div class="category-title">전체보기</div>
				<img src="/resources/images/category-01.png">
			</a>
		</div>
		
		
		
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=1" class="thumbnail" ng-click="select_home_category('치킨')" ><div class="category-title">치킨</div><img src="/resources/images/category-02.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=2" class="thumbnail" ng-click="select_home_category('피자양식')"><div class="category-title" >피자/양식</div><img src="/resources/images/category-03.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=3" class="thumbnail" ng-click="select_home_category('중식')"><div class="category-title" >중국집</div><img src="/resources/images/category-04.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=4" class="thumbnail" ng-click="select_home_category('한식')"><div class="category-title" >한식</div><img src="/resources/images/category-05.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=5" class="thumbnail" ng-click="select_home_category('일식돈까스')"><div class="category-title" >일식/돈까스</div><img src="/resources/images/category-06.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?category_num=6" class="thumbnail" ng-click="select_home_category('족발보쌈')"><div class="category-title" >족발/보쌈</div><img src="/resources/images/category-07.png"></a></div>
	
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?shop_num=7" class="thumbnail" ng-click="select_home_category('분식')"><div class="category-title" >분식</div><img src="/resources/images/category-09.png"></a></div>
		<div class="col-xs-6 col-sm-4 col-md-4"><a href="/shoplist?shop_num=100" class="thumbnail" ng-click="select_home_category('기타')"><div class="category-title" >기타</div><img src="/resources/images/category-convenience-store.png"></a></div>
	</div>
</div>


<%@ include file="common/footer.jsp" %>

</body>
</html>