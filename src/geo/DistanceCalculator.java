package geo;

import org.gps.utils.LatLonPoint;
import org.gps.utils.LatLonUtils;

public class DistanceCalculator {


		public static void main (String [] args) throws Exception{
			
			double lat1 = 44.97585859987010;
			double lat2 = 44.45930925998701;
			
			double lon1 = 8.803608404362727;
			double lon2 = 7.737893782102057;
		
			
			LatLonPoint gp1 = new LatLonPoint(lat1, lon1);
			
			LatLonPoint gp2 = new LatLonPoint(lat2, lon2);
			
		       double d = LatLonUtils.getHaversineDistance(gp1, gp2);	
			
		       System.out.println( d);

		           }	    
			}

