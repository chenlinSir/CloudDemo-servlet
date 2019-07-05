package com.cloud.entity;

import java.util.Date;



public class Recordenity {
	private int id;//主键
	private Ordersenity o_id;//订单外键
	private Sta_staffinfo s_id;//员工外键
	private Date Begin_time;//开始时间
	private Date end_time;//结束时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ordersenity getO_id() {
		return o_id;
	}
	public void setO_id(Ordersenity oId) {
		o_id = oId;
	}
	public Sta_staffinfo getS_id() {
		return s_id;
	}
	public void setS_id(Sta_staffinfo sId) {
		s_id = sId;
	}
	public Date getBegin_time() {
		return Begin_time;
	}
	public void setBegin_time(Date beginTime) {
		Begin_time = beginTime;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date endTime) {
		end_time = endTime;
	}
	public Recordenity(int id, Ordersenity oId, Sta_staffinfo sId,
			Date beginTime, Date endTime) {
		super();
		this.id = id;
		o_id = oId;
		s_id = sId;
		Begin_time = beginTime;
		end_time = endTime;
	}
	public Recordenity() {
		super();
	}
	public Recordenity(Ordersenity oId, Sta_staffinfo sId) {
		super();
		o_id = oId;
		s_id = sId;
	}
	
}
