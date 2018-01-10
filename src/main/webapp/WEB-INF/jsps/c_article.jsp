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
     background-image:url("style/images/main/14.jpg");
     background-size:cover;
     background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>airticle</title>
</head>
<body>
<p>Create Article</p>
	<div class="main">

			<form action="doSave" method="post">
				<table class="insert-tab">
						<tbody>
								<div class="main">
								<tr class="tr">
								<th><i class="require-red"></i>分类：</th>
								<td>
									<select class="catid" name="articletype">
										<c:forEach items="${typeList}" var="a">
											<option value="${a.id}">${a.type}</option>
										</c:forEach>
								</select></td>

							</tr>
							<tr class="tr">
								    文章标题：<input name="title" type="text" style="width:35%;margin-right:15px">${article.title}</input>
							</tr>
							<tr class="tr">
							<br/>  文章内容：<textarea rows="10" cols="30" name="content"style="width:95%;height:200px;margin-right:100px">
		                                      ${article.content} </textarea>
		                     <br/>
		                     </tr>
		                         <tr class="tr">
								<td><input class="article-btn-push" value="发布" type="submit"> 
								<input class="article-btn-back" onclick="history.go(-1)" value="返回" type="button"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		
</body>
<script src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="/style/js/menu.js"/>"></script>

</html>