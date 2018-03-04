<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Encrypt and Dectypt</title>
     <meta charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
	 <style>
	 	.textBox{
	 		width:300px;
	 	}
	 </style>
        <script type="text/javascript" src="js/layui/layui.js"> </script>
        <script type="text/javascript" src="js/jquery.min.js"> </script>
         <script  charset="utf-8" language="javascript"  type="text/javascript" src="js/encrypt.js"> </script>
		<script src="js/encrypt.js"></script>
		<script>var basePath="<%=basePath%>";</script>
   		

  </head>
  
  <body>
		    <div class="layui-form" style="margin-top: 10%;margin-left: 30%;">
    	
			  <div class="layui-form-item">
				<label class="layui-form-label">明文：</label>
				<div class="layui-input-inline">
					<input type="text" id="str" name="title" required lay-verify="required" autocomplete="off" class="layui-input  textBox">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密文：</label>
				<div class="layui-input-inline">
					<input  id="encStr"  required lay-verify="required" autocomplete="off" class="layui-input textBox">
				</div>
			</div>
			<div class="layui-form-item">
		    <label class="layui-form-label">加/解密方式：</label>
		    <div class="layui-input-inline">
		      <select id="encType" lay-filter="filter" class="textBox">
		        <option value="0"></option>
		        <option value="MD5">MD5</option>
		        <option value="DES">DES</option>
		        <option value="DIY">DIY</option>
		      </select>
		    </div>
		  </div>
		  	<div class="layui-form-item" style="display:none" id="divTel" >
				<label class="layui-form-label">手机号：</label>
				<div class="layui-input-inline">
					<input  id="decKey"  required lay-verify="required" autocomplete="off"  placeholder="解密密钥为注册时手机号加密后的消息摘要"  class="layui-input textBox">
				</div>
			</div>
		<div >
			
				<div class="layui-input-block">
					<button class="layui-btn" onclick="encrypt()">加密</button>
					<button class="layui-btn" onclick="decrypt()">解密</button>
				</div>
			</div>
    	</div>	
 	</body>
</html>
