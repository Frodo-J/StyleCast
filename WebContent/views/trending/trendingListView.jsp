<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.stylecast.theme.model.vo.*, java.util.ArrayList"%>
<%
	Theme t = (Theme)request.getAttribute("t");
	ArrayList<ThemePost> plist = (ArrayList<ThemePost>)request.getAttribute("plist");
	ArrayList<Theme> tlist = (ArrayList<Theme>)request.getAttribute("tlist");
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
	font-family: 'Noto Sans KR', sans-serif;
    font-weight: 300;
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
	font-size: 28px;
	font-weight: 600;
	margin-top: 25px;
	margin-left: 42px;
	float: left;
}

#week {
	width: auto;
	height: auto;
	font-size: 15px;
	font-weight: 600;
	margin: 39px 0px 0px 315px;
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
	font-weight: 500;
	color: white;
	text-shadow: 1px 1px 2px gray;
	position: absolute;
	left: 15px;
	bottom: 21px;
}

.like_button {
	background: url("resources/images/react_icon/sun2.svg") no-repeat;
	background-size: cover;
	border: 0px;
	width: 40px;
	height: 40px;
	position: absolute;
	right: 12px;
	bottom: 12px;
}

.theme {
	width: 1140px;
	height: 90px;
	margin-top: 17px;
	margin-left: 30px;
	position: relative;
	color: rgb(40, 40, 40);
}

.theme_title {
	font-size: 28px;
	font-weight: 600;
	position: absolute;
	left: 40px;
	top: 20px;
}

.theme_week {
	font-size: 15px;
	font-weight: 600;
	position: absolute;
	right: 28px;
	top: 33px;
}

#font_trending{
	color: rgb(241, 196, 15);
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

	<%@ include file="../common/menubar.jsp"%>

	<div class="wrap">
	
		<div id="content">
			<div id="content_1">
				<div id="title_content" style="border:2px solid <%= t.getThemeTitleColor() %>">
					<div id="title"><%= t.getThemeTitle() %></div>
					<div id="week"><%= t.getThemeSubtitle() %></div>
					<input type="hidden" id="themeNo" name="tno" value="<%= t.getThemeNo() %>">
				</div>
				<div id="post_content">
					<% for(ThemePost tp : plist) { %>
					<div class="post">
						<input type="hidden" value="<%= tp.getDailyNo() %>">
						<input type="hidden" value="<%= t.getThemeNo() %>">
						<img src="<%= tp.getDailyImg() %>">
						<div class="like_count">받은 좋아요 <%= tp.getCount() %></div>
						<% if(loginUser != null) { %>
							<input type="button" class="like_button"></input>
						<% }else { %>
							<input type="button" class="like_button" data-bs-toggle="modal" data-bs-target="#logoutUserModal"></input>
						<% } %>
					</div>
					<% } %>
				</div>
			</div>

			<div id="content_2">
				<!-- 베스트와 현재 테마번호를 제외한 나머지 테마 반복문-->
				<% for(Theme th : tlist) { %>
					<div class="theme" style="border: 2px solid <%= th.getThemeTitleColor() %>" 
						 onclick="location.href='<%=contextPath%>/list.to?tpage=' + <%= th.getThemeNo() %>">
						<input type="hidden" value="<%= th.getThemeNo() %>">
						<div class="theme_title"><%= th.getThemeTitle() %></div>
						<div class="theme_week"><%= th.getThemeSubtitle() %></div>
					</div>
				<% } %>
			</div>
		</div>
	</div>

    <!-- 비로그인 유저 action 클릭 Modal-->
    <div class="modal fade" id="logoutUserModal" tabindex="-1" aria-labelledby="logoutUserModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="logoutUserModalLabel">로그인 요청</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p>로그인 후 이용가능한 서비스입니다. 로그인 하시겠습니까?</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary" onclick="location.href='<%=contextPath%>/loginPage.me'">확인</button>
            </div>
          </div>
        </div>
    </div>

	<script>
	
    // daily click action
    $(".post").click(function(){
        if(event.target.className=='like_button') return;
        $(location).attr("href", "<%=contextPath%>/detail.th?tno=" + <%= t.getThemeNo() %> + "&dno=" + $(this).children().eq(0).val());
    });
    
	</script>
</body>
</html>