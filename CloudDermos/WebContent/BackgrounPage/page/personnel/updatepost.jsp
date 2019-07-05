<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		        $.post("servlet/staffinfoServlet?op=saddpost",function(res){
				$(res).each(function(i,q){
					var $option = $("<option value='"+q.b_id+"'>"+q.b_name+"</option>");
					if(j.bh.b_id==q.b_id){
						var $option = $("<option selected='selected' value='"+q.b_id+"'>"+q.b_name+"</option>");
					}
					$option.appendTo($("#serviceType"));
				});
				form.render();
			},"json");
		        
		         $("#id").val(j.post_id); 
		        $("#name").val(j.post_name);
		       	$("#remark").val(j.p_remark);
		        
		        form.on('submit(update)',function(){
  				var formData =  $("form").serialize();
  				$.post("servlet/staffinfoServlet?op=updatepost",formData,function(res){
  					if(res>0){
  						layer.msg("修改成功",{time:500},function(){
  							parent.layui.table.reload('tb');
  							var index = window.parent.layer.getFrameIndex(window.name);
  							window.parent.layer.close(index);
  							
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
    <form class="layui-form">
    	<input id="id" name="id" type="hidden"/>
		<div class="layui-form-item" style="margin-top: 20px; width:410px;">
	    <label class="layui-form-label">职位名称：</label>
	    <div class="layui-input-block">
	      <input type="text" id="name" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	 	<div class="layui-form-item"style="margin-top: 20px; width:410px;" >
  			<label class="layui-form-label">部门选择</label>
		    <div class="layui-input-block">
		      <select id="serviceType" name="serviceType">
     				<option  id="a"  value="0">请选择职位</option>
     			</select>
		    </div>
  		</div>
		<div class="layui-form-item" style="margin-top: 20px; width:410px;">
		    <label class="layui-form-label">职位备注：</label>
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
