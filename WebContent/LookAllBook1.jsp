<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>普通用户查看书籍</title>
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<tr>
					<th>书籍编号</th>
					<th>书籍名称</th>
					<th>书籍作者</th>
					<th>出版社</th>
					<th>出版时间</th>
					<th>是否可借</th>
					<th>状态位</th>
					<th>借书</th>
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
						type="submit" value="确定借书"></a></td>
				</tr>
			</tbody>
			<%
					}
				%>
		</table>
	</div>
</body>
</html>