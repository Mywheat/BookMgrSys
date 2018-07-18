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

public class LookAllBook1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AuthorityDao a = new AuthorityDao();
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = a.LookAllBookIfo1();
		HttpSession s = req.getSession();
		s.setAttribute("AllBook", v);
		resp.sendRedirect("LookAllBook1.jsp");
	}
}
