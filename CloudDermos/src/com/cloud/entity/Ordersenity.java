package com.cloud.entity;

public class Ordersenity {
		private int Id;// 订单id
		private int o_id;//外键   出库订单编号ID
		private UserInfoEntry us_id;//外键  客户信息编号ID
		private Sta_staffinfo sta_id;//外键   接单员编号ID
		private BigServiceEntity lst_id;//外键  服务类型订单编号ID
		private Double discount;//折扣
		private Double l_price;//总金额
		private String pay_type;//付款方式
		private String order_state;//订单状态
		private String service_way;//服务方式
		private String remark;//备注
		
		public Ordersenity(int id) {
			super();
			Id = id;
		}
		public Ordersenity(int id, UserInfoEntry us_id, Sta_staffinfo sta_id,
				BigServiceEntity lst_id, Double discount, String pay_type,
				String order_state, String service_way, String remark) {
			super();
			Id = id;
			this.us_id = us_id;
			this.sta_id = sta_id;
			this.lst_id = lst_id;
			this.discount = discount;
			this.pay_type = pay_type;
			this.order_state = order_state;
			this.service_way = service_way;
			this.remark = remark;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public int getO_id() {
			return o_id;
		}
		public void setO_id(int oId) {
			o_id = oId;
		}
		public UserInfoEntry getUs_id() {
			return us_id;
		}
		public void setUs_id(UserInfoEntry usId) {
			us_id = usId;
		}
		public Sta_staffinfo getSta_id() {
			return sta_id;
		}
		public void setSta_id(Sta_staffinfo staId) {
			sta_id = staId;
		}
		public BigServiceEntity getLst_id() {
			return lst_id;
		}
		public void setLst_id(BigServiceEntity lstId) {
			lst_id = lstId;
		}
		public Double getDiscount() {
			return discount;
		}
		public void setDiscount(Double discount) {
			this.discount = discount;
		}
		public Double getL_price() {
			return l_price;
		}
		public void setL_price(Double lPrice) {
			l_price = lPrice;
		}
		public String getPay_type() {
			return pay_type;
		}
		public void setPay_type(String payType) {
			pay_type = payType;
		}
		public String getOrder_state() {
			return order_state;
		}
		public void setOrder_state(String orderState) {
			order_state = orderState;
		}
		public String getService_way() {
			return service_way;
		}
		public void setService_way(String serviceWay) {
			service_way = serviceWay;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Ordersenity(int id, int oId, UserInfoEntry usId,
				Sta_staffinfo staId, BigServiceEntity lstId, Double discount,
				Double lPrice, String payType, String orderState,
				String serviceWay, String remark) {
			super();
			Id = id;
			o_id = oId;
			us_id = usId;
			sta_id = staId;
			lst_id = lstId;
			this.discount = discount;
			l_price = lPrice;
			pay_type = payType;
			order_state = orderState;
			service_way = serviceWay;
			this.remark = remark;
		}
		public Ordersenity(int oId, UserInfoEntry usId,
				Sta_staffinfo staId, BigServiceEntity lstId, Double discount,
				Double lPrice, String payType, String orderState,
				String serviceWay, String remark) {
			super();
			o_id = oId;
			us_id = usId;
			sta_id = staId;
			lst_id = lstId;
			this.discount = discount;
			l_price = lPrice;
			pay_type = payType;
			order_state = orderState;
			service_way = serviceWay;
			this.remark = remark;
		}
		public Ordersenity(UserInfoEntry usId, Sta_staffinfo staId,
				BigServiceEntity lstId, Double discount, String payType,
				String orderState, String serviceWay, String remark) {
			super();
			us_id = usId;
			sta_id = staId;
			lst_id = lstId;
			this.discount = discount;
			pay_type = payType;
			order_state = orderState;
			service_way = serviceWay;
			this.remark = remark;
		}
		public Ordersenity(int id, int oId, UserInfoEntry usId,
				Sta_staffinfo staId, BigServiceEntity lstId, Double discount,
				String payType, String orderState, String serviceWay,
				String remark) {
			super();
			Id = id;
			o_id = oId;
			us_id = usId;
			sta_id = staId;
			lst_id = lstId;
			this.discount = discount;
			pay_type = payType;
			order_state = orderState;
			service_way = serviceWay;
			this.remark = remark;
		}
		
		
}
