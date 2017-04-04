package datastructures2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListExample {
	
	public static void main (String [] args) throws Exception{


		String file = "C:\\Users\\alketcecaj\\Desktop\\FlickrDataPro\\F_Data_FIle";
		List<String>l = new ArrayList<String>();
		String line; 

		File f = new File(file);
		File[] files = f.listFiles();
		
		Map<String, List<String>>map = new TreeMap<String, List<String>>();
		
		for(int i = 0; i < files.length; i++){
			BufferedReader br = new BufferedReader(new FileReader(files[i]));

			while((line = br.readLine())!= null){

				String [] r = line.split("\t");
				String user = r[0];
				
				List<String>li = map.get(user);
				
				if(li == null){
					li = new ArrayList<String>();
					map.put(user, li);
				}
				li.add(user);
			}br.close();
			
			System.out.println("leggo il file nr "+i);

		}
		Collections.sort(l);
		        
		System.out.println(map.size());
		
		for (String str : map.keySet()) {
			System.out.println(str+"--> "+map.get(str).size());
		}
	}
}
