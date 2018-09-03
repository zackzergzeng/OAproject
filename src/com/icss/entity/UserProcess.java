package com.icss.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserProcess {
	private Integer process_id;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Timestamp time;
	private Integer pid;
	private Integer user_id;
	private ProcessBasicInfo pbi;
	private List<ProAttrValue> pavlist;
	private List<Auditing> aulist;
	public Integer getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public ProcessBasicInfo getPbi() {
		return pbi;
	}
	public void setPbi(ProcessBasicInfo pbi) {
		this.pbi = pbi;
	}
	public List<ProAttrValue> getPavlist() {
		return pavlist;
	}
	public void setPavlist(List<ProAttrValue> pavlist) {
		this.pavlist = pavlist;
	}
	public List<Auditing> getAulist() {
		return aulist;
	}
	public void setAulist(List<Auditing> aulist) {
		this.aulist = aulist;
	}
	
}
