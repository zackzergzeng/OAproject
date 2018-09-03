package com.icss.entity;

import com.sun.jmx.snmp.Timestamp;

public class User_info {
	private Integer user_Id;
	private String user_Name;
	private String real_Name;
	private String sex;
	private String pwd;
	private String birthday;
	private String tel;
	private Integer departMaster;
	private Integer departId;
	private Integer positionId;
	
	public Integer getDepartMaster() {
		return departMaster;
	}
	public void setDepartMaster(Integer departMaster) {
		this.departMaster = departMaster;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getReal_Name() {
		return real_Name;
	}
	public void setReal_Name(String real_Name) {
		this.real_Name = real_Name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
    
}
