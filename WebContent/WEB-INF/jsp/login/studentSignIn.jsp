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
<title>Insert title here</title>


</head>
<body style="background:#EEE9E9">
	<script type="text/javascript" src="../bootstrap/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../Unslider/unslider.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
	<div class="container">
		<div class="jumbotron" style="background: #A4D3EE">
			<!-- RGB颜色参考http://tool.oschina.net/commons?type=3 -->
			<h2>欢迎登录硕士管理系统</h2>
			<p>山东建筑大学非全日制硕士生管理系统</p>
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
									<a href="informationTest.html" target="navTab">查看/修改个人信息</a>
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
								<button class="btn btn-default btn-block" type="button">
									<a href="#">查看我的导师</a>
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
								<button class="btn btn-default btn-block" type="button">
									<a href="test/projectChooseTitle.html" target="navTab">提交论文选题申请</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/chooseTitleReport.html" target="navTab">提交选题报告</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/chooseTitleAnswer.html" target="navTab">论文选题答辩</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/checkMiddle.html" target="navTab">提交中期检查表</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/notpass.html" target="navTab">上传论文考核记录表</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">提交论文答辩申请书</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="test/updatePaper.html" target="navTab">上传论文电子版</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">查看论文答辩时间地点</a>
								</button>
								<button class="btn btn-default btn-block" type="button">
									<a href="#">提交授予硕士学位审批表</a>
								</button>
								<!-- <button class="btn btn-default btn-block" type="button">
									<a href="#">上传汇总文档</a>
								</button> -->
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
		<!-- Footer
    ================================================== -->
		<!-- 自定义footer css -->
		<!-- 这个地方是为了兼容加了个bs-docs-social 官网是没有的. -->
		<!--[if lte IE 9]>
<div class="bs-docs-social">
<![endif]-->
		<!-- <div class="footer"> 内置块css定义
		<div class="container">
			一行一排
			<p>
				由 <a href="http://twitter.com/mdo" target="_blank">@mdo</a> 和 <a
					href="http://twitter.com/fat" target="_blank">@fat</a>
				倾心制作开发,由KingHack学习并注解
			</p>
			<p>
				开源依照 <a href="http://www.apache.org/licenses/LICENSE-2.0"
					target="_blank">Apache License v2.0</a>, 文档依照 <a
					href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
			</p>
			<p>
				Icons取自<a href="http://glyphicons.com">Glyphicons Free</a> ,授权依照 <a
					href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.
			</p>
			尾部链接
			<ul class="footer-links">
				<li><a href="http://blog.getbootstrap.com">博客</a></li>
				<li class="muted">&middot;</li>
				<li><a
					href="https://github.com/twitter/bootstrap/issues?state=open">问题反馈</a></li>
				使用内置标准点分割
				<li class="muted">&middot;</li>
				<li><a
					href="https://github.com/twitter/bootstrap/blob/master/CHANGELOG.md">路线图与更新日志</a></li>
				[if lte IE 9]>
      
      <p>不完全支持Internet Explorer,请在360安全浏览器或者是金山猎豹浏览的极速模式中浏览</p>
      <![endif]
			</ul>
		</div>
		</div> -->
		<div id="footer" style="background: #8B8682">
			<div class="container" align="center">
				<p class="muted credit">
					信管开发团队 and <a href="http://ryanfait.com/sticky-footer/">  techjoy</a>.
				</p>
			</div>
		</div>
</body>
</html>