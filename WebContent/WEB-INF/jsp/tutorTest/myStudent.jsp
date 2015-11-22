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
			<h3>我的学生</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>专业</th>
						<th>电话</th>
						<th>QQ</th>
						<th>邮箱</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td>18851535154</td>
						<td>702284455</td>
						<td>xinguan@163.com</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td>18851535154</td>
						<td>702284455</td>
						<td>xinguan@163.com</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td>18851535154</td>
						<td>702284455</td>
						<td>xinguan@163.com</td>
					</tr>
					<tr>
						<td>张三</td>
						<td>男</td>
						<td>信息管理</td>
						<td>18851535154</td>
						<td>702284455</td>
						<td>xinguan@163.com</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>