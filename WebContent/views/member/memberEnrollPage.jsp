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

 		
        #enroll_form_input_info>input[type = text], [type = password], [type = email]{font-size:11px; width: 300px; height: 35px; margin: auto;}

        #enroll_form_input_info>#memId{width: 62%; height: 35px; margin-right: 83px; display: inline-block;}
        #enroll_form_input_info>#checkId{position: absolute; margin-left: -20%; bottom: 73.6%;}
        
        #enroll_form_input_info>#memName{margin-bottom: 8px;}
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
                    <a href="<%= contextPath %>">
                        <img src="<%=contextPath %>/resources/images/logo.jpg" width="60%">
                    </a>
                </div>
                <div id="enroll_form">
                    <h2>가입</h2><br>
                    <form action="<%= contextPath %>/insert.me" id="enroll_form_input" method="post">
                        <div id="enroll_form_input_info">
                            <input type="text" id="memId" name="memId" class="form-control" placeholder="4~12자의 영문 대소문자와 숫자로만 입력" size="12" maxlength="12" required>
                            <button type="button" class="btn btn-secondary btn-sm" id="checkId" onclick="idCheck();">중복확인</button>
                            <br><br>
                            <input type="email" id="email" name="email" class="form-control" placeholder="E-mail" required>
                            <br>
                            <input type="password" id="memPwd1" name="memPwd" class="form-control" style="margin-bottom: 3px;" placeholder="비밀번호(6자 이상 영문/숫자/특수문자포함)" size="16" maxlength="16" required>
                            <input type="password" id="memPwd2" class="form-control" placeholder="비밀번호 확인" maxlength="15" required>
                            <br>
                            <input type="text" id="memName" name="memName" class="form-control" placeholder="닉네임" required>
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
                            <button type="submit" class="btn btn-dark" onclick="formCheck();" style="width: 130px;" disabled>가입</button>
                            <br><br>
                            <a href="<%=contextPath%>/loginPage.me">여기서 로그인</a>
                            <br>
                            <h6>이용 중 도움이 필요하시면<br>
                            help@sytlecast.com으로 문의해 주세요.</h6>
                        </div>
                    </form>
                    <script>
	                    function formCheck(){
	            	    		
	            	    		var memId = $("#memId");
	            	    		var email = $("#email");
	            	    		var memPwd1 = $("#memPwd1");
	            	    		var memPwd2 = $("#memPwd2");
	            	    		var memName = $("#memName");
	            	    		
	            	    		// 정규 표현식
	            	    		var idPattern = /^[a-zA-Z]{1}[a-zA-Z0-9]{2,12}$/;
	            	    		var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	            	    		var pwdPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
	            				var namePattern = /^[0-9가-힝a-zA-Z]{2,15}$/;
	            	    	
	            				// 아이디
	            				if ((memId.val()) == ""){
	            		            alert("아이디를 입력하지 않았습니다.");
	            		            memId.select();
	            		            return false;
	            		        }
	            				if (!idPattern.test(memId.val())){
	            					alert("아이디는 4~12자의 대소문자와 숫자로만 입력 가능합니다.");
	            					memId.val('');
	            					memId.focus();
	            		            return false;
	            		        }
	            				
	            				// 비밀번호
	            				if ((memPwd1.val()) == ""){
	            		            alert("비밀번호를 입력해 주세요");
	            		            memPwd1.focus();
	            		            return false;
	            		        }
	            		        if ((memPwd2.val()) == ""){
	            		            alert("비밀번호를 입력해 주세요");
	            		            memPwd2.focus();
	            		            return false;
	            		        }
	            		    	if (!pwdPattern.test(memPwd1.val())){
	            		    		alert("비밀번호는 6자 이상의 대소문자/숫자/특수문자를 포함하여 입력해주세요.");
	            		    		memPwd1.val('');
	            		    		memPwd1.focus();
	            		            return false;
	            		        }	
	            		    	if (!memPwd1.val() == memPwd2.val()) {
	            		            alert("비밀번호가 일치 하지 않습니다.");
	            		            memPwd1.focus();
	            		            memPwd2.focus();
	            		            return false;
	            		        }
	            		    	
	            		    	// 이메일
	            		    	if ((email.val()) == ""){
	            		            alert("이메일을 입력해 주세요");
	            		            email.focus();
	            		            return false;
	            		        }
	            		    	if (!emailPattern.test(email.val())){
	            		    		alert("이메일을 잘못 입력 했습니다.");
	            		            return false;
	            		        }
	            		    	
	            		        //닉네임 입력 안 한 경우
	            		        if ((memName.val())=="") {
	            		            alert("닉네임을 입력해 주세요");
	            		            memName.focus();
	            		            return false;
	            		        }
	            		     	//닉네임에 특수 문자가 들어간 경우
	            		        if (!namePattern.test(memName.val())){
	            		        	alert("닉네임이 잘못 되었습니다.");
	            		        	memName.select();
	            		            event.preventDefault();
	            		        }
	            	    	
	            	    	}
	                    
	                    function idCheck(){
	                    	var $memId = $("#enroll_form_input input[name=memId]");
	                    	
	                    	$.ajax({
	                    		url:"idCheck.me",
	                    		data:{checkId:$memId.val()},
	                    		success:function(result){
	                    		
	                    			if(result == "NNNNN"){ // 사용불가
	                    				
	                    				alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.")
	                    				$memId.focus();
	                    				
	                    			}else{	// 사용가능
	                    				
	                    				if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){ //사용
										$("#enroll_form_input :submit").removeAttr("disabled");
	                    				$memId.attr("readonly", true); 
	                    					
	                    				}else {
	                    					$memId.focus();
	                    				}
	                    			}
	                    		},error:function(){
	                    			console.log("아이디중복체크용  ajax 통신실패");
	                    		}
	                    	})
	                    }
                    </script>
                </div>
            </div>
        </div>
    </div>
</body>
</html>