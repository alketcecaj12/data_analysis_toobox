package parsingandkml;


public class Item {

	String titolo;
	String descrizione;
	String link;
	String pubdate;
	
	
	public Item(String d, String l, String p){
		this.descrizione = d;
		this.link= l;
	    this.pubdate= p;
		
	}
	
	
	public String toString(){
		return "__ DESCRIZIONE: "+descrizione+"__LINK: "+link+"  ,__DATA: "+pubdate;
	}
	
	
	
}