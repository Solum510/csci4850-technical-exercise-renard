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

label.warn{
	color: red;
}
button {
  width: 100%;
}
input.menu{
	width: 100px;
}
div.grid{
	display: inline-block;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add an entry to the Jazz blog</title>
</head>
<body>
<h1>Add an entry to the blog:</h1>
	<div>
	<div class="grid"><form action="Homepage" method="post"><input class = "menu" type="submit" value="Home"></form>
	</div><div class="grid">
  	<form action="AddEntry" method="get"><input class = "menu"type="submit" value="New Entry"></form></div>
  	</div>
<hr class="solid"><br>

<form action="AddEntry" method="post">
  <label for="songName">Song name:</label><br>
  <input type="text" id="songName" name="songName"><br><br>
  <label for="artist">Artist:</label><br>
  <input type="text" id="artist" name="artist"><br><br>
  <label for="album">Album:</label><br>
  <input type="text" id="album" name="album"><br><br>
  <label for="desc">Description:</label><br>
  <input type="text" id="desc" name="desc"><br><br>
  <label for="ytlink">Youtube Link:</label><br>
  <input type="text" id="ytlink" name="ytlink"><br>
  ${requestScope["warning"]}<br>
  <div><div class="grid"><input type="submit" value="Submit">
  </div><div class="grid">
  <input type="reset"></div></div>
</form>


</body>
</html>