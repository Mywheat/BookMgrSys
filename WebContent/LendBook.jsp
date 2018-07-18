<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>借书页面</title>
<link rel="stylesheet" href="./css/x-admin.css" media="all">

</head>
<body>
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户编号</th>
						<th>书籍编号</th>
						<th>借书时间</th>
						<th>还书时间</th>
						<th>状态位</th>
						<th>还书</th>
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
						<td><%=sdto.getRno()%></td>
						<td><%=sdto.getNumber()%></td>
						<td><%=sdto.getLendDate()%></td>
						<td><%=sdto.getReturnDate()%></td>
						<td><%=sdto.getStatus()%></td>
						<td><a
							href="returnBook?rno=<%=sdto.getRno()%>&&number=<%=sdto.getNumber()%>&&lendDate=<%=sdto.getLendDate()%>"><input
								type="submit" value="确定还书"></a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
</body>
</html>