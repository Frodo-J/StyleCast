<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.SimpleDateFormat" %>
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
	border: 0px solid;
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

#content>div {
	position: relative;
}

#content_1 {
	width: 58%;
	height: 60%;
	float: left;
}

#content_2 {
	width: 42%;
	height: 60%;
	float: left;
}

#content_3 {
	width: 100%;
	height: 40%;
	float: right;
	border-top: 1px solid #eee;
	color: rgb(40, 40, 40);
}

#img_box, #daily_post {
	height: 550px;
	position: absolute;
	top: 90px;
}

#img_box {
	width: 550px;
	right: 30px;
}

#img_box>img {
	position: absolute;
	object-fit: cover;
	max-width: 100%;
	max-height: 100%;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
}

#daily_post {
	width: 380px;
	left: 10px;
	position: relative;
	color: rgb(40, 40, 40);
}

#daily_post>div {
	position: absolute;
}

#profile {
	width: 70px;
	height: 70px;
	left: 10px;
}

#profile_img {
	width: 100%;
	height: 100%;
}

#userid {
	top: 23px;
	left: 90px;
	font-size: 17px;
	font-weight: 600;
}

#like {
	width: 64px;
	height: 30px;
	top: 5px;
	right: 75px;
}

#like_button {
	background: url("resources/react_icon/sun.svg") no-repeat;
	background-size: cover;
	position: absolute;
	border: 0px;
	width: 30px;
	height: 30px;
}

#like>div {
	position: absolute;
	top: 3px;
	left: 35px;
	font-size: 14px;
}

#bookmark {
	width: 60px;
	height: 30px;
	top: 5px;
	right: 11px;
}

#bookmark_button {
	background: url("resources/react_icon/bookmark.svg") no-repeat;
	background-size: cover;
	position: absolute;
	border: 0px;
	width: 30px;
	height: 30px;
}

#bookmark>div {
	position: absolute;
	top: 3px;
	left: 31px;
	font-size: 14px;
}

#date {
	width: 75px;
	height: 20px;
	font-size: 13px;
	font-weight: 700;
	top: 41px;
	right: 15px;
	text-align: right;
}

#post_no {
	width: 75px;
	height: 20px;
	font-size: 13px;
	font-weight: 700;
	top: 61px;
	right: 15px;
	text-align: right;
}

#post_content {
	width: 360px;
	height: 90px;
	top: 90px;
	left: 10px;
	padding: 5px;
}

#tag {
	width: 360px;
	height: 60px;
	top: 190px;
	left: 10px;
	padding: 5px;
}

#line {
	position: relative;
	top: 245px;
}

#item_title {
	position: absolute;
	top: 260px;
	left: 10px;
	font-size: 16px;
	font-weight: 600;
}

#item {
	width: 365px;
	height: 220px;
	top: 290px;
	left: 8px;
	overflow-y: scroll;
	border: 0.5px solid whitesmoke;
}

.item_info {
	position: relative;
	width: 90%;
	height: 38px;
	margin: 12px 10px;
	cursor: pointer;
}

.item_info>img, .item_info>div {
	position: absolute;
	top: 0;
	bottom: 0;
	margin: auto;
}

.item_info>img {
	width: 30px;
	height: 30px;
	float: left;
}

.item_info>div {
	font-size: 14px;
	left: 40px;
	height: 20px;
}

#content_2>button {
	width: 50px;
	height: 30px;
	position: relative;
	top: 60px;
	left: 275px;
}

#report_bt {
	margin-left: 55px;
}

#bottom_title {
	width: 30%;
	font-size: 18px;
	font-weight: 600;
	margin-top: 30px;
	margin-left: 100px;
}

.theme_post {
	width: 230px;
	height: 300px;
	float: left;
	margin-top: 30px;
	margin-left: 25px;
}

.theme_post>img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	border: 0.5px solid whitesmoke;
	border-radius: 3%;;
}

#theme_p1 {
	margin-left: 100px;
}

#like_button:hover {
	background: url("resources/react_icon/sun_yellow.svg") no-repeat;
	background-size: cover;
	cursor: pointer;
}

#bookmark_button:hover {
	background: url("resources/react_icon/bookmark_blue.svg") no-repeat;
	background-size: cover;
	cursor: pointer;
}

