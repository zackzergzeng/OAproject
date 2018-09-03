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
</head>
<body>
<ul class="easyui-tree" data-options="url:'jsp/treeData.jsp',onClick:myTreeClick"></ul>
<script type="text/javascript">
	function myTreeClick(node){
		//添加tabs页;
		if ($('#desktop').tabs('exists', node.text)){
	        $('#desktop').tabs('select', node.text);
	    } else{
	    	if(node.text=="流程管理"){
				$("#desktop").tabs("add",{
					title:node.text,
					href:'jsp/showprocess.jsp',
					closable:true
				});
			}
			if(node.text=="添加流程"){
				$.ajax({
					url:"showprocesstype.do",
					traditional:true,
					type:"post",
					success:function(){
						$("#desktop").tabs("add",{
							title:node.text,
							href:'jsp/startprocess.jsp',
							closable:true
						});
					}
				});
			}
			if(node.text=="我的流程"){
				$("#desktop").tabs("add",{
					title:node.text,
					href:'toshowmyprocess.do',
					closable:true
				});
			}
	    }
	}
</script>
</body>
</html>