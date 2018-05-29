<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>全部读者信息的页面</title>
<script>
function allcheck(){
	 var checkObj = document.getElementsByName("check");//找出所有名为"check"的复选框
	for(var i=0;i<checkObj.length;i++)
		checkObj[i].checked = true;  //让复选框中的被选中的值为true
}

function nocheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0;i<checkObj.length;i++)
		checkObj[i].checked = false;  //让复选框中的被选中的值为false
}

function backcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0;i<checkObj.length;i++)
		if(checkObj[i].checked)
			checkObj[i].checked = false;
		else
			checkObj[i].checked = true;
		
}

function allDelete(){
	var checkObj = document.getElementsByName("check");
	var arr = []; //定义arr数组
	var flag = false;
	for(var i=0;i<checkObj.length;i++){
		if(checkObj[i].checked == true){
			arr.push(checkObj[i].value);
			flag = true;
		}		
	}
	alert(arr);
	if(flag){
		if(confirm("你确定要删除这些记录吗?"))
			location.href="deleteCheckServlet?arr="+arr; //调用servlet			
	}
	else
		alert("至少要选择一条记录才能进行批量删除...");
	
}
</script>
</head>
<body>
	<table border=1>
		<tr>
			<td></td>
			<td>rno</td>
			<td>rname</td>
			<td>password</td>
			<td>superuser</td>
			<td>status</td>
			<td>what to do</td>
		</tr>
		<%
			Vector<SelectDTO> v = new Vector<SelectDTO>();
			v = (Vector<SelectDTO>) session.getAttribute("AllReader");
			Iterator it = v.iterator();
			SelectDTO sdto = null;
			while (it.hasNext()) {
				sdto = (SelectDTO) it.next();
		%>
		<tr>
			<td><input type="checkbox" name="check" value=<%=sdto.getRno()%>></td>
			<td><%=sdto.getRno()%></td>
			<td><%=sdto.getRname()%></td>
			<td><%=sdto.getPassword()%></td>
			<td><%=sdto.getSuperuser()%></td>
			<td><%=sdto.getStatus()%></td>
			<td><a href="updateReaderIfo.jsp?rno=<%=sdto.getRno()%>">修改</a> 
			    <a href="deleteReaderServlet?rno=<%=sdto.getRno()%> ">删除</a>
		    </td>
		</tr>
		<%
			}
		%>
	</table>
	<input type="button" id="btn1" value="全选" onClick="allcheck();"/>
	<input type="button" id="btn2" value="不选" onClick="nocheck();"/>
	<input type="button" id="btn3" value="反选" onClick="backcheck();"/>
	<input type="button" value="批量删除" onClick="allDelete();"/>
</body>
</html>