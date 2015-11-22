<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
	<!-- <div class="modal fade" id="updateInformation" tabindex="-1"
		role="dialog" aria-labelledby="updateInformationLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					模态框的标题
					<h4 class="modal-title" id="myModalLable">修改个人信息</h4>
				</div>
				<div class="modal-body">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
		</div>
	</div> -->
	<div class="panel panel-warning">
		<div class="panel-heading">
			<h3>警告</h3>
		</div>
		<div class="panel-body">
			<div class="alert alert-warning">
				<a href="#" class="close" data-dismiss="alert"> &times; </a> <strong>警告！</strong>通过前一项才能进行此项
			</div>
		</div>
	</div>
</body>
</html>