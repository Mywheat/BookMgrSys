<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>������ļ�¼</title>
<link rel="stylesheet" href="./css1/x-admin.css" media="all">
</head>

<script  language="javascript">
function check(){
var regm = /^[n]+[u]+[l]+[l]?$/;
	if(!form.returnDate.value.match(regm)){
		alert("returnDateֻ�ܲ���null������������null...");
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
						<th>�û����</th>
						<th>�鼮���</th>
						<th>����ʱ��</th>
						<th>����ʱ��</th>
						<th>״̬λ</th>
						<th>ѡ�����</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input style="width: 125px" type="text" name="rno"></td>
						<td><input style="width: 125px" type="text" name="number"></td>
						<td><input style="width: 125px" type="text" name="lendDate"></td>
						<td><input style="width: 125px" type="text" id="returnDate" name="returnDate"></td>
						<td><input style="width: 125px" type="text" name="status"></td>
						<td><input style="width: 125px" type="submit" value="ȷ����� " onClick="return check();"></td>
					</tr>
				</tbody>
			</table>
	</form>
</body>
</html>