package com.AndroidPhone;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/UserService")

public class UserService {

	   UserDao userDao = new UserDao();
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String FAILURE_RESULT="<result>failure</result>";
	   
/********************************* GET METHODS ********************************/
	   
	   // ****** Récupération de tous les utilisateurs ****** //
	   @GET
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<User> getUsers(){
	      return userDao.getAllUsers();
	   }	
	  
	   
	   // ****** Récupération d'un utilisateur en fonction de son identifiant ***** //

	   @GET
	   @Path("/users/{userid}")
	   @Produces(MediaType.APPLICATION_XML)
	   public User getUser(@PathParam("userid") int userid){
	      return userDao.getUser(userid);
	   }
	   

	   // ****** Récupération de tous les conducteurs ****** //
	   @GET
	   @Path("/users/drivers")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<User> getDrivers(){
	      return userDao.getAllDrivers();
	   }
	   
	   // ****** Récupération de tous les passagers ****** //
	   @GET
	   @Path("/users/passengers")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<User> getPassengers(){
	      return userDao.getAllUsers();
	   }
	   
	   // ****** Récupération de tous les véhicules ****** //
	   @GET
	   @Path("/users/cars")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<User> getCars(){
	      return userDao.getAllUsers();
	   }
	   
	   // ****** Récupération de toutes les routes ****** //
	   @GET
	   @Path("/users/routes")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<User> getRoutes(){
	      return userDao.getAllUsers();
	   }

	   /******************* reste à faire 
			toutes les routes d’un utilisateur en fonction de son identifiant
			toutes les routes ( avec l’id utilisateur associé à chaque route ) */
	   
	
/********************************* POST METHODS ********************************/
	   
	   //une route pour un utilisateur donné (pas urgent)
	   //un nouveau nombre de passager pour un trajet donné (pas urgent)
	   
	   @POST
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public String updateUser(@FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("addStreet") String addStreet,
	      @FormParam("addPostal") String addPostal,
	      @FormParam("addCity") String addCity,
	      @FormParam("sexe") char sexe,
	      @FormParam("telephone") String telephone,
	      @FormParam("idVehicule") int idVehicule,
	      @FormParam("isDriver") boolean isDriver,
	      
	      @Context HttpServletResponse servletResponse) throws IOException{
		   
			  User user = new User(id, name, addStreet, addPostal, addCity, sexe, telephone, idVehicule, isDriver);
		      int result = userDao.updateUser(user);
		      if(result == 1){
		    	  return SUCCESS_RESULT;
		      }
		      return FAILURE_RESULT;
	   }   
	   
/********************************* PUT METHODS ********************************/
	   @PUT
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public String createUser(@FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("addStreet") String addStreet,
	      @FormParam("addPostal") String addPostal,
	      @FormParam("addCity") String addCity,
	      @FormParam("sexe") char sexe,
	      @FormParam("telephone") String telephone,
	      @FormParam("idVehicule") int idVehicule,
	      @FormParam("isDriver") boolean isDriver,
	      @Context HttpServletResponse servletResponse) throws IOException{
		   User user = new User(id, name, addStreet, addPostal, addCity, sexe, telephone, idVehicule, isDriver);
	      int result = userDao.addUser(user);
	      if(result == 1){
	         return SUCCESS_RESULT;
	      }
	      return FAILURE_RESULT;
	   }   
	   
/********************************* DELETE METHODS ********************************/
	   @Path("/users/{userid}")
	   @Produces(MediaType.APPLICATION_XML)
	   public String deleteUser(@PathParam("userid") int userid){
	      int result = userDao.deleteUser(userid);
	      if(result == 1){
	         return SUCCESS_RESULT;
	      }
	      return FAILURE_RESULT;
	   } 
	  
/********************************* OPTIONS METHODS ********************************/
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   public String getSupportedOperations(){
	      return "<operations>GET, PUT, POST, DELETE</operations>";
	   }
}
