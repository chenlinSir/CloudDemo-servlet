<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="../../layui2/layui/css/layui.css" media="all" />
	<script type="text/javascript" src="../../layui2/layui/layui.js"></script>
	<style type="text/css">
		#btnnnn{
			padding-left: 200px;
		}
		#top{
			padding-top: 100px;
		}
		.layui-form-item{
			padding-left: 60px;
		}
	</style>
	<script type="text/javascript">
		layui.use(['form','layer'],function(){
			var j = eval('('+parent.json+')');
			var form=layui.form,$=layui.$,layer=layui.layer;
				$("#serviceUpdata").val(j.lst_name);
				//监听表单提交
				form.on('submit(upd)',function(){
					var FormDa=$("form").serialize();
					$.post("../../../servlet/BigServiceServlet?op=updateBig&upId="+j.lst_id,FormDa,function(res){
						if(res>0){
							layer.msg("修改成功",{time:500},function(){
								//重新加载父页面
								window.parent.location.reload();
								//关闭当前层
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
							});
						}else{
							layer.msg("修改失败");
						}	
			
			        });
			        return false;
				});
				$("#quxiao").click(function(){
					var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
				});
		});
	
	</script>
  </head>
  
  <body>
  	<form class="layui-form" action="">
  		<div class="layui-form-item" id="top">
   			<label class="layui-form-label">服务类型:</label>
        	<div class="layui-input-inline">
     			<input id="serviceUpdata" name="serviceTypeUpdate" required  lay-verify="required" placeholder="请输入服务类型名称" autocomplete="off" class="layui-input">
	    	</div>
	    </div>
	    <div class="layui-form-item">
	    	<div class="layui-input-inline" id="btnnnn">
	    		<button class="layui-btn" lay-submit lay-filter="upd">修改</button>
  				<a class="layui-btn" id="quxiao">取消</a>
  			</div>
  		</div>
  	</form>
  </body>
</html>

