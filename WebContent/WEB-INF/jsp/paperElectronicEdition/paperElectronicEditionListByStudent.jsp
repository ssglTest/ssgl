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
			<h4 class="panel-title">上传论文电子版</h4>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="updatePaperElectronicEdition.html" enctype="multipart/form-data"
					method="post" role="form" class="form-inline">
					<div class="form-group">
						<label for="paperElectronicEditionFile">文件上传</label><input type="file"
							id="paperElectronicEditionFile" name="paperElectronicEditionFile"
							class="form-control"><label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传的论文电子版</p>
						<button type="submit" class="btn btn-default">上传</button>
					</div>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>标题</th>
						<th>上传日期</th>
						<th>审核状态</th>	
						<th>复制比</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:if test="${not empty paperElectronicEdition.student.no }">
							<td>${paperElectronicEdition.student.no}</td>
							<td>${paperElectronicEdition.student.name}</td>
							<td>${paperElectronicEdition.title }</td>
							<td>${paperElectronicEdition.updateDate}</td>
							<td>审核中
								<%-- <c:if test="${empty midtermCheck.approve}">
									<span class="label label-info">审核中</span>
								</c:if> <c:if test="${midtermCheck.approve=='approved' }">
									<span class="label label-success">已通过</span>
								</c:if> <c:if test="${midtermCheck.approve=='notApproved' }">
									<span class="label label-warning">未通过</span>
								</c:if> --%>
							</td>
							<td>10%</td>
							<td>
								<button class="btn btn-default">
									<a
										href="downloadPaperElectronicEdition.html?paperElectronicEditionId=${paperElectronicEdition.id }">下载</a>
								</button>
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
							</td>
						</c:if>
						<c:if test="${empty paperElectronicEdition.student.no }">
							<h3><span class="label label-default">未上传论文电子版</span></h3>
						</c:if>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>