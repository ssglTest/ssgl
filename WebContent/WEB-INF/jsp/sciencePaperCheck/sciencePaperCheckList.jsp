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
			<div class="title">
				<h4>学术论文检查</h4>
			</div>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>姓名</th>
						<th>学号</th>
						<th>标题</th>
						<th>审核状态</th>
						<th>审核</th>
						<th>上传日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty sciencePaperCheckList}">
						<h2><span class="label label-default">未有学生上传学术论文检查记录表，请耐心等待。</span></h2>
					</c:if>
					<c:forEach items="${sciencePaperCheckList}" var="sciencePaperCheck">
						<tr>
							<td>${sciencePaperCheck.student.name }</td>
							<td>${sciencePaperCheck.student.no }</td>
							<td>${sciencePaperCheck.title }</td>
							<td><c:if test="${empty sciencePaperCheck.student.no }">
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
								<div class="btn-group">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										审核<span class="carent"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a
											href="excellentSciencePaperCheck.html?sciencePaperCheckId=${sciencePaperCheck.id}"><h4>
													<span class="label label-success">优</span>
												</h4></a></li>
										<li><a
											href="goodSciencePaperCheck.html?sciencePaperCheckId=${sciencePaperCheck.id}"><h4>
													<span class="label label-success">良</span>
												</h4></a></li>
										<li><a
											href="fairSciencePaperCheck.html?sciencePaperCheckId=${sciencePaperCheck.id}"><h4>
													<span class="label label-info">中</span>
												</h4></a></li>
										<li><a
											href="poorSciencePaperCheck.html?sciencePaperCheckId=${sciencePaperCheck.id}"><h4>
													<span class="label label-warning">差</span>
												</h4></a></li>
									</ul>
								</div>
							</td>
							<td>${sciencePaperCheck.updataDate }</td>
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
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>