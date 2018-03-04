$(function(){
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
	 //手机号格式是否正确的失去焦点验证
	 $("#tel").change(function(){
		 var tel=$("#tel").val();
		 if(!isTel(tel)){
			 layui.use('layer', function(){
				  var layer = layui.layer;
				  layer.msg('手机号格式有误！');
				});	
		 }
	 });
	 //用户名是否存在的失去焦点验证
	 $("#uname").change(function(){
		 var uname=$("#uname").val().trim();
		 var param={};
		 param.uname=uname;
		 $.ajax({
				url:basePath+"demo/isUserExists.do",
				type:"post",
				dataType:"json",
				contentType:"application/json",
				data:JSON.stringify(param),
				success: function(res){
					if(res>0){
						layui.use('layer', function(){
							  var layer = layui.layer;
							  layer.msg('用户名已被注册！');
							});   
					}
				},
				error: function(){
					layui.use('layer', function(){
						  var layer = layui.layer;
						  layer.msg('error！');
						});   
				}
			});
	 });
});

function register(){
	var uname=$("#uname").val().trim();
	var pwd=$("#pwd").val().trim();
	var pwd2=$("#pwd2").val().trim();
	var tel=$("#tel").val().trim();
	var param={};
	param.uname=uname;
	param.pwd=pwd;
	param.tel=tel;
		if(uname==""||pwd==""||tel==""){
			layui.use('layer', function(){
				  var layer = layui.layer;
				  layer.msg('信息不完整！');
				});   
		}else if(pwd!=pwd2){
			layui.use('layer', function(){
				  var layer = layui.layer;
				  
				  layer.msg('两次输入密码不一致！');
				});   
		}else if(!isTel(tel)){
			layui.use('layer', function(){
				  var layer = layui.layer;
				  layer.msg('手机号格式有误！');
				});   
		}else{
				console.log(param);
			$.ajax({
				url:basePath+"demo/register.do",
				type:"post",
				dataType:"json",
				contentType:"application/json",
				data:JSON.stringify(param),
				
				success: function(res){
					console.log(res);
					if(res>0){
						layui.use('layer', function(){
							  var layer = layui.layer;
							  layer.msg('注册成功！');
							});	
						//tocheck
						window.setTimeout("window.location='login.jsp'",2000); 
					}else{
						layui.use('layer', function(){
							  var layer = layui.layer;
							  layer.msg('用户名已被注册！');
							});	
					}
					   
				},
				error: function(){
					layui.use('layer', function(){
						  var layer = layui.layer;
						  
						  layer.msg('注册失败！');
						});   
				}
			});
		}
}

function isTel(telNum){
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	if(!myreg.test(telNum) )
	{ 
	    return false; 
	}else{
		return true;
	}
}

