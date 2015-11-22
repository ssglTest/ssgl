<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link type="text/css" href="../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link href="styles/font-awesome.min.css" rel="stylesheet" /> -->
<link type="text/css" href="<%=basePath%>bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script>
	$(function() {
		$(".btn").click(function() {
			$(this).button('loading').delay(1000).queue(function() {
				// $(this).button('reset');
			});
		});
	});
</script>

<title>硕士管理系统</title>


</head>
<body style="background: #EEE9E9">
	
	<script type="text/javascript" src="<%=basePath %>bootstrap/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap.min.js"></script>
	<div class="container">
		<div class="jumbotron" style="background: #337ab7">
			<!-- RGB颜色参考http://tool.oschina.net/commons?type=3 -->
			<div class="row">
				<div class="col-md-2">
					<img alt="山东建筑大学图标" src="<%=basePath %>img/logo_login.png" width="100"
						height="100">
				</div>
				<div class="col-md-10">
					<h2 style="font-family: '楷体'">
						<font color="white">硕士管理系统</font>
					</h2>
					<p>
						<font color="white">山东建筑大学非全日制硕士生管理系统</font>
					</p>
				</div>
			</div>
			<div align="right">
				<div class="row">
					<div class="col-md-11">
						<h3>
							<span class="lable lable-default">当前用户：</span>${username}</h3>
					</div>
					<div class="col-md-1">
						<a href="logout.html"><button class="btn btn-default">退出登录</button></a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<nav class="navbar navbar-default" role="navigation"> <!-- <div class="navbar-header">
					<a class="navbar-brand" href="#">硕士生管理系统</a>
				</div> -->
				<div class="panel-group" id="accordion">
					<c:forEach items="${parentResourceList }" var="parent">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne${parent.id}">
										<button class="btn btn-primary btn-block">${parent.description}</button>
									</a>
								</h4>
							</div>
							<div id="collapseOne${parent.id}" class="panel-collapse collapse">
								<div class="panel-body">
									<c:forEach items="${childResourceList}" var="child">
										<c:if test="${child.parent==parent }">
											<button class="btn btn-default btn-block" type="button">
												<a href="${child.url}" target="navTab" id="${child.rel }">${child.description}</a>
											</button>
										</c:if>

									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				</nav>
			</div>
			<div class="col-md-9">
				<iframe name="navTab" height="600px" width="100%"></iframe>
			</div>

		</div>

	</div>
	<div id="footer" style="background: #8B8682"
		class="navbar-fixed-bottom">
		<div class="container" align="center">
			<p class="muted credit">
				信管开发团队 and <a href="http://ryanfait.com/sticky-footer/"> techjoy</a>.
			</p>
		</div>
	</div>
</body>
</html>