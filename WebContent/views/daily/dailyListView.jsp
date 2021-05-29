<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.stylecast.common.model.vo.PageInfo, java.util.ArrayList, com.stylecast.daily.model.vo.*, java.text.SimpleDateFormat" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Daily> list = (ArrayList<Daily>)request.getAttribute("list");
	ArrayList<Report> rlist = new ArrayList<>();
	
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
    <style>
        div{box-sizing: border-box; border: 0px solid gray;}
        .wrap{width:1200px; height:1300px; margin: auto;}

        .wrap>div{width:100%;}
        #content{height:88%;}

        #daily_wrapper{width:95%; height: 95%; margin: auto; margin-top: 30px;}
        /* daily style */
        .daily_post{width:260px; height:425px; float: left; color: rgb(40, 40, 40); border: 0.5px solid lightgrey; border-radius: 2pc; background: whitesmoke; margin-top: 25px; margin-left: 17px;}
        .daily_img{position: relative; width:230px; height:280px; margin: 24px 15px 10px;}
        .daily_img>img{width:230px; height:280px; object-fit: cover;}

        .action_hover{position: absolute; width: 230px; height:50px; bottom: 0px; visibility: hidden; 
                      background: linear-gradient(to bottom, rgba(0, 0, 0, 0.0) 0%, rgba(0, 0, 0, 0.2) 30%, rgba(0, 0, 0, 0.5) 70%, rgb(0, 0, 0, 0.7) 100%);}
        .action{float: left; width: 25%; height: 50px;}
        .action>input{width:100%; height: 100%; border:0px; background-size: 25px 25px;}
        .vertical-line{float: left; border-color: rgba(255,255,255,0.5); border-style: solid; border-width: 0 0 0 1px; 
                       margin-top: 14px; margin-right: -1px; margin-bottom: 19px; width: 0px; height: 20px; vertical-align: middle;}
        .like{background: url("resources/images/react_icon/sun2.svg") no-repeat center/contain;}
        .comment{background: url("resources/images/react_icon/comment2.svg") no-repeat center/contain;}
        .bookmark{background: url("resources/images/react_icon/bookmark2.svg") no-repeat center/contain;}
        .report{background: url("resources/images/react_icon/flag2.svg") no-repeat center/contain;}
        .action_hover input:hover{cursor: pointer;}

        .profile{width:50px; height: 50px; float: left; margin: 2px 11px 2px 17px;}
        .profile>img{width: 100%; height: 100%;}
        .userid{width:86px; float:left; font-size: 14px; font-weight: 700; margin: 0px;}
        .date{float:left; font-size: 12px; font-weight: 700; margin: 1px 0px 1px 28px;}
        .text{float:left; font-size: 12px; width: 120px; height:34px; margin: 4px 0px; overflow:hidden;}
        .more{float:left; background:url("resources/images/react_icon/plus.svg") no-repeat; width: 24px; height: 24px; margin: 8px 10px 0px 20px; border: 0px;}

        .react{float:left; width:200px; height: 26px; margin: 10px 26px 15px 34px;}
        .react>div{float: left; width:30px; height: 26px;}
        .react_like{background: url("resources/images/react_icon/sun.svg") no-repeat; background-size: contain;}
        .react_comment{background: url("resources/images/react_icon/comment.svg") no-repeat; background-size: contain;}
        .react_bookmark{background: url("resources/images/react_icon/bookmark.svg") no-repeat; background-size: contain;}
        .react_count{margin-right: 6px; text-align: center; font-size: 15px; font-weight: 550;}
        /* daily style end */
        .add{position: absolute; top:1100px; right: 150px;}
		#navigation{position: absolute; margin-top: 970px; margin-left: 500px;}
    </style>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    
    <%@ include file="../common/menubar.jsp" %>
    
    <div class="wrap">

        <div id="content">
            <div id="daily_wrapper">

				<% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); %> 

				<% for(Daily d : list) { %> 
	                <div class="daily_post fadein">
	                    <div class="daily_img">
	                        <img src="<%= contextPath %>/<%= d.getDailyImg() %>" alt="">
	                        <div class="action_hover">
	                            <div class="action"><input type="button" class="like"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="comment"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action"><input type="button" class="bookmark"></div>
	                            <div class="vertical-line"></div>
	                            <div class="action">
	                            	<input type="button" class="report" data-bs-toggle="modal" data-bs-target="#reportModal">
	                            </div>
	                        </div>
	                    </div>
						<input type="hidden" name="memNo" value="<%= loginUser %>">
						<input type="hidden" name="rMemNo" value="<%= d.getMemNo() %>">
						<input type="hidden" name="dailyNo" value="<%= d.getDailyNo() %>">
	                    <div class="profile">
	                        <img src="<%= contextPath %>/<%= d.getProfImg() %>" alt="">
	                    </div>
	                    <div class="userid"><%= d.getMemName() %></div>
	                    <div class="date"><%= simpleDateFormat.format(d.getEnrDate()) %></div>
	                    <div class="text"><%= d.getDailyContent() %></div>
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
                <% } %>
				
				<img src="https://img.icons8.com/ios-filled/50/000000/plus.png" class="add" onclick="location.href='03-2_데일리_작성form.html'">
				
				<div id="navigation">
				  <ul class="pagination">
				    <li class="page-item">
						<% if(currentPage != 1) { %>
			            	<a class="page-link" href="<%=contextPath%>/list.da?currentPage=<%=currentPage-1%>" aria-label="Previous">
						        <span aria-hidden="true">&lt;</span>
	      					</a>
						<% } %>
					</li>
		            <% for(int p=startPage; p<=endPage; p++) { %>
						<li class="page-item">
							<% if(p != currentPage) { %>
				            	<a class="page-link" href="<%=contextPath%>/list.da?currentPage=<%= p %>"><%= p %></a>
				            <% }else { %>
				            	<a class="page-link" href = "#"><%= p %></a>
			            	<% } %>
		            	</li>
		            <% } %>
					<li class="page-item">
						<% if (currentPage != maxPage) { %>
			            	<a class="page-link" href="<%=contextPath%>/list.da?currentPage=<%=currentPage+1%>" aria-label="Next">
	        					<span aria-hidden="true">&gt;</span>
	        				</a>
						<% } %>
					</li>
				  </ul>
				</nav>

                 
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
            <h5 class="modal-title" id="reportModalLabel">신고</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="" method="post" style="line-height: 30px;">
                	<!-- 회원번호, 피신고회원번호, 내용(널러블), 게시판카테고리(0), 데일리번호, 신고카테고리 -->

                    <input type="radio" name="report_category" value="욕설 및 비방" checked>&nbsp;욕설 및 비방<br>
                    <input type="radio" name="report_category" value="지나친 홍보성 내용">&nbsp;지나친 홍보성 내용<br>
                    <input type="radio" name="report_category" value="혐오스러움">&nbsp;혐오스러움<br>
                    <input type="radio" name="report_category" value="외설적임">&nbsp;외설적임<br>
                    <input type="radio" name="report_category" value="기타">&nbsp;기타<br>
                    <textarea name="report_text" id="report_text" rows="3" class="form-control" placeholder="기타 신고 사유를 입력해주세요" style="resize: none;" disabled=true;></textarea>
                    <br>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="width: 90px; margin-left: 120px;">취소</button>
                    
                    <button type="button" class="btn btn-primary" onclick="location.href='<%=contextPath%>/report.da'" style="width: 90px; margin-left: 50px;">보내기</button>
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
            if($("input[name=report_category]:checked").val() == "기타"){
                $("#report_text").attr("disabled",false);
            }else if($("input[name=report_category]:checked").val() == "욕설 및 비방" || 
                     $("input[name=report_category]:checked").val() == "지나친 홍보성 내용" ||
                     $("input[name=report_category]:checked").val() == "혐오스러움" ||
                     $("input[name=report_category]:checked").val() == "외설적임"){
                $("#report_text").attr("disabled",true);
            }
        })
        });

        // data to modal 

		//버튼 클릭했을때 부모창의 값을 모달창으로
        /*
		var memNo = "";
        var rMemNo = "";
        var dailyNo = "";
        var rptCategory = "";
        var content = "";
        
        $(document).ready(function() {
			$('#reportModal').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); // Button that triggered the modal
				rMemNo = button.data('rMemNo'); // Extract info from data-* attributes
				dailyNo = $(this).data('dailyNo');
				var modal = $(this);
				
				
				console.log(rMemNo);
				console.log(dailyNo);
		
			})
		});
		*/

    </script>


</body>
</html>