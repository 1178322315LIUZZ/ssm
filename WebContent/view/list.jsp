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
	<form action="/four/list.do" method="post" >
	姓名:<input type="text" name="sname" value="${sname }">
	年龄:<input type="text" name="staage" value="${staage }">
	-<input type="text" name="endage" value="${endage }">   
	<input type="checkbox" value="1" name="cid">数学
	<input type="checkbox" value="2" name="cid">语文
	<input type="checkbox" value="3" name="cid">英语
	<input type="checkbox" value="4" name="cid">化学
	<input type="submit" value="查询">                                
	<table>
    <tr>
      <td><input type="checkbox" onclick="qx(this.checked)"></td>
      <td>头像</td>
      <td>id</td>
      <td>名称</td>
      <td>密码</td>
      <td>年龄</td>
      <td>性别</td> 
      <td>科目</td> 
      <td>操作
      	<input type="button" value="添加" onclick="add()">
      </td> 
    </tr>
    <c:forEach items="${g }" var="c">
    	<tr>
    	<td><input type="checkbox" value="${c.sid }" class="m"></td>
    	<td><img alt="" src="${c.url }" width="50px" height="50px"></td>
    	<td>${c.sid }</td>
    	<td>${c.sname }</td>
    	<td>${c.pwd }</td>
    	<td>${c.age }</td>
    	<td>${c.sex }</td>
   		<td>
    		<c:forEach items="${c.type }" var="a">
    		${a.cname }
    		</c:forEach>
    	</td>
    	<td>
    		<input type="button" value="修改"  onclick="xiu(${c.sid})">
    	</td>
    	</tr>
    </c:forEach>
    <tr>
    <td colspan="10">
    	<button name="pageNum" value="1">首页</button>
    	<button name="pageNum" value="${pg.prePage==0?1:pg.prePage }">上一页</button>
    	<button name="pageNum" value="${pg.nextPage==0?pg.pages:pg.nextPage }">下一页</button>
    	<button name="pageNum" value="${pg.pages }">尾页</button>
    	当前页/总页 ${pg.pageNum}/${pg.pages }
    	<input type="button" value="批删" onclick="del()">
    	</td>
    </tr>
    </table>
	</form>
	<script type="text/javascript">
	function add() {
		location="/four/add.do"
	}
	
	function xiu(sid) {
		location="/four/find.do?sid="+sid
	}
	
	function qx(flag) {
		$(".m").attr("checked",flag)
	}
	
	function del() {
		var ids=$(".m:checked").map(function() {
			return $(this).val()
		}).get().join()
		if(ids.length>0){
			if(confirm("确认删除吗")){
				location="/four/del.do?sid="+ids
			}else{
				alert("你取消了批删操作")
			}
		}else{
			alert("请至少选择一条数据")
		}
	}
	</script>
</body>
</html>