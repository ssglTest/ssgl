<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存档选题报告评分表</title>
<link type="text/css" href="<%=basePath %>bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath %>bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>论文选题工作存档</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>专业</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2000123</td>
						<td>张三</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#saveChooseTitle">查看文档</button>
						</td>
					</tr>
					<tr>
						<td>2000123</td>
						<td>张三</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#saveChooseTitle">查看文档</button>
						</td>
					</tr>
					<tr>
						<td>2000123</td>
						<td>张三</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#saveChooseTitle">查看文档</button>
						</td>
					</tr>
					<tr>
						<td>2000123</td>
						<td>张三</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#saveChooseTitle">查看文档</button>
						</td>
					</tr>
					<tr>
						<td>2000123</td>
						<td>张三</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#saveChooseTitle">查看文档</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="modal fade" role="dialog" id="saveChooseTitle">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button class="close" type="button" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="submitFile">已经提交的文档</h4>
						</div>
						<div class="modal-body">
							<table class="table table-default">
								<thead>
									<tr>
										<th>文件名</th>
										<th>提交状态</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>管理工程学院硕士学位论文选题申请表</td>
										<td><span class="label label-success">已提交</span></td>
										</tr>
									<tr>
										<td>山东建筑大学硕士学位论文选题报告及论文工作计划</td>
										<td><span class="label label-warning">未提交</span></td>
									</tr>
									<tr>
										<td>东建筑大学硕士学位论文选题报告评分表</td>
										<td><span class="label label-success">已提交</span></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>