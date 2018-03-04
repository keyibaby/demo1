<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/layui/layui.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
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
		</form>
		<div >
				<div class="layui-input-block">
					<button class="layui-btn"  onclick=login()>登录</button>
					<button  class="layui-btn layui-btn-primary" onclick="window.location.href='register.jsp'">注册</button>
				</div>
			</div>
    	</div>
    	
		
 	</body>
</html>
