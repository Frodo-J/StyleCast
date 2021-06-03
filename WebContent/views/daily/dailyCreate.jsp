<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        *{font-family: 'Noto Sans KR', sans-serif;}
        div{border: 0px solid black;}
        
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        #header{height:12%; font-weight:500;}
        #content{height:88%; position: relative;}

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

        #dailyUp{
            position: absolute;
            width: 90%;
            height: 90%;
            margin: auto;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            background-color: rgb(224, 224, 224);
            }

        #dailyUp_header{height: 40%; width: 100%; box-sizing: border-box}
        #dailyUp_content{height: 60%; width: 100%; box-sizing: border-box}
        #tag{height: 0%;}

        #img{
            margin-top: 30px;
            margin-bottom: 20px;
        }
        
        #item_content>input[type="text"]{margin: auto;}

        #daily-enroll-content{
            width: 90%;
            height: 130px;
            border: none;
        }
        
        #daily-enroll-tag{
            width: 90%;
            height: 30px;
            border: none;
        }


        #tag>input[type="text"]{width: 200px;}

        #daily1, #daily2{
            width: 20%;
            font-size: 15px;
            margin-bottom: 16px;
            margin-right: 1.3%;
            border: none;
            display: inline-block;
        }

        #daily2{margin-left: 10px;}

        #tag>button[type="button"]{
            height: 32px;
            font-size: 11px;
            text-align: center;
            margin-bottom: 3px;
        }

        #upload{
            text-align: center;
            margin: auto;
            margin-bottom: 10px;
            position: absolute;
            left: 0;
            right: 0;
            bottom: 0;
        }

        .modal-body{
            text-align: center;
            background-color: rgb(244, 219, 165);
        }

        .modal-body p{font-weight: bold;}

        #tagLink{width: 60%;}
        #tagBtn{width: 30%;}
    </style>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <!--돋보기 이미지-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!--돋보기 이미지end-->
    <!--font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
    <!--font end-->
    <script>
        //----------이미지 첨부 기능 영역
        $(function(){
            $("#img").click(function(){
                $("#input-img").click();
            })
        })
    
        function loadImg(inputFile, num){
            if(inputFile.files.length == 1){ 
                var reader = new FileReader();
                reader.readAsDataURL(inputFile.files[0]);
                reader.onload = function(e){
                    switch(num){
                    case 1: $("#img").attr("src", e.target.result); break;
                    }
                }
                
            }else{ // 선택된 파일이 사라졌을 경우 => 미리보기 사라지게
                switch(num){
                }
            }
        }
        //---------------

        //---------------링크 등록 버튼 관련
        function linkChange1(){
            document.getElementById('linkBtn1').innerText = '링크 수정';
        }
        function linkChange2(){
            document.getElementById('linkBtn2').innerText = '링크 수정';
        }
        function linkChange3(){
            document.getElementById('linkBtn3').innerText = '링크 수정';
        }
        function linkChange4(){
            document.getElementById('linkBtn4').innerText = '링크 수정';
        }
        function linkChange5(){
            document.getElementById('linkBtn5').innerText = '링크 수정';
        }
        function linkChange6(){
            document.getElementById('linkBtn6').innerText = '링크 수정';
        }
        function linkChange7(){
            document.getElementById('linkBtn7').innerText = '링크 수정';
        }
        function linkChange8(){
            document.getElementById('linkBtn8').innerText = '링크 수정';
        }
        function linkChange9(){
            document.getElementById('linkBtn9').innerText = '링크 수정';
        }
        function linkChange10(){
            document.getElementById('linkBtn10').innerText = '링크 수정';
        }
        function linkChange11(){
            document.getElementById('linkBtn11').innerText = '링크 수정';
        }
        function linkChange12(){
            document.getElementById('linkBtn12').innerText = '링크 수정';
        }
        
    </script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <div class="wrap">

        <div id="content">
            <div id="dailyUp">
                <div id="dailyUp_header">
                    <div id="input_file" class="input-group" style="display: none">
                        <input type="file" class="form-control" id="input-img" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="loadImg(this,1);">
                    </div>
                    <div id="image">
                        <img src="<%=contextPath %>resources/image/add3.png" id="img" width = "300" height = "300">
                    </div>
                </div>
                
                <div id="dailyUp_content">
                    <form action="" id="daily-enroll-form">
                        <div id="item_content">
                            <input type="text" class="form-control" name="dailyContent" id="daily-enroll-content" placeholder="내용을 입력해주세요"></td>
                            <br><br>
                            <input type="text" name="dailyTag" class="form-control" id="daily-enroll-tag" placeholder="태그를 입력해주세요(최대 10개까지 가능)">
                            <br><br>
                        </div>

                        <div id="tag">
                            <h2 style="text-align: left; margin-left: 53px;">Item Tag</h2>
                            <p style="font-size: 10px; color: gray; text-align: left; margin-left: 53px;" >아이템을 구매한 곳의 링크를 입력해주세요! (선택사항)</p>
                            <br>
                            
                            <input type="text" name="top1" id="daily1" class="form-control" placeholder="상의1">
                            <button type="button" class="btn btn-secondary" id="linkBtn1" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange1()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="top2" id="daily2" class="form-control" placeholder="상의2">
                            <button type="button" class="btn btn-secondary" id="linkBtn2" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange2()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>

                            <input type="text" name="top3" id="daily2" class="form-control" placeholder="상의3">
                            <button type="button" class="btn btn-secondary" id="linkBtn3" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange3()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="bottom1" id="daily1" class="form-control" placeholder="하의1">
                            <button type="button" class="btn btn-secondary" id="linkBtn4" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange4()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>

                            <input type="text" name="bottom2" id="daily2" class="form-control" placeholder="하의2">
                            <button type="button" class="btn btn-secondary" id="linkBtn5" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange5()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="bottom3" id="daily2" class="form-control" placeholder="하의3">
                            <button type="button" class="btn btn-secondary" id="linkBtn6" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange6()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="shoes1" id="daily1" class="form-control" placeholder="신발1">
                            <button type="button" class="btn btn-secondary" id="linkBtn7" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange7()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>

                            <input type="text" name="shoes2" id="daily2" class="form-control" placeholder="신발2">
                            <button type="button" class="btn btn-secondary" id="linkBtn8" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange8()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="shoes3" id="daily2" class="form-control" placeholder="신발3">
                            <button type="button" class="btn btn-secondary" id="linkBtn9" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange9()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="etc1" id="daily1" class="form-control" placeholder="기타1">
                            <button type="button" class="btn btn-secondary" id="linkBtn10" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange10()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>

                            
                            <input type="text" name="etc2" id="daily2" class="form-control" placeholder="기타2">
                            <button type="button" class="btn btn-secondary" id="linkBtn11" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange11()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            
                            <input type="text" name="etc3" id="daily2" class="form-control" placeholder="기타3">
                            <button type="button" class="btn btn-secondary" id="linkBtn12" data-bs-toggle="modal" data-bs-target="#linkEnr" onclick="linkChange12()">링크 등록</button>&nbsp;&nbsp;&nbsp;
                            <!-- 모달 -->
                            <div class="modal fade" id="linkEnr" tabindex="-1" aria-labelledby="linkEnrLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="https://img.icons8.com/pastel-glyph/64/000000/information--v1.png"/ width="10%">
                                        <br><br>
                                        <p>구매하신 아이템의 링크를 등록해주세요!</p>
                                        <br>
                                        <input type="url" name="topLink1" id="tagLink" placeholder="상품의 링크를 입력해주세요">
                                        <br><br>
                                        <button type="submit" class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-target="#linkEnr2" data-bs-dismiss="modal">등록</button> 
                                    </div>
                                </div>
                                </div>
                            </div>
                            <!--등록시 생성 모달-->
                            <div class="modal fade" id="linkEnr2" tabindex="-1" aria-labelledby="linkEnrLabel2" aria-hidden="true">
                                <div class="modal-dialog modal-sm modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>링크가 등록되었습니다!</p>
                                        <br>
                                        <button class="btn btn-dark" id="tagBtn" data-bs-toggle="modal" data-bs-dismiss="modal">확인</button>
                                    </div>
                                </div>
                                </div>
                            </div>
                            <button type="submit" id="upload" class="btn btn-dark">업로드</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>