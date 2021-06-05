<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
       
        .wrap{width:1200px; height:1144px;  margin: auto;}

        #header, #content{width:100%;}
        #content{height:100%; width: 90%; margin: auto;}

        #side, #mypage{float: left; height: 100%;}
        #side{width: 20%;}
        #mypage{
            width: 80%;
            padding-top: 40px;
            padding-left: 50px;
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

        /* 비밀번호 확인 폼 css */
        #pass_input_box{
            margin-top: 90px;
            margin-left: 140px;
            width:400px;
            height: 250px;
            border-radius: 8px;
            background: #E0E0E0;
        }

        #input_box_1{padding-top: 50px;font-size: 14px; font-weight: bold;}
        #input_box_2{margin-top: 40px;}
        #input_box_3{margin-top: 20px;}
        #pass_input_box button{margin: 0px 25px;}
    </style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<% 
		String memId = loginUser.getMemId();
	%>
    
    <div class="wrap">

        <div id="content">
            <div id="side">

                <div id="line"></div>
                
                <div id="prof">
                    <div id="prof_img" align="center"><img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle"></div>
                    <div id="prof_nick" align="center"><%= loginUser.getMemName() %></div>
                </div>

                <div id="menu">
                    <div id="write">
                        	내가 쓴 글
                        <div><a href="<%= request.getContextPath() %>/myPage.me">데일리</a></div>
                        <div><a href="<%= request.getContextPath() %>/reply.me?currentPage=1" style="font-weight: normal;">댓글</a></div>
                        <div><a href="<%= request.getContextPath() %>/question.me?currentPage=1" style="font-weight: normal;">문의글</a></div>
                    </div>
                    <div><a href="<%= request.getContextPath() %>/bookmark.me">북마크</a></div>
                    <div><a href="<%= request.getContextPath() %>/myMember.me" style="font-weight: bold;">개인정보 수정</a></div>
                    <% if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
                    	<div><a href="<%= request.getContextPath() %>/memlist.adm?blackListYN=N&&currentPage=1">관리자 페이지</a></div>
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
                        <form name="profImg_update" style="line-height: 30px;">
                            <div id="prof-img">
                                <img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle">
                                <button id="prof-delete" class="btn btn-light btn-sm">삭제</button>
                            </div>
                            <div id="prof-input"><input type="file" name="userProfImg"></div>  
                            <input type="hidden" name="memId" value="<%=loginUser.getMemId()%>">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin: auto;">취소</button>
                            &emsp;&emsp;
                            <button type="button" class="btn btn-primary" onclick="imgUpdate(profImg_update);" style="width: 90px;">등록</button>
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
            
            <script>
	            function imgUpdate(formName){
	        		formName.action = "/StyleCast/updateProf.me";
	        		formName.method = "post";
	        		formName.enctype = "multipart/form-data";
	        		formName.submit();
	        	}
            </script>

            <div id="mypage">
                <b>개인정보 수정</b>
                <br><br>
                
                <!-- 비밀번호 체크 폼 -->
                <form action="passCheck.me" id="pass_check" method="post">
                    
                    <div id="pass_input_box" align="center">
                        <div id="input_box_1">개인정보 수정을 위해 비밀번호를 입력해주세요.</div>
                        <div id="input_box_2">
                        	<input type="password" class="form-control" name="checkPwd" style="width:250px">
                        	<input type="hidden" class="form-control" name="userId" value="<%=memId %>">
                        	</div>
                        
                        <div id="input_box_3">
                            <button type="button" class="btn btn-secondary btn-sm">취소</button>
                            <button type="submit" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#passModal">확인</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>