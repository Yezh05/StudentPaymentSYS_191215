<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="edu.stupaysys.po.*"%>
    <%
	User user = (User) session.getAttribute("USER_SESSION");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新开户页面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layui.css">
	<style type="text/css">
body{
	background-color: #fffffe;
}
</style>
</head>
<body>
		<div class="layui-main site-inline" style="margin-top: 10px;">
		  <h1 class="site-h1">宽带新开户页面</h1>
		  <hr>
      		<blockquote class="site-text layui-elem-quote">
      		<form class="layui-form" action="" id="addNetForm"> 
	<div class="layui-form-item">
    <label class="layui-form-label">客户号</label>
    <div class="layui-input-inline">
      <input type="text" name="custid" required lay-verify="required" placeholder="在此处填写客户号" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  	<div class="layui-form-item">
    <label class="layui-form-label">客户名</label>
    <div class="layui-input-inline">
      <input type="text" name="custname" required lay-verify="required" placeholder="在此处填写客户名" autocomplete="off" class="layui-input"  >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">所在宿舍</label>
    <div class="layui-input-inline">
      <input type="text" name="custdor" required lay-verify="required" placeholder="在此处填写所在宿舍" autocomplete="off" class="layui-input"  >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系电话</label>
    <div class="layui-input-inline">
      <input type="text" name="custphone" required lay-verify="required" placeholder="在此处填写联系电话" autocomplete="off" class="layui-input"  >
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">所选套餐</label>
    
    <div class="layui-input-inline">
   						<select  id="selectBundleid" name="bundleid" lay-verify="" lay-search>
   						
   						</select>
    </div> <div class="layui-input-inline">
					<button type="button" class="layui-btn layui-btn-normal" id='Btn_confirmBundle'>确认选择</button>
					</div>
  </div>
  
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">需缴费用</label>
    <div class="layui-input-inline">
      <input type="text" name="needtopay" id="needtopay" required lay-verify="required" placeholder="请先选择宽带套餐" autocomplete="off" class="layui-input" disabled="disabled" >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"></label>
    <div class="layui-input-inline">
      <button type="button" class="layui-btn" id='Btn_AddnewNet'>确认提交</button>
    </div>
  </div>
	 </form> 	
      		</blockquote>
      	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
		<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
	<script type="text/javascript">
	var needinfo;
	var bundlelist
	$(window).on('load', function(){
		var d1=$.ajax(
				 {url:'getNeedinfo',
					 /* data :{'bundleid': JSON.stringify(datalist[selectCustid][datalistkeys[6]])}, */
					 async:false,
					 type:'POST',
					success: function(result){
						needinfo=result;
					}	 
				 });
		console.log(needinfo);
		bundlelist = needinfo['bundle_list'];
		var addSelectHtml='<option value="">请选择或搜索宽带套餐</option>';
		for(var i=0;i<bundlelist.length;i++)
		{
			addSelectHtml+='<option value="'+i+'">'+bundlelist[i]['bundlename']+'</option>';
		}
		console.log(addSelectHtml);
		$('#selectBundleid').html(addSelectHtml);
		
		renderSelect();
		$('#Btn_confirmBundle').on('click',function(){
			$('#needtopay').val(bundlelist[$('#selectBundleid').val()]['bundleprice']);
		});
		 $("input[name='custid']").val(needinfo['newKey']);
		 $("#Btn_AddnewNet").on('click',function(){
			 
			 var custid =  $("input[name='custid']").val();
			 var custname =  $("input[name='custname']").val();
			 var custdor =  $("input[name='custdor']").val();
			 var custphone =  $("input[name='custphone']").val();
			 var bundleid =  bundlelist[$('#selectBundleid').val()]['bundleid'];
			 var needtopay =  $("input[name='needtopay']").val();
			 if(custid==""||custname==""||custdor==""||custphone==""||bundleid==""||needtopay==""){
				 layer.alert('请完整填写信息');
			 }else{
				 var orderid=randomNumber();
				 var newdatamap={
						 "custid": custid.toString(),
						 "custname": custname.toString(),
						 "custdor": custdor.toString(),
						 "custphone": custphone.toString(),
						 "bundleid": bundleid.toString(),
						 "custcreateid" : (<%= user.getUserid()%>).toString(),
						 'orderid':	 orderid.toString()
				 };
			 	layer.confirm('模拟支付', function(index){
			 		 var d2=$.ajax(
							 {url:'handleaddnew',
								 data :{'newdatamap': JSON.stringify(newdatamap)},
								 async:false,
								 type:'POST',
								 success: function(result){
									 layer.alert(result['mes']);
								 },
								 error:function(result){
									 layer.alert(result['mes']);
								 }
							  });
			 		
			 		 layer.close(index);
			 	});
			 	}
		 });
		 
		 
	});
	
	
	
	function renderSelect(){
	 	layui.use('form', function(){
		var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
		  form.render('select');
		});
	 	
	}
	function randomNumber() {
		var vNow = new Date();
		var sNow = "";
        sNow += String(vNow.getFullYear());
        sNow += String(vNow.getMonth() + 1);
        sNow += String(vNow.getDate());
        var randomNum = Math.random()
        var checkCode = randomNum*90;
				checkCode +=10;
        sNow += String(checkCode);
	    return parseInt(sNow);
	   }
	</script>
</html>