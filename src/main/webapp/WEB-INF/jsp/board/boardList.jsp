<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello board!  
</h1>


<c:if test="${not empty boardList}">
<c:forEach items="${boardList}" var="resultList" varStatus="status">
제목 : ${resultList.nttSj}<br/>
</c:forEach>
</c:if>
<br/>


</body>
</html>
