<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�޸Ľ��ļ�¼</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>
	<form action="updateLend_returnServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>�û����</th>
						<th>�鼮���</th>
						<th>����ʱ��</th>
						<th>����ʱ��</th>
						<th>״̬λ</th>
						<th>ѡ�����</th>
					</tr>
				</thead>
				<%
					String rno = request.getParameter("rno");
					String number = request.getParameter("number");
					String lendDate = request.getParameter("lendDate");
					Vector<SelectDTO> v = new Vector<SelectDTO>();
					v = (Vector<SelectDTO>) session.getAttribute("Lend_return");
					Iterator it = v.iterator();
					SelectDTO sdto = null;
					while (it.hasNext()) {
						sdto = (SelectDTO) it.next();
						if ((sdto.getRno()).equalsIgnoreCase(rno)
								&& (sdto.getNumber()).equalsIgnoreCase(number)
								&& (sdto.getLendDate()).equalsIgnoreCase(lendDate)) {
				%>

				<tbody>
					<tr>
						<td><input type="text" readOnly="true" name="rno"
							value=<%=sdto.getRno()%>></td>
						<td><input type="text" readOnly="true" name="number"
							value=<%=sdto.getNumber()%>></td>
						<td><input type="text" readOnly="true" name="lendDate"
							value=<%=sdto.getLendDate()%>></td>
						<td><input type="text" name="returnDate"
							value=<%=sdto.getReturnDate()%>></td>
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
		</div>
	</form>

</body>
</html>