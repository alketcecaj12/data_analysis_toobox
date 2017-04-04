package parsingandkml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;


	public class Main2ParsingItem {

	static HashMap <String, Item> docxml = new HashMap<String, Item>();

	public static void main(String [] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File("data2parsing/europe.xml")));
		
		String line;
	   
	    String title = null;
		String link = null;
	    String descrizione = null;
	    String pubdate = null;
	    
	    boolean inItem = false;
	    boolean indesc = false;
	    while((line = br.readLine())!= null){
			line = line.trim();
			

		if (line.equals("<item>")){
			inItem = true;
		}
		if(inItem){
			
			if(line.startsWith("<title>")){
				line = line.substring(line.indexOf(">")+1, line.indexOf("</"));
			    title=line;
			}
			
			if (line.startsWith("<description>")){
				
			   descrizione = line.substring(line.indexOf(">")+1);
				
				if(!(line.endsWith("</description>"))){
					
					line = br.readLine();
					
					descrizione += line;
					
					line = br.readLine();
					do{
						line = br.readLine();
						descrizione += line;
					}while(line.endsWith("</description>"));
				
				}
				else{
					indesc = false;
				}
			
			} 
			
			if(line.startsWith("<link>")){
				line = line.substring(line.indexOf(">")+1, line.indexOf("</"));
			    link = line;
			}	
		
			if(line.startsWith("<pubDate>")){
				line = line.substring(line.indexOf(">")+1, line.indexOf("</"));
			    pubdate = line;
			}
			
		}
		
		
		   if (inItem && line.startsWith("</item>")){
			Item i = new Item(descrizione, link,pubdate);
			docxml.put(title, i);
	        inItem = false;
		   }
			
			
		}br.close();
		System.out.println(docxml);
		for(String s : docxml.keySet()){
			System.out.println(s);
			
		}
		print(docxml, "PrintText.txt");
	}

	public static void print(HashMap <String, Item> docxml, String file) throws Exception {
		
        PrintWriter out = new PrintWriter(new FileWriter(new File(file)));

        for(String s: docxml.keySet()){
      	  out.print(s);
      	  out.println("");
        }
        out.close();
        
        }
	}

	
	

