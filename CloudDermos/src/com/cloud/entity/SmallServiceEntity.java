package com.cloud.entity;

public class SmallServiceEntity {
	private int sst_id;//服务名称id
	private String sst_name;//服务名称
	private BigServiceEntity bse;//服务类型实体
	private double sst_price;//服务价格（工时费）
	private String sst_remarks;//备注
	public int getSst_id() {
		return sst_id;
	}
	public void setSst_id(int sstId) {
		sst_id = sstId;
	}
	public String getSst_name() {
		return sst_name;
	}
	public void setSst_name(String sstName) {
		sst_name = sstName;
	}
	public BigServiceEntity getBse() {
		return bse;
	}
	public void setBse(BigServiceEntity bse) {
		this.bse = bse;
	}
	public double getSst_price() {
		return sst_price;
	}
	public void setSst_price(double sstPrice) {
		sst_price = sstPrice;
	}
	public String getSst_remarks() {
		return sst_remarks;
	}
	public void setSst_remarks(String sstRemarks) {
		sst_remarks = sstRemarks;
	}
	public SmallServiceEntity(String sstName, BigServiceEntity bse,
			double sstPrice, String sstRemarks) {
		super();
		sst_name = sstName;
		this.bse = bse;
		sst_price = sstPrice;
		sst_remarks = sstRemarks;
	}
	public SmallServiceEntity(int sstId, String sstName, BigServiceEntity bse,
			double sstPrice, String sstRemarks) {
		super();
		sst_id = sstId;
		sst_name = sstName;
		this.bse = bse;
		sst_price = sstPrice;
		sst_remarks = sstRemarks;
	}
	public SmallServiceEntity() {
		super();
	}
	
}
