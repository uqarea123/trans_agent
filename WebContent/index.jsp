<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

</head>
<body>

	<form action="${pageContext.request.contextPath }/user/addUser.do" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="提交"/></td>
				<td><input type="reset" name="重置"/></td>
			</tr>


		</table>
	</form>
</body>
</html>