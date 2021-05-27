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
       
        .wrap{width:1200px; height:1300px;  margin: auto;}

        #header, #content{width:100%;}
        #header{height:12%;}
        #content{height:88%; width: 90%; margin: auto;}

        #side, #mypage{float: left; height: 100%;}
        #side{width: 20%;}
        #mypage{
            width: 80%;
            height: 100%;
            padding-top: 40px;
            position: relative;
        }

        #line{width: 1.5px; height:90%; float:right; background: lightgrey;}
        #prof, #menu{width: 99%; float: left;}
        #prof{height: 17%;}
        #menu{height: 83%; padding-left: 10px;}

        /* 사이드바 상세 css */
        #prof div, #menu div{width: 100%;}
        #menu a{color: black; text-decoration: none;}

        #prof_img{height: 70%; padding: 20px;}

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

        #prof-img{width: 35%;}
        #prof-delete{height: 30px;}
        #prof-input{width: 65%;}

        .prof-body button{
            width: 50px;
            margin: 15px;
        }

        /* 데일리 리스트 css */
        #mypage div{float: left;}
        #daily_box{height: 75%; overflow-y: scroll; position: absolute;}

        /* daily style */
        .daily_post{width:260px; height:425px; float: left; color: rgb(40, 40, 40); border: 0.5px solid lightgrey; border-radius: 2pc; background: whitesmoke; margin-top: 30px; margin-left: 17px;}
        .daily_img{position: relative; width:230px; height:280px; margin: 24px 15px 10px;}
        .daily_img>img{width:230px; height:280px; object-fit: cover;}

        .profile{width:50px; height: 50px; float: left; margin: 0px 15px;}
        .profile>img{width: 100%; height: 100%;}
        .userid{width:80px; float:left; font-size: 16px; font-weight: 700; margin: 0px;}
        .date{float:left; font-size: 13px; font-weight: 700; margin: 2px 10px 1px 22px;}
        .text{float:left; width: 120px; margin: 4px 0px;}

        .react{float:left; width:200px; height: 26px; margin: 10px 26px 15px 34px;}
        .react>div{float: left; width:30px; height: 26px;}
        .react_like{background: url("resources/react_icon/sun.svg") no-repeat; background-size: contain;}
        .react_comment{background: url("resources/react_icon/comment.svg") no-repeat; background-size: contain;}
        .react_bookmark{background: url("resources/react_icon/bookmark.svg") no-repeat; background-size: contain;}
        .react_count{ margin-right: 6px; text-align: center; font-size: 15px; font-weight: 550;}
        /* daily style end*/
    </style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
    
    <div class="wrap">

        <div id="header"></div>

        <div id="content">
            <div id="side">

                <div id="line"></div>
                
                <div id="prof">
                    <div id="prof_img" align="center"><img src="resources/prof.png"></div>
                    <div id="prof_nick" align="center">닉네임</div>
                </div>

                <div id="menu">
                    <div id="write" style="font-weight: bold;">
                        내가 쓴 글
                        <div><a href="<%= request.getContextPath() %>/myPage.me">데일리</a></div>
                        <div><a href="<%= request.getContextPath() %>/reply.me" style="font-weight: normal;">댓글</a></div>
                        <div><a href="<%= request.getContextPath() %>/question.me?currentPage=1" style="font-weight: normal;">문의글</a></div>
                    </div>
                    <div><a href="<%= request.getContextPath() %>/bookmark.me">북마크</a></div>
                    <div><a href="<%= request.getContextPath() %>/myMember.me">개인정보 수정</a></div>
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
                        <form action="" method="post" style="line-height: 30px;">
                            <div id="prof-img">
                                <img src="resources/prof.png">
                                <button id="prof-delete" class="btn btn-light btn-sm">삭제</button>
                            </div>
                            <div id="prof-input"><input type="file" name="userProfImg"></div>  
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin: auto;">취소</button>
                            &emsp;&emsp;
                            <button type="button" class="btn btn-primary" onclick="" style="width: 90px;">등록</button>
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

            <!-- 데일리 리스트 -->
            <div id="mypage">
                <b style="margin-left: 50px;">내가 쓴 글 > 데일리</b>
                <br>

            <div id="daily_box">
                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi4.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi15.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi16.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi7.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi8.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi9.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi8.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>

                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi9.jpg" alt="">
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <div class="react">
                        <div class="react_like"></div>
                        <div class="react_count">10</div>
                        <div class="react_comment"></div>
                        <div class="react_count">10</div>
                        <div class="react_bookmark"></div>
                        <div class="react_count">10</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>