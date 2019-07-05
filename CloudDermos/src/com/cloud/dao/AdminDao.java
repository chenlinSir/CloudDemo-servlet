package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.BranchEntry;
import com.cloud.entity.PostInfoEntry;
import com.cloud.entity.Sta_staffinfo;
import com.cloud.util.Conn;

public class AdminDao {

	//部门的查询
	public List<BranchEntry> selectbranch(int h,int y,String key){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BranchEntry> list=new ArrayList<BranchEntry>();
		//编写sql语句
	String sql="select * from (select * from branch WHERE b_usable=1 and b_name LIKE ?)a limit ?,? ;";
			 try {
				ps = conn.conn.prepareStatement(sql);
				
				ps.setObject(1, "%"+key+"%");
				ps.setObject(2, (y-1)*h);
				ps.setObject(3, h);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int Id=rs.getInt("b_id");
					String bName=rs.getString("b_name");
					String bremark=rs.getString("b_remark");
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
	
	//部门条数查询
	public int selectbranchtiao(String key){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="select COUNT(*) FROM branch where b_usable=? and b_name like ?";
		int i=0;
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setInt(1, 1);
				ps.setString(2,"%"+key+"%" );
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					i=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return i;
	}
	
	//部门的添加
	public int addbranch(String name,String remark){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="insert into branch(b_name,b_remark,b_usable) values(?,?,DEFAULT)";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, remark);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	//部门的删除
	public int deletebranch(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update branch set b_usable=0  where b_id=?";
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
	
	//部门的修改
	public int updatebranch(String name,String remark,int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update branch set b_name=?,b_remark=? where b_id=?";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, remark);
			ps.setInt(3, id);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	//全部部门的查询
	public List<BranchEntry> selectbranchs(){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="select * FROM branch where b_usable=1";
		List<BranchEntry> list=new ArrayList<BranchEntry>();
			 try {
				ps = conn.conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int Id=rs.getInt("b_id");
					String bName=rs.getString("b_name");
					String bremark=rs.getString("b_remark");
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
	
	//------------------------------------------------------------------------------------
	//职位
	//-------------------------------------------------------------------------------------
	//职位的查询
	public List<PostInfoEntry> selectpost(int h,int y,String key){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<PostInfoEntry> list=new ArrayList<PostInfoEntry>();
		//编写sql语句
		String sql="select * from (select * from postinfo,branch WHERE  postinfo.p_bId=branch.b_id and p_usable=1 and b_name LIKE ? and post_name LIKE ?)a limit ?,? ;";
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setObject(1, "%"+key+"%");
				ps.setObject(2, "%"+key+"%");
				ps.setObject(3, (y-1)*h);
				ps.setObject(4, h);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int post_id=rs.getInt("post_id");
					int b_id=rs.getInt("b_id");
					String post_name=rs.getString("post_name");
					String bName=rs.getString("b_name");
					String bremark=rs.getString("b_remark");
					String p_remark=rs.getString("p_remark");
					BranchEntry bh=new BranchEntry(b_id, bName,bremark);
					PostInfoEntry ph=new PostInfoEntry(post_id, post_name, bh, p_remark);
					list.add(ph);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	
	//职位条数查询
	public int selectposttiao(String key){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="select COUNT(*) FROM postinfo,branch where postinfo.p_bId=branch.b_id and p_usable=1 and post_name like ? and b_name LIKE ?";
		int i=0;
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setString(1,"%"+key+"%" );
				ps.setString(2,"%"+key+"%" );
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					i=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return i;
	}
	
	//职位的添加
	public int addpost(String name,int id,String remark){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="insert into postinfo(post_name,p_bid,p_remark,p_usable) values(?,?,?,DEFAULT)";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.setString(3, remark);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	//职位的删除
	public int deletepost(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update postinfo set p_usable=0 where post_id=?";
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
	
	//职位的修改
	public int updatepost(String name,String remark,int bid,int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update postinfo set post_name=?,p_bid=?,p_remark=? where post_id=?";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, bid);
			ps.setString(3, remark);
			ps.setInt(4, id);
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	
	//全部职位的查询
	public List<PostInfoEntry> selectpostss(){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="select * FROM postinfo where p_usable=1";
		List<PostInfoEntry> list=new ArrayList<PostInfoEntry>();
			 try {
				ps = conn.conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int post_id=rs.getInt("post_id");
					String post_name=rs.getString("post_name");
					String p_remark=rs.getString("p_remark");
					PostInfoEntry ph=new PostInfoEntry(post_id, post_name, p_remark);

					list.add(ph);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	
	//全部职位的查询
	public List<PostInfoEntry> selectposts(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="select * FROM postinfo where p_usable=1 and p_bId=?";
		List<PostInfoEntry> list=new ArrayList<PostInfoEntry>();
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					int post_id=rs.getInt("post_id");
					String post_name=rs.getString("post_name");
					String p_remark=rs.getString("p_remark");
					PostInfoEntry ph=new PostInfoEntry(post_id, post_name, p_remark);

					list.add(ph);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	
//===========================================以下是员工块=====================================================================	
	//员工的查询
	public List<Sta_staffinfo> selectstaff(int h,int y,String key){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Sta_staffinfo> list=new ArrayList<Sta_staffinfo>();
		//编写sql语句
		String sql="SELECT *from(SELECT * FROM(select * from sta_staffss,postinfo,branch WHERE sta_staffss.S_postss=postinfo.post_id and postinfo.p_bId=branch.b_id) a WHERE  S_name LIKE ? or b_name LIKE ? or post_name LIKE ?)b limit ?,? ";
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setObject(1, "%"+key+"%");
				ps.setObject(2, "%"+key+"%");
				ps.setObject(3, "%"+key+"%");
				ps.setObject(4, (y-1)*h);
				ps.setObject(5, h);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
						//部门
					int b_id=rs.getInt("b_id");
					String bName=rs.getString("b_name");
					String bremark=rs.getString("b_remark");
						//职位
					int post_id=rs.getInt("post_id");
					String post_name=rs.getString("post_name");
					int p_bid=rs.getInt("p_bid");
					String p_remark=rs.getString("p_remark");
						//员工
					int S_id=rs.getInt("S_id");
					String S_name=rs.getString("S_name");
					String S_sex=rs.getString("S_sex");
					String S_birthday=rs.getString("S_birthday");
					String S_phone=rs.getString("S_phone");
					String S_logname=rs.getString("S_logname");
					String S_pwdss=rs.getString("S_pwdss");
					String S_entrytime=rs.getString("S_entrytime");
					String S_postss=rs.getString("S_postss");
					String S_present=rs.getString("S_present");
					String S_natio=rs.getString("S_natio");
					String S_place=rs.getString("S_place");
					String S_blood=rs.getString("S_blood");
					String S_idcate=rs.getString("S_idcate");
					String S_marital=rs.getString("S_marital");
					String S_politics=rs.getString("S_politics");
					String S_maxeducation=rs.getString("S_maxeducation");
					String S_maxdegree=rs.getString("S_maxdegree");
					String S_Email=rs.getString("S_Email");
					String S_emIP=rs.getString("S_emIP");
					String S_Englist=rs.getString("S_Englist");
					String S_computer=rs.getString("S_computer");
					String S_img=rs.getString("S_img");
					
					BranchEntry bh=new BranchEntry(b_id, bName,bremark);
					PostInfoEntry ph=new PostInfoEntry(post_id, post_name, bh, p_remark);
					Sta_staffinfo sa= new Sta_staffinfo(S_id, S_name, S_sex, S_birthday, S_phone, S_logname, S_pwdss, S_entrytime, ph, S_present, S_natio, S_place, S_blood, S_idcate, S_marital, S_politics, S_maxeducation, S_maxdegree, S_Email, S_emIP, S_Englist, S_computer, S_img);
					list.add(sa);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	//单个员工的查询
	public Sta_staffinfo aaselectstaff(int h){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Sta_staffinfo list=new Sta_staffinfo();
		//编写sql语句
		String sql="select * from  sta_staffss,postinfo,branch WHERE sta_staffss.S_postss=postinfo.post_id and S_id=?";
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setObject(1, h);
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
						//部门
					int post_id=rs.getInt("post_id");		String post_name=rs.getString("post_name");
					int p_bid=rs.getInt("p_bid");	String p_remark=rs.getString("p_remark");
						//员工
					int S_id=rs.getInt("S_id");
					String S_name=rs.getString("S_name");
					String S_sex=rs.getString("S_sex");
					String S_birthday=rs.getString("S_birthday");
					String S_phone=rs.getString("S_phone");
					String S_logname=rs.getString("S_logname");
					String S_pwdss=rs.getString("S_pwdss");
					String S_entrytime=rs.getString("S_entrytime");
					String S_postss=rs.getString("S_postss");
					String S_present=rs.getString("S_present");
					String S_natio=rs.getString("S_natio");
					String S_place=rs.getString("S_place");
					String S_blood=rs.getString("S_blood");
					String S_idcate=rs.getString("S_idcate");
					String S_marital=rs.getString("S_marital");
					String S_politics=rs.getString("S_politics");
					String S_maxeducation=rs.getString("S_maxeducation");
					String S_maxdegree=rs.getString("S_maxdegree");
					String S_Email=rs.getString("S_Email");
					String S_emIP=rs.getString("S_emIP");
					String S_Englist=rs.getString("S_Englist");
					String S_computer=rs.getString("S_computer");
					String S_img=rs.getString("S_img");
					
					BranchEntry bh=new BranchEntry();
					PostInfoEntry ph=new PostInfoEntry(post_id, post_name, bh, p_remark);
					list= new Sta_staffinfo(S_id, S_name, S_sex, S_birthday, S_phone, S_logname, S_pwdss, S_entrytime, ph, S_present, S_natio, S_place, S_blood, S_idcate, S_marital, S_politics, S_maxeducation, S_maxdegree, S_Email, S_emIP, S_Englist, S_computer, S_img);
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return list;
	}
	//员工条数查询
	public int selectstafftiao(String key){
		System.out.println(key);
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="SELECT  COUNT(*) FROM(SELECT *from sta_staffss,postinfo,branch where sta_staffss.S_postss=postinfo.post_id and postinfo.p_bId=branch.b_id) a WHERE S_name LIKE ? or b_name LIKE ? or post_name LIKE ?";
		int i=0;
			 try {
				ps = conn.conn.prepareStatement(sql);
				ps.setString(1,"%"+key+"%" );
				ps.setString(2,"%"+key+"%" );
				ps.setString(3,"%"+key+"%" );
				rs = ps.executeQuery();
				while(rs.next()){
					//通过查询来统计是否有这个用户的条数
					i=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.colse(ps, rs);
			}
		return i;
	}
	//员工的删除
	public int deletestaffinfo(int id){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="delete  from sta_staffss where S_id=?";
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
	//员工的添加
	public int addStaff(Sta_staffinfo sa,int pid){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="INSERT into sta_staffss(S_name,S_sex,S_birthday,S_phone,S_logname,S_pwdss,S_entrytime,S_postss,S_present," +
				"S_natio,S_place,S_blood,S_idcate,S_marital,S_politics,S_maxeducation," +
				"S_maxdegree,S_Email,S_emIP,S_Englist,S_computer,S_img) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, sa.getSta_name());
			ps.setString(2, sa.getSta_sex());
			ps.setString(3, sa.getSta_birthday());
			ps.setString(4, sa.getSta_phone());
			ps.setString(5, sa.getSta_login());
			ps.setString(6, sa.getSta_pwd());
			ps.setString(7, sa.getSta_entrytime());
			ps.setInt(8, pid);
			ps.setString(9, sa.getSta_present());
			ps.setString(10, sa.getS_natio());
			ps.setString(11, sa.getS_place());
			ps.setString(12, sa.getS_blood());
			ps.setString(13, sa.getS_idcate());
			ps.setString(14, sa.getS_marital());
			ps.setString(15, sa.getS_politics());
			ps.setString(16, sa.getS_maxeducation());
			ps.setString(17, sa.getS_maxdegree());
			ps.setString(18, sa.getS_Email());
			ps.setString(19, sa.getS_emIP());
			ps.setString(20, sa.getS_Englist());
			ps.setString(21, sa.getS_computer());
			ps.setString(22, sa.getS_img());
			
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	//员工修改
	public int updateStaff(Sta_staffinfo sa,int pid){
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql语句
		String sql="update sta_staffss set S_name=?,S_sex=?,S_birthday=?,S_phone=?,S_logname=?,S_pwdss=?,S_entrytime=?,S_postss=?,S_present=?," +
				"S_natio=?,S_place=?,S_blood=?,S_idcate=?,S_marital=?,S_politics=?,S_maxeducation=?," +
				"S_maxdegree=?,S_Email=?,S_emIP=?,S_Englist=?,S_computer=?,S_img=? where S_id=?";
		try {
			//调用SQL语句
			ps=conn.conn.prepareStatement(sql);
			
			ps.setString(1, sa.getSta_name());
			ps.setString(2, sa.getSta_sex());
			ps.setString(3, sa.getSta_birthday());
			ps.setString(4, sa.getSta_phone());
			ps.setString(5, sa.getSta_login());
			ps.setString(6, sa.getSta_pwd());
			ps.setString(7, sa.getSta_entrytime());
			ps.setInt(8, pid);
			ps.setString(9, sa.getSta_present());
			ps.setString(10, sa.getS_natio());
			ps.setString(11, sa.getS_place());
			ps.setString(12, sa.getS_blood());
			ps.setString(13, sa.getS_idcate());
			ps.setString(14, sa.getS_marital());
			ps.setString(15, sa.getS_politics());
			ps.setString(16, sa.getS_maxeducation());
			ps.setString(17, sa.getS_maxdegree());
			ps.setString(18, sa.getS_Email());
			ps.setString(19, sa.getS_emIP());
			ps.setString(20, sa.getS_Englist());
			ps.setString(21, sa.getS_computer());
			ps.setString(22, sa.getS_img());
			ps.setInt(23, sa.getSta_id());
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}

	public int register(String name, String pwd) {
		//初始化
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//编写sql查询管理员信息
		String sql="select COUNT(*) FROM register where r_name=? or r_phone=? or r_qq=? and r_pwd=?";
		try {
			//����SQL���
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, name);
			ps.setString(3, name);
			ps.setString(4, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				//ͨ���ѯ��ͳ���Ƿ�������û�������
				int number=rs.getInt(1);
				return number;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}
	
}
