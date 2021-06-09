<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.stylecast.qna.model.vo.*, java.util.ArrayList, com.stylecast.common.model.vo.BoardImage" %>
<%
	Qna q = (Qna)request.getAttribute("q");
	ArrayList<BoardImage> imgList = (ArrayList<BoardImage>)request.getAttribute("imgList");
	String content = q.getQnaContent();
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
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font end-->
    <style>
    	/*
        div:not(.wrap,.card,.card_body,.card_header,.input-group,.mb-3, #head_box, #detail_box,#qna_contents,#button_box,#qna_main,#out_of_contents_box,#comment_box,#content){border: 1px solid gray; box-sizing: border-box;}
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        #header{height:12%;}
        #content{
            height:88%;
        }

        #header>div{height:100%; float:left;}
        #header_1{width:22%;}
        #header_2{width:48%;}
        #header_3{width:20%;}
        #header_4{width:10%;}

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

        #head_of_qna{
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
        #qna_contents{
            height: 550px;
            overflow: auto;
            /* div영역내에 이미지가 넘쳤을 경우 스크롤 생김 */
        }
        #button_box{
            margin: auto;
            width: 80%;
        }
        #qna_main{
            float: right;
        }
        #out_of_contents_box{
            display: block;
        }
        #comment_box{
            width: 80%;
            margin:auto;
        }
        #answer_complete{
            float: right;
            margin-right: 5px;
        }
        #delete_btn{
            color: gray;
            size: 10px;
        }
        #font_qna{
        	color: rgb(241, 196, 15);
        
        } 
    </style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="wrap">
    <!--  
        <div id="header">
            <div id="header_1">로고</div>
            <div id="header_2">메뉴바</div>
            <div id="header_3">검색</div>
            <div id="header_4">로그인</div>
        </div>-->
        <div id="content">
            <div id="head_box">
                <h3 id="head_of_qna">Qna</h3>
            </div>
            <div id="detail_box">
                <table class="table">
                    <tr>
                        <th width=10%>구분</th>
                        <td width=60%>[<%=q.getQnaCategory() %>]</td>
                        <th width=10%>등록일</th>
                        <td width=10%><%=q.getEnrDate() %></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td colspan="3"><%=q.getQnaTitle() %></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td colspan="3"><%=q.getMemName() %></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="3">
                            <div id="qna_contents">
                            	<%=content %>
                            	<br>
                               	<br>
                                <!--첨부파일 이미지 있으면 여기아래 처리-->
                                <% for(int i=0; i<imgList.size(); i++){ %>
                                	<img src="<%=contextPath %>/<%= imgList.get(i).getImgPath()%>" width="600" height="auto"/>
								<%} %>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="out_of_contents_box">
            <div id="button_box">
            	<% if((loginUser != null && loginUser.getMemName().equals(q.getMemName()))){ %>
                	<button type="button" class="btn btn-secondary btn-sm" onclick="location.href='<%=contextPath%>/updateForm.qna?qno=<%=q.getQnaNo()%>';">수정</button>
                	<button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#exampleModalToggle_rept">삭제</button>
   
                <% }else if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
                	<button type="button" class="btn btn-secondary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#exampleModalToggle_rept">삭제</button>
                <% } %>
                <button id="qna_main" type="button" class="btn btn-secondary btn-sm" onclick="location.href='<%=contextPath%>/list.qna?currentPage=1'">목록으로 가기</button>
                <!--답변완료 상태이면 보이지 않도록-->
                <!--  <button id="answer_complete" type="button" class="btn btn-primary btn-sm">답변완료</button>-->
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
                                            <b>Qna글 삭제</b>
                                        </h5>
                                        <button
                                            type="button"
                                            class="btn-close"
                                            data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        	정말 Q&A글을 삭제하시겠습니까?
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
                                            onclick="location.href='<%=contextPath%>/delete.qna?qno=<%=q.getQnaNo()%>';">확인</button>
                                    </div>
                                </div>
                            </div>
                        </div>
            <br>
            <div id="comment_box">
                <div class="card">
                    <div class="card-header">
                        <img src="<%=contextPath %>/resources/images/comment.png"/>
                        <b>
                            Answer
                        </b>
                      </div>
                      <div class="card-body">
                        <div class="input-group mb-3">
                        <%if(loginUser.getAdminYN().equals("Y")){ %>
                            <input type="text" id="answerContent" class="form-control" placeholder="답변 내용을 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                            <button class="btn btn-secondary" type="button" id="button-addon2" onclick="updateAnswer();">작성</button>
                        <% }else{%>
                        	 <input type="text" class="form-control" placeholder="관리자만 입력 가능합니다." aria-label="Recipient's username" aria-describedby="button-addon2" disabled>
                            <button class="btn btn-secondary" type="button" id="button-addon2" disabled>작성</button>
                        <% } %>
                        </div>
                        <table class="table" id="reply-area">
                            <tbody>
                                <!-- <tr>
                                    <td width="10%"><b>admin</b></td>
                                    <td width="65%">안녕하세요 문의 답변입니다. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.</td>
                                    <td width="15%" align="right"><img src="<%=contextPath %>/resources/images/clock.png">2021.05.11</td>
                                    <td width="10%"><a href="#" class="link-secondary">삭제</a></td>
                                </tr> -->
                            </tbody>
                        </table>
                    	</div>
                	</div>  
            	</div>
            	<script>
            	$(function(){
            		selectReplyList();
            		
            		setInterval(selectReplyList, 1000);
            	})
            	
            	function deleteAnswer(){
            		$.ajax({
            			url:"adelete.qna",
            			data:{
            				qno:<%=q.getQnaNo()%>
            			},
            			type:"post",
            			success:function(result){
            				console.log("deleteAnswer실행");
            				if(result > 0){ // 댓글작성 성공 => 갱신된 댓글 리스트 조회
            					alert("성공적으로 삭제 되었습니다!");
            					selectReplyList();
            					$("#answerContent").val("");
            					$("#answerContent").attr("placeholder","답변 내용을 입력하세요");
            				}
            				
            			},error:function(){
            				console.log("댓글 작성용 ajax 통신실패");
            			}
            		});
            	}
            	
            	function updateAnswer(){
            		$.ajax({
            			url:"ainsert.qna",
            			data:{
            				content:$("#answerContent").val(),
            				qno:<%=q.getQnaNo()%>
            			},
            			type:"post",
            			success:function(result){
            				console.log("updateAnswer실행");
            				if(result > 0){ // 댓글작성 성공 => 갱신된 댓글 리스트 조회
            					selectReplyList();
            					$("#answerContent").val("");
            					$("#answerContent").attr("placeholder","여기에 다시 답변을 달면 답변이 수정됩니다.");
            				}
            				
            			},error:function(){
            				console.log("댓글 작성용 ajax 통신실패");
            			}
            		});
            	}
            	
            	function selectReplyList(){
            		$.ajax({
            			url:"alist.qna",
            			data:{qno:<%=q.getQnaNo()%>}, 
            			success:function(qAnswer){
            				console.log(qAnswer); // [{}, {}, ..]  |  []
            				var result = "";
            				if(qAnswer.ansContent == null){
            					result = "<tr> <td colspan="+ "4" +"> 등록된 답변이 없습니다.</td> </tr>";
            				}else{
            					$("#answerContent").attr("placeholder","여기에 다시 답변을 달면 답변이 수정됩니다.");
            					result = "<tr>"
			                        +    "<td width=" + "10%" + "><b>" + qAnswer.memAdminName + "</b></td>"
			                        +    "<td width=" + "65%" + ">" + qAnswer.ansContent + "</td>"
			                        +    "<td width=" + "15%" + " align = right>" + "<img src='<%=contextPath %>/resources/images/clock.png'>"+ qAnswer.ansDate2 + "</td>"
			                        +    "<td width="+ "5%" + "><a href="+ "#" +" class=" + "link-secondary onclick="+ "deleteAnswer();" + ">삭제</a></td>"
			                        + "</tr>";
            				}
            				//$("#reply-area tbody tr td:eq(0)").html(qAnswer.memAdminName);
            				//$("#reply-area tbody tr td:eq(1)").html(qAnswer.ansContent);
            				//$("#reply-area tbody tr td:eq(2)").html(qAnswer.ansDate);
            				$("#reply-area tbody").html(result);
            			},error:function(){
            				console.log("댓글리스트 조회용 ajax통신 실패");
            			}
            		})
            	}
            	
            	</script>
        	</div>
    	</div>
    </div>

</body>
</html>