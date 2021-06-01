<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.stylecast.theme.model.vo.*, java.util.ArrayList"%>
<%
	Theme t = (Theme)request.getAttribute("t");
	ArrayList<ThemePost> tlist = (ArrayList<ThemePost>)request.getAttribute("tlist");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
div {
	box-sizing: border-box;
}

.wrap {
	width: 1200px;
	height: 1300px;
	margin: auto;
}

.wrap>div {
	width: 100%;
}

#content {
	height: 88%;
}

#content_1 {
	width: 100%;
	height: 70%;
	position: relative;
}

#content_2 {
	width: 100%;
	height: 30%;
	border-top: 1px solid #eee;
}

#title_content {
	width: 1140px;
	height: 100px;
	top: 10px;
	left: 30px;;
	position: absolute;
	color: rgb(40, 40, 40);
}

#title {
	width: 60%;
	font-size: 30px;
	font-weight: 700;
	margin-top: 26px;
	margin-left: 42px;
	float: left;
}

#week {
	width: auto;
	height: auto;
	font-size: 15px;
	font-weight: 700;
	margin: 40px 0px 0px 280px;
	text-align: center;
	float: left;
}

#post_content {
	width: 1137px;
	height: 660px;
	margin-top: 125px;
	margin-left: 30px;
	overflow-y: scroll;
	position: absolute;
}

.post {
	width: 240px;
	height: 310px;
	float: left;
	margin: 12px 0px 10px 32px;
	position: relative;
}

.post>img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	border-radius: 3%;
	border: 0.5px solid whitesmoke;
}

.like_count {
	width: 60%;
	font-size: 16px;
	font-weight: 700;
	color: white;
	text-shadow: 1px 1px 2px gray;
	position: absolute;
	left: 12px;
	bottom: 20px;
}

.like_button {
	background: url("resources/images/react_icon/sun2.svg") no-repeat;
	background-size: cover;
	border: 0px;
	width: 40px;
	height: 40px;
	position: absolute;
	right: 12px;
	bottom: 10px;
}

.theme {
	width: 1140px;
	height: 90px;
	margin-top: 17px;
	margin-left: 30px;
	position: relative;
	color: rgb(40, 40, 40);
}

#theme_1 {
	border: 2px solid lightgreen;
}

#theme_2 {
	border: 2px solid lightsteelblue;
}

#theme_3 {
	border: 2px solid lightsalmon;
}

.theme_title {
	font-size: 30px;
	font-weight: 700;
	position: absolute;
	left: 20px;
	top: 24px;
}

.theme_week {
	font-size: 15px;
	font-weight: 700;
	position: absolute;
	right: 20px;
	top: 35px;
}

.post:hover {
	opacity: 0.8;
	cursor: pointer;
}

.like_button:hover {
	background: url("resources/images/react_icon/sun_yellow.svg") no-repeat;
	background-size: cover;
	cursor: pointer;
}

.theme:hover {
	background: whitesmoke;
	cursor: pointer;
}
</style>
<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<div class="wrap">
	
		<%@ include file="../common/menubar.jsp"%>

		<div id="content">
			<div id="content_1">
				<div id="title_content" style="border:2px solid <%= t.getThemeTitleColor() %>">
					<div id="title"><%= t.getThemeTitle() %></div>
					<div id="week"><%= t.getThemeSubtitle() %></div>
					<input type="hidden" id="themeNo" name="tno" value="<%= t.getThemeNo() %>">
				</div>
				<div id="post_content">
					<% for(ThemePost tp : tlist) { %>
					<div class="post">
						<img src="<%= tp.getDailyImg() %>">
						<input type="hidden" value="<%= tp.getDailyNo() %>">
						<div class="like_count">받은 좋아요 0</div>
						<input type="button" class="like_button"></input>
					</div>
					<% } %>
				</div>
			</div>

			<div id="content_2">
				<div class="theme" id="theme_1">
					<div class="theme_title">제목</div>
					<div class="theme_week">4월 4주차</div>
				</div>
				<div class="theme" id="theme_2">
					<div class="theme_title">ì¤íì¼ë¦¬ì ë¬´ì±ì ì½ë</div>
					<div class="theme_week">4ì 3ì£¼ì°¨</div>
				</div>
				<div class="theme" id="theme_3">
					<div class="theme_title">ê°ì ê¸° ìì¼ ì½ë</div>
					<div class="theme_week">4ì 2ì£¼ì°¨</div>
				</div>
			</div>
		</div>
	</div>


	<script>
	
	$(document).ready(function(){
	});
	</script>
</body>
</html>