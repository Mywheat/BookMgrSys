package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		s.invalidate();   //注销掉session，使其下一次是新用户
		System.out.println("该用户已经注销了哈。。。。。。");
		resp.sendRedirect(req.getContextPath() + "/index.html"); // req.getContextPath()取OK.html的工程路径
	}
}
