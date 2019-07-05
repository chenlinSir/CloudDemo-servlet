package com.cloud.entity;

import java.util.Date;
import java.util.List;

public class MessageEntity {
	//留言
	private int msgId;//用户id
	private String  userface;//用户照片地址
	private String  userName;//用户名
	private String  userAsk;//用户留言
	private String askTime;//留言时间
	private String email;//用户邮箱
	private String msgReply;//回复
	
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getUserface() {
		return userface;
	}
	public void setUserface(String userface) {
		this.userface = userface;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAsk() {
		return userAsk;
	}
	public void setUserAsk(String userAsk) {
		this.userAsk = userAsk;
	}
	public String getAskTime() {
		return askTime;
	}
	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MessageEntity(int msgId, String userface, String userName,
			String userAsk, String askTime, String email) {
		super();
		this.msgId = msgId;
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
		this.email = email;
	}
	public MessageEntity() {
		super();
	}
	public MessageEntity(int msgId) {
		super();
		this.msgId = msgId;
	}
	public MessageEntity(String userName, String userAsk, String askTime,
			String email) {
		super();
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
		this.email = email;
	}
	public String getMsgReply() {
		return msgReply;
	}
	public void setMsgReply(String msgReply) {
		this.msgReply = msgReply;
	}
	public MessageEntity(String userface, String userName, String userAsk,
			String askTime, String email, String msgReply) {
		super();
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
		this.email = email;
		this.msgReply = msgReply;
	}
	public MessageEntity(int msgId, String userface, String userName,
			String userAsk, String askTime, String email, String msgReply) {
		super();
		this.msgId = msgId;
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
		this.email = email;
		this.msgReply = msgReply;
	}
	
	
}
