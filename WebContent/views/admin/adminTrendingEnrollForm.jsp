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
                border: 0px solid black;
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
                height: 82%;
                padding-left: 50px;
                overflow: auto;
            }
            #blank_box {
                height: 7%;
                font-size: 22px;
                font-weight: 600;
            }

            #control_box{
                background-color: lightgray;
                width:100%;
                height: 80%;
                }
            
            #control_head{
                height:18%;
                position: relative;
            }

            #add_box{
                width: 808px;
                height:588px;
                margin: 3px;
                background-color: white;
                overflow: auto;
                float: left;
            }

            #title_box {
                position: absolute;
                width:330px;
                height: 40px;
                top:30px;
                left: 60px;
            }
            
            #theme_name {
                width: 100%;
                height: 100%;
            }

            #select_box{
                position: absolute;
                top: 88px;
                left: 220px;
            }
            #select_box>select{
                width: 60px;
                float: left;
            }
            #select_box>div{
                float: left;
                margin-top: 2px;
            }

            #check_box{
                position: absolute;
                width: 130px;
                padding: 0%;
                top: 90px;
                left: 420px;
            }
            #check_box>div{
                float: left;
            }
            #check_box>input{
                float: left;
                margin: 5px 0px 0px 5px;
            }

            #color_box{
                position: absolute;
                width: 120px;
                top: 83px;
                left: 560px;
            }
            #color_box>div{
                float: left;
                margin-top: 7px;

            }
            #color_box>input{
                display: inline-block;
                margin: 0px 0px 0px 5px;
                left: 5px;;
            }

            #submit_button{
                position: absolute;
                top: 84px;
                left: 715px;
            }

            #room_type{
                width: 150px;
            }

            #room_type img{
                width: 150px;
                height: 150px;
            }
            .codi{
                width:200px;
                height: 240px;
                float: left;
                margin-left:53px;
                margin-top: 20px;
            }
            .codi>img{
                width: 200px;
                height: 200px;
            }
            .codi>button{
                margin-top: 3px;
                margin-left: 55px;
            }
            
            #add_none{
            	margin-top: 50px;
            	margin-left: 240px;
            }

            #add_btn{
                float: right;
                margin-top: 5px; 
            }
            #return_btn{
                float: right; 
                margin-top: 5px; 
                margin-right:5px;
            }
            
            #prof_img{height: 70%; padding: 20px;}
        	#prof_img>img{width: 100px; height: 100px;}
            #prof{height: 17%;width: 99%; float: left;}
            #prof div, #menu div{width: 100%;}
        </style>
    </head>
    <body>
    
		<%@ include file="../common/menubar.jsp"%>

        <div class="wrap">

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle"></div>
                        <div id="prof_nick" align="center">닉네임</div>
                    	<input id="contextpath" type="hidden" value="<%= contextPath %>">
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href="<%=contextPath%>/memlist.adm?blackListYN=N&&currentPage=1">회원관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="">메인관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= contextPath %>/trdlist.adm?currentPage=1"><b>트렌딩관리</b></a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%=request.getContextPath()%>/rptList.adm?brCategory=0">게시글관리</a>
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
                                <form action="<%= contextPath %>/insert.tr" method="post" id="theme_info">
                                    <div id="title_box">
                                        <input id="theme_name" name="title" class="form-control" type="text" placeholder="제목" required>
                                    </div>
                                    <div id="select_box">
                                        <select name="month" class="form-select form-select-sm">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                        <div><b>월&ensp;</b></div>
                                        <select name="week" id="" class="form-select  form-select-sm">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                        <div><b>주차</b></div>
                                    </div> 
                                    <div id="check_box" class="form-check form-switch"> 
                                        <div><b>비공개/공개</b></div>
                                        <input type="checkbox" id="status" class="form-check-input">
                                        <input type="hidden" name="status" value="">
                                    </div>
                                    <script>
                                    	$(function(){
                                    		$("#submit_button>button").on("click", function(){
                                    			if($("#status").is(":checked")) {
                                    				$("input[name=status]").val("Y");
                                    			}else{
                                    				$("input[name=status]").val("N");
                                    			}
                                    		})
                                    	});
                                    </script>
                                    <div id="color_box">
                                        <div><b>테마 색상</b></div>
                                        <input type="color" id="theme_color" name="color" class="form-control form-control-color">
                                    </div>
                                    <div id="submit_button">
                                        <button type="submit" class="btn btn-primary">적용</button>
                                    </div>
                                </form>
                            </div>
                            <div id="add_box">

								<div id="add_none"><p>&emsp;&emsp;&ensp;테마에 추가된 데일리 게시글이 없습니다.<br>항목을 추가하기 전에 테마 정보를 먼저 적용해주세요.<p></div>
                                    <script>

                                        
                                        $(document).ready(function(){
                                        	$("#add_btn").on('click', function(){
                                                addRow();
                                        		
	                            			if($(".codi").length){
	                                            $("#add_none").remove();
	                            			}

	                                        });
                                        });
                                        
                                        function addRow(){

                                            var html="<div class=\"codi\"><img src=\"img/codi4.jpg\" alt=\"\"><button name=\"del_btn\" type=\"button\" class=\"btn btn-secondary\" onClick=\"javascript:delRow(this);\">삭제하기</button>"
                                            $("#add_box").append(html);              
                                        }

                                        function delRow(object){
                                            var index = $("#codi[name=del_btn]").index(object);
                                            var none = "<div id='add_none'><p>&emsp;&emsp;&ensp;테마에 추가된 데일리 게시글이 없습니다.<br>항목을 추가하기 전에 테마 정보를 먼저 적용해주세요.<p></div>"
                                            $(".codi").eq(index).remove();
											if($(".codi").length == 0) {
	                            				$("#add_box").append(none);
	                            			}
                                        }
                                    </script>
      
                            </div>
                        </div>
                        <button type="button" id="add_btn" class="btn btn-secondary" disabled>항목추가</button>
                        <button type="button" id="return_btn" class="btn btn-secondary" onclick="location.href='<%= contextPath %>/trdlist.adm?currentPage=1'">목록</button> 

                    </div>
                </div>
            </div>
        </div>

		<script>
		
			// 컬러 인풋 값 설정
			$(document).ready(function(){
				if($("input[id=status]").is(":checked")){
					$("input[name=status]").val('Y');
				}else{
					$("input[name=status]").val('N');
				}
			});
			

		</script>
            	
            	<script>
            		// 프로필 이미지 갱신
            		$(function(){
            			
            			var cp = $("#contextpath").val();
            			
            			$.ajax({
			        		url:"profImgSelect.me",
			        		data:{
			        			memNo:<%=loginUser.getMemNo()%>
			        		},
			        		type:"post",
			        		success:function(profImg){
								$("#content #prof_img img").attr("src", cp + profImg);
			        		},error:function(){
			        			console.log("프로필 이미지 불러오기 실패");
			        		}
			        	})
            		})
            	</script>
    </body>
</html>