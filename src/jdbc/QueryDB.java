package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//il codice in questa classe interroga il database teledatamese (la tabella netwok) 
//per avere le coordinate assiociate a ogni antenna e quindi a ogni evento 
//e riscrive i file(metodo printData()) cosi com'erano ma con le coordinate corrisponedenti assiociate a ogni evento

public class QueryDB {

	 public static void main(String[] args) {

		  Map<String, double[]>map = null;
		  String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/teledatamese";
	       
	      double[] location = new double[2];
	      
	 		try {
	 			Class.forName(myDriver);
	 		      Connection conn = DriverManager.getConnection(myUrl, "root", "SS7IAZ_*");
	 		      Statement st = conn.createStatement(); 
	 		    File Folder = new File("C:\\DATA\\data\\mese\\DatiCorrispondenti");
	 	        File files[];
	 	        files = Folder.listFiles();
	 	      

	 	        if(files.length>1)
	 	        {
	 	        	
	 	            for(int i = 0;i<files.length; i++){
	 	            
	 	            	String filename = files[i].getName();
	 	            	String filename2 = filename.substring(filename.indexOf("PLS"), filename.indexOf("."));
	 	            	System.out.println("leggo file "+i);
	 	            	BufferedReader  br = new BufferedReader(new FileReader(files[i]));
	 	            	map = new HashMap<String, double[]>();
	 	                String line = "";	
	 	                while((line = br.readLine())!=null){
	 	                	String [] riga = line.split("\t");
	 	                	String username = riga[0];
	 	                	int imsi = Integer.parseInt(riga[1]);
	 	                	long celllac = Long.parseLong(riga[2]);
	 	                	long tempo = Long.parseLong(riga[3]);
	 		      
	 		      
	 			       String query = "select lat_bari, lon_bari from network" +
	 					    " where celllac = '"+celllac+"';";
	 			
	 			              ResultSet r = st.executeQuery(query);
	 			                  while(r.next()){
	 				                double lat = r.getDouble("lat_bari");
	 				                double lon = r.getDouble("lon_bari");
	 				                 location = new double[]{lat,lon};
	 				                   map.put(line, new double[]{lat, lon});
	 				                 //  System.out.println(lat+", "+lon);
	 			                  }r.close();
	 			                   
	 		                       }br.close();
	 		                       printDataMap(map, "Coord2Celllac_"+filename2+"_.txt");
	 		                       
				                   
	                             }
	 	                        }
	 	                       }
	                             catch (Exception e)
	                           {
	           // System.err.println("Got an exception!");
	           // System.err.println(e.getMessage());
	            }
	 		
	           }
	  
	  public static void printDataMap(Map<String, double[]> map, String file)throws Exception{
			
			PrintWriter out = new PrintWriter(new FileWriter(file));
			for(String i : map.keySet()){
				out.print(i+"\t");
				out.println(map.get(i)[0]+"\t"+map.get(i)[1]);
			}
			out.close();
		}
	
}
