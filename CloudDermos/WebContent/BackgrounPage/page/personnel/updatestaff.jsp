<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="BackgrounPage/page/personnel/layui/css/layui.css" media="all" / > 
	<script type="text/javascript" src="BackgrounPage/page/personnel/layui/layui.js"></script>
  </head>
  <script type="text/javascript">
  		layui.use(['form','layer'],function(){
  			var form = layui.form,$=layui.$,layer=layui.layer;
  			
  			     //从父层获取值，json是父层的全局js变量。eval是将该string类型的json串变为标准的json串
		        var j = eval('('+parent.json+')');
		         $("#id").val(j.sta_id); 
		       	 $("#S_name").val(j.sta_name);
		       	 $("#S_sex").val(j.sta_sex);
		         $("#S_birthday").val(j.sta_birthday);
		         $("#S_phone").val(j.sta_phone); 
		       	 $("#S_login").val(j.sta_login);
		       	 $("#S_pwd").val(j.sta_pwd);
		         $("#S_entrytime").val(j.sta_entrytime);
		       	 $("#S_present").val(j.sta_present);
		       	 $("#S_natio").val(j.S_natio);
		         $("#S_place").val(j.S_place);
		         $("#S_blood").val(j.S_blood); 
		       	 $("#S_idcate").val(j.S_idcate);
		       	 $("#S_marital").val(j.S_marital);
		         $("#S_politics").val(j.S_politics);
		         $("#S_maxeducation").val(j.S_maxeducation); 
		       	 $("#S_maxdegree").val(j.S_maxdegree);
		       	 $("#S_Email").val(j.S_Email);
		         $("#S_emIP").val(j.S_emIP);
		         $("#seng").val(j.S_Englist);
		         $("#S_computer").val(j.S_computer);
  			 $.post("servlet/staffinfoServlet?op=saddpost",function(res){
				$(res).each(function(i,q){
					var $option = $("<option value='"+q.b_id+"'>"+q.b_name+"</option>");
					if(j.post.bh.b_id==q.b_id){
						var $option = $("<option selected='selected' value='"+q.b_id+"'>"+q.b_name+"</option>");
					}
					$option.appendTo($("#staff"));
				});
				form.render();
			},"json");
  			$.post("servlet/staffinfoServlet?op=postss",function(res){
				$(res).each(function(i,q){
					var $option = $("<option value='"+q.post_id+"'>"+q.post_name+"</option>");
					if(j.post.post_id==q.post_id){
						var $option = $("<option selected='selected' value='"+q.post_id+"'>"+q.post_name+"</option>");
					}
					$option.appendTo($("#post"));
				});
				form.render();
			},"json");
  			
  			//下拉框监听事件
			  form.on('select(test1)', function(data){
				    $.ajax({
				        url:'servlet/staffinfoServlet?op=tianjia&cityId='+data.value,
				        dataType:'json',
				        async: true,
				        success:function(data){
				            $("#post").html("<option value=''>请选择职位</option>");
				            $.each(data,function(index,item){
				                $('#post').append(new Option(item.post_name,item.post_id));//往下拉菜单里添加元素
				                form.render('select'); 
				            })
				        }
				   }); 
				  
				});  
		     
		         
		         
		        form.on('submit(update)',function(){
  				var formData =  $("form").serialize();
  				$.post("servlet/staffinfoServlet?op=updateStaff",formData,function(res){
  					if(res>0){
  						layer.msg("修改成功",{time:500},function(){
  							parent.layui.table.reload('tb');
  							var index = window.parent.layer.getFrameIndex(window.name);
  							window.parent.layer.close(index);
  						})
  					}else{
  						layer.msg("修改失败");
  					}
  				})
  				return false;
  			})
  			
  		})
  		
  </script>
  <body>
 
    <form  class="layui-form">
    	<input id="id" name="id" type="hidden"/>
		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">员工名称：</label>
  			<div class="layui-input-inline">
  				<input name="S_name" id="S_name" class="layui-input" placeholder="请输入员工名称" style="width: 300" autocomplete="off" lay-verify="required"/>
  				
  			</div>
  		</div>
  		<div class="layui-form-item">
		    <label class="layui-form-label" >性别：</label>
		    <div class="layui-input-block">
		    	<input type="text" class="layui-input" style="width: 300; height: 40px" name="S_sex" id="S_sex"/>
		    </div>
  		<div class="layui-form-item" style="margin-top: 20px">
  			<label class="layui-form-label">出生年月：</label>
  			<div class="layui-inline"> 
			  <input  name="S_birthday" id="S_birthday"  type="text" class="layui-input" id="test1" placeholder="请输入出生年月"  lay-verify="required" style="width:300px">
			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">联系电话：</label>
  			<div class="layui-input-inline">
  				<input name="S_phone" id="S_phone" class="layui-input" placeholder="请输入联系电话" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">登录名：</label>
  			<div class="layui-input-inline">
  				<input name="S_login" id="S_login" class="layui-input" placeholder="请输入登录名" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">登录密码：</label>
  			<div class="layui-input-inline">
  				<input name="S_pwd" type="password" id="S_pwd" class="layui-input" placeholder="请输入登录密码" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">入职时间：</label>
  			<div class="layui-input-inline">
  				<input name="S_entrytime" id="S_entrytime" type="text" class="layui-input" id="test3" placeholder="请输入入职时间">
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20px; width:410px;" >
  			<label class="layui-form-label">部门选择：</label>
		    <div class="layui-input-block">
		      <select id="staff" name="staff" lay-filter="test1" >
     				<option  id="a"  value="0">请选择职位</option>
     			</select>
		    </div>
		   
  		</div>
  		<div class="layui-form-item" style="margin-top: 20px; width:410px;">
  			 <label class="layui-form-label">职位选择：</label>
		    <div class="layui-input-block">
                    <select id="post" name="post">
     				<option  id="b"  value="0">请选择职位</option>
     			</select>
                </div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">家庭地址：</label>
  			<div class="layui-input-inline">
  				<input name="S_present" id="S_present" class="layui-input" placeholder="请输入家庭地址" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
 
 		
 		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">员工民族：</label>
  			<div class="layui-input-inline">
  				<input name="S_natio" id="S_natio" class="layui-input" placeholder="请输入员工民族" style="width: 300" autocomplete="off"  />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">员工籍贯：</label>
  			<div class="layui-input-inline">
  				<input name="S_place" id="S_place" class="layui-input" placeholder="请输入员工籍贯" style="width: 300" autocomplete="off"  />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">员工血型：</label>
  			<div class="layui-input-inline">
  				<input name="S_blood" id="S_blood" class="layui-input" placeholder="请输入员工血型" style="width: 300" autocomplete="off"  />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">身份证号：</label>
  			<div class="layui-input-inline">
  				<input name="S_idcate" id="S_idcate" class="layui-input" placeholder="请输入身份证号" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">婚姻状况：</label>
  			<div class="layui-input-inline">
  				<input name="S_marital" id="S_marital"  class="layui-input" placeholder="请输入婚姻状况" style="width: 300" autocomplete="off"  />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">政治面貌：</label>
  			<div class="layui-input-inline">
  				<input name="S_politics" id="S_politics"   class="layui-input" placeholder="请输入政治面貌" style="width: 300" autocomplete="off"  />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">最高学历：</label>
  			<div class="layui-input-inline">
  				<input name="S_maxeducation" id="S_maxeducation" class="layui-input" placeholder="请输入最高学历" style="width: 300" autocomplete="off" />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">最高学位：</label>
  			<div class="layui-input-inline">
  				<input name="S_maxdegree" id="S_maxdegree" class="layui-input" placeholder="请输入最高学位" style="width: 300" autocomplete="off" />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">email：</label>
  			<div class="layui-input-inline">
  				<input name="S_Email" id="S_Email" class="layui-input" placeholder="请输入邮箱" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
 		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">紧急电话：</label>
  			<div class="layui-input-inline">
  				<input name="S_emIP" id="S_emIP" class="layui-input" placeholder="请输入紧急电话" style="width: 300" autocomplete="off" lay-verify="required"/>
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">外语等级：</label>
  			<div class="layui-input-inline">
  				<input name="S_Englist" id="seng" class="layui-input" placeholder="请输入外语等级" style="width: 300" autocomplete="off" />
  			</div>
  		</div>
  		<div class="layui-form-item"style="margin-top: 20">
  			<label class="layui-form-label">计算机等级：</label>
  			<div class="layui-input-inline">
  				<input name="S_computer" id="S_computer" class="layui-input" placeholder="请输入计算机等级" style="width: 300" autocomplete="off" />
  			</div>
  		</div>
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="update">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
	</form>
  </body>
</html>
