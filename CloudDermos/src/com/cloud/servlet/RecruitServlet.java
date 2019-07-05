package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.RecruitDao;
import com.cloud.entity.BranchEntry;
import com.cloud.entity.PostInfoEntry;
import com.cloud.entity.RecruitEntry;
import com.google.gson.Gson;

public class RecruitServlet extends HttpServlet {

//servlet/RecruitServlet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String op=request.getParameter("op");
			RecruitDao recruitdao=new RecruitDao();
			System.out.println(op);
			if(op==null){
				//分页时取到当前页和显示条数
				int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
				int size = request.getParameter("limit")==null?5:Integer.parseInt(request.getParameter("limit"));
				
				List<RecruitEntry> re=recruitdao.SelectRecruit(size,currentPage);
				Gson g=new Gson();
				String json=g.toJson(re);
				json="{\"code\":0,\"msg\":0,\"count\":1,\"data\":"+json+"}";
				response.getWriter().print(json);

				System.out.println(json);
			}else if("upd".equals(op)){
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				//招聘id
				int reId=Integer.parseInt(request.getParameter("reId"));
				//职位id
				int post_id=Integer.parseInt(request.getParameter("city"));
				//发布时间
				String start_time=request.getParameter("start_time");
				//截止时间
				String end_time=request.getParameter("end_time");
				//招聘人数
				int sum=Integer.parseInt(request.getParameter("sum"));
				//部门id
				int b_id=Integer.parseInt(request.getParameter("city1"));
				int i=0;
				 i=recruitdao.updatebranch(post_id,start_time,end_time ,sum,b_id,reId);
				System.out.println(i);
				response.getWriter().print(i);
			}else if("cxb".equals(op)){
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				ArrayList<BranchEntry> re=recruitdao.selectpost();
				Gson g=new Gson();
				String json=g.toJson(re);
				json="{\"code\":0,\"msg\":0,\"count\":3,\"data\":"+json+"}";
				response.getWriter().print(json);

				System.out.println(json);
				
			}else if("cx1".equals(op)){
				int id=request.getParameter("post_id")==null?1:Integer.parseInt(request.getParameter("post_id"));
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				System.out.print(id);
				List<BranchEntry> re=recruitdao.selectpost(id);
				Gson g=new Gson();
				String json=g.toJson(re);
				json="{\"code\":0,\"msg\":0,\"count\":3,\"data\":"+json+"}";
				response.getWriter().print(json);

				
			}else if("del".equals(op)){
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				int id=Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				int i = recruitdao.deletRecruit(id);

				System.out.println("scts"+i);
				response.getWriter().print(i);
			}else if("add".equals(op)){
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				//职位id
				int post_id=Integer.parseInt(request.getParameter("city"));
				//发布时间
				String start_time=request.getParameter("start_time");
				//截止时间
				String end_time=request.getParameter("end_time");
				//招聘人数
				int sum=Integer.parseInt(request.getParameter("sum"));
				//部门id
				int b_id=Integer.parseInt(request.getParameter("city1"));
				int i=0;
				 i=recruitdao.addRecruit(post_id,start_time,end_time,sum,b_id);
				System.out.println(i);
				response.getWriter().print(i);
			}
				
				
				
	}

}
