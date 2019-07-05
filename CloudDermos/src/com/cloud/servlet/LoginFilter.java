package com.cloud.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)arg1;
		HttpSession session = req.getSession();
        String  loginName = (String)session.getAttribute("name");
        String path=req.getRequestURI();
        //System.out.println(path);
        if(path.indexOf("/CloudDermos/Login.jsp")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/subscribe.jsp")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/about.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/contact.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/gallery.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/index.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/Information Center.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/single.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/Staffmanagement.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        if(path.indexOf("/CloudDermos/Pc/typography.html")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
        
        if(path.indexOf("/CloudDermos/servlet/LoginServlet")>-1){//登陆页面不过滤
            arg2.doFilter(req, res);
            return;
        }
		else if(loginName!=null){//已经登录
            arg2.doFilter(req, res);//放行，递交给下一个过滤器
            return;
        }else{
        	res.sendRedirect("/CloudDermos/Login.jsp");
        	//window.top.location.href="BackgrounPage/index.jsp";
        }
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
