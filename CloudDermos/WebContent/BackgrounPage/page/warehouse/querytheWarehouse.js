layui.config({
	base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage'], function() {
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	var strimg; //图片的地址
	//加载页面数据
	var id;
	$.get("../../../servlet/QuerytheWarehouseServlet?op=searchPart", function(data) {
		var data = eval('(' + data + ')');
		usersData = data;
		if(window.sessionStorage.getItem("incomingPartsInfo")) {
			var addUsers = window.sessionStorage.getItem("incomingPartsInfo");
			usersData = JSON.parse(addUsers).concat(usersData);
		}
		//执行加载数据的方法
		querytheWarehouseList();
	});

	//新查询
	$(".search_btn").click(function() {
		if($(".search_input").val() != '') {
			var index = layer.msg('查询中，请稍候', {
				icon: 16,
				time: false,
				shade: 0.8
			});
			setTimeout(function() {
				$.post("../../../servlet/QuerytheWarehouseServlet?op=byPartName", {
					byPartName: $(".search_input").val()
				}, function(resJson) {
					if(resJson != null) {
						var data = eval('(' + resJson + ')');
						usersData = data;
						if(window.sessionStorage.getItem("incomingPartsInfo")) {
							var addUsers = window.sessionStorage.getItem("incomingPartsInfo");
							usersData = JSON.parse(addUsers).concat(usersData);
						}
						//执行加载数据的方法
						querytheWarehouseList();
						$(".search_input").val("");

					}
				});

				layer.close(index);
			}, 2000);
		} else {
			$.get("../../../servlet/QuerytheWarehouseServlet?op=searchPart", function(data) {
				var data = eval('(' + data + ')');
				usersData = data;
				if(window.sessionStorage.getItem("incomingPartsInfo")) {
					var addUsers = window.sessionStorage.getItem("incomingPartsInfo");
					usersData = JSON.parse(addUsers).concat(usersData);
				}
				//执行加载数据的方法
				querytheWarehouseList();
			});
		}
	});

	//配件添加
	$(".addParts").click(function() {
		location.href = "addParts.jsp";

	})

	//查看图片
	$("body").on("click", ".chakan_edit", function() {
		var _this = $(this).attr("id");
		$.post("../../../servlet/WarehouseServlet?op=ruku",
			{partId: _this },
			function(res){//须要servlet 传过来值
					if(res>0){	
						
					layer.open({
						  type: 2,
						  title:"详细",
						  shadeClose: true,
						  shade: 0.8,
						  area: ['932px','250px'],
						  content: 'page/warehouse/partsInfo.jsp' 
						}); 
					//window.location.href="partsInfo.jsp"; //跳转到JS
					}
				
				});
		
	})
	//配件出库
	$("body").on("click", ".chuku_edit", function() {
		var _this = $(this).attr("id");
		$.post("../../../servlet/WarehouseServlet?op=chuku",
			{partId: _this },
			function(res){//须要servlet 传过来值
					if(res>0){	
					window.location.href="chuku.jsp"; //跳转到JS
					}
				
				});
	});
	
	//配件入库 已完成 勿动
	$("body").on("click", ".ruku_edit", function() {
		var _this = $(this).attr("id");
		
		$.post("../../../servlet/WarehouseServlet?op=ruku",
			{	partId: _this },
			function(res){
					if(res>0){	
						window.location.href="ruku.jsp"; //跳转到入库页面
					}	
				
				
				});
		
          
	});

	//配件删除
	$("body").on("click", ".part_del", function() {
		var _this = $(this).attr("id");
		$.post("../../../servlet/QuerytheWarehouseServlet?op=delectById", {
			byPartId: _this
		}, function(res) {
			if(res > 0) {
				layer.msg("删除成功");
				$.get("../../../servlet/QuerytheWarehouseServlet?op=searchPart", function(data) {
					var data = eval('(' + data + ')');
					usersData = data;
					if(window.sessionStorage.getItem("incomingPartsInfo")) {
						var addUsers = window.sessionStorage.getItem("incomingPartsInfo");
						usersData = JSON.parse(addUsers).concat(usersData);
					}
					//执行加载数据的方法
					querytheWarehouseList();
				});
			} else {
				layer.msg("删除失败");
			}
			//执行加载数据的方法

		});

	})

	function querytheWarehouseList() {
		//渲染数据
		function renderDate(data, curr) {
			var dataHtml = '';
			currData = usersData.concat().splice(curr * nums - nums, nums);
			if(currData.length != 0) {

				for(var i = 0; i < currData.length; i++) {
					strimg = currData[i].q_partsImg; //img地址
					var id = currData[i].q_id;
					var number =currData[i].q_number;
					var isnumber='<a  class="layui-btn layui-btn-mini chuku_edit" id=' + currData[i].q_id + '>出库</a>';
					if(number==0){
						number="<a class=' ruku_edit' id="+ currData[i].q_id +" >待采购</a>";
						isnumber="";	
					}
					
					dataHtml += '<tr>' +
						'<td>' + currData[i].q_id + '</td>' +
						'<td>' + currData[i].q_partsName + '</td>' +
						'<td>' + currData[i].q_vehicleBrand + '</td>' +
						'<td>' + currData[i].q_partBrand + '</td>' +
						'<td>' + number+ '</td>' +
						'<td>' +
						'<a class="layui-btn layui-btn-normal layui-btn-mini chakan_edit" id=' + currData[i].q_id +'>查看</a>' +
						isnumber +
						'<a class="layui-btn layui-btn-mini ruku_edit" id=' + currData[i].q_id + '>入库</a>' +
						'<a class="layui-btn layui-btn-danger layui-btn-mini part_del" id=' + currData[i].q_id + '>删除</a>' +
						'</td>' +
						'</tr>';
						
					
				}
			} else {
				dataHtml = '<tr><td colspan="8" >暂无数据</td></tr>';
			}
			return dataHtml;
		}

		//分页
		var nums = 5; //每页出现的数据量
		laypage({
			cont: "page",
			pages: Math.ceil(usersData.length / nums),
			jump: function(obj) {
				$(".users_content").html(renderDate(usersData, obj.curr));
				$('.users_list thead input[type="checkbox"]').prop("checked", false);
				form.render();
			}
		})
	}

})