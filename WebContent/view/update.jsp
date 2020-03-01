<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form action="/four/update.do" method="post" enctype="multipart/form-data" modelAttribute="g">
		<input type="hidden" name="sid" value="${g.sid }">
		<table>
			<tr>
			<td>头像</td>
			<td>
				<img alt="" src="${g.url }" width="50px" height="50px">
				<input type="file" name="f">
			</td>
			</tr>
			<tr>
			<td>名称</td>
			<td>
			<input type="text" name="sname" value="${g.sname }">
			<form:errors path="sname" cssStyle="color:red"></form:errors>
			</td>
			</tr>
			<tr>
			<td>密码</td>
			<td>
			<input type="text" name="pwd" value="${g.pwd }">
			<form:errors path="pwd" cssStyle="color:red"></form:errors>
			</td>
			</tr>
			<tr>
			<td>年龄</td>
			<td>
			<input type="text" name="age" value="${g.age }">
			<form:errors path="age" cssStyle="color:red"></form:errors>
			</td>
			</tr>
			<tr>
			<td>性别</td>
			<td>
			<form:radiobutton path="sex" label="男" value="男" />
			<form:radiobutton path="sex" label="女" value="女" />
			<form:errors path="sex" cssStyle="color:red"></form:errors>
			</td>
			</tr>
			<tr>
			<td>科目</td>
			<td>
			<span id="sp"></span>
			</td>
			</tr>
			<tr>
				<td colspan="10"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
	var mids=${id}
	$.post(
			"/four/cha.do",
			function(asr) {
				for (var i = 0; i < asr.length; i++) {
					$("#sp").append("<input type='checkbox' value='"+asr[i].cid+"' name='mids'>"+asr[i].cname+"")
				}
				for (var i = 0; i < mids.length; i++) {
					$("[name=mids][value='"+mids[i]+"']").attr("checked",true)
				}
			},"json")
	</script>
</body>
</html>