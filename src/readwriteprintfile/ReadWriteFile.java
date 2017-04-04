package readwriteprintfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteFile {

	public static void main (String[] args) throws Exception{
		String file = "pathofFile";
		String file2 = "C:\\Users\\Alket\\codeindigo\\DataProcessingToolBox\\PLS4DB";
		List<String> list = new ArrayList<String>();
		loadData(list, file);
		
		Map<Integer, List<String>>map = new HashMap<Integer, List<String>>();
		printMap(file, map);
		appendContent(file2);	
	}
	
	
	public static void loadData(List<String>list, String file)throws Exception {
		
     BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = "";
		while((line = br.readLine())!= null){
			
			String [] riga = line.split(", ");
		    String nomeutente = riga[0];
			list.add(nomeutente);
			
    	}br.close();
		
	}
	
	 public static void printMap(String file, Map<Integer, List<String>>map) throws Exception{
		   
		   PrintWriter out = new PrintWriter(new FileWriter(file));
		
		   for( int k: map.keySet()){
			   out.print(""+k+","); 
			   
			   for (int i = 0; i < map.get(k).size(); i++) {  
			     out.print(map.get(k).get(i)+",");
			     out.println(","+map.get(k).get(i)+","+map.get(k).get(i));
			   } 
		   }
		   out.close();
	   }
	 
	 public static void loadMultipleFiles(String file, Map<Integer, List<String>>map)throws Exception{
		 
		 File Folder = new File(file);
	      File files[];
	      files = Folder.listFiles();
	 
		try{
		  if(files.length>1){
		   for(int i = 0;i<files.length; i++){
			          	System.out.println(i);
			BufferedReader br = new BufferedReader(new FileReader(files[i]));
			List<String>slist = new ArrayList<String>();
			int imsi = 0;
			String line = "";
			while((line = br.readLine())!= null){
				
				String [] riga = line.split(", ");
			    String nomeutente = riga[0];
				imsi = Integer.parseInt(riga[1]); 
	         	slist.add(nomeutente);	 
	        }br.close();
			
	        map.put(imsi, slist);
			     }
		       }
			}
		catch (Exception e){
				e.getCause();
	
			}
		}
	 
	 public static void appendContent(String folder){
			
    	 File Folder = new File(folder);
		 File files[];
		 files = Folder.listFiles();
//		 String filefullname = files[0].getName();
		 File file2 =new File("TwitterDatiFinali.csv");
		System.out.println("creo file"+file2.getName());
		 try{
	      
           if(files.length>1)
            {
             for(int i = 0;i<files.length; i++){
            
             System.out.print("reading...");
             System.out.println(files[i].getName()+", number: "+i);
            
             try{
	
	    		//if file doesnt exists, then create it
	    		if(!file2.exists()){
	    			file2.createNewFile();
	    		}
	 
	    		//true = append file
	    		 BufferedReader br = new BufferedReader(new FileReader(files[i]));
	    		  
		    		FileWriter fileWritter = new FileWriter(file2.getName(),true);
		    	    PrintWriter out = new PrintWriter(fileWritter);    
		    		//BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    		 String linea = "";
	    		 
	    		 while((linea = br.readLine())!=null){
	    	        out.println(linea);
		                System.out.println("Done");
				  }
		          br.close();
		          out.close();
	 
	    	 }catch(IOException e){
	    		e.printStackTrace();
	    	  }
            }
          }
		}catch(Exception e){
        	 e.getMessage();
        	 }
         }
}
