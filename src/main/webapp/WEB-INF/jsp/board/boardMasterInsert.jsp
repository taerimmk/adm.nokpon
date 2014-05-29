<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BoardMaster Detail</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
<style type="text/css">
/* .fileaattchYn{
display: none;
} */
.errors {
	color: red;
}
</style>

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
						<li><a href="#">게시판 관리</a></li>
						<li class="active">게시판 등록</li>
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
								<h3>게시판 등록</h3>
							</div>
							<div class="content">


								<form:form class="form-horizontal group-border-dashed"
									commandName="boardMaster" action="" style="border-radius: 0px;"
									id="frm" name="frm" method="post">
									<div class="form-group">
										<label class="col-sm-3 control-label">게시판명</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="bbsNm"
												id="bbsNm" placeholder="게시판명을 입력해 주세요"
												value="${boardMaster.bbsNm}" /><form:errors path="bbsNm" class="errors" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">답글가능여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn"
														style="position: absolute; opacity: 0;" value="Y"
														${boardMaster.answerPosblYn eq 'Y' ? 'checked':''} />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn"
														${boardMaster.answerPosblYn eq 'Y' ? '':'checked'}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">댓글가능여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="comntPosblYn"
														${boardMaster.comntPosblYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="comntPosblYn"
														${boardMaster.comntPosblYn eq 'Y' ? '':'checked'}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">파일첨부가능여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="fileAtchPosblYn"
														${boardMaster.fileAtchPosblYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="fileAtchPosblYn"
														${boardMaster.fileAtchPosblYn eq 'Y' ? '':'checked'}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>
									<div class="form-group fileaattchYn"
										${boardMaster.fileAtchPosblYn eq 'Y' ? '':'style=display:none;'}>
										<label class="col-sm-3 control-label">첨부파일갯수</label>
										<div class="col-sm-4">
											<select class="form-control" class="fileaattchYnInput"
												id="atchPosblFileNumber" name="atchPosblFileNumber">
												<option value="1"
													${boardMaster.atchPosblFileNumber eq '1' ? 'selected':''}>1</option>
												<option value="2"
													${boardMaster.atchPosblFileNumber eq '2' ? 'selected':''}>2</option>
												<option value="3"
													${boardMaster.atchPosblFileNumber eq '3' ? 'selected':''}>3</option>
												<option value="4"
													${boardMaster.atchPosblFileNumber eq '4' ? 'selected':''}>4</option>
												<option value="5"
													${boardMaster.atchPosblFileNumber eq '5' ? 'selected':''}>5</option>
											</select>
										</div>
									</div>
									<div class="form-group fileaattchYn"
										${boardMaster.fileAtchPosblYn eq 'Y' ? '':'style=display:none;'}>
										<label class="col-sm-3 control-label">파일사이즈</label>
										<div class="col-sm-4">
											<input type="text" class="form-control fileaattchYnInput"
												name="atchPosblFileSize" id="atchPosblFileSize"
												placeholder="파일크기를 입력해 주세요(단위 : kb)"
												value="${boardMaster.atchPosblFileSize}" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">사용여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="useYn"
														${boardMaster.useYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="useYn"
														${boardMaster.useYn eq 'Y' ? '':'checked'}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button" class="btn btn-primary" id="goSave">등록</button>
											<a href="<c:url value="/boardMaster/list/1"/>"><button
													type="button" class="btn btn-default">취소</button></a>
										</div>
									</div>
								</form:form>
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
		$(document).ready(
				function() {

					$("#goSave").on(
							"click",
							function() {
								$("#frm").attr("action",
										"<c:url value='/boardMaster/insert'/>")
										.submit();
								return false;
							});
					$('.icheck').on('ifChanged', function(event) {
						if (event.type === "ifChanged") {
							toggleFileInput();
						}
					}).iCheck({
						checkboxClass : 'icheckbox_flat-purple',
						radioClass : 'iradio_flat-purple'
					});
					$("input[name='atchPosblFileSize']").TouchSpin({
						min : 0,
						max : 1000000000,
						stepinterval : 50,
						step : 1024,
						maxboostedstep : 10000000,
						prefix : 'KB'
					});

				});
		var toggleFileInput = function() {
			var fileAtchPosblYn = $("input[name='fileAtchPosblYn']:checked")
					.val();
			if (fileAtchPosblYn == 'Y') {
				$(".fileaattchYn").show();
			} else {
				$(".fileaattchYnInput").val("");
				$("#atchPosblFileNumber").val("1");

				$(".fileaattchYn").hide();
			}
		};
	</script>
</body>
</html>
