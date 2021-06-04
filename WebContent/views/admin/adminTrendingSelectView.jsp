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
                height: 73%;
                padding-left: 50px;
                overflow: auto;
            }
            #blank_box {
                height: 8%;
                font-size: 22px;
                font-weight: 600;
            }

            #control_box{
                background-color: lightgray;
                width:100%;
                height: 86%;
                }
            
            #control_head{
                height:10%;
            }
            #add_box{
                height:618px;
                width: 808px;
                margin: 3px;
                background-color: white;
                overflow: auto;
                float: left;
            }

            #detail_box {
                float: left;
                margin-top:22px;
                margin-left: 50px;
                height:0%;
            }
            #select_box>select{
                width: 120px;
                height: 35px;
            }

            #search_box {
                float: right;
                margin-top: 20px;
                margin-right: 40px;
            }
            #search-box>button{
                float: left;
            }
            #search_input {
                float: left;
                width: 260px;
            }
            #search_btn{
                height:38px;
            }


            #codi{
                width:200px;
                height: 240px;
                float: left;
                margin-left:53px;
                margin-top: 20px;
            }
            #codi>img{
                width: 200px;
                height: 200px;
            }
            #codi>button{
                margin-top: 3px;
                margin-left: 70px;
            }

            #prof_img{height: 70%; padding: 20px;}
            #prof{height: 17%;width: 99%; float: left;}
            #prof div, #menu div{width: 100%;}
        </style>
    </head>
    <body>
        <div class="wrap">

            <div id="header"></div>

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="img/prof.PNG"></div>
                        <div id="prof_nick" align="center"><b>닉네임</b></div>
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href=""><b>회원관리</b></a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="">메인관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="">트렌딩관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="">게시글관리</a>
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
                                <div id="detail_box">
                                    <div id="select_box">
                                        <select name="" id="" class="form-select">
                                            <option value="1">최신순</option>
                                            <option value="2">좋아요순</option>
                                            <option value="3">댓글순</option>
                                        </select>
                                    </div> 
                                </div>
                                <div id="search_box">
                                    <input id="search_input" class="form-control" type="text" placeholder="검색어를 입력해주세요(#태그)">
                                    <button id="search_btn" type="button"><img src="img/loupe.png"></button>
                                </div>
                            </div>
                            <div id="add_box">
                                    
                                <div id="codi">
                                    <img src="img/codi4.jpg" alt="">
                                    <button name="del_btn" type="button" class="btn btn-secondary">선택</button>
                                </div>
                                <div id="codi">
                                    <img src="img/codi4.jpg" alt="">
                                    <button name="del_btn" type="button" class="btn btn-secondary">선택</button>
                                </div>
                                <div id="codi">
                                    <img src="img/codi4.jpg" alt="">
                                    <button name="del_btn" type="button" class="btn btn-secondary">선택</button>
                                </div>
                                <div id="codi">
                                    <img src="img/codi4.jpg" alt="">
                                    <button name="del_btn" type="button" class="btn btn-secondary">선택</button>
                                </div>
                            </div>
                        </div>
                        


                    </div>

                </div>
            </div>

        </div>

    </body>
</html>