<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>

<!DOCTYPE html>
<html>
<head>
<title>登录界面</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="../images/校门.jpg" height="100%" width="100%"/>    
</div> 
<br><br><br>
 
<form action="login" method="post">

<center>用户名:<input type="text" name="username" id="username" ></center>
<br>
<br>
<center>密&nbsp&nbsp码:<input type="password" name="password" id="password"></center>
<br>
<center> <input  type="reset" value="重置"></center>
<br>
<br>
<center><input type="submit" name="submit" value="登录"></center>
</form>
</body>
</html>