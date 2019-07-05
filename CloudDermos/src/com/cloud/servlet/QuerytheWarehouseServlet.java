package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.QueryTheWarehouseDao;
import com.cloud.entity.QuerytheWarehouseEntity;
import com.google.gson.Gson;

public class QuerytheWarehouseServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		QueryTheWarehouseDao dao = new QueryTheWarehouseDao();//查询对象
		Gson gs = new Gson(); //json格式转换
		if(op.equals("searchPart")){//查询零件
			List<QuerytheWarehouseEntity> list = dao.selectQuerytheWarehouse();
			String jsonStr = gs.toJson(list);
			response.getWriter().print(jsonStr);
		}else if(op.equals("byPartName")){//通过零件名称查名字
			request.setCharacterEncoding("utf-8");
			String byPartName= request.getParameter("byPartName");
			List<QuerytheWarehouseEntity> list = dao.selectQuerytheWarehouseByPartName(byPartName);
			String jsonStr = gs.toJson(list);
			response.getWriter().print(jsonStr);
			System.out.println("jsonStr:"+jsonStr);
			System.out.println("OP="+op+"\t\tbyPartName="+byPartName);
			
		}else if (op.equals("delectById")){// 通过ID逻辑删除零件
			int id =Integer.parseInt( request.getParameter("byPartId"));
			int row = dao.deleteQuerytheWarehouseById(id);
			response.getWriter().print(row);
			System.out.println(row);
		}
	
	}

}
