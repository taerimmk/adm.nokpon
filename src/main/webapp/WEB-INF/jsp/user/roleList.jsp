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
		pagination('paging', '${user.pageIndex}', '${user.totalPageUnit}',
				'movePage');

		$("#goRegistrer").on("click", function() {
			var action = '<c:url value="/user/new" />';
			location.href = action;
		});

		$(".checkAll").on("click", function() {
			var checkedStatus = this.checked;
			$(".checkAllSub").each(function() {
				$(this).prop('checked', checkedStatus);
			});
		});

	});
	var movePage = function(page) {
		var action = '<c:url value="/user/list/'+page+'" />';
		location.href = action;
	};
</script>
</head>
<body class="animated">
	<form action="" method="post" id="frm" name="frm"></form>
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
												<div class="pull-left"></div>
												<div class="clearfix"></div>
											</div>
										</div>
										<table class="table table-bordered dataTable" id="datatable2"
											aria-describedby="datatable2_info">
											<thead>
												<tr role="row">
													<th class="sorting_disabled" role="columnheader"
														rowspan="1" colspan="1" aria-label="" style="width: 22px;"><input
														type="checkbox" class="checkAll" /></th>
													<th class="sorting_asc" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														style="width: 369px;" aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">사용자</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 276px;">권한</th>

												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all">
												<c:if test="${not empty userList }">
													<c:forEach items="${userList }" varStatus="status"
														var="rData">
														<tr class="gradeA odd">
															<td class="center "><input type="checkbox"
																class="checkAllSub" name="seq"
																value="${rData.userRoleInfo.seq}" /></td>
															<td class=" sorting_1"><a
																href="<c:url value="/user/get/${rData.seq}/${user.pageIndex }"/>">${rData.userId }</a>
															</td>
															<td class="center"><select class="form-control">

																	<c:forEach items="${roleList}" var="roleData">
																		<option value="${roleData.seq}"
																			${ roleData.seq eq rData.userRoleInfo.roleInfo.seq ? 'selected=selected': ''}>${roleData.role }</option>
																	</c:forEach>
															</select></td>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>
										</table>
										<div class="row">

											<div class="col-sm-12">
												<div class="pull-left">
													<div class="dataTables_info" id="datatable2_info">
														<button type="submit" class="btn btn-primary"
															id="goRegistrer">저장</button>
													</div>
												</div>
												<div class="pull-right">
													<div class="dataTables_paginate paging_bs_normal"
														id="paging"></div>
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
