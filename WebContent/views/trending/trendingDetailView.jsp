<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.stylecast.theme.model.vo.*, com.stylecast.daily.model.vo.*, java.text.SimpleDateFormat"%>
<%
	Daily d = (Daily)request.getAttribute("d");
	// 데일리번호, 회원번호, 데일리내용, 작성일, 이미지경로, 태그, 회원닉네임, 프로필이미지경로
	Theme m = (Theme)request.getAttribute("m");
	ArrayList<Item> iList = (ArrayList<Item>)request.getAttribute("iList");
	ArrayList<Daily> dlist = (ArrayList<Daily>)request.getAttribute("dlist");
	
	int likeYN = (int)request.getAttribute("likeYN");
	int bookmarkYN = (int)request.getAttribute("bookmarkYN");
	
	int likeCount = (int)request.getAttribute("likeCount");
	int bookmarkCount = (int)request.getAttribute("bookmarkCount");
	
	String tag = d.getTag();
	String[] tags = tag.split("#");
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
	font-family: 'Noto Sans KR', sans-serif;
    font-weight: 300;
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

#profile_img {
	width: 70px;
	height: 70px;
	left: 10px;
}

#profile_img img {
	width: 100%;
	height: 100%;
}

#userid {
	top: 23px;
	left: 90px;
	font-size: 17px;
	font-weight: 500;
}

#like {
	width: 64px;
	height: 30px;
	top: 5px;
	right: 75px;
}

#like_button {
	background: url("resources/images/react_icon/sun.svg") no-repeat;
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
	background: url("resources/images/react_icon/bookmark.svg") no-repeat;
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
	font-weight: 500;
	top: 41px;
	right: 15px;
	text-align: right;
}

#post_no {
	width: 75px;
	height: 20px;
	font-size: 13px;
	font-weight: 500;
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

#tag a{
	color: #4b70fd;
	cursor: pointer;
	text-decoration: none;}

#line {
	position: relative;
	top: 245px;
}

#item_title {
	position: absolute;
	top: 260px;
	left: 10px;
	font-size: 16px;
	font-weight: 500;
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
	font-weight: 500;
	margin-top: 30px;
	margin-left: 100px;
}

#other_wrapper {
	position: absolute;
	margin-top: 30px;
	margin-left: 100px;
}

.theme_post {
	width: 230px;
	height: 300px;
	float: left;
	margin-right: 25px;
}

.theme_post>img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	border: 0.5px solid whitesmoke;
	border-radius: 3%;;
}

#font_trending{
	color: rgb(241, 196, 15);
}

#like_button:hover {
	background: url("resources/images/react_icon/sun_yellow.svg") no-repeat;
	background-size: cover;
	cursor: pointer;
}

