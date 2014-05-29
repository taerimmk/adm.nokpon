<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BoardMaster Update</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
<style type="text/css">
/* .fileaattchYn{
display: none;
} */
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
						<form class="form-horizontal group-border-dashed"
							action="<c:url value="/boardMaster/update/${boardMasterDetail.bbsId}/${boardMasterDetail.pageIndex}"/>"
							style="border-radius: 0px;" id="frm" method="post"
							enctype="multipart/form-data">
							<div class="block-flat">
								<div class="header">
									<h3>게시판 등록</h3>
								</div>
								<div class="content">


									<input type="hidden" id="bbsId" name="bbsId"
										value="${boardMasterDetail.bbsId}" />
									<div class="form-group">
										<label class="col-sm-3 control-label">게시판명</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="bbsNm"
												id="bbsNm" placeholder="게시판명을 입력해 주세요"
												value="${boardMasterDetail.bbsNm }" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">답글가능여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn"
														style="position: absolute; opacity: 0;" value="Y"
														${boardMasterDetail.answerPosblYn eq 'Y' ? 'checked':''} />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn"
														${boardMasterDetail.answerPosblYn eq 'N' ? 'checked':''}
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
														${boardMasterDetail.comntPosblYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="comntPosblYn"
														${boardMasterDetail.comntPosblYn eq 'N' ? 'checked':''}
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
														${boardMasterDetail.fileAtchPosblYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="fileAtchPosblYn"
														${boardMasterDetail.fileAtchPosblYn eq 'N' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>
									<div class="form-group fileaattchYn"
										${boardMasterDetail.fileAtchPosblYn eq 'N' ? 'style=display:none;':''}>
										<label class="col-sm-3 control-label">첨부파일갯수</label>
										<div class="col-sm-6">
											<select class="form-control" class="fileaattchYnInput"
												id="atchPosblFileNumber" name="atchPosblFileNumber">
												<option value="1"
													${boardMasterDetail.atchPosblFileNumber eq '1' ? 'selected':''}>1</option>
												<option value="2"
													${boardMasterDetail.atchPosblFileNumber eq '2' ? 'selected':''}>2</option>
												<option value="3"
													${boardMasterDetail.atchPosblFileNumber eq '3' ? 'selected':''}>3</option>
												<option value="4"
													${boardMasterDetail.atchPosblFileNumber eq '4' ? 'selected':''}>4</option>
												<option value="5"
													${boardMasterDetail.atchPosblFileNumber eq '5' ? 'selected':''}>5</option>
											</select>
										</div>
									</div>
									<div class="form-group fileaattchYn"
										${boardMasterDetail.fileAtchPosblYn eq 'N' ? 'style=display:none;':''}>
										<label class="col-sm-3 control-label">파일사이즈</label>
										<div class="col-sm-9">
											<input type="text" class="form-control fileaattchYnInput"
												name="atchPosblFileSize" id="atchPosblFileSize"
												placeholder="파일크기를 입력해 주세요(단위 : kb)"
												value="${boardMasterDetail.atchPosblFileSize}" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">사용여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="useYn"
														${boardMasterDetail.useYn eq 'Y' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y

												</div>
											</label> <label class="radio-inline">
												<div class="" aria-checked="false" aria-disabled="false"
													style="position: relative;">
													<input class="icheck" type="radio" name="useYn"
														${boardMasterDetail.useYn eq 'N' ? 'checked':''}
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div>
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button" class="btn btn-primary" id="goSave">수정</button>
											<a
												href="<c:url value="/boardMaster/get/${boardMasterDetail.bbsId}/${boardMaster.pageIndex}"/>"><button
													type="button" class="btn btn-default" id="goList">취소</button></a>
											<a
												href="<c:url value="/boardMaster/list/${boardMaster.pageIndex}"/>"><button
													type="button" class="btn btn-default" id="goList">목록</button></a>
										</div>
									</div>

								</div>
							</div>


							<div class="block-flat">
								<div class="header">
									<h3>게시판 권한</h3>
								</div>
								<div class="content">



									<div class="form-group">
										<label class="col-sm-3 control-label">Inline Checkbox</label>
										<div class="col-sm-9">
											<label class="checkbox-inline">
												<div style="position: relative;">
													<input class="icheck" type="checkbox" checked=""
														name="rad1" style="position: absolute; opacity: 0;" />&nbsp;&nbsp;읽기

												</div>
											</label> <label class="checkbox-inline">
												<div style="position: relative;">
													<input class="icheck" type="checkbox" name="rad1"
														style="position: absolute; opacity: 0;" />&nbsp;&nbsp;쓰기
												</div>
											</label> <label class="checkbox-inline">
												<div 
													style="position: relative;">
													<input class="icheck" type="checkbox" name="rad1"
														style="position: absolute; opacity: 0;" />&nbsp;&nbsp;수정
													
												</div>
											</label>
											<label class="checkbox-inline">
												<div 
													style="position: relative;">
													<input class="icheck" type="checkbox" name="rad1"
														style="position: absolute; opacity: 0;" />&nbsp;&nbsp;삭제
													
												</div>
											</label>
										</div>
									</div>


								</div>
							</div>
						</form>
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
		$(document)
				.ready(
						function() {

							$("#goSave").on("click", function() {
								$("#frm").submit();
							});

							/* $('.icheck').iCheck({
							      checkboxClass: 'icheckbox_flat-green',
							      radioClass: 'iradio_flat-green'
							}); */
							$('.icheck')
									.on(
											'ifCreated ifClicked ifChanged ifChecked ifUnchecked ifDisabled ifEnabled ifDestroyed check ',
											function(event) {
												/* if(event.type ==="ifChecked"){
												    $(this).trigger('click');  
												    $('input').iCheck('update');
												}
												if(event.type ==="ifUnchecked"){
												    $(this).trigger('click');  
												    $('input').iCheck('update');
												}       
												if(event.type ==="ifDisabled"){
												    console.log($(this).attr('id')+'dis');  
												    $('input').iCheck('update');
												}   */
												if (event.type === "ifChanged") {
													toggleFileInput();
												}
											}).iCheck({
										checkboxClass : 'icheckbox_flat-green',
										radioClass : 'iradio_flat-green'
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
