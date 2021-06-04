<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            }
            #search_box {
                display: inline-flex;
                float: left;
                margin-bottom: 10px;
            }
            #img_btn {
                background-color: white;
                border: none;
            }
            #input_search {
                width: 200px;
            }

            #black_box {
                float: right;
            }
            #codi_box {
                width: 95%;
                height: 80%;
                background-color: lightgrey;
                border-radius: 3px;
            }
            #codi_flex_box {
                display: inline-flex;
            }
            #prof_img {
                height: 70%;
                padding: 20px;
            }
            #prof {
                height: 17%;
                width: 99%;
                float: left;
            }
            #menu div,
            #prof div {
                width: 100%;
            }
            #codi_img {
                margin-top: 100px;
                margin-left: 50px;
                width: 400px;
                height: 400px;
            }
            #img_box {
                width: 50%;
                height: 100%;
            }
            #select_box {
                margin-top: 50px;
                margin-left: 70px;
                width: 50%;
                height: 63%;
                display: inline-flex;
            }
            #codi_table_box {
                margin-left: 30px;
                margin-top: 50px;
                width: 80%;
                height: 80%;
            }
            #codi_submit_box {
                margin-right: 5%;
                float: right;
                width: 95%;
                height: 150px;
            }
            #codi_btn_delete {
                margin-left: 15px;
                float: right;

            }
            #codi_btn_submit {
                float: right;
            }
            #codi_button_box {
                margin-top: 60px;
                width: 100%;
                height: 30%;
            }
        </style>
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="wrap">

            <div id="header"></div>

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="images/prof.PNG"></div>
                        <div id="prof_nick" align="center">
                            <b>닉네임</b>
                        </div>
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href="">회원관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= request.getContextPath() %>/codilist.ad?currentPage=1">
                                    <b>메인관리</b>
                                </a>
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
                    <!-- <h2 style="text-align: center;"> <b>회원관리</b> </h2> -->
                    <!-- <br> <div id="line2"></div> -->

                    <div id="content_of_form">
                        <div id="blank_box">
                            <h5>
                                <b>날씨 및 코디</b>
                            </h5>
                        </div>
                        <form id="codi_box" action="<%= request.getContextPath() %>/enrollForm.co" method="post" >
                            <div id="codi_flex_box">
                                <div id="img_box">
                                    <img id="codi_img" src=""/>
                                </div>
                                <div id="select_box">
                                    <div id="codi_table_box">
                                        <table>
                                            <tr height="30px">
                                                <th width="30%">성별</th>
                                                <td width="40%"><input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gender"
                                                    id="flexRadioDefault1"
                                                    value="M"
                                                    checked="checked">
                                                    <label class="form-check-label" for="flexRadioDefault1" >
                                                       	남성
                                                    </label>
                                                </td>
                                                <td>
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="flexRadioDefault1"
                                                        value="F"
                                                        width="100px">
                                                    <label class="form-check-label" for="flexRadioDefault1">
                                                        	여성
                                                    </label>
                                                </td>
                                            </tr>
                                            <tr height="150px">
                                                <th>날씨</th>
                                                <td colspan="2">
                                                    <select name="weather" class="form-select" aria-label="Default select example">
                                                        <option value="SUNNY" selected="selected">sunny</option>
                                                        <option value="CLOUD">cloud</option>
                                                        <option value="RAIN">rain</option>
                                                        <option value="SNOW">snow</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr height="50px">
                                                <th>온도</th>
                                                <td colspan="2"><input
                                                    class="form-control"
                                                    type="text"
                                                    name="highT"
                                                    placeholder="최고기온"
                                                    aria-label="default input example"></td>

                                            </tr>
                                            <tr>
                                                <th></th>
                                                <td colspan="2"><input
                                                    class="form-control"
                                                    type="text"
                                                    name="lowT"
                                                    placeholder="최저기온"
                                                    aria-label="default input example"></td>
                                            </tr>
                                            <tr style="display: none;">
                                                <th>이미지1</th>
                                                <td colspan="2">
                                                    <div id="input_file" class="input-group">
                                                        <input
                                                            type="file"
                                                            class="form-control"
                                                            id="input-img1"
                                                            name = "imgPath"
                                                            aria-describedby="inputGroupFileAddon04"
                                                            aria-label="Upload"
                                                            onchange="loadImg(this,1);">
                                                    </div>
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                    <script>
                                        $(function () {

                                            $("#codi_img").click(function () {
                                                $("#input-img1").click();
                                            })

                                        })

                                        function loadImg(inputFile, num) {
                                            // inputFile : 현재 변화가 생긴 input type="file" 요소객체 num : 몇번째 input요소인지 확인 후 해당 그영역에
                                            // 미리보기하기위해서 console.log(inputFile.files.length);

                                            if (inputFile.files.length == 1) {
                                                // 선택된 파일이 존재할 경우
                                                // => 선택된 파일을 읽어들여서 그 영역에 맞는 곳에 미리보기 파일을 읽어들일 FileReader 객체 생성
                                                var reader = new FileReader();

                                                // 파일을 읽어들이는 메소드 => 해당 파일을 읽어들이는 순간 해당 그 파일만의 고유한 url 부여됨
                                                reader.readAsDataURL(inputFile.files[0]);

                                                // 파일 읽기가 다 완료되었을 때 실행할 함수를 정의
                                                reader.onload = function (e) {
                                                    // 각 영역에 맞춰서 이미지 미리보기
                                                    switch (num) {
                                                        case 1:
                                                            $("#codi_img").attr("src", e.target.result);
                                                            break;
                                                    }
                                                }

                                            } else { // 선택된 파일이 사라졌을 경우 => 미리보기 사라지게
                                                switch (num) {
                                                    case 1:
                                                        $("#codi_img").attr("src", null);
                                                        break;
                                                }
                                            }

                                        }
                                    </script>

                                </div>

                            </div>
                            <div id="codi_submit_box">
                                <div id="codi_button_box">
                                    <button type="button" class="btn btn-secondary" id="codi_btn_delete" onclick="history.back();">취소</button>
                                    <button type="submit" class="btn btn-primary" id="codi_btn_submit" data-bs-toggle="modal" data-bs-target="#exampleModalToggle" >작성</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- Modal -->
                    <div
                        class="modal fade"
                        id="exampleModalToggle"
                        aria-hidden="true"
                        aria-labelledby="exampleModalToggleLabel"
                        tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalToggleLabel">
                                        <b>확인창</b>
                                    </h5>
                                    <button
                                        type="button"
                                        class="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    	코디를 업데이트하시겠습니까?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                                    <button
                                    	type="button"
                                        class="btn btn-primary"
                                        data-bs-target="#exampleModalToggle2"
                                        data-bs-toggle="modal"
                                        data-bs-dismiss="modal">확인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div
                        class="modal fade"
                        id="exampleModalToggle2"
                        aria-hidden="true"
                        aria-labelledby="exampleModalToggleLabel2"
                        tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalToggleLabel2">
                                        <b>확인창</b>
                                    </h5>
                                    <button
                                        type="button"
                                        class="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    	적용되었습니다!
                                </div>
                                <div class="modal-footer">
                                    <button
                                        class="btn btn-primary"
                                        data-bs-toggle="modal"
                                        data-bs-dismiss="modal"
                                        onclick="history.back();">확인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>

                </div>

            </div>
        </div>
	
</body>
</html>