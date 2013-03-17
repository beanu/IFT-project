package com.beanu.ifthen.bean;

import java.io.Serializable;

/**
 * 数据库存储单个实例
 * 
 * @author beanu
 * 
 */
public class DBItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String a;
	private String aType;
	private String content;
	private String b;
	private String bType;
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
