<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="../../layui2/layui/css/layui.css" media="all" />
		<script type="text/javascript" src="../../layui2/layui/layui.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.4.1.js" ></script>
		<style type="text/css">
			span{
				margin-right: 30px;
			}
			#btn{
				margin-left: 180px;
			}
		</style>
		<script type="text/javascript">
			layui.use(['form','layer','table'],function(){
				//获取父级页面数据
				var j = eval('('+parent.json+')');
				var form=layui.form,$=layui.$,layer=layui.layer,table = layui.table;
				table.render({
					elem:'#tbl',
					url:'../../../servlet/MRecordServlet?op=selectRecord',
					method:'post',
					width:450,
					page:true,
					limit:3,
					limits:[3,6,9],
					cols:[[
						{field:'sst_id',title:'配件名称',width:112,align:'center'},
						{field:'sst_name',title:'数量',width:110,align:'center'},
						{field:'sst_price',title:'品牌',width:112,align:'center'},
						{field:'sst_remarks',title:'售价',width:110,align:'center'},
						]]
				});	
				$("#selId").val(j.id);
				//监听表单提交
				form.on('submit(add)',function(){
					var FormDa=$("form").serialize();
					$.post("../../../servlet/MRecordServlet?op=updateRecord&rId="+$("#selId").val(),FormDa,function(res){
						if(res>0){
							layer.msg("添加成功",{time:500},function(){
								//重新加载父页面
									window.parent.location.reload();
									//关闭当前 层
									var index = parent.layer.getFrameIndex(window.name);
									parent.layer.close(index);
							});
						}else{
							layer.msg("添加失败");
						}	
				    });
				    return false;
				});
			});
		</script>
	</head>
	<body>
		<form class="layui-form" action="">
		<input type="hidden" name="id" id="selId">
		<div class="layui-container">
			<div style="background-color: #d2d2d2" align="center"><h2>客户信息</h2></div>
			<div class="layui-row">客户名称：xxx</div>
			<div class="layui-row">
			    <div class="layui-col-md3">
			      	电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：13002211563
			    </div>
			 </div>
			<div style="background-color: #d2d2d2" align="center"><h2>订单详情</h2></div>
			<div class="ding">
				<p>订单编号：23454212</p>
				<span>金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额：300</span>
				<span>服务方式：打蜡</span>
				<span>服务类型：汽车美容</span>
				<h6>接&nbsp;&nbsp;单&nbsp;&nbsp;员：XXX</h6>
			</div>
			<div class="layui-form news_list">
			  	<table class="layui-table" id="tbl" lay-filter="show">
				</table>
			</div>
			<div>开始/结束维修时间：yyyy/MM/dd~<input name="endTime" type="text" class="layui-input" id="test1"></div>
			<div>总金额：<span name="togPrice">4542</span></div>
		</div>
		
		<div class="layui-form-item" id="btn">
	    	<div class="layui-input-inline" id="btnnnn">
	    		<button class="layui-btn" lay-submit lay-filter="add">结束维修</button>
  				<button class="layui-btn" type="reset">取消</button>
  			</div>
  		</div>
		</form>
	</body>
</html>

