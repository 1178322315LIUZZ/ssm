package com.bw.entity;

public class User {
	private Integer id;
	private String user;
	private String pass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User(Integer id, String user, String pass) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", pass=" + pass + "]";
	}
	
}
