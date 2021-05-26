<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	//Member loginUser = (Member)session.getAttribute("loginUser");
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html >
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <!--ëë³´ê¸° ì´ë¯¸ì§-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link rel="stylesheet" href="style.css">
    <!--ëë³´ê¸° ì´ë¯¸ì§end-->
    <!--font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;500&family=Noto+Serif+KR:wght@300;500&display=swap" rel="stylesheet">
    <!--font end-->
    <title>Document</title>
    
    <style>
        
       
        .wrap{
            width:1200px; 
            height:1300px;  
            margin: auto; 
            font-family:'Noto Sans KR', sans-serif;
            }
	
        .wrap>div{width:100%;}
        #header{height:12%;}

        #header>div{float:left;}

        #header_1{width:22%; height:90%}
        #logoimg{
            height:100px; 
            width:100%; 
            margin-top: 25px;
            }

        #header_2{width:48%;height:90%}
        #header_2>div{
            height:auto; 
            margin-left:55px; 
            padding-top:55px; 
            float:left;
            }
        #header_2>div>a{
            text-decoration:none; 
            color:black;
            font-weight: 500;
            }

        #header_3{width:20%; height:90%;}
        .search-box{
            padding: 10px;
            margin-top:55px;
            margin-left:100%;
            top: 50%;
            left: 50%;
            transform: translate(-100%,-0%);
            height: 40px;
            background-color: #fff;
            border: 1px solid black;
            border-radius: 30px;
            transition: 0.4s;
            width:40px;
        }
        .search-box:hover{
            box-shadow: 0px 0px .5px 1px black;
            width: 250px;
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
            width: 210px;
            padding: 0 6px;
        }

        #header_4{width:10%; 
            height:100%; 
            text-align: center; 
            position: relative; 
            z-index: 1;
            }
        #login{
            border-radius:5px; 
            border:none; padding:7px 20px; 
            margin-top: 55px;
            }

        #navi{
            list-style-type:none;
            margin:0;
            padding:0;
            height:100%;
            font-weight:300;
        }
        #navi>li{
            float: left;
            width:100%;
            height:100%;
            text-align:center;
        }
        #navi a{
            text-decoration:none;
            font-size:10px;
            color:white;
            font-weight:900;
            display:block;
            transform:scale(1);
        }
        #profile{margin-top:50px;
            margin-left:35px;
            height:50px;
            width:50px;
            }
        #hide{width:120px; 
            height:105px; 
            background-color:darkgray;
            }
        #hide>div{
            width:100%;
            height: 33%;
            padding-top:10px;
            }
        #hide a{font-weight: 300;}
        #bookmk,#logout{margin-top:10px;}

        #profile>img{width:50px; height:50px;}
        #profile>div{width:50px; height:20px;}
        #hide a:hover{color: rgb(241, 196, 15);}
        #navi>li>ul{
            list-style-type:none;
            padding:0;
            display:none;
        }
        #navi>li>ul a{font-size:15px;}
        #navi>li>div:hover+ul{display:block;}
        #navi>li>ul:hover{display:block; }

        #header_6{
            width:100%; 
            height:1%; 
            background-color: gray;
            }

    </style>
</head>
<body>
    <div class="wrap">
        <div id="header">
            <div id="header_1">
                <a href="<%= contextPath %>"><img id="logoimg"src="<%=contextPath %>/resources/images/logo.jpg"></a>
            </div>

            <div id="header_2">
                <div id="daily"><a href=""><font size="5px">Daily</font></a></div>
                <div id="trending"><a href=""><font size="5px">Trending</font></a></div>
                <div id="qna"><a href=""><font size="5px">QnA</font></a></div>
                <div id="notice"><a href="<%= contextPath %>/list.no"><font size="5px">Notice</font></a></div>
            </div>
            
            <script>
                $("#header_2 a").click(function(){
                    $("#header_2 a").css("color", "black");
                    $(this).css("color", "rgb(241, 196, 15)");
                })
            </script>

            <div id="header_3">
                <div class="search-box">
                    <input type="text" class="search-txt" name=""placeholder="Type to search">
                    <a class="search-btn" href="#">
                      <i class="fas fa-search"></i>
                    </a>
                </div>
            </div>
            
            <div id="header_4">
                
               <% //if(loginUser == null){ %>
                	<button type="button" id="login" class="btn btn-primary">로그인</button>
               <%// }else{ %>
                
	     		<ul id="navi">
	              	<li>
	                    <div>
	                        <a id="profile" href="">
	                            <img src="<%=contextPath %>/resources/images/prof.PNG" alt="" class="rounded-circle">
	                        </a>
	                        <div>닉네임</div>
	                    </div>
	                    
	                    <ul id="hide">
	                        <div id="myfage"><a href="<%= contextPath %>/myPage.me">마이페이지</a><div>
	                        <div id="bookmk"><a href="<%= contextPath %>/bookmark.me">북마크</a><div>
	                        <div id="logout"><a href="<%= contextPath %>/logout.me">로그아웃</a><div>
	                    </ul>
	        		</li>
	            </ul>
                <% //} %>
             

            </div>
            <div id="header_5">
                
            </div>

            <div id="header_6">
            </div>
        
    </div>
</body>
</html>