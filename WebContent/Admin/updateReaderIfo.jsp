<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>修改读者信息的页面</title>
</head>
<body>
	<form action="updateReaderServlet">
		<table border=1>
			<tr>
				<td>rno</td>
				<td>rname</td>
				<td>password</td>
				<td>superuser</td>
				<td>status</td>
				<td></td>
			</tr>
			<%
			String rno = request.getParameter("rno");
			Vector<SelectDTO> v = new Vector<SelectDTO>();
			v = (Vector<SelectDTO>) session.getAttribute("AllReader");
			Iterator it = v.iterator();
			SelectDTO sdto = null;
			while (it.hasNext()) {
				sdto = (SelectDTO) it.next();
				if((sdto.getRno()).equalsIgnoreCase(rno))
				{
		%>
			<tr><!-- 不允许rno修改 -->
				<td><input type="text" readOnly="true" name="rno"
				    value=<%=sdto.getRno()%>></td>
				<td><input type="text" name="rname"
				    value=<%=sdto.getRname()%>></td>
				<td><input type="text" name="password"
					value=<%=sdto.getPassword()%>></td>
				<td><input type="text" name="superuser"
					value=<%=sdto.getSuperuser()%>></td>
				<td><input type="text" name="status"
					value=<%=sdto.getStatus()%>></td>
				<td><input type="submit" value="确认修改"></td>
			</tr>
			<%
			}}
		%>
		</table>
	</form>
</body>
</html> 