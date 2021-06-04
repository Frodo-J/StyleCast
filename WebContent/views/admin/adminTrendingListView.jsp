<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.stylecast.common.model.vo.PageInfo, com.stylecast.admin.model.vo.*, com.stylecast.theme.model.vo.*, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Theme> list = (ArrayList<Theme>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
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

            #add_box {
                float: right;
                margin-bottom:10px;
            }
            #prof_img{height: 70%; padding: 20px;}
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
                        <div id="prof_img" align="center"><img src="img/prof.PNG"></div>
                        <div id="prof_nick" align="center"><b>닉네임</b></div>
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href="">회원관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="">메인관리</a>
                            </h4>
                        </div>
                        <div>
                            <h4>
                                <a href="<%= contextPath %>/admin.tr?currentPage=1"><b>트렌딩관리</b></a>
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
                            <div id="add_box">
                                    <button type="button" onclick = "location.href = '상세경로'" id="add" class="btn btn-primary ">추가</button>
                            </div>
                        </div>
                        <div id="table_box">
                            <form name="trending_detail">
                                <table class="table table-hover text-center">
                                    <thead class="table-light">
                                        <th width="13%">번호</th>
                                        <th width="54%">제목</th>
                                        <th width="20%">월/주차</th>
                                        <th width="13%">상태</th>
                                    </thead>
                                    <tbody>
                                    	<% for(Theme t : list) { %>
	                                        <tr>
	                                            <td><%= t.getThemeNo() %></td>
	                                            <td><%= t.getThemeTitle() %></td>
	                                            <td><%= t.getThemeSubtitle() %></td>
	                                            <% if(t.getStatus().equals("Y")) { %>
	                                            	<td>공개</td>
	                                            <% }else { %>
	                                            	<td>비공개</td>
	                                            <% } %>
	                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </form>

                        </div>

                        <br>

						<div id="navigation">
							<ul class="pagination">
								<li class="page-item">
									<% if(currentPage != 1) { %> <a class="page-link prevPage"
									href="<%=contextPath%>/admin.tr?currentPage=<%=currentPage-1%>"
									aria-label="Previous"> <span aria-hidden="true">&lt;</span>
								</a> <% } %>
								</li>
								<% for(int p=startPage; p<=endPage; p++) { %>
								<li class="page-item">
									<% if(p != currentPage) { %> <a class="page-link"
									href="<%=contextPath%>/admin.tr?currentPage=<%= p %>"><%= p %></a>
									<% }else { %> <a class="page-link" href="#"><%= p %></a> <% } %>
								</li>
								<% } %>
								<li class="page-item">
									<% if (currentPage != maxPage) { %> <a class="page-link nextPage"
									href="<%=contextPath%>/admin.tr?currentPage=<%=currentPage+1%>"
									aria-label="Next"> <span aria-hidden="true">&gt;</span>
								</a> <% } %>
								</li>
							</ul>
		
						</div>

                    </div>

                </div>
            </div>

        </div>

    </body>
</html>