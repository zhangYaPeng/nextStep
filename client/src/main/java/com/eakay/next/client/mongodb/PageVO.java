package com.eakay.next.client.mongodb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageVO<T> implements Serializable {

	private static final long serialVersionUID = -5021355373678414115L;

	/** 当前页 */
	private int pageNo = 1;

	/** 每页显示条数 */
	private int pageSize = -1;

	/** 总记录数 */
	private long totalCount = -1;

	/** 总页数 */
	private long totalPages = -1;

	/** 返回结果 */
	private List<T> result = new ArrayList<T>();

	public PageVO() {
	}

	public PageVO(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if (pageSize < 1) {
			this.pageSize = 10;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPages() {
		if (totalCount < 0) {
			return -1;
		}

		long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		totalPages = count;
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
