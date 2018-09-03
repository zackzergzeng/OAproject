<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/show.css">
	<!-- 
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>-->
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	 
</head>
<body>
<div class="main">
<c:forEach items="${ptlist }" var="pt">
	<div class="list">
		<h1>${pt.ptName }</h1>
		<c:forEach items="${pt.pbi }" var="pbi">
			<a href="javascript:;" onclick="refresh(${pbi.pid})">${pbi.pName }</a>
		</c:forEach>
	</div>
</c:forEach>
</div>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	$(function(){
	    $('#btn').bind('click', function(){
	    	$(location).attr('href',"addprocess.jsp");
	    });
	});
	function refresh(pid){
		var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
		var url = "showattrform.do?pid="+pid;
		$('#desktop').tabs('update', {
			tab: tab,//被修改的标签页
			options: {
				title: "属性管理",//修改标签页标题
				href:url,//如果用URL就用href即可
				closable:true
			}
		});
	}
	</script>
</body>
</html>