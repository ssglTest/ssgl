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
<script type="text/javascript">
	function approved(midtermCheckId){
		var confirmed = window.confirm("确认通过？");
		if(confirmed ==true){
			$.ajax({
				url:"midtermCheckApproved.html",
				data:{"midtermCheckId":midtermCheckId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核成功");
					$(".midtermCheckaudit"+midtermCheckId).html("<span class='label label-success'>通过</span>");
					return true;
				},
				error:function(data){
					alert("网络故障，请检查后重新审核");
					return false;
				}
			});
		}
	}
	
	function notApproved(midtermCheckId){
		var confirmed = window.confirm("确认的不通过？");
		if(confirmed==true){
			$.ajax({
				url:"midtermCheckNotApproved.html",
				data:{"midtermCheckId":midtermCheckId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核成功");
					$(".midtermCheckaudit"+midtermCheckId).html("<span class='label label-warning'>未通过</span>");
					return true;
				},
				error:function(data){
					alert("审核成功");
					return false;
				}
			});
		}
	}
</script>
</head>
<body>
	<div class="panel panel-primary">
		<!-- <div class="panel panel-heading">
			<div class="panel panel-title">
				<h4>中期检查表</h4>
			</div>
		</div> -->
		<div class="panel panel-heading">
			<!-- <div class="panel panel-title">
				<h4>中期检查表</h4>
			</div> -->
			<h4>中期检查表</h4>
		</div>
		<div class="panel panel-body">
			<div class="form-group">
				<button class="btn btn-success">已通过</button>
				<button class="btn btn-warning">未通过</button>
				<button class="btn btn-info">全部学生</button>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>标题</th>
						<th>上传日期</th>
						<th>审核状态</th>
						<th>审核</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty midtermCheckList }">
						<h2><span class="label label-default">未有学生上传中期检查表，请耐心等待。</span></h2>
					</c:if>
					<c:forEach items="${midtermCheckList}" var="midtermCheck">
						<tr class="midtermCheck${midtermCheck.id }">
							<td class="midtermCheckno${midtermCheck.id}">${midtermCheck.student.no }</td>
							<td class="midtermCheckname${midtermCheck.id}">${midtermCheck.student.name }</td>
							<td class="midtermChecktitle${midtermCheck.id}">${midtermCheck.title }</td>
							<td class="midtermCheckupdateDate${midtermCheck.id}">${midtermCheck.updateDate }</td>
							<td class="midtermCheckaudit${midtermCheck.id}"><c:if test="${empty midtermCheck.approve }">
									<span class="label label-info">未审核</span>
								</c:if> <c:if test="${midtermCheck.approve=='approved' }">
									<span class="label label-success">已通过</span>
								</c:if> <c:if test="${midtermCheck.approve=='notApproved' }">
									<span class="label label-warning">未通过</span>
								</c:if></td>
							<td>
								<div class="btn-group">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										审核<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><%-- <a
											href="midtermCheckApproved.html?midtermCheckId=${midtermCheck.id }"><h4>
													<span class="label label-success">通过</span>
												</h4> </a> --%>
												<a class="btn btn-success" onclick="approved(${midtermCheck.id})">通过</a></li>
										<li><%-- <a
											href="midtermCheckNotApproved.html?midtermCheckId=${midtermCheck.id }"><h4>
													<span class="label label-warning">未通过</span>
												</h4> </a> --%>
												<a class="btn btn-warning" onclick="notApproved(${midtermCheck.id})">不通过</a></li>
									</ul>
								</div> <%-- <div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										审核<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a
											href="approvedPaperTitleApply.html?paperTitleApplyId=${paperTitleApply.id}"><h3>
													<span class="label label-success">通过</span>
												</h3></a></li>
										<li><a href="notApprovedPaperTitleApply.html?paperTitleApplyId=${paperTitleApply.id}"><h3>
													<span class="label label-danger">不通过</span>
												</h3></a></li>
									</ul>
								</div> --%>
							</td>
							<td>
								<button class="btn btn-default">
									<a href="#">查看</a>
								</button>
								<button class="btn btn-default">
									<a
										href="midtermCheckDownload.html?midtermCheckId=${midtermCheck.id }">下载</a>
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