package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;

public class LoginServlet extends HttpServlet {

	//所有从页面传过来的参数都在req里面
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.从页面获取我们想要的数据
		String rname = null;
		String password = null;
		req.setCharacterEncoding("utf-8");	
		rname = req.getParameter("rname");		
		password = req.getParameter("password");
		System.out.println("1."+rname+" "+password);
		
		//2.调用后台的业务逻辑判断用户名和密码是否存在且与之相对应
		libraryDAO l = new libraryDAO();
		int supervalue = l.FindReaderByUsernameAndPassword(rname, password);
		System.out.println("检测2------"+supervalue);
		HttpSession session = req.getSession();
		session.setAttribute("supervalue1", supervalue);	
		//3.根据结果找到相应的页面
		if(supervalue != 0)
			resp.sendRedirect(req.getContextPath()+"/OK.html");  //req.getContextPath()取OK.html的工程路径
		else
			resp.sendRedirect(req.getContextPath()+"/Error.html");
			
	}
}
