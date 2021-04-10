import java.io.*;
import java.util.*;
import java.util.Scanner;

/* h - xxx xxs xxxy xxy xxxx
 * xxxx yxx yxxx sxx xxx - h
 * 
 * 
 * */
public class LastLetterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter the string: ");
		String userInput = myObj.nextLine();
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your input is empty. Please re-enter your string: ");
			userInput = myObj.nextLine(); 
		}
		int total = countSpecialWords(userInput);
		System.out.println("Total number of words that ends in 's' or 'y' is  " + total);

	}
	
	public static int countSpecialWords(String str) {
		if (str == null || str.length() == 0) return 0;
		
		int total = 0;
		int s = -1;
		int y = -1;
		
		String[] words = str.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].endsWith("s") || words[i].endsWith("y")) {
				total++;
				if (words[i].endsWith("s") && s == -1) {
					s = i;
				}
				if (words[i].endsWith("y") && y == -1) {
					y = i;
				}
			}
		}
		if (s != -1 && y != -1) {
			swap(words, s, y);
		}	
		String newString = Arrays.toString(words);
		System.out.println(newString);
		
		return total;
	}
	
	private static void swap(String[] words, int s, int y) {
		String temp = words[s];
		words[s] = words[y];
		words[y] = temp;
	}
}
