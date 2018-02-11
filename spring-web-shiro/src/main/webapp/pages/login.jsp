<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Demo登录页面</h2>
	<h3>Demo登录</h3>
	<form action="/loginUser" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" value="luopc"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" value="123456"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">登录</button></td>
			</tr>
		</table>
	</form>

</body>
</html>