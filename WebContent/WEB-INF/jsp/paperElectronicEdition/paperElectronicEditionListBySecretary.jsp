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
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">论文电子版</h4>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>上传日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty  paperElectronicEditionList}">
						<h2>
							<span class="label label-info">还没有学生上传论文</span>
						</h2>
					</c:if>
					<c:forEach items="paperElectronicEditionList"
						var="paperElectronicEdition">
						<tr>
							<td>${paperElectronicEdition.student.no }</td>
							<td>${paperElectronicEdition.student.name }</td>
							<td>${paperElectronicEdition.updateDate }</td>
							<td>
								<button class="btn btn-default">
									<a
										href="downloadPaperElectronicEdition.html?paperElectronicEditionId=${paperElectronicEdition.id}">下载</a>
								</button>
								<button class="btn btn-default">
									<a href="#">查看</a>
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