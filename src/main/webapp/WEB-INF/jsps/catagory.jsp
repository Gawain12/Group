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
<body><div class="main">
				<table class="insert-tab insert-tab-comment">
					<thead>
						<th>ID</th>
						<th>类别</th>
						<th>操作</th>
					</thead>
					<tbody>
						<c:forEach items="${listType.list }" var="catagory">
							<tr class="topcatagory">
								<td>${catagory.id }</td>
								<td class="allcatagory"><span class="showcatagory">${catagory.type }</span>
									<form action="updateArticleT" method="post" class="changecatagory">
									    <input type="hidden" name="id" value="${catagory.id }"/>
										<input type="text" name="type" class="contentinput" /> 
										<input type="submit" value="保存" class="saveType" id="saveType">
										<a href="#" class="resetType" id="resetType">取消</a>
									</form></td>
								<td class="allcatagory"><a href="#" class="editType">编辑</a><a
									href="deleteArticleT?articletype_id=${catagory.id}" id="catagoryDelete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="list-page">
					<c:if test="${listType.currPage!=1}">
						<a href="doCatagory?currPage=1" class="prepage">首页</a>
						<a href="doCatagory?currPage=${listPage.currPage-1}"
							class="prepage">上一页</a>
					</c:if>
					<c:if test="${listType.currPage!=listType.totalPage }">
						<a href="doCatagory?currPage=${listType.currPage+1}"
							class="nextpage">下一页</a>
						<a href="doCatagory?currPage=${listType.totalPage }"
							class="prepage">尾页</a>
					</c:if>
					共<span class="pageCount"> ${listType.totalCount } </span>条 <span
						class="cuurPage">${listType.currPage} </span>/ <span
						class="pageCount"> ${listType.totalPage} </span>页
				</div>
				<form class="list-catagory" action="addCatagory">
					<input class="add" type="text" name="type" placeholder="添加类别">
					<input class="article-btn-back" value="添加" type="submit">
				</form>
			</div>
	
	
	<footer id="footer">
		<p></p>
	</footer>
	<script src="<c:url value="style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="style/js/menu.js"/>"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#catagoryDelete').on('click',function(){
			var r=confirm("delete for sure!")
            if (r==true)
            {
                return true;
            } else {
                return false;
            }
		});
	});
	</script>
</body>
</html>