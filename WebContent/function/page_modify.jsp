<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>内容更新页面</title>
</head>
<body bgcolor="CECEFF">
请在这个表单上选择要实现的功能：更新或者删除或者添加
<form entype="multipart/form-data" action="" method="post">
<select name="function">
<option value="updata">updata</option>
<option value="del">del</option>
<option value="add">add</option>
</select>
<br>
<br>
请在这个表单中选择要操作的模块：
<select name="object">
<option value="中心概况" name="中心概况">中心概况</option>
<option value="课程列表" name="课程列表">课程列表</option>
<option value="教学模式" name="教学模式">教学模式</option>
<option value="教资队伍" name="教资队伍">教资队伍</option>
<option value="版权归属" name="版权归属">版权归属</option>
<option value="管理制度" name="管理制度">管理制度</option>
<option value="机构介绍" name="机构介绍">机构介绍</option>
<option value="设备环境" name="设备环境">设备环境</option>
<option value="成果展示" name="成果展示">成果展示</option>
</select>
<br><br>
编辑模块：
<br>
<textarea rows="10" cols="10" name="message"></textarea>
<input type="file" name="img">
<input type="submit" value="提交" name="submit">
</form>
</body>
</html>