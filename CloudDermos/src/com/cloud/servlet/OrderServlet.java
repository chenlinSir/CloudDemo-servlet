package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.OrdersDao;
import com.cloud.entity.BigServiceEntity;
import com.cloud.entity.MessageEntity;
import com.cloud.entity.Ordersenity;
import com.cloud.entity.Recordenity;
import com.cloud.entity.SmallServiceEntity;
import com.cloud.entity.Sta_staffinfo;
import com.cloud.entity.UserInfoEntry;

import com.google.gson.Gson;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
			Gson gs=new Gson();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			OrdersDao dao=new OrdersDao();
			String op=request.getParameter("op");
			Gson gs=new Gson();
			if("queryfu".equals(op)){//查看大服务
				ArrayList<BigServiceEntity> list=dao.selectBigfu();
				String g= gs.toJson(list);
	   		    response.getWriter().print(g);
			}else if("selectOrder".equals(op)){//查询订单
				this.select2(request, response);
				
			}else if("addOrders".equals(op)){//添加订单
				String userName=request.getParameter("userName");//客户姓名
				UserInfoEntry ue=dao.selectUser(userName);//客户对象
				String staName=request.getParameter("staName");//接单员
				Sta_staffinfo st=dao.selectSta(staName);//接单员对象
				String userGrade=request.getParameter("userGrade");//服务类型
				BigServiceEntity sm=dao.selSml(userGrade);//服务类型对象
				String LStatus=request.getParameter("LStatus");//服务方式
				String ordertatus=request.getParameter("ordertatus");//订单状态
				String payStatus=request.getParameter("payStatus");//支付方式
				String zkStatus=request.getParameter("zkStatus");//折扣
				Double zk=Double.parseDouble(zkStatus);
				String remark=request.getParameter("remark");//备注				
				Ordersenity or=new Ordersenity(ue, st, sm,zk, payStatus, ordertatus, LStatus, remark);
				int row=dao.addOrder(or);
				if(row>0){
					response.getWriter().print(row);
				}
			}
			else if("update".equals(op)){//修改订单
				String idstr=request.getParameter("id");
				int id=Integer.parseInt(idstr);
				String userName=request.getParameter("userName");//客户姓名
				UserInfoEntry ue=dao.selectUser(userName);//客户对象
				String staName=request.getParameter("staName");//接单员
				Sta_staffinfo st=dao.selectSta(staName);//接单员对象			
				String userGrade=request.getParameter("userGrade");//服务类型
				int l_id=Integer.parseInt(userGrade);
				System.out.println(l_id);
				BigServiceEntity sm=dao.selSml2(l_id);//服务类型对象
				String LStatus=request.getParameter("LStatus");//服务方式
				String ordertatus=request.getParameter("ordertatus");//订单状态
				String payStatus=request.getParameter("payStatus");//支付方式
				String zkStatus=request.getParameter("zkStatus");//折扣
				Double zk=Double.parseDouble(zkStatus);
				String remark=request.getParameter("remark");//备注
				Ordersenity or=new Ordersenity(id,ue, st, sm,zk, payStatus, ordertatus, LStatus, remark);
				int row=dao.updateOrder(or);
				if(row>0){
					response.getWriter().print(row);
				}
			}else if("delete".equals(op)){
				//通过Id来删除
				String str=	request.getParameter("Id");
				int id=Integer.parseInt(str);
				int row=dao.delOrder(id);
				if(row>0){
					response.getWriter().print(row);
				}
			}else if("selectSta".equals(op)){//查看员工信息
				ArrayList<Sta_staffinfo> st=dao.selectStaName();
				String g=gs.toJson(st);
				response.getWriter().print(g);
			}else if("Maint".equals(op)){//添加维修工信息
				String idstr=request.getParameter("id");
				int id=Integer.parseInt(idstr);
				Ordersenity or=dao.selectOrd(id);
				String staName2=request.getParameter("staName2");//员工
				Sta_staffinfo st=dao.selectSta(staName2);
				Recordenity re=new Recordenity(or, st);
				int row=dao.record(re);
				if(row>0){
					response.getWriter().print(row);
			
				}
			}

	}
	
	//查看订单
	public void select(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		OrdersDao dao=new OrdersDao();
		ArrayList<Ordersenity> list=dao.select();
		String g=gs.toJson(list);
		System.out.println(g);
		g="{\"code\":0,\"msg\":\"\",\"count\":"+0+",\"data\":"+g+"}";
		response.getWriter().print(g);
	}	//查看订单2,模糊查询，分页
	public void select2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersDao dao=new OrdersDao(); 
		int Page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int rows=request.getParameter("limit")==null?3:Integer.parseInt(request.getParameter("limit"));
		String key=request.getParameter("key")==null?"":request.getParameter("key");
		ArrayList<Ordersenity> list=dao.select2(Page,rows,key);
		String g=gs.toJson(list);	
		g="{\"code\":0,\"msg\":\"\",\"count\":"+dao.selectCount(key)+",\"data\":"+g+"}";
		response.getWriter().print(g);
	}

}
