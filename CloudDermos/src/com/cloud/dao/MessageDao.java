package com.cloud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloud.entity.MessageEntity;
import com.cloud.entity.UserMessageEntity;
import com.cloud.util.Conn;

public class MessageDao {

	Conn conn=new Conn();
	public int addMessage( MessageEntity me) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="insert into message(userName,userAsk,askTime,email) values(?,?,?,?)";
		try {
			ps=conn.conn.prepareStatement(sql);
			ps.setString(1, me.getUserName());
			ps.setString(2, me.getUserAsk());
			ps.setObject(3, me.getAskTime());
			ps.setObject(4, me.getEmail());
			int re= ps.executeUpdate();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		return 0;
	}

	public List<MessageEntity> searchMessage(int currentPage, int pageCount, String key) {
		List<MessageEntity> list = new ArrayList<MessageEntity>();
		String sql = "select * from message where  userName like '"+key+"%' or askTime LIKE '"+key+"%' limit ?,?";
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.conn.prepareStatement(sql);
			ps.setObject(1, (currentPage-1)*pageCount);
			ps.setObject(2, pageCount);
			rs = ps.executeQuery();
			while(rs.next()){
				int msgId = rs.getInt("msgId");
				String userface =rs.getString("userface");
				String userName = rs.getString("userName");
				String userAsk = rs.getString("userAsk");
				String askTime = rs.getString("askTime");
				String email = rs.getString("email");
				String msgReply = rs.getString("msgReply");
				if(msgReply==null){
					msgReply="未回复";
				}else{
					msgReply="已回复";
				}
				MessageEntity me = new MessageEntity(msgId,userface, userName, userAsk, askTime, email, msgReply);
				list.add(me);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.colse(ps, rs);
		}
		
		return list;
	}

	public List<MessageEntity> searchMessageById(String msgId) {
		List<MessageEntity> list = new ArrayList<MessageEntity>();
		String sql = "select * from message where msgId = ?";
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.conn.prepareStatement(sql);
			ps.setObject(1, msgId);
			rs = ps.executeQuery();
			while(rs.next()){
				String userface =rs.getString("userface");
				String userName = rs.getString("userName");
				String userAsk = rs.getString("userAsk");
				String askTime = rs.getString("askTime");
				String email = rs.getString("email");
				String msgReply = rs.getString("msgReply");
				MessageEntity me = new MessageEntity(userface, userName, userAsk, askTime, email, msgReply);
				list.add(me);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<UserMessageEntity> searchUserMessageById(String msgId) {
		List<UserMessageEntity> list = new ArrayList<UserMessageEntity>();
		String sql = "select * from usermessage where msgId = ?";
		Conn conn=new Conn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.conn.prepareStatement(sql);
			ps.setObject(1, msgId);
			rs = ps.executeQuery();
			while(rs.next()){
				String userface =rs.getString("userface");
				String userName = rs.getString("userName");
				String userAsk = rs.getString("userAsk");
				String askTime = rs.getString("askTime");
				UserMessageEntity ume = new UserMessageEntity(userface, userName, userAsk, askTime);
				list.add(ume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getUserCount(String key) {
		String sql = "select COUNT(msgId) from message where userName like '%"+key+"%'";
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

	public int delMessageByMsgId(int msgId) {
		String sql="delete from message where msgId ="+msgId+"";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.conn.prepareStatement(sql);
			int row = stat.executeUpdate();
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return 0;
	}
	
}
