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
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>复制比检测</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>题目</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>大剧院BIM应用</td>
						<td>
							<button class="btn btn-default">
								<a href="#">下载</a>
							</button>
							<button class="btn btn-default" data-toggle="modal"
								data-target="#copyCheck">复制比</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="modal fade" id="copyCheck" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button class="close" type="button" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">复制比</h4>
						</div>
						<div class="modal-body">

							<input id="copy" name="copyCheck" type="text"
								class="form-control" placeholder="请输入复制比">
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary" type="button"
								data-dismiss="modal">关闭</button>
							<button class="btn btn-primary" type="button"
								data-dismiss="modal">保存更改</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>