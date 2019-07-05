<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recruit.jsp' starting page</title>
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
		layui.use(['table','layer'],function(){
			//初始化模块
			console.log("1");
			var table=layui.table,$=layui.$,layer=layui.layer;
			//绑定表格数据
			table.render({
				elem:'#tb',
				url:'servlet/RecruitServlet',
				method:'post',
				page:true,
				limit:5,
				limits:[5,10,15],
				cols:[[
					{field:'reId',title:'编号',width:60,align:'left'},
					{field:'post_name',title:'职位名称',width:100,align:'center'},
					{field:'pRemark',title:'职位介绍',width:100,align:'center'},
					{field:'start_time',title:'开始时间',align:'center'},
					{field:'end_time',title:'结束时间',align:'center'},
					{field:'sum',title:'招聘人数',align:'center'},
					{field:'b_name',title:'部门名称',align:'center'},
					{fixed:'right',title:'操作',toolbar:'#demo',align:'center'}
				]]
			});
			
			//添加招聘
			$("#addBtn").click(function(){
				layer.open({
					type:2,
					title:'添加招聘',
					content:'/CloudDermos/BackgrounPage/page/Recruit/add.jsp',
					area:['450px','400px'],
					shade:0.5,
					btn:'关闭',
					resize:false, //不允许拉伸
					zIndex:layer.zIndex
				});
			});
			
			
			//监听表格工具栏
			var jsons;
			table.on('tool(show)',function(obj){
				var data=obj.data;
				var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				  var tr = obj.tr; //获得当前行 tr 的DOM对象
				if(obj.event=='update'){
				//将一个JavaScript值(对象或者数组)转换为一个 JSON字符串
					$.post("servlet/staffinfoServlet?op=upd")
					json=JSON.stringify(data);
					
					layer.open({
						type:2,
						title:'修改招聘信息',
						content:'/CloudDermos/BackgrounPage/page/Recruit/upd.jsp',
						area:['450px','400px'],
						shade:0.5,
						btn:'关闭',
						resize:false,   //不允许拉伸
						zIndex:layer.zIndex
						})
					
				}
				if(obj.event=='delete'){
					layer.confirm("是否删除该数据?",function(){
					console.log("scid"+data.reId);
						$.post("servlet/RecruitServlet",{op:'del',id:data.reId},function(res){
							if(res>0){
								layer.msg("删除成功",{time:2000},function(){
									//刷新表格
									table.reload('tb');
								});
							}else if(res==0){
								layer.msg("没有找到编号为【"+data.b_id+"】的数据",{time:2000});
							}else{
								layer.msg("程序异常,请稍后再试....",{time:2000});
							}
						});
					});
				}
			});
			
		});
	</script>
</head>
<body class="childrenBody">
	<div>
  		<div class="layui-form-item">
  		<blockquote class="layui-elem-quote news_search">
  			<div class="layui-input-inline">
		      <input name="keywords" placeholder="请输入查询条件" autocomplete="off" class="layui-input" />
		    </div>
		    <button class="layui-btn layui-btn-radius" id="search">查询</button>
		    <button class="layui-btn layui-btn-radius layui-btn-warm" id="addBtn">发布招聘</button>
		  </blockquote>
	    	<table id="tb" lay-filter="show"></table>
  		</div>
  	</div>
  	<script type="text/html" id="demo">
  		<a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
  		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
  	</script>
  </body>
</html>
