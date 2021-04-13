import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Consonants {

	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your sentence: ");
		String userInput = scanner.nextLine();  
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your sentence is empty. Please enter your sentence again: ");
			userInput = scanner.nextLine(); 
		}
		int totalConsonants = countConsonants(userInput);
		System.out.println("Total number of consonants in your sentence is " + totalConsonants); 
		scanner.close();
	}
	
	public static int countConsonants(String str) {
		if (str == null || str.length() == 0) return 0;
			
		int total = 0;
		String s = str.toUpperCase();
		char[] letters = s.toCharArray();
		ArrayList<Character> consonants = new ArrayList<Character>(
				Arrays.asList('B', 'C', 'D', 'F', 'G','J','K','L','M','N','P','Q','S','T','V','X','Z','H','R','W','Y'));
		for (int i = 0; i < letters.length; i++) {
			if (consonants.contains(letters[i])) {
				letters[i] = '*';
				total++;
			}
		}
		
		return total;
	}
}
