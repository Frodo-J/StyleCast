<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.stylecast.common.model.vo.PageInfo, java.util.ArrayList, com.stylecast.daily.model.vo.*, java.text.SimpleDateFormat"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Daily> list = (ArrayList<Daily>)request.getAttribute("list");
	ArrayList<Report> rlist = new ArrayList<>();
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
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
	border: 0px solid gray;
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

#daily_wrapper {
	width: 95%;
	height: 95%;
	margin: auto;
	margin-top: 30px;
	position: relative;
}
/* daily style */
.daily_post {
	width: 260px;
	height: 425px;
	float: left;
	color: rgb(40, 40, 40);
	border: 0.5px solid lightgrey;
	border-radius: 2pc;
	background: whitesmoke;
	margin-top: 25px;
	margin-left: 17px;
}

.daily_img {
	position: relative;
	width: 230px;
	height: 280px;
	margin: 24px 15px 10px;
}

.daily_img>img {
	width: 230px;
	height: 280px;
	object-fit: cover;
}

.action_hover {
	position: absolute;
	width: 230px;
	height: 50px;
	bottom: 0px;
	visibility: hidden;
	background: linear-gradient(to bottom, rgba(0, 0, 0, 0.0) 0%,
		rgba(0, 0, 0, 0.2) 30%, rgba(0, 0, 0, 0.5) 70%, rgb(0, 0, 0, 0.7) 100%);
}

.action {
	float: left;
	width: 25%;
	height: 50px;
}

.action>input {
	width: 100%;
	height: 100%;
	border: 0px;
	background-size: 25px 25px;
}

.vertical-line {
	float: left;
	border-color: rgba(255, 255, 255, 0.5);
	border-style: solid;
	border-width: 0 0 0 1px;
	margin-top: 14px;
	margin-right: -1px;
	margin-bottom: 19px;
	width: 0px;
	height: 20px;
	vertical-align: middle;
}

.like {
	background: url("resources/images/react_icon/sun2.svg") no-repeat center/contain;
}

.comment {
	background: url("resources/images/react_icon/comment2.svg") no-repeat
		center/contain;
}

.bookmark {
	background: url("resources/images/react_icon/bookmark2.svg") no-repeat
		center/contain;
}

.report {
	background: url("resources/images/react_icon/flag2.svg") no-repeat
		center/contain;
}

.action_hover input:hover {
	cursor: pointer;
}

.profile {
	width: 50px;
	height: 50px;
	float: left;
	margin: 2px 11px 2px 17px;
}

.profile>img {
	width: 100%;
	height: 100%;
}

.userid {
	width: 86px;
	float: left;
	font-size: 14px;
	font-weight: 600;
	margin: 0px;
}

.date {
	float: left;
	font-size: 12px;
	font-weight: 500;
	margin: 1px 0px 1px 28px;
}

.text {
	float: left;
	font-size: 13px;
	width: 140px;
	height: 38px;
	margin: 3px 0px;
	overflow: hidden;
}

.more {
	float: left;
	background: url("resources/images/react_icon/plus.svg") no-repeat;
	width: 24px;
	height: 24px;
	margin: 12px 5px 0px 5px;
	border: 0px;
}

.react {
	float: left;
	width: 200px;
	height: 26px;
	margin: 7px 26px 7px 34px;
}

.react>div {
	float: left;
	width: 30px;
	height: 26px;
}

.react_like {
	background: url("resources/images/react_icon/sun.svg") no-repeat;
	background-size: contain;
}

.react_comment {
	background: url("resources/images/react_icon/comment.svg") no-repeat;
	background-size: contain;
}

.react_bookmark {
	background: url("resources/images/react_icon/bookmark.svg") no-repeat;
	background-size: contain;
}

.react_count {
	margin-right: 6px;
	text-align: center;
	font-size: 15px;
	font-weight: 500;
}
/* daily style end */
.add {
	position: absolute;
	top: 910px;
	right: 32px;
	cursor: pointer;
}

