<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.stupaysys.po.*"%>
<%
	User user = (User) session.getAttribute("USER_SESSION");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>欢迎来到校园宽带缴费管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layui.css">
<style type="text/css">
iframe {
	position: absolute;
	width: 100%;
	height: calc(100% - 44px);
	border: none;
}
/* .layui-layout-admin .layui-header {
    background-color: #001345;
} */
/* #tab {
	width: 100%;
} */

.layui-tab {
	margin: 0px;
	text-align: left !important;
}

.layui-tab-content {
	padding: 0px;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">校园宽带缴费管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<!-- <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul> -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <i class="layui-icon layui-icon-username"></i> <%=user.getUsername()%>
				</a></li>
				<li class="layui-nav-item"><a href="logout"><i class="layui-icon layui-icon-close-fill"></i> 退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item">  <a href=""><i class="layui-icon layui-icon-home"></i> 系统主页</a></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;"><i class="layui-icon layui-icon-website"></i> 宽带业务</a>
						<dl class="layui-nav-child">
							<dd>
								<a class="site-demo-active" data-type="tabAdd"
									data-url='findallbundle' data-id='asdlmanager'><i class="layui-icon layui-icon-component"></i> 宽带套餐管理</a>
							</dd>
							<dd>
								<a class="site-demo-active" data-type="tabAdd"
									data-url='findallcustomer' data-id='customermanager'><i class="layui-icon layui-icon-component"></i> 宽带客户管理</a>
							</dd>
							<dd>
								<a class="site-demo-active" data-type="tabAdd"
									data-url='findallorder' data-id='ordermanager'><i class="layui-icon layui-icon-component"></i> 宽带订单管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a class="site-demo-active" data-type="tabAdd"
									data-url='findalluser' data-id='userinfomanager'><i class="layui-icon layui-icon-user"></i> 用户管理</a></li>
					<li class="layui-nav-item"><a class="site-demo-active" data-type="tabAdd"
									data-url='netrenew' data-id='netrenew'><i class="layui-icon layui-icon-set"></i> 宽带续费</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body layui-from">
			<!-- 内容主体区域 -->
			<!-- <iframe src="http://www.baidu.com"></iframe> -->
			<div id="tab" class="layui-tab layui-tab-card" lay-allowclose="true" 	lay-filter="demo">
				<ul class="layui-tab-title">
					<li class="layui-this">主页</li>
					
				</ul>
				<div class="layui-tab-content" style="height: 150px;">
					<div class="layui-tab-item layui-show">
						<iframe src="newnetadd"></iframe>
						<%-- <div style="width: 100%;height: 500px;">
						欢迎 <%=user.getUsername()%> 来到 <br>
						校园宽带缴费管理系统
						</div> --%>
					</div>
					
				</div>
			</div>
			<!--  <div style="padding: 15px;">内容主体区域</div> -->
		</div>

		<div class="layui-footer" style="text-align: center;">
			<!-- 底部固定区域 -->
			© 计科16404 叶重涵 校园宽带缴费管理系统
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
	<script>
		layui.use('element', function() {
			var $ = layui.jquery, element = layui.element;

			var active = {
				tabAdd : function(url, id, name) {
					element.tabAdd('demo', {
						title : name,
						content : '<iframe src="'+url+'"></iframe>',
						id : id
					})

				},
				tabChange : function(id) {
					element.tabChange('demo', id);
				}

			};
			/* https://blog.csdn.net/weixin_44545501/article/details/93913691 */

			$('.site-demo-active').on(
					'click',
					function() {
					/* 	console.log('A'); */
						var data = $(this);
						/* var othis = $(this), type = othis.data('type');
						active[type] ? active[type].call(this, othis) : ''; */
						var isOpen = false;
						$.each($('.layui-tab-title li[lay-id]'),function (){
								if($(this).attr('lay-id') == data.attr('data-id')){
									isOpen=true;
								}
							}		
						)
						if (isOpen==false){
						active.tabAdd(data.attr('data-url'), data
								.attr('data-id'), data.text());
						}
						active.tabChange(data.attr('data-id'));
					});
		});
	</script>
</body>
</html>