package emailvalidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIdValidation {
	
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9_.-]+$";
	
	public static void main(String[] args) {
		
		boolean stillRunning, finished = true;
		String emailInput;
		
		Scanner scan = new Scanner(System.in);
		
		List <String> emailList = new ArrayList<String>();
		HashMap<String, Boolean> emailMap = new HashMap<String, Boolean>();
		
		Pattern pattern = Pattern.compile(regex);
		
		
		while(stillRunning = true) {
			System.out.println("Welcome to Email Validation" + "\n");
			System.out.println("Please enter the emails to validate'");
			System.out.println("Type 'F' when done");
			while(finished = true) {
				emailInput = scan.next();
				if(emailInput.compareTo("F") == 0) {
					break;
				}
				emailList.add(scan.next());
			}
			for(String email : emailList) {
				Matcher matcher = pattern.matcher(email);
				System.out.println("E-mail: " + email + "is" + (matcher.matches() ? "valid":"invalid"));
			}
			
			
			
			scan.close();
		}
	}
}
