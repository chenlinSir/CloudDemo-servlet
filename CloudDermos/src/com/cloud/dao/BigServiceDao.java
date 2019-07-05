package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.BigServiceEntity;
import com.cloud.util.Conn;

//服务类型dao
public class BigServiceDao {
	Conn c = new Conn();
	public List<BigServiceEntity> selectBig() {//查询
		//创建list
		List<BigServiceEntity> blist = new ArrayList<BigServiceEntity>();
		String sql = "select * from LargeServiceType";
		try {
			PreparedStatement sta = c.conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while(rs.next()){
				int id = rs.getInt("l_id");
				String s_name = rs.getString("lst_name");
				BigServiceEntity bse = new BigServiceEntity(id,s_name);
				//将实体装入list
				blist.add(bse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回list
		return blist;
	}

	public int addBig(String name) {//添加
		String sql = "insert into LargeServiceType(lst_name) values(?)";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, name);
			int row = ps.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updataBig(BigServiceEntity bse) {//修改
		String sql = "update LargeServiceType set lst_name=? where l_id=?";
		try {
			System.out.println("dao:::"+bse.getLst_name());
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, bse.getLst_name());
			ps.setObject(2, bse.getLst_id());
			int row = ps.executeUpdate();
			if(row>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteBig(int id) {//删除
		String sql = "delete from LargeServiceType where l_id=?";
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

	public BigServiceEntity selectBigById(int id) {
		String sql = "select * from LargeServiceType where l_id=?";
		try {
			PreparedStatement sta = c.conn.prepareStatement(sql);
			sta.setObject(1, id);
			ResultSet rs = sta.executeQuery();
			if(rs.next()){
				int l_id = rs.getInt("l_id");
				String s_name = rs.getString("lst_name");
				BigServiceEntity bse = new BigServiceEntity(l_id,s_name);
				return bse;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
