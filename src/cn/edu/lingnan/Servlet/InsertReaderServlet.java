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

public class InsertReaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���д�ҳ�洫�����Ĳ�������req����
		String rno = null;
		String rname = null;
		String password = null;
		req.setCharacterEncoding("utf-8");
		rno = req.getParameter("rno");
		rname = req.getParameter("rname");
		password = req.getParameter("password");
		int superuser = Integer.parseInt(req.getParameter("superuser"));
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println( rno + " " + rname + " " + password
				+ " " + superuser + " " +status);

		// 2.���ú�̨��ҵ���߼����в�������
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setRno(rno);
		sdto.setRname(rname);
		sdto.setPassword(password);
		sdto.setSuperuser(superuser);
		sdto.setStatus(status);
		boolean flag = l.InsertRegister(sdto);
		Vector<SelectDTO> v = new Vector<SelectDTO>();//��ʾ���
		v = l.FindAllReaderIfo();
		HttpSession s = req.getSession();
		s.setAttribute("AllReader", v);
		resp.sendRedirect("showAllReader.jsp");//�ض����鼮��ʾ����
	}
}
