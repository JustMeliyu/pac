<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 transitional//EN">
<html>
<%
	String path = request.getContextPath();
%>
<head>

	<title>PAC后台管理系统</title>

	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content="后台管理系统">
	<meta name="description" content="后台管理系统">
			
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui/css/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/H-ui.admin.css" />
	<script type="text/javascript" src="<%=path%>/static/jquery/1.9.1/jquery.min.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/layer/3.0.1/layer.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript"> var contextPath = "${pageContext.request.contextPath}";</script>
</head>

<body>
	<div >
		
		<div id="loginform" class="loginBox_z" style="padding-top:100px">
			<form class="form form-horizontal" method="post">
				<table  class="loginTable_z" style="width:500px;margin-left:auto;margin-right:auto;">
					<tr>
						<td colspan="2" style="text-align:center;padding-bottom:20px">
						<img src="<%=path%>/static/h-ui.admin/images/logo.png"/>
						</td>
					</tr>
				  <tr>
				    <td width="70"><div class="loginTable_z_td">用户名</div></td>
				    <td width="270"><input id="username" name="username" type="text" value=""  class="input-text  size-L" ></td>
				  </tr>
				  <tr>
				    <td width="70"><div class="loginTable_z_td">密&nbsp;&nbsp;&nbsp;码</div></td>
				    <td width="270"><input id="password" name="password" type="password" value=""  class="input-text  size-L"></td>
				  </tr>
				  <tr height="100">
				    <td colspan="2">
				    <div align="center">
				    	<button id="login_btn" class="btn btn-primary radius size-L" type="button" style="width:100%" >登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
				    </div>
				    </td>
				  </tr>
				</table>
				<label id="social-login"></label>
			</form>
			
		</div>
		<div class="footer">Copyright ©2018 全球集运有限公司</div>
	</div>
    <script type="text/javascript">

		$(document).ready(function(){
			if (window != top) {
				top.location.href = location.href; 
			}
// 			$(document).bind("contextmenu",function(e){
// 		   		return false;
// 		    });
		});
		//按下回车键时的响应
		document.onkeydown=function(event){
		    var e = event || window.event || arguments.callee.caller.arguments[0];     
		     if(e && e.keyCode==13){ // enter 键
		         $("#login_btn").click();
		    }
		}; 
		$('#login_btn').on('click', function() {
			var uname=$('input[name="username"]').val();
			var pword=$('input[name="password"]').val();
			if(uname=="" || pword==""){			
				failInfo("用户名和密码不能为空！");
			}else{
					$.ajax({
		            type: "post",
		            url: contextPath + "/login",
		            data:{username:uname,password:pword},
		            dataType: "text",
		            success: function (data) {
		                if (data == "false") {		              
		                	//两种情况：1:用户名密码错误 2：用户被禁用
		                    failInfo("用户名或密码错误！");
		                    return false;
		                }else if(data == "unkownCredentials"){
		                	//两种情况：1:用户对应的角色被禁用 2：角色没有配置资源
		                     failInfo("该用户禁止访问!");
		                    return false;
		                }else{
		                	window.location= contextPath + "/admin/home";
		                	return false;
		                }
		            },
		            error: function (XMLHttpRequest, textStatus,errorThrown) {
		             	failInfo("网络连接异常");	
		                return false;
		            }
		        });
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
</body>
</html>
