package com.cloud.entity;

import java.util.Date;

public class MRecordEntity {
	private int m_id;
	private Ordersenity oe;
	private Date beginTime;
	private Date endTime;
	private Sta_staffinfo se;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int mId) {
		m_id = mId;
	}
	public Ordersenity getOe() {
		return oe;
	}
	public void setOe(Ordersenity oe) {
		this.oe = oe;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Sta_staffinfo getSe() {
		return se;
	}
	public void setSe(Sta_staffinfo se) {
		this.se = se;
	}
	public MRecordEntity(int mId, Ordersenity oe, Date beginTime, Date endTime,
			Sta_staffinfo se) {
		super();
		m_id = mId;
		this.oe = oe;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.se = se;
	}
	public MRecordEntity(Ordersenity oe, Date beginTime, Date endTime,
			Sta_staffinfo se) {
		super();
		this.oe = oe;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.se = se;
	}
	public MRecordEntity() {
		super();
	}
	
}
