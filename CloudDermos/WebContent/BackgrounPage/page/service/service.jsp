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
		<script type="text/javascript" src="../../js/jquery-1.4.1.js"></script>
		<script type="text/javascript">
			layui.use(['form','layer','table'],function(){
				var form=layui.form,$=layui.$,layer=layui.layer,table = layui.table;
				
				//添加服务
				$("#serviceAddSmall").click(function(){
					var index = layui.layer.open({
						title : "新增服务",
						type : 2,
						content : "serviceAdd.jsp",
						area:['500px','450px'],
						shade:[0.8,'#393D49'],
					})
				});
				//添加服务类型
				$("#addLarge").click(function(){
					var index = layui.layer.open({
						title : "新增服务",
						type : 2,
						content : "serviceTypeAdd.jsp",
						area:['500px','450px'],
						shade:[0.8,'#393D49'],
					});
				});
				//修改服务类型
				var jsaon;
				$("#updateLarge").click(function(){
					$.post("../../../servlet/BigServiceServlet?op=selectBigById&id="+$("#sel").val(),function(res){
						if(res!=null){
							json = JSON.stringify(res);
							var index = layui.layer.open({
								title : "修改服务类型",
								type : 2,
								content : "serviceTypeUpdate.jsp",
								area:['500px','450px'],
								shade:[0.8,'#393D49'],
							});
						}
					},"json")
				});
				//删除服务类型
				var jsaon;
				$("#deleteLarge").click(function(){
					$.post("../../../servlet/BigServiceServlet?op=deleteBig&delId="+$("#sel").val(),function(res){
						if(res>0){
							layer.msg("删除成功",{time:500},function(){
								//重新加载页面
								window.location.reload();
							});
						}else{
							layer.msg("删除失败");
						}
					},"json")
				});
				//获取服务类型数据
				$.post("../../../servlet/BigServiceServlet?op=selectBig",function(res){
					$(res).each(function(i,q){
						var $option = $("<option value='"+q.lst_id+"'>"+q.lst_name+"</option>");
						$option.appendTo($("#sel"));
					});
					form.render();
				},"json");
				//遍历表格数据
				table.render({
					elem:'#tbl',
					url:'../../../servlet/SmallServiceServlet?op=selectSmall',
					method:'post',
					width:1150,
					page:true,
					limit:3,
					limits:[3,6,9],
					cols:[[
						{field:'sst_id',title:'编号',width:100,align:'center'},
						{field:'sst_name',title:'服务名称',width:140,align:'center'},
						{field:'bse.lst_name',title:'服务类型',templet:'<div>{{d.bse.lst_name}}</div>',width:140,align:'center'},
						{field:'sst_price',title:'工时费(单位/元)',width:170,align:'center'},
						{field:'sst_remarks',title:'备注',width:410,align:'center'},
						{field:'LStatus',title:'操作',toolbar:'#demo',width:180,align:'center'}
					]]
				});
				//模糊查询
				$("#searchSmall").click(function(){
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
									title : "修改服务",
									type : 2,
									content:'serviceUpdate.jsp',
									area:['500px','450px'],
									shade:[0.8,'#393D49'],
								});
						 
					 }else if(obj.event=='delete'){
						 layer.confirm("是否删除数据?",function(){
							 $.post("../../../servlet/SmallServiceServlet",{op:'delSmall',delId:data.sst_id},function(res){
								 if(res>0){ 
									 layer.msg("删除成功",{time:500},function(){
								   //刷新表格
								   table.reload('tbl');
							});
									
								 }else if(res=0){
									 layer.msg("没有找到【"+data.sst_id+"】",{time:500});
								 }else if(res<0){
									 layer.msg("程序异常，请稍后再试.....",{time:500});
								 }	 
							 });
							 
						 });
						 
					 }
				 });
				 
			});
		</script>
	</head>
	<body>
		<form class="layui-form" action="" id="tb">
			<div class="layui-form-item">
	   			<label class="layui-form-label">服务类型:</label>
	        	<div class="layui-input-inline">
	     			<select id="sel" lay-filter="serviceType">
	     				<option value="0">请选择服务类型</option>
	     			</select>
		    	</div>
		    	<div class="layui-inline">
					<a class="layui-btn layui-btn-normal" id="addLarge">新增服务类型</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-normal" id="updateLarge" lay-event="update">修改服务类型</a>
				</div>
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger" id="deleteLarge">删除服务类型</a>
				</div>
		    </div>
		<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input id="inpsel" style="width: 300px;" type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn" id="searchSmall">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal" id="serviceAddSmall">新增服务</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table" id="tbl" lay-filter="show">
		</table>
	</div>
	<div id="page"></div>
			<script type="text/html" id="demo">
	 			<a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
	 			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
	 		</script>
		</form>
	</body>
</html>
