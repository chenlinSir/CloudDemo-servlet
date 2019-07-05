<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="BackgrounPage/layui2/layui/css/layui.css" />
	<script type="text/javascript" src="BackgrounPage/layui2/layui/layui.js"></script>
	<script type="text/javascript">
  		layui.use(['form','layer'],function(){
  			var form = layui.form,$=layui.$,layer=layui.layer;
  			
		       	//请求部门信息
		       		$.ajax({
				        url:'servlet/RecruitServlet?op=cxb',
				        dataType:'json',
				        async: true,
				        success:function(data){
				        
				        	$("#city1").html("<option value=''>选择部门</option>");
				            $.each(data.data,function(index,item){
				        	 $('#city1').append(new Option(item.b_name,item.b_id));
				        	 form.render('select'); //这个很重要
				            })
				        }
				   }); 
				  $("#city1").click(function(){
					    console.log("xz"+$(this).val());
					    var zhi=$(this).val();
					   $.ajax({
					        url:'servlet/RecruitServlet?op=cx1&post_id='+zhi,
					        dataType:'json',
					        async: true,
					        success:function(data){
					        	$("#city").html("<option value=''>选择职位</option>");
					        	
					            $.each(data.data,function(index,item){
						        	console.log(item);
						        	 $('#city').append(new Option(item.b_name,item.b_id));
						        	 form.render('select'); //这个很重要
					            })
					        }
					   });
					});;
				
				
  			//监听表单提交
			form.on('submit(add)',function(){
				var formData=$("form").serialize();
				$.post("servlet/RecruitServlet?op=add",formData,function(res){
					if(res>0){
						layer.msg("发布成功",{time:2000},function(){
							//重新加载表格
							parent.layui.table.reload('tb');
							//关闭当前弹层
							var index = window.parent.layer.getFrameIndex(window.name);
							window.parent.layer.close(index);
						});
					}else{
						layer.msg("发布招聘失败");
					}
				});
				return false;
			});
  		})
  		
  </script>
  </head>
  
  <body>
  		<form >
    	<div class="layui-form-item" style=" width:410px;">
	    <label class="layui-form-label">部门名称：</label>
		    <div class="layui-input-block">
			      
			     <select name="city1" lay-verify="required" style="border:1px solid #e6e6e6; width:200px; height:38px;" id="city1">
			     	 <option id="tt1" ></option>
				      <c:forEach items="${bh}" var="b">
				        <option value="${b.b_id}">${b.b_name}</option>
				        </c:forEach>
				      </select>
			    </div>
		  </div> 
		<div class="layui-form-item" style=" width:410px;">
	     	<label class="layui-form-label">职位名称：</label> 
		    <div class="layui-input-block">
			    
			     <select name="city" lay-verify="required" style=" border:1px solid #e6e6e6; width:200px; height:38px;" id="city">
			     	 <option id="tt" ></option>
				      <c:forEach items="${bh}" var="b">
				        <option value="${b.post_id}">${b.post_name}</option>
				        </c:forEach>
				      </select>
			    </div>
		  </div>
  		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">开始时间</label>
			    <div class="layui-input-block">
			    	<input class="layui-input" name="start_time" id="start_time"/>
			    </div>
		</div>
		<div class="layui-form-item">
			    <label class="layui-form-label">结束时间</label>
			    <div class="layui-input-block">
			    	<input class="layui-input" name="end_time" id="end_time"/>
			    </div>
		</div>
		 <div class="layui-form-item">
			    <label class="layui-form-label">招聘人数</label>
			    <div class="layui-input-block">
			    	<input class="layui-input" name="sum" id="sum"/>
			    </div>
		</div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="add">立即发布</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>
  </body>
</html>
