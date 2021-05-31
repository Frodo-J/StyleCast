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
        *{font-family: 'Noto Sans KR', sans-serif;}
        /*div{border: 1px solid black;}*/
        
        .wrap{width:1200px; height:1300px;  margin: auto; font-family:'Noto Sans KR', sans-serif;}

        .wrap>div{width:100%;}
        #header{height:12%; font-weight:500;}

        #header>div{float:left;}

        #header_1{width:22%; height:90%}
        #logoimg{height:100px; width:100%; margin-top: 25px;}

        #header_2{width:48%;height:90%}
        #header_2>div{height:auto; margin-left:55px; padding-top:55px; float:left;}
        #header_2>div>a{text-decoration:none; color:black;}

        #header_3{width:20%; height:90%;}
            .search-box{
            padding: 10px;
            margin-top:75px;
            margin-left:50%;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            height: 40px;
            background-color: #fff;
            border: 1px solid black;
            border-radius: 30px;
            transition: 0.4s;
            width:40px;
            }
            .search-box:hover{
            box-shadow: 0px 0px .5px 1px black;
            width: 200px;
            }
            .search-btn{
            text-decoration: none;
            float: right;
            width: 18px;
            height: 18px;
            background-color: #fff;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            color: black;
            }
            .search-box:hover > .search-btn{
            background-color: #fff;
            }
            .search-txt{
            display: flex;
            padding: 0;
            width: 0px;
            border:none;
            background: none;
            outline: none;
            float: left;
            font-size: 10px;
            line-height: 20px;
            transition: .4s;
            }
            .search-box:hover > .search-txt{
            width: 160px;
            padding: 0 6px;
            }

        #header_4{width:10%; height:90%; text-align: center;}
        #login{border-radius:5px; border:none; padding:7px 20px; margin-top: 55px;}

        #header_5{width:100%; height:1%; background-color: gray;}

        
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
<div class="wrap">
        <div id="header">
            <div id="header_1">
                <a href="홈페이지링크"><img id="logoimg"src="resources/image/logo.jpg"></a>
            </div>

            <div id="header_2" alink="rgb(241, 196, 15)">
                <div id="daily"><a href=""><font size="5px">Daily</font></a></div>
                <div id="trending"><a href=""><font size="5px">Trending</font></a></div>
                <div id="qna"><a href=""><font size="5px">QnA</font></a></div>
                <div id="notice"><a href=""><font size="5px">Notice</font></a></div>
            </div>
            
            <script>
                $("#header_2 a").click(function(){
                    $("#header_2 a").css("color", "black");
                    $(this).css("color", "rgb(241, 196, 15)");
                })
            </script>

            <div id="header_3">
                <div class="search-box">
                    <input type="text" class="search-txt" name=""placeholder="Type to search">
                    <a class="search-btn" href="#">
                        <i class="fas fa-search"></i>
                    </a>
                </div>
            </div>
            
            <div id="header_4">
                <button type="button" id="login" class="btn btn-primary">로그인</button>
            </div>
        </div>
        <div id="find">
            <form action="" id="find_form">
                <p>
                    <h6 style="font-weight: bold;">ID가 기억나지 않으세요?</h6>
                    <br>
                    &nbsp; 이메일 <input type="email" class="form-control" name="userEmail" id="userEmail" placeholder="your@email.com" required>
                </p>
                <br>
                <input type="submit" value="ID 찾기" class="btn btn-dark">

            </form>

        </div>
    </div>

</body>
</html>