package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.BigServiceEntity;
import com.cloud.entity.SmallServiceEntity;
import com.cloud.util.Conn;

//服务（小）Dao
public class SmallServiceDao {
	//创建数据库连接对象
	Conn c = new Conn();
	//查询
	public List<SmallServiceEntity> selectSmall(String key, int page, int rows) {
		String sql = "select * from (select * from SmallServiceTypes where sst_name like ?) a limit ?,?";
		List<SmallServiceEntity> sslist = new ArrayList<SmallServiceEntity>();
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			if(key==null){
				key="";
			}
			//为？赋值
			ps.setObject(1, '%'+key+'%');
			ps.setObject(2, (page-1)*rows);
			ps.setObject(3, rows);
			ResultSet rs = ps.executeQuery();
			//遍历数据库中获取的值ֵ
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("sst_name");
				int lstId = rs.getInt("lst_id");
				BigServiceDao bdao = new BigServiceDao();
				BigServiceEntity bse = bdao.selectBigById(lstId);
				Double price = rs.getDouble("sst_price");
				String remarks = rs.getString("sst_remarks");
				//ֵ将值装入SmallServiceEntity实体中
				SmallServiceEntity sse = new SmallServiceEntity(id, name, bse, price, remarks);
				//将实体添加到集合
				sslist.add(sse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sslist;
	}
	public int addSmall(SmallServiceEntity sse) {
		String sql = "insert into SmallServiceTypes(sst_name,lst_id,sst_price,sst_remarks) values(?,?,?,?)";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, sse.getSst_name());
			ps.setObject(2, sse.getBse().getLst_id());
			ps.setObject(3, sse.getSst_price());
			ps.setObject(4, sse.getSst_remarks());
			int row = ps.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateSmall(SmallServiceEntity sse) {
		String sql = "update SmallServiceTypes set sst_name=?,lst_id=?,sst_price=?,sst_remarks=? where id=?";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, sse.getSst_name());
			ps.setObject(2, sse.getBse().getLst_id());
			ps.setObject(3, sse.getSst_price());
			ps.setObject(4, sse.getSst_remarks());
			ps.setObject(5, sse.getSst_id());
			int row = ps.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteSmall(int id) {
		String sql = "delete from SmallServiceTypes where id=?";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, id);
			int row = ps.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int selectAll(String key) {
		String sql = "select count(*) from SmallServiceTypes";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int row = rs.getInt(1);
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<SmallServiceEntity> selectSmallAll() {
		String sql = "select * from SmallServiceTypes";
		List<SmallServiceEntity> sslist = new ArrayList<SmallServiceEntity>();
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//遍历数据库中获取的值ֵ
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("sst_name");
				int lstId = rs.getInt("lst_id");
				BigServiceDao bdao = new BigServiceDao();
				BigServiceEntity bse = bdao.selectBigById(lstId);
				Double price = rs.getDouble("sst_price");
				String remarks = rs.getString("sst_remarks");
				//ֵ将值装入SmallServiceEntity实体中
				SmallServiceEntity sse = new SmallServiceEntity(id, name, bse, price, remarks);
				//将实体添加到集合
				sslist.add(sse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
