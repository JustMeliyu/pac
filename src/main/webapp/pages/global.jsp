<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
%>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />

<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui/css/H-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/icheck/icheck.css" />	

<script type="text/javascript" src="<%=path%>/static/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/static/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/static/h-ui.admin/js/H-ui.admin.js"></script>

<script type="text/javascript">
	var error="网络连接异常...";
	
	//屏蔽readonly下按backspace键返回的功能
	$(document).keydown(
			function(e) {
				var event = arguments.callee.caller.arguments[0]|| window.event;// 修正浏览器兼容 
				var target = e.target;
				var tag = e.target.tagName.toUpperCase();
				if (event.keyCode == 8) {
					if ((tag == 'INPUT' && !$(target).attr("readonly"))
							|| (tag == 'TEXTAREA' && !$(target)
									.attr("readonly"))) {
						if ((target.type.toUpperCase() == "RADIO")
								|| (target.type.toUpperCase() == "CHECKBOX")) {
							return false;
						} else {
							return true;
						}
					} else {
						return false;
					}
				}
	});
	
	//失败消息
	function failInfo(msg){
		layer.msg(msg, {icon:5,time:1500,offset:'rb'});	
	}
	//成功消息
	function successInfo(msg){
		layer.msg(msg,{icon:1,time:1500,offset:'rb'});
	}
</script>
