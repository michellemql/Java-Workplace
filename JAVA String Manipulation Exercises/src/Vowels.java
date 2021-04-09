import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 

public class Vowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter your sentence: ");
		String userInput = myObj.nextLine();  
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your sentence is empty. Please enter your sentence again: ");
			userInput = myObj.nextLine(); 
		}
		int totalVowels = countVowels(userInput);
		System.out.println("Your sentence is: " + userInput); 
		System.out.println("The total number of vowels in your sentence is: " + totalVowels); 
	}
	
	public static int countVowels(String sentence) {
		ArrayList<Character> vowels = new ArrayList<Character>(
				Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		int total = 0;
		String s = sentence.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (vowels.contains(c)) {
				total++;
			}
		}
		
		return total;
	}

}
