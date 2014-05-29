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
								<h3>게시판 상세</h3>
							</div>
							<div class="content">
								<form class="form-horizontal group-border-dashed" 
									style="border-radius: 0px;" id="frm" method="post"  >
									<div class="form-group">
										<label class="col-sm-3 control-label">게시판명</label>
										<div class="col-sm-9">
											<p class="form-control-static">${boardMasterDetail.bbsNm }</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">답글가능여부</label>
										<div class="col-sm-9">
											<p class="form-control-static">${boardMasterDetail.answerPosblYn eq 'Y' ? '가능':'불가능' }</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">댓글가능여부</label>
										<div class="col-sm-9">
											<p class="form-control-static">${boardMasterDetail.comntPosblYn eq 'Y' ? '가능':'불가능' }</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">파일첨부가능여부</label>
										<div class="col-sm-9">
											<p class="form-control-static">${boardMasterDetail.fileAtchPosblYn eq 'Y' ? '가능':'불가능'}</p>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">사용여부</label>
										<div class="col-sm-9">
											<p class="form-control-static">${boardMasterDetail.useYn eq 'Y' ? '사용':'미사용'}</p>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button" class="btn btn-primary" id="goUpdate" >수정</button>
											<%-- <a href="<c:url value="/boardMaster/get/${boardMasterDetail.bbsId}"/>" ><button type="button" class="btn btn-default" id="goList" >취소</button></a> --%>
											<a href="<c:url value="/boardMaster/list/${boardMasterDetail.pageIndex}"/>" ><button type="button" class="btn btn-default" id="goList" >목록</button></a>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#goUpdate").on("click", function() {
			var action = '<c:url value="/boardMaster/update/${boardMasterDetail.bbsId}/${boardMasterDetail.pageIndex}" />';
			location.href = action;
		});
		
	});
</script>	
</body>
</html>
