package cn.edu.lingnan.Servlet;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class DeleteLend_returnCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		libraryDAO l = new libraryDAO();
		String m = null;
		String n = null;
		String t = null;
		String[] arr1 = req.getParameterValues("arr");// 从showLend_return.jsp页面取得arr的值
		for (String a : arr1) {
			String[] b = a.split(","); 
				for(int i=0;i<b.length;i=i+3){
					m = b[i];
					n = b[i+1];
					t = b[i+2];
//					System.out.println(m);
//					System.out.println(n);
//					System.out.println(t);
					l.DeleteLend_return(m, n, t);
				}
				
			}
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		v = l.FindLend_return();
		HttpSession s = req.getSession();
		s.setAttribute("Lend_return", v);
		resp.sendRedirect("showLend_return.jsp");
		}
	}
