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
<link rel="stylesheet" href="css/bootstrap.css"/>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>流程填写</h1>
<div class="col-md-2"></div>
<div class="col-md-8">
	<form>
		<c:forEach items="${alist }" var="a">
		<c:if test="${a.ismain==1 }">
		  <div class="form-group">
		    <label for="exampleInputEmail1">${a.attrname }</label>
		    <input type="text" class="form-control" name="attr" id="${a.attrid }" placeholder="${a.attrname }">
		  </div>
		</c:if>
		</c:forEach>
		<c:forEach items="${alist }" var="a">
		<c:if test="${a.ismain==0 }">
		  <div class="form-group">
		    <label for="exampleInputEmail1">${a.attrname }</label>
		    <input type="text" class="form-control" name="attr" id="${a.attrid }" placeholder="${a.attrname }">
		  </div>
		</c:if>
		</c:forEach>
	  <button type="button" class="btn btn-default" id="tj">Submit</button>
	</form>
</div>
<script type="text/javascript">
	$("#tj").click(function(){
		var obj=[]
		$("input").each(function(){
			if($(this).attr("name")=="attr"){
				var nobj={}
				nobj.id=$(this).attr("id");
				nobj.value=$(this).val();
				obj.push(nobj);
			}
		})
		obj=JSON.stringify(obj);
		$.ajax({
			url:"adduserprocessattr.do",
			traditional:true,
			dataType:'json',
			data:{
				params:obj
			},
			type:"post",
			success:function(){
				alert("ok")
				var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
				var url = "jsp/myprocess.jsp";
				$('#desktop').tabs('update', {
					tab: tab,//被修改的标签页
					options: {
						title: "我的流程",//修改标签页标题
						href:url,//如果用URL就用href即可
						closable:true
					}
				});
			},
			error:function(){
				alert("error");
			}
		});
		//var tab = $('#desktop').tabs('getSelected');//获取选中的标签页
		//var url = "jsp/myprocess.jsp";
		//$('#desktop').tabs('update', {
		//	tab: tab,//被修改的标签页
		//	options: {
		//		title: "我的流程",//修改标签页标题
		//		href:url,//如果用URL就用href即可
		//		closable:true
		//	}
		//});
	})
</script>
</body>
</html>