package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;

public class LoginServlet extends HttpServlet {

	//���д�ҳ�洫�����Ĳ�������req����
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.��ҳ���ȡ������Ҫ������
		String rname = null;
		String password = null;
		req.setCharacterEncoding("utf-8");	
		rname = req.getParameter("rname");		
		password = req.getParameter("password");
		System.out.println("1."+rname+" "+password);
		
		//2.���ú�̨��ҵ���߼��ж��û����������Ƿ��������֮���Ӧ
		libraryDAO l = new libraryDAO();
		int supervalue = l.FindReaderByUsernameAndPassword(rname, password);
		System.out.println("���2------"+supervalue);
		HttpSession session = req.getSession();
		session.setAttribute("supervalue1", supervalue);	
		//3.���ݽ���ҵ���Ӧ��ҳ��
		if(supervalue != 0)
			resp.sendRedirect(req.getContextPath()+"/OK.html");  //req.getContextPath()ȡOK.html�Ĺ���·��
		else
			resp.sendRedirect(req.getContextPath()+"/Error.html");
			
	}
}
