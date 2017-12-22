<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored='false' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分组情况</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
#addinfo{ padding:0 0 10px 0;}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <td width="99%" align="left" valign="top" id="addinfo">您的位置：我的项目</td>
  </tr>
  <tr>
    <td align="left" valign="top">
      <tr><td>我创建的项目</td></tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">项目号</th>
        <th align="center" valign="middle" class="borderright">项目名称</th>
  		<th align="center" valign="middle" class="borderright">所属小组</th>
        <th align="center" valign="middle">操作</th>
      </tr>
	
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
	   <c:forEach var="project" items="${Projects}" >
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.uuid}" /></td>
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.gname}" /></td>    
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.total}" /></td>

        <td align="center" valign="middle" class="borderbottom">
		<a href="getproject?id=${project.uuid}" target="mainFrame" onFocus="this.blur()" class="add">查看项目情况</a><span class="gray">&nbsp;|&nbsp;</span>
		<a href="updateproject?id=${project.uuid}" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;&nbsp;</span>
		<a href="deleteproject?id=${project.uuid}" target="mainFrame" onFocus="this.blur()" class="add">删除项目</a><span class="gray">&nbsp;&nbsp;</span>
		</c:forEach>
      </tr>
	    <tr><td>我管理的项目</td></tr>
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
    <th align="center" valign="middle" class="borderright">项目号</th>
        <th align="center" valign="middle" class="borderright">项目名称</th>
  		<th align="center" valign="middle" class="borderright">所属小组</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach var="project" items="${Projects}" >
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.uuid}" /></td>
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.gname}" /></td>    
        <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${project.total}" /></td>
</c:forEach>
        <td align="center" valign="middle" class="borderbottom">
		<a href="getproject?id=${project.uuid}" target="mainFrame" onFocus="this.blur()" class="add">查看项目情况</a>
		<span class="gray">&nbsp;|&nbsp;</span>
		<a href="updateproject?id=${project.uuid}" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;&nbsp;</span>
      </tr>
      
  <tr>
    <td align="left" valign="top" class="fenye">1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
</body>
</html>