<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ȫ��������Ϣ��ҳ��</title>
<script>
function allcheck(){
	 var checkObj = document.getElementsByName("check");//�ҳ�������Ϊ"check"�ĸ�ѡ��
	for(var i=0;i<checkObj.length;i++)
		checkObj[i].checked = true;  //�ø�ѡ���еı�ѡ�е�ֵΪtrue
}

function nocheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0;i<checkObj.length;i++)
		checkObj[i].checked = false;  //�ø�ѡ���еı�ѡ�е�ֵΪfalse
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
	var arr = []; //����arr����
	var flag = false;
	for(var i=0;i<checkObj.length;i++){
		if(checkObj[i].checked == true){
			arr.push(checkObj[i].value);
			flag = true;
		}		
	}
	alert(arr);
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��?"))
			location.href="deleteCheckServlet?arr="+arr; //����servlet			
	}
	else
		alert("����Ҫѡ��һ����¼���ܽ�������ɾ��...");
	
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
			<td><a href="updateReaderIfo.jsp?rno=<%=sdto.getRno()%>">�޸�</a> 
			    <a href="deleteReaderServlet?rno=<%=sdto.getRno()%> ">ɾ��</a>
		    </td>
		</tr>
		<%
			}
		%>
	</table>
	<input type="button" id="btn1" value="ȫѡ" onClick="allcheck();"/>
	<input type="button" id="btn2" value="��ѡ" onClick="nocheck();"/>
	<input type="button" id="btn3" value="��ѡ" onClick="backcheck();"/>
	<input type="button" value="����ɾ��" onClick="allDelete();"/>
</body>
</html>