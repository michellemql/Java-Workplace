import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	
		int num1;
		System.out.println("Enter number 1: ");
		while (true) {
			try {
				num1 = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException nfe) {
				System.out.print("Try again: ");
			}
		}
		int num2;
		System.out.println("Enter number 2: ");
		while (true) {
			try {
				num2 = Integer.parseInt(scanner.next());
				break;
			} catch (NumberFormatException nfe) {
				System.out.print("Try again: ");
			}
		}
		
		System.out.println("Select an operator(+, -, *, /): ");  
		String operator = scanner.next();
		
		
		scanner.close();
		
		switch (operator) {
			case "+":
				int sum = addition(num1, num2);
				System.out.println("The sum of two numbers is: " + sum);
				break;
			case "-":
				int difference = subtraction(num1, num2);
				System.out.println("The difference of two numbers is: " + difference); 
				break;
			case "*":
				int product = Multiplication(num1, num2);
				System.out.println("The product of two numbers is: " + product); 
				break;
			case "/":
				int quotient = Division(num1, num2);
				System.out.println("The quotient of two numbers is: " + quotient); 
				break;
			default:
				System.out.println("Invalid operator, please try again."); 
		}
	}
	
	private static int addition(int x, int y) {
		return x + y;
	}
	
	private static int subtraction(int x, int y) {
		return x - y;
	}
	
	private static int Multiplication(int x, int y) {
		return x * y;
	}
	
	private static int Division(int x, int y) {
		return x / y;
	}
}
