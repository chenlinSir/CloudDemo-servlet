package com.cloud.entity;

public class UserInfoEntry {
//�û���Ϣʵ��
	//-- �û����
	private int us_id;
	//-- �û����
	 private String us_name;
	//-- �û��Ա�
	 private String us_sex;
	//  -- �û�����
	 private int us_age;
	//  -- �û����֤��
	 private String us_idcate;
	//-- �û���������
	 private String us_years;
	//  -- �û���ϵ�绰
	 private String us_phone;
	 //  -- ���о�ס��
	  private String us_present;
	  //-- email
	  private String us_Email; 
	 // -- �û�����
	 private String us_cartext;
	public int getUs_id() {
		return us_id;
	}
	public void setUs_id(int usId) {
		us_id = usId;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String usName) {
		us_name = usName;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String usSex) {
		us_sex = usSex;
	}
	public int getUs_age() {
		return us_age;
	}
	public void setUs_age(int usAge) {
		us_age = usAge;
	}
	public String getUs_idcate() {
		return us_idcate;
	}
	public void setUs_idcate(String usIdcate) {
		us_idcate = usIdcate;
	}
	public String getUs_years() {
		return us_years;
	}
	public void setUs_years(String usYears) {
		us_years = usYears;
	}
	public String getUs_phone() {
		return us_phone;
	}
	public void setUs_phone(String usPhone) {
		us_phone = usPhone;
	}
	public String getUs_present() {
		return us_present;
	}
	public void setUs_present(String usPresent) {
		us_present = usPresent;
	}
	public String getUs_Email() {
		return us_Email;
	}
	public void setUs_Email(String usEmail) {
		us_Email = usEmail;
	}
	public String getUs_cartext() {
		return us_cartext;
	}
	public void setUs_cartext(String usCartext) {
		us_cartext = usCartext;
	}
	public UserInfoEntry(int usId, String usName, String usSex, int usAge,
			String usIdcate, String usYears, String usPhone, String usPresent,
			String usEmail, String usCartext) {
		super();
		us_id = usId;
		us_name = usName;
		us_sex = usSex;
		us_age = usAge;
		us_idcate = usIdcate;
		us_years = usYears;
		us_phone = usPhone;
		us_present = usPresent;
		us_Email = usEmail;
		us_cartext = usCartext;
	}
	
	public UserInfoEntry(int usId) {
		super();
		us_id = usId;
	}
	public UserInfoEntry(String usName) {
		super();
		us_name = usName;
	}
	public UserInfoEntry(int usId, String usName, String usSex, int usAge,
			String usIdcate, String usYears, String usPhone, String usPresent,
			String usEmail) {
		super();
		us_id = usId;
		us_name = usName;
		us_sex = usSex;
		us_age = usAge;
		us_idcate = usIdcate;
		us_years = usYears;
		us_phone = usPhone;
		us_present = usPresent;
		us_Email = usEmail;
	}
	public UserInfoEntry(int us_id, String us_name) {
		super();
		this.us_id = us_id;
		this.us_name = us_name;
	}
	
	
}
