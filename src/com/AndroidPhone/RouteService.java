package com.AndroidPhone;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RouteService")



public class RouteService {
	
	   RouteDao routeDao = new RouteDao();
	   
/********************************* GET METHODS ********************************/
	   
	   // ****** Récupération de toutes les routes ****** //
	   @GET
	   @Path("/routes")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<Routes> getRoutes(){
	      return routeDao.getAllRoutes();
	   }
}
