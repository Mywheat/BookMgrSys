<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��ͨ�û�������Ϣ</title>
<link rel="stylesheet" href="./css/x-admin.css" media="all">
<script>
	function update() {
		if (confirm("��ȷ��Ҫ�޸���")) {
			location.href = "updateReader";
			alert("�޸ĳɹ�������");
		} else
			alert("�޸�ʧ�ܣ�����");
	}
</script>
</head>
<body>
	<form action="updateReader">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>�û����</th>
						<th>�û�����</th>
						<th>�û�����</th>
						<th>�û�Ȩ��</th>
						<th>״̬λ</th>
						<th>�޸�</th>
					</tr>
				</thead>
				<%
					Vector<SelectDTO> v = new Vector<SelectDTO>();
					v = (Vector<SelectDTO>) session.getAttribute("authority");
					Iterator it = v.iterator();
					SelectDTO sdto = null;
					while (it.hasNext()) {
						sdto = (SelectDTO) it.next();
				%>
				<tbody>
					<tr>
						<td><input type="text" readOnly="true" name="rno"
							value=<%=sdto.getRno()%>></td>
						<td><input type="text" name="rname"
							value=<%=sdto.getRname()%>></td>
						<td><input type="text" name="password"
							value=<%=sdto.getPassword()%>></td>
						<td><input type="text" readOnly="true" name="superuser"
							value=<%=sdto.getSuperuser()%>></td>
						<td><input type="text" readOnly="true" name="status"
							value=<%=sdto.getStatus()%>></td>
						<td><input type="submit" value="ȷ���޸�" Onclick="update();"></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
</body>
</html>