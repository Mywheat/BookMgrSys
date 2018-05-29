package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	    //所有从页面register.html传过来的参数都在req里面
		String rno = null;
		String rname = null;
		String password = null;
		int superuser = 0;
		req.setCharacterEncoding("utf-8");
		rno =  req.getParameter("rno");
		rname =  req.getParameter("rname");		
		password =  req.getParameter("password");
		superuser = Integer.parseInt(req.getParameter("superuser"));
		System.out.println("1."+rno+" "+rname+" "+password+" "+superuser);
		
		//2.调用后台的业务逻辑进行注册（插入数据）
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setRno(rno);
		sdto.setRname(rname);
		sdto.setPassword(password);
		sdto.setSuperuser(superuser);
		boolean flag = l.InsertRegister(sdto);
		
		//3.根据结果找到相应的页面
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.html");  //req.getContextPath()取OK.html的工程路径
		else
			resp.sendRedirect(req.getContextPath()+"/Error.html");
	}
}
