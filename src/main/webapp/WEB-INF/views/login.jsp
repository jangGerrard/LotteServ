<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var= "ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link href="${ctx}/jquery/vendors/bower_components/animate.css/animate.min.css" rel="stylesheet">
<link href="${ctx}/jquery/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css" rel="stylesheet">
    
<!-- CSS -->
<link href="${ctx}/jquery/css/app.min.1.css" rel="stylesheet">
<link href="${ctx}/jquery/css/app.min.2.css" rel="stylesheet">

<script src="${ctx}/jquery/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${ctx}/jquery/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${ctx}/jquery/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script src="${ctx}/jquery/js/functions.js"></script>
<script type="text/javascript">
function login(){
	var loginForm = _('login_form');
	var email = _('email');
	var password = _('password');
	
	if(email.value == ''){
		alert('email!');
		return false;
	}
	if(password.value == ''){
		alert('password!');
		return false;
	}
	loginForm.submit();
}

function join(){
	
	alert('joni');
	var joinEmail = _('join_email');
	var joinPassword = _('join_password');
	var aggrement =_('agreement');
	var joinForm _('joinForm');	

	if(joinEmail == ''){
		alert('email');		
		return false;
	}
	if(joinPassword.value = ''){
		alert('password!');
		return false;
	}
	if(!aggrement.checked ){
		alert('aggrement our .... ');
		return false;
	}
	
	joinform.submit();
}

function forgotpw(){
	var fotgotEmail = _('forgot_email');
	var forgotForm _('forgotForm');
	if(forgotEmail.value == ''){
		alert('email!');
		return false;
	}
	
	forgotForm.submit();
}

function _(elem){
	return document.getElementById(elem);
}
</script>

        
</head>
    <body class="login-content">
        <!-- Login -->
        <div class="lc-block toggled" id="l-login">
        <form id="login_form" action="${ctx}/login.lotte" method="post" onsubmit="login(); return false; ">
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
                <div class="fg-line">
                    <input id="email" name="email" type="text" class="form-control" placeholder="E-Mail">
                </div>
            </div>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
                <div class="fg-line">
                    <input id = "password" name="password" type="password" class="form-control" placeholder="Password">
                </div>
            </div>
            
            <div class="clearfix"></div>
            
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="">
                    <i class="input-helper"></i>
                    Keep me signed in
                </label>
            </div>
            
            <button type="submit" class="btn btn-login btn-danger btn-float"><i class="zmdi zmdi-arrow-forward"></i></button>
            
            <ul class="login-navigation">
                <li data-block="#l-register" class="bgm-red">Register</li>
                <li data-block="#l-forget-password" class="bgm-orange">Forgot Password?</li>
            </ul>
        </form>
        </div>
        
        <!-- Register -->
        <div class="lc-block" id="l-register">
            <form id ="joinForm" action="/login/join.lotte" method="post" onsubmit="join(); return false;">
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="zmdi zmdi-email"></i></span>
                <div class="fg-line">
                    <input id ="join_email" name = "joinEmail" type="text" class="form-control" placeholder="Email Address">
                </div>
            </div>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
                <div class="fg-line">
                    <input id="join_password" name="joinPassword" type="password" class="form-control" placeholder="Password">
                </div>
            </div>
            
            <div class="clearfix"></div>
            
            <div class="checkbox">
                <label>
                    <input id="agreement" type="checkbox" value="">
                    <i class="input-helper"></i>
                    Accept the license agreement
                </label>
            </div>
            
            <button type="submit" class="btn btn-login btn-danger btn-float"><i class="zmdi zmdi-arrow-forward"></i></button>
            
            <ul class="login-navigation">
                <li data-block="#l-login" class="bgm-green">Login</li>
                <li data-block="#l-forget-password" class="bgm-orange">Forgot Password?</li>
            </ul>
            
            </form>
        </div>
        
        <!-- Forgot Password -->
        <div class="lc-block" id="l-forget-password">
        <form id = "forgotForm" method="post" action="${ctx}/login/forgotpw.lotte" onsubmit="forgotpw(); return false;">
            <p class="text-left">send a message administer that you forget password. we'll send temporary password</p>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="zmdi zmdi-email"></i></span>
                <div class="fg-line">
                    <input name="forgotEmail"  id="forgot_email" type="text" class="form-control" placeholder="Email Address">
                </div>
            </div>
            
            <button type ="submit" class="btn btn-login btn-danger btn-float"><i class="zmdi zmdi-arrow-forward"></i></button>
            
            <ul class="login-navigation">
                <li data-block="#l-login" class="bgm-green">Login</li>
                <li data-block="#l-register" class="bgm-red">Register</li>
            </ul>
            </form>
        </div>
        
    </body>
</html>