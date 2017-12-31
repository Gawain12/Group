<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% //注册页面   %>
<html>
<head>
<style type="text/css">
h1.head{
   color:white;
   text-shadow:0 0 8px;
   margin-top:20px;
   margin-bottom:39px;
}
input::-webkit-input-placeholder {
      color: #fff;
      font-size: 15px;
}
input{
      width:233px;
      height:40px;
      margin-top:0px;
      margin-bottom:20px;
      padding-left:15px;
      border-radius:40px;
      outline:none;
      border:1.8px solid 	#5B5B5B;
      background-color:transparent;
      color:#00FFFF;
      font-size:15px;
}
button{
      width:180px;
      height:40px;
      margin-left:3px;
      margin-bottom:10px;
      border-radius:40px;
      outline:none;
      background-color:blue;
      border:2px solid 	#5B5B5B;
      color:#fff;
      font-size:15px;
}
a{
      font-size:15px;
      color:#fff;
      text-decoration:none;
}
body {
     background-image:url("style/images/main/14.jpg");
      background-size:cover;
      background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
      <center>
          <h1 class="head">注册</h1>
             <form action="<c:url value="/doRegister" />"  method="post"  onsubmit="return check()">
                      <input type='text' name='email' id="email" size="30" placeholder="邮箱地址:"><br>
                      <input type='text' name='phone' id="phone" size="30" placeholder="手机号码:"><br>
                      <input type='text' name='username' id="username" size="30" placeholder="昵称："><br>
                      <input type='password' name='password' id="password" size="30" placeholder="密码："><br>
                      <button type='submit'>确定</button><br>   
                      <font size="2">
                      <a href="<c:url value="login"/>">返回上层</a></font>        
             </form>
      </center>  
 
      
<script>
function check(){  //表单提交则验证开始
    var emai = false;
    var phone = false;
    var username = false;
    var passwor = false;
     
    if(checkEmail(document.getElementById("email").value)){ emai = true; }  
    if(checkphoner(document.getElementById("phone").value)){ phone = true; }
    if(checkUsername(document.getElementById("username").value)){ username = true; }
    if(checkPassword(document.getElementById("password").value)){ password = true; }
    if(checkConpassword(document.getElementById("password").value,document.getElementById("conpassword").value)){ conpasswor = true; }
    if(emai && passwor && phone && username ){ 
      return true;
    }
     alert("请将注册信息填写完整！"); 
     return false; 
  }
  
function checkEmail(email){
	   var pattern=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	   if(email == "" ){
		   return false;
	   }else if(!pattern.test(email)){
		   alert("请输入正确的邮箱地址！"); 
		   return false;
	   }else return true;
	 }
function checkphoner(phone){
	   var pattern=/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;  
	   if(phone == "" ){
	     return false;
	   }else if(!pattern.test(phone)){
		   alert("请输入正确的手机号码！"); 
		   return false;
	   } else return true; 
	 }
function checkUsername(username){ 
	var pattern= /^[\u4e00-\u9fff\w]{1,16}$/;
	if(username == "" ){
	     return false;
	   }else if(!pattern.test(username)){
		   alert("请输入正确的昵称"); 
		   return false;
	   }
	   else return true; 
	 }
function checkPassword(password){ 
	var pattern= /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
	if(password == "" ){
	     return false;
	   }else if(!pattern.test(password)){
		   alert("密码必须是6到20位，由数字和英文组成！"); 
		   return false;
	   }
	   else return true;
	   
	 }
</script>
</body>
</html>