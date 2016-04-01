<!DOCTYPE html>
<html>
<head>
	<#include "header.ftl">
	<title>Login Form</title>
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>Login to Your Wordrumb</h1>
		  	<form method="post" action="#">
		    	<p><input type="text" name="login" value="" placeholder="Username or Email"></p>
		    	<p><input type="password" name="password" value="" placeholder="Password"></p>
		    	<p class="remember_me">
		      	<label>
		        	<input type="checkbox" name="remember_me" id="remember_me">
		        Remember me on this computer
		      	</label>
		   		 </p>
		    	<p class="submit"><input type="submit" name="commit" value="Login"></p>
		  	</form>
		</div>

		<div class="login-help">
			<p>Still have no account? <a href="signup.html">Click here to sign up</a>.</p>
		</div>
	</section>

	<section class="about">
		<p class="about-author">
	  &copy; 2016 <a href="https://www.linkedin.com/in/zhangsiying" target="_blank">Siying Zhang</a></p>
	  Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
	</section>
</body>
</html>