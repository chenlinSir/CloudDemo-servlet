layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laydate = layui.laydate,
	$ = layui.jquery;
	//窗口加载完毕
	$(function(){
		alert("窗口加载完毕");
		//加载员工数据到option
		$.post("../../../servlet/WarehouseServlet?op=selectStname",function(res){
					$(res).each(function(i,q){
						var $option = $("<option value='"+q.sta_name+"'>"+q.sta_name+"</option>");
						$option.appendTo($("#staName2"));
					});
				form.render();
			},"json");
	});
   //输入框的值改变时触发
	  $("#pnumber").change("input",function(e){
    //获取input输入的值
		var Allprice=  $("#pnumber").val()*$("#buyingRate").val();
		 $("#Allprice").val(Allprice); 
	 //	alert("我的值被改变");
  	});	
	
			form.on('submit(rukuTJ)',function(){
				var formData=$("form").serialize();
				$.post("../../../servlet/WarehouseServlet?op=partRuku",formData,function(res){
					if(res>0){
						layer.msg("入库成功",{time:2000},function(){
							//跳转
							window.location.href="page/warehouse/querytheWarehouse.jsp";
							return false;
						});
					}else{
						layer.msg("入库失败");
					}
				});
				return false;
			});
});
