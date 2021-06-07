<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.common.model.vo.PageInfo, java.util.ArrayList, com.stylecast.admin.model.vo.*, java.text.SimpleDateFormat" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Codi> list = (ArrayList<Codi>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
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
            }
            #blank_box {
                height: 8%;
            }
            #search_box {
                width: 150px;
                display: inline-flex;
                float: right;
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
                width: 100%;
                height: 70%;
                border-radius: 3px;
                overflow-x: auto;
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
            .thumbnail {
                border: 2px solid gray;
                border-radius: 6px;
                width: 220px;
                display: inline-block;
                margin: 14px;
            }
            .thumbnail:hover {
                cursor: pointer;
            }
            #control_box {
                margin-left: 12px;
            }
            #weather_select {
                margin-right: 5px;
            }
            #page_box {
                width: 90%;
            }
            #write_box {
                width: 80%;
                height: 3%;
                margin: auto;
            }
            #write_box_inner {
                float: right;
            }
            #navigation{position: absolute; margin-top: 970px; margin-left: 500px;}
            #button{
            	float: right;
            	margin-right:79px;
            }
            #prof_img>img{width: 100px; height: 100px;}
            #prof_img{ height: 70%; padding: 20px;}
            #prof{height: 17%;width: 99%; float: left;}
            #prof div, #menu div{width: 100%;}
        </style>
<title>Insert title here</title>
</head>
<body>
		<%@ include file="../common/menubar.jsp" %>

        <div class="wrap">

            

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle"/></div>
                        <div id="prof_nick" align="center"><b><%=loginUser.getMemName()%></b></div>
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
                                <a href="<%= request.getContextPath() %>/codilist.ad?currentPage=1">
                                    <b>메인관리</b>
                                </a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= contextPath %>/trdlist.adm?currentPage=1">트렌딩관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%=contextPath%>/rptList.adm?brCategory=0&&currentPage=1">게시글관리</a>
                            </h4>
                        </div>
                    </div>
                </div>
				
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
                        <form id="control_box" action="<%=contextPath %>/searchCodi.ad?currentPage=1">
                        	<input
                            	class="form-check-input"
                                type="radio"
                                name="gender"
                                id="flexRadioDefault1"
                                value="ALL"
                                checked="checked">
                            <label class="form-check-label" for="flexRadioDefault1" >
                         	  	모두
                            </label>
                            <input
                            	class="form-check-input"
                                type="radio"
                                name="gender"
                                id="flexRadioDefault1"
                                value="M">
                            <label class="form-check-label" for="flexRadioDefault1" >
                         	  	남성
                            </label>
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
							<div id="button">
								<button class="btn btn-primary" type="submit" >적용</button>
							</div>
							<input type="hidden" name="currentPage" value="1">
                            <div id="search_box">
                                <select class="form-select" id="weather_select" name="weather_select">
                                    <option selected="selected" value="ALL">날씨 전체 조회</option>
                                    <option value="CLEAR">맑음/흐림</option>
                                    <option value="RAIN">비/눈</option>
                                </select>
                            </div>
                        </form>
                        <div id="codi_box">
                        	<% for(Codi c : list){ %>
                            <div class="thumbnail" align="center">
                            	<a href="<%= request.getContextPath() %>/codiUpDate.ad?cno=<%=c.getCodiNo() %>" style="text-decoration:none; color:black">
                                <input type="hidden" value="<%= c.getCodiNo() %>">
                                <img src="<%= c.getImgPath() %>" width="190" height="200">
                                <p>
                                    <b><%= c.getRecWeather() %>/<%= c.getRecLowT() %>/<%= c.getRecHighT() %>/<%=c.getGender() %></b>
                                </p>
                                </a>
                            </div>
                            <% } %>
                            <!-- 
                            <div class="thumbnail" align="center">
                                <input type="hidden" value="">
                                <img src="images/codi_bk.PNG" width="190" height="200">
                                <p>
                                    <b>
                                        sunny / 22 / 17
                                    </b>
                                </p>
                            </div>
                            <div class="thumbnail" align="center">
                                <input type="hidden" value="">
                                <img src="images/codi_sb.PNG" width="190" height="200">
                                <p>
                                    <b>sunny / 22 / 17
                                    </b>
                                </p>
                            </div>
                            <div class="thumbnail" align="center">
                                <input type="hidden" value="">
                                <img src="images/codi_bk.PNG" width="190" height="200">
                                <p>
                                    <b>
                                        sunny / 22 / 17
                                    </b>
                                </p>
                            </div>
                            <div class="thumbnail" align="center">
                                <input type="hidden" value="">
                                <img src="images/codi_sb.PNG" width="190" height="200">
                                <p>
                                    <b>sunny / 22 / 17
                                    </b>
                                </p>
                            </div>
                            <div class="thumbnail" align="center">
                                <input type="hidden" value="">
                                <img src="images/codi_bk.PNG" width="190" height="200">
                                <p>
                                    <b>
                                        sunny / 22 / 17
                                    </b>
                                </p>
                            </div>
                             -->

                        </div>
                        <div id="write_box">
                            <div id="write_box_inner">
                                <!-- 사용자일경우 안보이게-->
                                <a type="button" class="btn btn-primary" href ="<%= request.getContextPath() %>/codiCreate.ad">코디 추가</a>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div id="page_box" class="text-center">
			             	<div align="center" class="btn-group me-2" role="group" aria-label="First group">
			
								<% if(currentPage != 1){ %>
			            			<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/codilist.ad?currentPage=<%=currentPage-1%>';"> &lt; </button>
								<% } %>
			
			            		<% for(int p=startPage; p<=endPage; p++){ %>
			            	
			            			<% if(p != currentPage){ %>
				            			<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/codilist.ad?currentPage=<%= p %>';"><%= p %></button>
				            		<% }else { %>
				            			<button type="button" class="btn btn-outline-secondary" disabled><%= p %></button>
			            			<% } %>
			            	
			            		<% } %>
			
							<% if(currentPage != maxPage){ %>
			            		<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/codilist.ad?currentPage=<%=currentPage+1%>';"> &gt; </button>
							<% } %>
						
			        	</div>
			        </div>

                    </div>

                </div>
                
                <br>

            </div>

        </div>
	
</body>
</html>