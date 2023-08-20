package driverPackage;

public class OutPut {

	public static void printStringLeft (int size, String formatted) 
	{
		int length = formatted.length();
		System.out.print(formatted);
		while(size > length) 
		{
			System.out.print(" ");
			size--;
		}
	}
	
	public static String buildStringLeft(int size, String formatted) 
	{
		int length = formatted.length();
		while(size > length) {
			formatted += " ";
			size--;
		}
		return formatted;
	}
	
	public static String printStringRight(int size, String formatted)
	{
		int length = formatted.length();
		while(size > length)
		{
			System.out.print(" ");
			size--;
		}
		return formatted;
	}
}
