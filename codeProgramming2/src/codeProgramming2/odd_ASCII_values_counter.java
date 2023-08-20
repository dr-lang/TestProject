package codeProgramming2;

import java.util.Scanner;

public class odd_ASCII_values_counter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String originalString = scan.nextLine();
		System.out.print(oddIndexedChar(originalString));
	    if (scan != null) {
            scan.close();
	    }
	}
	public static int oddIndexedChar(String pMyString)
	{
	  String newString = "";
	  int number_of_odd = 0;
	  for(int index = 1; index <= pMyString.length() - 1; index += 2)
	    newString += pMyString.charAt(index);
	    number_of_odd = newString.length();
	  return number_of_odd;
	}
		
}




