import java.util.Scanner;

public class Words {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter your sentence: ");
		String userInput = myObj.nextLine();
		while (userInput == null || userInput.length() == 0) {
			System.out.println("Your input is empty. Please re-enter your sentence: ");
			userInput = myObj.nextLine(); 
		}
		int totalWords = countWords(userInput);
		System.out.println("Total number of words in it: " + totalWords);
	}
	
	public static int countWords(String str) {
		if (str == null || str.length() == 0) return 0;
		
		int count = 0;
		str.trim();
		
		// remove punctuation marks at the end to isolate the last word
		int k = str.length() - 1;
		while (k >= 0 && !Character.isLetter(str.charAt(k))) {
			k--;
		}
		
		String s = str.substring(0, k+1);
		String[] words = s.split(" ");

		boolean isWord = true;
		for (int i = 0; i < words.length; i++) {
			if (!isWord) {
				isWord = true;
			}
			String curWord = words[i];
			for (int j = 0; j < curWord.length(); j++) {
				char c = curWord.charAt(j);
				if (!Character.isLetter(c)) {
					isWord = false;
					continue;
				}
			}
			if (isWord) {
				count++;
			}
		}
		
		return count;
	}
}
