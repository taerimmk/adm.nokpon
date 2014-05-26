<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board List</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />

<script type='text/javascript'>
	$(function() {
		pagination('paging','${board.pageIndex}','${board.totalPageUnit}','callTest');
		
		$("#getBoardMst").on("change", function(){
			movePage(1);
		});
		$("#goRegistrer").on("click", function(){
			var bbsId = $("#getBoardMst").val();
			var action = '<c:url value="/board/'+bbsId+'/insert" />';
			location.href = action;
			
			return false;
		});
		
	});

var callTest = function(page){
	movePage(page);
};
var movePage = function(page){
	var bbsId = $("#getBoardMst").val();
	var action = '<c:url value="/board/'+bbsId+'/list/'+page+'" />';
	location.href = action;
	
	return false;
};
</script>
</head>
<body class="animated">
<form action="" method="post" id="frm" name="frm">

</form>
	<div id="cl-wrapper">

		<div class="cl-sidebar">
			<jsp:include page="/WEB-INF/jsp/cmn/inc/sideContents.jsp" />

		</div>
		<div class="container-fluid" id="pcont">
			<!-- TOP NAVBAR -->
			<jsp:include page="/WEB-INF/jsp/cmn/inc/headerContents.jsp" />


			<div class="cl-mcont">
				<div class="page-head">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">Tables</a></li>
						<li class="active">Data Tables</li>
					</ol>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
								<h3>Row Details</h3>
							</div>
							<div class="content">
								<div class="table-responsive">
									<div id="datatable2_wrapper"
										class="dataTables_wrapper form-inline" role="grid">
										<div class="row">
											<div class="col-sm-12">
												<div class="pull-right">
													<div class="dataTables_filter" id="datatable2_filter">
														<label><input type="text"
															aria-controls="datatable2" class="form-control"
															placeholder="Search"></label>
													</div>
												</div>
												<div class="pull-left">
													<div id="datatable2_length" class="dataTables_length">
														<label>Select <select size="1"
															name="datatable2_length" aria-controls="datatable2"
															class="form-control" id="getBoardMst">
															<option value="0">전체</option>
															<c:forEach items="${boardMstList}" var="boardMst" varStatus="boarMstStatus">
																<option value="${boardMst.bbsId}" <c:if test="${boardMst.bbsId eq board.bbsId}">selected='selected'</c:if>>${boardMst.bbsNm}</option>
															</c:forEach>
															</select>  BBS
														</label>
													</div>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<table class="table table-bordered dataTable" id="datatable2"
											aria-describedby="datatable2_info">
											<thead>
												<tr role="row">
													<th class="sorting_disabled" role="columnheader"
														rowspan="1" colspan="1" aria-label="" style="width: 22px;"></th>
													<th class="sorting_asc" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														style="width: 469px;" aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">제목</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 176px;">글쓴이</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 248px;">등록일</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 127px;">삭제여부</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="CSS grade: activate to sort column ascending"
														style="width: 164px;">기타</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all">
											<c:if test="${not empty boardList }">
												<c:forEach items="${boardList }" varStatus="status" var="rData">
												<tr class="gradeA odd">
													<td class="center "><img class="toggle-details"
														src="/images/plus.png"></td>
													<td class=" sorting_1"><a href="<c:url value="/board/${rData.bbsId}/get/${rData.nttId}"/>">${rData.nttSj }</a></td>
													<td class=" ">${rData.user.userId}</td>
													<td class=" ">${rData.regiDate }</td>
													<td class="center ">
														${rData.useYn  eq 'N' ? '삭제' : '미삭제'}
													</td>
													<td class="center ">A</td>
												</tr>
												</c:forEach>
											</c:if>													
											</tbody>
										</table>
										<div class="row">
										
											<div class="col-sm-12">
												<div class="pull-left">
													<div class="dataTables_info" id="datatable2_info"><button type="submit" class="btn btn-primary" id="goRegistrer">Registrer</button></div>
												</div>
												<div class="pull-right">
													<div class="dataTables_paginate paging_bs_normal" id="paging"></div>
												</div>
												<!-- <div class="pull-right" id="paging">
													
												</div> -->
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

	<jsp:include page="/WEB-INF/jsp/cmn/inc/footerResource.jsp" />
</body>
</html>
