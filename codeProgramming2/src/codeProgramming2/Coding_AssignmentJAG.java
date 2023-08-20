//The work and code for this project are all of my own work and it 
//does not contain any work or code received from another 
//source.



package codeProgramming2;


import java.util.ArrayList;
import java.util.Scanner;

public class Coding_AssignmentJAG {
	private static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
	//TwoStringsMethod();
	//HateToLoveMethod();
	//UserFavorites();
	//NumberOfGallons();
	//BMRCalculator();
	SecondLexico();
	//OneLineSentence();
	//DateChecker();
	//MaleOrFemaleBMR();
	//IsWordBackWord();
	//WinningFinalists();
	//ChocolateBarCoupons();
	}
	private static void TwoStringsMethod() {
		String CombinedString = null;
		System.out.print("Type a sentence or word.");
		String FirstString = keyboard.nextLine();
		System.out.print("Type a second sentence or word.");
		String SecondString = keyboard.nextLine();
		
		System.out.println("First: " + FirstString);
		System.out.println("Second: " + SecondString);
		CombinedString = FirstString + " " + SecondString;
		System.out.println("Combined: " + CombinedString);
	}
	private static void HateToLoveMethod() {
		
    System.out.println("Type a sentence or word. The first time the word hate");
    System.out.println("is used will be replaced by the word love");
    String LineOfText = keyboard.nextLine();
    
    if(LineOfText.contains("hate")){
    System.out.println(LineOfText.replaceFirst("hate", "love"));
    }
    	
    	}
	private static void UserFavorites() {
		System.out.println("What is your favorite color?");
		String Color = keyboard.nextLine();
		System.out.println("What is your favorie food?");
		String Food = keyboard.nextLine();
		System.out.println("What is your favorite animal?");
		String Animal = keyboard.nextLine();
		System.out.println("What is the first name of a friend or a relative");
		String Name = keyboard.nextLine();
		System.out.println("I had a dream that " + Name +" ate a " + Color);
		System.out.println(Animal + " and said it tasted like " + Food + "!");
		}
	private static void NumberOfGallons() {
		System.out.println("Enter radius of the well in inches.");
		double Radius = keyboard.nextInt();
		System.out.println("Enter the depth of the well in feet.");
		double Depth = keyboard.nextInt();
		double RadiusInFeet = Radius / 12;
		double InCubicFeet = (Math.PI * Math.pow(RadiusInFeet, 2) * Depth);
		double TotalGallons = InCubicFeet * 7.48;
		
		if (TotalGallons >= 250) {
		System.out.format("%.0f", TotalGallons);
		System.out.println(" Gallons of water. Plenty for a family");
		System.out.print("of 4 and no need to install a separate holding tank.");}
		else if (TotalGallons <= 250) {
		System.out.format("%.0f", TotalGallons);
		System.out.println(" Gallons of water. Not enough for a family");
		System.out.print("of 4. Need to install a separate holding tank.");}
	}
	private static void BMRCalculator() {
	System.out.print("Enter weight in pounds.");
	double Weight = keyboard.nextInt();
	System.out.print("Enter height in inches.");
	double Height = keyboard.nextInt();
	System.out.print("Enter age in years.");
	int Age = keyboard.nextInt();
	double ChocolateBar = 230;
	double FemaleBMR = 655 + (4.3 * Weight) + (4.7 * Height) - (4.7 * Age);
	System.out.format("Female: " + "%.0f", FemaleBMR / ChocolateBar);
	double MaleBMR = 66 + (6.3 * Weight) + (12.9 * Height) - (6.8 * Age);
	System.out.println("");
	System.out.format("Male: "+"%.0f", MaleBMR / ChocolateBar);
	}
	private static void SecondLexico() {
    System.out.print("Enter a sentence or phrase in undercase letters.");
	String LineOne = keyboard.nextLine();
	System.out.print("Enter a second sentence or phrase in undercase letters.");
	String LineTwo = keyboard.nextLine();
	System.out.print("Enter a third sentence or phrase in undercase letters.");
	String LineThree = keyboard.nextLine();
	
	int Size1 = LineOne.length();
    int Size2 = LineTwo.length();
    int Size3 = LineThree.length();
    int SecondMinimum = Math.min(Size1, Size2);
    int Minimum = Math.min(Size3, SecondMinimum);

    for (int index = 0; index < Minimum; index = index + 1) {
        int Character1 = (int)LineOne.charAt(index);
        int Character2 = (int)LineTwo.charAt(index);
        int Character3 = (int)LineThree.charAt(index);
        int TheBiggerCharacter = 0;
        String LargerString = null;
        String SecondLargest = null;
        
        if (Character1 > 65 && Character1 < 90 && Character2 > 65 && Character2 < 90);{
           if (Character1 != Character2 && Character1 > Character2) {
             TheBiggerCharacter = Character1;
             LargerString = LineOne;}
           else {
        	 TheBiggerCharacter = Character2;
        	 LargerString = LineTwo;}
           
        if (TheBiggerCharacter > 65 && TheBiggerCharacter < 90 && Character3 > 65 && Character3 < 90);{
           if (TheBiggerCharacter != Character3 && TheBiggerCharacter > Character3) {
             SecondLargest = LineThree;
             System.out.println(SecondLargest);
             break;}
           else {
             SecondLargest = LargerString;
             System.out.println(SecondLargest);
             break;}
               }
        }
    }
                      
               
           

    }
	private static void OneLineSentence(){
	System.out.print("Enter a sentence.");
	String Sentence = keyboard.nextLine();
	int Length = Sentence.length();
	char Last = Sentence.charAt(Length - 1);
	
	if (Last == 63 && (Length % 2 == 0)) {
	System.out.print("Yes");
	}
	else if (Last == 63 && (Length % 2 == 1)) {
	System.out.print("No");}
	
	if (Last == 33){
	System.out.print("Wow");}
	
	if (Last != 63 && Last != 33) {
	System.out.print("Yes No Wow" + " \"" + Sentence + "\"");
	}
	}
	
	private static void DateChecker() {
	System.out.print("Enter a date in mm/dd/yyyy format");
	String Date = keyboard.nextLine();
	String Month = Date.substring(0, 2);
	String Day = Date.substring(3, 5);
	String Year = Date.substring(6, 10);
	int MonthNum = Integer.valueOf(Month);
	int DayNum = Integer.valueOf(Day);
	int YearNum = Integer.valueOf(Year);
		
	if ((MonthNum == 4 || MonthNum == 6 || MonthNum == 9 || MonthNum == 11) && DayNum > 30) {
	System.out.print("Invalid ate");
	}
	if (DayNum > 31 || DayNum < 0 && MonthNum != 2 && (MonthNum < 1 || MonthNum > 12)) {
	System.out.print("Invalid Date");}
	else {
		System.out.print("Valid Date");
	}
	
	if ((YearNum % 4 ==0 && YearNum %100 != 0 || YearNum % 400 == 0) && DayNum == 29) {
    System.out.print("Valid Date");
	}
	else if (MonthNum == 2 && DayNum == 29) {
	System.out.print("Invalid Date");
	}
	}
	private static void MaleOrFemaleBMR() {
		System.out.println("Enter M for Male or enter W for Woman");
		String Gender = keyboard.nextLine();
		char G = Gender.charAt(0);
		System.out.print("Enter weight in pounds.");
		double Weight = keyboard.nextInt();
		System.out.print("Enter height in inches.");
		double Height = keyboard.nextInt();
		System.out.print("Enter age in years.");
		int Age = keyboard.nextInt();
		double ChocolateBar = 230;
		if (G == 87 || G == 119){
		double FemaleBMR = 655 + (4.3 * Weight) + (4.7 * Height) - (4.7 * Age);
		System.out.format("Female: " + "%.0f", FemaleBMR / ChocolateBar);
		System.out.print(" Chocolate Bars");
		}
		if (G == 77 || G == 109) {
		double MaleBMR = 66 + (6.3 * Weight) + (12.9 * Height) - (6.8 * Age);
		System.out.format("Male: "+"%.0f", MaleBMR / ChocolateBar);
		System.out.print(" Chocolate Bars");
		}
	}
	private static void IsWordBackWord() {
		System.out.println("Please Enter a word to find out if when we move the ");
		System.out.println("first letter to the the end of the rest of the letters");
		System.out.println("and reverse it whether it is the same word.");
		String QuitOrNot = null;
		int Count = 0;

	do {
				
	String Word = keyboard.next();
	if (Word.equals("Quit") || ((Word.equals("quit")))) {
		System.out.println("You found " + Count + " words");
		break;
	}
	int Length = Word.length();
	int LastIndex = Length - 1;
	int FirstIndex = 0;
	String FirstLetter = Word.substring(0,1);
	String TheRest = Word.substring(1, Length);
	String AlteredWord = TheRest + FirstLetter;
	
	for (int pass = 0; pass <= LastIndex; LastIndex = LastIndex - 1) {
	if ((Word.equals("Quit")) || (Word.equals("quit"))) {
		break;
	}
	
	char New = AlteredWord.charAt(LastIndex);
	char Old = Word.charAt(FirstIndex);
	FirstIndex = FirstIndex + 1;
	
	if (New != Old) {
	System.out.println("Word is not spelled the same when a letter is put at the");
	System.out.println("end and reversed");
	System.out.println("Type in Quit or quit to exit");
	break;
	}
	else if(pass == LastIndex){
	System.out.println("Word is spelled the same when a letter is put at the end");
	System.out.println("and reversed");
	Count = Count + 1;
	System.out.println("Type in Quit or quit to exit");
	
	
	}
	}
	}while ((QuitOrNot != "Quit") || (QuitOrNot != "quit"));
	 
	}
	
    private static void WinningFinalists(){
    	int num = (int) (Math.random() * 10) +1;
    	
    	int iterations = 0;
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	
    	while (iterations < 3) {
    		if (!list.contains(num)) {
    			list.add(num);
    			iterations = iterations + 1;
    		num = (int) (Math.random() * 10) +1;
    		}
    	    for(int finalist: list) {
    	    if (list.contains(num)) {
    	       break;
    	    }
    	    
    	    }
    }
    	System.out.print("The winners are: ");
    	 for (int Winners : list) {
    		 
             System.out.print(Winners + " ");
    	 }
    }
    private static void ChocolateBarCoupons(){
    	System.out.print("Enter amount of money to get chocolate bars. You get a");
        System.out.print(" coupon for every bar you buy");
    	int  Money = keyboard.nextInt();
    	    int AmountOfBars = 0;
    	    int Coupons = 0;
    	    int TotalOfBars = 0;
    	    int LeftOvers = 0;
    		int Cash = Money;
    		int FreeBars = 0;
    		do { 
    			Cash = Cash - 1;
    			AmountOfBars = AmountOfBars + 1;
    		    
    		    Coupons = Coupons + 1;
    		    		     
    		    
    }while (Cash  > 0);
    			
    		if (Coupons / 6 > 0) {
    			FreeBars = Coupons / 6;
    			int FreeCoupons = FreeBars * 1;
    			LeftOvers = (Coupons % 6) + FreeCoupons;}
    			
    			if (LeftOvers / 6 > 0) {
    				FreeBars = FreeBars + (LeftOvers / 6);
    			}
    			System.out.print(AmountOfBars + FreeBars);
    		} 
    }
    		    	
    		    
    		    
    		
    		
    	
    
    
    
    
    

    	
            
    		
            
    
    
    
    
	
		
	
	
