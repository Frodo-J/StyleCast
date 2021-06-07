<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat"%>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <!--font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
        rel="stylesheet">
    <!--font end-->
    <!--jQuery-->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!--jQuery end-->

    <script>
            
            $(function(){
                
                $("#img1").click(function(){
                    $("#input-img1").click();
                })
                $("#img2").click(function(){
                    $("#input-img2").click();
                })
                $("#img3").click(function(){
                    $("#input-img3").click();
                })
            })
        

            function loadImg(inputFile, num){
                // inputFile : 현재 변화가 생긴 input type="file" 요소객체
                // num : 몇번째 input요소인지 확인 후 해당 그영역에 미리보기하기위해서

                console.log(inputFile.files);
            	
            	
                if(inputFile.files.length == 1){ 
                    // 선택된 파일이 존재할 경우 
                    // => 선택된 파일을 읽어들여서 그 영역에 맞는 곳에 미리보기
                    // 확장자 체크
                    if(!/\.(gif|jpg|jpeg|png)$/i.test(inputFile.files[0].name)){
                    	alert('gif, jpg, png와 확장자명이 같은 이미지 파일만 선택해 주세요.\n\n현재 파일 : ' + inputFile.files[0].name);
                    	return;
                    }
                    // 파일을 읽어들일 FileReader 객체 생성
                    var reader = new FileReader();
                    
                    // 파일을 읽어들이는 메소드 => 해당 파일을 읽어들이는 순간 해당 그 파일만의 고유한 url 부여됨
                    reader.readAsDataURL(inputFile.files[0]);
                    
                    // 파일 읽기가 다 완료되었을 때 실행할 함수를 정의
                    reader.onload = function(e){
                        // 각 영역에 맞춰서 이미지 미리보기
                        switch(num){
                        case 1: $("#img1").attr("src", e.target.result); break;
                        case 2: $("#img2").attr("src", e.target.result); break;
                        case 3: $("#img3").attr("src", e.target.result); break;
                        }
                    }
                    
                }else{ // 선택된 파일이 사라졌을 경우 => 미리보기 사라지게
                    switch(num){
                    case 1: $("#img1").attr("src", null); break;
                    case 2: $("#img2").attr("src", null); break;
                    case 3: $("#img3").attr("src", null); break;
                    }
                }
                
            }

        	function goBack(){
        		window.history.back();
        	}

    </script>

    <style>
        /* div:not(#head_box, #detail_box,#notice_contents,#button_box,#notice_main,#image_lists,#input_file ){border: 1px solid gray; box-sizing: border-box;}
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        #header{height:12%;}
        #content{height:88%;}

        #header>div{height:100%; float:left;}
        #header_1{width:22%;}
        #header_2{width:48%;}
        #header_3{width:20%;}
        #header_4{width:10%;} */

        /* #content_1{width:100%; height:17%;}
        #content_2{width:70%; height:48%; float: left;}
        #content_3{width:30%; height:6%; float: left;}
        #content_4{width:30%; height:42%; float:left;}
        #content_5{width:100%; height:35%; float: right;} */
		
		.wrap{width:1200px; height:1300px;  margin: auto;}
        .wrap>div{width:100%;}
        
       	#content{
                font-family: 'Noto Sans KR', sans-serif;
                font-weight: 300;
        }

        #head_of_notice{
            font-weight: bold;
            margin-top: 30px;
            margin-left: 80px;
            margin-bottom: 10px;
        }
        #detail_box{
            width: 80%;
            margin: auto;
            margin-top: 20px;
        }
        #notice_contents{
            height: 500px;
            overflow: auto;
            /* div영역내에 이미지가 넘쳤을 경우 스크롤 생김 */
        }
        #button_box{
            margin: auto;
            width: 80%;
        }
        #notice_submit, #notice_cancel{
            float: right;
            margin: 3px;
        }
        #image_lists{
            max-height: 200px;
            overflow: auto;
        }
        #image_lists img{
            margin: 2px;
        }
        #font_notice{
        	color: rgb(241, 196, 15);
        
        } 
        
    </style>
    
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="wrap">
    <!--  
        <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div>
       -->
        <div id="content">
            <div id="head_box">
                <h3 id="head_of_notice">Notice</h3>
            </div>
            <form action="<%= contextPath %>/insert.no" id="enroll-form" method="post" enctype="multipart/form-data">
            <div id="detail_box">
            	<input type="hidden" name="userNo" value="<%= loginUser.getMemNo() %>">
                <table class="table">
                    <tr>
                        <th width=13%>제목</th>
                        <td width=57%><input type="text" name="title" style="font-weight:300" placeholder="제목을 입력해주세요" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required></td>
                        <th width=10%>작성일자</th>
                        <td width=20%><%= sf.format(nowTime) %></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="3">
                            <div id="notice_contents">
                                <textarea class="form-control" name="content" placeholder="내용을 입력해주세요" id="floatingTextarea2" style="height: 100%; font-weight:300"></textarea>
                            </div>
                        </td>
                    </tr>
                    <tr style="display: none;">
                        <th>이미지1</th>
                        <td colspan="3">
                            <div id="input_file" class="input-group">
                                <input type="file" class="form-control" id="input-img1" name="image1" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="loadImg(this,1);">
                            </div>
                        </td>
                    </tr>
                    <tr style="display: none;">
                        <th>이미지2</th>
                        <td colspan="3">
                            <div id="input_file" class="input-group">
                                <input type="file" class="form-control" id="input-img2" name="image2" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="loadImg(this,2);">
                            </div>
                        </td>
                    </tr>
                    <tr style="display: none;">
                        <th>이미지3</th>
                        <td colspan="3">
                            <div id="input_file" class="input-group">
                                <input type="file" class="form-control" id="input-img3" name="image3" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="loadImg(this,3);">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>이미지 첨부</th>
                        <td colspan="3">
                            <div id="image_lists">
                                <img id="img1" width="200" height="150" src="<%=contextPath %>/resources/images/add.png" onerror="javascript:this.src='<%=contextPath %>/resources/images/add.png'"/>
                                <img id="img2" width="200" height="150" src="<%=contextPath %>/resources/images/add.png" onerror="javascript:this.src='<%=contextPath %>/resources/images/add.png'"/>
                                <img id="img3" width="200" height="150" src="<%=contextPath %>/resources/images/add.png" onerror="javascript:this.src='<%=contextPath %>/resources/images/add.png'"/>
                            </div>
                        </td>
                    </tr>
                    
                </table>
            </div>
            <div id="button_box">
                <button id="notice_cancel" type="button" class="btn btn-secondary" onclick="goBack();">취소</button>
                <button id="notice_submit" type="submit" class="btn btn-primary" >등록</button>
            </div>
            </form>
        </div>

    </div>

</body>
</html>