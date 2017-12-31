<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% //登录页面   %>
<html>
<head>
<style type="text/css"> 
h1.head{
   color:white;
   text-shadow:0 0 8px;
   margin-top:60px;
}
p.head2{
   font-size:20px;
   color:white;
   text-shadow:0 0 5px;
}
.a{
   margin-top:60px;
}
.checkcode{
      width:100px;
      margin-left:100px;
}
input::-webkit-input-placeholder {
      color: #fff;
      font-size: 15px;
}
input{
      width:220px;
      height:50px;
      margin-top:0px;
      margin-bottom:20px;
      padding-left:15px;
      border-radius:40px;
      outline:none;
      border:2px solid 	#5B5B5B;
      background-color:transparent;
      color:#FF4500;
      font-size:15px;
}
.admin{
      float:left;
      height:20px;
      margin-top:-600px;
      margin-left:1120px;
}
.adminname{
      float:right;
      color:#fff;
      font-size:18px;
      margin-top:-584px;
      margin-right:17px;
}
.rememberbox{
      height:20px;
      margin-left:-100px;
}
.remember{
      color:#fff;
      font-size:15px;
}
.rememberbox2{
      float:left;
      height:20px;
      margin-left:522px;
      margin-top:-23px;
}
.remember2{
      float:left;
      color:#fff;
      font-size:15px;
      margin-left:560px;
      margin-top:-23px;
}
button{
      width:120px;
      height:45px;
      margin-left:3px;
      margin-bottom:10px;
      border-radius:40px;
      outline:none;
      background-color:blue;
      border:2px solid 	#5B5B5B;
      color:#fff;
      font-size:15px;
}
a.b{
      font-size:15px;
      color:#fff;
      margin-left:-30px;
      text-decoration:none;
}
a.c{
      font-size:15px;
      color:#fff;
      text-decoration:none;
}
a.a_code{
      font-size:15px;
      color:#fff;
      text-decoration:none;
}
body{ 
     background-image:url("style/images/main/14.jpg");
     background-size:cover;
     background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户登录</title>
</head>
<body onload="getRememberCookie()">
            <center>
                <h1 class="head" >TLGROUP</h1>
                <form action="<c:url value="/doLogin"/>" method="post" onSubmit="return check()">
                    <div class="a">                                       
	                    <p id="abc" class="head2" >用户登录</p><br>
	                    <input type='text' name='username' id="username"  placeholder="   用户名" /><br>
                    </div>
                    <input type='password' name='password' id="password"  placeholder="    密码"/><br/>
				  
                    <button type='submit'  onclick="sub()">登录</button><br>
	                
	        
	                <a class="c" href="<c:url value="/register"/>">注册</a>
	                
                </form>
            </center>
            
          
          
            
<script>

function check(){  
    var accountnumbe = false;
    var passwor = false;
    if(checkAccountnumber(document.getElementById("username").value)){ accountnumbe = true; }  
    if(checkPassword(document.getElementById("password").value)){ passwor = true; }
    if(accountnumbe && passwor && checkcod){ 
      return true;
    }
    	return false; 
  }
  
function checkAccountnumber(username){ 
	   if(username != ""){
	     return true;
	   }else{
		   alert("账号不能为空！"); 
		   return false;
	   }
	 }
function checkPassword(password){ 
	   if(password != ""){
	     return true;
	   }else{
		   alert("密码不能为空！"); 
		   return false;
	   }
	 }
</script>
</body>
</html>           

