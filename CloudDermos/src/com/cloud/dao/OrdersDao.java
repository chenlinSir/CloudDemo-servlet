package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cloud.entity.BigServiceEntity;
import com.cloud.entity.Ordersenity;
import com.cloud.entity.OutboundParts;
import com.cloud.entity.Recordenity;
import com.cloud.entity.SmallServiceEntity;
import com.cloud.entity.Sta_staffinfo;
import com.cloud.entity.UserInfoEntry;

import com.cloud.util.Conn;
import com.cloud.util.DateTime;


public class OrdersDao {
  Conn conn=new Conn();
private String us_name;
	public ArrayList<BigServiceEntity> selectBigfu() {
		ArrayList<BigServiceEntity> list=new ArrayList<BigServiceEntity>();
		PreparedStatement stat=null;
		ResultSet row=null;
		String sql="select * from LargeServiceType";
		 try {
			stat=conn.conn.prepareStatement(sql);
			 row = stat.executeQuery();
			 while(row.next()){
				 int id=row.getInt("l_id");
				 String lst_name=row.getString("lst_name");
				 BigServiceEntity big=new BigServiceEntity(id, lst_name);
				 list.add(big);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SmallServiceEntity> selectsmlfu(int lstId) {
		ArrayList<SmallServiceEntity> list=new ArrayList<SmallServiceEntity>();
		PreparedStatement stat=null;
		ResultSet row=null;
		String sql="select * from SmallServiceTypes WHERE lst_id=?";

		try {
			stat=conn.conn.prepareStatement(sql);
			stat.setInt(1, lstId);
			row = stat.executeQuery();
			while(row.next()){
				int id=row.getInt("id");
				String sst_name=row.getString("sst_name");
				int lst_id=row.getInt("lst_id");
				BigServiceEntity big=new BigServiceEntity(lst_id);
				Double sst_price=row.getDouble("sst_price");
				String sst_remarks=row.getString("sst_remarks");
				SmallServiceEntity sml=new SmallServiceEntity(id, sst_name, big, sst_price, sst_remarks);
				list.add(sml);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//查询订单
	public ArrayList<Ordersenity> select(){
    	ArrayList<Ordersenity> list=new ArrayList<Ordersenity>();
		PreparedStatement stat=null;
		ResultSet row=null;
		String sql="select * from orders,sta_staffss,userinfo,SmallServiceTypes where orders.user_id=userinfo.us_id  and orders.sta_id=sta_staffss.S_id and orders.service_type=SmallServiceTypes.id";
    	try {	
		 stat = conn.conn.prepareStatement(sql); 
		 row = stat.executeQuery();
		 while(row.next()){
			 	int id=row.getInt("id");
			 	int out_id=row.getInt("out_id");
			 	System.out.println(out_id);
				int user_id=row.getInt("user_id");
			 	int service_type=row.getInt("service_type");
			 	int sta_id=row.getInt("sta_id");
			 	Double discount=row.getDouble("discount");
				String pay_type=row.getString("pay_type");
				String order_state=row.getString("order_state");
				String service_way=row.getString("service_way");
				String remark=row.getString("remark");
				
				UserInfoEntry ue=selectUser2(user_id);
				Sta_staffinfo st=selectSta2(sta_id);
			    BigServiceEntity gig=selSml2(service_type);
			    Ordersenity or=new Ordersenity(id,out_id, ue, st, gig, discount, pay_type, order_state, service_way, remark); 
			    list.add(or);
		 }
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return list;
    	
    }//查找出库Id
	private OutboundParts selectOut(int outId) {
		String sql="select * from outboundparts where o_outboundId=?";
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setInt(1,outId);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int o_Id=row.getInt("o_outboundId");
				OutboundParts ou=new OutboundParts(o_Id);
				return ou;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Ordersenity selectByid(int id2){
    	ArrayList<Ordersenity> list=new ArrayList<Ordersenity>();
		PreparedStatement stat=null;
		ResultSet row=null;
		String sql="select * from orders where id=?";
    	try {	
		 stat = conn.conn.prepareStatement(sql); 
		 stat.setInt(1, id2);
		 row = stat.executeQuery();
		 while(row.next()){
			 	int id=row.getInt("id");
				int user_id=row.getInt("user_id");
			 	int service_type=row.getInt("service_type");
			 	int sta_id=row.getInt("sta_id");
			 	Double discount=row.getDouble("discount");
				String pay_type=row.getString("pay_type");
				String order_state=row.getString("order_state");
				String service_way=row.getString("service_way");
				String remark=row.getString("remark");
				UserInfoEntry ue=selectUser2(user_id);
				Sta_staffinfo st=selectSta2(sta_id);
			    BigServiceEntity gig=selSml2(service_type);
			    Ordersenity or=new Ordersenity(id, ue, st, gig, discount, pay_type, order_state, service_way, remark);
			    return or;
		 }
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return null;
    	
    }//添加订单
	public int addOrder(Ordersenity or) {
		String sql="INSERT into orders(user_id,sta_id,service_type,discount,pay_type,order_state,service_way,remark) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setObject(1, or.getUs_id().getUs_id());
			stat.setObject(2, or.getSta_id().getSta_id());
			stat.setObject(3, or.getLst_id().getLst_id());
			stat.setObject(4, or.getDiscount());
			stat.setObject(5, or.getPay_type());
			stat.setObject(6, or.getOrder_state());
			stat.setObject(7, or.getService_way());
			stat.setObject(8, or.getRemark());
			int row=stat.executeUpdate();
			if(row>0){
				return row;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	//查询客户
	public UserInfoEntry selectUser(String userName) {
		//ArrayList<UserInfoEntry> list=new ArrayList<UserInfoEntry>();
		String sql="select * from userinfo where us_name=?"; 
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setString(1, userName);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int usid=row.getInt("us_id");
				String usname=row.getString("us_name");
				String ussex=row.getString("us_sex");
				String usidcate=row.getString("us_idcate");
				String usyears=row.getString("us_years");
				String usphone=row.getString("us_phone");
				String uspresent=row.getString("us_present");
				String usEmail=row.getString("us_Email");
				UserInfoEntry ue=new UserInfoEntry(usid, usname, ussex, usid, usidcate, usyears, usphone, uspresent, usEmail, usEmail);
				return ue;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}	//查询客户
	public UserInfoEntry selectUser2(int  id) {
		//ArrayList<UserInfoEntry> list=new ArrayList<UserInfoEntry>();
		String sql="select * from userinfo where us_id=?"; 
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int usid=row.getInt("us_id");
				String usname=row.getString("us_name");
				String ussex=row.getString("us_sex");
				String usidcate=row.getString("us_idcate");
				String usyears=row.getString("us_years");
				String usphone=row.getString("us_phone");
				String uspresent=row.getString("us_present");
				String usEmail=row.getString("us_Email");
				UserInfoEntry ue=new UserInfoEntry(usid, usname, ussex, usid, usidcate, usyears, usphone, uspresent, usEmail, usEmail);
				return ue;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}//查看接单员
	public Sta_staffinfo selectSta(String staName) {
		//ArrayList<StaffinfoEntry> list=new ArrayList<StaffinfoEntry>();
		String sql="select * from sta_staffss where S_name=?"; 
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setString(1, staName);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int sta_id=row.getInt("S_id");
				String sta_name=row.getString("S_name");
				Sta_staffinfo st=new Sta_staffinfo(sta_id, sta_name);
				return st;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//查看接单员
	public Sta_staffinfo selectSta2(int sta_id2) {
		//ArrayList<StaffinfoEntry> list=new ArrayList<StaffinfoEntry>();
		String sql="select * from sta_staffss where S_id=?"; 
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setInt(1, sta_id2);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int sta_id=row.getInt("S_id");
				String sta_name=row.getString("S_name");
				Sta_staffinfo st=new Sta_staffinfo(sta_id, sta_name);
				return st;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//查看服务通过名字
	public BigServiceEntity selSml(String userGrade) {
		//ArrayList<StaffinfoEntry> list=new ArrayList<StaffinfoEntry>();
		String sql="select * from largeservicetype where lst_name=?";

		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setString(1, userGrade);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int l_id=row.getInt("l_id");
				String lst_name=row.getString("lst_name");
				BigServiceEntity sm=new BigServiceEntity(l_id, lst_name);
				return sm;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}//查看服务通过id
	public BigServiceEntity selSml2(int userGrade) {
		//ArrayList<StaffinfoEntry> list=new ArrayList<StaffinfoEntry>();
		String sql="select * from largeservicetype where l_id=?";

		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setInt(1, userGrade);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int l_id=row.getInt("l_id");
				String lst_name=row.getString("lst_name");
				BigServiceEntity sm=new BigServiceEntity(l_id, lst_name);
				return sm;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//修改订单
	public int updateOrder(Ordersenity or) {
		PreparedStatement stat=null;
    	String sql="update orders  set user_id=?,sta_id=?,service_type=?,discount=?,pay_type=?,order_state=?,service_way=?,remark=? where id=?";
    	try {	
    		stat = conn.conn.prepareStatement(sql);
			stat.setObject(1, or.getUs_id().getUs_id());
			stat.setObject(2, or.getSta_id().getSta_id());
			stat.setObject(3, or.getLst_id().getLst_id());
			System.out.println(or.getLst_id().getLst_id());
			stat.setObject(4, or.getDiscount());
			stat.setObject(5, or.getPay_type());
			stat.setObject(6, or.getOrder_state());
			stat.setObject(7, or.getService_way());
			stat.setObject(8, or.getRemark());
			stat.setObject(9, or.getId());
			int row = stat.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}//删除订单
	public int delOrder(int id) {
		String sql="delete from orders where id=?";
    	try {
    	  PreparedStatement stat = conn.conn.prepareStatement(sql);
    	  stat.setObject(1, id);
		  int row = stat.executeUpdate();
		if(row>0){
			return row;
		}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return 0;
	}//查看员工信息
	public ArrayList<Sta_staffinfo> selectStaName() {
		ArrayList<Sta_staffinfo> list=new ArrayList<Sta_staffinfo>();
		String sql="select * from sta_staffss "; 
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int sta_id=row.getInt("S_id");
				String sta_name=row.getString("S_name");
				Sta_staffinfo st=new Sta_staffinfo(sta_id, sta_name);
				list.add(st);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Ordersenity selectOrd(int id) {
		String sql="select * from orders where id=? ";
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet row = stat.executeQuery();
			while(row.next()){
				int idstr=row.getInt("id");
				Ordersenity or=new Ordersenity(idstr);
				return or;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//派工，添加维修记录表
	public int record(Recordenity re) {
		DateTime ti=new DateTime();
		String sql="INSERT into MaintenanceRecord(o_id,S_id,Begin_time) VALUES(?,?,?);";
		try {
			PreparedStatement stat = conn.conn.prepareStatement(sql);
			stat.setObject(1,re.getO_id().getId());
			System.out.println(re.getO_id().getId());
			stat.setObject(2,re.getS_id().getSta_id());
			System.out.println(re.getS_id().getSta_id());
			stat.setObject(3,ti.getTime());
			System.out.println(ti.getTime());
			
			int row=stat.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public ArrayList<Ordersenity> select2(int page, int rows,String key) {
		ArrayList<Ordersenity> list=new ArrayList<Ordersenity>();
		String sql="select * from (select * from (SELECT	orders.id,orders.out_id,userinfo.us_id,userinfo.us_name,largeservicetype.l_id,largeservicetype.lst_name,orders.service_way,orders.discount,orders.pay_type,orders.order_state,sta_staffss.S_id,sta_staffss.S_name,orders.remark FROM orders,sta_staffss,userinfo,largeservicetype  WHERE orders.sta_id=sta_staffss.S_id and orders.user_id=userinfo.us_id and orders.service_type=largeservicetype.l_id) a where us_name like ? or S_name like ? or id like ?) b limit ?,?";
		try {
			 PreparedStatement stat = conn.conn.prepareStatement(sql);		
			 stat.setString(1, "%"+key+"%");
			 stat.setString(2, "%"+key+"%");
			 stat.setObject(3, "%"+key+"%");
			 stat.setInt(4,(page-1)*rows);
			 stat.setInt(5,rows);
			 ResultSet row = stat.executeQuery();
			 while(row.next()){
				    int id=row.getInt("id");
				 	int out_id=row.getInt("out_id");
				 	System.out.println(out_id);
					int user_id=row.getInt("us_id");
				 	int service_type=row.getInt("l_id");
				 	int sta_id=row.getInt("S_id");
				 	Double discount=row.getDouble("discount");
					String pay_type=row.getString("pay_type");
					String order_state=row.getString("order_state");
					String service_way=row.getString("service_way");
					String remark=row.getString("remark");
					
					UserInfoEntry ue=selectUser2(user_id);
					Sta_staffinfo st=selectSta2(sta_id);
				    BigServiceEntity gig=selSml2(service_type);
				    Ordersenity or=new Ordersenity(id,out_id, ue, st, gig, discount, pay_type, order_state, service_way, remark); 
				    list.add(or);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int selectCount(String key) {
		PreparedStatement stat=null;
		ResultSet row=null;
    	String sql="select count(1) from  orders ";
    	try {
		 stat = conn.conn.prepareStatement(sql);
		
		 row = stat.executeQuery();
		 while(row.next()){
		   return row.getInt(1);
		 }
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return 0;
	}
	
		
}
