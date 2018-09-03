package com.icss.entity;

public class Steps {
	private int step_id;
	private String step_name;
	private int pre_step;
	private int pid;
	private int positionId;
	public int getStep_id() {
		return step_id;
	}
	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}
	public String getStep_name() {
		return step_name;
	}
	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}
	public int getPre_step() {
		return pre_step;
	}
	public void setPre_step(int pre_step) {
		this.pre_step = pre_step;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	
}
