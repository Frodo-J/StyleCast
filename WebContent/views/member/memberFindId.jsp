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
    	.wrap{width:1200px; height:1300px; margin: auto;}
        .wrap>div{width:100%;}
        #content{
        		height:88%;
        		font-family: 'Noto Sans KR', sans-serif;
                font-weight: 300;
        		}
        #find{
            margin: auto;
            width: 80%;
            height: 25%;
        }
        #find_form{width: 100%; height: 100%; font-weight: bold;}
        #find_form input[type=email]{width: 50%; margin-left: 27%; margin-top: -3%;}
        #find_form input[type=submit]{width: 14%; margin-left: 63%;} 
        
    </style>
</head>
<body>
		<%@ include file="../common/menubar.jsp" %>
	<div class="wrap">
	        <div id="content">
		        <div id="find">
		            <form action="<%=contextPath %>/findId.me" id="find_form" method="post">
		                <p>
		                    <h6 style="font-weight: bold;">ID가 기억나지 않으세요?</h6>
		                    <br>
		                    &nbsp; 이메일 <input type="email" class="form-control" name="email" placeholder="your@email.com" required>
		                </p>
		                <br>
		                <input type="submit" value="ID 찾기" class="btn btn-dark">
		
		            </form>
		        </div>
	        </div>
	    </div>
</body>
</html>