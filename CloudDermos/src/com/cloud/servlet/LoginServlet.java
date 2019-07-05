package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloud.dao.AdminDao;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if("login".equals(op)){
			String name = request.getParameter("loginName");
			String pwd = request.getParameter("password");
			AdminDao da=new AdminDao();
			int row=da.register(name, pwd);
			if(row>0){
				 HttpSession session = request.getSession();
			        //将数据存储到session中
			        session.setAttribute("name", name);
				response.getWriter().print(row);
			}
			
		}
	}

}