#bookmark_button:hover {
	background: url("resources/images/react_icon/bookmark_blue.svg") no-repeat;
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

	<%@ include file="../common/menubar.jsp"%>

	<div class="wrap">

		<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); %>
		<% if(loginUser != null) { %>
		<input type="hidden" id="loginUserNo"
			value="<%=loginUser.getMemNo()%>">
		<% } %>
		<div id="content">
			<div id="content_1">
				<div id="img_box">
					<img src="<%= contextPath %><%= d.getDailyImg() %>" alt="">
				</div>
			</div>
			<div id="content_2">
				<div id="daily_post">
					<div id="profile_img">
						<img src="<%= contextPath %><%= d.getProfImg() %>" class="rounded-circle">
					</div>
					<div id="userid"><%= d.getMemName() %></div>
					<% if(loginUser != null) { %>
					<!-- 로그인 유저 -->
					<div id="like">
						<input type="button" name="" id="like_button">
						<div>215</div>
					</div>
					<div id="bookmark">
						<input type="button" name="" id="bookmark_button">
						<div>117</div>
					</div>
					<% }else { %>
					<!-- 비로그인 유저 -->
					<div id="like">
						<%if(likeYN > 0){ %> <!-- 좋아요 등록o -->
                        	<input type="button" name="" id="like_button"
                        	style="background: url('resources/images/react_icon/sun_yellow.svg') no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;">
                        	<div><%=likeCount %></div>
                        <%}else{ %> <!-- 좋아요 등록x -->
                        	<input type="button" name="" id="like_button"
                        	style="background: url('resources/images/react_icon/sun.svg') no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;">
                        	<div><%=likeCount %></div>
                        <%} %>
					</div>
					<div id="bookmark">
						<%if(bookmarkYN > 0){ %> <!-- 북마크 등록o -->
                        	<input type="button" name="" id="bookmark_button"
                        	style="background: url('resources/images/react_icon/bookmark_blue.svg') no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;">
                        	<div><%=bookmarkCount %></div>
                        <% }else{ %> <!-- 북마크 등록x -->
                        	<input type="button" name="" id="bookmark_button"
                        	style="background: url('resources/images/react_icon/bookmark.svg') no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;">
                        	<div><%=bookmarkCount %></div>
                        <%} %>
					</div>
					<% } %>
					<div id="date"><%= simpleDateFormat.format(d.getEnrDate()) %></div>
					<div id="post_no">
						No.
						<%= d.getDailyNo() %></div>
					<div id="post_content"><%= d.getDailyContent() %></div>
					<div id="tag">

						<% for(int i=1; i<tags.length; i++) { %>
						<a>#<%= tags[i] %></a>
						<% } %>
					</div>
					<hr id="line">
					<div id="item_title">코디에 사용된 아이템</div>
					<div id="item">
						<% for(Item it : iList) { %>
						<div class="item_info"
							onclick="location.href='<%= it.getItemLink() %>';">
							<% if (it.getItemCategory().equals("상의")) {%>
							<img src="resources/images/cloth_icon/top.svg">
							<% }else if(it.getItemCategory().equals("하의")) {%>
							<img src="resources/images/cloth_icon/bottom.svg">
							<% }else if(it.getItemCategory().equals("신발")) {%>
							<img src="resources/images/cloth_icon/shoes.svg">
							<% }else if(it.getItemCategory().equals("기타")) {%>
							<img src="resources/images/cloth_icon/etc.svg">
							<% } %>
							<div><%= it.getItemName() %></div>
						</div>
						<% } %>
					</div>
				</div>
				<% if(loginUser != null && loginUser.getMemNo() == d.getMemNo()) { %>
				<!-- 작성자 본인일 때 -->
				<button class="btn btn-secondary btn-sm">수정</button>
				<button class="delete btn btn-secondary btn-sm"
					data-bs-toggle="modal" data-bs-target="#deleteModal">삭제</button>
				<% }else if (loginUser != null) { %>
				<!-- 작성자 본인이 아닐 때 -->
				<button id="report_bt" class="report btn btn-secondary btn-sm"
					data-bs-toggle="modal" data-bs-target="#reportModal">신고</button>
				<input type="hidden" name="loginUser"
					value="<%= loginUser.getMemNo() %>"> <input type="hidden"
					name="writeUser" value="<%= d.getMemNo() %>"> <input
					type="hidden" name="reportDailyNo" value="<%= d.getDailyNo() %>">
				<% } %>
			</div>
			<div id="content_3">
				<div id="bottom_title">'<%= m.getThemeTitle() %>' 테마의 다른 코디</div>
				<div id="other_wrapper">
					<% for(Daily a : dlist) { %>
						<div class="theme_post">
							<input type="hidden" value="<%= a.getDailyNo() %>">
							<img src="<%= contextPath %><%= a.getDailyImg() %>">
						</div>
					<% } %>
				</div>
			</div>
		</div>
	</div>
    
    <script>

		var lStatus = <%=likeYN%>;
		var bStatus = <%=bookmarkYN%>;
	
	    $(function(){
	    	selectLbCount();
	    	selectLbYn();
		})
    </script>
    
    <!-- 태그 검색 -->
    <script>
    	$("#tag a").click(function(){
    		
    		var text = $(this).text().substring(1);
    		
    		location.href = "<%=contextPath%>/search.ma?search_text=" + text + "&&tagYn=Y&&currentPage=1";
    	})
    </script>
    
    <!-- 북마크수 조회 -->
    <script>
    	function selectLbCount(){
    		
    		<% if(loginUser != null) {%>
    			console.log("dd");
    			$.ajax({
            		url:"bookmarkCount.do",
            		data:{
            			memNo:<%=loginUser.getMemNo()%>,
            			dailyNo:<%=d.getDailyNo()%>
            		},
            		type:"post",
            		success:function(daily){ // 성공시 실행 함수
        				$("#like>div").html(daily.likeCount);
        				$("#bookmark>div").html(daily.bookmarkCount);
            		},error:function(){ // 실패시 실행 함수
            			console.log("좋아요/북마크수 조회 실패");
            		}
            	})
            <%} %>
    	}
    </script>
    
    
    
    <!-- 북마크 여부 확인 -->
    <script>
    	function selectLbYn(){
    		<% if(loginUser != null) {%>
	    		$.ajax({
	    			url:"bookmarkYn.do",
	        		data:{
	        			memNo:<%=loginUser.getMemNo()%>,
	        			dailyNo:<%=d.getDailyNo()%>
	        		},
	        		type:"post",
	        		success:function(daily){ // 성공시 실행 함수
	        			if(daily.likeCount > 0){
	        				$("#like>input").css({"background" : "url('resources/images/react_icon/sun_yellow.svg') no-repeat"
			  								 , "background-size" : "cover"
						       				 , "position" : "absolute"
						       				 , "border" : "0px"
						       				 , "width" : "30px"
						       				 , "height" : "30px"});
	        			}else{
	        				$("#like>input").css({"background" : "url('resources/images/react_icon/sun.svg') no-repeat"
			       							 , "background-size" : "cover"
						       				 , "position" : "absolute"
						       				 , "border" : "0px"
						       				 , "width" : "30px"
						       				 , "height" : "30px"});
	        			}
	        		
	        			if(daily.bookmarkCount > 0){
	        				$("#bookmark>input").css("background", "url('resources/images/react_icon/bookmark_blue.svg') no-repeat")
							       				 .css("background-size", "cover")
							       				 .css("position", "absolute")
							       				 .css("border", "0px")
							       				 .css("width", "30px")
							       				 .css("height", "30px");
	        			}else{
	        				$("#bookmark>input").css("background", "url('resources/images/react_icon/bookmark.svg') no-repeat")
							       				 .css("background-size", "cover")
							       				 .css("position", "absolute")
							       				 .css("border", "0px")
							       				 .css("width", "30px")
							       				 .css("height", "30px");
	        			}
	        			
	    				lStatus = daily.likeCount;
	    				bStatus = daily.bookmarkCount;
	        		},error:function(){ // 실패시 실행 함수
	        			console.log("좋아요/북마크 여부 조회 실패");
	        		}
	    		})
            <%} %>
    	}
    </script>
    
    <!-- 좋아요 등록 / 삭제 -->
    <script>
	    $("#like_button").click(function(){
	    	<% if(loginUser == null) {%>
	    		alert("로그인한 회원만 가능한 서비스입니다.");
	    	<%}else { %>
		    	if(lStatus > 0){ // 좋아요 삭제
		    		$.ajax({
		        		url:"likeDelete.do",
		        		data:{
		        			memNo:<%=loginUser.getMemNo()%>,
		        			dailyNo:<%=d.getDailyNo()%>
		        		},
		        		type:"post",
		        		success:function(result){ // 성공시 실행 함수
		        			console.log(result + "삭제");
		        			selectLbCount();
		        			selectLbYn();
		        		},error:function(){ // 실패시 실행 함수
		        			alert("좋아요 삭제에 실패했습니다.");
		        		}
		        	});
		    	}else{ // 좋아요 등록
		    		$.ajax({
		        		url:"like.do",
		        		data:{
		        			memNo:<%=loginUser.getMemNo()%>,
		        			dailyNo:<%=d.getDailyNo()%>
		        		},
		        		type:"post",
		        		success:function(result){ // 성공시 실행 함수
		        			console.log(result + "등록");
		        			selectLbCount();
		        			selectLbYn();
		        		},error:function(){ // 실패시 실행 함수
		        			alert("좋아요 등록에 실패했습니다.");
		        		}
		        	});
		    	}
		    <%} %>
		})
    </script>
    
    <!-- 북마크 등록 / 삭제 -->
    <script>
	    $("#bookmark_button").click(function(){
	    	<% if(loginUser == null) {%>
    			alert("로그인한 회원만 가능한 서비스입니다.");
    		<%}else { %>
		    	if(bStatus > 0){ // 북마크 삭제
		    		$.ajax({
		        		url:"bookmarkDelete.do",
		        		data:{
		        			memNo:<%=loginUser.getMemNo()%>,
		        			dailyNo:<%=d.getDailyNo()%>
		        		},
		        		type:"post",
		        		success:function(result){ // 성공시 실행 함수
		        			console.log(result + "삭제");
		        			selectLbCount();
		        			selectLbYn();
		        		},error:function(){ // 실패시 실행 함수
		        			alert("북마크 삭제에 실패했습니다.");
		        		}
		        	});
		    	}else{ // 북마크 등록
		    		$.ajax({
		        		url:"bookmark.do",
		        		data:{
		        			memNo:<%=loginUser.getMemNo()%>,
		        			dailyNo:<%=d.getDailyNo()%>
		        		},
		        		type:"post",
		        		success:function(result){ // 성공시 실행 함수
		        			console.log(result + "등록");
		        			selectLbCount();
		        			selectLbYn();
		        		},error:function(){ // 실패시 실행 함수
		        			alert("북마크 등록에 실패했습니다.");
		        		}
		        	});
		    	}
		    <%} %>
		})
    </script>

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

	    // daily click action
	    $(".theme_post").on('click', function(){
	        $(location).attr("href", "<%=contextPath%>/detail.th?tno=" + <%= m.getThemeNo() %> + "&dno=" + $(this).children().eq(0).val());
	    });
	    
        // 신고 양식 textarea 비활성화
        $(document).ready(function(){
        $("input:radio[name=report_category]").click(function(){
            if($("input[name=report_category]:checked").val() == "기타"){
                $("#report_text").attr("disabled",false);
            }else if($("input[name=report_category]:checked").val() == "욕설 및 비방" || 
                     $("input[name=report_category]:checked").val() == "지나친 홍보성 내용" ||
                     $("input[name=report_category]:checked").val() == "혐오스러움" ||
                     $("input[name=report_category]:checked").val() == "외설적임"){
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