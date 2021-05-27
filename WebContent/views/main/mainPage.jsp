<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.stylecast.main.model.vo.Main"%>
<%
	ArrayList<Main> list = (ArrayList<Main>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="kr">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!--bootstrap end-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link rel="stylesheet" href="style.css">
    <!--font-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font end-->
    <style>
       
        .wrap{
            width:1200px; 
            height:1144px;  
            margin: auto; font-family:'Noto Sans KR', sans-serif;
            }

        .wrap>div{
            width:100%;
            }
        #content{
            height:100%; 
            position: relative;
            }

        


        #content_1{
            width:57%; 
            height:50%; 
            float: left;
            }
        #codi{
            margin-left: 60px; 
            height:40px; 
            margin-top:44px;
            }
        #codi>b{
            margin-top: 80px;
            }
        #codi_img{
            margin-left: 60px;
            width:616px; 
            height:396px;
            }
        #content_1>div>div{
            float: left; 
            }
        #codi_2{
            margin-left: 40px;
            }

        #content_3{
            width:10%; 
            height:50%; 
            float: left;
            }
        #change{
            height:50px; 
            width:50px; 
            padding:0px; 
            margin-top:83px; 
            border-radius: 50px; 
            border:none;
            background-color: darkgray;
            }
        #change:hover{
            background-color: gray;
            }

        #content_4{
            width:33%; 
            height:50%; 
            float:left;
            }
        #content_4>div{
            width:100%;
            }
        #todayweather>img{
            margin-top:140px; 
            margin-left:131px;
            }
        #todayweather{
            height:50%;
            }
        #todaytemp{
            height:5%; 
            text-align:center;
            }
        #location{
            height:20%; 
            text-align:center; 
            }

        #content_5{
            width:100%;
            height:35%;
            float: right;
            }
        #content_5>div{
            width:100%;
            }
        #daily{
            height:11%; 
            margin-left:60px;
            }
        #dailycontent{
            height:70%;
            width:100%;
            float:left; 
            }
        #dailycontent>div{
            height:240px; 
            float:left; 
            width:240px; 
            margin-left:60px;
            }
        #dailycontent>div>div{
        	height:240px; 
            float:left; 
            width:240px; 
        }
        #dailycontent img{
            height:240px; 
            float:left; 
            width:240px;
            }

    </style>
</head>

<body>
    
    <%@ include file="../common/menubar.jsp" %>
    
    <div class="wrap">

        <div id="content">
            <div id="content_1">
                <div id="codi">
                    <b><font size="5px">오늘의 코디</font></b>  
               </div>
                <div id="codi_img">
                    <div id="codi_1"><img id="codi_img_1" src="<%=contextPath %>/resources/codi_upfiles/codi1.jpg" alt="" width="280px" height="380px"></div>
                    <div id="codi_2"><img id="codi_img_2" src="<%=contextPath %>/resources/codi_upfiles/codi2.jpg" alt="" width="280px" height="380px"></div>
                </div>    
            </div>
            <div id="content_3">
                <button  id="change" onclick="toggleImg()">
                    <img src="<%=contextPath %>/resources/images/changebutton.png" alt="" width="100%" height="100%">
                </button>
            </div>

            <script>
                var cnt = 1;
                function toggleImg() {
                    var img1 = document.getElementById("codi_img_1");
                    var img2 = document.getElementById("codi_img_2");

                    if(cnt%2==1){
                        img1.src = "<%=contextPath %>/resources/codi_upfiles/codi3.jpg";
                        img2.src = "<%=contextPath %>/resources/codi_upfiles/codi4.jpg";
                    }else{
                        img1.src = "<%=contextPath %>/resources/codi_upfiles/codi1.jpg";
                        img2.src = "<%=contextPath %>/resources/codi_upfiles/codi2.jpg";
                    }
                    cnt++;
                }
              </script>
			
            <div id="content_4">
            	<script>
            		var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";
	            	var apiURI = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=1edf4d31ce3af918461e6292d0fd5669&units=metric";
		                $.ajax({
		                    url: apiURI,
		                    dataType: "json",
		                    type: "GET",
		                    async: "false",
		                    success: function(resp) {
		                        $("#todaytemp").text("현재온도 : "+(resp.main.temp) + "°C");
		                        $("#todayweather").text(resp.weather[0].icon);
		                        $("#")
		                        console.log("현재온도 : "+ (resp.main.temp- 273.15) );
		                        console.log("현재습도 : "+ resp.main.humidity);
		                        console.log("날씨 : "+ resp.weather[0].main );
		                        console.log("상세날씨설명 : "+ resp.weather[0].description );
		                        console.log("날씨 이미지 : "+ resp.weather[0].icon );
		                        console.log("바람   : "+ resp.wind.speed );
		                        console.log("나라   : "+ resp.sys.country );
		                        console.log("도시이름  : "+ resp.name );
		                        console.log("구름  : "+ (resp.clouds.all) +"%" );                 
		                    }
		                });
		        	function changeIcon(date){
		        		let icon = (Arr["weather"] as! [[String: Any]])[0]["icon"]
		        	}
            	</script>
                <div id="todayweather"></div>
                <div id="todaytemp" class="ctemp"></div>
                <div id="location"><b><font size="7px" >Seoul</font></b></div>   
            </div>
            
            
            
            <div id="content_5">
                <div id="daily">
                     <b><font size="5px">데일리</font></b>  
                </div>
				
                <div id="dailycontent">
                <% for(Main m : list){ %>
                	<div id="newDaily"><a href=""><img src="<%= m.getDailyImg() %>" alt=""></a></div>
                <% } %>
                </div>
            </div>
        </div>

    </div>

</body>
</html>