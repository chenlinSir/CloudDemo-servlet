<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="dist/jq_slideImage.js" type="text/javascript" charset="utf-8"></script>
		<style>
			.demo1{
				width: 100%;
				height: 300px;
			}
			.demo2{
				width: 300px;
				height: 200px;
			}
		</style>
	</head>
	<body>
	    <div class="demo2" id="slideImageWrap2">
	
	    </div>
    <script>
        var mySlideImage2 = new SlideImageVerify('#slideImageWrap2',{
        	initText:'请滑动拼图完成验证',
            slideImage:['image/1457076225317.jpg','image/1453451563372.jpg','image/1413425283564.jpg','image/1453451550875.jpg','image/1453451555614.jpg','image/1453451559718.jpg'],
            slideAreaNum:20,
            refreshSlide:false,
            getSuccessState:function (res) {
                window.top.location.href="BackgrounPage/index.jsp";
            }
        })
    </script>
  </body>
</html>
