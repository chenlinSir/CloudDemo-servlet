package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.MessageEntity;
import com.cloud.entity.UserMessageEntity;
import com.cloud.util.Conn;

public class UserMessageDao {
	Conn conn = new Conn();
	public int getUserCount(String key) {
		String sql = "select COUNT(userId) from usermessage where userName like ('%"+key+"%')";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat=conn.conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}

	public List<UserMessageEntity> searchUserMessage(int currentPage,
			int pageCount, String key ,int msgId1) {
		List<UserMessageEntity> list = new ArrayList<UserMessageEntity>();
		String sql = "select * from usermessage where msgId = ? limit ?,? ";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.conn.prepareStatement(sql);
			ps.setObject(1,msgId1);
			ps.setObject(2, (currentPage-1)*pageCount);
			ps.setObject(3, pageCount);
			rs = ps.executeQuery();
			while(rs.next()){
				int userId = rs.getInt("userId");
				int msgId = rs.getInt("msgId");
				String userface =rs.getString("userface");
				String userName = rs.getString("userName");
				String userAsk = rs.getString("userAsk");
				String askTime = rs.getString("askTime");
				UserMessageEntity me = new UserMessageEntity(userId,msgId, userface, userName, userAsk, askTime);
				list.add(me);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		
		return list;
	}

	public int addUserMessage(UserMessageEntity ume) {
		String sql = "insert into usermessage(msgId,userface,userName,userAsk,askTime) values(?,?,?,?,?)";
		String sql1 = "update message set msgReply = ? WHERE msgId=?";
		PreparedStatement stat=null;
		ResultSet rs=null;
		PreparedStatement stat1=null;
		try {
			stat=conn.conn.prepareStatement(sql);
			stat.setObject(1, ume.getMsgId());
			stat.setObject(2, ume.getUserface());
			stat.setObject(3, ume.getUserName());
			stat.setObject(4, ume.getUserAsk());
			stat.setObject(5, ume.getAskTime());
			stat1=conn.conn.prepareStatement(sql1);
			stat1.setObject(1, ume.getUserAsk());
			stat1.setObject(2, ume.getMsgId());
			int row = stat.executeUpdate();
			int row1 = stat1.executeUpdate();
			if(row>0 && row1>0){
				return row ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delUserMessageByMsgId(int userId,int msgId) {
		String sql="delete from usermessage where userId="+userId+"";
		String slq1="update message set msgReply =''  WHERE msgId="+msgId+"";
		PreparedStatement stat = null;
		PreparedStatement stat1 = null;
		ResultSet rs = null;
		try {
			stat = conn.conn.prepareStatement(sql);
			stat1 = conn.conn.prepareStatement(slq1);
			
			int row = stat.executeUpdate();
			int row1 = stat1.executeUpdate();
			if(row>0 && row1>0){
				return row;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return 0;
	}
	
}
