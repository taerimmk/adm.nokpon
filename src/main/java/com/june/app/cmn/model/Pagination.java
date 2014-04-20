package com.june.app.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

public class Pagination {
	@Transient
	private long pageIndex;
	@Transient
	private long totalPage;
	@Transient
	private int pagePerUnit;
	@Transient
	private int pageSize = 10;
	@Transient
	private int totalPageUnit;
	
	public long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public int getPagePerUnit() {
		return pagePerUnit;
	}
	public void setPagePerUnit(int pagePerUnit) {
		this.pagePerUnit = pagePerUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	

}