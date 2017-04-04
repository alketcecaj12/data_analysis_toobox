package math;

import java.text.DecimalFormat;

public class Main2Math {

	public static void main(String[] args)
	    {	
	 
		double kilobytes = 1205.6358;
	 
		System.out.println("kilobytes : " + kilobytes);
	 
		double newKB = Math.round(kilobytes*100.0)/100.0;
		System.out.println("kilobytes (Math.round) : " + newKB);
	 
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("kilobytes (DecimalFormat) : " + df.format(kilobytes));
	    }
	}
	
	
	
