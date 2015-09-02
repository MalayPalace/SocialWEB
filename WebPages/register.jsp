<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="scripts/res_css.css">
<script src="scripts/scripts_js.js"></script>
<title>SocialWEB: Register Page</title>
</head>
<body>
	<h1>
		<u>MEMBERSHIP FORM</u>
	</h1>
	<form name="frm" method="post" action="AddUser" onsubmit="return register()">
		<table>
			<tr>
				<td>EMAIL-ID :</td>
				<td><input type="email" name="email" /></td>
				<td></td>
			</tr>
			<tr>
				<td>USERNAME :</td>
				<td><input type="text" name="username" onchange="getUser(this.value)"/></td>
				<td><div id="userchk"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><font color="GRAY">Should be unique</font></td>
				<td></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="password" name="pwd" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD"></td>
				<td><input type="reset" value="CLEAR"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>