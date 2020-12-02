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
		String scannerInput;
		
		Scanner scan = new Scanner(System.in);
		
		List <String> emailList = new ArrayList<String>();
		HashMap<String, Boolean> emailMap = new HashMap<String, Boolean>();
		
		Pattern pattern = Pattern.compile(regex);
		
		System.out.println("Welcome to Email Validation" + "\n");
		
		while(stillRunning = true) {
			System.out.println("Please enter the emails to validate'");
			System.out.println("Enter 'F' when done");
			while(finished = true) {
				scannerInput = scan.next();
				if(scannerInput.compareTo("F") == 0) {
					break;
				}
				emailList.add(scan.next());
			}
			for(String email : emailList) {
				Matcher matcher = pattern.matcher(email);
				System.out.println("Results:" + "\n");
				System.out.println("E-mail: " + email + "is" + (matcher.matches() ? "valid":"invalid"));
				emailMap.put(email, matcher.matches());
			}
			
			System.out.println("Type 'log' to view the emails attempted...");
			System.out.println("Enter any key to continue or type 'exit' to exit");
			scannerInput = scan.next();
			if(scannerInput.compareTo("log") == 0) {
				int numEntry = 0;
				for(HashMap.Entry<String, Boolean> entry : emailMap.entrySet()) {
					numEntry += 1;
					String email = entry.getKey();
					Boolean valid = entry.getValue();
					System.out.println(numEntry + ": " + "Email: " + email + "Valid: " + valid );
				}
			}else if(scannerInput.compareTo("exit") == 0) {
				break;
			}
		}
		
		scan.close();
	}
}
