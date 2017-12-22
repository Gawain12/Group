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
input::-webkit-input-placeholder {
      color: #fff;
      font-size: 15px;
}
input{
        box-sizing: border-box;
  text-align:left;
  font-size:18px;
  height:35px;
  border-radius:4px;
  border:1px solid #c8cccf;
  color:#6a6f77;
  -web-kit-appearance:none;
  -moz-appearance: none;
  display:block;
  outline:0;
  padding:0 1em;
  text-decoration:none;
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
								<h1>Create Article</h1>
						                                            
                        
					<div class="tm-content-box tm-gray-bg tm-services">
                    <div class="tm-welcome-link tm-button">
                    <h1 style="color:white">发表文章</h1>
                    </div>
                    <br/>
                    <form name="articleFrom" action="ArticleAddServlet" method="post">
		                                         文章标题：<input name="title" type="text" style="width:35%;margin-right:15px"></input>
		          
		                                       <br/>  文章内容：<textarea rows="10" cols="30" name="content"style="width:95%;height:200px;margin-right:100px"></textarea><br/>
	            <input type="submit" value="发表"  id="article"/>
	            </form> 
                    </div>
                        
           

						</article>
					</div>
</body>
</html>