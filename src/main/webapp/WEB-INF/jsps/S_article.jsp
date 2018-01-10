
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored='false' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

a{
      font-size:18px;
      color:#fff;
      text-decoration:none;
}
h1{
font-size:30px;
      color:gray;
      text-decoration:none;
}

span{
font-size:15px;
      color:#fff;
      text-decoration:none;
}
textarea::-webkit-input-placeholder {
      color: #fff;
      font-size: 15px;
}
textarea{
     width:220px;
      height:50px;
      margin-top:0px;
      margin-bottom:20px;
      padding-left:15px;
      border-radius:4px;
      outline:none;
      border:1px solid #c8cccf;
      font-size:25px; 
      color:#6a6f77;     
SCROLLBAR-DARKSHADOW-COLOR: #92C0D1; 

SCROLLBAR-TRACK-COLOR:#BED8EB; 


}
time{
font-size:11px;
color:black;
}
body{ 
     background-image:url("${pageContext.request.contextPath}/style/images/main/14.jpg");
     background-size:cover;
     background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOW ARTICLE</title>
</head>
<body>
<p>My Article</p>
 
    <section class="main">
        <article class="article">
            <h1 class="article_title" align="center"> ${article.title}</h1>
	   <c:choose>
				<c:when test="${userList.size()>0 }">
				      <form action="doAuthority" method="post">			
						<a href="doAuthority" >管理权限</a>			
            	<input type="hidden" name="article_id" value="${article.id}">
							<select class="catid" name="userId">
										<c:forEach items="${userList}" var="a">
											<option value="${a.userid}">${a.username}</option>
										</c:forEach>
								</select>
								
						<input class="article-btn-push" value="添加用户" type="submit"> 
					
						</form>
						</c:when>
						</c:choose>
            <div class="article-content">
                    <div id="services" class="tm-content-box tm-gray-bg tm-services">
                <content>${article.content}</content>
                </div>
            </div>
        </article>
        <!--end article-->
        
		
			<form action="reply" method="get">
        <div class="publish-comment">
            <div class="comment-text">
            	<input type="hidden" name="article_id" value="${article.id}">
                <textarea placeholder="谈谈" class="content" id="content"name="content" ></textarea>
                <div class="comment-push clearfix">
                    <input type="submit" class="comment-btn" id="comment-btn" value="发表评论">
                </div>
            </div>
        </div>
        </form>
   	<tbody id="deleteItem">
        <div id="commentList">
     
        <c:choose>
				<c:when test="${listReply.size()==0 }">
						暂无评论
				</c:when>
   </c:choose>
        <c:forEach items="${listReply}" var="a">
        <div class="show-comment">
            <p class="comment">${a.content}</p>
            <time class="time">${a.time} </time>
      <c:choose>
				<c:when test="${userList.size()>0 }">   
<a href="deReply?id=${a.id}" class="deleteItem">删除</a>
				 </c:when>
						</c:choose>
        </div>
        </c:forEach>
       </tbody>
        <!-- End main_content-->
    </section>
    <!-- End main  -->
   
    <script src="<c:url value="${pageContext.request.contextPath}/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="${pageContext.request.contextPath}/style/js/main.js"/>"></script>
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