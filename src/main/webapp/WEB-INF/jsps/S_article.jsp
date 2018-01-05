
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
font-size:10px;
color:green;
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
            <div class="article-content">
                    <div id="services" class="tm-content-box tm-gray-bg tm-services">
                <content>${article.content}</content>
                </div>
            </div>
        </article>
        <!--end article-->
        
			<form action="reply" method="post">
        <div class="publish-comment">
            <div class="comment-text">
            	<input type="hidden" name="article_id" value="${article.id}" id="article_id">
                <textarea placeholder="谈谈" class="content" id="content"></textarea>
                <div class="comment-push clearfix">
                    <input type="submit" class="comment-btn" id="comment-btn" value="发表评论">
                </div>
            </div>
        </div>
           </form>
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
        </div>
        </c:forEach>
       
        </div>
        <!-- End main_content-->
    </section>
    <!-- End main  -->
    <script src="<c:url value="${pageContext.request.contextPath}/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="${pageContext.request.contextPath}/style/js/main.js"/>"></script>
	<script type="text/javascript">
		function renderReply(data){
			 var html = '';
			 html='<div class="show-comment"><p class="comment">'+data.reply.content+'</p><time class="time">'+data.reply.time+'</time></div>';
		     $('#commentList').prepend(html);
		}
		$('#comment-btn').on('click',function(){
			alert("sfsfsfsff");
		  	$.ajax({  
		  	    type : 'GET',  
		  	    contentType : 'application/json',  
		  	    url : 'reply',
		  	    data:{
		  	    	article_id:$('#article_id').val(),
		  	    	content:$('#js-textarea').val()
		  	    },
		  	    dataType : 'json',  
		  	    success : function(data) {  
		  	      console.log("success");
		  	      renderReply(data);		  	      
		  	    },  
		  	    error : function() {  
		  	      alert("error")  
		  	    }  
		  	  });
		});
		
		
	</script>
</body>
</html>