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
							<td id="no">${paperTitleApply.student.no}</td>
							<td id="name">${paperTitleApply.student.name}</td>
							<td>${paperTitleApply.title}</td>
							<td>
								<%-- <button class="btn btn-default" data-toggle="modal" id="${paperTitleApply.id}" 
									data-target="#paperTitleApply">审核</button> --%>
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										<!-- 使用 <span class="caret"></span> 来指示按钮作为下拉菜单。 -->
										审核<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#"><h3><span class="label label-success">通过</span></h3></a></li>
										<li><a href="#"><h3><span class="label label-danger">不通过</span></h3></a></li>
									</ul>
								</div>
							</td>
							<td>
								<button class="btn btn-default">
									<a
										href="downPaperTitleApply.html?paperTitleApplyId=${paperTitleApply.id}">下载</a>
								</button>
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- <div class="modal fade" id="paperTitleApply" tabindex="-1"
				role="dialog" aria-labelledby="updateInformationLabel"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							模态框的标题
							<h4 class="modal-title" id="myModalLable">审核论文选题申请</h4>
						</div>
						<div class="modal-body">
							<form  action="#" class="form-horizontal" role="form">
								<div class="form-group">
									<h3><span class="label label-default">姓名：</span></h3>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">提交更改</button>
						</div>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>