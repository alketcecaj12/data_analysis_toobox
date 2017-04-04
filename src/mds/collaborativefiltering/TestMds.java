package mds.collaborativefiltering;

import java.util.List;

public class TestMds {

	   public static double delta = 0.01;
	       public static void main(String[] args) {
	             double[][] items = new double[][]{
	                           { 1, 2, 3 ,4},
	                           { 2, 3, 4, 5},
	                           {14,15,16,17},
	                           {13,14,17,16}
	             };
	            
	             for(int i=0; i<items.length;i++)
	             for(int j=0; j<items.length;j++) {
	                    double d = d(items[i],items[j]);
	                    System.out.println("dist item_"+i+", item_"+j+" = "+d);
	             }
	                   
	            
	             double[][] points = new double[][]{
	                           {10*Math.random(),10*Math.random()},
	                           {10*Math.random(),10*Math.random()},
	                           {10*Math.random(),10*Math.random()},
	                           {10*Math.random(),10*Math.random()}
	             };
	            System.out.println(" i numeri random sono ");
	             print(points);
	            
	            
	             for(int t=0; t<1000;t++)
	             for(int i=0; i<points.length;i++) {
	                    points[i] = shift(i,points,items);
	                    System.out.println("----------------"+i);
	             }
	            
	            // print(points);
	             System.out.println("calcolo la distanza dopo il shift ");
	             for(int i=0; i<points.length;i++)
		             for(int j=0; j<points.length;j++) {
		                    double d = d(points[i],points[j]);
		                    System.out.println("dist point_"+i+", point_"+j+" = "+d);
		             }
	             System.out.println("---------------------------------------------");
	             print(points);
	            
	       }
	       public static double dist(double[] x, double[] y) {
	             double s = 0;
	             for(int i=0; i<x.length;i++)
	                    s+= Math.pow(x[i] - y[i],2);
	             return Math.sqrt(s);
	       }
	       
	    
	       public static double[] shiftpoints(int i, double[][] points, List<double[]> items) {
	             double[] p = points[i];
	            
	             for(int j=0; j<points.length;j++) {
	            	 double[] d = items.get(j);
	                    double[] d1 = items.get(i);
	                    
	                    double dist2d = d(points[i],points[j]);
	                    //System.out.println("distanza in 2d = "+dist2d);
	                    
	                    double dist4d = dist(d,d1);
	                    //System.out.println("distanza in 4d = "+dist4d);
	                    double v = 0;
	                    if(dist2d > dist4d) v = 1;
	                    if(dist2d < dist4d) v = -1;
	                   
	                    p[0] = points[i][0] + (points[j][0] - points[i][0])*delta*v;
	                    p[1] = points[i][1] + (points[j][1] - points[i][1])*delta*v;
	                   // System.out.println("p0 = "+p[0]);
	                   // System.out.println("p1 = "+p[1]);
	             }
	             return p;
	       }
	      
	      
	       public static void print(double[][] v) {
	             for(int i=0;i<v.length;i++) {
	                    for(int j=0; j<v[i].length;j++)
	                           System.out.print(v[i][j]+", ");
	                    System.out.println();
	             }
	             System.out.println();
	       }
	      
	       public static double d(double[] x, double[] y) {
	             double s = 0;
	             for(int i=0; i<x.length;i++)
	                    s+= Math.pow(x[i] - y[i],2);
	             return Math.sqrt(s);
	       }
	       
	       public static void getRandPts( double[][] points){
		    
		    for(int j = 0; j < points[0].length; j++){
		       for(int i = 0; i < points.length; i++){
			      double elem = 10*Math.random();
			      points[i][j] = elem;
			      
		       }
	         }
	       }
	       public static double[] shift(int i, double[][] points, double[][] items) {
	             double[] p = points[i];
	            
	             for(int j=0; j<points.length;j++) {
	                    double dist2d = d(points[i],points[j]);
	                    //System.out.println("distanza in 2d = "+dist2d);
	                    double dist4d = d(items[i],items[j]);
	                    //System.out.println("distanza in 4d = "+dist4d);
	                    double v = 0;
	                    if(dist2d > dist4d) v = 1;
	                    if(dist2d < dist4d) v = -1;
	                   
	                    p[0] = points[i][0] + (points[j][0] - points[i][0])*delta*v;
	                    p[1] = points[i][1] + (points[j][1] - points[i][1])*delta*v;
	                    //System.out.println("p0 = "+p[0]);
	                    //System.out.println("p1 = "+p[1]);
	             }
	             return p;
	       }
	       
}
