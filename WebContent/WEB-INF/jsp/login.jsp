<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>登录</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
	<style type="text/css">
		body{
		/* vertical-align:middle; */
		background-image: url(resources/images/networks.jpg);
		}
		 #div_login{
		 margin: 20vh auto 0;
			text-align:center;
			opacity: 0.9;
		} 
		#div_login_in{
			width:300px;
		   background-color: rgba(255, 255, 255, 0.92);
			/* margin : 50px 20px 50px 20px; */
			padding: 50px 20px 50px 20px;
			border :0px solid;
			border-radius: 4px;
		}
		.layui-btn{
		width: 100%;
		margin-top: 8px;
		}
		.layui-form-item {
     margin-bottom: 8px;
     }
     footer {
     text-align:center;
    background-color: #FFF;
    position: fixed;
      bottom: 0px;
      width:100%;
      height:25px;
    z-index: 9999;
    opacity: 0.85;
}
h2 {
font-weight: bold;
        width: 100%;
        margin-top: 10px;
    margin-bottom: 10px;
}
	</style>
</head>

<body>
<div id="div_login" >

        <div class="layui-inline" id='div_login_in'>
	<h2>校园宽带缴费管理系统</h2>
	<form action="${pageContext.request.contextPath }/login" method="post" class="layui-form layui-form-pane">
		<!-- <table>
			<tr>
				<td>USERNAME:</td>
				<td><input type="text" name="username" class="layui-input"></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password" class="layui-input"></td>
			</tr>
			<tr>
				<td><input type="submit" value="LOGIN" class="layui-btn"></td>
			</tr>
		</table> -->
		<div class="layui-form-item">
			<!-- <label class="layui-form-label">用户名</label> -->
			<!-- <div class="layui-input-block" > -->
				<input type="number" name="userid" autocomplete="off" placeholder="请输入用户账号" class="layui-input" value='1000'>
			<!-- </div> -->
		</div>
		<div class="layui-form-item">
			<!-- <label class="layui-form-label">密码</label> -->
			<!-- <div class="layui-input-block"> -->
				<input type="password" name="userpassword" autocomplete="off" placeholder="请输入密码" class="layui-input" value='123456'>
			<!-- </div> -->
		</div>
		<div class="layui-form-item">
			<!-- <label class="layui-form-label"></label> -->
			<!-- <div class="layui-input-block"> -->
				<input type="submit" value="登录" class="layui-btn" ><br>
				
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			<!-- </div> -->
			
		</div>
	</form>
	
	<button data-method="notice" class="layui-btn" id="btn_notice" style="Display:none;">示范一个公告层</button>
	</div>
	</div>
	
	<footer>
 
    <p>&copy; 2019 计科164 叶重涵 & &nbsp; <a href="http://www.layui.com">layui.com</a> </p>
    
	
	</footer>
	
	
	<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
	<script>
	var active;
		layui.use('layer', function () { //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

			//触发事件
			 active = {
				notice: function () {
					//示范一个公告层
					layer.open({
						type: 1
						, title: false //不显示标题栏
						, closeBtn: false
						, area: '300px;'
						, shade: 0.8
						, id: 'LAY_layuipro' //设定一个id，防止重复弹出
						, btn: ['返回']
						, btnAlign: 'c'
						, moveType: 1 //拖拽模式，0或者1
						, content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">出现错误！<br>错误信息如下：<br><br>${ msg }<br></div>'
						, success: function (layero) {
							/* var btn = layero.find('.layui-layer-btn');
							btn.find('.layui-layer-btn0').attr({
								href: 'http://www.layui.com/'
								, target: '_blank'
							}); */
						}
					});
				}
			};

			$('#btn_notice').on('click', function () {
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
			
		});
	</script>
	<script type="text/javascript">
	$(window).on('load', function(){
	var msg = '${ msg }';
	var m=0;
	var b = $('#btn_notice');
	 if (msg != ''&&m==0) {
 		m++;
 		$("#btn_notice")[0].click();
 		/* $('#btn_notice').trigger('click'); */
 		console.log('Trigger'); 
	} 
	} );

	</script>
</body>

</html>