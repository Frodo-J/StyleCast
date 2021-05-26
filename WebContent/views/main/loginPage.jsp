<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StyleCast</title>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
         /*div{border: 1px solid gray; box-sizing: border-box;} */
         *{font-family: 'Noto Sans KR', sans-serif;}
        .wrap{
            width:1200px;
            height:1300px;
            margin: auto;
            position: relative;
            }
        .wrap>#box{
            width: 350px;
            height: 500px;
            top: 350px;
            left: 425px;
            position: absolute;
            border-radius: 20%;
            background-color: white;
            font-size: 16px;
            text-align: center;
        }
        #box_wrap{margin-top: 20px;}

        #enroll_form>h2{margin: auto; font-weight:bold; color: gray;}

        #enroll_form_input_info>input[type = text], input[type = password]{width: 300px; height: 35px; margin: auto;}
        #enroll_form_input_info>input[type = email]{width: 53%; height: 35px; margin-right: 115px;}
        #enroll_form_input_info>#emailAuthenticate{position: absolute; margin-left: -30%; width: 106px;}

        #enroll_form_input_info>#userId, #userPwd{margin-bottom: 8px;}
        #enroll_form_input_info>a{color: gray;}
        #enroll_form_input_info>h6{color: black; font-weight: bold;}
        #enroll_form_input_info>button:hover{cursor: pointer;}

    </style>
</head>
<body> 

	<%@ include file="../common/menubar.jsp" %>
	
    <div class="wrap" id="background">

        <script type="text/javascript">
            var bg = new Array();
            bg[bg.length] = '<%= contextPath %>/resources/images/Login_Join_bg (1).jpg';
            bg[bg.length] = '<%= contextPath %>/resources/images/Login_Join_bg (2).jpg';
            bg[bg.length] = '<%= contextPath %>/resources/images/Login_Join_bg (3).jpg';

            var obj = document.getElementById('background');
            var size = Math.floor(Math.random()*(bg.length));
            j = (isNaN(size)) ? 0 : size;
            obj.style.backgroundImage = 'url('+ bg[size] + ')';
            
            var msg = "<%= alertMsg %>";
            
            if(msg != "null"){
            	alert(msg);
            	<% session.removeAttribute("alertMsg"); %>
            }
        </script>

        <div id="box">
        	<%if(loginUser == null){ %>
	        	<!-- 로그인전에 보이는 div -->
	            <div id="box_wrap">
	                <div id="logo">
	                    <a href="">
	                        <img src="resources/image/logo.jpg" alt="로고입니다" width="60%">
	                    </a>
	                </div>
	                <div id="enroll_form">
	                    <h2>로그인</h2><br>
	                    <form action="<%= contextPath %>/login.me" id="enroll_form_input" method="post">
	                        <div id="enroll_form_input_info">
	                            <input type="text" name="userId" class="form-control" id="memId" placeholder="ID" required>
	                            
	                            <a href="<%= contextPath %>/findId.me" style="margin-left: 35%;">ID가 기억나지 않으세요?</a>
	                            <br><br>
	                            <input type="password" name="userPwd" class="form-control" id="memPwd" placeholder="비밀번호를 입력해주세요" required>
	                            
	                            <a href="<%= contextPath %>/findPwd.me" style="margin-left: 38%;">비밀번호를 잊으셨나요?</a>
	                            <br><br>
	                            <button type="submit" class="btn btn-dark" style="width: 130px;">로그인</button>
	                            <br>
	                            <br>
	                            <h6>
	                            이용 중 도움이 필요하시면<br>
	                            help@stylecast.com으로 문의해 주세요.
	                            </h6>
	                        </div>
	                    </form>
	                </div>
	            </div>
	       <% }else{ %>
	       		<!-- 로그인 성공 후 -->
	       		<div id="user-info">
	       			<b><%= loginUser.getMemName() %>님</b>의 방문을 환영합니다. <br><br>
	       		</div>
	       <% } %>
        </div>
    </div>
</body>
</html>