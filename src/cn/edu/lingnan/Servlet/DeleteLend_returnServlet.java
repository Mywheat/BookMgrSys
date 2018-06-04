package cn.edu.lingnan.Servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class DeleteLend_returnServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		libraryDAO l = new libraryDAO();
		String rno = req.getParameter("rno");
		String number = req.getParameter("number");
		String lendDate = req.getParameter("lendDate");
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = l.DeleteLend_return(rno, number, lendDate);
		HttpSession s = req.getSession();
		s.setAttribute("Lend_return", v);
		resp.sendRedirect("showLend_return.jsp");
	}
}
