package com.cloud.util;

import java.util.List;

/**
 * 
 * @author Administrator
 * 
 *         分页类
 */
public class Page<T> {
	private int currentPage;// 当前页数
	private int pageCount;// 每页条数
	private int totleCount;// 总条数
	private int totlePage;// 总页数
	private List<T> list;

	public Page(int currentPage, int pageCount, int totleCount, List<T> list) {
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.totleCount = totleCount;
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	// 上一页功能
	public int prePage() {
		if (currentPage == 1) {
			return currentPage;
		}
		return currentPage - 1;
	}

	// 下一页功能
	public int nextPage() {
		if (currentPage == totlePage) {
			return currentPage;
		}
		return currentPage + 1;
	}

	public int getTotlePage() {
		if (totleCount % pageCount == 0) {
			totlePage = totleCount / pageCount;
		} else {
			totlePage = totleCount / pageCount + 1;
		}
		return totlePage;
	}
}
