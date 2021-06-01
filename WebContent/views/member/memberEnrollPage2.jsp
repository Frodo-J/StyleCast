<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.member.vo.Member"%>
<%
	String contextPath = request.getContextPath();

	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
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
        /*div{border: 1px solid gray; box-sizing: border-box;}*/
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
            height: 740px;
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
        #enroll_form_input_info>input[type = email]{width: 52.6%; height: 35px; margin-right: 115px; display: inline-block;}
        #enroll_form_input_info>#sendAuthenticate,#emailAuthenticate{position: absolute; margin-left: -30%;}

        #enroll_form_input_info>#userId, #userNname{margin-bottom: 8px;}
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
                    <h2>가입</h2><br>
                    <form action="<%= contextPath %>/insert.me" id="enroll_form_input" method="post">
                        <div id="enroll_form_input_info">
                            <input type="text" id="userId" name="memId" class="form-control" placeholder="ID" maxlength="12" required>
                            <input type="email" name="email" class="form-control" placeholder="E-mail" required>
                            <input type="button" class="btn btn-secondary btn-sm" name="emailAuthenticate" id="sendAuthenticate" onclick="resendEmail();" value="인증번호 발송">
                            <input type="hidden" readonly="readonly" name="code_check" id="code_check" value="<%= getRandom()%>" />
                            <br><br>
                            <input type="text" name="authenticateNumber" class="form-control" id="authenticateNumber" onkeyup="checkCode()" style="width: 35%; margin-right: 5px; display: inline-block;" placeholder="인증번호" required>
                            <div id="checkCode"></div>
                            <input type="hidden" readonly="readonly" name="code_check" id="code_check" value="<%=request.getAttribute("code") %>">
                            <input type="button" style="margin-right: 90px; margin-bottom: 10px; width: 80px;"class="btn btn-secondary btn-sm" name="emailAuhenticate" id="emailAuhenticate" type="hidden" value="확인">
                            <br><br>
                            <input type="password" name="memPwd" class="form-control" style="margin-bottom: 3px;" placeholder="비밀번호(8자 이상 영문/숫자/특수문자)" maxlength="15" required>
                            <input type="password" class="form-control" placeholder="비밀번호 확인" maxlength="15" required>
                            <br>
                            <input type="text" id="userNname" name="memName" class="form-control" placeholder="닉네임" required>
                            <br>
                            <input type="radio" class="form-check-input" name="gender" value="M" checked> <label for="radioM">남자</label>
                            &nbsp;&nbsp;&nbsp;
                            <input type="radio" class="form-check-input" name="gender" value="F"> <label for="radioF">여자</label>
                            <br>
                            <input type="checkbox" class="form-check-input" name="form" id="infoForm" value="infoForm" required>
                            <a href="<%=contextPath%>/privacy.po">개인정보 처리방침 동의</a>
                            <br>
                            <input type="checkbox" class="form-check-input" name="form" id="serviceForm" value="serviceForm" required>
                            <a href="<%=contextPath%>/termsofUse.po" style="margin-right: 18%;">사용약관 동의</a>
                            <br><br>
                            <button type="submit" class="btn btn-dark" style="width: 130px;">가입</button>
                            <br><br>
                            <a href="<%=contextPath%>/loginPage.me">여기서 로그인</a>
                            <br>
                            <h6>이용 중 도움이 필요하시면<br>
                            help@sytlecast.com으로 문의해 주세요.</h6>
                            
                            <script>
                            	function resendEmail(){
                            		var email = $('input[name="email"]').val();
                                	location.href = '<%=contextPath%>/send.me?email=' + email + '&code_check=<%=getRandom()%>';
                            		document.getElementById('sendAuthenticate').value = "재발송";
                            	}
                            	
                            	function checkCode(){
                          			var v1 = form2.code_check.value;
                          			var v2 = form2.code.value;
                          			if(v1!=v2){
                          				document.getElementById('checkCode').innerHTML = "잘못된인증번호";
                          				document.getElementById('checkCode').style.color = "red";
                                        	makeNull();
                          		  	}else{
                          			   	document.getElementById('checkCode').style.color = "blue";
                          			   	document.getElementById('checkCode').innerHTML = "인증되었습니다."; 
                          			   		makeReal();
                          		  	}
                          		 }
	                          	function makeReal(){
	                          		var hi = document.getElementById("emailAuhenticate");
	                          		hi.type="submit";
	                          	}
	                              function makeNull(){
	                          		var hi = document.getElementById("emailAuhenticate");
	                          		hi.type="hidden";
	                          	}
                            	
                            </script>
                            <%! public int getRandom(){
								int random = 0;
								random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;
								return random;
							} %>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>