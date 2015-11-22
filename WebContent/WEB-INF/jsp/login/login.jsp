<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="<%=basePath%>bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath%>bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/bootstrap.min.js"></script>

<title>登录界面</title>
<style>
.div-a {
	background: url(img/sky.jpg) no-repeat;
	width: 230px;
	padding: 10px;
}

.div-b {
	width: 300px;
	height: 350px;
	padding: 5px;
	margin-top: 150px;
	margin-left: 800px;
}

.img {
	width: 550px;
	height: 410px;
	margin-top: 150px;
	margin-left: 100px;
}
</style>

</head>
<body class="div-a">
	<div class="row">
		<div class="col-md-6">
			<div class="img">
				<img alt="山东建筑大学" src="<%=basePath%>img/jianzhu.jpg"
					class="img-circle"> <a
					href="http://rj.baidu.com/soft/detail/14744.html?ald"
					target="dialog"><font color="red">推荐使用chrome浏览器(点此下载)</font></a>
			</div>
		</div>
		<div class="col-md-6">
			<div class="div-b">
				<form class="form-signin" action="login.action"
					method="POST">
					<h1 style="font-family: '楷体'">硕士管理系统${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</h1>
					<font size="3" color="red">${info}</font>
					<div class="form-group">
						<label for="username">username</label> <input type="text"
							id="username" name="username" class="form-control"
							placeholder="请输入你的用户名" required autofocus>
					</div>
					<div class="form-group">
						<label for="password">password</label> <input type="password"
							id="password" name="password" class="form-control"
							placeholder="请输入你的密码" required>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>