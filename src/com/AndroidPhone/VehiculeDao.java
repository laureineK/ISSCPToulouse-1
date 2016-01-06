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

public class VehiculeDao {

	@SuppressWarnings("unchecked")
	public List<Vehicule> getAllVehicules(){
		
			      List<Vehicule> VehiculeList = null;
			      try {
			         File file = new File("Vehicule.dat");
			         if (!file.exists()) {
			        
			            Vehicule vehicule1 = new Vehicule(2,"43.604652","1.444209","2015-12-17 17:39:26");
			            Vehicule vehicule2 = new Vehicule(3,"43.603578","1.445947","2015-12-17 17:39:26");
			            Vehicule vehicule3 = new Vehicule(4,"43.594084","1.44879","2015-12-17 17:41:23");
			            Vehicule vehicule4 = new Vehicule(5,"43.592141","1.44055"," 	2015-12-17 17:42:01");
			            Vehicule vehicule5 = new Vehicule(6,"43.597922","1.445507","2015-12-17 17:42:46");
			            Vehicule vehicule6 = new Vehicule(7,"43.600331","1.450914","2015-12-17 17:42:46");
			            
			             
			            VehiculeList = new ArrayList<Vehicule>();
			            VehiculeList.add(vehicule1);
			            VehiculeList.add(vehicule2);
			            VehiculeList.add(vehicule3);
			            VehiculeList.add(vehicule4);
			            VehiculeList.add(vehicule5);
			            VehiculeList.add(vehicule6);
			            
			            saveVehiculeList(VehiculeList);	
			            
			         }
			         else{
			            FileInputStream fis = new FileInputStream(file);
			            ObjectInputStream ois = new ObjectInputStream(fis);
			            VehiculeList = (List<Vehicule>) ois.readObject();
			            ois.close();
			         }
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (ClassNotFoundException e) {
			         e.printStackTrace();
			      }		
			      return VehiculeList;
	}
	

	
	public int addVehicule(Vehicule addVehicule){
		List<Vehicule> VehiculeList = getAllVehicules();
		boolean VehiculeExists = false;
		
		for(Vehicule Vehicule: VehiculeList){
			if(Vehicule.getIdVehicule() == addVehicule.getIdVehicule()){
				VehiculeExists = true;
				break;
			}
		}
		if(! VehiculeExists){
			VehiculeList.add(addVehicule);
			saveVehiculeList(VehiculeList);
			return 1;
		}
		
		return 0;
	}

	
	   public int updateVehicule(Vehicule upvehicule){
		      List<Vehicule> VehiculeList = getAllVehicules();

		      for(Vehicule Vehicule: VehiculeList){
		         if(Vehicule.getIdVehicule() == upvehicule.getIdVehicule()){
		            int index = VehiculeList.indexOf(Vehicule);			
		            VehiculeList.set(index, upvehicule);
		            saveVehiculeList(VehiculeList);
		            return 1;
		         }
		      }		
		      return 0;
		   }
	   
	
	public int deleteVehicule(int id){
		List<Vehicule> VehiculeList = getAllVehicules();
		
		for(Vehicule Vehicule: VehiculeList){
			if(Vehicule.getIdVehicule() == id){
				int index = VehiculeList.indexOf(Vehicule);
				VehiculeList.remove(index);
				saveVehiculeList(VehiculeList);
				return 1;
			}
		}
		return 0;
	}
	
	   private void saveVehiculeList(List<Vehicule> VehiculeList){
	      try {
	         File filer = new File("Vehicule.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(filer);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(VehiculeList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }   
	
	
}
