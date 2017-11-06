
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.situ.crm.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="../common/head1.jsp"%>
<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
</head>
<body>
<div style="width:300px ; margin:100px auto" >
<form action="/Java1707Crm/user/login.action" method="post">
    用户名 ：<input type="text" name="name" class="form-control" /><br/>
         密码：<input type="text" name="password" class="form-control" /><br/>
    <input style="width:300px ; margin: auto" type="submit" value="登陆" class="btn btn-primary btn-lg"/>
   </form>
 
</div>
</body>
</html>