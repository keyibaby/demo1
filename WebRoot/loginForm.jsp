<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginForm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		   <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/layui/layui.js"></script>
        <script type="text/javascript" src="js/jquery.form.js"></script>
   		
        <script type="text/javascript" src="js/loginForm.js"></script>
   		
   		<script>var basePath="<%=basePath%>";</script>
  </head>
  
<body>
		<div>
			<form id="form"  action="${pageContext.request.contextPath }/demo/loginForm.do" method="post">
				<input type="text" name="uname"/>
				<input type="text" name="pwd"/>
				<a type="submit" onclick="login()">登录</button>
			</form>
		</div>
	</body>
</html>
