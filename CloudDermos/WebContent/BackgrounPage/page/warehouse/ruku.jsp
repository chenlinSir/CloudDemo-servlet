<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>

		<meta charset="utf-8">
		<title>入库</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="../../css/font_eolqem241z66flxr.css" media="all" />
	</head>
	<style type="text/css">
		#ss img {
			width: 100%;
			height: 100%;
		}
		
		#ss {
			width: 100px;
			height: 100px;
		}
	</style>
	
	<body class="childrenBody">
		<form class="layui-form" method="post" >
			
			<div class="layui-form-item" style="display:none;">
				<label class="layui-form-label">配件ID</label>
				<div class="layui-input-block">
					<input name="q_id" value="<c:out value="${q_id}" ></c:out>" lay-verify="required" type="text" class="layui-input" style="width: 400px;height: 38px;">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入库标题</label>
				<div class="layui-input-block">
					<input lay-verify="required" type="text" class="layui-input" style="width: 400px;height: 38px;" name="i_title" placeholder="入库标题">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入库时间</label>
				<div class="layui-input-block">
					<input  readonly type="text" class="layui-input" name="i_time" style="width: 400px;height: 38px;" lay-verify="required" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
				</div>
			</div>

			<div class="layui-inline">
			    <label class="layui-form-label">入库人员</label>
				<div class="layui-input-block">
					<select class="staName2" lay-filter="staName2" name="i_personnel"  id="staName2">
				   </select>
				</div>
			</div>
			


			<div class="layui-form-item">
				<label class="layui-form-label" >入库数量</label>
				<div class="layui-input-block">
					<input id="pnumber"  name="i_number" type="text" class="layui-input" style="width: 400px;height: 38px;" lay-verify="required" placeholder="入库数量">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">配件进价</label>
				<div class="layui-input-block">
		
					<input  value=${q_buyingRate}  readonly id="buyingRate" type="text" class="layui-input " style="width: 400px;height: 38px;" placeholder="支出表？这个怎么做">
						<!--  <c:out value="${q_sellingPrice}" ></c:out> -->
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">进价总金额</label>
				<div class="layui-input-block">
						<!--  <%=session.getAttribute("partId").toString()%> -->
					<input name="i_totalPrice" readonly id="Allprice" type="text" class="layui-input " style="width: 400px;height: 38px;" placeholder="进价金额">
						<!--  <c:out value="${q_sellingPrice}" ></c:out> -->
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					
    				<button class="layui-btn" 	lay-submit  lay-filter="rukuTJ">提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
		<!--
    	这是接下来是显示的信息
    -->
		<div class="layui-form news_list">
			<table class="layui-table layui-elip">
				<colgroup>
					<col width="50px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="100px">
					<col width="50px">
					<col width="200px">
				</colgroup>
				<thead>
					<tr>
						<th>ID</th>
						<th>名称</th>
						<th>适用车型</th>
						<th>品牌</th>
						<th>数量</th>
						<th>单位</th>
						<th>型号</th>
						<th>作用</th>
						<th>进价</th>
						<th>售价</th>
						<th>图片</th>
					</tr>
				</thead>
				<thead>
					<tr>
						<td><c:out value="${q_id}" ></c:out></td>
						<td><c:out value="${q_partsName}" ></c:out></td>
						<td><c:out value="${q_vehicleBrand}" ></c:out></td>
						<td><c:out value="${q_partBrand}" ></c:out></td>
						<td><c:out value="${q_number}" ></c:out></td>
						<td><c:out value="${q_unit}" ></c:out></td>
						<td><c:out value="${q_partType}" ></c:out></td>
						<td><c:out value="${q_partEffect}" ></c:out></td>
						<th><c:out value="${q_buyingRate}" ></c:out></th>
						<th><c:out value="${q_sellingPrice}" ></c:out></th>
						<td>
							<div id="ss">
								<img src="img/${q_partsImg}" />
							</div>
						</td>

					</tr>
				</thead>
				<tbody class="users_content"></tbody>
			</table>
		</div>
	<script type="text/javascript" src="../../layui/layui.js"></script>
		<script src="ruku.js" type="text/javascript" charset="utf-8"></script>
		<script>
				
		</script>
		
	</body>
	
</html>