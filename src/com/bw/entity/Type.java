package com.bw.entity;

public class Type {
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Type(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Type() {
		super();
	}
	@Override
	public String toString() {
		return "Type [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
