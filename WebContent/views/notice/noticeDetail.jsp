<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.stylecast.notice.model.vo.*, java.util.ArrayList, com.stylecast.common.model.vo.BoardImage"%>
<%
	Notice n = (Notice)request.getAttribute("n");
	ArrayList<BoardImage> imgList = (ArrayList<BoardImage>)request.getAttribute("imgList");
	String content = n.getNoticeContent();
	content = content.replace("\r\n","<br>");
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
    <style>
        /*div:not(#head_box, #detail_box,#notice_contents,#button_box,#notice_main ){border: 1px solid gray; box-sizing: border-box;}
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        #header{height:12%;}
        #content{height:88%;}

        #header>div{height:100%; float:left;}
        #header_1{width:22%;}
        #header_2{width:48%;}
        #header_3{width:20%;}
        #header_4{width:10%;}
*/
        /* #content_1{width:100%; height:17%;}
        #content_2{width:70%; height:48%; float: left;}
        #content_3{width:30%; height:6%; float: left;}
        #content_4{width:30%; height:42%; float:left;}
        #content_5{width:100%; height:35%; float: right;} */
		
		.wrap{width:1200px; height:1300px;  margin: auto;}
        .wrap>div{width:100%;}
        
        #content {
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
            height: 750px;
            overflow: auto;
            /* div영역내에 이미지가 넘쳤을 경우 스크롤 생김 */
        }
        #button_box{
            margin: auto;
            width: 80%;
        }
        #notice_main{
            float: right;
        }
        #font_notice{
        	color: rgb(241, 196, 15);
        
        } 
    </style>
    <script>
    	function goBack(){
    		window.history.back();
    	}
    </script>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="wrap">
        <!--  <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div>-->
        <div id="content">
            <div id="head_box">
                <h3 id="head_of_notice">Notice</h3>
            </div>
            <div id="detail_box">
                <table class="table">
                    <tr>
                        <th width=10%>제목</th>
                        <td width=60%><%= n.getNoticeTitle() %></td>
                        <th width=10%>등록일</th>
                        <td width=10%><%=n.getEnrDate()%></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td><%=n.getMemName() %></td>
                        <th>조회수</th>
                        <td><%=n.getCount() %></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="3">
                            <div id="notice_contents">
                               	<%=content%>
                               	<br>
                                <!--첨부파일 이미지 있으면 여기아래 처리-->
                                <% for(int i=0; i<imgList.size(); i++){ %>
                                	<img src="<%=contextPath %>/<%= imgList.get(i).getImgPath()%>" width="500" height="550"/>
								<%} %>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="button_box">
                <!--아래 두개 버튼은 관리자만 보이게끔-->
                <% if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
                	<button type="button" class="btn btn-secondary btn-sm" onclick="location.href='<%=contextPath%>/updateForm.no?nno=<%=n.getNoticeNo()%>';">수정</button>
                	<button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#exampleModalToggle_rept">삭제</button>
                 <% } %>
                <button id="notice_main" type="button" class="btn btn-secondary btn-sm" onclick="location.href='<%=contextPath%>/list.no?currentPage=1'">목록으로 가기</button>
            </div>
            
             <!-- Modal -->
                        <div
                            class="modal fade"
                            id="exampleModalToggle_rept"
                            aria-hidden="true"
                            aria-labelledby="exampleModalToggleLabel"
                            tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalToggleLabel">
                                            <b>공지글 삭제</b>
                                        </h5>
                                        <button
                                            type="button"
                                            class="btn-close"
                                            data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        	정말 공지글을 삭제하시겠습니까?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                                        <button
                                            class="btn btn-primary"
                                            data-bs-target="#exampleModalToggle_rept2"
                                            data-bs-toggle="modal"
                                            data-bs-dismiss="modal">삭제하기</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div
                            class="modal fade"
                            id="exampleModalToggle_rept2"
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
                                        	삭제되었습니다!
                                    </div>
                                    <div class="modal-footer">
                                        <button
                                            class="btn btn-primary"
                                            data-bs-toggle="modal"
                                            data-bs-dismiss="modal"
                                            onclick="location.href='<%=contextPath%>/delete.no?nno=<%=n.getNoticeNo()%>';">확인</button>
                                    </div>
                                </div>
                            </div>
                        </div>
        </div>

    </div>

</body>
</html>