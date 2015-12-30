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

public class UserDao {
	
	
	public List<User> getAllUsers(){
		
			      List<User> userList = null;
			      try {
			         File file = new File("Users.dat");
			         if (!file.exists()) {
			            User user = new User(1, "Laureine FOUENANG", "135 Avenue Rangueil 31400 Toulouse", "0695587548");
			            User user1 = new User(2, "Guy KENGNE", "43 Avenue de la Paix 94260 Fresnes", "0695847854");
			            userList = new ArrayList<User>();
			            userList.add(user);
			            userList.add(user1);
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
	
	
}
