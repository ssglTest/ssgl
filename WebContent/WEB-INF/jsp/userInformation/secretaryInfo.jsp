<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="../bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">个人信息</h3>
		</div>
		<div class="panel-body">
			<table class="table">
				<tbody>
					<tr>
						<td>姓名：</td>
						<td>${secretary.name}</td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>男</td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td>20</td>
					</tr>
					<tr>
						<td>邮箱：</td>
						<td>${secretary.email }</td>
					</tr>
					<tr>
						<td>手机：</td>
						<td>${secretary.mobile }</td>
					</tr>
					<tr>
						<td>QQ：</td>
						<td>${secretary.qq }</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-md-1">
									<button class="btn btn-default" data-toggle="modal"
										data-target="#updateInformation">修改个人信息</button>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="modal fade" id="updateInformation" tabindex="-1"
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
							<form action="updateSecretaryInfo.html" role="form"
								class="form-horizontal" method="post">
								<input type="hidden" value="${secretary.id}" name=secretaryId>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="name">姓名</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="name"
											placeholder="${secretary.name }" disabled>
									</div>
								</div>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="sex">性别</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="disabledInput"
											placeholder="男" disabled>
									</div>
								</div>
								<br>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="age">年龄</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="disabledInput"
											placeholder="20" disabled>
									</div>
								</div>
								<br>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="email">邮箱</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="email"
											name="email" placeholder="${secretary.email }">
									</div>
								</div>
								<br>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="phone">手机</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="phone" name=mobile
											placeholder="${secretary.mobile }">
									</div>
								</div>
								<br>
								<div class="form-grounp">
									<label class="col-sm-2 control-lable" for="qq">QQ</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="qq" name=qq
											placeholder="${secretary.qq }">
									</div>
								</div>
								<br>
								<div align="right">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="submit" class="btn btn-primary">提交更改</button>
								</div>

							</form>
						</div>
						<div class="modal-footer">
							<!-- <button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">提交更改</button> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>