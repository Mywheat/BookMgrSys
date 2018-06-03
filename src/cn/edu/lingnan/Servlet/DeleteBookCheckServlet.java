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

public class DeleteBookCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		libraryDAO l = new libraryDAO();
		String[] arr1 = req.getParameterValues("arr");
		for(String a : arr1){
			String[] b = a.split(",");   //用","对数组a进行分割
			for(String c : b)
				l.DeleteBookByNumber(c);
		}
		
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = l.FindAllBookIfo();
		HttpSession s = req.getSession();
		s.setAttribute("AllBook", v);
		resp.sendRedirect("showAllBook.jsp");		
	}
}
