package cn.edu.lingnan.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesTest extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//	---------------------ҳ��-------------------------------------------
		String name = req.getParameter("cookieName");   //�ӿͻ��˻�ȡcookieName���Ե�ֵ
		if(name != null && name.length() > 0){
			String value = req.getParameter("cookieValue");
			Cookie c = new Cookie(name,value);
			c.setMaxAge(3600);   //����ʧЧʱ��Ϊ3600��
			resp.addCookie(c);
		}
//	---------------------����-------------------------------------------
		resp.setContentType("text/html");
		java.io.PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();   //��ȡ���������е�Cookie����Ϣ
		out.println("<html>");
		out.println("<head><title>Servlet Cookie Information</title></head>");
		out.println("body");
		if((cookies == null) || (cookies.length == 0)){
			out.println("No cookies found");
		}else{
			out.println("<table>");
			out.println("<tr><td>Name</td><td>Value</td></tr>");  //<tr>ָ�У�<td>ָ��
			for(int i = 0;i < cookies.length;i++){
				Cookie c = cookies[i];
				out.println("<tr><td>"+c.getName()+"</td>");
				out.println("<td>"+c.getValue()+"</td></tr>");
			}
			out.println("</table>");
		}
//	--------------�����µ�Cookie��ֵ������submit��ť��ѭ�����������ҳ��-----------------	
		out.println("<form action=\"cookiesTest\" method=Get>");
		out.println("Name :<input type=text length=20 name=\"cookieName\">");
		out.println("<br><p>");
		out.println("Value :<input type=text length=20 name=\"cookieValue\">");
		out.println("<br><p>");
		out.println("<input type=\"submit\" values=\"submit\"</form>");
		out.println("</body");
		out.println("</html>");
		out.flush();
		
	}

}
