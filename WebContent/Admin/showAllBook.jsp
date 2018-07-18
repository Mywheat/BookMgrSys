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

<script>
	function allcheck() {
		var checkObj = document.getElementsByName("check");//找出所有名为"check"的复选框
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = true; //让复选框中的被选中的值为true
	}

	function nocheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = false; //让复选框中的被选中的值为false
	}

	function backcheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++)
			if (checkObj[i].checked)
				checkObj[i].checked = false;
			else
				checkObj[i].checked = true;

	}

	function allDelete() {
		var checkObj = document.getElementsByName("check");
		var arr = []; //定义arr数组
		var flag = false;
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				arr.push(checkObj[i].value);
				flag = true;
			}
		}
		alert(arr);
		if (flag) {
			if (confirm("你确定要删除这些记录吗?"))
				location.href = "deleteBookCheckServlet?arr=" + arr; //调用servlet			
		} else
			alert("至少要选择一条记录才能进行批量删除...");
	}
	
	function insert() {
		location.href = "insertBookIfo.jsp";
	}
</script>

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
					<td><a href="updateBookIfo.jsp?number=<%=sdto.getNumber()%>">
							<input type="button" value="修改">
					</a> <a href="deleteBookServlet?number=<%=sdto.getNumber()%>"><input
							type="button" value="删除"></a></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
		<button class="layui-btn layui-btn-danger" id="btn1"
			onClick="allcheck();">
			<i class="layui-icon"></i>全选
		</button>
		<button class="layui-btn layui-btn-danger" id="btn2"
			onClick="nocheck();">
			<i class="layui-icon"></i>不选
		</button>
		<button class="layui-btn layui-btn-danger" id="btn3"
			onClick="backcheck();">
			<i class="layui-icon"></i>反选
		</button>
		<button class="layui-btn layui-btn-danger" onClick="insert();">
			<i class="layui-icon"></i>添加
		</button>
		<button class="layui-btn layui-btn-danger" onClick="allDelete();">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>

		<a href="admin.jsp" class="layui-btn layui-btn-danger">返回上页</a>

	</div>
</body>
</html>