function login(){
	var ajax_option={  
			url:basePath+"demo/login.do",
			contentType:"application/json",
			success: function(res){
			console.log(res);
			if(res.uuid!=""){
				window.location.href="encrypt.jsp?"+"id="+res.uuid;
			}
			else{
				layui.use('layer', function(){
					  var layer = layui.layer;
					  layer.msg('�û����������');
					});   
			}
			
			}
	
	}
	$("#form").ajaxSubmit();
}
	
	
//	$.ajax({
//		url:basePath+"demo/login.do",
//		type:"post",
//		dataType:"json",
//		contentType:"application/json",
//		data:JSON.stringify(param),
//		success: function(res){
//			console.log(res);
//			if(res.uuid!=""){
//				window.location.href="encrypt.jsp?"+"id="+res.uuid;
//			}
//			else{
//				layui.use('layer', function(){
//					  var layer = layui.layer;
//					  layer.msg('�û����������');
//					});   
//			}
//		},
//		error: function(res){
//			console.log(res);
//			layui.use('layer', function(){
//				  var layer = layui.layer;
//				  layer.msg('��¼ʧ�ܣ����Ժ����ԣ�');
//				});   
//		}
//	});
	
	
	
	
    
