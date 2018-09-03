package com.icss.entity;

public class ProAttrValue {
	private Integer val_id;
	private Integer process_id;
	private Integer attrid;
	private String attr_val;
	private Attributes attributes;
	public Integer getVal_id() {
		return val_id;
	}
	public void setVal_id(Integer val_id) {
		this.val_id = val_id;
	}
	public Integer getProcess_id() {
		return process_id;
	}
	public void setProcess_id(Integer process_id) {
		this.process_id = process_id;
	}
	public Integer getAttrid() {
		return attrid;
	}
	public void setAttrid(Integer attrid) {
		this.attrid = attrid;
	}
	public String getAttr_val() {
		return attr_val;
	}
	public void setAttr_val(String attr_val) {
		this.attr_val = attr_val;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	
}
