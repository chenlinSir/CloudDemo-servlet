package com.cloud.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.BigServiceDao;
import com.cloud.dao.SmallServiceDao;
import com.cloud.entity.BigServiceEntity;
import com.cloud.entity.SmallServiceEntity;
import com.google.gson.Gson;

//服务（小）Servlet
public class SmallServiceServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取op
		String op = request.getParameter("op");
		//创建Gson对象
		Gson g = new Gson();
		//创建dao层对象
		SmallServiceDao sdao = new SmallServiceDao();
		if("selectSmall".equals(op)){//查询
			String key = request.getParameter("key");
			int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			int rows = request.getParameter("limit")==null?3:Integer.parseInt(request.getParameter("limit"));
			List<SmallServiceEntity> sslist = sdao.selectSmall(key,page,rows);
			String gsonStr = g.toJson(sslist);
			gsonStr="{\"code\":0,\"msg\":\"\",\"count\":"+sdao.selectAll(key)+",\"data\":"+gsonStr+"}";
			response.getWriter().print(gsonStr);
		}else if("selectSmallAll".equals(op)){//查询
			List<SmallServiceEntity> sslist = sdao.selectSmallAll();
			String gsonStr = g.toJson(sslist);
			gsonStr="{\"code\":0,\"msg\":\"\",\"count\":"+0+",\"data\":"+gsonStr+"}";
			response.getWriter().print(gsonStr);
		}else if("addSmall".equals(op)){//添加
			//获取页面数据
			String s_name = request.getParameter("service");
			int serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
			BigServiceDao bdao = new BigServiceDao();
			BigServiceEntity bse = bdao.selectBigById(serviceTypeId);
			Double price = Double.parseDouble(request.getParameter("price"));
			String remark = request.getParameter("remark");
			SmallServiceEntity sse = new SmallServiceEntity(s_name, bse, price, remark);
			int row = sdao.addSmall(sse);
			String gsonStr = g.toJson(row);
			response.getWriter().print(gsonStr);
		}else if("updateSmall".equals(op)){//修改
			int id = Integer.parseInt(request.getParameter("bigId"));
			String serivce = request.getParameter("serivce");
			int serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
			BigServiceDao bdao = new BigServiceDao();
			BigServiceEntity bse = bdao.selectBigById(serviceTypeId);
			Double price = Double.parseDouble(request.getParameter("price"));
			String remark = request.getParameter("remark");
			SmallServiceEntity sse = new SmallServiceEntity(id, serivce, bse, price, remark);
			int row = sdao.updateSmall(sse);
			String gsonStr = g.toJson(row);
			response.getWriter().print(gsonStr);
		}else if("delSmall".equals(op)){//删除
			int id = Integer.parseInt(request.getParameter("delId"));
			int row = sdao.deleteSmall(id);
			String gsonStr = g.toJson(row);
			response.getWriter().print(gsonStr);
		}
		
	}
}









