<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Insert</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
  
<script type="text/javascript">
    $(document).ready(function(){
    	 $("#goList").on("click", function(){
    		var url ="<c:url value='/user/list/${pageIndex}' />"; 
    		location.href = url;
    		return false;
    	 });
    });
</script>
</head>
<body class="animated">

	<div id="cl-wrapper">
<!------------------------------------------------------------------------------
						** 사이드 메뉴 영역 START **
-------------------------------------------------------------------------------->
		<div class="cl-sidebar">
			<jsp:include page="/WEB-INF/jsp/cmn/inc/sideContents.jsp" />

		</div>
<!------------------------------------------------------------------------------
						** 사이드 메뉴 영역 END **
-------------------------------------------------------------------------------->

		<div class="container-fluid" id="pcont">
			<!-- TOP NAVBAR -->
<!------------------------------------------------------------------------------
						** 헤더 메뉴 영역 START **
-------------------------------------------------------------------------------->
			<jsp:include page="/WEB-INF/jsp/cmn/inc/headerContents.jsp" />
<!------------------------------------------------------------------------------
						** 헤더 메뉴 영역 END **
-------------------------------------------------------------------------------->


			<div class="cl-mcont">
<!------------------------------------------------------------------------------
						** 네비게이션 영역 START **
-------------------------------------------------------------------------------->
				<div class="page-head">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">Tables</a></li>
						<li class="active">Data Tables</li>
					</ol>
				</div>
<!------------------------------------------------------------------------------
						** 네비게이션 영역 END **
-------------------------------------------------------------------------------->

<!------------------------------------------------------------------------------
						** 본문영역 START **
-------------------------------------------------------------------------------->
				<div class="row">
					<div class="col-md-12">

						<div class="block-flat">
							<div class="header">
								<h3>사용자 :  ${user.userId }</h3>
							</div>
							<div class="content">
					<form class="form-horizontal group-border-dashed" 
									style="border-radius: 0px;" id="frm" method="post"  >
									<div class="form-group">
										<label class="col-sm-2 control-label">아이디</label>
										<div class="col-sm-10">
											<p class="form-control-static">${user.userId }</p>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label">이름</label>
										<div class="col-sm-10">
											<p class="form-control-static">${user.name}</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">이메일</label>
										<div class="col-sm-10">
											<p class="form-control-static">${user.email}</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">상태</label>
										<div class="col-sm-10">
											<p class="form-control-static">${user.status}</p>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button" class="btn btn-primary" id="goSave" >수정</button>
											<button class="btn btn-default" id="goList" >목록</button>
										</div>
									</div>
									</form>
							</div>
						</div>

					</div>
				</div>
<!------------------------------------------------------------------------------
						** 본문영역 END **
-------------------------------------------------------------------------------->
			</div>

		</div>

	</div>

	<jsp:include page="/WEB-INF/jsp/cmn/inc/footerResource.jsp" />
</body>
</html>
