<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ͨ�û��鿴�鼮</title>
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<tr>
					<th>�鼮���</th>
					<th>�鼮����</th>
					<th>�鼮����</th>
					<th>������</th>
					<th>����ʱ��</th>
					<th>�Ƿ�ɽ�</th>
					<th>״̬λ</th>
					<th>����</th>
				</tr>
			</thead>

			<%
					Vector<SelectDTO> v = new Vector<SelectDTO>();
					v = (Vector<SelectDTO>) session.getAttribute("AllBook");
					Iterator it = v.iterator();
					SelectDTO sdto = null;
					while (it.hasNext()) {
						sdto = (SelectDTO) it.next();
				%>
			<tbody>
				<tr>
					<td><%=sdto.getNumber()%></td>
					<td><%=sdto.getBname()%></td>
					<td><%=sdto.getAuthor()%></td>
					<td><%=sdto.getBookpub()%></td>
					<td><%=sdto.getBookpubdate()%></td>
					<td><%=sdto.getBooklend()%></td>
					<td><%=sdto.getStatus()%></td>
					<td><a href="lendBook?number=<%=sdto.getNumber()%>"><input
						type="submit" value="ȷ������"></a></td>
				</tr>
			</tbody>
			<%
					}
				%>
		</table>
	</div>
</body>
</html>