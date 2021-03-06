<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Insert</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />

<script type="text/javascript">
	$(function() {

		$("#goList")
				.on(
						"click",
						function() {
							var action = '<c:url value="/site/video/list/${video.pageIndex}" />';
							location.href = action;

							return false;
						});

		$("#goUpdate")
				.on(
						"click",
						function() {
							var action = '<c:url value="/site/video/update/${video.nttId}/${video.pageIndex}" />';
							location.href = action;

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
								<h3>게시물 등록</h3>
							</div>
							<div class="content">
								<form class="form-horizontal group-border-dashed"
									style="border-radius: 0px;" id="frm" method="post">
									<div class="form-group">
										<label class="col-sm-2 control-label">제목</label>
										<div class="col-sm-10">
											<p class="form-control-static">${video.nttSj }</p>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">내용</label>
										<div class="col-sm-10">
											<p class="form-control-static">${video.nttCn}</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">동영상</label>
										<div class="col-sm-6">
											<p class="form-control-static">
												${video.nttLink}
											</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">삭제여부</label>
										<div class="col-sm-6">
											<p class="form-control-static">${rData.useYn  eq 'N' ? '삭제' : '미삭제'}</p>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button class="btn btn-primary" id="goUpdate">수정</button>
											<button class="btn btn-default" id="goList">목록</button>
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
