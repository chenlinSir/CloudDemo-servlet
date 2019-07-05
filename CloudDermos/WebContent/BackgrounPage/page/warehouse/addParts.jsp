<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<title>配件添加</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/font_eolqem241z66flxr.css" media="all" />
	<style>
		.myfile{
			width: 1px;
			height: 1px;
			
		}
	</style>
</head>
<body class="childrenBody">
	<div id ="div1">
	<form action="../../../servlet/AddPartInfoAndFile" method="post" class="layui-form" enctype="multipart/form-data">
		<div class="layui-form-item">
				<label class="layui-form-label">适用车型</label>
				<div class="layui-input-block">
					<input name="q_vehicleBrand" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入适用车型">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件名称</label>
				<div class="layui-input-block">
					<input name="q_partsName" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件名称">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件品牌</label>
				<div class="layui-input-block">
					<input name="q_partBrand" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件品牌">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">所属单位</label>
				<div class="layui-input-block">
					<input name="q_unit" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入所属单位">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件型号</label>
				<div class="layui-input-block">
					<input name="q_partType" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件型号">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件作用</label>
				<div class="layui-input-block">
					<input name="q_partEffect" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件作用">
				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件进价</label>
				<div class="layui-input-block">
					<input name="q_buyingRate" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件进价">				</div>
		</div>
		<div class="layui-form-item">
				<label class="layui-form-label">配件售价</label>
				<div class="layui-input-block">
					<input name="q_sellingPrice" style="width: 400px" type="text" class="layui-input" lay-verify="required" placeholder="请输入配件售价">
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">配件图片</label>
			<div class="layui-input-block">
				<input name="q_partsImg" lay-verify="required" type="file" id="file" class="myfile" accept="image/png, image/jpeg, image/gif, image/jpg"> 
				<label for="file" class='layui-btn layui-btn-lg layui-btn-primary layui-btn-radius'>上传图片</label> 
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addNews">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
		
	</form>
	</div>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="addParts.js"></script>

</body>
</html>