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
    
    <title>My JSP 'addbrach.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="BackgrounPage/page/personnel/layui/css/layui.css" />
	<script type="text/javascript" src="BackgrounPage/page/personnel/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','layer'],function(){
			var form=layui.form,$=layui.$,layer=layui.layer;
			
			 $.post("servlet/staffinfoServlet?op=saddpost",function(res){
				$(res).each(function(i,q){
					var $option = $("<option value='"+q.b_id+"'>"+q.b_name+"</option>");
					$option.appendTo($("#serviceType"));
				});
				form.render();
			},"json");
			
			
			
			//监听表单提交
			form.on('submit(add)',function(){
				var formData=$("form").serialize();
				$.post("servlet/staffinfoServlet?op=addpost",formData,function(res){
					if(res>0){
						layer.msg("添加职位成功",{time:2000},function(){
							//重新加载表格
							parent.layui.table.reload('tb');
							//关闭当前弹层
							var index = window.parent.layer.getFrameIndex(window.name);
							window.parent.layer.close(index);
						});
					}else{
						layer.msg("添加职位失败");
					}
				});
				return false;
			});
		});
	</script>
  </head>
  
  <body>
    <form class="layui-form" method="post" action="">
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">职位名称：</label>
  			<div class="layui-input-inline">
  				<input name="uname" class="layui-input" placeholder="请输入职位名" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20px; width:410px;" >
  			<label class="layui-form-label">部门选择：</label>
		    <div class="layui-input-block">
		      <select id="serviceType" name="serviceType">
     				<option  id="a"  value="0">请选择职位</option>
     			</select>
		    </div>
  		</div>
  		<div class="layui-form-item" style="margin-top: 20">
  			<label class="layui-form-label">职位备注：</label>
  			<div class="layui-input-inline">
  				<input name="remark" class="layui-input" style="width: 300" placeholder="请输入备注" autocomplete="off"/>
  			</div>
  		</div>
  		<div class="layui-form-item">
  			<div class="layui-input-inline" style="padding-left:150px;">
  				<button class="layui-btn" lay-submit lay-filter="add">提交</button>
  				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
  			</div>
  		</div>
  	</form>
  </body>
</html>
