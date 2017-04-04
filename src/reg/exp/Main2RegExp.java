package reg.exp;

public class Main2RegExp {

	public static void main (String []args){
		
		String[] tokens = "Java,C?C#,C++.Python:Javascript;PHP".split("[.,:;?]");
		for(int i = 0; i < tokens.length; i++){
		System.out.println(tokens[i]);
	    }
    }
}