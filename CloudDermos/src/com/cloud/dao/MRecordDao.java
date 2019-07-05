package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cloud.entity.MRecordEntity;
import com.cloud.entity.Ordersenity;
import com.cloud.entity.Sta_staffinfo;
import com.cloud.util.Conn;

public class MRecordDao {
	//创建连接
	Conn c = new Conn();
	//创建OrderDao对象
	OrdersDao odao = new OrdersDao();
	//创建员工dao对象
	AdminDao adao = new AdminDao();
	//查询维修记录
	public List<MRecordEntity> selectRecord(String key, int page, int rows) {
		String sql = "select * from (select * from maintenancerecord where id like ?) a limit ?,?";
		List<MRecordEntity> mlist = new ArrayList<MRecordEntity>();
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, "%"+key+"%");
			ps.setObject(2, (page-1)*rows);
			ps.setObject(3, rows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int mId = rs.getInt("id");
				int odId = rs.getInt("o_id");//订单id
				Ordersenity oe = odao.selectByid(odId);
				Date begin = rs.getDate("Begin_time");
				Date end = rs.getDate("end_time");
				int sid = rs.getInt("S_id");//员工id
				Sta_staffinfo st = adao.aaselectstaff(sid);
				//查询订单信息装入实体
				MRecordEntity mre = new MRecordEntity(mId, oe, begin, end, st);
				mlist.add(mre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}
	public int selectRecordAll() {
		String sql = "select count(*) from MaintenanceRecord";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int count = rs.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public MRecordEntity selectRecordById(int id) {
		String sql = "select * from MaintenanceRecord where id=?";
		try {
			PreparedStatement ps = c.conn.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int mId = rs.getInt("id");
				int odId = rs.getInt("o_id");//订单id
				Ordersenity oe = odao.selectByid(odId);
				Date begin = rs.getDate("Begin_time ");
				Date end = rs.getDate("Begin_time ");
				int sid = rs.getInt("S_id");//员工id
				Sta_staffinfo st = adao.aaselectstaff(sid);
				//查询订单信息装入实体
				MRecordEntity mre = new MRecordEntity(mId, oe, begin, end, st);
				return mre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
