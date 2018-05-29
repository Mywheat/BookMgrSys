<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ taglib uri="http://cn.edu.lingnan" prefix="aaa" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>JSP Tag Page</title>
</head>
<body>
   <aaa:TagExmple1/>
   <br>
   
   <c:set var="a" value="aaa"/>
<!-- <c:out value="${a}"/>  --> 
   <c:remove var="a"/>
   <c:out value="${a}"/>
   
   <c:catch var="error">
      <%=9/0 %>
   </c:catch>
   <c:out value="${error}"/><br>
   
   <%
   String[] str = new String[5];
   str[0] = "aaaaa";
   str[1] = "bbbbb";
   str[2] = "ccccc";
   str[3] = "ddddd";
   str[4] = "eeeee";
   request.setAttribute("str1", str);
   %>
   <c:out value="${str1[1]}"/><br>
   <c:if test="${str1[1]=='bbbbb'}">
      str[1] value is bbbbb 
   </c:if><br>
   <c:choose>
     <c:when test="${str1[1]=='bbcbb'}">
        str[1] value is bbcbb
     </c:when>
     <c:otherwise>
        str[1] value is bbbbb
     </c:otherwise>
   </c:choose>
   <br>
   <c:forEach var="b" items="${str1}">
   <c:out value="${b}"/>
   </c:forEach>
   <br>
   <c:forEach var="c" begin="1" end="5">
   <c:out value="${c}"/>
   </c:forEach>
   <br>
   <c:forTokens var="d" items="zhangsan,lisi,wangwu,zhaoliu" delims=",">
     <c:out value="${d}"/>
   </c:forTokens>
   <br>
   
<!--<a href = "<c:url value="http://qq.com"/>">
     This is the link of qq1
   </a>
 -->
 
   <c:url var="e" value="http://qq.com">
      <c:param name="rname" value="aaa"/>
   </c:url>
   <a href = "${e}">
      This is the link of qq2
   </a>
   <br>
   
<!--    <c:import url="/OK.html"/><br>  --> 
   <br><br><br>
   
   <sql:setDataSource
   driver = "com.mysql.jdbc.Driver"
   url = "jdbc:mysql://localhost:3306/library"
   user = "root"
   password = "666666"
   var = "f"
   />
   
   <sql:query var="result1" dataSource="${f}"
       sql="select * from reader"
   />
   <table border="1">
     <c:forEach var="g" items="${result1.rows}">
       <tr>
         <td><c:out value="${g.rno}"/></td>
         <td><c:out value="${g.rname}"/></td>
         <td><c:out value="${g.password}"/></td>
         <td><c:out value="${g.superuser}"/></td>
         <td><c:out value="${g.status}"/></td>
       </tr>
     </c:forEach>
   </table>
   <br>
   
   <sql:update dataSource="${f}"
       sql="update reader set superuser = '2' where rno = 'r04' "  
   />
   <table border="1">
     <c:forEach var="h" items="${result1.rows}">
       <tr>
         <td><c:out value="${h.rno}"/></td>
         <td><c:out value="${h.rname}"/></td>
         <td><c:out value="${h.password}"/></td>
         <td><c:out value="${h.superuser}"/></td>
         <td><c:out value="${h.status}"/></td>
       </tr>
     </c:forEach>
   </table>
   <br>
   
   
</body>
</html>