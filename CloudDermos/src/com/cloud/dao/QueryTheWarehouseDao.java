package com.cloud.dao;
/*
 * querythewarehouse表 （配件信息表）
 * */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.QuerytheWarehouseEntity;
import com.cloud.util.Conn;

public class QueryTheWarehouseDao {
	Conn c = new Conn(); //创建连接数据库的对象
	/*
	 * 查询QuerytheWarehouse表的实体
	 * */
	public List<QuerytheWarehouseEntity> selectQuerytheWarehouse(){
		List<QuerytheWarehouseEntity> list = new ArrayList<QuerytheWarehouseEntity>();
		String sql = "select * from querythewarehouse where q_noFollow=1"; //查询显示的配件
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		try {
			 ps = c.conn.prepareStatement(sql);
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
	/*
	 * 通过id查询配件
	 * */
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
				String q_unit = rs.getString("q_partType");
				String q_partType = rs.getString("q_partType");
				String q_partEffect = rs.getString("q_buyingRate");
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
	/*
	 * 通过零件名称查询
	 * */
	public List<QuerytheWarehouseEntity> selectQuerytheWarehouseByPartName(String name){
		List<QuerytheWarehouseEntity> list = new ArrayList<QuerytheWarehouseEntity>();
		String sql = "select * from querythewarehouse where q_noFollow=1  HAVING q_partsName like '%"+name+"%';"; //注意点
		PreparedStatement ps=null;//预编译语句		
		ResultSet rs=null;//结果集
		try {
			
			 ps = c.conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 while(rs.next()){
				int q_id =rs.getInt("q_id");
				String q_vehicleBrand = rs.getString("q_vehicleBrand");
				String q_partsImg = rs.getString("q_partsImg");
				String q_partsName = rs.getString("q_partsName");
				String q_partBrand = rs.getString("q_partBrand");
				int q_number =rs.getInt("q_number");
				String q_unit = rs.getString("q_partType");
				String q_partType = rs.getString("q_partType");
				String q_partEffect = rs.getString("q_buyingRate");
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
	//通过ID 逻辑删除配件
	public int deleteQuerytheWarehouseById(int id){
		String sql = "update querythewarehouse set q_noFollow=2 where q_id =?";
		PreparedStatement ps=null;//预编译语句
		ResultSet rs=null;//结果集
		try {
			
			 ps = c.conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 int row =ps.executeUpdate();
			 if(row>0){
				 return row; 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return 0;
		
	}
	// 像这个表插入数据
	public boolean InsertQuerytheWarehouse(QuerytheWarehouseEntity QWE){
		PreparedStatement ps=null;//预编译语句
		String sql ="INSERT INTO `couldcar`.`querythewarehouse` (`q_id`, `q_vehicleBrand`, `q_partsImg`, `q_partsName`, `q_partBrand`, `q_number`, `q_unit`, `q_partType`, `q_partEffect`, `q_buyingRate`, `q_sellingPrice`,`q_noFollow`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; 
		try {
			ps = c.conn.prepareStatement(sql);
			ps.setObject(1,QWE.getQ_id() );
			ps.setObject(2,QWE.getQ_vehicleBrand() );
			ps.setObject(3, QWE.getQ_partsImg());
			ps.setObject(4,QWE.getQ_partsName());
			ps.setObject(5,QWE.getQ_partBrand());
			ps.setObject(6,QWE.getQ_number());
			ps.setObject(7, QWE.getQ_unit());
			ps.setObject(8,QWE.getQ_partType());
			ps.setObject(9,QWE.getQ_partEffect());
			ps.setObject(10, QWE.getQ_buyingRate());
			ps.setObject(11, QWE.getQ_sellingPrice());
			ps.setObject(12,QWE.getQ_noFollow());
			int row = ps.executeUpdate();
			if(row>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
