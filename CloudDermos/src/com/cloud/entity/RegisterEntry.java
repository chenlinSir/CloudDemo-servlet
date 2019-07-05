package com.cloud.entity;

public class RegisterEntry {
	//管理人员
		//-- 管理员编号
		private int r_id;
		//-- 管理员名称
		 private String r_name;
		//  -- 管理员密码
		private String r_pwd;
		// -- 管理员联系电话 
	 	private String r_phone;
	 	// --备注  可以为空（登陆介绍）
	   private String r_remark;
	   // qq登陆
	   private String r_qq;
	public RegisterEntry(int rId, String rName, String rPwd, String rPhone,
			String rRemark, String rQq) {
		super();
		r_id = rId;
		r_name = rName;
		r_pwd = rPwd;
		r_phone = rPhone;
		r_remark = rRemark;
		r_qq = rQq;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int rId) {
		r_id = rId;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String rName) {
		r_name = rName;
	}
	public String getR_pwd() {
		return r_pwd;
	}
	public void setR_pwd(String rPwd) {
		r_pwd = rPwd;
	}
	public String getR_phone() {
		return r_phone;
	}
	public void setR_phone(String rPhone) {
		r_phone = rPhone;
	}
	public String getR_remark() {
		return r_remark;
	}
	public void setR_remark(String rRemark) {
		r_remark = rRemark;
	}
	public String getR_qq() {
		return r_qq;
	}
	public void setR_qq(String rQq) {
		r_qq = rQq;
	}
	public RegisterEntry() {
		super();
	}
	
		
}
