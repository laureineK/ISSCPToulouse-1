package com.AndroidPhone;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDao {
	
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		
			      List<User> userList = null;
			      try {
			         File file = new File("Users.dat");
			         if (!file.exists()) {
			        	 
			      
			            User user = new User(1,"MARIE DUPONT", "27 Rue Jean Jaurés", "31400","Toulouse", 'F', "06062164978",2, true);
			            User user1 = new User(2,"JEAN VALJEAN", "Place Vendôme", "31200","Toulouse", 'M',"0605040302",3, false);
			            User user2 = new User(3,"SUZANNE SUZ", "87 Rue des Magiciens", "31400","Toulouse", 'F',"0561348250",4, true);
			            User user3 = new User(4,"PATRICK PAT", "Grand Rond", "3100","Toulouse", 'M',"0531313131",5,true);
			            User user4 = new User(5,"MARC MAR", "1 Impasse des cocotiers","31400","Toulouse", 'M',"0638854987",6,true);
			            User user5 = new User(6,"PASCAL PAS", " 1 Impasse Debussy","31400","Toulouse", 'M',"0606063171",7,true);
			            
			             
			            userList = new ArrayList<User>();
			            userList.add(user);
			            userList.add(user1);
			            userList.add(user2);
			            userList.add(user3);
			            userList.add(user4);
			            userList.add(user5);
			            
			            saveUserList(userList);	
			            
			         }
			         else{
			            FileInputStream fis = new FileInputStream(file);
			            ObjectInputStream ois = new ObjectInputStream(fis);
			            userList = (List<User>) ois.readObject();
			            ois.close();
			         }
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (ClassNotFoundException e) {
			         e.printStackTrace();
			      }		
			      return userList;
	}
	
	
	//getAllDrivers()
	@SuppressWarnings({"null" })
	public List<User> getAllDrivers(){
		List<User> driverList = null;
		List<User> users = getAllUsers();
		
		for(User user: users){
			if(user.getIsDriver() == true){
				driverList.add(user);
			}
		}
		return driverList;
	}
	
	
	public User getUser(int id){
		List<User> users = getAllUsers();
		
		for(User user: users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	
	public int addUser(User pUser){
		List<User> userList = getAllUsers();
		boolean userExists = false;
		
		for(User user: userList){
			if(user.getId() == pUser.getId()){
				userExists = true;
				break;
			}
		}
		if(! userExists){
			userList.add(pUser);
			saveUserList(userList);
			return 1;
		}
		
		return 0;
	}

	
	   public int updateUser(User pUser){
		      List<User> userList = getAllUsers();

		      for(User user: userList){
		         if(user.getId() == pUser.getId()){
		            int index = userList.indexOf(user);			
		            userList.set(index, pUser);
		            saveUserList(userList);
		            return 1;
		         }
		      }		
		      return 0;
		   }
	   
	
	public int deleteUser(int id){
		List<User> userList = getAllUsers();
		
		for(User user: userList){
			if(user.getId() == id){
				int index = userList.indexOf(user);
				userList.remove(index);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}
	
	   private void saveUserList(List<User> userList){
	      try {
	         File file = new File("Users.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(userList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }   
	
	
	   
	   
	   
	   
	   
	   
	   public static void sauverEnBase(String client){
		   //information d'accés à la base de données
		   String url = "";
		   String login = "";
		   String passwd = "";
		   Connection con = null;
		   Statement stat = null;
		   
		   try{
			   //Chargement du driver
			   		Class.forName("com.mysql.jdbc.Driver");
			   //Récupération de la connexion
			   		con = (Connection) DriverManager.getConnection(url, login, passwd);
		   	   //Création d'un statement
			   		stat = (Statement) con.createStatement();
	//		   		String sql = "INSERT INTO '' ('') VALUES ('""')";
			   //execution de la requete
		//	   		stat.executeUpdate(sql);
			   	
		   }catch (SQLException e) {
			   e.printStackTrace();
		   }catch (ClassNotFoundException e){
			   e.printStackTrace();
		   }finally{
			   try{
				   //libérer ressources de la mémoire
				   con.close();
				   stat.close();
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
		   }
	   }

	   
	   
}
