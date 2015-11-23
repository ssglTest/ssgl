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
	function approved(paperReplyApplyId){
		var confirmed = window.confirm("确认通过？");
		if(confirmed==true){
			$.ajax({
				url:"approvedPaperReplyApply.html",
				data:{"paperReplyApplyId":paperReplyApplyId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核功能");
					$(".paperReplyApplyaudit"+paperReplyApplyId).html("<span class='label label-success'>通过</span>");
					return true;
				},
				error:function(data){
					alert("网络故障，请检查后重新审核");
					return false;
				}
			});
		}
	}
	
	function notApproved(paperReplyApplyId){
		var confirmed = window.confirm("确认不通过？");
		if(confirmed==true){
			$.ajax({
				url:"notApprovedPaperReplyApply.html",
				data:{"paperReplyApplyId":paperReplyApplyId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核成功");
					$(".paperReplyApplyaudit"+paperReplyApplyId).html("<span class='label label-warning'>未通过</span>");
					return true;
				},
				error:function(data){
					alert("网络故障，请检查后重新审核");
					return false;
				}
			});
		}
	}
</script>
</head>
<body>
	<!-- bootstrap中的面板 -->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">学位论文答辩申请</h4>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<button class="btn btn-success">已通过</button>
				<button class="btn btn-warning">未通过</button>
				<button class="btn btn-info">所有学生</button>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>题目</th>
						<th>审核状态</th>
						<th>审核</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty paperReplyApplyList}">
						<h2><span class="label label-default">未有学生上传学位论文答辩申请，请耐心等待。</span></h2>
					</c:if>
					<c:forEach items="${paperReplyApplyList}" var="paperReplyApply">
						<tr class="paperReplyApply${paperReplyApply.id }">
							<td class="paperReplyApplyno${paperReplyApply.id }">${paperReplyApply.student.no}</td>
							<td class="paperReplyApplyname${paperReplyApply.id }">${paperReplyApply.student.name}</td>
							<td class="paperReplyApplytitle${paperReplyApply.id }">${paperReplyApply.title}</td>
							<td class="paperReplyApplyaudit${paperReplyApply.id }">
								<!-- 判断是否审核 --> <c:if test="${empty paperReplyApply.approve }">
									<span class="label label-info">未审核</span>
								</c:if> <c:if test="${not empty paperReplyApply.approve }">
									<c:if test="${paperReplyApply.approve=='approved'}">
										<span class="label label-success">通过</span>
									</c:if>
									<c:if test="${paperReplyApply.approve=='notApproved' }">
										<span class="label label-warning">未通过</span>
									</c:if>
								</c:if>
							</td>
							<td>
								<%-- <button class="btn btn-default" data-toggle="modal" id="${paperTitleApply.id}" 
									data-target="#paperTitleApply">审核</button> --%>
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										<!-- 使用 <span class="caret"></span> 来指示按钮作为下拉菜单。 -->
										审核<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><%-- <a
											href="approvedPaperReplyApply.html?paperReplyApplyId=${paperReplyApply.id}"><h3>
													<span class="label label-success">通过</span>
												</h3></a> --%>
												<a class="btn btn-success" onclick="approved(${paperReplyApply.id})">通过</a></li>
										<li><%-- <a href="notApprovedPaperReplyApply.html?paperReplyApplyId=${paperReplyApply.id}"><h3>
													<span class="label label-danger">不通过</span>
												</h3></a> --%>
												<a class="label label-warning" onclick="notApproved(${paperReplyApply.id})">未通过</a></li>
									</ul>
								</div>
							</td>
							<td>
								<button class="btn btn-default">
									<a
										href="downPaperReplyApply.html?paperReplyApplyId=${paperReplyApply.id}">下载</a>
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