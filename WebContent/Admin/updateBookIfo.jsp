<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�޸��鼮��Ϣ��ҳ��</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>
	<form action="updateBookServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>�鼮���</th>
						<th>�鼮����</th>
						<th>�鼮����</th>
						<th>������</th>
						<th>��������</th>
						<th>�Ƿ�ɽ�</th>
						<th>״̬λ</th>
						<th>ѡ�����</th>
					</tr>
				</thead>
				<%
					String number = request.getParameter("number");
					Vector<SelectDTO> v = new Vector<SelectDTO>();
					v = (Vector<SelectDTO>) session.getAttribute("AllBook");
					Iterator it = v.iterator();
					SelectDTO sdto = null;
					while (it.hasNext()) {
						sdto = (SelectDTO) it.next();
						if ((sdto.getNumber()).equalsIgnoreCase(number)) {
				%>

				<tbody>
					<tr>
						<!-- ������rno�޸� -->
						<td><input style="width: 125px" type="text" readOnly="true" name="number"
							value=<%=sdto.getNumber()%>></td>
						<td><input style="width: 125px" type="text" name="bname"
							value=<%=sdto.getBname()%>></td>
						<td><input style="width: 125px" type="text" name="author"
							value=<%=sdto.getAuthor()%>></td>
						<td><input style="width: 125px" type="text" name="bookpub"
							value=<%=sdto.getBookpub()%>></td>
						<td><input style="width: 125px" type="text" name="bookpubdate"
							value=<%=sdto.getBookpubdate()%>></td>
						<td><input style="width: 125px" type="text" readOnly="true" name="booklend"
							value=<%=sdto.getBooklend()%>></td>
						<td><input style="width: 125px" type="text" name="status"
							value=<%=sdto.getStatus()%>></td>
						<td><input style="width: 125px" type="submit" value="ȷ���޸�"></td>
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