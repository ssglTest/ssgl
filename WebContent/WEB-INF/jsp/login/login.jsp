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
<script type="text/javascript">
		$(document).ready(function(){
			$("#submit").click(function(){
				var checkCode=$.trim($("#veritionCode").val());
				var info = $("#info");
				if(checkCode==''){
					info.html("验证码不能为空");
					$("#veritionCode").focus();
					return false;
				}else{
					$(this).submit();
				}
			});
		});
	</script>
<!-- 验证码 -->
<script type="text/javascript">
		$("#checkImage").click(function(){
			changCode();
		});
		
		function changCode(){
			var checkImage = $("#checkImage");
			checkImage.hide();
			checkImage.prop("src", "<%=basePath%>kaptcha/getKaptchaImage.html?id="+ Math.random()).fadeIn();
		event.cancelBubble = true;
	}
</script>
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
	margin-top: 120px;
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
				<form class="form-signin" action="login.action" method="POST">
					<h1 style="font-family: '楷体'">硕士管理系统</h1>
					<font id="info" size="3" color="red">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}&nbsp;${info}</font>
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
					<div class="form-group">
						<div class="row">
						<div class="col-md-5"><p>
								验证码：<span><input style="width:45px" type="text" name="verifitcaionCode"
									id="veritionCode" maxlength="4" autocomplete="off" /></span>
									
							</p></div>
						<div class="col-md-7"><p style="margin-left: 6px">
								<span id="checkImgSpan"> <img style="width:70px;height:30px;" alt="验证码"
									src="<%=basePath%>kaptcha/getKaptchaImage.html" id="checkImage" />
									<a style="width:70px;" class="btn btn-default" onclick="changCode()">换一张？</a>
								</span>
							</p></div>
							
							
						</div>

					</div>
					<button id="submit" class="btn btn-lg btn-primary btn-block"
						type="submit">登录</button>
					<button class="btn btn-lg btn-info btn-block" type="reset">重置</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>