package readwriteprintfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressFiles {

	    public static void main( String[] args )
	    {
	    	byte[] buffer = new byte[1024];
	 
	    	try{
	 
	    		FileOutputStream fos = new FileOutputStream("C:\\MyFile.csv.zip");
	    		ZipOutputStream zos = new ZipOutputStream(fos);
	    		ZipEntry ze= new ZipEntry("Sorted_1.00841079E9.csv");
	    		zos.putNextEntry(ze);
	    		FileInputStream in = new FileInputStream("C:\\Sorted_1.00841079E9.csv");
	 
	    		int len;
	    		while ((len = in.read(buffer)) > 0) {
	    			zos.write(buffer, 0, len);
	    		}
	 
	    		in.close();
	    		zos.closeEntry();
	 
	    		//remember close it
	    		zos.close();
	 
	    		System.out.println("Done");
	 
	    	}catch(IOException ex){
	    	   ex.printStackTrace();
	    	}
	    }
	}
	

