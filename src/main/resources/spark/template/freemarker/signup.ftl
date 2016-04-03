<!DOCTYPE html>
<html>
<head>
	<#include "header.ftl">
	<title>Signup Form</title>
</head>
<body>
	<section class="container">
		<div class="login">
			<h1>Sign up for Wordrumb</h1>
		  	<form method="POST" action="/register">
		    	<p><input type="text" name="username" value="" placeholder="Username"></p>
		    	<p><input type="text" name="useremail" value="" placeholder="User Email"></p>
		    	<p><input type="password" name="password" value="" placeholder="Password"></p>
		    	<p><input type="password" name="repassword" value="" placeholder="Retype the Password"></p>
		    	<p class="submit"><input type="submit" name="commit" value="Sign Up"></p>
		  	</form>
		</div>

		<div class="login-help">
			<p>Already have an account? <a href="login.html">Click here to login</a>.</p>
		</div>
	</section>

	<section class="about">
		<p class="about-author">Wordrumb
	  &copy; 2016 <a href="https://www.linkedin.com/in/zhangsiying" target="_blank">Siying Zhang</a></p>
	  Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
	</section>
</body>
</html>