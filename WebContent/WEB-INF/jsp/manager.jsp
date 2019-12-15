<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>用户信息管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layui.css">
<style type="text/css">
.layui-form.layui-border-box.layui-table-view {
	margin-top: 0;
}

</style>
</head>
<body>
	<table id="demo" lay-filter="demo">
		<thead id="thead"></thead>
		<tbody id="tbody">

		</tbody>
	</table>



	<script src="${pageContext.request.contextPath}/resources/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="LeftbarDemo">
		<div class="layui-item">

	<!--	<label class="layui-form-label">全局模糊搜索</label>-->
			<div class="layui-input-inline">
				<input type="text" name="seachinput" id="seachinput" autocomplete="off" placeholder="请输入搜索内容" class="layui-input"  />
			</div>
			<div class="layui-input-inline">
			<!--	<button id="seach_button" class="layui-btn layui-btn-sm">搜索</button> -->
	<!--<button type="button" id="seach_button" class="layui-btn layui-btn-warm layui-btn-radius">搜索</button>-->
			</div>
		</div>
	</script>
	<script>
	var datalist= ${ list };
	var datalistkeys = Object.keys(datalist[0]);
	var keynamemap = ${ keynamemap }; 
	
	layui.use(['table', 'form', 'layer'], function(){
		var table = layui.table;
		var form = layui.form;
		/*console.log(keynamemap['bundleid']); */
		 $(window).load(      
		            function (){
		            	 var tableheadData="<tr>";
		            	 //动态增加5个td,并且把data数组的五个值赋给每个td
		            	 for(var i=0;i<datalistkeys.length;i++){
		            		 tableheadData+="<th lay-data=\"{field:'"+datalistkeys[i]+"'}\" >"+keynamemap[datalistkeys[i]]+"</th>";
		            	 }
		          tableheadData+="<th lay-data=\"{fixed: 'right', title:'操作', align:'center', toolbar: '#barDemo'}\" >"+'操作'+"</th>";
		            	 tableheadData+="</tr>";
		            	 //现在tableData已经生成好了，把他赋值给上面的tbody
		            	 $("#thead").html(tableheadData);
		            	 
		            	 var tablebodyData="";
		            	 for(var i=0;i<datalist.length;i++){
		            		 tablebodyData+="<tr>";
		            		 for(var j=0;j<datalistkeys.length;j++){
		            			 var tddata=datalist[i][datalistkeys[j]];
		            			 if(typeof(tddata)=="undefined"){
		            				 tddata='';
		            			 }
		            			 tablebodyData+="<td>"+tddata+"</td>";
		            		 	}
		            		  tablebodyData+="<td></td>"; 
		            		 tablebodyData+="</tr>";
		            		 }
		            	 $("#tbody").html(tablebodyData);
		            	//转换静态表格
		            	  table.init('demo', {
		            		   height: 500 //设置高度
		            		   ,limit: 100 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
		            		   //支持所有基础参数
		            		   ,page: true
		            		   ,toolbar: '#LeftbarDemo'
		            		   ,defaultToolbar: [ {
		            			    title: '添加新数据' //标题
		            			        ,layEvent: 'add' //事件名，用于 toolbar 事件中使用
		            			        ,icon: 'layui-icon-add-1' //图标类名
		            			      },'filter', 'exports', 'print']
	            		   		,text: {none: '', 'undefined' : ''}
		            	  ,done: function (res, curr, count) {
		            		    console.log(res);
		            		    $("[data-field = 'userlimit']").children().each(function () {
		            		        if ($(this).text() == '1') {
		            		            $(this).html("<font color='#FFB800'>管理员</font>");
		            		        } else if ($(this).text() == '2') {
		            		            $(this).html("<font color='#01AAED'>客户经理</font>");
		            		        } else if ($(this).text() == '3') {
		            		            $(this).html("<font color='#5FB878'>客户</font>");
		            		        }
		            		    });
		            		    $("[data-field = 'userstate']").children().each(function () {
		            		        if ($(this).text() == '1') {
		            		            $(this).html("<font color='#009688'>正常使用</font>");
		            		        } else if ($(this).text() == '0') {
		            		            $(this).html("<font color='#FF5722'>暂停使用</font>");
		            		        } 
		            		    });
		            		    $("[data-field = 'orderstate']").children().each(function () {
		            		        if ($(this).text() == '1') {
		            		            $(this).html("<font color='#009688'>正常</font>");
		            		        } else if ($(this).text() == '0') {
		            		            $(this).html("<font color='#FF5722'>失效</font>");
		            		        } 
		            		    });
		            		    $("[data-field = 'bundlestate']").children().each(function () {
		            		        if ($(this).text() == '1') {
		            		            $(this).html("<font color='#009688'>正常</font>");
		            		        } else if ($(this).text() == '0') {
		            		            $(this).html("<font color='#FF5722'>失效</font>");
		            		        } 
		            		    });
		            		    $("[data-field = 'bundlevalidtime']").children().each(function () {
		            		        if ($(this).text() == '1') {
		            		            $(this).html("<font color='#009688'>1个月</font>");
		            		        } else if ($(this).text() == '12') {
		            		            $(this).html("<font color='#FF5722'>12个月</font>");
		            		        } 
		            		    });
		            		    //得到当前页码
		            		    console.log('当前页码='+curr);
		            		    //得到数据总量
		            		    console.log('数据总量='+count);
		            		}
		            		
		            		 });
		            		table.on('toolbar(demo)', function(obj){
		            		  var checkStatus = table.checkStatus(obj.config.id);
		            		  switch(obj.event){
		            		    case 'add':
		            		      {layer.msg('添加一行新数据');
		            		      var AddformHTML=' ';
			            	    	 for(var i=0;i<datalistkeys.length;i++){
					            		/*  tableheadData+="<th lay-data=\"{field:'"+datalistkeys[i]+"'}\" >"+keynamemap[datalistkeys[i]]+"</th>"; */
			            	    		 AddformHTML+='<div class="layui-form-item">'
			            	               +' <label class="layui-form-label">'+keynamemap[datalistkeys[i]]+'</label>'
			            	               +'   <div class="layui-input-block">'
			            	               +'     <input type="text" name="'+datalistkeys[i]+'" lay-verify="required" autocomplete="off" placeholder="请输入'+keynamemap[datalistkeys[i]]+'" class="layui-input" >'
			            	               +'    </div>'
			            	               +'        </div>';
			            	    	}
			            	    	 AddformHTML+= '<div class="layui-form-item" style="margin-top:40px"><div class="layui-input-block"><button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo12">确认添加</button><button type="reset" class="layui-btn layui-btn-primary">重置数据</button></div></div>';
			            	    	 $('#addform').html(AddformHTML);
			            	    	 var addlayeyopen = layer.open({
				            	    	  type: 1,
				            	    	  area: ['700px', '450px'],
				            	    	  maxmin: true,
				            	    	  title: "添加信息",
				            	    	  content: $('#popAddTest'),
				            	    	});
			            	    	 
			            	    	 form.on('submit(demo12)',function(message) {
				            	    	var mes= (message['field']);
			     		            	console.log(mes);
			     		            	var url='addone';
			     			            	switch(datalistkeys[0]){
			     			            	case 'userid':url+='user'; break;
			     			            	case 'orderid':url+='order'; break;
			     			            	case 'bundleid': url+='bundle'; break;
			     			            	case 'custid' : url+='customer'; break;
			     			            }
			     			            	
			     			            	/* console.log("tablebodyData.length"+tablebodyData.length); */
			     			            	//console.log("mes.length"+mes.length());
			     			            	/* var newrow = "<td>3003</td><td>牛度恩adasda</td><td>123456</td><td>3</td><td>1</td><td></td>"; */
			     			            	/* for(int i=0;i<mes) */
			     			            	/* newtablebodyData = tablebodyData.slice(0,-5)+newrow+'</tr>';
			     			            	console.log(newtablebodyData);
			     			            	$("#tbody").html(newtablebodyData);
			     			            	 table.init('demo', {}); */
			     			            	
			     			            	
			     		            	var d1=$.ajax({url:url,data :{'mes': JSON.stringify(mes)},async:false,type:'POST'});
			     		            	if(Number(d1.responseText)>=1){
			     		            		
			     		            		window.alert("添加成功");
			     		            	 
			     		            	}else{
			     		            		layer.msg('添加失败');
			     		            		return false;
			     		            	}
			     		            	
			     		            	layer.close(addlayeyopen);
			     		            	
			     		            });
			            	    	 
		            		    }
		            		    break;
		            		  };
		            		});
		            	//监听工具条 
		            	  table.on('tool(demo)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
		            	    var data = obj.data; //获得当前行数据
		            	    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		            	    var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
		            	   
		            	    if(layEvent === 'detail'){ //查看
		            	      //do somehing
		            	    } else if(layEvent === 'del'){ //删除
		            	      layer.confirm('真的删除行么', function(index){
		            	    	  
		            	    	  var url='delone';
		            	switch(datalistkeys[0]){
		            	case 'userid':url+='user'; break;
		            	case 'orderid':url+='order'; break;
		            	case 'bundleid': url+='bundle'; break;
		            	case 'custid' : url+='customer'; break;
		            	    	  }
		            	    	  var d1=$.ajax({url:url,data :{'trdata': JSON.stringify(obj.data)},async:false,type:'POST'});
		            	    	 console.log(Number(d1.responseText));
		            	    	  if(Number(d1.responseText)>=1){
		            	    		  console.log('删除成功');
		            	    		  layer.msg('删除成功');
		            	    		  obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				            	        layer.close(index);
		            	    	  }else{
		            	    		  console.log('删除失败');
		            	    		  layer.msg('删除失败');
		            	    		  layer.close(index);
		            	    		 
		            	    	  }
		            	        
		            	       
		            	      });
		            	    } else if(layEvent === 'edit'){ //编辑
		            	      //do something
		            	      	var updateformHTML=' ';
		            	    	 for(var i=0;i<datalistkeys.length;i++){
				            		/*  tableheadData+="<th lay-data=\"{field:'"+datalistkeys[i]+"'}\" >"+keynamemap[datalistkeys[i]]+"</th>"; */
		            	    		 updateformHTML+='<div class="layui-form-item">'
		            	               +' <label class="layui-form-label">'+keynamemap[datalistkeys[i]]+'</label>'
		            	               +'   <div class="layui-input-block">'
		            	               +'     <input type="text" name="'+datalistkeys[i]+'" lay-verify="required" autocomplete="off" placeholder="请输入'+keynamemap[datalistkeys[i]]+'" class="layui-input" value="'+data[datalistkeys[i]]+'">'
		            	               +'    </div>'
		            	               +'        </div>';
		            	    	}
		            	    	 updateformHTML+= '<div class="layui-form-item" style="margin-top:40px"><div class="layui-input-block"><button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo11">确认修改</button><button type="reset" class="layui-btn layui-btn-primary">重置数据</button></div></div>';
		            	      	$('#updateform').html(updateformHTML);
		            	    	 
		            	      /* layer.msg('EDIT'); */
		            	      var editlayeyopen = layer.open({
		            	    	  type: 1,
		            	    	  area: ['700px', '450px'],
		            	    	  maxmin: true,
		            	    	  title: "修改信息",
		            	    	  content: $('#popUpdateTest'),
		            	    	});
		            	      
		            	      form.on('submit(demo11)',function(message) {
		            	    	  
		            	var   mes= (message['field']);
		            	console.log(mes);
		            	 var url='updateone';
			            	switch(datalistkeys[0]){
			            	case 'userid':url+='user'; break;
			            	case 'orderid':url+='order'; break;
			            	case 'bundleid': url+='bundle'; break;
			            	case 'custid' : url+='customer'; break;
			            	    	  }
		            	var d1=$.ajax({url:url,data :{'mes': JSON.stringify(mes)},async:false,type:'POST'});
		            	if(Number(d1.responseText)>=1){
		            	obj.update(
		            		mes
	            	    );
		            	 layer.msg('修改成功');
		            	}else{
		            		layer.msg('修改失败');
		            	}
		            	layer.close(editlayeyopen);
		            	return false;
		            	      });
		              } /* else if(layEvent === 'LAYTABLE_TIPS'){
		            	      layer.alert('Hi，头部工具栏扩展的右侧图标。');
		            	    } */
		            	  });
		            	
		            	  
		            	/* 	function onSearch(){//js函数开始
		            			  setTimeout( 
		            					  function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
		            					
		            						  
		            			  
		            			 },200);//200为延时时间 
		            			} */
		            
		            		/* $('#seach_button').on('click',function(){ */
		            			$('#seachinput').on('input',function(){
		            				setTimeout( 
			            					  function(){
		            			  var storeId = document.querySelector("body > div.layui-form.layui-border-box.layui-table-view > div.layui-table-box > div.layui-table-body.layui-table-main > table");//获取table的id标识
		            			    var rowsLength = storeId.rows.length;//表格总共有多少行
		            			    console.log(rowsLength);
		            			    var colsLength=   storeId.rows[0].cells.length-1;
		            			    var key = $('#seachinput').val();//获取输入框的值
		            			    /*  var searchCol = 0;//要搜索的哪一列，这里是第一列，从0开始数起  */
		            			   
		            			    for(var i=0;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
		            			    	 for (var searchCol = 0;searchCol<colsLength; searchCol++) {
		            			    
		            			      var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
		            			      if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
		            			        storeId.rows[i].style.display='';//显示行操作，
		            			        console.log('no'+i)
		            			        break;
		            			      }else{
		            			        storeId.rows[i].style.display='none';//隐藏行操作
		            			        console.log('hide'+i)
		            			      }
		            			    }
		            			    }
			            					  },200);
		            		}); 	
		            
		            
		            }); 
		 
				});
	 
			</script>
	<div class="layui-row" id="popUpdateTest"
		style="padding: 20px; display: none;">
		<div class="layui-col-md10">
			<form class="layui-form layui-from-pane" action=""
				style="margin-top: 20px" id="updateform">

				<!-- <div class="layui-form-item">
                <label class="layui-form-label">eqptName</label>
                <div class="layui-input-block">
                    <input type="text" name="neweqptName"  required  lay-verify="required" autocomplete="off" placeholder="请输入采集设备名称" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" style="margin-top:40px">
                <div class="layui-input-block">
                    <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo11">确认修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置数据</button>
                </div>
            </div> -->
			</form>
		</div>
	</div>
	<div class="layui-row" id="popAddTest"
		style="padding: 20px; display: none;">
		<div class="layui-col-md10">
			<form class="layui-form layui-from-pane" action=""
				style="margin-top: 20px" id="addform"></form>
		</div>
	</div>
</body>
</html>