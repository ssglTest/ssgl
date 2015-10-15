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
				<h4>学术论文考核记录表</h4>
			</div>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>审核日期</th>
						<th>审核状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items=${sciencePaperCheckList } var="sciencePaperCheck">
						<tr>
							<td>${sciencePaperCheck.student.no }</td>
							<td>${sciencePaperCheck.student.name }</td>
							<td>${sciencePaperCheck.auditDate }</td>
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
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
								<button class="btn btn-default">
									<a
										href="sciencePaperCheckDownload.html?sciencePaperCheckId=${sciencePaperCheck.id}">下载</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>