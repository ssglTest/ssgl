<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h4>学术论文检查</h4>
			</div>
		</div>
		<div class="body">
			<div class="page-header">
				<form action="paperTitleReportUpdate.html" class="form-inline"
					role="form" enctype="multipart/form-data" method="post">
					<!-- 将标签和控件放在.form-gropu中，这是获得最佳间距的方法 -->
					<div class="form-group">
						<label for="fileUpdate">上传文件</label> <input type="file"
							name="sciencePaperCheckUploadFile" id="fileUpdate"
							class="form-control"> <label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传的学术论文检查表</p>
						<button type="submit" class="btn btn-default">上传文件</button>
					</div>
				</form>
				<table class="table">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>标题</th>
							<th>上传日期</th>
							<th>审核状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sciencePaperCheck.student.no }</td>
							<td>${sciencePaperCheck.student.name }</td>
							<td>${sciencePaperCheck.title }</td>
							<td>${sciencePaperCheck.updateDate }</td>
							<td><c:if test="${empty sciencePaperCheck.approve }">
									<span class="label label-info">未审核</span>
								</c:if> <c:if test="${sciencePaperCheck.approve=='excellent' }">
									<span class="label label-success">优</span>
								</c:if> <c:if test="${sciencePaperCheck.approve=='good' }">
									<span class="label label-success">良</span>
								</c:if> <c:if test="${sciencePaperCheck.approve=='fair' }">
									<span class="label label-info">中</span>
								</c:if> <c:if test="${sciencePaperCheck.approve=='poor' }">
									<span class="label label-warning">差</span>
								</c:if></td>
							<td>
								<button type="button" class="btn btn-default">
									<a href="#">查看</a>
								</button>
								<button type="button" class="btn btn-default">
									<a
										href="sciencePaperCheckDownload.html?sciencePaperCheckId=${sciencePaperCheck.id}">下载</a>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>