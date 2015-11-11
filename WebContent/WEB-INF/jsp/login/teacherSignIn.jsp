<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link href="styles/font-awesome.min.css" rel="stylesheet" />
<title>硕士管理系统</title>
</head>
<body style="background: #EEE9E9">
	<script type="text/javascript" src="../bootstrap/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../Unslider/unslider.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
	<div class="container">
		<div class="jumbotron" style="background: #337ab7">
			<!-- RGB颜色参考http://tool.oschina.net/commons?type=3 -->
			<div class="row">
				<div class="col-md-2">
					<img alt="山东建筑大学图标" src="../img/logo_login.png" width="100"
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
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne">
									<button class="btn btn-primary btn-block">个人信息</button>
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="teacherInfo.html" target="navTab">查看/修改个人信息</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo">
									<button class="btn btn-primary btn-block">资料下载</button>
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="test/postGraduateFileRlus.html" target="navTab">硕士管理相关规定</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/needUpdateFile.html" target="navTab">需上传的文档模板</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFive">
									<button class="btn btn-primary btn-block">基本流程</button>
								</a>
							</h4>
						</div>
						<div id="collapseFive" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="test/basicFlow.html" target="navTab">硕士培养基本流程</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseThree">
									<button class="btn btn-primary btn-block">课程教学</button>
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="test/publicClassInformation.html" target="navTab">查看公共课程信息</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">查看专业课程信息</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">查看公共课成绩</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">查看专业课成绩</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/chooseTitle.html" target="navTab">查看选题资格名单</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFour">
									<button class="btn btn-primary btn-block">学位论文</button>
								</a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="test/personalPlan.html" target="navTab">上传个人培养计划</a>
								</button>
							</div>
						</div>
					</div>
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