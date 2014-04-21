pagination= function(id, pageIndex, totalPages,nextFn){
	var options = {
			currentPage : pageIndex,
			totalPages : totalPages,
			onPageClicked : function(e, originalEvent, type, page) {
				//callTest();
				var strFun = nextFn;
				var fn = window[strFun];
				fn(page);
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

		$('#'+id).bootstrapPaginator(options);
		//$('#'+id).find('ul').addClass("pagination");
};	