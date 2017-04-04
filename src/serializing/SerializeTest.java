package serializing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeTest {
	
	public static void main (String[] args) throws Exception{
		
		 Employee e = new Employee();
		 Employee e1 = new Employee();
	      e.name = "Alket ";
	      e.address = "Paolo davoli 5";
	      e.SSN = 1333;
	      e.number = 101;
	      
	      e1.name = "Alket Cecaj";
	      e1.address = "Ardizzone 3";
	      e1.SSN = 111333;
	      e1.number = 1011;
	     List<Employee>em = new ArrayList<Employee>();
	     em.add(e);
	     em.add(e1);
	     System.out.println("Employees before serialization ");
	     for (int i = 0; i < em.size(); i++) {
	    	 System.out.println(em.get(i).name);	
		 }
	     serial(em);
	     List<Employee>deserlist = new ArrayList<Employee>();
	     
	     deserlist = deserial(em);
	     
	     System.out.println("Employees after deserialization ");
	     
	     for (int i = 0; i < deserlist.size(); i++) {
	    	  System.out.println("Deserialized Employees...");
		      System.out.println(deserlist.get(i).name);
		 }
	    
	      
	    }
		
	public static List<Employee>deserial(List<Employee>deser){
		  try{
	         FileInputStream fileIn = new FileInputStream("data/employees.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         deser = (List) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	       
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	        
	      }
		  return deser;
		
	}
	
	public static void serial(List<Employee>em ){
		try{
			FileOutputStream fileOut =
					new FileOutputStream("data/employees.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(em);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in data/employees.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}

	}
	}


