package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// �жϵ�¼ҳ���Ȩ�ޣ����Ȩ��Ϊ1�����ȥ��admin.html��ҳ�棬����ȥȨ�޴����ҳ��authority.html
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession(); // ȡֵ����HttpServletRequest������
		Integer supervalue2 = (Integer) session.getAttribute("supervalue1");
		System.out.println("���3-------" + supervalue2);		
		if (supervalue2 != null) // supervalue1Ҫ�����Integer�ſ��������ӵ��ã���������int�ᱨ��
		{
			if (supervalue2 == 0) // ��¼����
			{
				System.out.println("��¼����Ȩ��Ϊ0");
				resp.sendRedirect(req.getContextPath() + "/index.html");
			}				
			else 
				if (supervalue2 == 1){
					arg2.doFilter(arg0, arg1); // ����һ�����ݣ����û����һ����ֱ�ӵ�����Դ(��������ȥ�ľ�ȥ��)				
				}		
			    else{
					resp.sendRedirect(req.getContextPath()+ "/authority.jsp");
			    }			    	
		}else {
			System.out.println("��û�е�¼��Ȩ��Ϊ��");
			resp.sendRedirect(req.getContextPath() + "/index.html");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
