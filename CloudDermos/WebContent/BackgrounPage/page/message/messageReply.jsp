<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<meta charset="utf-8">
	<title>消息回复</title>
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
  		layui.use(['form','table','layer'],function(){
  			var form = layui.form,$=layui.$,layer=layui.layer;
  			var table = layui.table,layer=layui.layer,$=layui.$;
  			 //从父层获取值，json是父层的全局js变量。eval是将该string类型的json串变为标准的json串
		        var j = eval('('+parent.json+')');
  			 
  			  	table.render({
  			  		initSort: {
					    field: 'userId' //排序字段，对应 cols 设定的各字段名
					    ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
					  },
	  				elem:'#tb',
	  				url:'../../../servlet/MessageServlet?op=searchUserMessage&msgId='+j.msgId,
	  				method:'post',
	  				cols:[[
	  						{field:'userId',title:'编号',width:80,align:'center'},
	  						{field:'userName',title:'姓名',width:80,align:'center'},
	  						{field:'askTime',title:'留言时间',align:'center'},
	  						{field:'userAsk',title:'回复内容',align:'center'},
	  						{fixed: 'right', title:'操作',align:'center', toolbar: '#demo', width:150}
	  					]]
  			})
  			
  			
  			
  			
  			
		         $("#userName").text(j.userName);
		        $("#userAsk").text(j.userAsk);
		        $("#askTime").text(j.askTime);
		        form.on('submit(send)',function(obj){
  				var formData =  $("form").serialize();
		        	if(formData=="userAsk="){
		        		layer.msg("消息框不能为空！");
		        		return false;
		        	}
  				$.post("../../../servlet/MessageServlet?op=sendMessage&msgId="+j.msgId,formData,function(res){
  					if(res>0){
  						layer.msg("发送成功",{time:500},function(){
  							parent.layui.table.reload('tb');
  							var index = window.parent.layer.getFrameIndex(window.name);
  							window.parent.layer.close(index)
  						})
  					}else{
  						layer.msg("发送失败");
  					}
  				})
  				return false;
  			})
  			
  			  table.on('tool(show)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				  var data = obj.data; //获得当前行数据
				  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				  var tr = obj.tr; //获得当前行 tr 的DOM对象
				   if(layEvent === 'delete'){ //删除
				    	layer.confirm('真的删除行么', function(index){
				      	obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				      	layer.close(index);
				     	 //向服务端发送删除指令
				     	 $.post("../../../servlet/MessageServlet",{op:'delUserMessage',ids:data.userId,ids1:data.msgId},function(res){
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
				  } 
				});
  			
  		})
  </script>
<body class="childrenBody">
	<form class="layui-form">
		<div class="replay_edit">
			<textarea class="layui-textarea" id="msgReply" name="userAsk"></textarea>
			<a class="layui-btn send_msg" lay-filter="send" lay-submit>发送</a>
		</div>
	</form>
			<table id="tb" lay-filter="show">
  			</table>
  			<script type="text/html" id="demo">
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
  		</script>
</body>

</html>