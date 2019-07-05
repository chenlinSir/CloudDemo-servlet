package com.cloud.entity;
/*
 * querytheWarehouse表（配件信息表）
 */
public class QuerytheWarehouseEntity {
	private int q_id;//配件信息ID
	private String q_vehicleBrand;//配件适用车型
	private String q_partsImg;//图片IMG地址
	private String q_partsName;//配件名称
	private String q_partBrand;//配件品牌
	private int q_number;//数量
	private String q_unit;//单位
	private String q_partType;//配件型号
	private String q_partEffect;//配件
	private double q_buyingRate;//配件进价
	private double q_sellingPrice;//售价
	private int q_noFollow; //是否需要  1需要 0不需要
	
	public int q_noFollow() {
		return q_noFollow;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int qId) {
		q_id = qId;
	}
	public String getQ_vehicleBrand() {
		return q_vehicleBrand;
	}
	public QuerytheWarehouseEntity() {
		super();
	}
	public QuerytheWarehouseEntity(int q_Id, String q_VehicleBrand, String q_PartsImg,
			String q_PartsName, String q_PartBrand, int q_Number, String q_Unit,
			String q_PartType, String q_PartEffect, double q_BuyingRate,
			double q_SellingPrice) {
		super();
		q_id = q_Id;
		q_vehicleBrand = q_VehicleBrand;
		q_partsImg = q_PartsImg;
		q_partsName = q_PartsName;
		q_partBrand = q_PartBrand;
		q_number = q_Number;
		q_unit = q_Unit;
		q_partType = q_PartType;
		q_partEffect = q_PartEffect;
		q_buyingRate = q_BuyingRate;
		q_sellingPrice = q_SellingPrice;
	}
	public QuerytheWarehouseEntity(int qId, String qVehicleBrand,
			String qPartsImg, String qPartsName, String qPartBrand,
			int qNumber, String qUnit, String qPartType, String qPartEffect,
			double qBuyingRate, double qSellingPrice, int qNoFollow) {
		super();
		q_id = qId;
		q_vehicleBrand = qVehicleBrand;
		q_partsImg = qPartsImg;
		q_partsName = qPartsName;
		q_partBrand = qPartBrand;
		q_number = qNumber;
		q_unit = qUnit;
		q_partType = qPartType;
		q_partEffect = qPartEffect;
		q_buyingRate = qBuyingRate;
		q_sellingPrice = qSellingPrice;
		q_noFollow = qNoFollow;
	}
	public void setQ_vehicleBrand(String qVehicleBrand) {
		q_vehicleBrand = qVehicleBrand;
	}
	public String getQ_partsImg() {
		return q_partsImg;
	}
	public void setQ_partsImg(String qPartsImg) {
		q_partsImg = qPartsImg;
	}
	public String getQ_partsName() {
		return q_partsName;
	}
	public void setQ_partsName(String qPartsName) {
		q_partsName = qPartsName;
	}
	public String getQ_partBrand() {
		return q_partBrand;
	}
	public void setQ_partBrand(String qPartBrand) {
		q_partBrand = qPartBrand;
	}
	public int getQ_number() {
		return q_number;
	}
	public void setQ_number(int qNumber) {
		q_number = qNumber;
	}
	public String getQ_unit() {
		return q_unit;
	}
	public void setQ_unit(String qUnit) {
		q_unit = qUnit;
	}
	public String getQ_partType() {
		return q_partType;
	}
	public void setQ_partType(String qPartType) {
		q_partType = qPartType;
	}
	public String getQ_partEffect() {
		return q_partEffect;
	}
	public void setQ_partEffect(String qPartEffect) {
		q_partEffect = qPartEffect;
	}
	public double getQ_buyingRate() {
		return q_buyingRate;
	}
	public void setQ_buyingRate(double qBuyingRate) {
		q_buyingRate = qBuyingRate;
	}
	public double getQ_sellingPrice() {
		return q_sellingPrice;
	}
	public void setQ_sellingPrice(double qSellingPrice) {
		q_sellingPrice = qSellingPrice;
	}
	public int getQ_noFollow() {
		return q_noFollow;
	}
	public void setQ_noFollow(int qNoFollow) {
		q_noFollow = qNoFollow;
	}
	
}
