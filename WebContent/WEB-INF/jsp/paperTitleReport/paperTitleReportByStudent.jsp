<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="<%=basePath %>bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath %>bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">
				<h3>学位论文选题报告</h3>
			</div>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="paperTitleReportUpdate.html" class="form-inline"
					role="form" enctype="multipart/form-data" method="post">
					<!-- 将标签和控件放在.form-gropu中，这是获得最佳间距的方法 -->
					<div class="form-group">
						<label for="fileUpdate">上传文件</label> <input type="file"
							name="paperTitleReportFile" id="fileUpdate" class="form-control">
						<label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传的学位论文选题报告</p>
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
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							
								<td>${paperTitleReport.student.no}</td>
								<td>${paperTitleReport.student.name}</td>
								<td>${paperTitleReport.title}</td>
								<td>${paperTitleReport.updateDate}</td>
								<td><c:if test="${not empty paperTitleReport.student.no}">
										<button class="btn btn-default">
											<a href="#">查看</a>
										</button>
										<button class="btn btn-default">
											<a
												href="paperTitleReportDownload.html?paperTitleReportId=${paperTitleReport.id}">下载</a>
										</button>
									</c:if></td>
							<c:if test="${empty paperTitleReport.student.no }">
								<h4><span class="label label-info">未上传论文选题报告</span></h4>
							</c:if>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>