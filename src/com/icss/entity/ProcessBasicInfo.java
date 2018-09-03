package com.icss.entity;

public class ProcessBasicInfo {
	private int pid;
	private int ptId;
	private String pName;
	private int status;
	private String remarks;
	private ProcessType type;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPtId() {
		return ptId;
	}
	public void setPtId(int ptId) {
		this.ptId = ptId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public ProcessType getType() {
		return type;
	}
	public void setType(ProcessType type) {
		this.type = type;
	}
	
}
