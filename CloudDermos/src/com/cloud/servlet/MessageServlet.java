package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloud.dao.MessageDao;
import com.cloud.dao.UserMessageDao;
import com.cloud.entity.MessageEntity;
import com.cloud.entity.UserMessageEntity;
import com.cloud.util.DateTime;
import com.cloud.util.Page;
import com.google.gson.Gson;

public class MessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	MessageDao md = new MessageDao();
	UserMessageDao umd = new UserMessageDao();
	DateTime dt = new DateTime();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		HttpSession session = request.getSession();
		if("addMessage".equals(op)){
			String userName = request.getParameter("userName");
			String email = request.getParameter("Email");
			String userAsk = request.getParameter("userAsk");
			String dateTime = dt.getTime();
			MessageEntity me = new MessageEntity(userName, userAsk, dateTime, email);
			int row =md.addMessage(me);
			if(row>0){
					response.getWriter().print(row);
			}else{
				response.getWriter().print(row);
			}
		}else if("searchMessage".equals(op)){
			String pageStr = request.getParameter("page");
			String pageCount1 = request.getParameter("limit");
			String key = request.getParameter("key")==null?"":request.getParameter("key");
			 int currentPage = 1;
			 int pageCount =3;
			if (pageStr != null) {
				currentPage = Integer.parseInt(pageStr);
			}
			if(pageCount1!=null){
				 pageCount = Integer.parseInt(pageCount1);
			}
			int totleCount = md.getUserCount(key);
			List<MessageEntity> list = md.searchMessage(currentPage, pageCount, key);
			Page<MessageEntity> paged = new Page(currentPage, pageCount, totleCount, list);
			response.setCharacterEncoding("utf-8");
			Gson g = new Gson();
			String gsonStr = g.toJson(list);
			gsonStr="{\"code\":0,\"msg\":\"\",\"count\":"+paged.getTotleCount()+",\"data\":"+gsonStr+"}";
			response.getWriter().print(gsonStr);
			
			
		}else if("searchMessageById".equals(op)){
			String msgId = request.getParameter("msgId");
			List<MessageEntity> list = md.searchMessageById(msgId);
			Gson g=new Gson();
			String jsonStr=g.toJson(list);
			response.getWriter().print(jsonStr);
		}else if("delMessage".equals(op)){
			int  msgId  = Integer.parseInt(request.getParameter("ids"));
			int row = md.delMessageByMsgId(msgId);
			response.getWriter().print(row);
		}else if("searchUserMessage".equals(op)){
			String pageStr = request.getParameter("page");
			String pageCount1 = request.getParameter("limit");
			String key = request.getParameter("key")==null?"":request.getParameter("key");
			 int currentPage = 1;
			 int pageCount =3;
			if (pageStr != null) {
				currentPage = Integer.parseInt(pageStr);
			}
			if(pageCount1!=null){
				 pageCount = Integer.parseInt(pageCount1);
			}
			int totleCount = umd.getUserCount(key);
			int msgId = Integer.parseInt(request.getParameter("msgId"));
			List<UserMessageEntity> list = umd.searchUserMessage(currentPage, pageCount, key,msgId);
			Page<UserMessageEntity> paged = new Page(currentPage, pageCount, totleCount, list);
			response.setCharacterEncoding("utf-8");
			Gson g = new Gson();
			String gsonStr = g.toJson(list);
			gsonStr="{\"code\":0,\"msg\":\"\",\"count\":"+paged.getTotleCount()+",\"data\":"+gsonStr+"}";
			response.getWriter().print(gsonStr);
			
			
		}else if("sendMessage".equals(op)){
	        String  userName = (String)session.getAttribute("name");
			String userAsk = request.getParameter("userAsk");
			int  msgId = Integer.parseInt(request.getParameter("msgId"));
			String dateTime = dt.getTime();
			System.out.println(dateTime);
			UserMessageEntity ume = new UserMessageEntity(msgId, null, userName, userAsk, dateTime);
			int row = umd.addUserMessage(ume);
			response.getWriter().print(row);
		}else if("delUserMessage".equals(op)){
			int  userId  = Integer.parseInt(request.getParameter("ids"));
			int  msgId  = Integer.parseInt(request.getParameter("ids1"));
			int row = umd.delUserMessageByMsgId(userId,msgId);
			response.getWriter().print(row);
		}
		
		
	}

}
