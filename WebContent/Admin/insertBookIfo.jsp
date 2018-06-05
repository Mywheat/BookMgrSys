<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>插入书籍信息</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>

	<form action="insertBookServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>书籍编号</th>
						<th>书籍名称</th>
						<th>书籍作者</th>
						<th>出版社</th>
						<th>出版日期</th>
						<th>是否可借</th>
						<th>状态位</th>
						<th>选择操作</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input style="width:100px" type="text" name="number"></td>
						<td><input style="width:100px" type="text" name="bname"></td>
						<td><input style="width:100px" type="text" name="author"></td>
						<td><input style="width:100px" type="text" name="bookpub"></td>
						<td><input style="width:100px" type="text" name="bookpubdate"></td>
						<td><input style="width:100px" type="text" name="booklend"></td>
						<td><input style="width:100px" type="text" name="status"></td>
						<td><input style="width:100px" type="submit" value="确认添加"></td>
					</tr>
				</tbody>
			</table>
	</form>

</body>
</html>