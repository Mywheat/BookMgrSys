<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>插入用户信息</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>
<body>

	<form action="insertReaderServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户编号</th>
						<th>用户名称</th>
						<th>用户密码</th>
						<th>用户权限</th>
						<th>状态位</th>
						<th>选择操作</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input style="width: 125px" type="text" name="rno"></td>
						<td><input style="width: 125px" type="text" name="rname"></td>
						<td><input style="width: 125px" type="text" name="password"></td>
						<td><input style="width: 125px" type="text" name="superuser"></td>
						<td><input style="width: 125px" type="text" name="status"></td>
						<td><input style="width: 125px" type="submit" value="确认添加"></td>
					</tr>
				</tbody>
			</table>
	</form>

</body>
</html>