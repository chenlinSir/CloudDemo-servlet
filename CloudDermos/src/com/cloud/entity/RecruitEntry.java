package com.cloud.entity;

public class RecruitEntry {
	public int reId;
	public int post_id;
	public String post_name;
	public String pRemark;//职位介绍
	public String start_time;
	public String end_time;
	public int sum;
	public String b_name;
	public int b_id;
	public RecruitEntry(int reId, String postName, String pRemark,
			String startTime, String endTime, int sum, String bName) {
		super();
		this.reId = reId;
		post_name = postName;
		this.pRemark = pRemark;
		start_time = startTime;
		end_time = endTime;
		this.sum = sum;
		b_name = bName;
	}
	

	public RecruitEntry(int postId, String startTime, String endTime, int sum,
			int bId) {
		super();
		post_id = postId;
		start_time = startTime;
		end_time = endTime;
		this.sum = sum;
		b_id = bId;
	}


	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int postId) {
		post_id = postId;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int bId) {
		b_id = bId;
	}
	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String postName) {
		post_name = postName;
	}
	public String getpRemark() {
		return pRemark;
	}
	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String startTime) {
		start_time = startTime;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String endTime) {
		end_time = endTime;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String bName) {
		b_name = bName;
	}
	
	
}
