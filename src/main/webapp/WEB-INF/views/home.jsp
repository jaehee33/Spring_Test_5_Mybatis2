<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form action="./fileTest" method="post" enctype="multipart/form-data"> 
	<input type="text" name="id">
	<input type="file" name="f1">
	<button>button</button>
</form>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
