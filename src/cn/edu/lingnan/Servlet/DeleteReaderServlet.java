package cn.edu.lingnan.Servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class DeleteReaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		libraryDAO l = new libraryDAO();
		String rno = req.getParameter("rno");
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		boolean flag = l.DeleteReaderByRno(rno);
		if(flag){
			JOptionPane.showMessageDialog(null,"»Ì…æ≥˝≥…π¶£°");
			HttpSession s = req.getSession();
			v = l.FindAllReaderIfo();
			s.setAttribute("AllReader", v);
			resp.sendRedirect("showAllReader.jsp");
		}else{
			JOptionPane.showMessageDialog(null,"»Ì…æ≥˝ ß∞‹£°");
			resp.sendRedirect("showAllReader.jsp");
		}
		
	}
}
