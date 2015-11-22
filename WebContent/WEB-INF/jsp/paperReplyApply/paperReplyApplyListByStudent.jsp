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
				<h3>学位论文答辩申请</h3>
			</div>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="updatePaperReplyApply.html" method="post"
					enctype="multipart/form-data" role="form" class="form-inline">
					<!-- 把标签和控件放在一个带有 class .form-group 的 <div> 中。这是获取最佳间距所必需的 -->
					<div class="form-group">
						<label for="fileUpdate">上传文件</label> <input type="file"
							id="paperReplyApplyFile" class="form-control"
							name="paperReplyApplyFile" /> <label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传的学位论文答辩申请</p>
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
						<th>上传日期</th>
						<th>审核状态</th>
						<th>审核日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:if test="${not empty paperReplyApply.student.no }">
							<td>${paperReplyApply.student.name}</td>
							<td>${paperReplyApply.student.no}</td>
							<td>${paperReplyApply.title}</td>
							<td>${paperReplyApply.updateDate}</td>
							<td>
								<!-- label标签的外观有sucess default primary warning danger -->
								<c:if test="${empty paperReplyApply.approve}">
									<span class="label label-default">审核中，请耐心等待</span>
								</c:if>
								<c:if test="${paperReplyApply.approve=='approved' }">
									<span class="label label-success">已通过</span>
								</c:if>
								<c:if test="${paperReplyApply.approve=='notApproved' }">
									<span class="label label-warning">未通过</span>
								</c:if>
							</td>
							<td>
								<c:if test="${empty paperReplyApply.auditDate }">
									<span class="label label-info">审核中</span>
								</c:if>
								${paperReplyApply.auditDate}
							</td>
							<td>
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
								<button class="btn btn-default">
									<a
										href="downPaperReplyApply.html?paperReplyApplyId=${paperReplyApply.id}">下载</a>
								</button>
							</td>
						</c:if>
						<c:if test="${empty paperReplyApply.student.no }">
							<h4><span class="label label-info">未学位论文答辩申请</span></h4>
						</c:if>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>