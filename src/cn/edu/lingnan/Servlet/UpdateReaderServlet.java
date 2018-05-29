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

public class UpdateReaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rno = req.getParameter("rno");
		String rname = req.getParameter("rname");           
		rname = new String(rname.getBytes("iso-8859-1"),"GB2312");
		String password = req.getParameter("password");
		int superuser = Integer.parseInt(req.getParameter("superuser"));
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println(rno+" "+rname+" "+password+" "+superuser+" "+status);
		libraryDAO l = new libraryDAO();
		SelectDTO sdto = new SelectDTO();
		sdto.setRno(rno);
		sdto.setRname(rname);
		sdto.setPassword(password);
		sdto.setSuperuser(superuser);
		sdto.setStatus(status);
		boolean flag = l.UpdateReaderIfo(sdto);
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = l.FindAllReaderIfo();
		HttpSession s = req.getSession();
		s.setAttribute("AllReader", v);
		resp.sendRedirect("showAllReader.jsp");
	}
}
