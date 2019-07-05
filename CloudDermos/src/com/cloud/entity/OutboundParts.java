package com.cloud.entity;
/*
 * ����������� entity
 * */
public class OutboundParts {
	private int o_outboundId;//����ID
	private int o_partsId;//���ID
	private String o_partsName;//������
	private int	o_number;//��������
	private String o_time;//����ʱ��
	private String o_cause;//����ԭ��
	private String o_personnel;//������Ա
	private String o_manager;//�ֿ������Ա
	public int getO_outboundId() {
		return o_outboundId;
	}
	public void setO_outboundId(int oOutboundId) {
		o_outboundId = oOutboundId;
	}
	public int getO_partsId() {
		return o_partsId;
	}
	public void setO_partsId(int oPartsId) {
		o_partsId = oPartsId;
	}
	public String getO_partsName() {
		return o_partsName;
	}
	public void setO_partsName(String oPartsName) {
		o_partsName = oPartsName;
	}
	public int getO_number() {
		return o_number;
	}
	public void setO_number(int oNumber) {
		o_number = oNumber;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String oTime) {
		o_time = oTime;
	}
	public String getO_cause() {
		return o_cause;
	}
	public void setO_cause(String oCause) {
		o_cause = oCause;
	}
	public String getO_personnel() {
		return o_personnel;
	}
	public void setO_personnel(String oPersonnel) {
		o_personnel = oPersonnel;
	}
	public String getO_manager() {
		return o_manager;
	}
	public void setO_manager(String oManager) {
		o_manager = oManager;
	}
	public OutboundParts(int oOutboundId, int oPartsId, String oPartsName,
			int oNumber, String oTime, String oCause, String oPersonnel,
			String oManager) {
		super();
		o_outboundId = oOutboundId;
		o_partsId = oPartsId;
		o_partsName = oPartsName;
		o_number = oNumber;
		o_time = oTime;
		o_cause = oCause;
		o_personnel = oPersonnel;
		o_manager = oManager;
	}
	public OutboundParts() {
		super();
	}
	public OutboundParts(int oOutboundId) {
		super();
		o_outboundId = oOutboundId;
	}
	
}
