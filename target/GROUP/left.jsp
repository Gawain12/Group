<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored='false' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="style/css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="style/js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa;
 SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;
   SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(style/images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
h1{font-size:15px;
   color:white;
   text-shadow:0 0 8px;
   margin-top:6px;
}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="style/images/main/2.jpg" width="44" height="44" /></div>
    
	<h1>Wellcome：<c:out value="${user.username}"/></h1>
            
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>系统功能</span>
        <a href="main.jsp" target="mainFrame" onFocus="this.blur()">首页</a>
        <a href="doModify" target="mainFrame" onFocus="this.blur()">查看个人信息</a>
      </div>
	   <div class="collapsed">
        <span>分组管理</span>
        <a href="Myowngroup" target="mainFrame" onFocus="this.blur()">我的分组</a>
        <a href="c_group.jsp" target="mainFrame" onFocus="this.blur()">创建分组</a>
        <a href="GetAllGroup" target="mainFrame" onFocus="this.blur()">所有分组</a>
      </div>
	   <div class="collapsed">
        <span>文章管理</span>
        <a href="doPublish2"target="mainFrame" onFocus="this.blur()">编写文章</a>
        <a href="doCatagory?currPage=1"target="mainFrame" onFocus="this.blur()">管理分类</a>
        <a href="doMarticle?currPage=1"target="mainFrame" onFocus="this.blur()">我的文章</a>     
        <a href="doAarticle?currPage=1"target="mainFrame" onFocus="this.blur()">所有文章</a>
      </div>

    </div>
	
</body>
</html>