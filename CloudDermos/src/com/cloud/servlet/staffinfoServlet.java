package com.cloud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.dao.AdminDao;
import com.cloud.entity.BranchEntry;
import com.cloud.entity.PostInfoEntry;
import com.cloud.entity.Sta_staffinfo;
import com.cloud.util.Cmd5;
import com.google.gson.Gson;

public class staffinfoServlet extends HttpServlet {

	 AdminDao da=new AdminDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取op
		String op=request.getParameter("op");
		
		if("breach".equals(op)){
			//部门查询
			System.out.println("op"+op);
			selectbreach(request, response);
		}else if("addbreach".equals(op)){
			//部门添加
			System.out.println("op"+op);
			addbreach(request, response);
		}else if("updatebreachs".equals(op)){
			//部门修改
			System.out.println("op"+op);
			updatebreachs(request, response);
			
		}else if("deletebrach".equals(op)){
			//部门删除
			System.out.println("op"+op);
			deletebrach(request, response);
			
		}else if("post".equals(op)){
			//职位查询
			System.out.println("op"+op);
			selectpost(request, response);
		}else if("saddpost".equals(op)){
			//添加职位时进行部门的查询方便添加与修改
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			 List<BranchEntry> list = da.selectbranchs();
			 Gson g=new Gson();
			 String gsonString=g.toJson(list);
			 response.getWriter().print(gsonString);
			System.out.println("你好还哦"+gsonString);
			
		}else if("addpost".equals(op)){
			//职位添加
			System.out.println("op"+op);
			addpost(request, response);
		}else if("deletepost".equals(op)){
			//职位删除
			System.out.println("op"+op);
			deletepost(request, response);
		}else if("updatepost".equals(op)){
			updatepost(request, response);
		}else if("Staffinfo".equals(op)){
			Staffinfo(request, response);
		}
		else if("deletestaffinfo".equals(op)){
			deletestaffinfo(request, response);
		}else if("addStaff".equals(op)){
			addStaff(request, response);
		}else if("postss".equals(op)){
			//部门的查询
			System.out.println("op"+op);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			System.out.println("op"+op+"中添加");
			List<PostInfoEntry> plist=da.selectpostss();
			Gson g=new Gson();
			String json=g.toJson(plist);
			response.getWriter().print(json);
			
			
		}else if("updateStaff".equals(op)){
			//部门的查询
			System.out.println("op"+op);
			updateStaff(request, response);
			
		}else if("tianjia".equals(op)){
			//部门的查询
			System.out.println("op"+op);
			int cityId=Integer.parseInt(request.getParameter("cityId"));
			List<PostInfoEntry> daa = da.selectposts(cityId);
			Gson g=new Gson();
			if(daa.size()<1){
				PostInfoEntry pa=new PostInfoEntry(0, "该部门暂无职位", "无");
				daa.add(pa);
				String json=g.toJson(daa);
				response.getWriter().print(json);
			}else{
				String json=g.toJson(daa);
				response.getWriter().print(json);
			}
		}else if("selAAstaffinfo".equals(op)){
			//单个员工查询
			System.out.println("op"+op);
			int id=Integer.parseInt(request.getParameter("id"));
			Sta_staffinfo Sta = da.aaselectstaff(id);
			System.out.println(Sta.getSta_phone());
			request.getSession().setAttribute("Stas", Sta);
		}
		else{
			selectpost(request, response);
			System.out.println("op"+op);
		}
		
	}
	
