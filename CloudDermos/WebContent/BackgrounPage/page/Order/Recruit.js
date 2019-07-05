layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var usersData = '';
	$.get("../../json/Recruit.json", function(data){
		usersData = data;
		if(window.sessionStorage.getItem("addUser")){
			var addUsers = window.sessionStorage.getItem("addUser");
			usersData = JSON.parse(addUsers).concat(usersData);
		}
		//执行加载数据的方法
		Recruit();
	})

	//查询
	$(".search_btn").click(function(){
		var userArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "../../json/Recruit.json",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addUsers")){
							var addUsers = window.sessionStorage.getItem("addUsers");
							usersData = JSON.parse(addUsers).concat(data);
						}else{
							usersData = data;
						}
						for(var i=0;i<usersData.length;i++){
							var usersStr = usersData[i];
							var selectStr = $(".search_input").val();
		            		function changeStr(data){
		            			var dataStr = '';
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//Id
		            		if(usersStr.Id.indexOf(selectStr) > -1){
			            		usersStr["Id"] = changeStr(usersStr.Id);
		            		}
		            		//客户姓名
		            		if(usersStr.userName.indexOf(selectStr) > -1){
			            		usersStr["userName"] = changeStr(usersStr.userName);
		            		}
		            		//应聘部门
		            		if(usersStr.service_type.indexOf(selectStr) > -1){
			            		usersStr["service_type"] = changeStr(usersStr.service_type);
		            		}
		            		//应聘职位
		            		if(usersStr.service_way.indexOf(selectStr) > -1){
			            		usersStr["service_way"] = changeStr(usersStr.service_way);
		            		}
		            		//邮箱
		            		if(usersStr.pay_type.indexOf(selectStr) > -1){
			            		usersStr["pay_type"] = changeStr(usersStr.pay_type);
		            		}
		            		//手机号码
		            		if(usersStr.order_state.indexOf(selectStr) > -1){
			            		usersStr["order_state"] = changeStr(usersStr.order_state);
		            		}
		            		
		            		if(usersStr.Id.indexOf(selectStr)>-1 ||usersStr.userName.indexOf(selectStr)>-1 || usersStr.service_type.indexOf(selectStr)>-1 || usersStr.service_way.indexOf(selectStr)>-1 || usersStr.pay_type.indexOf(selectStr)>-1|| usersStr.order_state.indexOf(selectStr)>-1){
		            			userArray.push(usersStr);
		            		}
		            		
		            	}
		            	usersData = userArray;
		            	Recruit(usersData);
					}
				})
            	
                layer.close(index);
            },2000);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	//添加会员
	$(".usersAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加会员",
			type : 2,
			content : "Orders.html",
			success : function(layero, index){
				layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})

    //全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

	//操作
	$("body").on("click",".users_edit",function(){  //编辑
		//window.location.href="../../page/jiemiam/UpdateOrders.html";
		var index=layui.layer.open({
			title:'确定',
			type:2,
			content:'UpdateOrders.html',
			area:['750px','400px'],
			shade:[0.8, '#393D49']
			
		});
		
	})

	$("body").on("click",".users_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<usersData.length;i++){
				if(usersData[i].Id == _this.attr("data-id")){
					usersData.splice(i,1);
					Recruit(usersData);
				}
			}
			layer.close(index);
		});
	})

	function Recruit(){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			currData = usersData.concat().splice(curr*nums-nums, nums);
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
			    	+  '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+  '<td>'+currData[i].Id+'</td>'
			    	+  '<td>'+currData[i].userName+'</td>'
			    	+  '<td>'+currData[i].service_type+'</td>'
			    	+  '<td>'+currData[i].service_way+'</td>'
			    	+  '<td>'+currData[i].pay_type+'</td>'
			    	+  '<td>'+currData[i].order_state+'</td>'
			    	+  '<td>'
					+    '<a class="layui-btn layui-btn-mini users_edit"><i class="iconfont icon-edit"></i> 确定</a>'
					+    '<a class="layui-btn layui-btn-danger layui-btn-mini users_del" data-id="'+data[i].Id+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
			        +  '</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 13; //每页出现的数据量
		laypage({
			cont : "page",
			pages : Math.ceil(usersData.length/nums),
			jump : function(obj){
				$(".users_content").html(renderDate(usersData,obj.curr));
				$('.users_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
        
})