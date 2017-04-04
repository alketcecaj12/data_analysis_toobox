package readwriteobjects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	 
	   public static void main (String args[]) {
	 
		   Serializer serializer = new Serializer();
		   serializer.serializeAddress("paolo davoli 5", "italia");
	   }
	 
	   public void serializeAddress(String street, String country){
	 
		   Address address = new Address();
		   address.setStreet(street);
		   address.setCountry(country);
	 
		   try{
	 
			FileOutputStream fout = new FileOutputStream("c:\\address.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	   }
	}
