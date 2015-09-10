<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="bootstrap/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="bootstrap/jquery-1.11.3.min.js" ></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js" ></script>

<title>登录界面</title>
<style>
.div-a {
	background: url(img/sky.jpg) no-repeat;
	width: 230px;
	height: 136px;
	padding: 10px;
}

.div-b {
	width: 300px;
	height: 350px;
	padding: 5px;
	margin-top: 200px;
	margin-left: 900px;
}
</style>

</head>
<body class="div-a">

	<div class="div-b">
		<form class="form-signin" action="userContro/login.html" method="POST">
			<h2 class="form-signin-heading" >登录</h2>
				<font size="3" color="red">${message}</font>
			<div class="form-group">
				<label for="inputEmail">username</label> <input type="text"
					id="inputEmail" name="username" class="form-control" placeholder="请输入你的用户名"
					required autofocus>
			</div>
			<div class="form-group">
				<label for="inputPassword">password</label> <input type="password"
					id="inputPassword" name="password" class="form-control" placeholder="请输入你的密码"
					required>
			</div>
			<div class="form-group">
				<label for="usertype">User type</label> <select class="form-control"
					id="usertype" name="role">
					<option>student</option>
					<option>tutor</option>
					<option>teacher</option>
					<option>secretary</option>
				</select>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					记住密码
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
</body>
</html>