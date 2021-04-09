import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter the word: ");
		String userInput = myObj.nextLine();  
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your input is empty. Please enter your word again: ");
			userInput = myObj.nextLine(); 
		}
		boolean isPalindromic = isPalindrome(userInput);
		System.out.println("Your word is " + userInput); 
		String result = (isPalindromic == true) ? "is " : "is not ";
		System.out.println("It " + result + "a palindromic word."); 
	}
	
	public static boolean isPalindrome(String str) {
		String reversedStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversedStr += str.charAt(i);
		}
		
		return reversedStr.equals(str);
		
	}
}
