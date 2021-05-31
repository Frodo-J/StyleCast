<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stylecast.common.model.vo.PageInfo,com.stylecast.qna.model.vo.Qna, java.util.ArrayList" %>
<%
	/*PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	*/
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
        /* div:not(#head_box,#head_of_qna,#qna_lists,#search_box,#img_btn,#input_search,#write_box,#write_box_inner,#page_box){border: 1px solid gray; box-sizing: border-box;}
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;} */
        /* #header{height:12%;} */
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
    <div class="wrap">
    	<%@ include file="../common/menubar.jsp" %>
        <!-- <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div> -->
        
        <div id="content">
            <div id="head_box">
                <h2 id="head_of_qna">Qna</h2>
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
                        <th width="15%">구분</th>
                        <th width="50%">제목</th>
                        <th>작성자</th>
                        <th width="15%">등록일</th>
                        <th width="10%">답변여부</th>
                      </thead>
                      <tbody>
                        <tr>
                            <td>15</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>14</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>13</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>12</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>[오류/버그]</td>
                            <td>문의문의<img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                          </tr>
                        <tr>
                            <td>8</td>
                            <td>[오류/버그]</td>
                            <td>문의문의 </td>
                            <td>adfasfs</td>
                            <td>2021-05-21</td>
                            <td>답변대기</td>
                          </tr>
                        <tr>
                            <td>7</td>
                            <td>[기타문의]</td>
                            <td>문의 <img src="<%=contextPath %>/resources/images/padlock.png"/></td>
                            <td>admin</td>
                            <td>2021-05-20</td>
                            <td>답변대기</td>
                          </tr>
                        <tr>
                            <td>6</td>
                            <td>[사이트이용]</td>
                            <td>문의입니다.<img src="<%=contextPath %>/resources/images/padlock.png"/> <span class="answer">[1]</span> </td>
                            <td>mdf</td>
                            <td>2021-05-12</td>
                            <td>답변완료</td>
                          </tr>
                        <tr>
                            <td>5</td>
                            <td>[건의사항]</td>
                            <td>문의입니다. 답변해주세요 <img src="<%=contextPath %>/resources/images/padlock.png"/> <span class="answer">[1]</span> </td>
                            <td>addsf</td>
                            <td>2021-05-10</td>
                            <td>답변완료</td>
                          </tr>
                        <tr>
                            <td>4</td>
                            <td>[사이트이용]</td>
                            <td>문의문의 <img src="<%=contextPath %>/resources/images/padlock.png"/> <span class="answer">[1]</span> </td>
                            <td>dafsdaf</td>
                            <td>2021-05-01</td>
                            <td>답변완료</td>
                          </tr>
                        <tr>
                            <td>3</td>
                            <td>[기타문의]</td>
                            <td>문의입니다. <img src="<%=contextPath %>/resources/images/padlock.png"/> <span class="answer">[1]</span> </td>
                            <td>admin</td>
                            <td>2021-05-01</td>
                            <td>답변완료</td>
                          </tr>
                        <tr>
                            <td>2</td>
                            <td>[가입/로그인]</td>
                            <td>가입문의 드립니다. 빨리 답변해주세요!!!!!!!!!!!!!!!!!  <img src="<%=contextPath %>/resources/images/padlock.png"/><span class="answer">[1]</span> </td>
                            <td>abcv11</td>
                            <td>2021-05-01</td>
                            <td>답변완료</td>
                          </tr>
                        <tr>
                          <td>1</td>
                          <td>[사이트이용]</td>
                          <td>문의  <img src="<%=contextPath %>/resources/images/padlock.png"/> <span class="answer">[1]</span></td>
                          <td>asdfa</td>
                          <td>2021-05-01</td>
                          <td>답변완료</td>
                        </tr>
                        <!--글이 없을 경우-->
                        <!-- <tr>
                            <td colspan="6">글이 없습니다.</td>
                        </tr> -->
                        <!--검색결과가 없을 경우-->
                        <!-- <tr>
                            <td colspan="6">'OO'가 포함된 검색어를 찾을 수 없습니다.</td>
                        </tr> -->
                      </tbody>
                  </table>
            </div>
            <div id="write_box">
                <div id="write_box_inner">
                    <!-- 사용자일경우 안보이게-->
                    <% if(loginUser != null){ %>
                    <button type="button" class="btn btn-secondary btn-sm">글작성</button>
                	<%} %>
                </div>
            </div>
            <!-- 여기에 페이지네이션 집 -->

        </div>

    </div>

</body>
</html>