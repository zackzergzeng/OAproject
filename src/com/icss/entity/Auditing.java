package com.icss.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Auditing {
	private Integer aud_id;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Timestamp aud_time;
	private Integer result;
	private String remarks;
	private Integer process_id;
	private Integer step_id;
	private Integer user_Id;
	private Steps steps;
	public Integer getAud_id() {
		return aud_id;
	}
	public void setAud_id(Integer aud_id) {
		this.aud_id = aud_id;
	}
	public Timestamp getAud_time() {
		return aud_time;
	}
	public void setAud_time(Timestamp aud_time) {
		this.aud_time = aud_time;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	public Integer getStep_id() {
		return step_id;
	}
	public void setStep_id(Integer step_id) {
		this.step_id = step_id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public Steps getSteps() {
		return steps;
	}
	public void setSteps(Steps steps) {
		this.steps = steps;
	}
	
}
