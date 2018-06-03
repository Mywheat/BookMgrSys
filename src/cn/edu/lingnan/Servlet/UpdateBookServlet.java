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

public class UpdateBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("GB2312");
		String number = req.getParameter("number");
		String bname = req.getParameter("bname"); 
		bname = new String(bname.getBytes("iso-8859-1"),"GB2312");
		String author = req.getParameter("author");
		author = new String(author.getBytes("iso-8859-1"),"GB2312");
		String bookpub = req.getParameter("bookpub");
		bookpub = new String(bookpub.getBytes("iso-8859-1"),"GB2312");
		String bookpubdate = req.getParameter("bookpubdate");
		String booklend = req.getParameter("booklend");
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println(number+" "+bname+" "+author+" "+bookpub+" "+bookpubdate+" "+booklend+" "+status);
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setNumber(number);
		sdto.setBname(bname);
		sdto.setAuthor(author);
		sdto.setBookpub(bookpub);
		sdto.setBookpubdate(bookpubdate);
		sdto.setBooklend(booklend);
		sdto.setStatus(status);
		boolean flag = l.UpdateBookIfo(sdto);//更新数据
		Vector<SelectDTO> v = new Vector<SelectDTO>();//显示结果
		v = l.FindAllBookIfo();
		HttpSession s = req.getSession();
		s.setAttribute("AllBook", v);
		resp.sendRedirect("showAllBook.jsp");//重定向到书籍显示界面
	}
}
