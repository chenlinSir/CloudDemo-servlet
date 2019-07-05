<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>My JSP 'Adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="../../css/layui.css" />
	<script type="text/javascript" src="../../js/layui.js" ></script>
	<script type="text/javascript" src="../../js/jquery-1.4.1.js"></script>
	<style type="text/css">
		#btnnnn{
			padding-left: 200px;
		}
		#top{
			padding-top: 50px;
		}
		.layui-form-item{
			padding-left: 60px;
		}
	</style>
	<script type="text/javascript">
		layui.use(['form','layer'],function(){
			//获取父级页面数据
			var j = eval('('+parent.json+')');
			var form=layui.form,$=layui.$,layer=layui.layer;
			//获取服务类型数据
			$.post("../../../servlet/BigServiceServlet?op=selectBig",function(res){
				$(res).each(function(i,q){
					var $option = $("<option value='"+q.lst_id+"'>"+q.lst_name+"</option>");
					if(j.bse.lst_id==q.lst_id){
						var $option = $("<option selected='selected' value='"+q.lst_id+"'>"+q.lst_name+"</option>");
					}
					$option.appendTo($("#serviceType"));
				});
				form.render();
			},"json");
			$("#bigId").val(j.sst_id);
			$("#serivce").val(j.sst_name);
			$("#serviceType").val(j.bse.lst_name);
			$("#a").val(j.sst_name);
			$("#price").val(j.sst_price);
			$("#remark").val(j.sst_remarks);
				//监听表单提交
				form.on('submit(upd)',function(){
					var FormDa=$("form").serialize();
					$.post("../../../servlet/SmallServiceServlet?op=updateSmall&bigId="+$("#bigId").val(),FormDa,function(res){
						if(res>0){
							layer.msg("修改成功",{time:500},function(){
								//重新加载父页面
								window.parent.location.reload();
								//关闭当前层
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
							});
						}else{
							layer.msg("修改失败");
						}	
			        });
			        return false;
				});
				$("#quxiao").click(function(){
					var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
				});
		});
	
	</script>
  </head>
  
  <body>
  	<form class="layui-form" action="">
  		<input id="bigId" type="hidden" name="bigId" required  lay-verify="required" placeholder="请输入id" autocomplete="off" class="layui-input">
  		<div class="layui-form-item" id="top">
   			<label class="layui-form-label">服务名称:</label>
        	<div class="layui-input-inline">
     			<input id="serivce" name="serivce" required  lay-verify="required" placeholder="请输入服务名称" autocomplete="off" class="layui-input">
	    	</div>
	    </div>
  		<div class="layui-form-item">
   			<label class="layui-form-label">服务类型:</label>
        	<div class="layui-input-inline">
     			<select id="serviceType" name="serviceType">
     				<option  id="a"  value="0">请选择服务类型</option>
     			</select>
	    	</div>
	    </div>
	    <div class="layui-form-item">
   			<label class="layui-form-label">工时费:</label>
        	<div class="layui-input-inline">
     			<input id="price" name="price" required  lay-verify="required" placeholder="请输入工时费" autocomplete="off" class="layui-input">
	    	</div>
	    </div>
	    <div class="layui-form-item">
   			<label class="layui-form-label">备注:</label>
        	<div class="layui-input-inline">
     			<input id="remark" name="remark" required  lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
	    	</div>
	    </div>
	    <div class="layui-form-item">
	    	<div class="layui-input-inline" id="btnnnn">
	    		<button class="layui-btn" lay-submit lay-filter="upd">修改</button>
  				<a class="layui-btn" id="quxiao">取消</a>
  			</div>
  		</div>
  	</form>
  </body>
</html>

