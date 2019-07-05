package com.cloud.entity;

public class OutboundPartsInfoEntity {
	private int o_ouId;//出库ID
	private int o_partsId2;//配件出库ID,外键
	private int o_querytheWarehouseId2;//配件基本信息ID,外键
	private int o_number;//出库数量
	private double o_totalPrice;//总金额
	public int getO_ouId() {
		return o_ouId;
	}
	public void setO_ouId(int oOuId) {
		o_ouId = oOuId;
	}
	public int getO_partsId2() {
		return o_partsId2;
	}
	public void setO_partsId2(int oPartsId2) {
		o_partsId2 = oPartsId2;
	}
	public int getO_querytheWarehouseId2() {
		return o_querytheWarehouseId2;
	}
	public void setO_querytheWarehouseId2(int oQuerytheWarehouseId2) {
		o_querytheWarehouseId2 = oQuerytheWarehouseId2;
	}
	public int getO_number() {
		return o_number;
	}
	public void setO_number(int oNumber) {
		o_number = oNumber;
	}
	public double getO_totalPrice() {
		return o_totalPrice;
	}
	public void setO_totalPrice(double oTotalPrice) {
		o_totalPrice = oTotalPrice;
	}
	public OutboundPartsInfoEntity(int oOuId, int oPartsId2,
			int oQuerytheWarehouseId2, int oNumber, double oTotalPrice) {
		super();
		o_ouId = oOuId;
		o_partsId2 = oPartsId2;
		o_querytheWarehouseId2 = oQuerytheWarehouseId2;
		o_number = oNumber;
		o_totalPrice = oTotalPrice;
	}
	public OutboundPartsInfoEntity() {
		super();
	}
	
}
