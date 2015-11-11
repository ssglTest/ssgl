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
<script type="text/javascript">
	function updateInfo() {
		window.open("secretaryInfo.html", "navTab");
	}

	function sendpublicgrade() {
		window.open("#", "navTab");
	}

	function sendmajorgrade() {
		window.open("#", "navTab");
	}

	function sendchoosetitlepepol() {
		window.open("secretary/chooseTitleName.html", "navTab");
	}

	function baseprocess() {
		window.open("#", "navTab");
	}

	function updatepapertitleapply() {
		window.open("paperTitleReply/paperTitleReplyList.html", "navTab");
	}

	function updatepapertitlereply() {
		window.open("paperReplyTime/updatePaperReply.html", "navTab");
	}

	function updatereplygrade() {
		window.open("replyGrade/updateReplyGrade.html", "navTab");
	}

	function auditpapertitleapply() {
		window.open("paperTitleApply/paperTitleApplyManage.html", "navTab");
	}

	function updatepapertitlereportgrade() {
		window.open("paperTitleReport/paperTitleReportList.html", "navTab");
	}

	function auditpaperreplyapply() {
		window.open("paperReplyApply/paperReplyApplyList.html", "navTab");
	}

	function updategrade() {
		window.open("#", "navTab");
	}

	function copycheck() {
		window.open("secretary/copyCheck.html", "navTab");
	}

	function savepapertitle() {
		window.open("paperTitleKeepDoc/paperTitleDocList.html", "navTab");
	}

	function savemidtermcheck() {
		window.open("midtermCheck/midtermCheckList.html", "navTab");
	}

	function auditmidtermcheck() {
		window.open("midtermCheck/midtermCheckList.html", "navTab");
	}

	function savesciencepapercheck() {
		window.open("sciencePaperCheck/saveSciencePaperCheck.html", "navTab");
	}

	function savealldoc() {
		window.open("#", "navTab");
	}
</script>
<title>硕士管理系统</title>

</head>
<body style="background: #EEE9E9">
	<script type="text/javascript" src="../bootstrap/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../Unslider/unslider.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
	<div class="container">
		<div class="jumbotron masthead" style="background-color: #337ab7">
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
								<button class="btn btn-default btn-block" type="button"
									onclick="updateInfo()">查看/修改个人信息</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="sendpublicgrade()">发布公共课成绩与学分情况</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="sendmajorgrade()">发布专业课成绩与学分情况</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="sendchoosetitlepepol()">发布选题资格名单</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="baseprocess()">硕士培养基本流程</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="updatepapertitleapply()">上传选题报告答辩时间地点</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="updatepapertitlereply()">上传论文答辩时间地点</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="updatereplygrade()">上传答辩成绩</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="auditpapertitleapply()">审核论文选题申请表</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="updatepapertitlereportgrade()">上传选题报告答辩成绩</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="auditmidtermcheck()">审核中期检查表</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="auditpaperreplyapply()">审核学位论文答辩申请书</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="updategrade()">上传学位论文答辩成绩</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="copycheck()">复制比检测</button>
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
								<button class="btn btn-default btn-block" type="button"
									onclick="savepapertitle()">论文选题工作存档</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="savemidtermcheck()">存档中期检查表</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="savesciencepapercheck()">存档学位论文考核记录表</button>
								<button class="btn btn-default btn-block" type="button"
									onclick="savealldoc()">汇总文档</button>
							</div>
						</div>
					</div>
				</div>
				</nav>
			</div>
			<div class="col-md-9">
				<iframe name="navTab" height="500px" width="100%"></iframe>
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