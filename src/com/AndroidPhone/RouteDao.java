package com.AndroidPhone;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class RouteDao {


	
	
	@SuppressWarnings("unchecked")
	public List<Routes> getAllRoutes(){
		
			      List<Routes> routesList = null;
			      try {
			         File file = new File("Routes.dat");
			         if (!file.exists()) {
			        	 
			            Routes route1 = new Routes(1, 4, "15h30", "15°", "60°", "Place de la République", "18h03", "16°", "60°", "Gare Matabiau", 3, "28/12/2015");
			            Routes route2 = new Routes(2, 5, "07h15", "30°", "75°", "1 Impasse Andre Campra", "08h45", "21°", "78°", "Colomiers", 1, "04/01/2016");
			            
			             
			            routesList = new ArrayList<Routes>();
			            routesList.add(route1);
			            routesList.add(route2);
			            
			            saveRoutesList(routesList);	
			            
			         }
			         else{
			            FileInputStream fis = new FileInputStream(file);
			            ObjectInputStream ois = new ObjectInputStream(fis);
			            routesList = (List<Routes>) ois.readObject();
			            ois.close();
			         }
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (ClassNotFoundException e) {
			         e.printStackTrace();
			      }		
			      return routesList;
	}
	

	
	public int addRoutes(Routes addroute){
		List<Routes> routesList = getAllRoutes();
		boolean routesExists = false;
		
		for(Routes routes: routesList){
			if(routes.getId() == addroute.getId()){
				routesExists = true;
				break;
			}
		}
		if(! routesExists){
			routesList.add(addroute);
			saveRoutesList(routesList);
			return 1;
		}
		
		return 0;
	}

	
	   public int updateRoutes(Routes uproute){
		      List<Routes> routesList = getAllRoutes();

		      for(Routes routes: routesList){
		         if(routes.getId() == uproute.getId()){
		            int index = routesList.indexOf(routes);			
		            routesList.set(index, uproute);
		            saveRoutesList(routesList);
		            return 1;
		         }
		      }		
		      return 0;
		   }
	   
	
	public int deleteRoutes(int id){
		List<Routes> routesList = getAllRoutes();
		
		for(Routes routes: routesList){
			if(routes.getId() == id){
				int index = routesList.indexOf(routes);
				routesList.remove(index);
				saveRoutesList(routesList);
				return 1;
			}
		}
		return 0;
	}
	
	   private void saveRoutesList(List<Routes> routesList){
	      try {
	         File filer = new File("Routes.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(filer);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(routesList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }   
	

	
	
}
