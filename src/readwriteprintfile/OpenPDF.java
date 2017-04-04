package readwriteprintfile;

import java.io.File;

public class OpenPDF {
	 
	public static void main(String[] args) {
 
	  try {
 
		if ((new File("C:\\EffectiveEventDiscovery.pdf")).exists()) {
 
			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler c:\\EffectiveEventDiscovery.pdf");
			p.waitFor();
 
		} else {
 
			System.out.println("File is not exists");
 
		}
 
		System.out.println("Done");
 
  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
 
	}
}