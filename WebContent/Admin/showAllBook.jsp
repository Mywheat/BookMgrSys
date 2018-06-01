<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Show All Book</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>
	<div class="x-body">
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" name="" value=""></th>
					<th>书籍编号</th>
					<th>书籍名称</th>
					<th>书籍作者</th>
					<th>出版社</th>
					<th>出版时间</th>
					<th>是否可借</th>
					<th>状态位</th>
					<th>选择操作</th>
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
					<td><input type="checkbox" name="check"
						value=<%=sdto.getNumber()%>></td>
					<td><%=sdto.getNumber()%></td>
					<td><%=sdto.getBname()%></td>
					<td><%=sdto.getAuthor()%></td>
					<td><%=sdto.getBookpub()%></td>
					<td><%=sdto.getBookpubdate()%></td>
					<td><%=sdto.getBooklend()%></td>
					<td><%=sdto.getStatus()%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
</body>
</html>