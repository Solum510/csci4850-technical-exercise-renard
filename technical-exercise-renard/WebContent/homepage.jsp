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
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nathan's Jazz Blog</title>
</head>
<body>
<h1>Welcome to Nathan's Jazz Blog!</h1>
<menu>  
	<li><button onclick="window.location='homepage.jsp';">Home</button></li>
  	<li><button onclick="window.location='addEntry.jsp';">New Entry</button></li>
</menu>

<hr class="solid">

<div align=center class="scaffold">
<div align=center class="entry">
<big>Don't Destory the Funk</big>
<p>Phat Phunction - Real Life, High Fidelity<br>
It's just kinda funky, ya feel?</p><br>
<iframe width="420" height="315"
src="https://www.youtube.com/embed/NqSPLsJaFsE">
</iframe>
<br><br>
</div>
${requestScope["entriesHtml"]}

</div>
</body>
</html>

