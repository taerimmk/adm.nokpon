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

<P>  The time on the server is ${selectUser.seq}. </P>
<br/>
${selectUser.id} <br/>
${selectUser }
<a href="/app/j_spring_security_logout">logout</a>

</body>
</html>
