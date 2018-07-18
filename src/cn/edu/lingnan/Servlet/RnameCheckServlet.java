package cn.edu.lingnan.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.libraryDAO;

public class RnameCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rname = new String(req.getParameter("rname").getBytes("ISO-8859-1"),"GB2312");
//		System.out.println("¼ì²âÒ»ÏÂ¡£¡£¡£¡£¡£¡£"+rname);
		libraryDAO l = new libraryDAO();
		boolean flag = l.FindReaderByRname(rname);
		if(flag)
			resp.getWriter().print("true");
	}
}
