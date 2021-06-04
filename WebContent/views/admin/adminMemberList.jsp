<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.common.model.vo.PageInfo, com.stylecast.member.vo.Member, java.util.ArrayList" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	String blackListYN = request.getParameter("blackListYN");
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

            #content {
                font-family: 'Noto Sans KR', sans-serif;
                font-weight: 300;
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
            #prof_img{height: 70%; padding: 20px;}
            #prof{height: 17%;width: 99%; float: left;}
            #prof div, #menu div{width: 100%;}
        </style>
    	<script>
    	$(function(){
    		console.log("<%=blackListYN%>");
    	})
    	</script>
    </head>
    <body>
        <!--참고하면 좋은 글-->
        <!--modal form submit에 관한 글-->
        <!-- https://codevang.tistory.com/287 -->
        <!--자바스크립트문으로 form전송 -->
        <!--https://all-record.tistory.com/172-->
        <%@ include file="../common/menubar.jsp" %>
        <div class="wrap">

            <div id="content">
                <div id="side">

                    <div id="line"></div>
                    <div id="prof">
                        <div id="prof_img" align="center"><img src="<%=contextPath %>/resources/images/prof.PNG"></div>
                        <div id="prof_nick" align="center"><b>닉네임</b></div>
                    </div>
                    <div id="menu">
                        <div>
                            <h4>
                                <a href="<%=contextPath%>/memlist.adm?blackListYN=N&&currentPage=1"><b>회원관리</b></a>
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
                    <!-- <h2 style="text-align: center;">
                        <b>회원관리</b>
                    </h2> -->
                    <!-- <br>
                    <div id="line2"></div> -->
                    
                    <div id="content_of_form">
                        <div id="blank_box"><h5><b>회원관리</b></h5></div>
                        <div id="control_box">
                            <div id="search_box">
                                <select class="form-select">
                                    <option selected="selected" value="1">아이디</option>
                                    <option value="2">이메일</option>
                                    <option value="3">닉네임</option>
                                </select>
                                <input id="input_search" class="form-control" type="text" placeholder="검색내용">
                                <button id="img_btn" type="button"><img src="<%=contextPath%>/resources/images/loupe.png"></button>
                            </div>
                            <div id="black_box">
                                <div class="form-check form-switch">
                                	<%if(blackListYN.equals("Y")){ %>
                             		<%=blackListYN %>
                                    <label class="form-check-label" for="flexSwitchCheckDefault">
                                        <b>블랙회원 보이기 OFF/ON</b>
                                    </label>
                                    <input class="form-check-input" type="checkbox" name="blackYN" id="flexSwitchCheckDefault" checked onclick="goToBlackN();"/>
                                	<%}else if(blackListYN.equals("N")){ %>
                                		<%=blackListYN %>
                                		<label class="form-check-label" for="flexSwitchCheckDefault">
                                        <b>블랙회원 보이기 OFF/ON</b>
                                    	</label>
                                    <input class="form-check-input" type="checkbox" name="blackYN" id="flexSwitchCheckDefault" onclick="goToBlackY();" />
                                	<%} %>
                                </div>
                            </div>
                            <script>
                            	function goToBlackN(){
                            		location.href = "<%=contextPath%>/memlist.adm?blackListYN=N&&currentPage=1";
                            	}
                            	
                            	function goToBlackY(){
                            		location.href = "<%=contextPath%>/memlist.adm?blackListYN=Y&&currentPage=1";
                            	}
                            </script>
                        </div>
                        <div id="table_box">
                            <form name="mem_detail">
                                <table class="table table-bordered table-hover">
                                    <thead class="table-secondary">
                                        <th width="10%">경고횟수</th>
                                        <th>회원번호</th>
                                        <th width="20%">이메일</th>
                                        <th width="20%">아이디</th>
                                        <th>닉네임</th>
                                        <th>블랙 여부</th>
                                        <th>블랙 적용/해제</th>
                                    </thead>
                                    <tbody>
                                    	<% if(list.isEmpty()) { %>
                                    		<tr> <td colspan="7"> 멤버가 없습니다. </td></tr> 
                                    	<% }else{ %>
                                    		<% for(Member m : list){%>
                                    		<tr>
                                            		<td><%=m.getWarning() %>번</td>
                                            		<td><%=m.getMemNo() %></td>
                                            		<td><%=m.getEmail() %></td>
                                            		<td><%=m.getMemId() %></td>
                                            		<td><%=m.getMemName() %></td>
                                            		<td><%=m.getBlackYN() %></td>
                                            		<td align="center">
                                            		<% if(m.getBlackYN().equals("N")){%>
                                                		<button
                                                    		type="button"
                                                    		class="btn btn-secondary btn-sm black_btn"
                                                    		data-bs-toggle="modal"
                                                    		data-bs-target="#exampleModalToggle">블랙 적용</button>
                                                    <%}else if(m.getBlackYN().equals("Y")){ %>
                                                    	<button
                                                    		type="button"
                                                    		class="btn btn-secondary btn-sm black_btn"
                                                    		data-bs-toggle="modal"
                                                    		data-bs-target="#exampleModalNoneBK">블랙 해제</button>
                                                    <%} %>
                                            		</td>
                                        		</tr>
                                    		<% } %>
                                    	<% } %>
                                    </tbody>
                                </table>
                            </form>

                        </div>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalToggleLabel"><b>블랙 적용</b></h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                  정말로 블랙 처리 하시겠습니까?
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                                  <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal" data-bs-dismiss="modal">적용하기</button>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalToggleLabel2"><b>확인창</b></h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                  적용되었습니다!
                                </div>
                                <div class="modal-footer">
                                  <button class="btn btn-primary" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="yBlackMem(mem_detail)">확인</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        <!-- 모달 끝 -->
                        
                       	 <!-- Modal -->
                        <div class="modal fade" id="exampleModalNoneBK" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalToggleLabel"><b>블랙 해제</b></h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                  정말 블랙을 해제 하시겠습니까?
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                                  <button class="btn btn-primary" data-bs-target="#exampleModalNoneBK2" data-bs-toggle="modal" data-bs-dismiss="modal">적용하기</button>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="modal fade" id="exampleModalNoneBK2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalToggleLabel2"><b>확인창</b></h5>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                  해제되었습니다!
                                </div>
                                <div class="modal-footer">
                                  <button class="btn btn-primary" data-bs-toggle="modal" data-bs-dismiss="modal" onclick="nBlackMem(mem_detail)">확인</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        <script>
                            //no는 전달된 회원번호를 의미합니다.
                            var memNo = 0;
                            $('.black_btn').click(function() {
                                var btn = $(this);
                                var tr = btn
                                    .parent()
                                    .parent();
                                var td = tr.children();

                                memNo = td
                                    .eq(1)
                                    .text();
                                console.log(memNo);
                            });

                            function yBlackMem(formName) {
                                console.log("전달된 no는 " + memNo);
                                formName.action = "<%= contextPath %>/updateblacky.adm?memNo=" + memNo;
                                formName.method = "post";
                                formName.submit();

                            }
                            function nBlackMem(formName) {
                                console.log("전달된 no는 " + no);
                                formName.action = "";
                                formName.method = "post";
                                formName.submit();

                            }
                        </script>
                        <br>
                        <div id="page_box" class="text-center">
                            <div align="center" class="btn-group me-2" role="group" aria-label="First group">

							<% if(currentPage != 1){ %>
            					<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/memlist.adm?blackListYN=<%=blackListYN%>&&currentPage=<%=currentPage-1%>';"> &lt; </button>
							<% } %>

            				<% for(int p=startPage; p<=endPage; p++){ %>
            	
            					<% if(p != currentPage){ %>
	            					<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/memlist.adm?blackListYN=<%=blackListYN%>&&currentPage=<%= p %>';"><%= p %></button>
	            				<% }else { %>
	            					<button type="button" class="btn btn-outline-secondary" disabled><%= p %></button>
            					<% } %>
            	
            				<% } %>
						<% if(currentPage == 1 && maxPage == 0 && endPage == 0){ %>
						
						<% } else if(currentPage != maxPage){ %>
            				<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/memlist.adm?blackListYN=<%=blackListYN%>&&currentPage=<%=currentPage+1%>';"> &gt; </button>
						<% } %>
			
        					</div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>