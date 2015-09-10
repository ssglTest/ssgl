<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateInfo.html" method="post">
	    <input type="hidden" value="${student.id} " name="id"/>
		email:<input type="text" value="${student.email} "/><br/>
		qq:<input type="text" value="${student.qq}"/><br/>
		mobile<input type="text" value="${student.mobile}"/><br/>
		<input type="submit" value="submit"/>
	</form>

</body>
</html>