<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb312">
</head>
<body>
<br><br><br><br><br>
<center><h2>（说明:如果您将要上传的页面有四张图片,请按照从上到下,从左到右的顺序编号）</h2></center>
<br>
	<div align="center">
		<form action="upload_img" method="post"  enctype="multipart/form-data">
			<table>
				<tr>
					<td><h3>图片名称：</h3></td>
					<td><input id="name" type="text" name="name">
					</td>
				</tr>
				<tr>
					<td><h3>选择上传的图片</h3></td>
					<td><input id="file1" type="file" name="img">
					</td>
				</tr>				
				<tr>
					<td align="center" colspan="2">
					<input id="button" type="submit" value="上传"> 
						<!--  <a id="a" href="centerOverviewShow_img.jsp">查看上传图片</a>-->
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>