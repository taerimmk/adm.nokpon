<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BoardMaster Detail</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
<style type="text/css">
.fileaattchYn{
display: none;
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
			
								<form class="form-horizontal group-border-dashed"
									action="<c:url value="/boardMaster/insert"/>"
									style="border-radius: 0px;" id="frm" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-sm-3 control-label">게시판명</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="bbsNm" id ="bbsNm"
												placeholder="게시판명을 입력해 주세요" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">답글가능여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn"
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y
													
												</div> 
											</label> <label class="radio-inline">
												<div class="" aria-checked="false"
													aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="answerPosblYn" checked="checked"
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
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y
													
												</div> 
											</label> <label class="radio-inline">
												<div class="" aria-checked="false"
													aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="comntPosblYn" checked="checked"
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
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y
													
												</div> 
											</label> <label class="radio-inline">
												<div class="" aria-checked="false"
													aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="fileAtchPosblYn" checked="checked"
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div> 
											</label>
										</div>
									</div>
									<div class="form-group fileaattchYn">
										<label class="col-sm-2 control-label">첨부파일갯수</label>
										<div class="col-sm-6">
											<select class="form-control" class="fileaattchYnInput">
												<option value="1" >1</option>
												<option value="2" >2</option>
												<option value="3" >3</option>
												<option value="4" >4</option>
												<option value="5" >5</option>
											</select>
										</div>
									</div>
									<div class="form-group fileaattchYn">
										<label class="col-sm-3 control-label">파일사이즈</label>
										<div class="col-sm-9">
											<input type="text" class="form-control fileaattchYnInput" name="atchPosblFileSize" id="atchPosblFileSize"
												placeholder="파일크기를 입력해 주세요(단위 : kb)" /> 
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">사용여부</label>
										<div class="col-sm-9">
											<label class="radio-inline">
												<div aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="useYn" checked="checked"
														style="position: absolute; opacity: 0;" value="Y" />&nbsp;&nbsp;Y
													
												</div> 
											</label> <label class="radio-inline">
												<div class="" aria-checked="false"
													aria-disabled="false" style="position: relative;">
													<input class="icheck" type="radio" name="useYn" 
														style="position: absolute; opacity: 0;" value="N" />&nbsp;&nbsp;N
												</div> 
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button" class="btn btn-primary" id="goSave">등록</button>
											<a href="<c:url value="/boardMaster/list/1"/>" ><button type="button" class="btn btn-default">취소</button></a>
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

		$("#goSave").on("click", function() {
			$("#frm").submit();
		});
		$('.icheck').iCheck({
	          checkboxClass: 'icheckbox_flat-green',
	          radioClass: 'iradio_flat-green'
		});
		$("input[type=radio][name='fileAtchPosblYn']").on("change", function(){
			alert("!");
			var fileAtchPosblYn = $("input[name='fileAtchPosblYn']:checked").val();
			if (fileAtchPosblYn =='Y'){
				$(".fileaattchYn").show();
			}else{
				$(".fileaattchYnInput").val("");
				$(".fileaattchYn").hide();
			}
		});
	});
</script>	
</body>
</html>
