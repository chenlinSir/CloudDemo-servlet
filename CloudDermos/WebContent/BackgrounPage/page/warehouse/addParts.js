layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	//创建一个编辑器
	 	form.on("submit(addNews)",function(){
 		//是否添加过信息
//       alert("layui跳转");// 记得手动F5跳转
////       window.self.location.href="../../page/warehouse/querytheWarehouse.jsp";
//		window.self.location.href="../../page/warehouse/querytheWarehouse.jsp";;//不让表单跳转！！
//       return false;     //  
         
  
	 	});
 		
 
 
	
})
