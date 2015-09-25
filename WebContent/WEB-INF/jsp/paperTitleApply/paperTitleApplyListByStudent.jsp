<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="../../bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../../bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">
				<h3>论文选题申请</h3>
			</div>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="#" role="form" class="form-inline">
					<!-- 把标签和控件放在一个带有 class .form-group 的 <div> 中。这是获取最佳间距所必需的 -->
					<div class="form-group">
						<label for="fileUpdate">上传文件</label> <input type="file"
							id="fileUpdate" class="form-control" name="paperTitleApply">
						<p class="help-block">请选择需要上传的论文选题申请表</p>
						<button class="btn btn-default" type="submit">上传</button>
					</div>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>姓名</th>
						<th>学号</th>
						<th>题目</th>
						<th>审核状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${paperTitleApply.student.name}</td>
						<td>${paperTitleApply.student.no}</td>
						<td>${paperTitleApply.title}</td>
						<td>
							<span class="label label-success">已通过</span>
						</td>
						<td>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>