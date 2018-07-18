<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>插入借阅记录</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>

<script  language="javascript">
function check(){
var regm = /^[n]+[u]+[l]+[l]?$/;
	if(!form.returnDate.value.match(regm)){
		alert("returnDate只能插入null，请重新输入null...");
		form.returnDate.focus();
		return false;
	}
}
</script>

<body>
	<form name="form" action="insertLend_returnServlet">
		<div class="x-body">
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户编号</th>
						<th>书籍编号</th>
						<th>借书时间</th>
						<th>还书时间</th>
						<th>状态位</th>
						<th>选择操作</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input style="width: 125px" type="text" name="rno"></td>
						<td><input style="width: 125px" type="text" name="number"></td>
						<td><input style="width: 125px" type="text" name="lendDate"></td>
						<td><input style="width: 125px" type="text" id="returnDate" name="returnDate"></td>
						<td><input style="width: 125px" type="text" name="status"></td>
						<td><input style="width: 125px" type="submit" value="确认添加 " onClick="return check();"></td>
					</tr>
				</tbody>
			</table>
	</form>
</body>
</html>