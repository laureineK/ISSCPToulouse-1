package com.AndroidPhone;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "routes")

public class Routes implements Serializable{
	
	private static final long serialVersionUID = 1l;
	private int id;
	private int idUser;
	private String departHour;
	private String departLat;
	private String departLong;
	private String departPlace;
	private String arriveHour;
	private String arriveLat;
	private String arriveLong;
	private String arrivePlace;
	private int availableSeats;
	private String days;
	
	//****************************************** CONSTRUCTORS
	public Routes(){};
	
	public Routes(int id, int idUser, String departHour, String departLat, String departLong, String departPlace,
			String arriveHour, String arriveLat, String arriveLong, String arrivePlace, int availableSeats,
			String days) {
		this.id = id;
		this.idUser = idUser;
		this.departHour = departHour;
		this.departLat = departLat;
		this.departLong = departLong;
		this.departPlace = departPlace;
		this.arriveHour = arriveHour;
		this.arriveLat = arriveLat;
		this.arriveLong = arriveLong;
		this.arrivePlace = arrivePlace;
		this.availableSeats = availableSeats;
		this.days = days;
	}

	//****************************************** GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getDepartHour() {
		return departHour;
	}

	public void setDepartHour(String departHour) {
		this.departHour = departHour;
	}

	public String getDepartLat() {
		return departLat;
	}

	public void setDepartLat(String departLat) {
		this.departLat = departLat;
	}

	public String getDepartLong() {
		return departLong;
	}

	public void setDepartLong(String departLong) {
		this.departLong = departLong;
	}

	public String getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}

	public String getArriveHour() {
		return arriveHour;
	}

	public void setArriveHour(String arriveHour) {
		this.arriveHour = arriveHour;
	}

	public String getArriveLat() {
		return arriveLat;
	}

	public void setArriveLat(String arriveLat) {
		this.arriveLat = arriveLat;
	}

	public String getArriveLong() {
		return arriveLong;
	}

	public void setArriveLong(String arriveLong) {
		this.arriveLong = arriveLong;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public int isAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}
	
	
	
	
}
