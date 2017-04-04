package main;

public class Main {

	public static void main (String[] args){
		
        int value1 = 1;
        int value2 = 2;
        int result = 0;
        boolean someCondition = false;
        result = someCondition ? value1 : value2;
        
       // if(someCondition) result = value1;
       // else result = value2;
        System.out.println(result);

	}
}
