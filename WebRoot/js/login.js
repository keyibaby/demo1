	layui.use('form', function(){
		  var form = layui.form;
		  
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});

function login(){
	var uname=$("#uname").val().trim();
	var pwd=$("#pwd").val().trim();
	var param={};
	param.uname=uname;
	param.pwd=pwd;
	if(uname==""||pwd==""){
//		alert("请输入用户名和密码！");
		layui.use('layer', function(){
			  var layer = layui.layer;
			  layer.msg('请输入用户名和密码！');
			});              
			     
	}else{
		$.ajax({
			url:basePath+"demo/login.do",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(param),
			success: function(res){
				console.log(res);
				if(res.uuid!=""){
					window.location.href="encrypt.jsp?"+"id="+res.uuid;
				}
				else{
					layui.use('layer', function(){
						  var layer = layui.layer;
						  layer.msg('用户名密码错误！');
						});   
				}
			},
			error: function(res){
				console.log(res);
				layui.use('layer', function(){
					  var layer = layui.layer;
					  layer.msg('登录失败，请稍后再试！');
					});   
			}
		});
	}	
		
}
