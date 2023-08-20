package myProgrammingProject;

import java.util.Scanner;

public class reverseA_String {
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String yesOrNo = null;
		
		do
		{
			
		
			
		String alteredString = "";
		
		System.out.println("Please enter a word?");
		
		String originalString = keyboard.next();
		
		for(int index = originalString.length() - 1; index >= 0; index--)
		{
			alteredString += originalString.charAt(index);
		}
		System.out.println(alteredString);
		
		System.out.println("Would you like to continue this program?");
		
		yesOrNo = keyboard.next();
		
		
	}while(yesOrNo.equals("Yes") || yesOrNo.equals("yes"));

		System.out.println("Have a nice day.");
}
}
