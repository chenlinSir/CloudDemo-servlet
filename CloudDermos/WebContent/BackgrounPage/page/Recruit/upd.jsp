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
	<link rel="stylesheet" href="BackgrounPage/page/personnel/layui/css/layui.css" />
	<script type="text/javascript" src="BackgrounPage/page/personnel/layui/layui.js"></script>
	
	<link rel="stylesheet" href="BackgrounPage/layui2/layui/css/layui.css" />
	<script type="text/javascript" src="BackgrounPage/layui2/layui/layui.js"></script>
	<script type="text/javascript">
  		layui.use(['form','layer'],function(){
  			var form = layui.form,$=layui.$,layer=layui.layer;
  			
  			 //从父层获取值，json是父层的全局js变量。eval是将该string类型的json串变为标准的json串
		        var j = eval('('+parent.json+')');
		         $("#reId").val(j.reId); 
		         $("#tt").val(j.post_id);
		        $("#tt").text(j.post_name);
		       	$("#remark").val(j.pRemark);
		       	$("#start_time").val(j.start_time);
		       	$("#end_time").val(j.end_time);
		       	$("#tt1").val(j.b_id);
		       	$("#sum").val(j.sum);
		        $("#tt1").text(j.b_name);
		        
		       	//请求部门信息
		       		$.ajax({
				        url:'servlet/RecruitServlet?op=cxb',
				        dataType:'json',
				        async: true,
				        success:function(data){
				        	$("#city1").html("<option value='"+j.b_id+"'>"+j.b_name+"</option>");
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
					        	$("#city").html("<option value='"+j.post_id+"'>"+j.post_name+"</option>");
					        	
					            $.each(data.data,function(index,item){
						        	console.log(item);
						        	
						        	 $('#city').append(new Option(item.b_name,item.b_id));
						        	 form.render('select'); //这个很重要
					            })
					        }
					   });
					});;
				
				   
		        form.on('submit(update)',function(){
	  				var formData =  $("form").serialize();
	  				$.post("servlet/RecruitServlet?op=upd",formData,function(res){
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
  </head>
  
  <body>
  		<form class="" >
    	<input id="reId" name="reId" type="hidden"/>
    	<div class="layui-form-item" style="width:410px;">
	     	<label class="layui-form-label">部门名称：</label> 
		    <div class="layui-input-block">
			    
			     <select name="city1" lay-verify="required" style=" border:1px solid #e6e6e6; width:200px; height:38px;" id="city1">
			     	 <option id="tt1" ></option>
				      <c:forEach items="${bh}" var="b">
				        <option value="${b.b_id}">${b.b_name}</option>
				        </c:forEach>
				      </select>
			    </div>
		  </div> 
		<div class="layui-form-item" style="width:410px;">
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
	      <button class="layui-btn" lay-submit lay-filter="update">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>
  </body>
</html>
