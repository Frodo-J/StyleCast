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

        /* 마이 페이지 상세 css */
        .form-control-sm{width: 200px;}

        #form-button{margin-left: 100px;}
        #update-form input, #userId{margin:5px;}
        #update-form input, #userId{margin-left:20px;}
        #update-form #newpass{margin:5px 0px 0px 20px;}
        #update-form #newpass_confirm{margin:0px 0px 5px 20px;}

        #confirm-btn{
            margin-left: 20px;
            width: 60px;
        }
        
        #retire_link, #form-button{
            font-size: 13px;
            border: 0px;
        }

        #retire_link span{text-decoration: underline;}
        #retire_link span:hover{cursor: pointer;}

        /* 회원 탈퇴 확인창 css*/
        #deleteBox{
            border: 1px solid black;
            width: 600px;
            height: 480px;
            background: lightgray;
            position: absolute;
            top: 100px;
            left: 120px;
            font-size: 14px;
            display: none;
            z-index: 3;
        }

        #delete-title{
            padding-top: 20px;
            padding-left: 20px;
        }
        #delete-title h3{
            font-weight: bold;
        }

        #delete-line{
            margin: 15px;
            width:95%;
            height: 1px;
            background: black;
        }

        #delete-yn{
            margin-top: 20px;
            margin-left: 120px;
            }

        #delete-body{
            padding-left: 15px;
            margin-bottom: 30px;
        }

        #delete-footer button{margin: 10px 30px;}
    </style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<%
		String memId = loginUser.getMemId();
		String memPwd = loginUser.getMemPwd();
		String memName = loginUser.getMemName();
		String email = loginUser.getEmail();
		String gender = loginUser.getGender();
	%>
	
    
    <div class="wrap">

        <div id="content">
            <div id="side">

                <div id="line"></div>
                
                <div id="prof">
                    <div id="prof_img" align="center"><img src="../../resources/images/prof.png"></div>
                    <div id="prof_nick" align="center">닉네임</div>
                </div>

                <div id="menu">
                    <div id="write">
                        	내가 쓴 글
                        <div><a href="<%= request.getContextPath() %>/myPage.me">데일리</a></div>
                        <div><a href="<%= request.getContextPath() %>/reply.me?currentPage=1">댓글</a></div>
                        <div><a href="<%= request.getContextPath() %>/question.me?currentPage=1">문의글</a></div>
                    </div>
                    <div><a href="<%= request.getContextPath() %>/bookmark.me">북마크</a></div>
                    <div><a href="<%= request.getContextPath() %>/myMember.me" style="font-weight: bold;">개인정보 수정</a></div>
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

            <div id="mypage">
                <b>개인정보 수정</b>
                <br><br>

                <!-- 개인정보 수정 입력 폼 -->
                <form action="<%= contextPath %>/update.me" id="update-form" method="post">

                    <table>
                        <tr>
                            <td><label class="form-label">아이디</label></td>
                            <td><span id="userId"><%=memId %></span></td>
                            <td><input type="hidden" name="userId" class="form-control form-control-sm" value="<%=memId%>"></td>
                        </tr>
                        <tr>
                            <td><label class="form-label">비밀번호</label></td>
                            <td><input type="password" name="userNewPwd" id="newpass" class="form-control form-control-sm" maxlength="15" placeholder="새 비밀번호"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="password" id="newpass_check" class="form-control form-control-sm" maxlength="15" placeholder="새 비밀번호 확인" ></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="hidden" name="userPwd" class="form-control form-control-sm" value="<%=memPwd%>"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label class="form-label">이메일</label></td>
                            <td><input type="email" class="form-control form-control-sm" name="email" value="<%=email%>"></td>
                            <td><button type="button" class="btn btn-light btn-sm">인증번호 발송</button></td>
                        </tr>
                        <tr>
                            <td><label class="form-label">인증번호 입력</label></td>
                            <td><input type="text" class="form-control form-control-sm" name="email-confirm" style="width:100px" placeholder="인증번호"></td>
                            <td><button type="button" id="confirm-btn" class="btn btn btn-light btn-sm" style="margin-left: -100px;">확인</button></td>
                        </tr>
                        <tr>
                            <td><label class="form-label">닉네임</label></td>
                            <td><input type="text" class="form-control form-control-sm" name="userName" value="<%=memName%>"></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><label class="form-label">성별</label></td>
                            <td colspan="2">
                                <input type="radio" name="gender" id="male" value="m">
                                <label for="male">남자</label>
                                
                                <input type="radio" name="gender" id="female" value="f">
                                <label for="female">여자</label>
                            </td>
                        </tr>
                    </table>
                    
                    <!-- 성별 라디오 버튼 선택 함수 -->
                    <script>
                    	$(function(){
                    		<% if(gender.equals("M")){ %>
                    			$("#male").attr("checked", true);
                    		<% }else{ %>
                    			$("#female").attr("checked", true);
                    		<% } %>
                    	})
                    </script>

                    <script>
                        $(function(){
                            if($("#newpass").val().length > 0){
                            	$("#newpass_check").attr("required", true);
                            	
                            	if($("#newpass").val() != $("#newpass_check").val()){
                        			$("#form-button button[type='submit']").attr("disabled", true);
                        		}
                        	}
                        })
                    </script>

                    <br>

                    <div id="form-button">
                        <button type="reset" class="btn btn-secondary btn-sm">초기화</button>
                        <button type="submit" class="btn btn-primary btn-sm">수정하기</button>
                    </div>
                    
                    <br>

                    <div id="retire_link">StyleCast를 더 이상 이용하지 않는다면&nbsp;&nbsp;<span>회원탈퇴 바로가기</span></div>
                </form>
                
                <!-- 회원탈퇴 확인창 띄우기 -->
                <script>
                    $("#retire_link span").click(function(){
                        $("#deleteBox").css("display", "block");
                    })
                </script>

                <div id="deleteBox">
                    <form action="delete.me" method="post">
                        <div id="delete-title">
                            <h3>StyleCast 회원탈퇴</h3>
                            StyleCast를 이용해주셔서 감사합니다.
                        </div>
                        <div id="delete-line"></div>
                        <div id="delete-body">
                            탈퇴를 신청하기 전에 안내 사항을 확인해주세요.<br><br>

                            1. 사용하고 계신 아이디는 탈퇴할 경우 재사용 및 복구가 불가합니다.<br><br>

                            2. 탈퇴 후 회원정보는 모두 삭제됩니다.<br><br>

                            3. 탈퇴 후에도 게시판 및 댓글 서비스에 등록한 게시물은 그대로 남아 있습니다.<br><br>

                            탈퇴 후에는 동일한 아이디로 재가입할 수 없으며, 아이디와 데이터는 복구할 수 없습니다.<br>
                            게시판형 서비스에 남아 있는 게시글을 탈퇴 후 삭제할 수 없습니다.<br><br>
                            
                           	<input type="hidden" name="userId" value="<%=memId%>">
                           	

                            <div>
                                <input type="checkbox" id="delete-yn" required> <label for="delete-yn">안내 사항을 모두 확인했으며, 이에 동의합니다.</label>
                            </div>
                        </div>
                        <div id="delete-footer" align="center">
                            <button type="button" id="cancel-btn" class="btn btn-secondary btn-sm">탈퇴취소</button>
                            <button type="submit" class="btn btn-danger btn-sm">탈퇴하기</button>
                        </div>
                    </form>
                </div>

                <script>
                    $("#cancel-btn").click(function(){
                        $("#deleteBox").css("display", "none");
                    })
                </script>
            </div>
        </div>
    </div>
</body>
</html>