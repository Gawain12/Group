<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored='false' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

a{
      font-size:15px;
      color:#fff;
      text-decoration:none;
}

}
span{
font-size:15px;
      color:#fff;
      text-decoration:none;
}
time{
font-size:10px;
color:gray;
}
body{ 
     background-image:url("style/images/main/14.jpg");
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
            <h1 class="article_title"> ${article.title}</h1>
            <div class="article-content">
                <p>${article.content}</p>
            </div>
        </article>
        <!--end article-->
        <form  onSubmit="renderReply(data)">
        <div class="publish-comment">
            <div class="comment-text">
            	<input type="hidden" name="article_id" value="${article.id}" id="article_id">
                <textarea placeholder="谈谈想法" class="js-textarea" id="js-textarea"></textarea>
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
    <script src="<c:url value="style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="style/js/main.js"/>"></script>
	<script type="text/javascript">
		function renderReply(data){
			 var html = '';
			 html='<div class="show-comment"><p class="comment">'+data.reply.content+'</p><time class="time">'+data.reply.time+'</time></div>';
		     $('#commentList').prepend(html);
		}
		$('#comment-btn').on('click',function(){
			
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