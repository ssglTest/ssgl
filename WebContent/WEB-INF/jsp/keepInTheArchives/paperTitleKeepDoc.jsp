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
			<h3 class="panel-title">学位论文选题存档</h3>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${studentList}" var="student">
						<tr>
							<td>${student.no}</td>
							<td>${student.name}</td>
							<td>
								<button class="btn btn-default" data-toggle="modal"
									data-target="#saveFiles">存档文件</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="modal fade" id="saveFiles" tabindex="-1"
				role="dialog" aria-labelledby="updateInformationLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<!-- 模态框的标题 -->
							<h4 class="modal-title" id="myModalLable">修改个人信息</h4>
						</div>
						<div class="modal-body">
							<form action="#" role="form" class="form-horizontal">
								
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">提交更改</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>