
<!DOCTYPE html>
<html>
<head>
		<#include "header.ftl">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>Wordrumb - Login or create an account!</h1>
		</div>
		<p>Login to your own account to keep synchronized of your words notes.</p>
		<form>
			<table class="left-table">
				<tr class="table-title"><td>New Account:
				<td></tr>
				<tr class="inputfield"><td>
					<input type="text"   placeholder="Username" required/>
				</td></tr> 
				<tr class="inputfield"><td>
					<input type="text"   placeholder="Email" required/>
					<div class="clear"> </div>
				</td></tr> 
				<tr class="inputfield"><td>
					<input type="password"   placeholder="password" required/>
					<div class="clear"> </div>
				</td></tr> 
				<tr class="inputfield"><td>
					<input type="password"   placeholder="password" required/>
					<div class="clear"> </div>
				</td></tr> 
				<tr class="submit"><td>
					<input type="submit" onclick="myFunction()" value="Create Account">
					<div class="clear"> </div>
				</td></tr> 
			</table>
			<table class="right-table">
				<tr class="table-title"><td>Login:
				<td></tr>
				<tr class="inputfield"><td><input type="text"  placeholder="Username" required/></td></tr>
				<tr class="inputfield"><td> <input type="password"  placeholder="Password" required/></td></tr>
				<tr class="forgetpw"><td><a href="#">I forgot my Password!</a></td></tr>
				<tr class="submit"><td><input type="submit" onclick="myFunction()" value="Login"><div class="clear"> </div>
				</td></tr> 
			</table>
				<div class="clear"> </div>			
			</form>
		</div>
			
		<!---start-copyright-->
   		<div class="copy-right">
			<p>Created by <a href="https://github.com/SiyingZhang">Siying Zhang</a></p> 
		</div>
		<!---//end-copyright-->
</body>
</html>