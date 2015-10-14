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
			<h3 class="panel-title">选题报告答辩时间</h3>
		</div>
		<div class="panel-body">
			<table class="table">
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
							<c:if test="${not empty paperTitleReply.title}">
								<td>${paperTitleReply.id}</td>
								<td>${paperTitleReply.title}</td>
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
							</c:if>
							<c:if test="${empty paperTitleReply.title }">
								<span class="label label-info">研究生秘书还未上传论文选题答辩的相关文件，请耐心等待</span>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>