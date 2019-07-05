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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="BackgrounPage/layui/css/layui.css" />
<script type="text/javascript" src="BackgrounPage/layui/layui.js" ></script>

<script type="text/javascript">
layui.use(['form','layer'],function(){
			var form=layui.form,$=layui.$,layer=layui.layer;
				//监听表单提交
				form.on('submit(addUser)',function(){
					var FormDa=$("form").serialize();
					alert(FormDa);
					/*$.post("../../servlet/OrderServlet?op=addOrders",FormDa,function(res){
					
						if(res>0){
							layer.msg("添加成功",{time:500},function(){
								//重新加载表格
								parent.layui.table.reload('tb');
							   //关闭当前弹层
							   var index= window.parent.layer.getFrameIndex(window.name); 
							       window.parent.layer.close(index);
							});
						
						}else{
							layer.msg("添加失败");
						}	
			
			        });*/
			        return false;
				});
			
		
		});


</script>
<body class="childrenBody">
	<form class="layui-form" style="width:80%;" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">客户姓名</label>
			<div class="layui-input-block">
				<input type="text" name="userName"  class="layui-input userName" lay-verify="required" placeholder="请输入客户名">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">接单员</label>
			<div class="layui-input-block">
				<input type="text" name="staName" class="layui-input staName" lay-verify="required" placeholder="请输入接单员">
			</div>
		</div>
			
		     <div class="layui-inline">
			    <label class="layui-form-label">服务类型</label>
				<div class="layui-input-block">
					<select class="userGrade" lay-filter="userGrade" name="userGrade">
						<option value="0">==请选择==</option>					
				   </select>
				</div>
		    </div>
		    
		        <div class="layui-inline">
			    <label class="layui-form-label">服务方式</label>
				<div class="layui-input-block">
					<select  class="userStatus" lay-filter="userStatus" name="LStatus">
						<option value="0">==请选择==</option>
						<option value="1">上门服务</option>
						<option value="2">在店服务</option>
				    </select>
				</div>
		    </div>
		    
		    <div class="layui-inline">
			    <label class="layui-form-label">订单状态</label>
				<div class="layui-input-block">
					<select class="OrderStatus" lay-filter="userStatus" name="payStatus">
						<option value="0">==请选择==</option>
						<option value="1">已付款</option>
						<option value="2">未付款</option>
				    </select>			 
				</div>
		    </div>
		        
		</div>
		   <div class="layui-inline">
			    <label class="layui-form-label">支付方式</label>
				<div class="layui-input-block">
					<select  class="PayStatus" lay-filter="userStatus" name="orderStatus">
						<option value="0">==请选择==</option>
						<option value="1">现金</option>
						<option value="2">微信</option>
						<option value="3">支付宝</option>
						<option value="4">网银</option>
						</select>
				</div>
		    </div>
		      <div class="layui-inline">
			    <label class="layui-form-label">折扣</label>
				<div class="layui-input-block">
					<select class="ZkStatus" lay-filter="userStatus" name="zkStatus">
						<option value="0">==请选择==</option>
						<option value="1">9.5折</option>
						<option value="2">9折</option>
						<option value="3">8.5折</option>
						<option value="4">8折</option>
						</select>
				</div>
		    </div>
		    
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea name="remark" placeholder="请输入备注" class="layui-textarea linksDesc"></textarea>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="addUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
  </body>
</html>
