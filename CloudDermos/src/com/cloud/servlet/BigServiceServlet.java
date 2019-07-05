package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cloud.dao.BigServiceDao;
import com.cloud.entity.BigServiceEntity;
import com.google.gson.Gson;

//服务类型Servlet
public class BigServiceServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson g = new Gson();
		//处理请求乱码
		request.setCharacterEncoding("utf-8");
		//处理响应乱码
		response.setCharacterEncoding("utf-8");
		//创建dao层对象
		BigServiceDao bdao = new BigServiceDao();
		//获取op
		String op = request.getParameter("op");
		if("selectBig".equals(op)){//查询
			List<BigServiceEntity> blist = bdao.selectBig();
			String gsonStr = g.toJson(blist);
			response.getWriter().print(gsonStr);
		}else if("selectBigById".equals(op)){
			int id = Integer.parseInt(request.getParameter("id"));
			BigServiceEntity bse = bdao.selectBigById(id);
			String gsonStr = g.toJson(bse);
			response.getWriter().print(gsonStr);
		}else if("addBig".equals(op)){//添加
			//获取页面值
			String name = request.getParameter("name");
			System.out.println(name);
			//将实体传到dao层
			int row = bdao.addBig(name);
			response.getWriter().print(row);
		}else if("updateBig".equals(op)){//修改
			//获取页面的值
			int id = Integer.parseInt(request.getParameter("upId"));
			String name = request.getParameter("serviceTypeUpdate");
			//获取服务类型实体
			BigServiceEntity bse = new BigServiceEntity(id,name);
			//将实体传到dao层
			int row = bdao.updataBig(bse);
			response.getWriter().print(row);
		}else if("deleteBig".equals(op)){//删除
			//通过页面获取id
			int id = Integer.parseInt(request.getParameter("delId"));
			//将id传到dao层
			int row = bdao.deleteBig(id);
			response.getWriter().print(row);
		}
		
	}
}
