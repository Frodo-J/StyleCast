<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.stylecast.qna.model.vo.Qna, com.stylecast.common.model.vo.PageInfo" %>
 <%
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
 	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");

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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!--text-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <style>
        *{
            font-family: 'Noto Sans KR', sans-serif;
        }

        div{
            /*border: 1px solid black;*/
            box-sizing: border-box;
        }
       
        .wrap{width:1200px; height:1144px;  margin: auto;}

        #header, #content{width:100%;}
        #content{height:100%; width: 90%; margin: auto;}

        #side, #mypage_box{float: left; height: 100%;}
        #side{width: 20%;}
        #mypage_box{
            width: 80%;
            padding-top: 40px;
            padding-left: 50px;
            position: relative;
        }

        #line{width: 1.5px; height:90%; float:right; background: lightgrey;}
        #prof, #menu{width: 99%; float: left;}
        #prof{height: 17%;}
        #menu{height: 83%; padding-left: 10px;}

        /* 사이드바 상세 css */
        #prof div, #menu div{width: 100%;}
        #menu a{color: black; text-decoration: none;}

        #prof_img{height: 70%; padding: 20px; /*border: solid 1px red;*/}
        #prof_img>img{width: 100px; height: 100px;}

        #write>div{font-size: 13px; padding-left: 20px; margin-top: 8px;}
        #menu>div{margin-bottom: 15px;}

        /* 프로필 이미지 수정 모달 css */
        #prof-title h3{
            padding-top: 10px;
            font-weight: bold;
        }

        .prof-body{width: 100%; height: 63%;}

        .prof-body>div{
            height: 100%;
            float:left;
        }

        #prof-img{width: 35%; /*border: solid 1px red;*/}
        #prof-img>img{width: 100px; height: 100px;}
        #prof-delete{height: 30px;}
        #prof-input{width: 65%;}

        .prof-body button{
            width: 50px;
            margin: 15px;
        }

        /* 문의 게시판 css */
        #mypage_box div{float: left;}

        table tbody tr td:nth-child(2){
            text-align: left;
        }

        #reply_list{
            width: 90%;
            margin: auto;
        }
        
        /* 페이지 박스 css */
        #page_box{
            width: 90%;
            margin: auto;
            height: 100px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
    
    <div class="wrap">

        <div id="content">
            <div id="side">

                <div id="line"></div>
                
                <div id="prof">
                    <div id="prof_img" align="center"><img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle"></div>
                    <div id="prof_nick" align="center"><%= loginUser.getMemName() %></div>
                    <input id="contextpath" type="hidden" value="<%= contextPath %>">
                </div>

                <div id="menu">
                    <div id="write" style="font-weight: bold;">
                        	내가 쓴 글
                        <div><a href="<%= request.getContextPath() %>/myPage.me" style="font-weight: normal;">데일리</a></div>
                        <div><a href="<%= request.getContextPath() %>/reply.me?currentPage=1" style="font-weight: normal;">댓글</a></div>
                        <div><a href="<%= request.getContextPath() %>/question.me?currentPage=1">문의글</a></div>
                    </div>
                    <div><a href="<%= request.getContextPath() %>/bookmark.me">북마크</a></div>
                    <div><a href="<%= request.getContextPath() %>/myMember.me">개인정보 수정</a></div>
                    <% if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
                    	<div><a href="<%= request.getContextPath() %>/memlist.adm?blackListYN=N&&currentPage=1">관리자 페이지</a></div>
                    <% } %>
                </div>
            </div>

            <!-- 프로필 이미지 수정 모달 -->
            <div class="modal fade" id="profModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                    <h5 class="prof-title" id="reportModalLabel" align="center">프로필 이미지 수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="prof-body" align="center">
                        <form name="profImg_update" style="line-height: 30px;">
                            <div id="prof-img">
                                <img src="<%= contextPath %>/<%= loginUser.getProfImg() %>" class="rounded-circle">
                                <button id="prof-delete" class="btn btn-light btn-sm">삭제</button>
                            </div>
                            <div id="prof-input"><input type="file" name="userProfImg"></div>  
                            <input type="hidden" name="memId" value="<%=loginUser.getMemId()%>">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin: auto;">취소</button>
                            &emsp;&emsp;
                            <button type="button" class="btn btn-primary" onclick="imgUpdate(profImg_update);" style="width: 90px;">등록</button>
                        </form>
                    </div>
                </div>
                </div>
            </div>

            <!-- 프로필 이미지 수정 모달 띄우기 -->
            <script>
                $("#prof_img").click(function(){
                    $("#profModal").modal("show");
                })
            </script>
            
            <script>
	            function imgUpdate(formName){
	        		formName.action = "/StyleCast/updateProf.me";
	        		formName.method = "post";
	        		formName.enctype = "multipart/form-data";
	        		formName.submit();
	        	}
            </script>

            <div id="mypage_box">
                <b>내가 쓴 글 > 문의글</b>
            <br><br>

            <div id="reply_list">
                <table class="table table-hover text-center">
                    <thead class="table-light">
                        <tr>
                            <th width="10%">번호</th>
                            <th width="60%">제목</th>
                            <th>등록일</th>
                            <th>처리상태</th>
                        </tr>
                      </thead>
                      <tbody>
                      
                      <%if(list.isEmpty()){ %>
                      
                      <!-- 문의글이 없을 경우 -->
						<tr>
                            <td colspan="4">작성한 문의글이 없습니다.</td>
                        </tr>
                        
                      <%} else{%>
                      
                      <!-- 문의글이 있을 경우 -->
                      <%for(Qna qna : list){ %>
                        <tr>
                            <td><%=qna.getQnaNo() %></td>
                            <td><%=qna.getQnaTitle() %></td>
                            <td><%=qna.getEnrDate() %></td>
                            <td>
                            	<%if(qna.getAnsContent() == null || qna.getAnsContent().equals("")) {%>
                            	처리중
                            	<% }else { %>
                            	처리완료
                            	<%} %>
                            </td>
                        </tr>
                       <%} %>
                      <%} %>
                      </tbody>
                  </table>
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
								$(".modal-content #prof-img img").attr("src", cp + profImg);
			        		},error:function(){
			        			console.log("프로필 이미지 불러오기 실패");
			        		}
			        	})
            		})
            	</script>
            
            <!-- 
            <script>
	            $("table>tbody>tr").click(function(){
	            	location.href = "<%=contextPath%>/detail.da?dno=" + $(this).children().eq(3).text();
		        });
            </script>
            -->

            <div id="page_box">
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                    	
               			<% if(currentPage == 1){ %>
               				<!-- 현재 페이지가 1일 때 -->
							<li class="page-item disabled">
		                       <a class="page-link" href="<%=contextPath%>/question.me?currentPage=<%= currentPage-1 %>" tabindex="-1" aria-disabled="true">&laquo;</a>
		                    </li>
						<% }else { %>
               				<!-- 현재 페이지가 1이 아닐 때 -->
							<li class="page-item">
		                       <a class="page-link" href="<%=contextPath%>/question.me?currentPage=<%= currentPage-1 %>" tabindex="-1" aria-disabled="true">&laquo;</a>
		                    </li>
						<%} %>
                      
                      <% for(int p=startPage; p<=endPage; p++){ %>
                      	<% if(p != currentPage){ %>
                      		<li class="page-item"><a class="page-link" href="<%=contextPath%>/question.me?currentPage=<%= p %>"><%= p %></a></li>
                      	<% }else { %>
                      	<!-- 현재 페이지 버튼 -->
                      		<li class="page-item disabled"><button class="page-link"><%= p %></button></li>
                      	<% } %>
                      <% } %>
                      
                      <% if(currentPage == maxPage){ %>
               				<!-- 현재 페이지가 마지막 페이지일 때 -->
							<li class="page-item disabled">
		                       <a class="page-link" href="<%=contextPath%>/question.me?currentPage=<%= currentPage-1 %>" tabindex="-1" aria-disabled="true">&raquo;</a>
		                    </li>
						<% }else { %>
               				<!-- 현재 페이지가 1이 아닐 때 -->
							<li class="page-item">
		                       <a class="page-link" href="<%=contextPath%>/question.me?currentPage=<%= currentPage+1 %>">&raquo;</a>
		                    </li>
						<%} %>
                    </ul>
                  </nav>
            </div>
            </div>
        </div>
    </div>
</body>
</html>