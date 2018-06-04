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

public class InsertLend_returnServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rno = null;
		String number = null;
		String lendDate = null;
		String returnDate = null;
		req.setCharacterEncoding("utf-8");
		rno = req.getParameter("rno");
		number = req.getParameter("number");
		lendDate = req.getParameter("lendDate");
		returnDate = req.getParameter("returnDate");
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println("1. " + rno + " " + number + " " + lendDate + " "
				+ returnDate + " " + status);
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setRno(rno);
		sdto.setNumber(number);
		sdto.setLendDate(lendDate);
		sdto.setReturnDate(returnDate);
		sdto.setStatus(status);
		boolean flag = l.InsertLend_return(sdto);
		if(flag){
			Vector<SelectDTO> v = new Vector<SelectDTO>();// ��ʾ���
			v = l.FindLend_return();
			HttpSession s = req.getSession();
			s.setAttribute("Lend_return", v);
			resp.sendRedirect("showLend_return.jsp");// �ض����鼮��ʾ����
		}else{
			System.out.println("���鼮�ѱ��������ȥ��������鼮��");
			resp.sendRedirect("insertLend_return.jsp");
		}
		
	}
}
