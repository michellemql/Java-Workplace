import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 

public class Vowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter your sentence: ");
		String userInput = myObj.nextLine();  
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your sentence is empty. Please enter your sentence again: ");
			userInput = myObj.nextLine(); 
		}
		int totalVowels = countVowels(userInput);
		System.out.println("Total number of vowels in your sentence: " + totalVowels); 
	}
	
	public static int countVowels(String str) {
		if (str == null || str.length() == 0) return 0;
		
		ArrayList<Character> vowels = new ArrayList<Character>(
				Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		int total = 0;
		String s = str.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (vowels.contains(c)) {
				total++;
			}
		}
		
		return total;
	}

}
