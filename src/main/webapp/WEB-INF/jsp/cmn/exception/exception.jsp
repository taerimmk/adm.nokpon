<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Flat Dream</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
</head>

<body class="texture">

	<div id="cl-wrapper" class="error-container">
		<div class="page-error">
			<h1 class="number text-center">404</h1>
			<h2 class="description text-center">Sorry, but this page doesn't
				exists!</h2>
			<h3 class="text-center">
				Would you like to go <a href="<c:url value="/main"/>">home</a>?
			</h3>
		</div>
		<div class="text-center copy">
			&copy; 2014 <a href="#">Your Company</a>
		</div>


	</div>


	<script type="text/javascript">
		$(function() {
			$("#cl-wrapper").css({
				opacity : 1,
				'margin-left' : 0
			});
		});
	</script>
	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<jsp:include page="/WEB-INF/jsp/cmn/inc/footerResource.jsp" />

</body>
</html>
