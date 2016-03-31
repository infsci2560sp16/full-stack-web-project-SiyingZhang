<!DOCTYPE html>
<html>
<head>
	<#include "header.ftl">
</head>

<body>
	<h1>Delete the Substring</h1>
	<p>Find out if any substrings are contained in a string.  Submit your input string and substring and we will tell you how many substrings there. </p>

	<form action='/task1_workout' method="get">
		<div class="form-group">
			<label for="string1">String (the longer one)</label>
			<input id="string1" name="string1" class="form-control" type="text">
			<label for="substring">Substring (shorter than String)</label>
			<input id="substring" name="substring" class="form-control" type="text">
		</div>
		<button type="submit" class="btn btn-info">How many substrings there?</button>
	</form>

</body>
</html>