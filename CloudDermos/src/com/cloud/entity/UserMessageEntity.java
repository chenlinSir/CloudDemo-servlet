package com.cloud.entity;

public class UserMessageEntity {
	private int userId;
	private int msgId;//用户id
	private String  userface;//用户照片地址
	private String  userName;//用户名
	private String  userAsk;//用户留言
	private String askTime;//留言时间
	
	
	
	public UserMessageEntity(int userId, int msgId, String userface,
			String userName, String userAsk, String askTime) {
		super();
		this.userId = userId;
		this.msgId = msgId;
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserMessageEntity(int msgId, String userface, String userName,
			String userAsk, String askTime) {
		super();
		this.msgId = msgId;
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
	}
	public UserMessageEntity(String userface, String userName, String userAsk,
			String askTime) {
		super();
		this.userface = userface;
		this.userName = userName;
		this.userAsk = userAsk;
		this.askTime = askTime;
	}
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
	
}
