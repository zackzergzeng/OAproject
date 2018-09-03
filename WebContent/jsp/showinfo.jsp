<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<table class="easyui-datagrid table" id="dg" data-options="url:'showmyprocess.do',loadFilter:pagerFilter,singleSelect:true" pagination=true pageList=[4,5] pageSize=5>
		<thead>
			<tr>
				<th data-options="field:'num',formatter:autoput">序号</th>
				<th data-options="field:'main',formatter:mainname">名称</th>
				<th data-options="field:'status',formatter:putstate">状态</th>
				<th data-options="field:'type',formatter:showtype">类别</th>
			</tr>
		</thead>
	</table>
</body>
</html>