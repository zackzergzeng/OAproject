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
	    			<td>流程名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="processName" id="processName" value="${upbi.pName }" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>流程类型:</td>
	    			<td>
	    				<select class="easyui-combobox" name="ptId" id="ptId">
	    				<c:forEach items="${ptlist }" var="pt">
	    					<option value="${pt.ptId }">${pt.ptName }</option>
	    				</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>说明:</td>
	    			<td><input class="easyui-textbox" name="remarks" id="remarks" value="${upbi.remarks }" data-options="multiline:true" style="width:300px;height:100px"></input></td>
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
			var processName=$('#processName').val();
			var ptId=$('#ptId').find('option:selected').attr('value');
			var remarks=$('#remarks').val();
			var neourl='';
			if(t==0){
				neourl="addprocess.do";
			}else if(t==1){
				neourl="updateprocessinfo.do";
			}
			$.ajax({
				url:neourl,
				traditional:true,
				data:{
					processName:processName,
					ptId:ptId,
					remarks:remarks
				},
				type:"post",
				success:function(){
					var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
					var url = "jsp/showprocess.jsp";
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
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>