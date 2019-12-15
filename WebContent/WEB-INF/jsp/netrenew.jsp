<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.stupaysys.po.*"%>
    <%
	User user = (User) session.getAttribute("USER_SESSION");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宽带续费</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layui.css">
<style type="text/css">
body{
	background-color: #fffffe;
}
</style>
</head>
<body>
<!-- <h1>宽带续费</h1> -->
	<div class="layui-main site-inline" style="margin-top: 10px;">
		  <h1 class="site-h1">用户宽带续费</h1>
		  <hr>
      		<blockquote class="site-text layui-elem-quote">
  			
    		<form class="layui-form" lay-filter="selectCustForm">
    		<div class="layui-form-item" >
    		<label class="layui-form-label"></label><font style="font-size: 15px">在此处选择需要续费的用户</font>
    		</div>
    		 <div class="layui-form-item" >
    		 	<label class="layui-form-label">选择客户</label>
    		  		<div class="layui-input-inline">
   						<select  id="selectCustid" name="custid" lay-verify="" lay-search>
   							<!-- <option value="010">layer</option>
  							<option value="021">form</option>
 							 <option value="0571" >layim</option> -->
   						</select>
					</div> <div class="layui-input-inline">
					<button type="button" class="layui-btn layui-btn-normal" id='Btn_confirmCust'>确认选择</button>
					</div>
				</div>
				
		 </form>
		 </blockquote>
		 <blockquote class="site-text layui-elem-quote">
	<!-- <form class="layui-form" action=""> -->
	<div class="layui-form-item">
    <label class="layui-form-label">客户号</label>
    <div class="layui-input-inline">
      <input type="text" name="custid" required lay-verify="required" placeholder="请先选择用户" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  	<div class="layui-form-item">
    <label class="layui-form-label">客户名</label>
    <div class="layui-input-inline">
      <input type="text" name="custname" required lay-verify="required" placeholder="请先选择用户" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">所选套餐</label>
    <div class="layui-input-inline">
      <input type="text" name="choosebundle" required lay-verify="required" placeholder="请先选择用户" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">到期时间</label>
    <div class="layui-input-inline">
      <input type="text" name="vaildtime" required lay-verify="required" placeholder="请先选择用户" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">需缴费用</label>
    <div class="layui-input-inline">
      <input type="text" name="needtopay" required lay-verify="required" placeholder="请先选择用户" autocomplete="off" class="layui-input" disabled >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"></label>
    <div class="layui-input-inline">
      <button type="button" class="layui-btn layui-btn-disabled" id='Btn_CustRenew'>确认续费</button>
    </div>
  </div>
	<!-- </form> -->
	</blockquote>
	</div>
	
	
	<script src="${pageContext.request.contextPath}/resources/layui.js"></script>
		<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
	<script type="text/javascript">
	var datalist= ${ list };
	var datalistkeys = Object.keys(datalist[0]);
	var active;
	$(window).on('load', function(){
		var addUserSelectHtml='<option value="">请选择或搜索客户</option>';
		for(var i=0;i<datalist.length;i++)
		{
			addUserSelectHtml+='<option value="'+i+'">'+datalist[i][datalistkeys[0]]+datalist[i][datalistkeys[1]]+'</option>';
		}
		console.log(addUserSelectHtml);
		$('#selectCustid').html(addUserSelectHtml);
		renderSelect();
		$('#Btn_confirmCust').on('click',function(){
			var selectCustid = $('#selectCustid').val();
			if(selectCustid==''){
				layui.use(['layer'], function(){
					var $ = layui.jquery, layer = layui.layer; 
					layer.alert('请选择一个宽带客户', {icon: 2, title:'警告'});
				});
			}else{
				//alert($('#selectCustid').val());
			 var d1=$.ajax(
					 {url:'getsomebundleinfo',
						 data :{'bundleid': JSON.stringify(datalist[selectCustid][datalistkeys[6]])},
						 async:false,
						 type:'POST',
						 success: function(result){
							 console.log(result);
							 $("input[name='custid']").val(datalist[selectCustid][datalistkeys[0]]);
							 $("input[name='custname']").val(datalist[selectCustid][datalistkeys[1]]);
							 $("input[name='vaildtime']").val(datalist[selectCustid][datalistkeys[7]]);
							 $("input[name='choosebundle']").val(result['bundleinfo']);
							 $("input[name='needtopay']").val(result['bundleprice']);
							 $("#Btn_CustRenew").attr("class","layui-btn");
							 $("#Btn_CustRenew").on('click',function(){
								 /* var ordercreatedate = new Date(); */
								 layer.confirm('模拟支付', function(index){
									 /* var orderpaydate = new Date(); */
									 var orderid= randomNumber();
									 var ordercreateuserid = <%=user.getUserid()%> ;
									 var orderbundleid = datalist[selectCustid][datalistkeys[6]];
									 var orderstate = 1;
									 var ordercustid = datalist[selectCustid][datalistkeys[0]];
									 var neworder = {
										'orderid':	 orderid,
										/* 'ordercreatedate':	 ordercreatedate,
										'orderpaydate' :orderpaydate, */
										'ordercreateuserid':ordercreateuserid,
										'orderbundleid':orderbundleid,
										'orderstate':orderstate,
									 	'ordercustid':ordercustid
									 };
									 console.log(neworder);
									 
									 var d2=$.ajax(
											 {url:'renewNet',
												 data :{'neworder': JSON.stringify(neworder)},
												 async:false,
												 dataType:"text",
												 type:'POST',
												 success: function(result){
													 var obj = JSON.parse(result);
													 console.log(obj);
													 layer.alert(obj['mes']+ "<br>续费至"+obj['newvaliddate'], {icon: 1, title:'提示'});
													
												 }
												 
											  });
									 
									 
									 
									 layer.close(index);
									});
							 })
							}}
					 ); 
			//console.log(d1.responseText);
			}
			}
		);
		});
	
	
	layui.use(['table', 'form', 'layer'], function(){
		var table = layui.table;
		var form = layui.form;
		var $ = layui.jquery, layer = layui.layer; 
		
		  /* //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  }); */
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
</body>
</html>