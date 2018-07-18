package cn.edu.lingnan.AuthorityServlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.AuthorityDao;
import cn.edu.lingnan.dto.SelectDTO;

public class ReturnBook extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AuthorityDao a = new AuthorityDao();
		String rno = req.getParameter("rno");
		String number = req.getParameter("number");
		String lendDate = req.getParameter("lendDate");
		System.out.println(rno+" "+number+" "+lendDate);
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = a.DeleteLend_return(rno, number, lendDate);
//		for(SelectDTO s : v){
//			System.out.println("ssssssss"+s.getNumber()+s.getLendDate()+s.getRno()+s.getReturnDate()+s.getStatus());
//		}
		HttpSession s = req.getSession();
		s.setAttribute("returnbook", v);
		resp.sendRedirect("ReturnBook.jsp");
	}
}
