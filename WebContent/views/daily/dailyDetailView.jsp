<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.stylecast.daily.model.vo.*"%>
<%
	Daily d = (Daily)request.getAttribute("d");
	// 데일리번호, 회원번호, 데일리내용, 작성일, 이미지경로, 태그, 회원닉네임, 프로필이미지경로
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
        div{box-sizing: border-box; border: 0px solid;}
        .wrap{width:1200px; height:1300px; margin: auto; overflow:visible;}

        .wrap>div{width:100%;}
        #content{height:88%;}

        #content>div{position: relative;}
        #content_1{width:58%; height:60%; float: left;}
        #content_2{width:42%; height:60%; float: left;}
        #content_3{width:100%; height:40%; float: right; border-top: 1px solid #eee; color: rgb(40, 40, 40);}

        #img_box, #daily_post{height:550px; position: absolute; top: 90px;}
        #img_box{width:550px; right: 30px;}
        #img_box>img{position: absolute; object-fit:cover; max-width: 100%; max-height: 100%; top:0; left: 0; right: 0; bottom: 0; margin: auto;}
        
        #daily_post{width:380px; left: 10px; position: relative; color: rgb(40, 40, 40);}
        #daily_post>div{position: absolute;}
        #profile_img{width:70px; height:70px; left: 10px;}
        #profile_img img{width: 100%; height: 100%;}
        #userid{top:23px; left: 90px; font-size: 17px; font-weight: 600;}
        
        #like{width:64px; height:30px; top:5px; right: 75px;}
        #like_button{background: url("resources/images/react_icon/sun.svg") no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;}
        #like>div{position: absolute; top:3px; left: 35px; font-size: 14px;}
        #bookmark{width:60px; height:30px; top:5px; right: 11px;}
        #bookmark_button{background: url("resources/images/react_icon/bookmark.svg") no-repeat; background-size: cover; position: absolute; border:0px; width:30px; height: 30px;}
        #bookmark>div{position: absolute; top:3px; left: 31px; font-size: 14px;}
        #date{width:75px; height: 20px; font-size:13px; font-weight: 700; top:41px; right:15px; text-align: right;}
        #post_no{width: 75px; height: 20px; font-size: 13px; font-weight: 700; top:61px; right:15px; text-align: right;}

        #post_content{width:360px; height:90px; top:90px; left: 10px; padding: 5px;}
        #tag{width: 360px; height:60px; top:190px; left: 10px; padding: 5px;}
        #line{position: relative; top: 245px;}

        #item_title{position: absolute; top: 260px; left: 10px; font-size: 16px; font-weight: 600;}
        #item{width: 365px; height:220px; top:290px; left: 8px; overflow-y: scroll; border: 0.5px solid whitesmoke;}
        .item_info{position: relative; width:90%; height: 38px; margin: 12px 10px; }
        .item_info>img, .item_info>div {position:absolute; top: 0; bottom: 0;  margin: auto;} 
        .item_info>img{width:30px; height: 30px; float: left;}
        .item_info>div{font-size: 14px; left: 40px; height: 20px;}
        #content_2>button{width:50px; height: 30px; position: relative; top: 60px; left:275px;}
        #report_bt{margin-left: 55px;}

        #comment_wrapper{width: 970px; height: 410px; margin: 15px auto 20px auto;}
        #comment_count{width: 100%; height: 30px;}
        #comment_count span{font-size: 16px; font-weight: 700; }
        #comment_write{width: 100%; height: 70px; margin-bottom: 10px; border-bottom: 1px solid lightgray;}
        #comment_write input{float: left; width: 850px; height: 35px; margin-top:15px; margin-left: 22px; margin-right: 10px;}
        #comment_write button{width:60px; height: 35px; margin-top: 15px;}

        #comment_read_wrapper{width: 96%; height: 300px; overflow-y: scroll; margin: auto;}
        .comment_read{position: relative; width: 100%; height: 60px;}
        .comment_read>div{float: left;}
        .comment_read img{width: 40px; height: 40px; margin-top: 10px;}
        .comment_id{margin-top: 15px; margin-left: 10px; font-weight: 600; width:105px; height: 30px; overflow: hidden;}
        .comment_content{width: 630px; height: auto; max-height: 50px; position: absolute; overflow: hidden; margin-left: 10px; top: 50%; left: 51%; transform: translate(-50%, -50%);}
        .comment_report{background: url("resources/images/react_icon/flag.svg") no-repeat;  background-size: cover; margin: 17px 0px 15px 650px; border:0px; width: 25px; height:25px; margin-top: 15px; float: left; visibility: hidden;}
        .comment_delete{background: url("resources/images/react_icon/delete.svg") no-repeat;  background-size: cover; margin: 17px 0px 15px 650px; border:0px; width: 25px; height:25px; margin-top: 15px; float: left; visibility: hidden;}
        .comment_date{font-size: 14px; font-weight: 600; margin-top: 15px; margin-left: 10px;}

        #like_button:hover{background: url("resources/images/react_icon/sun_yellow.svg") no-repeat;  background-size: cover; cursor: pointer;}
        #bookmark_button:hover{background: url("resources/images/react_icon/bookmark_blue.svg") no-repeat;  background-size: cover; cursor: pointer;}

        .comment_report:hover{background: url("resources/images/react_icon/flag_red.svg") no-repeat;  background-size: cover; cursor: pointer;}
        .comment_delete:hover{background: url("resources/images/react_icon/delete_red.svg") no-repeat;  background-size: cover; cursor: pointer;}

    </style>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    
    <div class="wrap">
    
    	<%@ include file="../common/menubar.jsp" %>

        <div id="content">
            <div id="content_1">
                <div id="img_box">
                    <img src="<%= d.getDailyImg() %>" alt="">
                </div>
            </div>
            <div id="content_2">
                <div id="daily_post">
                    <div id="profile_img">
                        <img src="<%= d.getProfImg() %>" alt="">
                    </div>
                    <div id="userid"><%= d.getMemName() %></div>
                    <!-- 로그인 유저 -->
                    <div id="like">
                        <input type="button" name="" id="like_button">
                        <div>215</div>
                    </div>
                    <div id="bookmark">
                        <input type="button" name="" id="bookmark_button">
                        <div>117</div>
                    </div>
                    <!-- 비로그인 유저
                    <div id="like">
                        <input type="button" name="" id="like_button" data-bs-toggle="modal" data-bs-target="#logoutUserModal">
                        <div>215</div>
                    </div>
                    <div id="bookmark">
                        <input type="button" name="" id="bookmark_button" data-bs-toggle="modal" data-bs-target="#logoutUserModal">
                        <div>117</div>
                    </div>
                    -->
                    <div id="date"><%= d.getEnrDate() %></div>
                    <div id="post_no">No. <%= d.getDailyNo() %></div>
                    <div id="post_content"><%= d.getDailyContent() %></div>
                    <div id="tag">

                    	<% for(int i=1; i<tags.length; i++) { %>
                        	<a href="">#<%= tags[i] %></a>
                        <% } %>
                    </div>
                    <hr id="line">
                    <div id="item_title">코디에 사용된 아이템</div>
                    <div id="item">
                        <div class="item_info">
                            <img src="resources/cloth_icon/top.svg" alt="">
                            <div>스트라이프 하늘색 셔츠</div>
                        </div>
                        <div class="item_info">
                            <img src="resources/cloth_icon/top.svg" alt="">
                            <div>흰 반팔 티셔츠</div>
                        </div>
                        <div class="item_info">
                            <img src="resources/cloth_icon/bottom.svg" alt="">
                            <div>워싱 데님 반바지</div>
                        </div>
                        <div class="item_info">
                            <img src="resources/cloth_icon/etc.svg" alt="">
                            <div>골드 팬던트 목걸이</div>
                        </div> 
                    </div>
                </div>
                <!-- 작성자 본인이 아닐 때 -->
                <button id="report_bt" class="report btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#reportModal">신고</button>
                <!-- 수정 .getMemNo() --><input type="hidden" name="loginUser" value="<%= loginUser %>"> 
	            <input type="hidden" name="writeUser" value="<%= d.getMemNo() %>">
	            <input type="hidden" name="reportDailyNo" value="<%= d.getDailyNo() %>">
            </div>
            <div id="content_3">
                <div id="comment_wrapper">
                    <div id="comment_count">
                        <span>댓글</span>
                        <span>(3)</span>
                    </div>
                    <div id="comment_write"> 
                        <form action="" method="post">
                            <!-- 로그인이 되어있을 경우 -->
                            <input type="text" class="form-control" placeholder="댓글을 입력해주세요">
                            <button type="submit" class="btn btn-secondary btn-sm">입력</button>
                            <!-- 로그인 되어있지 않을 경우
                            <input type="text" class="form-control" placeholder="로그인 후 이용가능한 서비스입니다" readonly>
                            <button type="submit" class="btn btn-secondary btn-sm" disabled>입력</button>
                            -->
                        </form>
                    </div>
                    <div id="comment_read_wrapper">
                        <!-- 댓글 작성자 본인일 때 -->
                        <div class="comment_read">
                            <div><img src="resources/profile.png" alt=""></div>
                            <div class="comment_id">user01</div>
                            <div class="comment_content">
                                댓글 내용입니다
                                <br>
                                댓글 내용이 길어서 두줄입니다
                            </div>
                            <input type="button" class="comment_delete">
                            <div class="comment_date">21. 04. 02</div>
                        </div>
                        <!-- 댓글 작성자 본인이 아닐 때-->
                        <div class="comment_read">
                            <div><img src="resources/profile.png" alt=""></div>
                            <div class="comment_id">user02</div>
                            <div class="comment_content">
                                댓글 내용입니다
                            </div>
                            <input type="button" class="comment_report report" data-bs-toggle="modal" data-bs-target="#reportModal">
                            <div class="comment_date">21. 04. 03</div>
                        </div>
                        <div class="comment_read">
                            <div><img src="resources/profile.png" alt=""></div>
                            <div class="comment_id">user03</div>
                            <div class="comment_content">
                                댓글 내용입니다
                            </div>
                            <input type="button" class="comment_report report" data-bs-toggle="modal" data-bs-target="#reportModal">
                            <div class="comment_date">21. 04. 03</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
            <h5 class="modal-title" id="reportModalLabel">신고</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="<%=contextPath%>/report.da" method="post" style="line-height: 30px;">
                	<!-- 회원번호, 피신고회원번호, 내용(널러블), 게시판카테고리(0), 데일리번호, 신고카테고리 -->
					<input type="hidden" id="memNo" name="memNo" value="">
					<input type="hidden" id="rMemNo" name="rMemNo" value="">
					<input type="hidden" id="dailyNo" name="dailyNo" value="">
					<input type="hidden" id="currentUrl" name="currentUrl" value="">
                    <input type="radio" name="report_category" value="욕설 및 비방" checked>&nbsp;욕설 및 비방<br>
                    <input type="radio" name="report_category" value="지나친 홍보성 내용">&nbsp;지나친 홍보성 내용<br>
                    <input type="radio" name="report_category" value="혐오스러움">&nbsp;혐오스러움<br>
                    <input type="radio" name="report_category" value="외설적임">&nbsp;외설적임<br>
                    <input type="radio" name="report_category" value="기타">&nbsp;기타<br>
                    <textarea name="report_text" id="report_text" rows="3" class="form-control" placeholder="기타 신고 사유를 입력해주세요" style="resize: none;" disabled=true;></textarea>
                    <br>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin-left: 120px;">취소</button>
                    
                    <button type="submit" class="btn btn-primary" style="width: 90px; margin-left: 50px;">보내기</button>
                </form>
            </div>
        </div>
        </div>
    </div>
    
    <!-- 게시글 삭제 확인-->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="deleteModalLabel">삭제</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p>이 게시글을 삭제하시겠습니까?</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary">확인</button>
            </div>
          </div>
        </div>
    </div>

    <!-- 비로그인 유저 action 클릭 -->
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
              <button type="button" class="btn btn-primary">확인</button>
            </div>
          </div>
        </div>
    </div>

      

    <script>
        // 댓글 신고 버튼 호버
        $(document).ready(function(){
    	$(".comment_read").hover(function(){
    		$(this).children(".comment_report").css("visibility", "visible");
    	}, function(){
    		$(this).children(".comment_report").css("visibility", "hidden");
    	})
        });
        
        // 댓글 삭제 버튼 호버
        $(document).ready(function(){
    	$(".comment_read").hover(function(){
    		$(this).children(".comment_delete").css("visibility", "visible");
    	}, function(){
    		$(this).children(".comment_delete").css("visibility", "hidden");
    	})
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
        
        // 모달에 값 전달 
        $('.report').on('click', function(){
            //$("#memNo").val($(this).siblings('input[name=loginUser]').val());
            $("#rMemNo").val($(this).siblings('input[name=writeUser]').val());
            $("#dailyNo").val($(this).siblings('input[name=reportDailyNo]').val());
            $("#currentUrl").val($(location).attr('href'));
            
			console.log($("#rMemNo").val());
			console.log($("#dailyNo").val());
            console.log($("#currentUrl").val());
            
         })
         
    </script>

    

</body>
</html>