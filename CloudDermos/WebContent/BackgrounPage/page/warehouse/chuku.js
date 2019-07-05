layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laydate = layui.laydate,
	$ = layui.jquery;
   //输入框的值改变时触发
	  $("#pnumber").change("input",function(e){
    //获取input输入的值
		var Allprice=  $("#pnumber").val()*$("#buyingRate").val();
		 $("#Allprice").val(Allprice); 
	 //	alert("我的值被改变");
  	});	
			form.on('submit(chukuTJ)',function(){
				var formData=$("form").serialize();
				$.post("../../../servlet/WarehouseServlet?op=partRchuku",formData,function(res){
					if(res>0){
						layer.msg("出库成功",{time:2000},function(){
							//重新加载表格
							
							window.location.href="page/warehouse/querytheWarehouse.jsp";
							return false;
						});
					}else{
						layer.msg("出库失败,库存不足");
					}
				});
				return false;
			});
});
