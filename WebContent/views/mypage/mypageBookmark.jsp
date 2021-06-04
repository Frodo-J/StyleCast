<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.stylecast.daily.model.vo.Daily, java.text.SimpleDateFormat" %>
<%
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd");
	
	ArrayList<Daily> list = (ArrayList<Daily>)request.getAttribute("list");
	ArrayList<Daily> bList = (ArrayList<Daily>)request.getAttribute("bList");
	ArrayList<Daily> lList = (ArrayList<Daily>)request.getAttribute("lList");
	
	int[] bArr = new int[bList.size()];
	int bSize = 0;
	for(Daily bDaily : bList){
	  bArr[bSize++] = bDaily.getDailyNo();
	}
	
	int[] lArr = new int[lList.size()];
	int lSize = 0;
	for(Daily lDaily : lList){
	  lArr[lSize++] = lDaily.getDailyNo();
	}
%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!--text-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
        *{
            font-family: 'Noto Sans KR', sans-serif;
        }

        div{
            /*border: 1px solid black;*/
            box-sizing: border-box;
        }
       
        .wrap{width:1200px; height:1300px;  margin: auto;}

        #header, #content{width:100%;}
        #header{height:12%;}
        #content{height:88%; width: 90%; margin: auto;}

        #side, #mypage{float: left; height: 100%;}
        #side{width: 20%;}
        #mypage{
            width: 80%;
            height: 100%;
            padding-top: 40px;
            position: relative;
        }

        #line{width: 1.5px; height:90%; float:right; background: lightgrey;}
        #prof, #menu{width: 99%; float: left;}
        #prof{height: 17%;}
        #menu{height: 83%; padding-left: 10px;}

        /* 사이드바 상세 css */
        #prof div, #menu div{width: 100%;}
        #menu a{color: black; text-decoration: none;}

        #prof_img{height: 70%; padding: 20px; /*border: solid 1px red;*/}
        #prof_img>img{width: 100px; height: 100px;}

        #write>div{font-size: 13px; padding-left: 20px; margin-top: 8px;}
        #menu>div{margin-bottom: 15px;}

        /* 프로필 이미지 수정 모달 css */
        #prof-title h3{
            padding-top: 10px;
            font-weight: bold;
        }

        .prof-body{width: 100%; height: 63%;}

        .prof-body>div{
            height: 100%;
            float:left;
        }

        #prof-img{width: 35%; /*border: solid 1px red;*/}
        #prof-img>img{width: 100px; height: 100px;}
        #prof-delete{height: 30px;}
        #prof-input{width: 65%;}

        .prof-body button{
            width: 50px;
            margin: 15px;
        }

        /* 북마크 리스트 css */
        /*#mypage{border: 1px solid black;}*/
        #mypage div{float: left;}
        #daily_box{height: 75%; width:100%; overflow-y: scroll; position: absolute;}
        #empty_box{margin-top: 180px; margin-left: 300px;}
        
        /* daily style */
        .daily_post{width:260px; height:425px; float: left; color: rgb(40, 40, 40); border: 0.5px solid lightgrey; border-radius: 2pc; background: whitesmoke; margin-top: 25px; margin-left: 17px;}
        .daily_img{position: relative; width:230px; height:280px; margin: 24px 15px 10px;}
        .daily_img>img{width:230px; height:280px; object-fit: cover;}

        .action_hover{position: absolute; width: 230px; height:50px; bottom: 0px; visibility: hidden; 
                      background: linear-gradient(to bottom, rgba(0, 0, 0, 0.0) 0%, rgba(0, 0, 0, 0.2) 30%, rgba(0, 0, 0, 0.5) 70%, rgb(0, 0, 0, 0.7) 100%);}
        .action{float: left; width: 25%; height: 50px;}
        .action>input{width:100%; height: 100%; border:0px; background-size: 25px 25px;}
        .vertical-line{float: left; border-color: rgba(255,255,255,0.5); border-style: solid; border-width: 0 0 0 1px; 
                       margin-top: 14px; margin-right: -1px; margin-bottom: 19px; width: 0px; height: 20px; vertical-align: middle;}
        .like{background: url("resources/images/react_icon/sun2.svg") no-repeat center/contain;}
        .comment{background: url("resources/images/react_icon/comment2.svg") no-repeat center/contain;}
        .bookmark{background: url("resources/images/react_icon/bookmark2.svg") no-repeat center/contain;}
        .report{background: url("resources/images/react_icon/flag2.svg") no-repeat center/contain;}
        .action_hover input:hover{cursor: pointer;}

        .profile{width:50px; height: 50px; float: left; margin: 2px 11px 2px 17px;}
        .profile>img{width: 100%; height: 100%;}
        .userid{width:86px; float:left; font-size: 14px; font-weight: 700; margin: 0px;}
        .date{float:left; font-size: 12px; font-weight: 700; margin: 0px 0px 1px 28px;}
        .text{float:left; font-size: 12px; width: 120px; height:34px; margin: 4px 0px; overflow:hidden;}
        .more{float:left; background:url("resources/images/react_icon/plus.svg") no-repeat; width: 24px; height: 24px; margin: 8px 10px 0px 20px; border: 0px;}

        .react{float:left; width:200px; height: 26px; margin: 10px 26px 15px 34px;}
        .react>div{float: left; width:30px; height: 26px;}
        .react_like{background: url("resources/images/react_icon/sun.svg") no-repeat; background-size: contain;}
        .react_comment{background: url("resources/images/react_icon/comment.svg") no-repeat; background-size: contain;}
        .react_bookmark{background: url("resources/images/react_icon/bookmark.svg") no-repeat; background-size: contain;}
        .react_count{margin-right: 6px; text-align: center; font-size: 15px; font-weight: 550;}
        /* daily style end */
    </style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
    
    <div class="wrap">

        <div id="header"></div>

        <div id="content">
            <div id="side">

                <div id="line"></div>
                
                <div id="prof">
                    <div id="prof_img" align="center"><img src="resources/prof.png"></div>
                    <div id="prof_nick" align="center">닉네임</div>
                </div>

                <div id="menu">
                    <div id="write">
                        	내가 쓴 글
                        <div><a href="<%= request.getContextPath() %>/myPage.me">데일리</a></div>
                        <div><a href="<%= request.getContextPath() %>/reply.me?currentPage=1">댓글</a></div>
                        <div><a href="<%= request.getContextPath() %>/question.me?currentPage=1">문의글</a></div>
                    </div>
                    <div><a href="<%= request.getContextPath() %>/bookmark.me" style="font-weight: bold;">북마크</a></div>
                    <div><a href="<%= request.getContextPath() %>/myMember.me">개인정보 수정</a></div>
                    <% if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
                    	<div><a href="<%= request.getContextPath() %>">관리자 페이지</a></div>
                    <% } %>
                </div>
            </div>

            <!-- 프로필 이미지 수정 모달 -->
            <div class="modal fade" id="profModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                    <h5 class="prof-title" id="reportModalLabel" align="center">프로필 이미지 수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="prof-body" align="center">
                        <form action="" method="post" style="line-height: 30px;">
                            <div id="prof-img">
                                <img src="resources/prof.png">
                                <button id="prof-delete" class="btn btn-light btn-sm">삭제</button>
                            </div>
                            <div id="prof-input"><input type="file" name="userProfImg"></div>  
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin: auto;">취소</button>
                            &emsp;&emsp;
                            <button type="button" class="btn btn-primary" onclick="" style="width: 90px;">등록</button>
                        </form>
                    </div>
                </div>
                </div>
            </div>

            <!-- 프로필 이미지 수정 모달 띄우기 -->
            <script>
                $("#prof_img").click(function(){
                    $("#profModal").modal("show");
                })
            </script>

            <!-- 북마크 리스트 -->
            <div id="mypage">
                <b style="margin-left: 50px;">북마크</b>
                <br>

                <div id="daily_box">
                	
            	<!-- 데일리 게시글이 없을 경우 -->
            	<%if(list.isEmpty()){ %>
					<div id="empty_box">
                        	등록한 북마크가 없습니다.
                    </div>
                    
                <%} else{%>
                    
                    <% for(Daily d : list) { %>
                   
	                <div class="daily_post fadein">
	                	<input type="hidden" value="<%= d.getDailyNo() %>">
	                    <div class="daily_img">
	                        <img src="<%= contextPath %>/<%= d.getDailyImg() %>" alt="">
	                        <div class="action_hover">
	                        	<!-- 로그인시 가능하도록 설정해야함 -->
								<% if(loginUser != null) { %>
	                            <div class="action">
	                            <% int l = 0; %>
	                            	<%for (int i = 0; i < lArr.length; i++) {%>
	                            		 <%if (lArr[i] == d.getDailyNo()) { %>
	                            		 	<input type="button" class="like"
	        		                        style="background: url('resources/images/react_icon/sun_yellow.svg') no-repeat center/contain; width:100%; height: 100%; border:0px; background-size: 25px 25px;">
	                            			<% l++;%>
	                            			<% d.setLikeCount(1); %>
	                            	<%}}%>
	                            		<%if(l == 0) {%>
	                            			<input type="button" class="like"
		                            		style="background: url('resources/images/react_icon/sun2.svg') no-repeat center/contain; width:100%; height: 100%; border:0px; background-size: 25px 25px;">   	
	                            			<% d.setLikeCount(0); %>
	                            		<%} %>
	                            </div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="comment"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action">
	                            <% int b = 0; %>
	                            	<%for (int i = 0; i < bArr.length; i++) {%>
	                            		 <%if (bArr[i] == d.getDailyNo()) { %>
	                            		 	<input type="button" class="bookmark"
	        		                        style="background: url('resources/images/react_icon/bookmark_blue.svg') no-repeat center/contain; width:100%; height: 100%; border:0px; background-size: 25px 25px;">
	                            			<% b++;%>
	                            			<% d.setBookmarkCount(1); %>
	                            	<%}}%>
	                            		<%if(b == 0) {%>
	                            			<input type="button" class="bookmark"
		                            		style="background: url('resources/images/react_icon/bookmark2.svg') no-repeat center/contain; width:100%; height: 100%; border:0px; background-size: 25px 25px;">   	
	                            			<% d.setBookmarkCount(0); %>
	                            		<%} %>
	                            </div>
	                            <div class="vertical-line"></div>
	                            <div class="action">
		                            <input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal">
	                                <input type="hidden" name="loginUser" value="<%= loginUser.getMemNo() %>"> 
	                                <input type="hidden" name="writeUser" value="<%= d.getMemNo() %>">
	                                <input type="hidden" name="reportDailyNo" value="<%= d.getDailyNo() %>">
	                            </div>
								<% }else { %>
								<div class="action"><input type="button" class="like" data-bs-toggle="modal" data-bs-target="#logoutUserModal"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="comment"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="bookmark" data-bs-toggle="modal" data-bs-target="#logoutUserModal"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#logoutUserModal"></div>
								
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
	                        <div class="react_count"><%= d.getLikeCount() %></div>
	                        <div class="react_comment"></div>
	                        <div class="react_count">10</div>
	                        <div class="react_bookmark"></div>
	                        <div class="react_count"><%= d.getBookmarkCount() %></div>
	                    </div>
	                </div>
                <% } %>
            	<%} %>

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
			    </script>
    
			    <!-- 북마크 -->
			    <script>
				    $(".daily_img .action_hover .bookmark").click(function(){
				    	
				    	var bc = $(this).closest(".daily_post").find(".react_bookmark").next();
				    	var img = $(this);
				    	
				    	<% if(loginUser != null) {%>
						$.ajax({
			        		url:"bookmarkMulti.do",
			        		data:{
			        			memNo:<%=loginUser.getMemNo()%>,
			        			dailyNo:$(this).parent().next().next().children("input[name=reportDailyNo]").val()
			        		},
			        		type:"post",
			        		success:function(daily){ // 성공시 실행 함수 => 북마크 버튼 색 변경, 북마크수 갱신
								//북마크수 갱신
			        			bc.html(daily.bookmarkCount); 
			        		
			        			if(daily.likeCount > 0){ // 북마크 등록 완료
			        				img.css({"background" : "url('resources/images/react_icon/bookmark_blue.svg') no-repeat center/contain"
														 	 , "background-size" : "25px 25px"
										       				 , "border" : "0px"
										       				 , "width" : "100%"
										       				 , "height" : "100%"});
			        			} else{ // 북마크 삭제 완료
			        				img.css({"background" : "url('resources/images/react_icon/bookmark2.svg') no-repeat center/contain"
													 		 , "background-size" : "25px 25px"
										       				 , "border" : "0px"
										       				 , "width" : "100%"
										       				 , "height" : "100%"});
			        			}
			        				
			        		},error:function(){ // 실패시 실행 함수
			        			console.log("북마크 등록/삭제 실패");
			        		}
			        	})
			        <%} %>
					})
			    </script>
			    
			    <!-- 좋아요 -->
			    <script>
				    $(".daily_img .action_hover .like").click(function(){
				    	
				    	var lc = $(this).closest(".daily_post").find(".react_like").next();
				    	var img = $(this);
				    	
				    	<% if(loginUser != null) {%>
						$.ajax({
			        		url:"likeMulti.do",
			        		data:{
			        			memNo:<%=loginUser.getMemNo()%>,
			        			dailyNo:$(this).parent().siblings(".action").children("input[name=reportDailyNo]").val()
			        		},
			        		type:"post",
			        		success:function(daily){ // 성공시 실행 함수 => 좋아요 버튼 색 변경, 좋아요수 갱신
								//좋아요수 갱신
			        			lc.html(daily.likeCount); 
			        		
			        			if(daily.bookmarkCount > 0){ // 좋아요 등록 완료
			        				img.css({"background" : "url('resources/images/react_icon/sun_yellow.svg') no-repeat center/contain"
														 	 , "background-size" : "25px 25px"
										       				 , "border" : "0px"
										       				 , "width" : "100%"
										       				 , "height" : "100%"});
			        			} else{ // 좋아요 삭제 완료
			        				img.css({"background" : "url('resources/images/react_icon/sun2.svg') no-repeat center/contain"
													 		 , "background-size" : "25px 25px"
										       				 , "border" : "0px"
										       				 , "width" : "100%"
										       				 , "height" : "100%"});
			        			}
			        				
			        		},error:function(){ // 실패시 실행 함수
			        			console.log("좋아요 등록/삭제 실패");
			        		}
			        	})
			        <%} %>
					})
			    </script>
			    
                </div>
            </div>
        </div>
    </div>
</body>
</html>