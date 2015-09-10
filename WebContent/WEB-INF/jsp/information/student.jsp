<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
 <table>
 	<tr>
 		<th>学号</th>
 		<th>姓名</th>
 		<th>qq</th>
 		<th>email</th>
 		<th>电话</th>
 	<tr>
 	<tr>
 		<td>${student.no}</td>
 		<td>${student.name }</td>
 		<td>${student.qq }</td>
 		<td>${student.email }</td>
 		<td>${student.mobile }</td>
 	</tr>
 </table>
 <br/>
 <a href="updateInfo.html">个人信息修改</a>
</body>
</html>