#navigation {
	position: absolute;
	margin-top: 970px;
	margin-left: 500px;
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
			<div id="daily_wrapper">

				<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); %>

				<% for(Daily d : list) { %>
				<div class="daily_post fadein">
					<input type="hidden" value="<%= d.getDailyNo() %>">
					<div class="daily_img">
						<img src="<%= contextPath %>/<%= d.getDailyImg() %>" alt="">
						<div class="action_hover">
							<% if(loginUser != null) { %>
							<div class="action">
								<input type="button" class="like">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="comment">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="bookmark">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="report" data-bs-toggle="modal"
									data-bs-target="#reportModal"> <input type="hidden"
									name="loginUser" value="<%= loginUser.getMemNo() %>"> <input
									type="hidden" name="writeUser" value="<%= d.getMemNo() %>">
								<input type="hidden" name="reportDailyNo"
									value="<%= d.getDailyNo() %>">
							</div>
							<% }else { %>
							<div class="action">
								<input type="button" class="like" data-bs-toggle="modal"
									data-bs-target="#logoutUserModal">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="comment">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="bookmark" data-bs-toggle="modal"
									data-bs-target="#logoutUserModal">
							</div>
							<div class="vertical-line"></div>
							<div class="action">
								<input type="button" class="report" data-bs-toggle="modal"
									data-bs-target="#logoutUserModal">
							</div>

							<% } %>
						</div>
					</div>

					<div class="profile">
						<img src="<%= contextPath %>/<%= d.getProfImg() %>" alt="">
					</div>
					<div class="userid"><%= d.getMemName() %></div>
					<div class="date"><%= simpleDateFormat.format(d.getEnrDate()) %></div>
					<div class="text"><%= d.getDailyContent() %></div>
					<input type="button" class="more" onclick="">
					<div class="react">
						<div class="react_like"></div>
						<div class="react_count">10</div>
						<div class="react_comment"></div>
						<div class="react_count">10</div>
						<div class="react_bookmark"></div>
						<div class="react_count">10</div>
					</div>
				</div>
				<% } %>

				<!-- 데일리 작성 버튼 로그인 여부 체크 -->
				<% if(loginUser != null) { %>
				<img src="https://img.icons8.com/ios-filled/50/000000/plus.png"
					class="add" onclick="location.href='03-2_데일리_작성form.html'">
				<% }else { %>
				<img src="https://img.icons8.com/ios-filled/50/000000/plus.png"
					class="add" data-bs-toggle="modal"
					data-bs-target="#logoutUserModal">
				<% } %>

				<!-- 페이징바 -->
				<div id="navigation">
					<ul class="pagination">
						<li class="page-item">
							<% if(currentPage != 1) { %> <a class="page-link prevPage"
							href="<%=contextPath%>/list.da?currentPage=<%=currentPage-1%>"
							aria-label="Previous"> <span aria-hidden="true">&lt;</span>
						</a> <% } %>
						</li>
						<% for(int p=startPage; p<=endPage; p++) { %>
						<li class="page-item">
							<% if(p != currentPage) { %> <a class="page-link"
							href="<%=contextPath%>/list.da?currentPage=<%= p %>"><%= p %></a>
							<% }else { %> <a class="page-link" href="#"><%= p %></a> <% } %>
						</li>
						<% } %>
						<li class="page-item">
							<% if (currentPage != maxPage) { %> <a class="page-link nextPage"
							href="<%=contextPath%>/list.da?currentPage=<%=currentPage+1%>"
							aria-label="Next"> <span aria-hidden="true">&gt;</span>
						</a> <% } %>
						</li>
					</ul>

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

	<!-- 비로그인 유저 action 클릭 Modal-->
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
        // daily img hover
        $(document).ready(function(){
    	$(".daily_img").hover(function(){
    		$(this).children(".action_hover").css("visibility", "visible");
    	}, function(){
    		$(this).children(".action_hover").css("visibility", "hidden");
    	})
        });
        
        // daily click action
        $(".daily_post").click(function(){
            if(event.target.className=='like' || 
               event.target.className=='bookmark' || 
               event.target.className=='report') return;
            $(location).attr("href", "<%=contextPath%>/detail.da?dno=" + $(this).children().eq(0).val());
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