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
    
    <title>My JSP 'Staffinfoss.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
			tr td{
				width: 80px;
				height: 30px;
				text-align: center;
			}
		</style>
	<link rel="stylesheet" type="text/css" href="BackgrounPage/page/personnel/layui/css/layui.css">
  	<script type="text/javascript" src="BackgrounPage/page/personnel/layui/layui.js"></script>
  </head>
 	<body>
		<form action="" >
			<table 	cellpadding="0" cellspacing="0" width="600px" border="1px">
				
				<tr>
					<th>姓名</th>
					<td   id="name">${Stas.sta_name}</td>
					<th>性别</th>
					<td id="sex">${Stas.sta_sex} </td>
					<td colspan="2" rowspan="5" id="sex"><img style="width: 135px;height: 150px" src="BackgrounPage/images/face.jpg"/></td>
				</tr>
				<tr>
					<th>出生年月</th>
					<td  id="S_birthday">${Stas.sta_birthday} </td>
					<th>民族</th>
					<td id="S_natio">${Stas.s_natio}</td>
					
				</tr>
				<tr>
					<th>籍贯</th>
					<td id="S_place">${Stas.s_place} </td>
					<th>血型</th>
					<td  id="S_blood">${Stas.s_blood} </td>
				</tr>
				<tr>
					<th>身份证号</th>
					<td colspan="3" id="S_idcate">${Stas.s_idcate}</td>
				</tr>
				<tr>
					<th>联系电话</th>
					<td colspan="3" id="S_phone">${Stas.sta_phone}</td>
					
				</tr>
				<tr>
					<th>婚姻状况</th>
					<td colspan="2" id="S_marital">${Stas.s_marital} </td>
					<th>政治面貌</th>
					<td colspan="2" id="S_politics">${Stas.s_politics} </td>
					
				</tr>
				<tr>
					<th>最高学历</th>
					<td colspan="5" id="S_maxeducation">${Stas.s_maxeducation} </td>
				</tr>
				<tr>
					<th>最高学位</th>
					<td colspan="5" id="S_maxdegree">${Stas.s_maxdegree} </td>
				</tr>
				<tr>
					<th>居住地址</th>
					<td colspan="5" id="sta_present">${Stas.sta_present}</td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td colspan="5" id="S_Email">${Stas.s_Email}</td>
				</tr>
				<tr>
					<th>紧急联系人</th>
					<td colspan="5" id="S_emIP">${Stas.s_emIP}</td>
				</tr>
				<tr>
					<th>外语等级</th>
					<td colspan="2" id="S_Englist">${Stas.s_Englist}</td>
					<th>计算机等级</th>
					<td colspan="2" id="S_computer">${Stas.s_computer}</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>
