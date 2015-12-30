package com.AndroidPhone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")

public class User implements Serializable {
	
	private static final long serialVersionUID = 1l;
	private int id;
	private String name;
	private String address;
	private String phoneNum;
	
	public User(){}
	
	public User(int id, String name, String address, String phoneNum){
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	public int getId(){
		return id;
	}
	
	@XmlElement
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	@XmlElement
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress(){
		return address;
	}
	
	@XmlElement
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getPhoneNum(){
		return phoneNum;
	}
	
	@XmlElement
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}

}
