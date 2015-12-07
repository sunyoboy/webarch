package com.slj.basic.util;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	
	private int pageNum = 1;
	
	private int pageSize = 10;
	
	private long totalRow;
	
	private int totalPage;
	
	private int startRow;
	
	private int endRow;
	
	private List<T> resultList;

	public Page() {
		this.startRow = this.getStartRow();
		this.endRow = this.getEndRow();
	}
	
	public Page(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;
		this.endRow = pageNum * pageSize;		
	}

	public Page(int pageNum, int pageSize, long totalRow, int totalPage,
			int startRow, int endRow, List<T> resultList) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRow = totalRow;
		this.totalPage = totalPage;
		this.startRow = this.getStartRow();
		this.endRow = this.getEndRow();
		this.resultList = resultList;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		endRow = pageNum * pageSize;
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}	

	public int getFirstPage() {
	    setPageNum(1);
        return pageNum;
    }

    public int getLastPage() {
        setPageNum(totalPage);
        return pageNum;
    }

    public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	public int getNextPage() {
		if(pageNum < totalPage) {
			pageNum += 1;
		} 
			
		return pageNum;
	}
	
	public int getPrevPage() {
		if(pageNum > 0) {
			return (pageNum - 1);
		} 
		
		return pageNum;
	}
	
}
