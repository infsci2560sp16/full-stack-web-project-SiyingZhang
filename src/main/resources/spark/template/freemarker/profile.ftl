<html>
<head>
	<#include "header.ftl">
	<title>Profile</title>
</head>

<body>
	<section class="container">
		<div class="login">
			<h1>Profile Settings</h1>
		  	<form method="post" action="modify-profile.js">	  		
		    	<p><label class="rowname">Username: </label><input type="text" name="username" value="${user.getUsername()}"></p>
		    	<p><label class="rowname">User Email: </label><input type="text" name="useremail" value="${user.getUseremail()}" placeholder="Password"></p>  	
		    	<p><label class="rowname">Change Password: </label><input type="password" name="password" value="${user.getPassword()}" placeholder="Password"></p>
		    	<p><label class="rowname">Retype Password: </label><input type="password" name="password" value="${user.getPassword()}" placeholder="Password"></p>
		    	<p class="submit"><input type="submit" name="savechange" value="Save"> <input type="submit" name="cancelchange" value="Cancel"></p>
		  	</form>
		</div>
	</section>

	<section class="about">
		<p class="about-author">Wordrumb
	  &copy; 2016 <a href="https://www.linkedin.com/in/zhangsiying" target="_blank">Siying Zhang</a></p>
	  Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
	</section>	
</body>
</html>