<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
function Mycheck(){
	if(from.user_Name.value==""){
		alert("请输入用户名！");
		from.user_Name.focus();
		return false;
	}
	if(from.pwd.value==""){
		alert("请输入登录密码！");
		from.pwd.focus();
		return false;
	}
	form.submit();
}
</script>
<body>
<div class="easyui-window" data-options="width:300,height:170,title:'登录'">
<form  name="from"action="login.do" method="post" onSubmit="return Mycheck()">
<table align="center">
<tr><td>登录名：</td><td><input type="text" name="user_Name"></td></tr>
<tr><td>密码：</td><td><input type="password" name="pwd"></td></tr>
<tr><td><a href="#">忘记密码</a></td>
<tr><td colspan="2" align="center"><input type="submit" value="登录"></td></tr>
</table>
</form>
</div>
</body>
</html>