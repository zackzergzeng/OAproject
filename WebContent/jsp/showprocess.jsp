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
	<table class="easyui-datagrid" id="dg" data-options="url:'showprocess.do',loadFilter:pagerFilter,singleSelect:true,toolbar:'#tool'" pagination=true pageList=[4,5] pageSize=5>
		<thead>
			<tr>
				<th data-options="field:'num',formatter:autoput">序号</th>
				<th data-options="field:'pName'">名称</th>
				<th data-options="field:'status',formatter:putstate">状态</th>
				<th data-options="field:'ptId',formatter:showtype">类别</th>
				<th data-options="field:'remarks'">说明</th>
				<th data-options="field:'_operate',width:300,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tool">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>
	</div>
	<div id="dd">Dialog Content.</div>
	<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"
	    data-options="iconCls:'icon-save',modal:true,closed:true">
	    Window Content
	</div>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	$(function(){
	    $('#btn').bind('click', function(){
	    	$.ajax({
	    		url:"clearsession.do",
				traditional:true
	    	})
	    	$.ajax({
				url:"showprocesstype.do",
				traditional:true
			})
	    	$('#win').window('open');
	    	$('#win').window('refresh','jsp/addprocess.jsp')
	    });
	});
	function formatOper(val,row,index){
		//row-选中行的对象
		//index-选中行的编号
		return "<a href='javascript:;' onclick='send("+row.pid+",0)'>属性管理</a>&nbsp;<a href='javascript:;' onclick='send("+row.pid+",1)'>步骤管理</a>&nbsp;<a href='javascript:;' onclick='send("+row.pid+",2)'>修改</a>&nbsp;<a href='javascript:;' onclick='deleteinfo("+row.pid+")'>删除</a>";
	}
	function send(pid,t){
		$.ajax({
			url:"setpid.do",
			traditional:true,
			data:{
				pid:pid,
				t:t
			},
			type:"post",
			success:function(){
				if(t==0){
					refreshprocess(t);
				}else if(t==1){
					refreshprocess(t);
				}else{
					$('#win').window('open');
			    	$('#win').window('refresh','jsp/addprocess.jsp')
				}
			}
		});
		
	}
	function deleteinfo(pid){
		$.ajax({
			url:"deleteprocessinfo.do",
			traditional:true,
			data:{
				pid:pid,
			},
			type:"post",
			success:function(){
				$('#dg').datagrid('reload');
			}
		})
	}
	function autoput(val,row,index){
		return index+1;
		//return row.pid;
	}
	function putstate(val,row,index){
		if(row.states=="0"){
			return "停用";
		}else{
			return "启用";
		}
	}
	function showtype(val,row,index){
		return row.type.ptName;
	}
	function refreshprocess(t){
		//添加tabs页;
		var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
		if(t==0){
			$('#desktop').tabs('update', {
				tab: tab,//被修改的标签页
				options: {
					title: "属性管理",//修改标签页标题
					href:"${pageContext.request.contextPath}/jsp/showprocessattr.jsp",//如果用URL就用href即可
					closable:true
				}
			});
		}else if(t==1){
			$('#desktop').tabs('update', {
				tab: tab,//被修改的标签页
				options: {
					title: "步骤管理",//修改标签页标题
					href:"${pageContext.request.contextPath}/jsp/showstep.jsp",//如果用URL就用href即可
					closable:true
				}
			});
		}
	}
	</script>
</body>
</html>