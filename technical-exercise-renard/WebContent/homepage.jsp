<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

/* Solid border */
hr.solid {
  border-top: 3px solid #bbb;
}

menu {
  display: flex;
  list-style: none;
  padding: 0;
  width: 400px;
}

li {
  flex-grow: 1;
}

button {
  width: 100%;
}

.entry{
	width: 435px;
	border: 5px groove #34dbeb;
}
input.menu{
	width: 100px;
}

div.grid{
	display: inline-block;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nathan's Jazz Blog</title>
</head>
<body>
<h1>Welcome to Nathan's Jazz Blog!</h1>
<div>
	<div class="grid"><form action="Homepage" method="post"><input class = "menu" type="submit" value="Home"></form>
	</div><div class="grid">
  	<form action="AddEntry" method="get"><input class = "menu"type="submit" value="New Entry"></form></div>
  	</div>

<hr class="solid">

<div align=center class="scaffold">
${requestScope["entriesHtml"]}


</div>
</body>
</html>

