<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Register</title>
    
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />
		<script type="text/javascript" src="js/layui/layui.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script  type="text/javascript" src="js/register.js" charset="utf-8"></script>
	
   		<script>var basePath="<%=basePath%>";</script>
   			
	
  </head>
  
 <body>
		<div style="margin-top: 10%;margin-left: 30%;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" id="uname" name="title" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
				<div class="layui-input-inline"> 
					<input type="password" id="pwd" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码</label>
				<div class="layui-input-inline"> 
					<input type="password" id="pwd2" name="password" required lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline"> 
					<input type="text" id="tel" name="password" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
			</div>
		</form>
		<div class="layui-input-block">
					<button class="layui-btn"  onclick=register()>确定</button>
					<button class="layui-btn layui-btn-primary" onclick="window.location.href='login.jsp'">返回</button>
				
				</div>
		</div>
	</body>
</html>
