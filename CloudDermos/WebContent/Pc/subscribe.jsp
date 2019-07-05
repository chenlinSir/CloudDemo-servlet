<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Typography</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- font -->
<link href="http://fonts.googleapis.com/css?family=Cinzel:400,700,900" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
<!-- //font -->

  <link rel="stylesheet" href="css/layui.css"  media="all">

<link href="css/jquery.fancyspinbox.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/lay/modules/layer.js" charset="utf-8"></script>
<script src="js/layui.js"></script>

<script src="js/bootstrap.js"></script>

		<script>
			layui.use(['laypage','laydate','form'], function(){
			  var form = layui.form;
			  var laypage = layui.laypage;
			  var laydate = layui.laydate;
			  //执行laydate实例
			  laydate.render({
			  	elem:'#date'
			  });
			  
			  //执行一个laypage实例
			  laypage.render({
			    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
			    ,count: 50 //数据总数，从服务端得到
			  });
			  form.on('submit(login_hash)', function(data) {
      		 
	        var layIndex = layer.load(2, {
	          shade: [0.1, '#393D49']
	        });
        
      	var formData =  $("form").serialize();
        $.post("../",formData,function(res){
  					if(res>0){
 						    layer.open({
                        type:0,
                        title: false,
                        fixed :true,
                        closeBtn: 0,
                        resize :false,
                        btn :false,
                        shift: 2,
                        shadeClose: true,
                        content: '提交成功',
                        time:1000,
                        end :function(){
 						    	layer.close(layIndex);
                        }
                    });
  							
  					}else{
  						layer.msg("留言失败,请联系管理员！",{
  							time: 3000,
  						});
  						 layer.close(layIndex);
  					}
      })
      
      return false;
      })
			});
		</script>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script> 
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<!-- banner -->
	<div class="banner jarallax">
		<div class="banner-dot">
			<div class="header-top">
				<div class="container">
					<div class="header-top-left">
						<p><i class="fa fa-home" aria-hidden="true"></i> 1st Street , mexico city</p>
					</div>
					<div class="header-top-right">
						<p><i class="fa fa-phone" aria-hidden="true"></i> +1 234 567 8901</p>
					</div>
				</div>
			</div>
			<div class="header">
				<div class="container">
					<div class="header-left">
						<div class="w3layouts-logo">
							<h1>
								<a href="index.html">Carmotive</a>
							</h1>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			
			<div class="header-right about-top">
				<div class="container">
						<div class="top-nav">
							<nav class="navbar navbar-default">
								<div class="navbar-header">
									<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
										<span class="sr-only">Toggle navigation</span>
										<span class="icon-bar"></span>
										<span class="icon-bar"></span>
										<span class="icon-bar"></span>
									</button>
								</div>
								<!--navbar-header-->
								<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav navbar-right">
										<li><a href="index.html">Home</a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="gallery.html">Gallery</a></li>
										<li class=""><a href="#" class="dropdown-toggle hvr-bounce-to-bottom active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Recruit<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a class="hvr-bounce-to-bottom" href="icons.html">Icons</a></li>
												<li><a class="hvr-bounce-to-bottom" href="typography.html">Typography</a></li>          
											</ul>
										</li>	
										<li><a href="Information Center.html">Information Center</a></li>
										<li><a href="contact.html">Contact Us</a></li>
									</ul>	
									<div class="clearfix"> </div>	
								</div>
							</nav>
						</div>
						<div class="clearfix"> </div>
					</div>
			</div>
			<div class="wthree-heading">
				<h2>Typography</h2>
			</div>
		</div>
	</div>
	<!-- //banner -->
	
	<!-- subscribe -->
	<div class="wthree-subscribe">
		<div class="container">
			<div class="agileits-heading">
				<h3>预约登记表</h3>
			</div>
			<div class="w3-agileits-subscribe-form">
				<form class="layui-form" action="" method="post">
					<div class="layui-form-item">
					    <div class="layui-inline">
					      <label class="layui-form-label"style="width: 100px">客户姓名：</label>
					      <div class="layui-input-inline">
					        <input type="tel" name="phone" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					      </div>
					    </div>
					    <div class="layui-inline">
					      <label class="layui-form-label" style="width: 100px">联系电话：</label>
					      <div class="layui-input-inline">
					        <input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
					      </div>
					    </div>
					</div>
					<div class="layui-form-item">
					    <div class="layui-inline">
					      <label class="layui-form-label" style="width: 100px">车型：</label>
					      <div class="layui-input-inline" style="width: 220px">
						        <select name="modules"  lay-verify="required" lay-search="">
						          <option value="">请选择车型</option>
						          <option value="奔驰">奔驰</option>
						          <option value="宝马">宝马</option>
						          <option value="法拉利">法拉利</option>
						          <option value="劳斯莱斯">劳斯莱斯</option>
						          <option value="小绵羊">小绵羊</option>
						          <option value="比亚迪">比亚迪</option>
						          <option value="布加迪威龙">布加迪威龙</option>
						          <option value="大众">大众</option>
						          <option value="马自达">马自达</option>
						          <option value="奥迪">奥迪</option>
						        </select>
					    </div>
					    <div class="layui-inline">
					      <label class="layui-form-label" style="width: 100px">车牌号码：</label>
					      <div class="layui-input-inline">
					        <input type="tel" name="phone" lay-verify="required" placeholder="请输入车牌号码" autocomplete="off" class="layui-input">
					      </div>
					    </div>
					</div>
					
			</div>
			 <div class="layui-form-item">
					    <div class="layui-inline">
					      <label class="layui-form-label"style="width: 150px">预计进站时间：</label>
					      <div class="layui-input-inline">
					         <input type="text" style="width: 100%" name="date" id="date" lay-verify="date" placeholder="请选择预计进站时间" autocomplete="off" class="layui-input">
					      </div>
					    </div>
					    <div class="layui-inline">
					      <label class="layui-form-label" style="width: 100px">故障描述：</label>
					      <div class="layui-input-inline">
					        <input type="tel" name="phone" lay-verify="required" placeholder="请输入故障描述" autocomplete="off" class="layui-input">
					      </div>
					    </div>
					</div>
				    <label class="layui-form-block">备注内容：</label>
				  <div class="layui-form-item layui-form-text" >
				    <div class="layui-input-block">
				      <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
				    </div>
				  </div>
				    <div class="layui-form-item">
					    <div class="layui-input-block">
					      <button class="layui-btn" lay-submit="submit" lay-filter="login_hash" lay-filter="demo1">立即提交</button>
					      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
					    </div>
				  </div>
				</form>
			</div>
		</div>
	</div>
	<!-- //subscribe -->
	
		<div class="wthree-subscribe" style="padding-top: 0px;">
		<div class="container">
			<div class="agileits-heading">
				<div class="layui-form">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- typography -->
	
		
	<!-- footer -->
	<div class="w3-agile-footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Address</h4>
					</div>
					<div class="footer-grid-info">
						<p>Guizhou Aerospace Vocational and Technical College
							<span>65 Ping'an Avenue,Zip codet 563000.</span>
						</p>
						<p class="phone">Phone : +135 9559 4303
							<span>Email : <a href="#">2671412803@qq.com</a></span>
							<span>FAX : <a href="#">123 456 789</a></span>
						</p>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Navigation</h4>
					</div>
					<div class="footer-grid-info">
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">About</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="icons.html">Icons</a></li>
							<li><a href="typography.html">Typography</a></li>
							<li><a href="Information Center.html">Information Center</a></li>
							<li><a href="contact.html">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Newsletter</h4>
					</div>
					<div class="agile-footer-grid">
						<ul class="w3agile_footer_grid_list">
							<li>Lamborghinini, the company's new beauty product <a href="#">http://Lamborghinini.com</a> at list,for everybody.
								<span><i class="fa fa-twitter" aria-hidden="true"></i> 02 days ago</span></li>
							<li>Lamborghinini, the company's new beauty product <a href="#">http://Lamborghinini.com</a><span><i class="fa fa-twitter" aria-hidden="true"></i> 03 days ago</span></li>
						</ul>
					</div>
				</div>
				<div class="col-md-3 footer-grid">
					<div class="footer-grid-heading">
						<h4>Follow</h4>
					</div>
					<div class="social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-rss"></i></a></li>
							<li><a href="#"><i class="fa fa-vk"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="agileits-w3layouts-copyright">
				<p>Preson &copy; 2019.Company name All rights reserved.</p>
			</div>
		</div>
	</div>
	<!-- //footer -->
	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>

	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>	
</html>
