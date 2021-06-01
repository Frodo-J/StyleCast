<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>StyleCast</title>
    <style>
        #find{
            margin: auto;
            width: 80%;
            height: 25%;
        }
        #find_form{width: 100%; height: 100%; font-weight: bold;}
        #find_form input[type=email]{width: 30%; margin-left: 26%; margin-top: -3%;}
        #find_form input[type=text]{width: 20%; margin-left: 26%; margin-top: -3%;}
        #find_form input[type=submit]{width: 14%; margin-left: 63%;}
        #find_form>a{color: gray; font-size: 14px; margin-left: 27%;}
        
    </style>
</head>
<body>
    <div class="wrap">
		<%@ include file="../common/menubar.jsp" %>
        <div id="find">
            <form action="<%=contextPath %>/findPwd.me" id="find_form">
                <p>
                    <h6 style="font-weight: bold;">가입시 등록하신 아이디와 이메일 주소를 입력하세요.</h6>
                    <br>
                    &nbsp; 아이디 <input type="text" class="form-control" name="memId" required>
                    <a href="<%= contextPath %>/findIdController.me">ID가 기억나지 않으세요?</a>
                    <br><br>
                    &nbsp; 이메일 <input type="email" class="form-control" name="email" placeholder="your@email.com" required>
                </p>
                <br>
                <input type="submit" value="비밀번호 찾기" class="btn btn-dark">
            </form>
        </div>
    </div>
</body>
</html>