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
	<table class="easyui-datagrid" id="dg" data-options="url:'showsteps.do',loadFilter:pagerFilter,singleSelect:true,toolbar:'#tool'" pagination=true pageList=[4,5] pageSize=5>
		<thead>
			<tr>
				<th data-options="field:'num',formatter:autoput">序号</th>
				<th data-options="field:'step_name'">步骤名称</th>
				<th data-options="field:'pre_step',formatter:putstate">步数</th>
				<th data-options="field:'positionId'">步骤用户</th>
				<th data-options="field:'_operate',width:300,align:'center',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="tool">
		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">添加</a>
		<a id="back" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">返回</a>
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
	    	//$(location).attr('href',"addstep.jsp");
	    	$.ajax({
	    		url:"clearsession.do",
				traditional:true,
	    	})
	    	$('#win').window('open');
	    	$('#win').window('refresh','jsp/addstep.jsp')
	    });
	});
	$(function(){
	    $('#back').bind('click', function(){
	    	var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
			var url = "jsp/showprocess.jsp";
			$('#desktop').tabs('update', {
				tab: tab,//被修改的标签页
				options: {
					title: "流程管理",//修改标签页标题
					href:url,//如果用URL就用href即可
					closable:true
				}
			});
	    });
	});
	function formatOper(val,row,index){
		//row-选中行的对象
		//index-选中行的编号
		return "<a href='javascript:;' onclick='send("+row.step_id+")'>修改</a>&nbsp;<a href='javascript:;' onclick='deleteinfo("+row.step_id+")'>删除</a>";
	}
	function send(step_id){
		$.ajax({
			url:"setstepid.do",
			traditional:true,
			data:{
				step_id:step_id,
			},
			type:"post"
		});
		$('#win').window('open');
    	$('#win').window('refresh','jsp/addstep.jsp')
	}
	function deleteinfo(step_id){
		$.ajax({
			url:"deletestep.do",
			traditional:true,
			data:{
				step_id:step_id,
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
	</script>
</body>
</html>