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

<P>  The time on the server is ${serverTime}. </P>

	<form method="post" action="/add">
		id<input type="text" name="id"/>
		value<input type="text" name="pw"/>
		<button>submit</button>
	</form>
</body>
</html>
