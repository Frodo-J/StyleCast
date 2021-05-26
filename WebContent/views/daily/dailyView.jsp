<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        div{box-sizing: border-box; border: 0px solid gray;}
        .wrap{width:1200px; height:1300px; margin: auto;}

        .wrap>div{width:100%;}
        #content{height:88%;}

        #daily{width:95%; height: 95%; margin: auto; margin-top: 30px;}
        /* daily style */
        .daily_post{width:260px; height:425px; float: left; color: rgb(40, 40, 40); border: 0.5px solid lightgrey; border-radius: 2pc; background: whitesmoke; margin-top: 30px; margin-left: 17px;}
        .daily_img{position: relative; width:230px; height:280px; margin: 24px 15px 10px;}
        .daily_img>img{width:230px; height:280px; object-fit: cover;}

        .action_hover{position: absolute; width: 230px; height:50px; bottom: 0px; visibility: hidden; 
                      background: linear-gradient(to bottom, rgba(0, 0, 0, 0.0) 0%, rgba(0, 0, 0, 0.2) 30%, rgba(0, 0, 0, 0.5) 70%, rgb(0, 0, 0, 0.7) 100%);}
        .action{float: left; width: 25%; height: 50px;}
        .action>input{width:100%; height: 100%; border:0px; background-size: 25px 25px;}
        .vertical-line{float: left; border-color: rgba(255,255,255,0.5); border-style: solid; border-width: 0 0 0 1px; 
                       margin-top: 14px; margin-right: -1px; margin-bottom: 19px; width: 0px; height: 20px; vertical-align: middle;}
        .like{background: url("resources/react_icon/sun2.svg") no-repeat center/contain;}
        .comment{background: url("resources/react_icon/comment2.svg") no-repeat center/contain;}
        .bookmark{background: url("resources/react_icon/bookmark2.svg") no-repeat center/contain;}
        .report{background: url("resources/react_icon/flag2.svg") no-repeat center/contain;}
        .action_hover input:hover{cursor: pointer;}

        .profile{width:50px; height: 50px; float: left; margin: 0px 15px;}
        .profile>img{width: 100%; height: 100%;}
        .userid{width:80px; float:left; font-size: 16px; font-weight: 700; margin: 0px;}
        .date{float:left; font-size: 13px; font-weight: 700; margin: 2px 10px 1px 22px;}
        .text{float:left; width: 120px; margin: 4px 0px;}
        .more{float:left; background:url("resources/react_icon/plus.svg") no-repeat; width: 24px; height: 24px; margin: 8px 10px 0px 20px; border: 0px;}

        .react{float:left; width:200px; height: 26px; margin: 10px 26px 15px 34px;}
        .react>div{float: left; width:30px; height: 26px;}
        .react_like{background: url("resources/react_icon/sun.svg") no-repeat; background-size: contain;}
        .react_comment{background: url("resources/react_icon/comment.svg") no-repeat; background-size: contain;}
        .react_bookmark{background: url("resources/react_icon/bookmark.svg") no-repeat; background-size: contain;}
        .react_count{ margin-right: 6px; text-align: center; font-size: 15px; font-weight: 550;}
        /* daily style end */

    </style>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    
    <%@ include file="../common/menubar1.jsp" %>
    
    <!-- daily 게시판 조회 div생성하며 -> 글번호, 회원번호, 내용, 등록일, 등록경로, 태그 -->
    <!-- 좋아요수(count daily_like daily_no), 댓글수(count daily_cm daily_no), 북마크수(count daily_bookmark daily_no) -->

    <div class="wrap">

        <div id="content">
            <div id="daily">
                <div class="daily_post">
                    <div class="daily_img">
                        <img src="resources/img_codi4.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <img src="resources/img_codi19.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <img src="resources/img_codi30.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <img src="resources/img_codi24.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <img src="resources/img_codi28.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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
                        <img src="resources/img_codi29.jpg" alt="">
                        <div class="action_hover">
                            <div class="action"><input type="button" class="like"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="comment"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="bookmark"></div>
                            <div class="vertical-line"></div>
                            <div class="action"><input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal"></div>
                        </div>
                    </div>
                    <div class="profile">
                        <img src="resources/profile.png" alt="">
                    </div>
                    <div class="userid">userid</div>
                    <div class="date">21. 05. 03</div>
                    <div class="text">text</div>
                    <input type="button" class="more" onclick="">
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

    <!-- Modal -->
    <div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
            <h5 class="modal-title" id="reportModalLabel">ì ê³ </h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="" method="post" style="line-height: 30px;">
                    <input type="radio" name="report_category" id="" value="ìì¤ ë° ë¹ë°©" checked>&nbsp;ìì¤ ë° ë¹ë°©<br>
                    <input type="radio" name="report_category" id="" value="ì§ëì¹ íë³´ì± ë´ì©">&nbsp;ì§ëì¹ íë³´ì± ë´ì©<br>
                    <input type="radio" name="report_category" id="" value="íì¤ì¤ë¬ì">&nbsp;íì¤ì¤ë¬ì<br>
                    <input type="radio" name="report_category" id="" value="ì¸ì¤ì ì">&nbsp;ì¸ì¤ì ì<br>
                    <input type="radio" name="report_category" id="" value="ê¸°í">&nbsp;ê¸°í<br>
                    <textarea name="report_text" id="report_text" rows="3" class="form-control" placeholder="ê¸°í ì ê³  ì¬ì ë¥¼ ìë ¥í´ì£¼ì¸ì" style="resize: none;" disabled=true;></textarea>
                    <br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin: auto;">ì·¨ì</button>
                    &emsp;&emsp;
                    <button type="button" class="btn btn-primary" onclick="" style="width: 90px;">ë³´ë´ê¸°</button>
                </form>
            </div>
        </div>
        </div>
    </div>

    <script>
        // daily img hover
        $(document).ready(function(){
    	$(".daily_img").hover(function(){
    		$(this).children(".action_hover").css("visibility", "visible");
    	}, function(){
    		$(this).children(".action_hover").css("visibility", "hidden");
    	})
        });
        
        // daily click action
        $(".daily_post").click(function(){
            if(event.target.className=='like' || 
               event.target.className=='comment' || 
               event.target.className=='bookmark' || 
               event.target.className=='report') return;
            $(location).attr("href", "https://www.naver.com/")
        });
        
        // report disabled
        $(document).ready(function(){
        $("input:radio[name=report_category]").click(function(){
            if($("input[name=report_category]:checked").val() == "ê¸°í"){
                $("#report_text").attr("disabled",false);
            }else if($("input[name=report_category]:checked").val() == "ìì¤ ë° ë¹ë°©" || 
                     $("input[name=report_category]:checked").val() == "ì§ëì¹ íë³´ì± ë´ì©" ||
                     $("input[name=report_category]:checked").val() == "íì¤ì¤ë¬ì" ||
                     $("input[name=report_category]:checked").val() == "ì¸ì¤ì ì"){
                $("#report_text").attr("disabled",true);
            }
        })
        });
    </script>


</body>
</html>