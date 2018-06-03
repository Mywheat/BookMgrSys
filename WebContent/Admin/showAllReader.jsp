<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�û�����ҳ��</title>
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
		var checkObj = document.getElementsByName("check");//�ҳ�������Ϊ"check"�ĸ�ѡ��
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = true; //�ø�ѡ���еı�ѡ�е�ֵΪtrue
	}

	function nocheck() {
		var checkObj = document.getElementsByName("check");
		for (var i = 0; i < checkObj.length; i++)
			checkObj[i].checked = false; //�ø�ѡ���еı�ѡ�е�ֵΪfalse
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
		var arr = []; //����arr����
		var flag = false;
		for (var i = 0; i < checkObj.length; i++) {
			if (checkObj[i].checked == true) {
				arr.push(checkObj[i].value);
				flag = true;
			}
		}
		alert(arr);
		if (flag) {
			if (confirm("��ȷ��Ҫɾ����Щ��¼��?"))
				location.href = "deleteReaderCheckServlet?arr=" + arr; //����servlet			
		} else
			alert("����Ҫѡ��һ����¼���ܽ�������ɾ��...");

	}
	
	function insert(){
		location.href = "insertReaderIfo.jsp";
	}
	
</script>

</head>
<body>

	<div class="x-body">
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" name="" value=""></th>
					<th>�û����</th>
					<th>�û�����</th>
					<th>�û�����</th>
					<th>�û�Ȩ��</th>
					<th>״̬λ</th>
					<th>ѡ�����</th>
				</tr>
			</thead>
			<%
				Vector<SelectDTO> v = new Vector<SelectDTO>();
				v = (Vector<SelectDTO>) session.getAttribute("AllReader");
				Iterator it = v.iterator();
				SelectDTO sdto = null;
				while (it.hasNext()) {
					sdto = (SelectDTO) it.next();
			%>
			<tbody>
				<tr>
					<td><input type="checkbox" name="check"
						value=<%=sdto.getRno()%>></td>
					<td><%=sdto.getRno()%></td>
					<td><%=sdto.getRname()%></td>
					<td><%=sdto.getPassword()%></td>
					<td><%=sdto.getSuperuser()%></td>
					<td><%=sdto.getStatus()%></td>
					<td class="td-manage"><a title="�޸�"
						href="updateReaderIfo.jsp?rno=<%=sdto.getRno()%>" class="ml-5"
						style="text-decoration: none"> <i class="layui-icon">&#xe642;</i>
					</a><a title="ɾ��" href="deleteReaderServlet?rno=<%=sdto.getRno()%> "
						style="text-decoration: none"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>

		<button class="layui-btn layui-btn-danger" id="btn1"
			onClick="allcheck();">
			<i class="layui-icon"></i>ȫѡ
		</button>
		<button class="layui-btn layui-btn-danger" id="btn2"
			onClick="nocheck();">
			<i class="layui-icon"></i>��ѡ
		</button>
		<button class="layui-btn layui-btn-danger" id="btn3"
			onClick="backcheck();">
			<i class="layui-icon"></i>��ѡ
		</button>
		<button class="layui-btn layui-btn-danger" onClick="insert();">
			<i class="layui-icon"></i>���
		</button>
		<button class="layui-btn layui-btn-danger" onClick="allDelete();">
			<i class="layui-icon">&#xe640;</i>����ɾ��
		</button>

		<a href="admin.html" class="layui-btn layui-btn-danger">������ҳ</a>

	</div>

</body>
</html>