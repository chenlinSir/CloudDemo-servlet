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
		<script type="text/javascript">
			layui.use(['form','layer','table'],function(){
				var form=layui.form,$=layui.$,layer=layui.layer,table = layui.table;
				table.render({
					elem:'#tbl',
					url:'../../../servlet/MRecordServlet?op=selectRecord',
					method:'post',
					width:1160,
					page:true,
					limit:3,
					limits:[3,6,9],
					cols:[[
						{field:'m_id',title:'维修单号',width:150,align:'center'},
						{field:'d.oe.us_id.us_name',title:'客户名称',templet:'<div>{{d.oe.us_id.us_name}}</div>',width:95,align:'center'},
						{field:'d.oe.us_id.us_phone',title:'客户电话',templet:'<div>{{d.oe.us_id.us_phone}}</div>',width:175,align:'center'},
						{field:'d.beginTime',title:'开始时间',templet:'<div>{{d.beginTime}}</div>',width:250,align:'center'},
						{field:'d.se.sta_name',title:'维修人员',templet:'<div>{{d.se.sta_name}}</div>',width:100,align:'center'},
						{field:'sst_remarks',title:'维修费(元)',templet:'<div>未结算</div>',width:100,align:'center'},
						{field:'LStatus',title:'操作',toolbar:'#demo',width:180,align:'center'}
						]]
				});	
				//模糊查询
				$("#selectR").click(function(){
					 var DeparName=$("#inpsel").val();
					  layui.table.reload('tbl',{
						  where:{key:DeparName}
					  });
				});
				 //删除服务
				 table.on('tool(show)',function(obj){
					 var data=obj.data;
					 if(obj.event=='update'){ //修改服务
						json = JSON.stringify(data);
						var index = layui.layer.open({
							title : "查看详情",
							type : 2,
							content:'recordInfo.jsp',
							area:['500px','450px'],
							shade:[0.8,'#393D49'],
						});
					 }else if(obj.event=='delete'){
						json = JSON.stringify(data);
						alert(json);
						var index = layui.layer.open({
							title : "完成维修",
							type : 2,
							content:'recordInfo2.jsp',
							area:['500px','450px'],
							shade:[0.8,'#393D49'],
						});
					 }
				 });
			});
		</script>
	</head>
	<body>
		<form class="layui-form" action="">
		<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input id="inpsel" style="width: 300px;" type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn" id="selectR">查询</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table" id="tbl" lay-filter="show">
		</table>
	</div>
	<div id="page"></div>
			<script type="text/html" id="demo">
	 			<a class="layui-btn layui-btn-xs" lay-event="update">查看详情</a>
	 			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">完成维修</a>
	 		</script>
		</form>
	</body>
</html>
