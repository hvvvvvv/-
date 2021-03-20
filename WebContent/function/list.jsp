<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
A:link {
FONT-SIZE: 18px; COLOR: #272727; TEXT-DECORATION: none
}
A:visited {
FONT-SIZE: 18px; COLOR:  #272727; TEXT-DECORATION: none
}
A:active {
FONT-SIZE: 18px; COLOR:  #272727; TEXT-DECORATION: none
}
A:hover {
FONT-SIZE: 18px; COLOR:  #272727; TEXT-DECORATION: none
}
</style>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理人员界面</title>
</head>

<body bgcolor="#CECEFF">
<br><br><br><br><br><br>
	<table width="75%" align="center" border="1px" cellpadding="0px" cellspacing="0px">
		<tr>
			<th>账号</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>
				<a href="preUpdate?name=${user.username}" style="text-decoration:none">修改</a> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				 <a href="delete?name=${user.username}" onclick="return confirm('确定要删除吗?');" style="text-decoration:none">删除</a>
				 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				 <a href="insert.jsp" style="text-decoration:none">增加</a> 
				 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				 <a href="reset.jsp"style="text-decoration:none">重置密码</a>
				 </td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
