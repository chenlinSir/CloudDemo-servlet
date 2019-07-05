package com.cloud.entity;

public class PostInfoEntry {
//职位表
	 //-- 职位编号
	private int post_id;
	 // -- 职位名称
	private String post_name ;
	 //-- 部门编号 外键
	private BranchEntry bh;
	//--备注  可以为空（职位介绍）
	 private String p_remark;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int postId) {
		post_id = postId;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String postName) {
		post_name = postName;
	}
	public BranchEntry getBh() {
		return bh;
	}
	public void setBh(BranchEntry bh) {
		this.bh = bh;
	}
	public String getP_remark() {
		return p_remark;
	}
	public void setP_remark(String pRemark) {
		p_remark = pRemark;
	}
	public PostInfoEntry(int postId, String postName, BranchEntry bh,
			String pRemark) {
		super();
		post_id = postId;
		post_name = postName;
		this.bh = bh;
		p_remark = pRemark;
	}
	public PostInfoEntry() {
		super();
	}
	public PostInfoEntry(int postId, String postName, String pRemark) {
		super();
		post_id = postId;
		post_name = postName;
		p_remark = pRemark;
	}
	
	  
	  
	  
}
