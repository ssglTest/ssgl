<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="<%=basePath%>bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath%>bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">导入学生</h3>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="importStudentFromExcel.html" method="post"
					enctype="multipart/form-data" role="form" class="form-inline">
					<!-- 把标签和控件放在一个带有 class .form-group 的 <div> 中。这是获取最佳间距所必需的 -->
					<div class="form-group">
						<label for="importStudentFromExcel">上传文件</label> <input
							type="file" id="importStudentFromExcel" class="form-control"
							name="importStudentFromExcel" /> <label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传学生名单</p>
						<button class="btn btn-default" type="submit">上传</button>
					</div>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>专业</th>
						<th>电话</th>
						<th>邮箱</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty studentList}">
						<h2>
							<span class="label label-default">还没有上传学生名单</span>
						</h2>
					</c:if>
					<c:forEach items="${studentList}" var="student">
						<tr>
							<td>${student.no}</td>
							<td>${student.name}</td>
							<td>${student.major}</td>
							<td>${student.mobile }</td>
							<td>${student.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>