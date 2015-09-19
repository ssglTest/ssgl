<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<link href="../img/glyphicons-halflings-white.png">
<link href="../img/glyphicons-halflings.png">
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link href="styles/font-awesome.min.css" rel="stylesheet" />
<script>
	$(function() {
		$(".btn").click(function() {
			$(this).button('loading').delay(1000).queue(function() {
				// $(this).button('reset');
			});
		});
	});
</script>
<!-- <style type="text/css">
html, body {
	margin: 0px 0px;
	width: 100%;
	height: 100%;
}

iframe {
	margin: 0px 0px;
	width: 100%;
	height: 100%;
}
</style> -->
<title>硕士管理系统</title>


</head>
<body style="background: #EEE9E9">
	<script type="text/javascript" src="../bootstrap/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../Unslider/unslider.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
	<div class="container">
		<div class="jumbotron masthead" style="background-color: #A4D3EE">
			<!-- RGB颜色参考http://tool.oschina.net/commons?type=3 -->
			<div class="row">
				<div class="col-md-2">
					<img alt="山东建筑大学图标"  src="../img/logo_login.png" width="100" height="100">
				</div>
				<div class="col-md-10">
					<h2 style="font-family: '微软雅黑'">欢迎登录硕士管理系统</h2>
					<p>山东建筑大学非全日制硕士生管理系统</p>
				</div>
			</div>
			<div align="right">
				<%-- <label class="control-lable">当前用户:</label><label
					class="control-lable">${username}</label>  --%>
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
									<a href="secretary/informationTest.html" target="navTab">查看/修改个人信息</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo">
									<button class="btn btn-primary btn-block">发布信息</button>
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="#">发布公共课成绩与学分情况</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">发布专业课成绩与学分情况</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="secretary/chooseTitleName.html" target="navTab">发布选题资格名单</a>
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
									<a href="#">硕士培养基本流程</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseThree">
									<button class="btn btn-primary btn-block">上传文件</button>
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="secretary/uploadChooseTitleReportTime.html"
										target="navTab">上传选题报告答辩时间地点</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">上传论文答辩时间地点</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">上传答辩成绩</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFour">
									<button class="btn btn-primary btn-block">审核</button>
								</a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="secretary/lookChooseTitle.html" target="navTab">审核论文选题申请表</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">审核学位论文答辩申请书</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">上传答辩成绩</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseSix">
									<button class="btn btn-primary btn-block">论文复制比检测</button>
								</a>
							</h4>
						</div>
						<div id="collapseSix" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="#">复制比检测</a>
								</button>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseSeven">
									<button class="btn btn-primary btn-block">存档</button>
								</a>
							</h4>
						</div>
						<div id="collapseSeven" class="panel-collapse collapse">
							<div class="panel-body">
								<button class="btn btn-default btn-block" type="button">
									<a href="secretary/saveChooseTitle.html" target="navTab">论文选题工作存档</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">存档中期检查表</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">存档学位论文考核记录表</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">汇总文档</a>
								</button>
							</div>
						</div>
					</div>
				</div>
				</nav>
			</div>
			<div class="col-md-9">
				<iframe name="navTab" height="700px" width="100%"></iframe>
			</div>

		</div>

	</div>
	<div id="footer" style="background: #8B8682"
		class="navbar-fixed-bottom">
		<div class="container" align="center">
			<p class="muted credit">
				<a href="#">信管开发团队 </a> and <a
					href="http://ryanfait.com/sticky-footer/">techjoy</a>.
			</p>
		</div>
	</div>
</body>
</html>