<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�޸Ķ�����Ϣ��ҳ��</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>
	<form action="updateReaderServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>�û����</th>
						<th>�û�����</th>
						<th>�û�����</th>
						<th>�û�Ȩ��</th>
						<th>״̬λ</th>
						<th>ѡ�����</th>
					</tr>
				</thead>
				<%
					String rno = request.getParameter("rno");
					Vector<SelectDTO> v = new Vector<SelectDTO>();
					v = (Vector<SelectDTO>) session.getAttribute("AllReader");
					Iterator it = v.iterator();
					SelectDTO sdto = null;
					while (it.hasNext()) {
						sdto = (SelectDTO) it.next();
						if ((sdto.getRno()).equalsIgnoreCase(rno)) {
				%>

				<tbody>
					<tr>
						<!-- ������rno�޸� -->
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
						<td><input type="submit" value="ȷ���޸�"></td>
					</tr>
				</tbody>


				<%
					}
					}
				%>
			</table>
	</form>
</body>
</html>
