<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    /*
        div:not(#head_box,#head_of_notice,#notice_lists,#search_box,#img_btn,#input_search,#admin_box,#admin_box_inner,#page_box){border: 1px solid gray; box-sizing: border-box;}
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        
        */
        /*
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

        * {
                font-family: 'Noto Sans KR', sans-serif;
                font-weight: 300;
        }

        table tbody tr td:nth-child(2){
            text-align: left;
        }

        table tbody tr:hover{
            cursor: pointer;
        }

        #head_of_notice{
            font-weight: bold;
            margin-top: 30px;
            margin-left: 80px;
            margin-bottom: 10px;
        }
        #notice_lists{
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
        #admin_box{
            width: 80%;
            height: 70px;
            margin: auto;
        }
        #admin_box_inner{
            float: right;
        }
        #page_box{
            width: 80%;
            margin: auto;
            height: 100px;
        }
    </style>
</head>
<body>
    
    <div class="wrap">
    	<%@ include file="../common/menubar1.jsp" %>
        <!--  <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div> -->
        
        <div id="content">
            <div id="head_box">
                <h2 id="head_of_notice">Notice</h2>
            </div>
            
            <div id="notice_lists">
                <div id="search_box">
                    <select class="form-select">
                        <option selected value="1">제목</option>
                        <option value="2">내용</option>
                        <option value="3">작성자</option>
                    </select>
                    <input id="input_search" class="form-control" type="text" placeholder="검색내용">
                    <button id="img_btn" type="button"><img src="<%=contextPath %>/resources/images/loupe.png"></button> 
                </div>
                <table class="table table-hover text-center">
                    <thead class="table-light">
                        <th width="10%">번호</th>
                        <th width="60%">제목</th>
                        <th>작성자</th>
                        <th>등록일</th>
                      </thead>
                      <tbody>
                        <tr>
                            <td>15</td>
                            <td>카카오 오븐에 제목만은 왼쪽 정렬로 되어 있어서 일단 왼쪽정렬로 해봤는데</td>
                            <td>admin</td>
                            <td>2021-05-15</td>
                        </tr>
                        <tr>
                            <td>14</td>
                            <td>이상하면 바꾸겠습니다...!</td>
                            <td>admin</td>
                            <td>2021-05-14</td>
                        </tr>
                        <tr>
                            <td>13</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-13</td>
                        </tr>
                        <tr>
                            <td>12</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-12</td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-11</td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-10</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-09</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-08</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-07</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-06</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-05</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-04</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-03</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>공지사항</td>
                            <td>admin</td>
                            <td>2021-05-02</td>
                        </tr>
                        <tr>
                          <td>1</td>
                          <td>공지사항</td>
                          <td>admin</td>
                          <td>2021-05-01</td>
                        </tr>
                        <!--글이 없을 경우-->
                        <!-- <tr>
                            <td colspan="4">글이 없습니다.</td>
                        </tr> -->
                        <!--검색결과가 없을 경우-->
                        <!-- <tr>
                            <td colspan="4">'OO'가 포함된 검색어를 찾을 수 없습니다.</td>
                        </tr> -->
                      </tbody>
                  </table>
            </div>
            <div id="admin_box">
                <div id="admin_box_inner">
                    <!-- 사용자일경우 안보이게-->
                    <button type="button" class="btn btn-secondary btn-sm">글작성</button>
                </div>
            </div>
            <div id="page_box">
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                      <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&laquo;</a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                      <li class="page-item"><a class="page-link" href="#">2</a></li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#">&raquo;</a>
                      </li>
                    </ul>
                  </nav>
            </div>

        </div>

    </div>

</body>
</html>