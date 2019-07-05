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
	<link rel="stylesheet" href="BackgrounPage/css/layui.css" />
	<script type="text/javascript" src="BackgrounPage/js/layui.js" ></script>

	<script type="text/javascript">
		layui.use(['form','layer'],function(){
			var form=layui.form,$=layui.$,layer=layui.layer;
			var j=eval('('+parent.json+')');
			$("#id").val(j.Id);
			$("#userName").val(j.us_id.us_name);
			$("#staName").val(j.sta_id.sta_name);
		
			//服务方式
			$("#userGrade").text(j.lst_id.lst_name);
			$.post("servlet/BigServiceServlet?op=selectBig",function(res){
					$(res).each(function(i,q){
						var $option = $("<option value='"+q.lst_id+"'>"+q.lst_name+"</option>");
						if(j.lst_id.lst_id==q.lst_id){
							var $option = $("<option selected='selected' value='"+q.lst_id+"'>"+q.lst_name+"</option>");
						}
						$option.appendTo($(".userGrade"));
					});
				form.render();
			},"json");
			
			//服务类型
			$("#LStatus").text(j.service_way);
			if("上门服务"==j.service_way){
				$("select[name='LStatus'] option:eq(1)").attr("selected","selected");
			}else{
				$("select[name='LStatus'] option:eq(2)").attr("selected","selected");
			}
			//订单状态
			$("#ordertatus").text(j.order_state);
			if("未付款"==j.order_state){
				$("select[name='ordertatus'] option:eq(1)").attr("selected","selected");
			}else{
				$("select[name='ordertatus'] option:eq(2)").attr("selected","selected");
			}
			//付款方式
			$("#payStatus").text(j.pay_type);
			if("现金"==j.pay_type){
				$("select[name='payStatus'] option:eq(1)").attr("selected","selected");
			}else if("微信"==j.pay_type){
				$("select[name='payStatus'] option:eq(2)").attr("selected","selected");
			}else if("支付宝"==j.pay_type){
				$("select[name='payStatus'] option:eq(3)").attr("selected","selected");
			}else if("网银"==j.pay_type){
				$("select[name='payStatus'] option:eq(4)").attr("selected","selected");
			}
			//折扣
			$("#zkStatus").text(j.discount);
			if("9.5"==j.discount){
				$("select[name='zkStatus'] option:eq(1)").attr("selected","selected");
			}else if("9"==j.discount){
				$("select[name='zkStatus'] option:eq(2)").attr("selected","selected");
			}else if("8.5"==j.discount){
				$("select[name='zkStatus'] option:eq(3)").attr("selected","selected");
			}else if("8"==j.discount){
				$("select[name='zkStatus'] option:eq(4)").attr("selected","selected");
			}
			$("#remark").val(j.remark);
			form.render();
				//监听表单提交
				form.on('submit(update)',function(){
					//表单序列化
					var FormDa=$("form").serialize();
					$.post("servlet/OrderServlet?op=update",FormDa,function(res){
						if(res>0){
							layer.msg("修改成功",{time:500},function(){
								//重新加载表格
								parent.layui.table.reload('tb');
							    //关闭当前弹层
							   var index= window.parent.layer.getFrameIndex(window.name); 
							       window.parent.layer.close(index);
							});
						
						}else{
							layer.msg("修改失败");
						}		
			        });
			        return false;
				});
			
		
		});
	
	
	</script>
<body class="childrenBody">
	<form class="layui-form" style="width:80%;" >
	<input type="hidden" name="id" required  lay-verify="required" autocomplete="off" class="layui-input" id="id">
		<div class="layui-form-item">
			<label class="layui-form-label" >客户姓名</label>
			<div class="layui-input-block">
				<input type="text" name="userName"  id="userName" class="layui-input userName" lay-verify="required" placeholder="请输入客户名">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">接单员</label>
			<div class="layui-input-block">
				<input type="text" name="staName" id="staName" class="layui-input staName" lay-verify="required" placeholder="请输入接单员">
			</div>
		</div>
			
		     <div class="layui-inline">
			    <label class="layui-form-label">服务类型</label>
				<div class="layui-input-block">
					<select class="userGrade" lay-filter="userGrade" name="userGrade"  id="userGrade">
						<option value="0" >==请选择==</option>					
				   </select>
				</div>
				</div>
		    </div>
		    
		        <div class="layui-inline">
			    <label class="layui-form-label">服务方式</label>
				<div class="layui-input-block">
					<select  class="userStatus" lay-filter="userStatus" name="LStatus" >
						<option value="0" >==请选择==</option>
						<option value="上门服务">上门服务</option>
						<option value="在店服务">在店服务</option>
				    </select>
				</div>
		    </div>
		    
		    <div class="layui-inline">
			    <label class="layui-form-label">订单状态</label>
				<div class="layui-input-block">
					<select class="OrderStatus" lay-filter="userStatus" name="ordertatus" >
						<option value="0">==请选择==</option>
						<option value="未付款">未付款</option>
						<option value="已付款">已付款</option>
				    </select>			 
				</div>
		    </div>
		        
		</div>
		   <div class="layui-inline">
			    <label class="layui-form-label">支付方式</label>
				<div class="layui-input-block">
					<select  class="PayStatus" lay-filter="userStatus" name="payStatus" >
						<option value="0">==请选择==</option>
						<option value="现金">现金</option>
						<option value="微信">微信</option>
						<option value="支付宝">支付宝</option>
						<option value="网银">网银</option>
						</select>
				</div>
		    </div>
		      <div class="layui-inline">
			    <label class="layui-form-label">折扣</label>
				<div class="layui-input-block">
					<select class="ZkStatus" lay-filter="userStatus" name="zkStatus">
						<option value="0">==请选择==</option>
						<option value="9.5">9.5</option>
						<option value="9">9</option>
						<option value="8.5">8.5</option>
						<option value="8">8</option>
						</select>
				</div>
		    </div>
		    
		       
		    
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<textarea name="remark" id="remark" placeholder="请输入备注" class="layui-textarea linksDesc"></textarea>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="update">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
  </body>
</html>
