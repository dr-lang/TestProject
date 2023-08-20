package myProgrammingProject;

import java.util.Scanner;

public class palindromeChecker {
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String yesOrNo = null;
		do
		{
		String reversedString = "";	
		
		System.out.println("Enter a string and i'll reverse it.");
		String originalString = keyboard.next();
		for(int index = originalString.length() -1; index >= 0; index--)
		{
			reversedString += originalString.charAt(index);
		}
		
		if (originalString.equalsIgnoreCase(reversedString))
		{
			System.out.println("The string is a palindrome.");
		}
		else
		{
			System.out.println("The String is not a palindrome");
		}
		
		System.out.println("Would you like to continue?");
		yesOrNo = keyboard.next();
		} while(yesOrNo.equals("Yes")|| yesOrNo.equals("yes"));

		System.out.println("Have a nice day.");
	}

}
