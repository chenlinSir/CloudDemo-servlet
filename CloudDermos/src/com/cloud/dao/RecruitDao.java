package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.BranchEntry;
import com.cloud.entity.PostInfoEntry;
import com.cloud.entity.RecruitEntry;
import com.cloud.util.Conn;

public class RecruitDao {
	//查询招聘信息
	public List<RecruitEntry> SelectRecruit(int h,int y){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<RecruitEntry> list=new ArrayList<RecruitEntry>();
		//编写sql语句
		String sql="select * from recruit,postinfo,branch WHERE branch.b_id=recruit.b_id and postinfo.post_id=recruit.post_id limit ?,? ;";
			 try {
				ps = conn.conn.prepareStatement(sql);
				
				ps.setObject(1, (y-1)*h);
				ps.setObject(2, h);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int reId=rs.getInt("reId");
					String post_name=rs.getString("post_name");
					String p_remark=rs.getString("p_remark");
					String start_time=rs.getString("start_time");
					String end_time=rs.getString("end_time");
					int sum=rs.getInt("sum");
					String b_name=rs.getString("b_name");
					RecruitEntry zhi=new RecruitEntry(reId,post_name,p_remark,start_time,end_time,sum,b_name);
					list.add(zhi);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	
	//添加招聘信息
	
	public int addRecruit(int postId, String startTime, String endTime, int sum,
			int bId){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="INSERT INTO recruit(post_id,start_time,end_time,sum,b_id) VALUES (?,?,?,?,?)";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setInt(1, postId);
			ps.setString(2, startTime);
			ps.setString(3, endTime);
			ps.setInt(4, sum);
			ps.setInt(5, bId);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	
	//删除招聘信息
	public int deletRecruit(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句delete  from sta_staffss where S_id=?
		String sql="delete  from recruit where reId=?";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setInt(1, id);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	//修改招聘信息
	public int updatebranch(int post_id,String start_time,String end_time ,int sum,int b_id, int reId){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update recruit set post_id=?,start_time=?,end_time=?,sum=?,b_id=? where reId=?";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setInt(1, post_id);
			ps.setString(2, start_time);
			ps.setString(3, end_time);
			ps.setInt(4, sum);
			ps.setInt(5, b_id);
			ps.setInt(6, reId);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	
	
	//部门的查询
	public ArrayList<BranchEntry> selectpost(){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<BranchEntry> list=new ArrayList<BranchEntry>();
		//编写sql语句
		String sql="select * from branch;";
			 try {
				ps = conn.conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				while(rs.next()){
					int b_id=rs.getInt("b_id");
					String bName=rs.getString("b_name");
					String bremark=rs.getString("b_remark");
					BranchEntry bh=new BranchEntry(b_id, bName,bremark);
					list.add(bh);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	//根据id查职位
	public List<BranchEntry> selectpost(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BranchEntry> list=new ArrayList<BranchEntry>();
		//编写sql语句
	String sql="select * from postinfo WHERE post_id=? ;";
			 try {
				ps = conn.conn.prepareStatement(sql);
				
				ps.setObject(1, id);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int Id=rs.getInt("post_id");
					String bName=rs.getString("post_name");
					String bremark=null;
					BranchEntry bh=new BranchEntry(Id, bName,bremark);
					list.add(bh);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	
	
}
