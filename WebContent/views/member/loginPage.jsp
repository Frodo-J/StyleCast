<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.member.vo.Member"%>
<%
	String contextPath = request.getContextPath();

	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StyleCast</title>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <!--bootstrap end-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
         *{font-family: 'Noto Sans KR', sans-serif;}
         #background { 
			margin: auto;
			background-repeat:no-repeat;
			background-position:0 0;
			background-size:100% 100%;
		}
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
    <script>

	    $(document).ready(function(){ 
	        
		    var numberOfImages=3; 
		    var imageNum = Math.round(Math.random()*(numberOfImages-1))+1;
		    var imgPath=('./resources/images/login_img/img_'+imageNum+'.jpg');
		    $('#background').css('background-image', ('url("'+imgPath+'")'));
		     
		    });
		    
  	</script>
</head>
<body> 
    <div class="wrap" id="background">
        <div id="box">
            <div id="box_wrap">
                <div id="logo">
                    <a href="">
                        <img src="<%=contextPath %>/resources/images/logo.jpg" width="60%">
                    </a>
                </div>
                <div id="enroll_form">
                    <h2>로그인</h2><br>
                    <form action="<%= contextPath %>/login.me" id="enroll_form_input" method="post">
                        <div id="enroll_form_input_info">
                            <input type="text" name="memId" class="form-control" placeholder="ID" required>
                            
                            <a href="<%= contextPath %>/findId.me" style="margin-left: 35%;">ID가 기억나지 않으세요?</a>
                            <br><br>
                            <input type="password" name="memPwd" class="form-control" placeholder="비밀번호를 입력해주세요" required>
                            
                            <a href="<%= contextPath %>/findPwd.me" style="margin-left: 38%;">비밀번호를 잊으셨나요?</a>
                            <br><br>
                            <button type="submit" class="btn btn-dark" style="width: 130px;">로그인</button>
                            <br>
                            <a href="<%=contextPath%>/joinPage.me">여기서 가입</a>
                            <br><br>
                            <h6>이용 중 도움이 필요하시면<br>
                            help@stylecast.com으로 문의해 주세요.
                            </h6>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>