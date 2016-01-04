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
	private boolean isDriver;
	
	public User(){}
	
	public User(int id, String name, String address, String phoneNum, boolean isDriver){
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.isDriver = isDriver;
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
	

	public boolean getIsDriver(){
		return isDriver;
	}
	
	@XmlElement
	public void setIsDriver(boolean isDriver){
		this.isDriver = isDriver;
	}

	   @Override
	   public boolean equals(Object object){
	      if(object == null){
	         return false;
	      }else if(!(object instanceof User)){
	         return false;
	      }else {
	         User user = (User)object;
	         if(id == user.getId()
	            && name.equals(user.getName())
	            && address.equals(user.getAddress())
	            && phoneNum.equals(user.getPhoneNum())
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }	

}
