<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="com.stylecast.admin.model.vo.*, com.stylecast.daily.model.vo.*, java.util.ArrayList, java.text.SimpleDateFormat" %>
<%
	ArrayList<Daily> dlist = (ArrayList<Daily>)request.getAttribute("dlist");
	int tno = ((Integer)request.getAttribute("tno")).intValue();
%>
<!DOCTYPE html>
<html lang="kr">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <!--bootstrap-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
        <!--bootstrap end-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!--font-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
            rel="stylesheet">
        <!--font end-->

        <style>

            div {
                /*border: 1px solid black;*/
                box-sizing: border-box;
            }

            * {
                font-family: 'Noto Sans KR', sans-serif;
            }

            .wrap {
                width: 1200px;
                height: 1300px;
                margin: auto;
            }

            .wrap > div {
                width: 100%;
            }
            table thead th {
                text-align: center;
            }
            table tbody tr td {
                text-align: center;
            }
            #table_box{
                height: 75%;
            }
            #header {
                height: 12%;
            }
            #content {
                height: 88%;
                width: 90%;
                margin: auto;
            }
            #content > div {
                float: left;
                height: 100%;
            }

            #side {
                width: 20%;
            }
            #form {
                width: 80%;
                padding-top: 40px;
            }

            #menu {
                margin-top: 10%;
                width: 99%;
                float: left;
                padding-left: 10px;
            }
            #menu div {
                width: 100%;
                margin-bottom: 40px;
            }
            #menu a {
                color: black;
                text-decoration: none;
            }
            #line {
                width: 1.5px;
                height: 80%;
                float: right;
                background: lightgrey;
            }

            #line2 {
                width: 100%;
                height: 1.5px;
                background-color: lightgray;
            }

            #content_of_form {
                height: 82%;
                padding-left: 50px;
                overflow: auto;
            }
            #blank_box {
                height: 7%;
                font-size: 22px;
                font-weight: 600;
            }

            #control_box{
                background-color: lightgray;
                width:100%;
                height: 86%;
                }
            
            #control_head{
                height:8%;
            }
            #daily_box{
                height:710px;
                width: 808px;
                margin: 3px;
                background-color: white;
                overflow: auto;
                float: left;
            }

            #search_box {
                float: right;
                margin-top: 16px;
                margin-right: 30px;
            }
            #search_input {
                float: left;
                width: 260px;
            }
            #search_icon{
            	background: url("resources/images/search.svg") no-repeat;
				background-size: contain;
				width: 25px;
				height: 25px;
				float: left;
				margin: 6px 3px;
            }

			#prev{
				background: url("resources/images/back.svg") no-repeat;
				background-size: contain;
				float: left;
				width: 25px;
				height: 25px;
				margin-top: 20px;
				margin-left: 20px;
				cursor: pointer;
			}
			/* daily style */
			.daily_post {
				width: 230px;
				height: 365px;
				float: left;
				color: rgb(40, 40, 40);
				border: 0.5px solid lightgrey;
				border-radius: 2pc;
				background: whitesmoke;
				margin-top: 10px;
				margin-left: 26px;
				margin-bottom: 5px;
			}
			
			.daily_img {
				position: relative;
				width: 200px;
				height: 250px;
				margin: 15px 15px 4px;
			}
			
			.daily_img>img {
				width: 200px;
				height: 250px;
				object-fit: cover;
			}
			
			.profile {
				width: 40px;
				height: 40px;
				float: left;
				margin: 2px 5px 0px 17px;
			}
			
			.profile>img {
				width: 100%;
				height: 100%;
			}
			
			.userid {
				width: 83px;
				float: left;
				font-size: 13px;
				font-weight: 600;
				margin-top: 2px;
			}
			
			.date {
				float: left;
				font-size: 11px;
				font-weight: 500;
				margin: 3px 0px 1px 20px;
			}
			
			.text {
				float: left;
				font-size: 12px;
				width: 150px;
				height: 20px;
				margin: 3px 0px 0px 0px;
				overflow: hidden;
			}
            .tag {
				float: left;
				font-size: 12px;
				width: 150px;
				height: 20px;
				margin: 0px 0px 2px 63px;
				overflow: hidden;
			}
			
			.react {
				float: left;
				width: 160px;
				height: 21px;
				margin: 1px 0px 0px 47px;
			}
			
			.react>div {
				float: left;
				width: 21px;
				height: 21px;
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
				font-size: 13px;
				font-weight: 500;
			}
			/* daily style end */

            #prof_img{height: 70%; padding: 20px;}
        	#prof_img>img{width: 100px; height: 100px;}
            #prof{height: 17%;width: 99%; float: left;}
            #prof div, #menu div{width: 100%;}
        </style>
    </head>
    <body>
    
    	<%@ include file="../common/menubar.jsp"%>
    
        <div class="wrap">

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle"/></div>
                        <div id="prof_nick" align="center"><b><%=loginUser.getMemName()%></b></div>
                    	<input id="contextpath" type="hidden" value="<%= contextPath %>">
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href="<%=contextPath%>/memlist.adm?blackListYN=N&&currentPage=1"><b>회원관리</b></a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= contextPath %>/codilist.ad?currentPage=1">메인관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= contextPath %>/trdlist.adm?currentPage=1">트렌딩관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%=contextPath%>/rptList.adm?brCategory=0&&currentPage=1">게시글관리</a>
                            </h4>
                        </div>
                    </div>
                </div>

                <script>
                    $("#menu a").click(function () {
                        $("#menu a").css("font-weight", "normal");
                        $(this).css("font-weight", "bold");
                    })
                </script>

                <div id="form">
                    
                    <div id="content_of_form">
                        <div id="blank_box">트렌딩 관리</div>
                        <div id="control_box">
                            <div id="control_head">
                            <div id="prev" onclick="location.href='<%=contextPath%>/modifyForm.tr?tno=<%= tno %>'"></div>
                            <div id="search_box">
                                <div id="search_icon"></div>
	                            <input id="search_input" class="form-control" type="text" placeholder="검색어를 입력해주세요(#태그)">
                            </div>
                            </div>
                            
                            <script>
	                            $(document).ready(function() {
	                                $("#search_input").on("keyup", function() {
	                                    var k = $(this).val();
	                                    $(".daily_post").hide();
	                                	if(k.startsWith("#")) {
	                                    	var temp = $(".tag:contains('" + k + "')");
	                                	}else {
	                                    	var temp = $(".text:contains('" + k + "')");
	                                	}

	                                    $(temp).parent().show();
	                                })
	                            })
                            </script>
                            
                            <div id="daily_box">
                                    
                                <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); %>
				
								<% for(Daily d : dlist) { %>
								<div class="daily_post fadein">
									<input type="hidden" value="<%= d.getDailyNo() %>">
									<div class="daily_img">
										<img src="<%= contextPath %>/<%= d.getDailyImg() %>" alt="">
									</div>
				
									<div class="profile">
										<img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle">
									</div>
									<div class="userid"><%= d.getMemName() %></div>
									<div class="date"><%= simpleDateFormat.format(d.getEnrDate()) %></div>
									<div class="text"><%= d.getDailyContent() %></div>
									<div class="tag"><%= d.getTag() %></div>
									
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

								<script>
						        // daily click action
						        $(".daily_post").on("click", function(){
						            $(location).attr("href", "<%=contextPath%>/insertTPost.tr?tno="+ <%= tno %> + "&dno=" + $(this).children().eq(0).val());
						        });
								</script>

                            </div>
                        </div>
                        


                    </div>

                </div>
            </div>

        </div>

    </body>
</html>