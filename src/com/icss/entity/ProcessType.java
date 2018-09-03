package com.icss.entity;

import java.util.List;

public class ProcessType {
	private int ptId;
	private String ptName;
	private int fatherType;
	private List<ProcessBasicInfo> pbi;
	public int getPtId() {
		return ptId;
	}
	public void setPtId(int ptId) {
		this.ptId = ptId;
	}
	public String getPtName() {
		return ptName;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public int getFatherType() {
		return fatherType;
	}
	public void setFatherType(int fatherType) {
		this.fatherType = fatherType;
	}
	public List<ProcessBasicInfo> getPbi() {
		return pbi;
	}
	public void setPbi(List<ProcessBasicInfo> pbi) {
		this.pbi = pbi;
	}
	
}
