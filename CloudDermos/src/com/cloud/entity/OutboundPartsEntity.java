package com.cloud.entity;
public class OutboundPartsEntity {
	private int o_outboundId;//出库ID
	private String o_title;//出库标题
	private String o_time;//出库时间
	private String o_cause;//出库原因
	private String o_personnel;//出库人员
	private String o_manager;//仓库管理人员
	public OutboundPartsEntity(int oOutboundId, String oTitle, String oTime,
			String oCause, String oPersonnel, String oManager) {
		super();
		o_outboundId = oOutboundId;
		o_title = oTitle;
		o_time = oTime;
		o_cause = oCause;
		o_personnel = oPersonnel;
		o_manager = oManager;
	}
	public OutboundPartsEntity() {
		super();
	}
	public int getO_outboundId() {
		return o_outboundId;
	}
	public void setO_outboundId(int oOutboundId) {
		o_outboundId = oOutboundId;
	}
	public String getO_title() {
		return o_title;
	}
	public void setO_title(String oTitle) {
		o_title = oTitle;
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
	
}
