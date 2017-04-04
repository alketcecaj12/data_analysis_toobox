package reg.exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2RegexPatternValidation {

	
		  private Pattern pattern;
		  private Matcher matcher;
	 
		  private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	 
		  public Main2RegexPatternValidation(){
			  pattern = Pattern.compile(USERNAME_PATTERN);
		  }
	 
		  /**
		   * Validate username with regular expression
		   * @param username username for validation
		   * @return true valid username, false invalid username
		   */
		  public  boolean validate(final String username){
	 
			  matcher = pattern.matcher(username);
			  System.out.println("valid");
			  return matcher.matches();
	 
		  }
		  public static void main (String[] args){
			   Pattern pattern;
			    Matcher matcher;
		 
			   final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
			   //validate("ciao");
			   Main2RegexPatternValidation pv = new Main2RegexPatternValidation();
			   pv.validate( USERNAME_PATTERN);
		  }
	}

