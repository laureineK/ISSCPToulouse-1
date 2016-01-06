package com.AndroidPhone;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicule")

public class Vehicule implements Serializable{
	
	private static final long serialVersionUID = 1l;
	private int idVehicule;
	private String currentLat;
	private String currentLong;
	private String postTime;
	
	//********************************* CONSTRUCTORS *******************************************//
	
	public Vehicule(){}
	
	public Vehicule(int idVehicule, String currentLat, String currentLong, String postTime) {
		super();
		this.idVehicule = idVehicule;
		this.currentLat = currentLat;
		this.currentLong = currentLong;
		this.postTime = postTime;
	}

	//******************************* GETTERS AND SETTERS ************************************//
	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public String getCurrentLat() {
		return currentLat;
	}

	public void setCurrentLat(String currentLat) {
		this.currentLat = currentLat;
	}

	public String getCurrentLong() {
		return currentLong;
	}

	public void setCurrentLong(String currentLong) {
		this.currentLong = currentLong;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	

}
