package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.MRecordDao;
import com.cloud.entity.MRecordEntity;
import com.cloud.entity.SmallServiceEntity;
import com.google.gson.Gson;

public class MRecordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//创建维修记录dao
		MRecordDao mdao = new MRecordDao();
		//创建Gson对象
		Gson g = new Gson();
		//获取op
		String op = request.getParameter("op");
		//判断op
		if("selectRecord".equals(op)){
			String key = request.getParameter("key")==null?"":request.getParameter("key");
			int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			int rows = request.getParameter("limit")==null?3:Integer.parseInt(request.getParameter("limit"));
			List<MRecordEntity> sslist = mdao.selectRecord(key,page,rows);
			String gsonStr = g.toJson(sslist);
			gsonStr="{\"code\":0,\"msg\":\"\",\"count\":"+mdao.selectRecordAll()+",\"data\":"+gsonStr+"}";
			System.out.println(gsonStr);
			response.getWriter().print(gsonStr);
		}else if("updateRecord".equals(op)){
			int id = Integer.parseInt(request.getParameter("id"));
			MRecordEntity mre = mdao.selectRecordById(id);
		}
	}

}
