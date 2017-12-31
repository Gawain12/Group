<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章管理</title>
<link href="style/css/css.css" type="text/css" rel="stylesheet" />
<link href="style/css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="style/images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:20px; background:url(style/images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:16px; line-height:40px;}
#main-tab td a{ font-size:15px; color:#548fc9;}
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
    <td width="99%" align="left" valign="top" id="addinfo">您的位置：文章管理</td>
  </tr>
  <h6 style="color:red;"><c:out value="${ME}"/></h6>
  <tr>
    <td align="left" valign="top">
      <tr><td>我的文章</td></tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
          <th align="center" valign="middle" class="borderright">发布时间</th>   
     <!--    <th align="center" valign="middle" class="borderright">文章类别</th> -->
        <th align="center" valign="middle" class="borderright">文章标题</th>
        <th align="center" valign="middle">操作</th>
      </tr>
	<c:forEach items="${listArticle.list}" var="a">
							<tr>
								<td>${a.id}</td>
								<td>${a.pubDate}</td>
	<!--							<td>${a.articleType}</td> -->
						<td><a href="articleShow/${a.id}">	${a.title}</a></td>
								<td><a href="doPublish?article_id=${a.id}">编辑</a> 
								<a href="doDelete?article_id=${a.id}" class="deleteItem">删除</a></td>
							</tr>
						</c:forEach>
	 	<div class="list-page">
					<c:if test="${listArticle.currPage!=1}">
						<a href="doMarticle?currPage=1" class="prepage">首页</a>
						<a href="doMarticle?currPage=${listArticle.currPage-1}"
							class="prepage">上一页</a>
					</c:if>
					<c:if test="${listArticle.currPage!=listArticle.totalPage}">
						<a href="doMarticle?currPage=${listArticle.currPage+1}"
							class="nextpage">下一页</a>
						<a href="doMarticle?currPage=${listArticle.totalPage }"
							class="prepage">尾页</a>
					</c:if>
					<span class="pageCount">共${listArticle.totalCount}</span>条 <span
						class="cuurPage">${listArticle.currPage}</span> / <span
						class="pageCount">${listArticle.totalPage}</span>页
				</div>

	<script src="<c:url value="style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="style/js/menu.js"/>"></script>
	<script>
    $(document).ready(function() {
    	// 删除时，显示提示框 
        $('#deleteItem').on('click', 'a', function(e) {
        	if(e.target.className == 'deleteItem'){
        		var flag = confirm('确定删除？');
                if (flag) {
                    return true;
                } else {
                    return false;
                }
        	}
            
        })
    });
    </script>
</body>
</html>