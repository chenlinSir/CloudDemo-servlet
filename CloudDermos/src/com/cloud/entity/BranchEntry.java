package com.cloud.entity;

public class BranchEntry {
//部门实体
	//部门编号
	private int b_id ;
	// 部门名称
	private String b_name ;
	//部门备注
	private String b_remark;
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int bId) {
		b_id = bId;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String bName) {
		b_name = bName;
	}
	public String getB_remark() {
		return b_remark;
	}
	public void setB_remark(String bRemark) {
		b_remark = bRemark;
	}
	public BranchEntry(int bId, String bName, String bRemark) {
		super();
		b_id = bId;
		b_name = bName;
		b_remark = bRemark;
	}
	public BranchEntry() {
		super();
	}
	
	
}
