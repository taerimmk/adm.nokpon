<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Insert</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />

<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/bootstrap.wysihtml5/src/bootstrap-wysihtml5.css"/>"></link> --%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/js/bootstrap.summernote/dist/summernote.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.summernote/dist/summernote.min.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	//$('#summernote').summernote();

	$('#summernote').summernote({
		//height: 200,
		onImageUpload : function(files,	editor, welEditable) {
			sendFile(files[0], editor,	welEditable);
		}
	});
	function sendFile(file, editor, welEditable) {
		var data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "<c:url value='/image/upload/db.json'/>",
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				var setUrl = "<c:url value='/getImageDB/"+data.atchFileId+"/"+data.fileSn+"'/>";
					editor.insertImage(welEditable,	setUrl);
					}
		});
	}
	$("#goSave").on("click", function() {
		$("#frm").attr("action", "<c:url value='/site/video/new'/>").submit();
	});
	$("#goUpdate").on("click", function() {
		$("#frm").attr("action", "<c:url value='/site/video/update/${video.pageIndex}'/>").submit();
	}); 
	$("#goCancel").on("click", function() {
		var action = '<c:url value="/site/video/list/1"/>';
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
									action=""
									style="border-radius: 0px;" id="frm" method="post">
									<fmt:parseDate value="${video.regiDate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
									<input type="hidden" name="displayDiv" value="M" />
									<input type="hidden" name="nttId" value="${video.nttId }" />
									<input type="hidden" name="regiDate" value="${video.regiDate}" />
									<input type="hidden" name="regiId" value="${video.regiId}" />
									
									<%-- <fmt:formatDate pattern="yyyy-MM-dd" value="${video.regiDate}" /> --%>
									<div class="form-group">
									
										<label class="col-sm-2 control-label">제목 TT : ${video.regiDate}</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="nttSj"
												placeholder="제목을 입력해 주세요" value="${video.nttSj}" />
										</div>
									</div>
									<%-- <c:out value="${video.nttLink}" escapeXml="false" /> --%>
									<div class="form-group">
										<label class="col-sm-2 control-label">유부트링크</label>
										<div class="col-sm-10">
											<textarea class="form-control"
												placeholder="유투브 링크를 넣어주세요" name="nttLink" id="nttLink" >${video.nttLink}</textarea>
												
												 
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">내용</label>
										<div class="col-sm-10">
											<!-- <textarea class="form-control" placeholder="내용을 입력해 주세요"></textarea> -->
											<!-- <div id="summernote" style="display: none;"></div> -->
											<textarea class="form-control" id="summernote" name="nttCn"
												rows="18">${video.nttCn}
											</textarea>
										</div>
									</div>
<c:if test="${'update' eq mode }">									
									<div class="form-group">
										<label class="col-sm-2 control-label">삭제여부</label>
										<div class="col-sm-10">
											<select class="form-control" name="useYn" >
												<option value="Y" ${'Y' eq video.useYn ? 'seleced=seleced':'' } >미삭제</option>
												<option value="N" ${'N' eq video.useYn ? 'seleced=seleced':'' } >삭제</option>
											</select>
										</div>
									</div>
</c:if>									


									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<c:choose>
												<c:when test="${'new' eq save}">
													<button type="button" class="btn btn-primary" id="goSave">등록</button>
												</c:when>
												<c:otherwise>
													<button type="button" class="btn btn-primary" id="goUpdate">수정</button>
												</c:otherwise>
											</c:choose>
											<button class="btn btn-default" id="goCancel">Cancel</button>
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
