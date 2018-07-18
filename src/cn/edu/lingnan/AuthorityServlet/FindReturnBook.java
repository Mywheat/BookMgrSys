package cn.edu.lingnan.AuthorityServlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.AuthorityDao;
import cn.edu.lingnan.dto.SelectDTO;

public class FindReturnBook extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rno = null;
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		HttpSession s = req.getSession();
		v = (Vector<SelectDTO>) s.getAttribute("authority");
		Iterator it = v.iterator();
		SelectDTO sdto = null;
		while (it.hasNext()) {
			sdto = (SelectDTO) it.next();
			rno = sdto.getRno();
		}
//		System.out.println(rno);
        AuthorityDao a = new AuthorityDao();		
		HttpSession s1 = req.getSession();
		Vector<SelectDTO> v1 = new Vector<SelectDTO>();
		v1 = a.FindReturnBook(rno);
//		for(SelectDTO s2 : v){
//			System.out.print("aaaaaaaa"+s2.getRno());
//		}
		s1.setAttribute("returnbook", v1);	
		resp.sendRedirect("ReturnBook.jsp");
	}
}
