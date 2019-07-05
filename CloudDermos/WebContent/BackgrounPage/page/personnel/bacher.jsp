<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
		layui.use(['table','layer'],function(){
			//初始化模块
			var table=layui.table,$=layui.$,layer=layui.layer;
			
			//绑定表格数据
			table.render({
				elem:'#tb',
				url:'servlet/staffinfoServlet?op=breach',
				method:'post',
				page:true,
				limit:5,
				limits:[5,10,15],
				cols:[[
					{field:'b_id',title:'部门编号'},
					{field:'b_name',title:'部门名称',align:'center'},
					{field:'b_remark',title:'部门备注',align:'center'},
					{fixed:'right',title:'操作',toolbar:'#demo',align:'center'}
				]]
			});
			
			//模糊查询
			$("#search").click(function(){
				var keyword=$("input[name=keywords]").val();
				//重载表格数据
				table.reload('tb',
					{
						where:{key:keyword}
					}
				);
			});
			
			$("#addBtn").click(function(){
				layer.open({
					type:2,
					title:'添加部门',
					content:'BackgrounPage/page/personnel/addbrach.jsp',
					area:['450px','400px'],
					shade:0.5,
					btn:'关闭',
					resize:false,  //不允许拉伸
					zIndex:layer.zIndex
				});
			});
			
			//监听表格工具栏
			
			table.on('tool(show)',function(obj){
			console.log(obj);
				var data=obj.data;
				if(obj.event=='update'){
				//将一个JavaScript值(对象或者数组)转换为一个 JSON字符串
					json=JSON.stringify(data);
					
					layer.open({
						type:2,
						title:'修改部门',
						content:'BackgrounPage/page/personnel/updatebacher.jsp',
						area:['450px','400px'],
						shade:0.5,
						btn:'关闭',
						resize:false,   //不允许拉伸
						zIndex:layer.zIndex
						})
					
				}
				if(obj.event=='delete'){
					layer.confirm("是否删除该数据?",function(){
						$.post("servlet/staffinfoServlet",{op:'deletebrach',id:data.b_id},function(res){
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
  <body>
  	<div>
  		<div class="layui-form-item">
  		<blockquote class="layui-elem-quote news_search">
  			<div class="layui-input-inline">
		      <input name="keywords" placeholder="请输入查询条件" autocomplete="off" class="layui-input" />
		    </div>
		    <button class="layui-btn layui-btn-radius" id="search">查询</button>
		    <button class="layui-btn layui-btn-radius layui-btn-warm" id="addBtn">添加</button>
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
