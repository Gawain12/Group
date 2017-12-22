<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page isELIgnored='false' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.loginOut{
      float:right;
      margin-top:-17px;
      width:40px;
      height:22px;
      border-radius:5px;
      outline:none;
      background-color:#5B5B5B;
      border:2px solid #5B5B5B;
      color:#fff;
      font-size:5px;
}
.thename{
      float:right;
      font-weight:600;
}

.navigation{
      width:900px;
      height:30px;
      margin-left:220px;
      margin-bottom:20px;
      border:2px solid 	#BB3D00; 
      background-image:url("images/bj7.jpg");
      background-size:cover;
      padding-top:10px;
}
a.nav{
      font-size:20px;
      color:#930000;
      text-decoration:none;
      margin-left:50px;
}
.head{
      color:black;
      text-shadow:0 0 8px;
      margin-top:60px;
}
.boader{
      width:500px;
      height:500px;
      margin-left:220px;
      background-color:#F0F0F0;
      border:2px solid 	#BB3D00;
      border-radius:8px;
}
.nav1{
      color:black;
      font-size:15px;
      margin-left:80px;
      margin-top:38px;
}
input.special::-webkit-input-placeholder {
      color:#FF5809;
      font-size: 15px;
}
input.special{
      width:150px;
      height:40px;
      margin-top:0px;
      margin-bottom:20px;
      padding-left:15px;
      border-radius:40px;
      outline:none;
      border:2px solid 	#5B5B5B;
      background-color:transparent;
      color:black;
      font-size:15px;
}
button.special{
      width:120px;
      height:40px;
      margin-bottom:10px;
      margin-right:100px;
      border-radius:40px;
      outline:none;
      background-color:#FF8040;
      border:2px solid 	#5B5B5B;
      color:#fff;
      font-size:15px;
}

a.bottom{
      font-size:15px;
      color:#FF5809;
      margin-right:100px;
      text-decoration:none;
}
body {
     background-image:url("images/login/14.jpg");
      background-size:cover;
      background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改用户基本信息</title>
</head>
<body onload="unread(1)">
      <div id="head">
          MyInfo
        
             <form action='loginOut'>
	               <button class="loginOut" type='submit'>注销</button>
	      </form>
	                   
	          
          </a>
      </div>
      <div class="boader">
	      <h3 class="head" style='text-align:center'>基本信息</h3>
	      <div class="nav1">
		      <center>  
		             <br><br>
                       <form name="userFrom" action="UserUpdate" method="post">
		                  <table>		                         					          					                                           
				                 <tr>
					                  <td> 昵 称:</td>
					                  <td><input class="special" type='text' name='username' id="username" size="20"  value="${user.username}" ></td>
					             </tr>                                       
					             <tr>                                       
		                              <td>电话号码:</td>
		                              <td><input class="special" type='text' name='phone' id="phone" size="20"  value="${user.phone}"></td>
					             </tr> 
                                 <tr>
					                  <td>邮箱地址:</td>
					                  <td><input class="special" type='text' name='email' id="email" size="20"  value="${user.email}"></td>
									  <input name="userid" type="hidden" value="${user.userid}"/>
					            </tr> 								 
					                                         					                                               					         
		                 </table>
		                 <button class="special" type='submit'>保存</button><br>
		                 <a class="bottom" href='main.jsp'>返回上层</a>
		            </form> 
		            <h6 style="color:red;"><c:out value="${MES}"/></h6>
		      </center>
	      </div>
      </div>
       

</body>
</html>