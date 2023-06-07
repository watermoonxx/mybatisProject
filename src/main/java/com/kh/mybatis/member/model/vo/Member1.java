package com.kh.mybatis.member.model.vo;

public class Member1 {
	private String user_ID;
	private String user_Pwd;
	private String user_Name;
	private String email;
	private String birthday;
	private String gender;
	private String phone;
	private String address;
	private String enroll_date;
	private String modify_date;
	private String status;
	
	
	public Member1() { }
	
	public Member1(String user_ID, String user_Pwd, String user_Name, String email, String birthday, String gender,
			String phone, String address) {
		// super(); // 부모에게 넘겨주는 상황이 없으므로 필요 x  
		this.user_ID = user_ID;
		this.user_Pwd = user_Pwd;
		this.user_Name = user_Name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}

	public Member1(String user_ID, String user_Pwd, String user_Name, String email, String birthday, String gender,
			String phone, String address, String enroll_date, String modify_date, String status) {
		super();
		this.user_ID = user_ID;
		this.user_Pwd = user_Pwd;
		this.user_Name = user_Name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.status = status;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getUser_Pwd() {
		return user_Pwd;
	}

	public void setUser_Pwd(String user_Pwd) {
		this.user_Pwd = user_Pwd;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member1 [user_ID=" + user_ID + ", user_Pwd=" + user_Pwd + ", user_Name=" + user_Name + ", email="
				+ email + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone + ", address=" + address
				+ ", enroll_date=" + enroll_date + ", modify_date=" + modify_date + ", status=" + status + "]";
	}

	
	

}
