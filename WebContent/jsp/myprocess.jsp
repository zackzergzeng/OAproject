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

	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	 
</head>
<body>

	<div id="tool1">
		<c:forEach items="${ptlist }" var="pt">
		<h1>${pt.ptName }</h1>
		<c:forEach items="${pt.pbi }" var="pbi">
			<a id="p${pbi.pid }" href="#" class="easyui-linkbutton" onclick="showprocesstype(${pbi.pid})" data-options="iconCls:'icon-search'">${pbi.pName }</a>
		</c:forEach>
		<br>
		</c:forEach>
	</div>
	<table class="easyui-datagrid table" id="dgmp" data-options="url:'showmyprocess.do',loadFilter:pagerFilter,singleSelect:true" pagination=true pageList=[4,5] pageSize=5>
		<thead>
			<tr>
				<th data-options="field:'num',formatter:autoput">序号</th>
				<th data-options="field:'main',formatter:mainname">名称</th>
				<th data-options="field:'status',formatter:putstate">状态</th>
				<th data-options="field:'type',formatter:showtype">类别</th>
				<th data-options="field:'_operate',width:300,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	function showprocesstype(pid){
		$('#dgmp').datagrid('options').url='showmyprocessbypid.do?pid='+pid;
	    $('#dgmp').datagrid('reload');
	}
	function formatOper(val,row,index){
		//row-选中行的对象
		//index-选中行的编号
		return "<a href=''>详情</a>";
	}
	function autoput(val,row,index){
		return index+1;
	}
	function mainname(val,row,index){
		for(var i=0;i<row.pavlist.length;i++){
			if(row.pavlist[i].attributes.ismain==1){
				return row.pavlist[i].attr_val;
			}
		}
	}
	function showtype(val,row,index){
		return row.pbi.pName;
	}
	function putstate(val,row,index){
		for(var i=0;i<row.aulist.length;i++){
			if(row.aulist[i].result==null){
				return "未完成";
			}
		}
		return "完成"
	}
	</script>
</body>
</html>