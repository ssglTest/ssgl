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
<!-- bootstrap中的面板 -->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">论文选题申请</h4>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>题目</th>
						<th>审核</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${paperTitleApplyList}" var="paperTitleApply">
						<tr>
							<td>${paperTitleApply.student.no}</td>
							<td>${paperTitleApply.student.name}</td>
							<td>${paperTitleApply.title}</td>
							<td>
								<button class="btn btn-default" data-toggle="modal"
									data-target="#paperTitleApply">审核</button>
							</td>
							<td>
								<button class="btn btn-default">
									<a href="#">下载</a>
								</button>
								<button class="btn btn-default">
									<a href="#">查看</a>
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