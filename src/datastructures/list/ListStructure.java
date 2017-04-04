package datastructures.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStructure {

	
	public static void main (String[]args){
		
		List<int[]> lista = new ArrayList<int[]>();
		int[] k = {1,2,3};
		int[] j = {4,5,6};
		int[] m = {7,6,9};
		lista.add(k);
		lista.add(j);
		lista.add(m);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	
		
		
		
		
	}
	
	
	
}
