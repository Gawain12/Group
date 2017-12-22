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

body{ 
     background-image:url("img/login.jpg");
     background-size:cover;
     background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="tab-5" class="tab">
						<article>
							<div class="text-section">
								<h1>Article</h1>
								<p></p>
							</div>
							
                    <div id="services" class="tm-content-box tm-gray-bg tm-services">
                            <h2 class="tm-section-title" align="center">HER</h2>
                            <p>"She" is a science-fiction romance film about the love of artificial intelligence in the near future. 
                            Theodore Theodore (Jacqueline Phoenix Joaquin Phoenix ornaments) is a letter writer, thoughtful and deep, can write the most heartfelt letters. He just ended with his wife Catherine
                             (Rooney Mara Rooney Mara) marriage, not out of the shadow of heartbreak. A chance to let him touch the latest artificial intelligence system OS1 ...</p>                                                                
                            <div class="tm-welcome-box1">                          
                               <a href="article.jsp" class="tm-welcome-link tm-button">查看评论</a>
                            </div>
                            <div class="tm-welcome-box2">                           
                                <a href="ArticleDelServlet?id=1" class="tm-welcome-link tm-button">删除文章</a>
                            </div>                                              
                        
                    <div id="services" class="tm-content-box tm-gray-bg tm-services">
                            <h2 class="tm-section-title" align="center">Source Code</h2>
                            <p>　Captain Steve Cuth Stevens (Jake Gyllenhaal), a U.S. Air Force pilot in Afghanistan, suddenly woke up and found himself on a fast train, sitting beside him with a stranger Christian (Michelle Monaghan Michelle Monaghan) is talking to himself. Cole do not know why I will be in this car,
                             And he found himself actually exists as another person, just as he puzzled, the train suddenly exploded...</p>                                                                
                            <div class="tm-welcome-box1">                          
                               <a href="article.jsp" class="tm-welcome-link tm-button">查看评论</a>
                            </div>
                            <div class="tm-welcome-box2">                           
                                <a href="ArticleDelServlet?id=1" class="tm-welcome-link tm-button">删除文章</a>
                            </div>  
                            
                    <div id="services" class="tm-content-box tm-gray-bg tm-services">
                            <h2 class="tm-section-title" align="center">Blade Runner 2049</h2>
                            <p>The story happened 30 years after the big blackout. Replica K (Ryan Gosling) is a new generation of silver-leaf killers. In today's world, 
                            the dividing line between human beings and replicators is clearer. Duplicators are instilled as soon as they are made Serve on the human mind,
                             absolutely not allowed to produce human feelings.... </p>                                                                
                            <div class="tm-welcome-box1">                          
                               <a href="article.jsp" class="tm-welcome-link tm-button">查看评论</a>
                            </div>
                            <div class="tm-welcome-box2">                           
                                <a href="ArticleDelServlet?id=1" class="tm-welcome-link tm-button">删除文章</a>
                            </div>                                                                   
                    </div>                                                                                         
                    </div>                      
                    </div>
						</article>
					</div>
<a href="selectPageServlet?page=1">首页</a>
<c:choose>
	<c:when test="${page.curpage==1}">
		<a href="selectPageServlet?page=${page.curpage}">上一页</a>
	</c:when>
	<c:otherwise>
		<a href="selectPageServlet?page=${page.curpage-1}">上一页</a>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${page.curpage==page.totalPage}">
		<a href="selectPageServlet?page=${page.curpage}">下一页</a>
	</c:when>
	<c:otherwise>
		<a href="selectPageServlet?page=${page.curpage+1}">下一页</a>
	</c:otherwise>
</c:choose>
<a href="selectPageServlet?page=${page.totalPage}">尾页</a>
</body>
</html>