$(document).ready(function(){
	console.log("author：1313 10  刘佳利");
});

layui.use('form', function(){
  var form = layui.form;
  form.render();
  
form.on('select(filter)', function(data){
	if(data.value=="DIY"){
		$("#divTel").css("display","block");
	}
	else{
		$("#divTel").css("display","none");
	}
});
});      



function encrypt(){
	var str=$("#str").val().trim();
	var encType=$("#encType").val();
	var id=GetQueryString("id");
	var param={};
	param.str=str;
	param.encType=encType;
	param.uuid=id;
	
	if(str==""||encType==0){
		layui.use('layer', function(){
			  var layer = layui.layer;
			  
			  layer.msg('请输入明文并选择加密方式！');
			});   
	}else{
			$.ajax({
			url:basePath+"demo/encrypt.do",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(param),
			success: function(res){
				$("#encStr").val(res.encStr);
			},
			error: function(){
				layui.use('layer', function(){
					  var layer = layui.layer;
					  
					  layer.msg('加密失败！');
					});   
			}
		});
	}

	
	
}

function decrypt(){
	var encStr=$("#encStr").val().trim();
	var encType=$("#encType").val();
	var decKey=$("#decKey").val().trim();
	var id=GetQueryString("id");
	if(encStr==""){
		alert("请输入密文！");
	}else if(encType=="0"){
		alert("请选择解密方式！");
	}
	else if(encType=="DIY"&&decKey.isempty){
		alert("请输入解密密钥");
	}else{
			var param={};
			param.encStr=encStr;
			param.encType=encType;
			param.decKey=decKey;
			param.uuid=id;
			$.ajax({
			
			url:basePath+"demo/decrypt.do",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(param),
			
			success: function(res){
				$("#str").val(res.str);
			},
			error: function(){
				alert("解密失败！");
			}
		});
	}

	
}

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)
    	 return  unescape(r[2]); 
     return null;
}



