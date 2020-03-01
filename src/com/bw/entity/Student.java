package com.bw.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Student {
	private Integer sid;
	@NotBlank(message = "姓名不能为空")
	private String sname;
	private String url;
	@NotBlank(message="密码不能为空")
	@Length(min = 3,max = 6,message = "密码长度为3至6位")
	private String pwd;
	private Integer age;
	@NotBlank(message="性别不能为空")
	private String sex;
	private List<Type> type;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<Type> getType() {
		return type;
	}
	public void setType(List<Type> type) {
		this.type = type;
	}
	public Student(Integer sid, String sname, String url, String pwd, Integer age, String sex, List<Type> type) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.url = url;
		this.pwd = pwd;
		this.age = age;
		this.sex = sex;
		this.type = type;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", url=" + url + ", pwd=" + pwd + ", age=" + age + ", sex="
				+ sex + ", type=" + type + "]";
	}
	
}
