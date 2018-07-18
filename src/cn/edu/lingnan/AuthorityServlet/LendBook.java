package cn.edu.lingnan.AuthorityServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.AuthorityDao;
import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class LendBook extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rno = null;
		String number = null;
		String lendDate = null;
		String returnDate = null;
		req.setCharacterEncoding("utf-8");
		
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		System.out.println(df.format(day));   
		
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		HttpSession s = req.getSession();
		v = (Vector<SelectDTO>) s.getAttribute("authority");
		Iterator it = v.iterator();
		SelectDTO sdto = null;
		while (it.hasNext()) {
			sdto = (SelectDTO) it.next();
			rno = sdto.getRno();
		}
		
		
		number = req.getParameter("number");
		lendDate = df.format(day);
		
		returnDate = req.getParameter("returnDate");
		
			
		System.out.println("1. " + rno + " " + number + " " + lendDate + " "
				+ returnDate);
		
		AuthorityDao a = new AuthorityDao();
		
		SelectDTO sdto2 = new SelectDTO();
		sdto2.setRno(rno);
		sdto2.setNumber(number);
		sdto2.setLendDate(lendDate);
		sdto2.setReturnDate(returnDate);
		
		boolean flag = a.InsertLendBook(sdto2);
		System.out.println(flag);
		
		
		if(flag){
			HttpSession s1 = req.getSession();
			Vector<SelectDTO> v2 = new Vector<SelectDTO>();
			v2 = a.FindLendBook(sdto2);
			s1.setAttribute("AllBook", v2);
			resp.sendRedirect("LendBook.jsp");// 重定向到书籍显示界面
		}else{
			System.out.println("该书籍已被借出，你去看看别的书籍吧");
			resp.sendRedirect("LookAllBook1.jsp");
		}
		
	}
}
