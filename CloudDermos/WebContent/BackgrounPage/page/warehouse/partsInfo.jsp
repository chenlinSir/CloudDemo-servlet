<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!--配件表incomingPartsInfo -->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>配件信息表</title>

	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<style type="text/css">
		#ss img{
			width: 100%;
			height: 100%;
		}
		#ss{
			width: 100px;
			height: 100px;
		}
	</style>
</head>
<body class="childrenBody">
	
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

    </body>
   
</html>