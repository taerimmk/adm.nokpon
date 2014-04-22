<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Insert</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />

<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/bootstrap.wysihtml5/src/bootstrap-wysihtml5.css"/>"></link> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/bootstrap.summernote/dist/summernote.css" />" />
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.summernote/dist/summernote.min.js"/>"></script>  
<script type="text/javascript">
    $(document).ready(function(){
    	 //$('#summernote').summernote();
    	 
    	 $('#summernote').summernote({
             //height: 200,
             onImageUpload: function(files, editor, welEditable) {
                 sendFile(files[0], editor, welEditable);
             }
         });
         function sendFile(file, editor, welEditable) {
             var data = new FormData();
             data.append("file", file);
             $.ajax({
                 data: data,
                 type: "POST",
                 url: "<c:url value='/image/upload/db.json'/>",
                 cache: false,
                 contentType: false,
                 processData: false,
                 success: function(data) {
                	 var setUrl = "<c:url value='/getImageDB/"+data.atchFileId+"/"+data.fileSn+"'/>";
                	 //console.log("## "+setUrl);
                	 //var setUrl = "'"+data.setUrl+"'";
                     editor.insertImage(welEditable, setUrl);
                 }
             });
         }
         $("#goSave").on("click", function(){
        	 $("#frm").submit();
         });
      /*Date Range Picker*/
      
      /*Select2*/
        $(".select2").select2({
          width: '100%'
        });
      
       /*Tags*/
        $(".tags").select2({tags: 0,width: '100%'});
      
       /*Slider*/
        $('.bslider').slider();     
      
      /*Input & Radio Buttons*/
        $('.icheck').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass: 'iradio_flat-green'
        });
      /*spinners*/
        $("input[name='cleaninit']").TouchSpin();
        $("input[name='demo1']").TouchSpin({
          min: 0,
          max: 100,
          step: 0.1,
          decimals: 2,
          boostat: 5,
          maxboostedstep: 10,
          postfix: '%'
        });
        $("input[name='demo2']").TouchSpin({
          min: -1000000000,
          max: 1000000000,
          stepinterval: 50,
          maxboostedstep: 10000000,
          prefix: '$'
        });
        $("input[name='demo4']").TouchSpin({
          postfix: "a button",
          postfix_extraclass: "btn btn-default"
        });
      /*End of spinners*/
      /*Color Picker*/
        $('.demo1').colorpicker({
          format: 'hex', // force this format
        });
        $('.demo2').colorpicker({
          format: 'hex', // force this format
        });
        $('.demo-auto').colorpicker();
        // Disabled / enabled triggers
        $(".disable-button").click(function(e) {
            e.preventDefault();
            $("#demo_endis").colorpicker('disable');
        });

        $(".enable-button").click(function(e) {
            e.preventDefault();
            $("#demo_endis").colorpicker('enable');
        });

        
      /*End of Color Picker*/
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
								<form class="form-horizontal group-border-dashed" action="<c:url value="/board/${bbsId}/insertProc"/>"
									style="border-radius: 0px;" id="frm" method="post" enctype="multipart/form-data" >
									<div class="form-group">
										<label class="col-sm-2 control-label">제목</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="nttSj"
												placeholder="제목을 입력해 주세요" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">내용</label>
										<div class="col-sm-10">
											<!-- <textarea class="form-control" placeholder="내용을 입력해 주세요"></textarea> -->
											<!-- <div id="summernote" style="display: none;"></div> -->
											<textarea class="form-control" id="summernote" name="nttCn" rows="18">
											</textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">파일</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="Placeholder text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">이미지</label>
										<div class="col-sm-6">
											<div class="fileinput fileinput-new"
												data-provides="fileinput">
												<input type="hidden" value="" name="...">
												<div class="fileinput-new thumbnail"
													style="width: 200px; height: 150px;">
													<img src="http://placehold.it/190x140/7761A7/ffffff"
														alt="...">
												</div>
												<div class="fileinput-preview fileinput-exists thumbnail"
													style="max-width: 200px; max-height: 150px; line-height: 10px;"></div>
												<div>
													<span class="btn btn-primary btn-file"><span
														class="fileinput-new">Select image</span><span
														class="fileinput-exists">Change</span><input type="file"
														name="atchFileIdFile" /></span> <a href="#"
														class="btn btn-danger fileinput-exists"
														data-dismiss="fileinput">Remove</a>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-primary" id="goSave">Registrer</button>
											<button class="btn btn-default">Cancel</button>
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
