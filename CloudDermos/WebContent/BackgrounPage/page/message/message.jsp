<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<meta charset="utf-8">
	<title>消息列表--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui2/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="../../css/message.css" media="all" />
	<script type="text/javascript" src="../../layui2/layui/layui.js"></script>
</head>
  	<script type="text/javascript">
  		layui.use(['table'],function(){
  			var table = layui.table,layer=layui.layer,$=layui.$;
  			
  			table.render({
  				elem:'#tb',
  				url:'../../../servlet/MessageServlet?op=searchMessage',
  				method:'post',
  				page:true,
  				limit:3,
  				limits:[3,6,9],
  				cols:[[
  						{field:'msgId',title:'编号',width:60},
  						{field:'userface',title:'图片',width:80,align:'center'},
  						{field:'userName',title:'姓名',width:100,align:'center'},
  						{field:'userAsk',title:'留言内容',width:100,align:'center'},
  						{field:'askTime',title:'留言时间',align:'center'},
  						{field:'email',title:'邮箱',align:'center'},
  						{field:'msgReply',title:'回复内容',align:'center'},
  						{fixed: 'right', title:'操作', toolbar: '#demo', width:180}
  					]]
  			})
  			
  			
  			$("#search").click(function(){
  			var keyword = $("input[name = keyword]").val();
  			table.reload('tb',
	  			{ 
	  				where:{key:keyword}
	  			})
  			})
  			
  			table.on('tool(show)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				  var data = obj.data; //获得当前行数据
				  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				  var tr = obj.tr; //获得当前行 tr 的DOM对象
				 
				    	json = JSON.stringify(data);
				  if(layEvent === 'update'){ //查看
				    	//do somehing
				    	layer.open({
		  					type:2,
		  					title:"与 "+data.userName+" 的聊天",
		  					content:'messageReply.jsp',
		  					area:['550px','500px'],
		  					shade:0.5,
		  					resize:false,
		  					zIndex:layer.zIndex,
		  				})
				  } else if(layEvent === 'delete'){ //删除
				    	layer.confirm('真的删除行么', function(index){
				      	obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				      	layer.close(index);
				     	 //向服务端发送删除指令
				     	 $.post("../../../servlet/MessageServlet",{op:'delMessage',ids:data.msgId},function(res){
				     		 if(res>0){
				     			 layer.msg("删除成功",{time:500},function(){
				     				 table.reload('tb');
				     			 })
				     		 }else if(res==0){
				     			  layer.msg("没有找到编号为【"+data.msgId+"】的数据",{time:500})
				     			   table.reload('tb');
				     		 }else{
				     			  layer.msg("程序异常，请稍后再试......",{time:500})
				     			   table.reload('tb');
				     		 }
				     	 })
				    });
				  }else  if(obj.event === 'detail'){
					      layer.open({
		  					type:2,
		  					title:""+data.userName+"的留言",
		  					content:'messageReply1.jsp',
		  					area:['550px','500px'],
		  					shade:0.5,
		  					resize:false,
		  					zIndex:layer.zIndex,
		  				})
					    }
				});
  		})
  		
  		
  	</script>
<body class="childrenBody">
		<div class="layui-form-item">
  			<div class="layui-input-inline">
  			<input name="keyword" placeholder="请输入查询条件" autocomplete="off" class="layui-input"/>
  		</div>
  		<button id="search" class="layui-btn layui-but-radius" >查询</button>
  		</div>
  		<table id="tb" lay-filter="show">
  		</table>
  		<script type="text/html" id="demo">
			  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  			<a class="layui-btn layui-btn-xs" lay-event="update">回复</a>
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
  		</script>
</body>
</html>