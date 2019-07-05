<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="BackgrounPage/page/personnel/layui/css/layui.css">
  	<script type="text/javascript" src="BackgrounPage/page/personnel/layui/layui.js"></script>
  </head>
  <script type="text/javascript">
  		layui.use(['form','layer'],function(){
  			var form = layui.form,$=layui.$,layer=layui.layer;
  			
  			 //从父层获取值，json是父层的全局js变量。eval是将该string类型的json串变为标准的json串
		        var j = eval('('+parent.json+')');
		         $("#id").val(j.b_id); 
		        $("#name").val(j.b_name);
		       $("#remark").val(j.b_remark);
		        
		        form.on('submit(update)',function(){
  				var formData =  $("form").serialize();
  				$.post("servlet/staffinfoServlet?op=updatebreachs",formData,function(res){
  					if(res>0){
  						layer.msg("修改成功",{time:500},function(){
  							parent.layui.table.reload('tb');
  							var index = window.parent.layer.getFrameIndex(window.name);
  							window.parent.layer.close(index)
  						})
  					}else{
  						layer.msg("修改失败");
  					}
  				})
  				return false;
  			})
  			
  		})
  		
  </script>
  <body>
    <form class="">
    	<input id="id" name="id" type="hidden"/>
		<div class="layui-form-item">
	    <label class="layui-form-label">部门名称：</label>
	    <div class="layui-input-block">
	      <input type="text" id="name" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	
	
		<div class="layui-form-item">
		    <label class="layui-form-label">部门备注：</label>
		    <div class="layui-input-inline">
		      <input type="text" id="remark" name="remark" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
    	</div>
		  
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="update">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
	</form>
  </body>
</html>
