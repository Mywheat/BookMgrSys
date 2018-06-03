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

public class InsertBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���д�ҳ�洫�����Ĳ�������req����
		String number = null;
		String bname = null;
		String author = null;
		String bookpub = null;
		String bookpubdate = null;
		String booklend = null;
		req.setCharacterEncoding("utf-8");
		number = req.getParameter("number");
		bname = req.getParameter("bname");
		author = req.getParameter("author");
		bookpub = req.getParameter("bookpub");
		bookpubdate = req.getParameter("bookpubdate");
		booklend = req.getParameter("booklend");
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println("1." + number + " " + bname + " " + author
				+ " " + bookpub + " " + bookpubdate + " " + booklend + " " +status);

		// 2.���ú�̨��ҵ���߼����в�������
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setNumber(number);
		sdto.setBname(bname);
		sdto.setAuthor(author);
		sdto.setBookpub(bookpubdate);
		sdto.setBookpubdate(bookpubdate);
		sdto.setBooklend(booklend);
		sdto.setStatus(status);
		boolean flag = l.InsertBookIfo(sdto);
		Vector<SelectDTO> v = new Vector<SelectDTO>();//��ʾ���
		v = l.FindAllBookIfo();
		HttpSession s = req.getSession();
		s.setAttribute("AllBook", v);
		resp.sendRedirect("showAllBook.jsp");//�ض����鼮��ʾ����
	}
}
