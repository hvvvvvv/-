<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<br><br><br><br><br>
<center><h2>(说明：如果该目录下有两篇文章，请按照页面展示顺序编号)</h2></center>
<br>
	<div align="center">
		<form action="upload_txt" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><h3>文件编号：</h3></td>
					<td><input id="name" type="text" name="name">
					</td>
				</tr>
				<tr>
					<td><h3>选择上传的txt文件</h3></td>
					<td><input id="file1" type="file" name="message">
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
 <!-- 文件名称<input type="text" name="name">
信息请以txt文件上传<input type="file" name="message">
<input type="submit" value="提交">-->
</body>
</html>