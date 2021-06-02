<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.common.model.vo.PageInfo,com.stylecast.qna.model.vo.Qna, java.util.ArrayList" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
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
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font end-->
    <style>
        /*div:not(#head_box,#head_of_qna,#qna_lists,#search_box,#img_btn,#input_search,#write_box,#write_box_inner,#page_box){border: 1px solid gray; box-sizing: border-box;}*/
        .wrap{width:1200px; height:1300px;  margin: auto;}
        .wrap>div{width:100%;}
        
        /* #header{height:12%;} 
        #content{height:88%;}

        /* #header>div{height:100%; float:left;}
        #header_1{width:22%;}
        #header_2{width:48%;}
        #header_3{width:20%;}
        #header_4{width:10%;} */


        /* #content_1{width:100%; height:17%;}
        #content_2{width:70%; height:48%; float: left;}
        #content_3{width:30%; height:6%; float: left;}
        #content_4{width:30%; height:42%; float:left;}
        #content_5{width:100%; height:35%; float: right;} */

        #content{
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 300;
        }

        table tbody tr td:nth-child(3){
            text-align: left;
        }
        table tbody tr:hover{
            cursor: pointer;
        }
        .answer{
            color: orangered;
            font-weight: bold;
        }

        #head_of_qna{
            font-weight: bold;
            margin-top: 30px;
            margin-left: 80px;
            margin-bottom: 10px;
        }
        #qna_lists{
            width: 80%;
            height: 65%;
            margin: auto;
        }
        #search_box{
            display: inline-flex;
            float: right;
            margin-bottom: 10px;
        }
        #img_btn{
            background-color: white;
            border: none;
        }
        #input_search{
            width: 200px;
        }
        #write_box{
            width: 80%;
            height: 3%;
            margin: auto;
        }
        #write_box_inner{
            float: right;
        }
        #page_box{
            width: 80%;
            margin: auto;
            height: 100px;
        }
        #font_qna{
        	color: rgb(241, 196, 15);
        }
    </style>
</head>
<body>
    <!-- 1페이지당 15개글이 최대-->
    <%@ include file="../common/menubar.jsp" %>
    <div class="wrap">
        <!-- <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div> -->
        
        <div id="content">
            <div id="head_box">
                <h3 id="head_of_qna">Qna</h3>
            </div>
            <div id="qna_lists">
                <div id="search_box" action="<%= contextPath %>/search.qna?currentPage=1" method="post">
                    <select class="form-select" name="search_category">
                        <option selected value="qna_title">제목</option>
                        <option value="qna_content">내용</option>
                        <option value="mem_name">작성자</option>
                    </select>
                    <input id="input_search" class="form-control" type="text" placeholder="검색내용" name="search_text">
                    <button id="img_btn" type="submit"><img src="<%=contextPath %>/resources/images/loupe.png"></button> 
                </div>
                <table class="table table-hover text-center">
                    <thead class="table-light">
                        <th width="10%">번호</th>
                        <th>구분</th>
                        <th width="35%">제목</th>
                        <th width="20%">작성자</th>
                        <th>등록일</th>
                        <th>답변여부</th>
                      </thead>
                      <tbody>
                      <%if(list.isEmpty()){ %>
                      	<tr>
                      		<td colspan="6">존재하는 공지사항이 없습니다</td>
                      	</tr>
                      <% }else{ %>
                      	<% for(Qna q : list){ %>
                      		<tr>
                      			<td><%=q.getQnaNo() %></td>
                            	<td>[<%=q.getQnaCategory() %>]</td>
                            	<td><%=q.getQnaTitle() %><img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            	<td><%=q.getMemName() %></td>
                            	<td><%=q.getEnrDate() %></td>
                            	<td><% if(q.getAnsContent() == null){ %>
                            	답변대기<%} else{%>
                            	답변완료
                            	<%} %>
                            	</td>
                      		</tr>
                      	<% } %>
                      <% } %>
                      </tbody>
                  </table>
                    <script>
                  	$(function(){
                  		$("table>tbody>tr").click(function(){
                  			// 클릭한 행의 큐엔에이 넘버 값을 가져오기
                  			var qno = $(this).children().eq(0).text();
                  			// 클릭한 행의 큐앤에이 작성자 닉네임을 가져오기
                  			var postMemName = $(this).children().eq(3).text();
                  			var adminYN = "<%=adminYN%>";
                  			var memName = "<%=memName%>";
                  			console.log(postMemName);
                  			
                  			if((adminYN =="Y") || (memName == postMemName) ){
                  				location.href = "<%=contextPath%>/detail.qna?qno=" + $(this).children().eq(0).text();
                  			}else{
                  				alert("권한이 없습니다!")
                  			}
                  			
                  			
                  		})
                  	})
                  
                  </script>
            </div>
            <div id="write_box">
                <div id="write_box_inner">
                    <!-- 로그인 안한 사용자일경우 안보이게-->
                    <% if(loginUser != null){ %>
                    	<button type="button" class="btn btn-secondary btn-sm" onclick="location.href='<%=contextPath%>/createForm.qna';">글작성</button>
                	<%} %>
                </div>
            </div>
            <!-- 여기에 페이지네이션 집 -->
            <div id="page_box" class="text-center">
             	<div align="center" class="btn-group me-2" role="group" aria-label="First group">

					<% if(currentPage != 1){ %>
            			<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/list.no?currentPage=<%=currentPage-1%>';"> &lt; </button>
					<% } %>

            		<% for(int p=startPage; p<=endPage; p++){ %>
            	
            			<% if(p != currentPage){ %>
	            			<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/list.no?currentPage=<%= p %>';"><%= p %></button>
	            		<% }else { %>
	            			<button type="button" class="btn btn-outline-secondary" disabled><%= p %></button>
            			<% } %>
            	
            		<% } %>

				<% if(currentPage != maxPage){ %>
            		<button type="button" class="btn btn-outline-secondary" onclick="location.href='<%=contextPath%>/list.no?currentPage=<%=currentPage+1%>';"> &gt; </button>
				<% } %>
			
        	</div>
        </div>

        </div>

    </div>

</body>
</html>