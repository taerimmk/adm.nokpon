<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.paginator/js/bootstrap-paginator.min.js"/>"></script>
<script type='text/javascript'>
	$(function() {
		var options = {
			currentPage : '${pagination.pageIndex}',
			totalPages : 3,
			onPageClicked : function(e, originalEvent, type, page) {
				$('#alert-content').text(
						"Page item clicked, type: " + type + " page: " + page);
			},itemTexts: function (type, page, current) {
                switch (type) {
                case "first":
                    return "First";
                case "prev":
                    return "Previous";
                case "next":
                    return "Next";
                case "last":
                    return "Last";
                case "page":
                    return page;
                }
            }
		}

		$('#paging').bootstrapPaginator(options);
		$('#paging').find('ul').addClass("pagination");
	});
</script>

<div class="dataTables_paginate paging_bs_normal" id="paging"></div>