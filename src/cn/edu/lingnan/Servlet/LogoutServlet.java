package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.libraryDAO;
import cn.edu.lingnan.dto.SelectDTO;

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		s.invalidate();   //ע����session��ʹ����һ�������û�
		System.out.println("���û��Ѿ�ע���˹�������������");
		resp.sendRedirect(req.getContextPath() + "/index.html"); // req.getContextPath()ȡOK.html�Ĺ���·��
	}
}
