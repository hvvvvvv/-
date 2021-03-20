<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- 增加注册jsp insert.jsp -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor="#CECEFF">

<br><br><br><br><br><br><br><br><br><br>
<center><h2>请输入账号：</h2></center>
<br><br>
<form action="insert" method="post">
	<center><input type="text" name="username" value="username" placeholder="账号" style="width:300px;height:30px"/><br/></center>
<!--  		<input type="text" name="password" value="password" placeholder="密码"/><br/> -->
<br><br><br><br>
		<center><input type="submit" value="注册" style="height:30px;width:100px"/><br/></center>
	</form>
</body>
</html>
