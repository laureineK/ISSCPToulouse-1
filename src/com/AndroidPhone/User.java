package com.AndroidPhone;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")

public class User implements Serializable {
	
	private static final long serialVersionUID = 1l;
	private int id;
	private String name;
	private String addStreet;
	private String addPostal;
	private String addCity;
	private char sexe;
	private String telephone;
	private int idVehicule;
	private boolean isDriver;

	//**************************************** CONSTRUCTEURs *********************************************//
	public User(){}
	
	public User(int id, String name, String addStreet, String addPostal,String addCity, char sexe, String telephone, int idVehicule, boolean isDriver){
		this.id = id;
		this.name = name;
		this.addStreet = addStreet;
		this.addPostal = addPostal;
		this.addCity = addCity;
		this.sexe = sexe;
		this.telephone = telephone;
		this.idVehicule = idVehicule;
		this.isDriver = isDriver;
	}
	
	
	// *********************************** GETTERS AND SETTERS **************************************//
	
	public String getAddStreet() {
		return addStreet;
	}

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}

	public String getAddPostal() {
		return addPostal;
	}

	public void setAddPostal(String addPostal) {
		this.addPostal = addPostal;
	}

	public String getAddCity() {
		return addCity;
	}

	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public void setDriver(boolean isDriver) {
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
	

	public boolean getIsDriver(){
		return isDriver;
	}
	
	@XmlElement
	public void setIsDriver(boolean isDriver){
		this.isDriver = isDriver;
	}

	
	
//**************************************** AUTRES ***********************************************//	
	
	
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
	            && addStreet.equals(user.getAddStreet())
	            && addPostal.equals(user.getAddPostal())
	            && addCity.equals(user.getAddCity())
	            && telephone.equals(user.getTelephone())
	         ){
	            return true;
	         }			
	      }
	      return false;
	   }	

	   
	   
}
