<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Board Insert</title>
<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp" />
</head>
<body class="animated">

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
														<label>Show <select size="1"
															name="datatable2_length" aria-controls="datatable2"
															class="form-control"><option value="10"
																	selected="selected">10</option>
																<option value="25">25</option>
																<option value="50">50</option>
																<option value="100">100</option></select> Rows
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
														style="width: 269px;" aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">제목</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 376px;">글쓴이</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 348px;">등록일</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 227px;">삭제여부</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="datatable2" rowspan="1" colspan="1"
														aria-label="CSS grade: activate to sort column ascending"
														style="width: 164px;">기타</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all">
												<tr class="gradeA odd">
													<td class="center "><img class="toggle-details"
														src="/images/plus.png"></td>
													<td class=" sorting_1">Gecko</td>
													<td class=" ">Firefox 1.0</td>
													<td class=" ">Win 98+ / OSX.2+</td>
													<td class="center ">1.7</td>
													<td class="center ">A</td>
												</tr>
												
											</tbody>
										</table>
										<div class="row">
											<div class="col-sm-12">
												<div class="pull-left">
													<div class="dataTables_info" id="datatable2_info">Showing
														1 to 10 of 57 entries</div>
												</div>
												<div class="pull-right">
													<div class="dataTables_paginate paging_bs_normal">
														<ul class="pagination">
															<li class="prev disabled"><a href="#"><span
																	class="fa fa-angle-left"></span>&nbsp;Previous</a></li>
															<li class="active"><a href="#">1</a></li>
															<li><a href="#">2</a></li>
															<li><a href="#">3</a></li>
															<li><a href="#">4</a></li>
															<li><a href="#">5</a></li>
															<li class="next"><a href="#">Next&nbsp;<span
																	class="fa fa-angle-right"></span></a></li>
														</ul>
													</div>
												</div>
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
