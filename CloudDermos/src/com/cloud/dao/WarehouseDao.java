package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.QuerytheWarehouseEntity;
import com.cloud.util.Conn;
import com.mysql.jdbc.Statement;
/*
 * 
 * */
public class WarehouseDao {
	Conn c = new Conn(); //创建连接数据库的对象
	public List<QuerytheWarehouseEntity> selectQuerytheWarehouseById(int id){
		List<QuerytheWarehouseEntity> list = new ArrayList<QuerytheWarehouseEntity>();
		String sql = "select * from querythewarehouse where q_id = ? and  q_noFollow=1";
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		try {
			 ps = c.conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 rs=ps.executeQuery();
			 while(rs.next()){
				int q_id =rs.getInt("q_id");
				String q_vehicleBrand = rs.getString("q_vehicleBrand");
				String q_partsImg = rs.getString("q_partsImg");
				String q_partsName = rs.getString("q_partsName");
				String q_partBrand = rs.getString("q_partBrand");
				int q_number =rs.getInt("q_number");
				String q_unit = rs.getString("q_unit");
				String q_partType = rs.getString("q_partType");
				String q_partEffect = rs.getString("q_partEffect");
				double q_buyingRate = rs.getDouble("q_buyingRate");
				double q_sellingPrice = rs.getDouble("q_sellingPrice");
				QuerytheWarehouseEntity QWE = new QuerytheWarehouseEntity(q_id, q_vehicleBrand, q_partsImg, q_partsName, q_partBrand, q_number, q_unit, q_partType, q_partEffect, q_buyingRate, q_sellingPrice);
				list.add(QWE);
			 }
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
		
	}
	//incomingParts表的最后主键ID值
	public int incomingPartsIdDESC(){ 
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		String sql = "SELECT i_partsId FROM incomingParts order by i_partsId DESC limit 1";
		 try {
			ps = c.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ID = Integer.parseInt(rs.getString("i_partsId"));
				return ++ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
	}
	
	
	
	 //incomingPartsInfo表最大主键ID
	public int incomingPartsInfoIdDESC(){
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		String sql = "SELECT i_partsId FROM incomingpartsinfo order by i_partsId DESC limit 1";
		 try {
			ps = c.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ID = Integer.parseInt(rs.getString("i_partsId"));
				return ++ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
	}
	// 如何将不同的数据添加到不同的表中
	public boolean BeOutInStorage(int q_id,String i_title,
			String i_time,String i_personnel,int i_number,
			double i_totalPrice,int incomingPartsID,
			int incomingPartsInfoId) throws SQLException{
		c.conn.setAutoCommit(false); //关闭自动提交	
		//添加incomingParts信息
		String sql1 ="INSERT INTO `couldcar`.`incomingparts` (`i_partsId`, `i_title`, `i_time`, `i_personnel`) VALUES (?, ?,?,?)";
		//添加incomingPartsInfo信息
		String sql2 ="INSERT INTO `couldcar`.`incomingpartsinfo` (`i_partsId`, `i_incomingPartsId`, `i_querytheWarehouseId`, `i_number`, `i_totalPrice`) VALUES (?,?,?,?,?)";
		//入库成功后，配件数量应增加。所以要修改ID配件的数量
		String sql3=" UPDATE `couldcar`.`querythewarehouse` SET `q_number`=`q_number`+? WHERE (`q_id`=?);";
		PreparedStatement ps1=c.conn.prepareStatement(sql1);//预编译语句1
		ps1.setObject(1, incomingPartsID);
		ps1.setObject(2, i_title);
		ps1.setObject(3, i_time);
		ps1.setObject(4, i_personnel);
		int row1 = ps1.executeUpdate();//返回sql1受影响行数
		PreparedStatement ps2=c.conn.prepareStatement(sql2);//预编译语句2
		ps2.setObject(1,incomingPartsInfoId);
		ps2.setObject(2,incomingPartsID);
		ps2.setObject(3,q_id);
		ps2.setObject(4,i_number);
		ps2.setObject(5, i_totalPrice);
		int row2 = ps2.executeUpdate();//返回sql2受影响行数
		PreparedStatement ps3=c.conn.prepareStatement(sql3);//预编译语句3
		ps3.setObject(1,i_number);
		ps3.setObject(2,q_id);
		int row3 = ps3.executeUpdate();//返回sql3受影响行数
		if(row1>0&&row2>0&&row3>0){
			c.conn.commit();//事物提交
			ps1.close();
			ps2.close();
			ps3.cancel();
			return true;
		}
	
		
		return false;
	} 
	
	
	
	
	public QuerytheWarehouseEntity selectQuerytheWarehouseByIdObject(int id){
		List<QuerytheWarehouseEntity> list = new ArrayList<QuerytheWarehouseEntity>();
		String sql = "select * from querythewarehouse where q_id = ? and  q_noFollow=1";
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		try {
			
			 ps = c.conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 rs=ps.executeQuery();
			 while(rs.next()){
				int q_Id =rs.getInt("q_id");
				String q_VehicleBrand = rs.getString("q_vehicleBrand");
				String q_PartsImg = rs.getString("q_partsImg");
				String q_PartsName = rs.getString("q_partsName");
				String q_PartBrand = rs.getString("q_partBrand");
				int q_Number =rs.getInt("q_number");
				String q_Unit = rs.getString("q_partType");
				String q_PartType = rs.getString("q_partType");
				String q_PartEffect = rs.getString("q_buyingRate");
				double q_BuyingRate = rs.getDouble("q_buyingRate");
				double q_SellingPrice = rs.getDouble("q_sellingPrice");
				QuerytheWarehouseEntity QWE = new QuerytheWarehouseEntity( q_Id,q_VehicleBrand, q_PartsImg,
						q_PartsName,q_PartBrand,q_Number, q_Unit,
						 q_PartType,q_PartEffect,q_BuyingRate,
						 q_SellingPrice); 	
				return QWE;
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
		
	}
	// outboundParts表中最大ID值
	public int outboundPartsMaxId(){
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		String sql = "SELECT o_outboundId FROM `outboundParts` order by o_outboundId DESC limit 1";
		 try {
			ps = c.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ID = Integer.parseInt(rs.getString("o_outboundId"));
				return ++ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
	}
	// outboundPartsInfo最大ID
	public int outboundPartsInfoMaxId(){
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		String sql = "SELECT o_ouId FROM `outboundpartsinfo` order by o_ouId DESC limit 1";
		 try {
			ps = c.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ID = Integer.parseInt(rs.getString("o_ouId"));
				return ++ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
	}

	//获取配件数量
	public int partNumber(int id){ 
		String sql = "select q_number FROM querythewarehouse where q_id=?";
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		 try {
			ps = c.conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				int partNumber = Integer.parseInt(rs.getString("q_number"));
				return partNumber;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}
	
	
	public boolean putOutStorage(int q_id,String o_title,String o_time,String o_cause,
			String o_personnel,String o_manager,int o_number,double o_totalPrice,
			int outboundPartsMaxId,int outboundPartsInfoMaxId) throws SQLException{
		System.out.println("进入出库JDBC");
		c.conn.setAutoCommit(false); //关闭自动提交	
		String sql1="INSERT INTO `couldcar`.`outboundparts` (`o_outboundId`, `o_title`, `o_time`, `o_cause`, `o_personnel`, `o_manager`) VALUES (?,?,?,?,?,?)";
		String sql2 ="INSERT INTO `couldcar`.`outboundpartsinfo` (`o_ouId`, `o_partsId2`, `o_querytheWarehouseId2`, `o_number`, `o_totalPrice`) VALUES (?,?,?,?,?)";
		String sql3=" UPDATE `couldcar`.`querythewarehouse` SET `q_number`=`q_number`-? WHERE (`q_id`=?)";
		try {
			PreparedStatement ps1 = c.conn.prepareStatement(sql1);
			ps1.setObject(1,outboundPartsMaxId);
			ps1.setObject(2, o_title);
			ps1.setObject(3, o_time);
			ps1.setObject(4, o_cause);
			ps1.setObject(5, o_personnel);
			ps1.setObject(6, o_manager);
			int row1 = ps1.executeUpdate();
			PreparedStatement ps2 = c.conn.prepareStatement(sql2);
			ps2.setObject(1, outboundPartsInfoMaxId);
			ps2.setObject(2, outboundPartsMaxId);
			ps2.setObject(3, q_id);
			ps2.setObject(4, o_number);
			ps2.setObject(5, o_totalPrice);
			int row2 = ps2.executeUpdate();
			PreparedStatement ps3 = c.conn.prepareStatement(sql3);
			ps3.setObject(1, o_number);
			ps3.setObject(2,q_id);
			int row3 = ps3.executeUpdate();
			if(row1>0&&row2>0&&row3>0){
				c.conn.commit();//事物提交
				ps1.close();
				ps2.close();
				ps3.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	// querytheWarehouse最大ID
	public int QuerytheWarehouseMaxId(){
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		String sql = "SELECT q_id FROM `querytheWarehouse` order by q_id DESC limit 1";
		 try {
			ps = c.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int ID = Integer.parseInt(rs.getString("q_id"));
				return ++ID;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 1;
		
	}
	
}
