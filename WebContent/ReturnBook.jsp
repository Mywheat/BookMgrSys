<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�����¼</title>
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
<form action="bookReturn">
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<tr>
					<th>�û����</th>
					<th>�鼮���</th>
					<th>����ʱ��</th>
					<th>����ʱ��</th>
					<th>״̬λ</th>
				</tr>
			</thead>

			<%
				Vector<SelectDTO> v = new Vector<SelectDTO>();
				v = (Vector<SelectDTO>) session.getAttribute("returnbook");
				Iterator it = v.iterator();
				SelectDTO sdto = null;
				while (it.hasNext()) {
					sdto = (SelectDTO) it.next();
			%>
			<tbody>
				<tr>
					<td><%=sdto.getRno()%></td>
					<td><%=sdto.getNumber()%></td>
					<td><%=sdto.getLendDate()%></td>
					<td><%=sdto.getReturnDate()%></td>
					<td><%=sdto.getStatus()%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
	</div>
	</form>
</body>
</html>