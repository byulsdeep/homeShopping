<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./css/reset.css"><!-- list.do -->
<link rel="stylesheet" href="../css/reset.css"><!-- index.jsp -->
<link rel="stylesheet" href="./css/style.css"><!-- list.do -->
<link rel="stylesheet" href="../css/style.css"><!-- index.jsp -->
<!-- servlet으로 접근할땐 위에꺼가 먹히고 페이지에 직접 이동 할땐 아래꺼가 먹힘 
css 폴더 없애기 추천 -->
</head>
<body>
	<div id="wrap">
		<header>
			<h1>쇼핑몰 회원관리</h1>
			<nav>
				<div class="nav_menu">
					<a href="moveSignUp.do">회원등록</a>
				</div>
				<div class="nav_menu">
					<a href="list.do">회원목록조회/수정</a>
				</div>
				<div class="nav_menu">
					<a href="sales.do">회원매출조회</a>
				</div>
				<div class="nav_menu">
					<!-- <a href="./index.jsp">홈으로</a> -->
					<a href="home.do">홈으로</a>
<!-- 첫번째 접속은 성공하나, 한번 더 클릭하면 view/view/idnex.jsp로 됨. 
css 폴더 없이 WebContent에 직접 접근으로 변경 추천 -->
				</div>
			</nav>
		</header>
