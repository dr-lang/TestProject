package myProgrammingProject;

import java.util.Scanner;

public class vowelCounterAndSum {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		int count = 0;
		int total_A_S = 0;
		int total_E_S = 0;
		int total_I_S = 0;
		int total_O_S = 0;
		int total_U_S = 0;
		
		System.out.println("Enter a Sentence or Word.");
		
		String originalString = keyboard.nextLine();
		int size = originalString.length();
		
		for (int index = 0; index < size; index++)
		{
			
			switch(originalString.charAt(index))
			
			{
			case 'A':
			case 'a':
				count++;
				total_A_S++;
				break;
			case 'E':
			case 'e':
				count++;
				total_E_S++;
				break;
			case 'I':
			case 'i':
				count++;
				total_I_S++;
				break;
			case 'O':
			case 'o':
				count++;
				total_O_S++;
				break;
			case 'U':
			case 'u':
				count++;
				total_U_S++;
				break;
			
			}
		}
		System.out.println(String.format("There are %d total vowels in this sentence.", count));
		System.out.println(String.format("There are %d As in this sentence.", total_A_S));
		System.out.println(String.format("There are %d total Es in this sentence.", total_E_S));
		System.out.println(String.format("There are %d Is in this sentence.", total_I_S));
		System.out.println(String.format("Ther are %d total Os in this sentence.", total_O_S));
		System.out.println(String.format("There are %d Us in this sentence.", total_U_S));
		
		

	}

}
