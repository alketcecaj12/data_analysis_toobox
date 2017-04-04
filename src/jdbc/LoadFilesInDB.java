package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LoadFilesInDB {

	public static void main (String[] args) throws Exception{
	loadNetworkData("C:\\Users\\Alket\\codeindigo\\DataProcessingToolBox"
			+ "\\PLS4DB");	
    }
    
	public static void loadNetworkData(String file)throws Exception{
	  
	  File Folder = new File(file);
      File files[];
      files = Folder.listFiles();
 
		String myDriver = "org.gjt.mm.mysql.Driver";
	    String myUrl = "jdbc:mysql://localhost/db2toolbox";
	    Class.forName(myDriver);
	    Connection conn = DriverManager.getConnection(myUrl, "root", "SS7IAZ_*");
	     
	    Statement st = conn.createStatement();
	   
		try{
			if(files.length>1)
		      {
			 for(int i = 0;i<files.length; i++){
		          	System.out.println(i);
		BufferedReader br = new BufferedReader(new FileReader(files[i]));
		
		String line = "";
		while((line = br.readLine())!= null){
			
			String [] riga = line.split(", ");
		    String nomeutente = riga[0];
			int imsi = Integer.parseInt(riga[1]); 
            long celllac = Long.parseLong(riga[2]);
            long tempo = Long.parseLong(riga[3]);
            double lat_ant = Double.parseDouble(riga[4]);
    		double lon_ant = Double.parseDouble(riga[5]);
    		
			
			 st.executeUpdate("INSERT INTO eventdata(username, imsi, celllac," +
		         		"tempo, lat_bari, lon_bari) " +
		         		"VALUES ('"+nomeutente+"','"+imsi+"','"+celllac+"','"+tempo+"','"+lat_ant+"','"+lon_ant+"')" +
		                		"ON DUPLICATE KEY UPDATE contatore = contatore+1;");
		    
		}br.close();
			 }
		      }
		    }catch( Exception e) {
			    e.printStackTrace();
			    
			}		
	}
}

	
	

