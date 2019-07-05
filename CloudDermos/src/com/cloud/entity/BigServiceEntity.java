package com.cloud.entity;

public class BigServiceEntity {
	private int lst_id;//����id
	private String lst_name;//�����������
	
	public int getLst_id() {
		return lst_id;
	}
	public void setLst_id(int lstId) {
		lst_id = lstId;
	}
	public String getLst_name() {
		return lst_name;
	}
	public void setLst_name(String lstName) {
		lst_name = lstName;
	}
	public BigServiceEntity(int lstId, String lstName) {
		super();
		lst_id = lstId;
		lst_name = lstName;
	}
	public BigServiceEntity() {
		super();
	}
	public BigServiceEntity(int lstId) {
		super();
		lst_id = lstId;
	}
	
}
