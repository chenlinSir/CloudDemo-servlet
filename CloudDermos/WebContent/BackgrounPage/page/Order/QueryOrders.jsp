<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	<meta charset="utf-8">
	<title>用户总数--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	
	<link rel="stylesheet" href="../../layui2/layui/css/layui.css" />
    <script type="text/javascript" src="../../layui2/layui/layui.js" ></script>
		<script type="text/javascript">
			layui.use(['table','layer'],function(){
				
				var table=layui.table,$=layui.$,layer =layui.layer ;
					//遍历表格数据
					table.render({
					elem:'#tb',
					url:'../../../servlet/OrderServlet?op=selectOrder',
					method:'post',
					width:1150,
					page:true,
					limit:3,
					limits:[3,6,9],
					cols:[[
						{field:'Id',title:'订单编号',width:90,align:'center'},
						{field:'out_id',title:'出库订单',templet:'<div>{{d.o_id==0?0:d.o_id}}</div>',width:90,align:'center'},
						{field:'us_id',title:'客户姓名',templet:'<div>{{d.us_id.us_name}}</div>',width:100,align:'center'},
						{field:'lst_id',title:'服务类型',templet:'<div>{{d.lst_id.lst_name}}</div>',width:100,align:'center'},
						{field:'service_way',title:'服务方式',width:158,align:'center'},
						{field:'discount',title:'折扣',width:100,align:'center'},
				        {field:'pay_type',title:'付款方式',width:100,align:'center'},
						{field:'order_state',title:'订单状态',width:100,align:'center'},
						{field:'sta_id',title:'接单员',templet:'<div>{{d.sta_id.sta_name}}</div>',width:101,align:'center'},
						{field:'right',title:'操作',toolbar:'#demo',width:200,align:'center'}
					]],
					initSort:{
    				field: 'Id',   //排序字段，对应 cols 设定的各字段名	
    				type: 'asc'    //排序方式  asc: 升序、desc: 降序、null: 默认排序
                           }
				});
					 
					
				//模糊查询
				$("#search").click(function(){
					var keyword=$("#key").val();
					
				   layui.table.reload('tb',
						{
							where:{key:keyword}
						}
				    );
				});
				//添加订单
				 $("#addOrders").click(function(){
					 layer.open({
						 type:2,
						 title:'添加订单',
						 content:'Orders.jsp',
						 area:['400px','500px'],
                         shade:[0.8, '#393D49'],
                         
					 }); 
				 });
				 //删除客户
				 var jason;
				 table.on('tool(show)',function(obj){
					 var data=obj.data;
					  //修改订单
					 if(obj.event=='update'){
						 json=JSON.stringify(data);
						 layer.open({
						 type:2,
						 title:'修改订单',
						 content:'UpdateOrders.jsp',
						 area:['400px','500px'],
                         shade:[0.8, '#393D49'],   
					 });
						 
					 }
					  //添加维修记录单
					 else if(obj.event=='add'){ 
						 json=JSON.stringify(data);
						 layer.open({
						 type:2,
						 title:'添加维修记录',
						 content:'Add.jsp',
						 area:['400px','400px'],
                         shade:[0.8, '#393D49'],
						 });
					 }
					 else if(obj.event=='delete'){
						 layer.confirm("是否删除数据?",function(){
							 $.post("../../../servlet/OrderServlet",{op:'delete',Id:data.Id},function(res){
								 if(res>0){ 
									 layer.msg("删除成功",{time:500},function(){
								   //刷新表格
								   table.reload('tb');
							});	
								 }else if(res=0){
									 layer.msg("没有找到【"+data.Id+"】",{time:500});
								 }else if(res<0){
									 layer.msg("程序异常，请稍后再试.....",{time:500});
								 }	 
							 });
							 
						 });
						 
					 }
				 });
				 
				 
				 
				 
			});
		</script>
    <body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="text" value="" placeholder="请输入关键字" id="key" class="layui-input search_input">
		    </div>
		    
		    <a class="layui-btn search_btn"  id="search">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal usersAdd_btn" href="Orders.jsp"  >添加订单</a>
		</div>
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux">　本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
		</div>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table" id="tb" lay-filter="show">
		
		</table>
		
	</div>

		<script type="text/html" id="demo">
	 		<a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
	 		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
			<a class="layui-btn layui-btn-xs" lay-event="add">派工</a>
	 	</script>
	</body>
</html>