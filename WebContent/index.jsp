<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index3.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
</head>
<body>
	<h1>${err }</h1>
	<form action="/four/login.do" method="post">
		<table>
			<tr>
			<td>用户名</td>
			<td>
				<input type="text" name="user">
			</td>
			</tr>
			<tr>
			<td>密码</td>
			<td>
				<input type="text" name="pass">
			</td>
			</tr>
			<tr>
			<td colspan="10">
				<input type="submit" value="登录">
			</td>
			</tr>
		</table>
	</form>
</body>
</html>