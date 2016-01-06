package com.AndroidPhone;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/VehiculeService")

public class VehiculeService {

	   VehiculeDao vehiculeDao = new VehiculeDao();
	   
/********************************* GET METHODS ********************************/
	   
	   // ****** R�cup�ration de touts les v�hicules ****** //
	   @GET
	   @Path("/vehicules")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<Vehicule> getVehicules(){
	      return vehiculeDao.getAllVehicules();
	   }
	
	
}
