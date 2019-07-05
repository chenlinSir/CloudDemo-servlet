package  com.cloud.entity;

public class Sta_staffinfo {
	//员工编号
	private int  sta_id;
	//员工名称
	private String sta_name;
	//员工性别
	private String sta_sex;
	//员工出生年月
	private String sta_birthday;
	//员工电话号码
	private String sta_phone;
	//员工登录名
	private String sta_login;
	//员工登录密码
	private String sta_pwd;
	//员工入职时间
	private String sta_entrytime;
	//员工职位
	private PostInfoEntry post;
	//员工住址
	private String sta_present;
	//员工民族
	private String S_natio;
	//员工籍贯
	private String S_place;
	//员工血型
	private String S_blood;
	//员工身份证号
	private String S_idcate;
	//婚姻状况
	private String S_marital;
	//员工政治面貌
	private String S_politics;
	//最高学历
	private String S_maxeducation;
	//最高学位
	private String S_maxdegree;
	//邮箱
	private String S_Email;
	//紧急联系人的电话
	private String S_emIP;
	//外语等级
	private String S_Englist;
	//计算机等级
	private String S_computer;
	//员工照片
	private String S_img;
	public Sta_staffinfo(int staId, String staName, String staSex,
			String staBirthday, String staPhone, String staLogin,
			String staPwd, String staEntrytime, PostInfoEntry post,
			String staPresent, String sNatio, String sPlace, String sBlood,
			String sIdcate, String sMarital, String sPolitics,
			String sMaxeducation, String sMaxdegree, String sEmail,
			String sEmIP, String sEnglist, String sComputer, String sImg) {
		super();
		sta_id = staId;
		sta_name = staName;
		sta_sex = staSex;
		sta_birthday = staBirthday;
		sta_phone = staPhone;
		sta_login = staLogin;
		sta_pwd = staPwd;
		sta_entrytime = staEntrytime;
		this.post = post;
		sta_present = staPresent;
		S_natio = sNatio;
		S_place = sPlace;
		S_blood = sBlood;
		S_idcate = sIdcate;
		S_marital = sMarital;
		S_politics = sPolitics;
		S_maxeducation = sMaxeducation;
		S_maxdegree = sMaxdegree;
		S_Email = sEmail;
		S_emIP = sEmIP;
		S_Englist = sEnglist;
		S_computer = sComputer;
		S_img = sImg;
	}
	
	public Sta_staffinfo(int staId, String staName) {
		super();
		sta_id = staId;
		sta_name = staName;
	}

	public Sta_staffinfo() {
		super();
	}
	public int getSta_id() {
		return sta_id;
	}
	public void setSta_id(int staId) {
		sta_id = staId;
	}
	public String getSta_name() {
		return sta_name;
	}
	public void setSta_name(String staName) {
		sta_name = staName;
	}
	public String getSta_sex() {
		return sta_sex;
	}
	public void setSta_sex(String staSex) {
		sta_sex = staSex;
	}
	public String getSta_birthday() {
		return sta_birthday;
	}
	public void setSta_birthday(String staBirthday) {
		sta_birthday = staBirthday;
	}
	public String getSta_phone() {
		return sta_phone;
	}
	public void setSta_phone(String staPhone) {
		sta_phone = staPhone;
	}
	public String getSta_login() {
		return sta_login;
	}
	public void setSta_login(String staLogin) {
		sta_login = staLogin;
	}
	public String getSta_pwd() {
		return sta_pwd;
	}
	public void setSta_pwd(String staPwd) {
		sta_pwd = staPwd;
	}
	public String getSta_entrytime() {
		return sta_entrytime;
	}
	public void setSta_entrytime(String staEntrytime) {
		sta_entrytime = staEntrytime;
	}
	public PostInfoEntry getPost() {
		return post;
	}
	public void setPost(PostInfoEntry post) {
		this.post = post;
	}
	public String getSta_present() {
		return sta_present;
	}
	public void setSta_present(String staPresent) {
		sta_present = staPresent;
	}
	public String getS_natio() {
		return S_natio;
	}
	public void setS_natio(String sNatio) {
		S_natio = sNatio;
	}
	public String getS_place() {
		return S_place;
	}
	public void setS_place(String sPlace) {
		S_place = sPlace;
	}
	public String getS_blood() {
		return S_blood;
	}
	public void setS_blood(String sBlood) {
		S_blood = sBlood;
	}
	public String getS_idcate() {
		return S_idcate;
	}
	public void setS_idcate(String sIdcate) {
		S_idcate = sIdcate;
	}
	public String getS_marital() {
		return S_marital;
	}
	public void setS_marital(String sMarital) {
		S_marital = sMarital;
	}
	public String getS_politics() {
		return S_politics;
	}
	public void setS_politics(String sPolitics) {
		S_politics = sPolitics;
	}
	public String getS_maxeducation() {
		return S_maxeducation;
	}
	public void setS_maxeducation(String sMaxeducation) {
		S_maxeducation = sMaxeducation;
	}
	public String getS_maxdegree() {
		return S_maxdegree;
	}
	public void setS_maxdegree(String sMaxdegree) {
		S_maxdegree = sMaxdegree;
	}
	public String getS_Email() {
		return S_Email;
	}
	public void setS_Email(String sEmail) {
		S_Email = sEmail;
	}
	public String getS_emIP() {
		return S_emIP;
	}
	public void setS_emIP(String sEmIP) {
		S_emIP = sEmIP;
	}
	public String getS_Englist() {
		return S_Englist;
	}
	public void setS_Englist(String sEnglist) {
		S_Englist = sEnglist;
	}
	public String getS_computer() {
		return S_computer;
	}
	public void setS_computer(String sComputer) {
		S_computer = sComputer;
	}
	public String getS_img() {
		return S_img;
	}
	public void setS_img(String sImg) {
		S_img = sImg;
	}
	
	
	
}
