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
			<div class="panel-title">
				<h3>学位论文选题报告</h3>
			</div>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="updatePaperTitleReply.html" method="post" role="form"
					class="form-inline" enctype="multipart/form-data">
					<div class="form-group">
						<label for="#fileUpdate">上传文件</label> <input type="file"
							class="form-control" name="paperTitleReplyFile" id="fileUpdate">
							<label class="label label-info">${info}</label>
							<button class="btn btn-default" type="submit">提交</button>
					</div>
				</form>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>编号</th>
						<th>标题</th>
						<th>上传日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${paperTitleReplyList}" var="paperTitleReply">
						<tr>
							<td>${paperTitleReply.id}</td>
							<td>${paperTitleReply.title }</td>
							<td>${paperTitleReply.updateDate}</td>
							<td>
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
								<button class="btn btn-default">
									<a href="downloadPaperTitleReply.html">下载</a>
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