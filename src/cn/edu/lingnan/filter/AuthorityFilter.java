package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 判断登录页面的权限，如果权限为1，则可去到admin.html的页面，否则去权限错误的页面authority.html
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession(); // 取值，是HttpServletRequest的子类
		Integer supervalue2 = (Integer) session.getAttribute("supervalue1");
		System.out.println("检测3-------" + supervalue2);		
		if (supervalue2 != null) // supervalue1要定义成Integer才可以这样子调用，如果定义成int会报错
		{
			if (supervalue2 == 0) // 登录错误
			{
				System.out.println("登录错误，权限为0");
				resp.sendRedirect(req.getContextPath() + "/index.html");
			}				
			else 
				if (supervalue2 == 1){
					arg2.doFilter(arg0, arg1); // 往下一级传递，如果没有下一级，直接调用资源(即是你想去哪就去哪)				
				}		
			    else{
					resp.sendRedirect(req.getContextPath()+ "/authority.jsp");
			    }			    	
		}else {
			System.out.println("还没有登录，权限为空");
			resp.sendRedirect(req.getContextPath() + "/index.html");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
