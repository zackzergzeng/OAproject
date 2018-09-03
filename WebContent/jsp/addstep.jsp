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
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	    <form id="ff">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>步骤名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="step_name" id="step_name" value="${step.step_name }" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>步骤号:</td>
	    			<td><input class="easyui-textbox" type="text" name="pre_step" id="pre_step" value="${step.pre_step }" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>步骤用户:</td>
	    			<td><input class="easyui-textbox" type="text" name="positionId" id="positionId" data-options="required:true"></input></td>
	    			<!-- <td><select id="jobCombobox" class="easyui-combobox" style="width:200px"></select></td> -->
	    		</tr>
	    	</table>
	    	<div style="text-align:center;padding:5px">
	    		<c:if test="${isupdate!=1 }">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitinfo(0)">提交</a>
	    		</c:if>
	    		<c:if test="${isupdate==1 }">
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitinfo(1)">提交</a>
	    		</c:if>
	    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
	    	</div>
	    </form>
	<script> 
		function submitinfo(t){
			var step_name=$('#step_name').val();
			var pre_step=$('#pre_step').val();
			var positionId=$('#positionId').val();
			alert(step_name);
			var neourl='';
			if(t==0){
				neourl="addstep.do";
			}else if(t==1){
				neourl="updatestep.do";
			}
			$.ajax({
				url:neourl,
				traditional:true,
				data:{
					step_name:step_name,
					pre_step:pre_step,
					positionId:positionId
				},
				type:"post",
				success:function(){
					var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
					var url = "jsp/showstep.jsp";
					$('#desktop').tabs('update', {
						tab: tab,//被修改的标签页
						options: {
							title: "我的流程",//修改标签页标题
							href:url,//如果用URL就用href即可
							closable:true
						}
					});
					$('#win').window('close');
				}
			});
		}
		$(function(){
			$('#jobCombobox').combobox({
				url:'showLogType.do',
				valueField:'lpid',
				textField:'lname',
				editable:false
			});  
		})
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>