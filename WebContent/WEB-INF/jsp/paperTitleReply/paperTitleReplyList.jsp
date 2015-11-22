<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="panel-title">
				<h3>学位论文选题报告</h3>
			</div>
		</div>
		<div class="panel-body">
			<div class="page-header">
				<form action="paperTitleApplyUpload.html" method="post"
					enctype="multipart/form-data" role="form" class="form-inline">
					<div class="form-group">
						<label for="#fileUpdate">上传文件</label> <input type="file"
							class="form-control" name="paperTitleReplyFile" id="fileUpdate">
						<label class="label label-info">${info}</label>
						<p class="help-block">请选择需要上传的学位论文选题报告答辩的时间地点</p>
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
				<c:if test="${empty paperTitleReplyList }">
					<h4><span class="label label-default">还没有上传论文选题答辩的时间地点</span></h4>
				</c:if>
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
									<a
										href="downloadPaperTitleReply.html?paperTitleReplyId=${paperTitleReply.id}">下载</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- <div align="center">
				<ul class="pagination">
					<li><a href="#">&laquo</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">&raquo</a></li>
				</ul>
			</div> -->
		</div>
	</div>
</body>
</html>