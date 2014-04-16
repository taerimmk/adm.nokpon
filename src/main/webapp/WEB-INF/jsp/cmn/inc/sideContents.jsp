<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="cl-toggle">
				<i class="fa fa-bars"></i>
			</div>
<div class="cl-navblock">
				<div class="menu-space">
					<div class="content">
						<div class="sidebar-logo">
							<div class="logo">
								<a href="index2.html"></a>
							</div>
						</div>
						<div class="side-user">
							<div class="avatar">
								<img src="images/avatar6.jpg" alt="Avatar" />
							</div>
							<div class="info">
								<p>
									40 <b>GB</b> / 100 <b>GB</b><span><a href="#"><i
											class="fa fa-plus"></i></a></span>
								</p>
								<div class="progress progress-user">
									<div class="progress-bar" role="progressbar" aria-valuenow="40"
										aria-valuemin="0" aria-valuemax="100" style="width: 40%">
										<span class="sr-only">50% Complete (success)</span>
									</div>
								</div>
							</div>
						</div>
						<ul class="cl-vnavigation">
							<li><a href="index.html"><i class="fa fa-home"></i><span>Dashboard</span></a></li>
							
							<li><a href="#"><i class="fa fa-smile-o"></i><span>사용자관리</span></a>
								<ul class="sub-menu">
									<li><a href="ui-elements.html">사용자등록/수정</a></li>
									<li><a href="ui-alerts.html">그룹관리</a></li>
									<li><a href="ui-alerts.html">권한관리</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-list-alt"></i><span>게시판관리</span></a>
								<ul class="sub-menu">
									<li><a href="<c:url value="/board/0/list/1"/>">게시판 등록/수정</a></li>
									
								</ul></li>
							<li><a href="#"><i class="fa fa-list-alt"></i><span>게시물관리</span></a>
								<ul class="sub-menu">
									<li><a href="<c:url value="/board/0/list/1"/>">게시물 등록/수정</a></li>
									
								</ul></li>	
							<li><a href="#"><i class="fa fa-table"></i><span>메인페이지</span></a>
								<ul class="sub-menu">
									<li><a href="tables-general.html">General</a></li>
									<li><a href="tables-datatables.html"><span
											class="label label-primary pull-right">New</span>Data Tables</a></li>
									<li><a href="tables-xeditable.html"><span
											class="label label-primary pull-right">New</span>X-Editable</a></li>
								</ul></li>
							
							
						</ul>
					</div>
				</div>
				<div class="text-right collapse-button" style="padding: 7px 9px;">
					<input type="text" class="form-control search"
						placeholder="Search..." />
					<button id="sidebar-collapse" class="btn btn-default" style="">
						<i style="color: #fff;" class="fa fa-angle-left"></i>
					</button>
				</div>
			</div>			