.theme_post:hover {
	opacity: 0.8;
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
		<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); %> 
		

		<div id="content">
			<div id="content_1">
				<div id="img_box">
					<img src="resources/img_codi5.jpg" alt="">
				</div>
			</div>
			<div id="content_2">
				<div id="daily_post">
					<div id="profile">
						<img id="profile_img" src="resources/profile.png" alt="">
					</div>
					<div id="userid">nickname</div>
					<div id="like">
						<input type="button" name="" id="like_button">
						<div>215</div>
					</div>
					<div id="bookmark">
						<input type="button" name="" id="bookmark_button">
						<div>117</div>
					</div>
					<div id="date">simpleDateFormat.format()21. 04. 01</div>
					<div id="post_no">No. 1</div>
					<div id="post_content">í¬ì¤í¸ ë´ì©</div>
					<div id="tag">
						<a href="">#ìì¼ì½ë</a> <a href="">#ì½í¼í¬ì¸ </a> <a
							href="">#íëì</a> <a href="">#í°ì</a>
					</div>
					<hr id="line">
					<div id="item_title">ì½ëì ì¬ì©ë ìì´í</div>
					<div id="item">
						<div class="item_info">
							<img src="resources/cloth_icon/top.svg" alt="">
							<div>ì¸í¼ë°© í´ëì ìì¼</div>
						</div>
						<div class="item_info">
							<img src="resources/cloth_icon/top.svg" alt="">
							<div>Uë¥ ê·¸ë ì´ ëí¸</div>
						</div>
						<div class="item_info">
							<img src="resources/cloth_icon/bottom.svg" alt="">
							<div>íì´í¸ ì½í¼ í¬ì¸ </div>
						</div>
						<div class="item_info">
							<img src="resources/cloth_icon/shoes.svg" alt="">
							<div>íì´í¸ íë« ìì¦</div>
						</div>
						<div class="item_info">
							<img src="resources/cloth_icon/etc.svg" alt="">
							<div>ë³¼ë ì¤ë² ì´ì´ë§</div>
						</div>
					</div>
				</div>
				<% if (loginUser != null) { %>
				<!-- 작성자 본인이 아닌 회원일 때 -->
				<button id="report_bt" class="report btn btn-secondary btn-sm"
					data-bs-toggle="modal" data-bs-target="#reportModal">신고</button>
				<input type="hidden" name="loginUser"
					value="<%= loginUser.getMemNo() %>"> <input type="hidden"
					name="writeUser" value="<%= d.getMemNo() %>"> <input
					type="hidden" name="reportDailyNo" value="<%= d.getDailyNo() %>">
				<% } %>
			</div>
			<div id="content_3">
				<div id="bottom_title">ë² ì¤í¸ 30 íë§ì ë¤ë¥¸ ê²ìê¸</div>
				<div id="theme_p1" class="theme_post">
					<img src="resources/img_codi6.jpg" alt="">
				</div>
				<div class="theme_post">
					<img src="resources/img_codi22.jpg" alt="">
				</div>
				<div class="theme_post">
					<img src="resources/img_codi10.jpg" alt="">
				</div>
				<div class="theme_post">
					<img src="resources/img_codi23.jpg" alt="">
				</div>
			</div>
		</div>
	</div>

	<!-- 게시글 신고 Modal -->
	<div class="modal fade" id="reportModal" tabindex="-1"
		aria-labelledby="reportModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="reportModalLabel">게시글 신고</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="<%=contextPath%>/report.da" method="post"
						style="line-height: 30px;">
						<!-- 회원번호, 피신고회원번호, 내용(널러블), 게시판카테고리(0), 데일리번호, 신고카테고리 -->
						<input type="hidden" id="memNo" name="memNo" value=""> <input
							type="hidden" id="rMemNo" name="rMemNo" value=""> <input
							type="hidden" id="dailyNo" name="dailyNo" value=""> <input
							type="hidden" id="currentUrl" name="currentUrl" value="">
						<input type="radio" name="report_category" value="욕설 및 비방" checked>&nbsp;욕설
						및 비방<br> <input type="radio" name="report_category"
							value="지나친 홍보성 내용">&nbsp;지나친 홍보성 내용<br> <input
							type="radio" name="report_category" value="혐오스러움">&nbsp;혐오스러움<br>
						<input type="radio" name="report_category" value="외설적임">&nbsp;외설적임<br>
						<input type="radio" name="report_category" value="기타">&nbsp;기타<br>
						<textarea name="report_text" id="report_text" rows="3"
							class="form-control" placeholder="기타 신고 사유를 입력해주세요"
							style="resize: none;" disabled=true;></textarea>
						<br>
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal" style="width: 90px; margin-left: 120px;">취소</button>

						<button type="submit" class="btn btn-primary"
							style="width: 90px; margin-left: 50px;">보내기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 비로그인 유저 action 클릭 Modal -->
	<div class="modal fade" id="logoutUserModal" tabindex="-1"
		aria-labelledby="logoutUserModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="logoutUserModalLabel">로그인 요청</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>로그인 후 이용가능한 서비스입니다. 로그인 하시겠습니까?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='<%=contextPath%>/loginPage.me'">확인</button>
				</div>
			</div>
		</div>
	</div>

	<script>

        // 신고 양식 textarea 비활성화
        $(document).ready(function(){
        $("input:radio[name=report_category]").click(function(){
            if($("input[name=report_category]:checked").val() == "ê¸°í"){
                $("#report_text").attr("disabled",false);
            }else if($("input[name=report_category]:checked").val() == "ìì¤ ë° ë¹ë°©" || 
                     $("input[name=report_category]:checked").val() == "ì§ëì¹ íë³´ì± ë´ì©" ||
                     $("input[name=report_category]:checked").val() == "íì¤ì¤ë¬ì" ||
                     $("input[name=report_category]:checked").val() == "ì¸ì¤ì ì"){
                $("#report_text").attr("disabled",true);
            }
        })
        });
        
        // 게시글 신고 모달에 값 전달 
        $('.report').on('click', function(){
            $("#memNo").val($(this).siblings('input[name=loginUser]').val());
            $("#rMemNo").val($(this).siblings('input[name=writeUser]').val());
            $("#dailyNo").val($(this).siblings('input[name=reportDailyNo]').val());
            $("#currentUrl").val($(location).attr('href'));
         });

    </script>

</body>
</html>