<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../../bootstrap/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="../../bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../../bootstrap/bootstrap.min.js"></script>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" language="javascript">
	function approved(paperTitleApplyId){
		var approve = window.confirm("确认通过？");
		if(approve==true){
			$.ajax({
				url:"approvedPaperTitleApply.html",
				data:{"paperTitleApplyId":paperTitleApplyId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核通过");
					$(".paperTitleApplyaudit"+paperTitleApplyId).html("<span class='label label-success'>通过</span>");
					return true;
				},
				error:function(msg){
					alert("网络故障，请检查后重新审核");
					return false;
				}
			});
		}
	}
	
	function notApproved(paperTitleApplyId){
		var approve = window.confirm("确认不通过？");
		if(approve==true){
			$.ajax({
				url:"notApprovedPaperTitleApply.html",
				data:{"paperTitleApplyId":paperTitleApplyId},
				dataType:'json',
				type:'POST',
				success:function(data){
					alert("审核未通过");
					$(".paperTitleApplyaudit"+paperTitleApplyId).html("<span class='label label-warning'>未通过</span>");
					return true;
				},
				error:function(msg){
					window.error("网络故障，请检查后重新审核");
					return false;
				}
			});
		}
	}
	/* function test(){
		window.confirm("这是一个测试 ")
	} */
</script>
</head>
<body>
	<!-- bootstrap中的面板 -->
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4 class="panel-title">论文选题申请</h4>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<button class="btn btn-success">
					<a href="getApproved.html">已通过</a>
				</button>
				<button class="btn btn-warning">
					<a href="getNotApproved.html">未通过</a>
				</button>
				<button class="btn btn-info">
					<a href="paperTitleApplyManage.html">所有学生</a>
				</button>
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
					<c:if test="${empty paperTitleApplyList }">
						<h1>
							<span class="label label-default">未有学生提交，请耐心等待。</span>
						</h1>
					</c:if>
					<c:forEach items="${paperTitleApplyList}" var="paperTitleApply">
						<tr class="paperTitleApply${paperTitleApply.id}">
							<td class="paperTitleApplyno${paperTitleApply.id }">${paperTitleApply.student.no}</td>
							<td class="paperTitleApplyname${paperTitleApply.id}">${paperTitleApply.student.name}</td>
							<td class="paperTitleApplytitle${paperTitleApply.id}">${paperTitleApply.title}</td>
							<td class="paperTitleApplyaudit${paperTitleApply.id}">
								<!-- 判断是否审核 --> <c:if test="${empty paperTitleApply.approve }">
									<span class="label label-info">未审核</span>
								</c:if> <c:if test="${not empty paperTitleApply.approve }">
									<c:if test="${paperTitleApply.approve=='approved'}">
										<span class="label label-success">通过</span>
									</c:if>
									<c:if test="${paperTitleApply.approve=='notApproved' }">
										<span class="label label-warning">未通过</span>
									</c:if>
								</c:if>
							</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										<!-- 使用 <span class="caret"></span> 来指示按钮作为下拉菜单。 -->
										审核<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a class="btn btn-success"
											onclick="approved(${paperTitleApply.id})"
											id="approvedPaperTitleApply">通过</a></li>
										<li><a class="btn btn-warning"
											onclick="notApproved(${paperTitleApply.id})"
											id="notApprovedPaperTitleApply">不通过</a></li>
									</ul>
								</div>
							</td>
							<td>
								<button class="btn btn-default">
									<a
										href="downPaperTitleApply.html?paperTitleApplyId=${paperTitleApply.id}">下载</a>
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