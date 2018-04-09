<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui/css/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/Hui-iconfont/1.0.7/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/h-ui.admin/css/style.css" />
<%-- 	<link rel="stylesheet" type="text/css" href="<%=path%>/static/icheck/icheck.css" />	 --%>
	
	<script type="text/javascript" src="<%=path%>/static/jquery/1.9.1/jquery.min.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.js"></script> 
	<script type="text/javascript" src="<%=path%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<script type="text/javascript" src="<%=path%>/static/layer/3.0.1/layer.js"></script> 
	</head>
	<body>	
		<div class="loginWraper"></div>
		<header class="navbar-wrapper">
			<div class="navbar navbar-fixed-top">
				<div class="container-fluid cl"> 
				<a class="logo navbar-logo f-l mr-10 hidden-xs"><img src="<%=path%>/static/h-ui.admin/images/title.png"/></a> 
				<a class="logo navbar-logo-m f-l mr-10 visible-xs"><img src="<%=path%>/static/h-ui.admin/images/title.png"/></a> 
				<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
					
				<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
							<li>欢迎您：</li>
							
							<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">						
									<li><a href="javascript:;" data-val="blue" title="经典蓝">经典蓝(默认)</a></li>
									<li><a href="javascript:;" data-val="default" title="经典黑">经典黑</a></li>
									<li><a href="javascript:;" data-val="green" title="经典绿">经典绿</a></li>
									<li><a href="javascript:;" data-val="red" title="经典红">经典红</a></li>
<!-- 									<li><a href="javascript:;" data-val="landscape" title="山峰">山峰</a></li> -->
<!-- 									<li><a href="javascript:;" data-val="starry" title="璀璨星空">璀璨星空</a></li> -->
								</ul>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<div class="page-container">

			<div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">死信队列个数：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<span id="deadqueue"></span>条
					</div>
				</div>
				<!-- 工具栏 -->
				<div class="cl pd-5 bg-1 bk-gray mt-20"> 
					<span class="l">
						<a href="javascript:;" onclick="batchDel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 清空</a> 	
						<a class="btn btn-primary radius"  onclick="batchSend()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 重发</a>

					</span>  
				</div>
				
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			$.ajax({
	            type: "POST",
	            url:"<%=path%>/deadsize",
	            success: function(data) {
					  $("#deadqueue").html(data);
	            }
	          });	
		})
		function batchDel()
		{
			layer.confirm('确认清空记录？',function(index){	
				layer.close(index);			
				$.ajax({
		            type: "POST",
		            url:"<%=path%>/cleandeadlist",
		            success: function(data) {
		               if(data == 1){
						  layer.msg("清除成功",{icon:1,time:1500});
						}else{
						  layer.msg("异常",{icon:2,time:1500});
						}	
		            }
		          });	
			});
		}
		
		function batchSend()
		{
			layer.confirm('确认重发所有记录？',function(index){	
				layer.close(index);			
				$.ajax({
		            type: "POST",
		            url:"<%=path%>/resend",
		            success: function(data) {
		               if(data == 1){
						  layer.msg("异步发送中，请稍后",{icon:1,time:1500});
						}else{
						  layer.msg("异常",{icon:2,time:1500});
						}	
		            }
		          });	
			});
		}
	</script>
</html>