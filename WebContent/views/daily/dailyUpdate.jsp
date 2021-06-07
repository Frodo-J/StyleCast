<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.stylecast.common.model.vo.* ,com.stylecast.daily.model.vo.*"%>
<%

	//Item il = (Item)request.getAttribute("il");
	Daily d = (Daily)request.getAttribute("d");
	ArrayList<Item> list = (ArrayList<Item>)request.getAttribute("list");
	
	
	String dPath = request.getContextPath() + "/" + d.getDailyImg();
	
	
	ArrayList<Item> topList = new ArrayList<>();
	ArrayList<Item> bottomList = new ArrayList<>();
	ArrayList<Item> shoesList = new ArrayList<>();
	ArrayList<Item> etcList = new ArrayList<>();
	
	for(Item i : list){
		if(i.getItemCategory().equals("상의")){
			topList.add(i);
		}else if(i.getItemCategory().equals("하의")){
			bottomList.add(i);
		}else if(i.getItemCategory().equals("신발")){
			shoesList.add(i);
		}else{
			etcList.add(i);
		}
	}
	
	
	/*
	String[] iName = new String[3];
	String[] iLink = new String[3];
	for(int i=0; i<list.size(); i++){
		if(list != null){
			iName[i] = list.get(i).getItemName();
			iLink[i] = list.get(i).getItemLink();
		}
	}
	*/

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        *{font-family: 'Noto Sans KR', sans-serif;}
        div{border: 0px solid black;}
        
        .wrap{width:1200px; height:1300px;  margin: auto;}

        .wrap>div{width:100%;}
        #header{height:12%; font-weight:500;}
        #content{height:88%; position: relative;}

        #header>div{float:left;}

        #header_1{width:22%; height:90%}
        #logoimg{height:100px; width:100%; margin-top: 25px;}

        #header_2{width:48%;height:90%}
        #header_2>div{height:auto; margin-left:55px; padding-top:55px; float:left;}
        #header_2>div>a{text-decoration:none; color:black;}

        #header_3{width:20%; height:90%;}
            .search-box{
            padding: 10px;
            margin-top:75px;
            margin-left:50%;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            height: 40px;
            background-color: #fff;
            border: 1px solid black;
            border-radius: 30px;
            transition: 0.4s;
            width:40px;
            }
            .search-box:hover{
            box-shadow: 0px 0px .5px 1px black;
            width: 200px;
            }
            .search-btn{
            text-decoration: none;
            float: right;
            width: 18px;
            height: 18px;
            background-color: #fff;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            color: black;
            }
            .search-box:hover > .search-btn{
            background-color: #fff;
            }
            .search-txt{
            display: flex;
            padding: 0;
            width: 0px;
            border:none;
            background: none;
            outline: none;
            float: left;
            font-size: 10px;
            line-height: 20px;
            transition: .4s;
            }
            .search-box:hover > .search-txt{
            width: 160px;
            padding: 0 6px;
            }

        #header_4{width:10%; height:90%; text-align: center;}
        #login{border-radius:5px; border:none; padding:7px 20px; margin-top: 55px;}

        #header_5{width:100%; height:1%; background-color: gray;}

        #dailyUp{
            position: absolute;
            width: 90%;
            height: 90%;
            margin: auto;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            background-color: rgb(224, 224, 224);
            }

        #dailyUp_header{height: 40%; width: 100%; box-sizing: border-box}
        #dailyUp_content{height: 60%; width: 100%; box-sizing: border-box}

        #img{
            margin-top: 30px;
            margin-bottom: 20px;
        }
        
        #item_content>input[type="text"]{margin: auto;}

        #daily-enroll-content{
            width: 90%;
            height: 130px;
            border: none;
        }
        
        #daily-enroll-tag{
            width: 90%;
            height: 30px;
            border: none;
        }
        
        
        
        #tag_body{
        	text-align: center;
        	margin: auto;
        	position: absolute;
            left: 0;
            right: 0;
        }

        #dailyName, #dailyLink1{
            font-size: 12px;
            margin-bottom: 16px;
            margin-left:-3px;
            border: none;
            display: inline-block;
        }

		#dailyName{
			width : 100px;
			margin-right: 1%;
			margin-left: 1%;
		}

		#dailyLink1{
			width : 200px;
			margin-right: 3%
		}
		
		#dailyLink2{
			width : 200px;
		}
		

        #daily{margin-left: 10px;}


        #daily_submit, daily_cancel{
            text-align: center;
            margin: auto;
            position: relative;
            left: 0;
            right: 0;
            bottom: 0;
            top : 0;
        }
        
        #daily_button{margin-top : 30px;}

    </style>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <!--돋보기 이미지-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!--돋보기 이미지end-->
    <!--font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
    <!--font end-->
    <!--jQuery-->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!--jQuery end-->
    <script>
        //----------이미지 첨부 기능 영역
        $(function(){
            $("#img").click(function(){
                $("#input-img").click();
            })
        })
    
        function loadImg(inputFile, num){
            if(inputFile.files.length == 1){ 
                var reader = new FileReader();
                reader.readAsDataURL(inputFile.files[0]);
                reader.onload = function(e){
                    switch(num){
                    case 1: $("#img").attr("src", e.target.result); break;
                    }
                }
                
            }else{ // 선택된 파일이 사라졌을 경우 => 미리보기 사라지게
                switch(num){
                case 1: $("#img").attr("src", null); break;
                }
            }
        }
        
        function goBack(){
        	window.history.back();
        }
        
    </script>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <div class="wrap">

        <div id="content">
            <div id="dailyUp">
                <form action="<%= contextPath %>/update.da" id="daily-enroll-form" method="post" enctype="multipart/form-data">
                <input type="hidden" name="dno" value="<%=d.getDailyNo() %>">
	                <div id="dailyUp_header">
	                    <div id="input_file" class="input-group" style="display: none">
	                        <input type="file" class="form-control" id="input-img" name="image" aria-describedby="inputGroupFileAddon04" aria-label="Upload" onchange="loadImg(this,1);" required>
	                    </div>
	                    <div id="image">
	                    	<input type="hidden" name="originDilePath" value="<%=dPath%>"/>
	                        <img src="<%=dPath%>" id="img" name="img" width = "300" height = "300" onerror="javascript:this.src='<%=contextPath %>/resources/images/add2.png'">
	                    </div>
	                </div>
                
               		<div id="dailyUp_content">
                        <div id="item_content">
                        	<input type="hidden" name="memNo" value="<%= loginUser.getMemNo() %>">
                            <input type="text" class="form-control" name="dailyContent" id="daily-enroll-content" value="<%=d.getDailyContent()%>"placeholder="내용을 입력해주세요">
                            <br><br>
                            <input type="text" name="tag" class="form-control" id="daily-enroll-tag" value="<%=d.getTag()%>" placeholder="태그를 입력해주세요(최대 10개까지 가능)">
                            <br><br>
                        </div>
                        <div id="tag">
                            <h2 style="text-align: left; margin-left: 53px;">Item Tag</h2>
                            <p style="font-size: 10px; color: gray; text-align: left; margin-left: 53px;" >아이템을 구매한 곳의 링크를 입력해주세요! (선택사항)</p>
                            <br>
                            <div id="tag_body">
                            
                            	
                            	<%for(int i=0; i<=2; i++){ %>
                            		<% if(i <= topList.size() - 1){ %>
                            			
                            			<input type="hidden" name="topNo<%= i+1 %>" value="<%=topList.get(i).getItemNo() %>">
                            			<input type="text" name="top<%= i+1 %>" value="<%= topList.get(i).getItemName() %>" id="dailyName" class="form-control" placeholder="상의<%= i+1 %>">
		                            	<input type="text" name="topLink<%= i+1 %>" value="<%= topList.get(i).getItemLink() %>" id="dailyLink1" class="form-control" placeholder="링크">	
                            		
                            		<% }else{ %>
                            			<input type="text" name="top<%= i+1 %>" value="" id="dailyName" class="form-control" placeholder="상의<%= i+1 %>">
		                           	    <input type="text" name="topLink<%= i+1 %>" value="" id="dailyLink1" class="form-control" placeholder="링크">
                            		
                            		<% } %>
                            	<% } %>
                            	
                            	<%for(int i=0; i<=2; i++){ %>
                            		<% if(i <= bottomList.size() - 1){ %>
                            			
                            			<input type="hidden" name="bottomNo<%= i+1 %>" value="<%=bottomList.get(i).getItemNo() %>">
                            			<input type="text" name="bottom<%= i+1 %>" value="<%= bottomList.get(i).getItemName() %>" id="dailyName" class="form-control" placeholder="하의<%= i+1 %>">
		                            	<input type="text" name="bottomLink<%= i+1 %>" value="<%= bottomList.get(i).getItemLink() %>" id="dailyLink1" class="form-control" placeholder="링크">	
                            		
                            		<% }else{ %>
                            			<input type="text" name="bottom<%= i+1 %>" value="" id="dailyName" class="form-control" placeholder="하의<%= i+1 %>">
		                           	    <input type="text" name="bottomLink<%= i+1 %>" value="" id="dailyLink1" class="form-control" placeholder="링크">
                            		
                            		<% } %>
                            	<% } %>
                            		
                            	<%for(int i=0; i<=2; i++){ %>
                            		<% if(i <= shoesList.size() - 1){ %>
                            			
                            			<input type="hidden" name="shoesNo<%= i+1 %>" value="<%=shoesList.get(i).getItemNo() %>">
                            			<input type="text" name="shoes<%= i+1 %>" value="<%= shoesList.get(i).getItemName() %>" id="dailyName" class="form-control" placeholder="신발<%= i+1 %>">
		                            	<input type="text" name="shoesLink<%= i+1 %>" value="<%= shoesList.get(i).getItemLink() %>" id="dailyLink1" class="form-control" placeholder="링크">	
                            		
                            		<% }else{ %>
                            			<input type="text" name="shoes<%= i+1 %>" value="" id="dailyName" class="form-control" placeholder="신발<%= i+1 %>">
		                           	    <input type="text" name="shoesLink<%= i+1 %>" value="" id="dailyLink1" class="form-control" placeholder="링크">
                            		
                            		<% } %>
                            	<% } %>  
                            	
                            	<%for(int i=0; i<=2; i++){ %>
                            		<% if(i <= etcList.size() - 1){ %>
                            			
                            			<input type="hidden" name="etcNo<%= i+1 %>" value="<%=etcList.get(i).getItemNo() %>">
                            			<input type="text" name="etc<%= i+1 %>" value="<%= etcList.get(i).getItemName() %>" id="dailyName" class="form-control" placeholder="기타<%= i+1 %>">
		                            	<input type="text" name="etcLink<%= i+1 %>" value="<%= etcList.get(i).getItemLink() %>" id="dailyLink1" class="form-control" placeholder="링크">	
                            		
                            		<% }else{ %>
                            			<input type="text" name="etc<%= i+1 %>" value="" id="dailyName" class="form-control" placeholder="기타<%= i+1 %>">
		                           	    <input type="text" name="etcLink<%= i+1 %>" value="" id="dailyLink1" class="form-control" placeholder="링크">
                            		
                            		<% } %>                        	
	                            <% } %>
                            		
	                            
	                			<div id=daily_button>
	                				<button type="button" style="width:100px;" id="daily_cancel" class="btn btn-dark" onclick="location.href='<%=contextPath%>/detail.da?dno=<%=d.getDailyNo()%>';">취소</button>&nbsp;&nbsp;&nbsp;
	                				<button type="submit" style="width:100px;" id="daily_submit" class="btn btn-dark">수정</button>
	                			</div>
                           </div>
	                	</div>
	                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>