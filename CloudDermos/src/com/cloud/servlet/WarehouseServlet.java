package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cloud.dao.OrdersDao;
import com.cloud.dao.WarehouseDao;
import com.cloud.entity.QuerytheWarehouseEntity;
import com.cloud.entity.Sta_staffinfo;
import com.google.gson.Gson;

public class WarehouseServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		WarehouseDao dao = new WarehouseDao();
		List<QuerytheWarehouseEntity> list =null; //配件基本信息的结果集
		Gson gs = new Gson();
		if(op.equals("ruku")){
			int partId = Integer.parseInt(request.getParameter("partId"));
			request.getSession().setAttribute("partId", partId); //给会话设置由入库传来ID值
			list = dao.selectQuerytheWarehouseById(partId);
			if(list!=null){
				for(QuerytheWarehouseEntity QWE:list){
					request.getSession().setAttribute("q_id", QWE.getQ_id());//设置ID
					request.getSession().setAttribute("q_vehicleBrand", QWE.getQ_vehicleBrand());//适用车型
					request.getSession().setAttribute("q_partsImg", QWE.getQ_partsImg());//配件图片
					request.getSession().setAttribute("q_partsName", QWE.getQ_partsName());//配件名称
					request.getSession().setAttribute("q_partBrand", QWE.getQ_partBrand());//配件品牌
					request.getSession().setAttribute("q_number", QWE.getQ_number());//配件数量
					request.getSession().setAttribute("q_unit", QWE.getQ_unit());//单位
					request.getSession().setAttribute("q_partType", QWE.getQ_partType());//配件类型
					request.getSession().setAttribute("q_partEffect", QWE.getQ_partEffect());//配件作用
					request.getSession().setAttribute("q_buyingRate", QWE.getQ_buyingRate());//配件进价
					request.getSession().setAttribute("q_sellingPrice", QWE.getQ_sellingPrice());//配件售价
				}
				response.getWriter().print(gs.toJson(partId)); // 为什么传过去的是一个对象？？
			}else{
				System.out.println("没有通过ID找到");
			}
		//	request.getRequestDispatcher("BackgrounPage/page/warehouse/ruku.jsp").forward(request, response); 
			
		}else if(op.equals("partRuku")){
			int q_id = Integer.parseInt(request.getParameter("q_id"));//配件ID
			String i_title = request.getParameter("i_title");//入库标题
			String i_time = request.getParameter("i_time");//入库时间
			String i_personnel = request.getParameter("i_personnel");//入库人员
			int i_number = Integer.parseInt(request.getParameter("i_number"));//入库数量
			double i_totalPrice = Double.parseDouble(request.getParameter("i_totalPrice"));//配件进价总金额
			System.out.println(op);
			System.out.println(i_title);
			System.out.println(i_time);
			System.out.println(i_personnel);
			System.out.println(i_number);
			System.out.println(i_totalPrice);
			//获取incomingParts最大ID值
			int incomingPartsID = dao.incomingPartsIdDESC(); 
			//获取incomingPartsInfo最大ID值
			int incomingPartsInfoId = dao.incomingPartsInfoIdDESC();
			boolean bool = false; //默认提交失败
			try {
				 bool = dao.BeOutInStorage(q_id, i_title, i_time, i_personnel, i_number, i_totalPrice, incomingPartsID, incomingPartsInfoId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bool){
				System.out.println("提交成功");
				response.getWriter().print(1); // 传值到前台
			}else{
				System.out.println("提交失败");
				response.getWriter().print(-1); // 传值到前台
			}
			System.out.println("配件ID"+q_id+"\t"+"incomingPartsID:"+incomingPartsID+"\t"+"incomingPartsInfoId:"+incomingPartsInfoId);
			

		}else if(op.equals("chuku")){
			int partId = Integer.parseInt(request.getParameter("partId"));
			request.getSession().setAttribute("partId", partId); //给会话设置由入库传来ID值
			list = dao.selectQuerytheWarehouseById(partId);
			if(list!=null){
				for(QuerytheWarehouseEntity QWE:list){
					request.getSession().setAttribute("q_id", QWE.getQ_id());//设置ID
					request.getSession().setAttribute("q_vehicleBrand", QWE.getQ_vehicleBrand());//适用车型
					request.getSession().setAttribute("q_partsImg", QWE.getQ_partsImg());//配件图片
					request.getSession().setAttribute("q_partsName", QWE.getQ_partsName());//配件名称
					request.getSession().setAttribute("q_partBrand", QWE.getQ_partBrand());//配件品牌
					request.getSession().setAttribute("q_number", QWE.getQ_number());//配件数量
					request.getSession().setAttribute("q_unit", QWE.getQ_unit());//单位
					request.getSession().setAttribute("q_partType", QWE.getQ_partType());//配件类型
					request.getSession().setAttribute("q_partEffect", QWE.getQ_partEffect());//配件作用
					request.getSession().setAttribute("q_buyingRate", QWE.getQ_buyingRate());//配件进价
					request.getSession().setAttribute("q_sellingPrice", QWE.getQ_sellingPrice());//配件售价
				}
				response.getWriter().print(gs.toJson(partId)); // 为什么传过去的是一个对象？？
			}else{
				System.out.println("没有通过ID找到");
			}
			System.out.println("进入出库操作");

		}else if(op.equals("partRchuku")){
			System.out.println("出库表单提交");
			int q_id = Integer.parseInt(request.getParameter("q_id"));//配件ID
			String o_title = request.getParameter("o_title");//出库标题
			String o_time = request.getParameter("o_time");//出库时间
			String o_cause = request.getParameter("o_cause");//出库原因
			String o_personnel = request.getParameter("o_personnel");//出库人员
			String o_manager = request.getParameter("o_manager");//管理人员
			int o_number = Integer.parseInt(request.getParameter("o_number"));//出库数量
			double o_totalPrice = Double.parseDouble(request.getParameter("o_totalPrice"));//售价总金额
			//得到主键ID
			int outboundPartsMaxId = dao.outboundPartsMaxId();
			int outboundPartsInfoMaxId = dao.outboundPartsInfoMaxId();
			System.out.println("outboundPartsMaxId:"+outboundPartsMaxId);
			System.out.println("outboundPartsInfoMaxId:"+outboundPartsInfoMaxId);
			System.out.println("配件ID："+q_id);
			System.out.println("出库标题"+o_title);
			System.out.println("出库原因："+o_cause);
			System.out.println("出库人员："+o_personnel);
			System.out.println("管理人员："+o_manager);
			System.out.println("出库数量："+o_number);
			System.out.println("售价总金额："+o_totalPrice);
			// 查看坤库存是否足够
			int partNumber = dao.partNumber(q_id);
			if(partNumber>=o_number){
				try {
					boolean out = dao.putOutStorage(q_id, o_title, o_time, o_cause, o_personnel, o_manager, o_number, o_totalPrice, outboundPartsMaxId, outboundPartsInfoMaxId);
					if(out){
						response.getWriter().print(1);
						System.out.println("添加成功");
					}else{
						System.out.println("添加失败");
						response.getWriter().print(0);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				response.getWriter().print(0);
			}
		}else if(op.equals("chakan")){
			int partId = Integer.parseInt(request.getParameter("partId"));
			request.getSession().setAttribute("partId", partId); //给会话设置由入库传来ID值
			list = dao.selectQuerytheWarehouseById(partId);
			response.getWriter().print(gs.toJson(partId));
			if(list!=null){
				for(QuerytheWarehouseEntity QWE:list){
					request.getSession().setAttribute("q_id", QWE.getQ_id());//设置ID
					request.getSession().setAttribute("q_vehicleBrand", QWE.getQ_vehicleBrand());//适用车型
					request.getSession().setAttribute("q_partsImg", QWE.getQ_partsImg());//配件图片
					request.getSession().setAttribute("q_partsName", QWE.getQ_partsName());//配件名称
					request.getSession().setAttribute("q_partBrand", QWE.getQ_partBrand());//配件品牌
					request.getSession().setAttribute("q_number", QWE.getQ_number());//配件数量
					request.getSession().setAttribute("q_unit", QWE.getQ_unit());//单位
					request.getSession().setAttribute("q_partType", QWE.getQ_partType());//配件类型
					request.getSession().setAttribute("q_partEffect", QWE.getQ_partEffect());//配件作用
					request.getSession().setAttribute("q_buyingRate", QWE.getQ_buyingRate());//配件进价
					request.getSession().setAttribute("q_sellingPrice", QWE.getQ_sellingPrice());//配件售价
				}
				 // 为什么传过去的是一个对象？？
			}else{
				System.out.println("没有通过ID找到");
			}
		}else if(op.equals("selectStname")){ //查询员工.................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................0
			ArrayList<Sta_staffinfo> list2= new OrdersDao().selectStaName();
			String g=gs.toJson(list2);
			response.getWriter().print(g);
			System.out.println("进入查询员工操作");
		}
	}
	
}
