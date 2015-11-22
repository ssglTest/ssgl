<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
			<h3 class="panel-title">审核论文选题申请表</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>专业</th>
						<th>审核</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td><button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button></td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default">
								<a href="#">查看</a>
							</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#updateInformation">审核</button>
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

				</tbody>
			</table>
			<div align="center">
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
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
							<form action="#" role="form" class="form-horizontal">
								<table class="table table-hover">
									<tbody>
										<tr>
											<td>姓名:</td>
											<td>张三</td>
										</tr>
										<tr>
											<td>标题:</td>
											<td>论文选题申请表</td>
										</tr>
										<tr>
											<td>审核</td>
											<td>
												<select class="form-control" name="resultOfCheck">
													<option>通过</option>
													<option>不通过</option>
												</select>
											</td>
										</tr>
									</tbody>
								</table>
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