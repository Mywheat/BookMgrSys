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

public class UpdateLend_returnServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rno = req.getParameter("rno");
		String number = req.getParameter("number");
		String lendDate = req.getParameter("lendDate");
		String returnDate = req.getParameter("returnDate");
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println(rno+" "+number+" "+lendDate+" "+returnDate+" "+status);
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setRno(rno);
		sdto.setNumber(number);
		sdto.setLendDate(lendDate);
		sdto.setReturnDate(returnDate);
		sdto.setStatus(status);
		boolean flag = l.UpdateLend_return(sdto);//更新数据
		Vector<SelectDTO> v = new Vector<SelectDTO>();//显示结果
		v = l.FindLend_return();
		HttpSession s = req.getSession();
		s.setAttribute("Lend_return", v);
		resp.sendRedirect("showLend_return.jsp");//重定向到书籍显示界面
	}
}