//=========================员工块==================================================================
	public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//员工编号
		int sta_id=Integer.parseInt(request.getParameter("id"));
		//员工名称
		String sta_name=request.getParameter("S_name");
		//员工性别
		String sta_sex=request.getParameter("S_sex");
		//员工出生年月
		String sta_birthday=request.getParameter("S_birthday");
		//员工电话号码
		String sta_phone=request.getParameter("S_phone");
		//员工登录名
		String sta_login=request.getParameter("S_login");
		//员工登录密码
		String sta_pwd=request.getParameter("S_pwd");
		//员工入职时间
		String sta_entrytime=request.getParameter("S_entrytime");
		//员工职位
		int post=Integer.parseInt(request.getParameter("post"));
		//员工住址
		String sta_present=request.getParameter("S_present");
		//员工民族
		String S_natio=request.getParameter("S_natio");
		//员工籍贯
		String S_place=request.getParameter("S_place");
		//员工血型
		String S_blood=request.getParameter("S_blood");
		//员工身份证号
		String S_idcate=request.getParameter("S_idcate");
		//婚姻状况
		String S_marital=request.getParameter("S_marital");
		//员工政治面貌
		String S_politics=request.getParameter("S_politics");
		//最高学历
		String S_maxeducation=request.getParameter("S_maxeducation");
		//最高学位
		String S_maxdegree=request.getParameter("S_maxdegree");
		//邮箱
		String S_Email=request.getParameter("S_Email");
		//紧急联系人的电话
		String S_emIP=request.getParameter("S_emIP");
		//外语等级
		String S_Englist=request.getParameter("S_Englist");
		//计算机等级
		String S_computer=request.getParameter("S_computer");
		//员工照片
		//String S_img=request.getParameter("S_img");
		//员工必填
		PostInfoEntry ph=new PostInfoEntry();
		
		Sta_staffinfo st=new Sta_staffinfo(sta_id, sta_name, sta_sex, sta_birthday, sta_phone, sta_login, sta_pwd, sta_entrytime, ph, sta_present, S_natio, S_place, S_blood, S_idcate, S_marital, S_politics, S_maxeducation, S_maxdegree, S_Email, S_emIP, S_Englist, S_computer,"a");
		
		int i = da.updateStaff(st, post);
		response.getWriter().print(i);
	};
	//员工添加
	public void addStaff(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//员工编号
		//int sta_id=Integer.parseInt(request.getParameter("sta_id"));
		//员工名称
		String sta_name=request.getParameter("S_name");
		//员工性别
		String sta_sex=request.getParameter("S_sex");
		//员工出生年月
		String sta_birthday=request.getParameter("S_birthday");
		//员工电话号码
		String sta_phone=request.getParameter("S_phone");
		//员工登录名
		String sta_login=request.getParameter("S_login");
		//员工登录密码
		String sta_pwd1=request.getParameter("S_pwd");
		//加密密码
		Cmd5 cd = new Cmd5();
		String sta_pwd = cd.getMD5String(sta_pwd1);
		//员工入职时间
		String sta_entrytime=request.getParameter("S_entrytime");
		//员工职位
		int post=Integer.parseInt(request.getParameter("post"));
		//员工住址
		String sta_present=request.getParameter("S_present");
		//员工民族
		String S_natio=request.getParameter("S_natio");
		//员工籍贯
		String S_place=request.getParameter("S_place");
		//员工血型
		String S_blood=request.getParameter("S_blood");
		//员工身份证号
		String S_idcate=request.getParameter("S_idcate");
		//婚姻状况
		String S_marital=request.getParameter("S_marital");
		//员工政治面貌
		String S_politics=request.getParameter("S_politics");
		//最高学历
		String S_maxeducation=request.getParameter("S_maxeducation");
		//最高学位
		String S_maxdegree=request.getParameter("S_maxdegree");
		//邮箱
		String S_Email=request.getParameter("S_Email");
		//紧急联系人的电话
		String S_emIP=request.getParameter("S_emIP");
		//外语等级
		String S_Englist=request.getParameter("S_Englist");
		//计算机等级
		String S_computer=request.getParameter("S_computer");
		//员工照片
		String S_img=request.getParameter("S_img");
		//员工必填
		System.out.println(sta_birthday);
		PostInfoEntry ph=new PostInfoEntry();
		
		Sta_staffinfo st=new Sta_staffinfo(0, sta_name, sta_sex, sta_birthday, sta_phone, sta_login, sta_pwd, sta_entrytime, ph, sta_present, S_natio, S_place, S_blood, S_idcate, S_marital, S_politics, S_maxeducation, S_maxdegree, S_Email, S_emIP, S_Englist, S_computer, S_img);
		
		int i = da.addStaff(st, post);
		response.getWriter().print(i);
	};
	//员工删除
	public void deletestaffinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int i = da.deletestaffinfo(id);
		response.getWriter().print(i);
		
	};
	//员工查询	
	public void Staffinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//分页时取到当前页和显示条数
		int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int size = request.getParameter("limit")==null?5:Integer.parseInt(request.getParameter("limit"));
		//获取参数
		String key = request.getParameter("key")==null?"":request.getParameter("key");
		List<Sta_staffinfo> list=da.selectstaff(size,currentPage,key);
		Gson g=new Gson();
		String json=g.toJson(list);
		json="{\"code\":0,\"msg\":\"\",\"count\":"+da.selectstafftiao(key)+",\"data\":"+json+"}";
		response.getWriter().print(json);
		//System.out.println(json);
	};
	//------------------------------以下是职位---------------------------------------------------------------
	public void selectpost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//分页时取到当前页和显示条数
		int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int size = request.getParameter("limit")==null?5:Integer.parseInt(request.getParameter("limit"));
		//获取参数
		String key = request.getParameter("key")==null?"":request.getParameter("key");
		List<PostInfoEntry> list=da.selectpost(size,currentPage,key);
		Gson g=new Gson();
		String json=g.toJson(list);
		json="{\"code\":0,\"msg\":\"\",\"count\":"+da.selectposttiao(key)+",\"data\":"+json+"}";
		response.getWriter().print(json);
		System.out.println(json);
	};
	//职位添加
	public void addpost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		int id=Integer.parseInt(request.getParameter("serviceType"));
		String remark=request.getParameter("remark");
		int i = da.addpost(uname, id,remark);
		response.getWriter().print(i);
	};
	//职位修改
	public void updatepost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int pid=Integer.parseInt(request.getParameter("serviceType"));
		String name=request.getParameter("name");
		String remark=request.getParameter("remark");
		int i=0;
		 i=da.updatepost(name, remark, pid, id);
		System.out.println(i);
		response.getWriter().print(i);
	};
	//职位删除
	public void deletepost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int i = da.deletepost(id);
		response.getWriter().print(i);
		
	};
	
	//---------------------以下是部门块-------------------------------------------------------------------
	//部门查询
	public void selectbreach(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//分页时取到当前页和显示条数
		int currentPage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int size = request.getParameter("limit")==null?5:Integer.parseInt(request.getParameter("limit"));
		//获取参数
		String key = request.getParameter("key")==null?"":request.getParameter("key");
		System.out.println(currentPage+"\t"+size);
		
		List<BranchEntry> list=da.selectbranch(size,currentPage,key);
		Gson g=new Gson();
		String json=g.toJson(list);
		json="{\"code\":0,\"msg\":\"\",\"count\":"+da.selectbranchtiao(key)+",\"data\":"+json+"}";
		response.getWriter().print(json);
	};
	//部门添加
	public void addbreach(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String remark=request.getParameter("remark");
		int i = da.addbranch(uname, remark);
		response.getWriter().print(i);
	};
	//部门修改
	public void updatebreachs(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String remark=request.getParameter("remark");
		int i=da.updatebranch(name, remark, id);
		response.getWriter().print(i);
	};
	//部门删除
	public void deletebrach(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("adfa:"+id);
		int i = da.deletebranch(id);
		response.getWriter().print(i);
		
	};

}
