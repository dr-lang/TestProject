package codeProgramming2;
import java.util.Scanner;

public class CSC222_Review_Solutions {

	private static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		//CombinedAndWidthAndLength();
		//nohatejustlove();
	    //favorites();
		//gallonsAmount();
		//justBMRChocolate();
		lexicographically();
		//oneSentence();
		//date();
		//mwBMRChocolate();
		//winners();
		//wordReversed();
		//candyBars();
	}

	private static void wordReversed() {
		String testWord = null;
		String inputWord = null;
		int count = 0;
		int length = 0;
		System.out.println("This program tests to see if a word is the same word if its first letter is moved to the last letter and read backwards.");
		System.out.println("Three examples of this property are banana dresser and grammar");
		System.out.println("Please enter a word to test.");
		System.out.println("Enter \"quit\" to exit.");
		inputWord = keyboard.nextLine();
		while(!inputWord.equalsIgnoreCase("quit"))
		{
			length = inputWord.length();
			if(length > 0)
			{
				testWord = inputWord.substring(0,1);
				for(int index = length; index > 1; index--)
				{
					testWord = testWord.concat(inputWord.substring(index - 1, index));
				}
				
				if(testWord.equalsIgnoreCase(inputWord))
					count++;
			}
			System.out.println("Please enter another word to test.");
			System.out.println("Enter \"quit\" to exit.");
			inputWord = keyboard.nextLine();
		}
		System.out.printf("We found %d words that have that property.\n", count);
	}

	private static void candyBars() {
		int inputDollars = 0;
		int workingDollars = 0;
		int coupons = 0;
		int barCount = 0;
		System.out.println("This section of code prompts the user for an input dollar amount.");
		System.out.println("Each dollar will buy a candy bar, and each candy bar has a coupon.");
		System.out.println("Six coupons will also buy a candy bar.");
		System.out.println("Please enter the number of dollars you want to spend on candy bars\nand I will tell you how many bars cou can buy includings those bought with coupons.");
		inputDollars = keyboard.nextInt();
		workingDollars = inputDollars;
		while(workingDollars > 0 || coupons == 6)
		{
			if(coupons == 6)
			{
				barCount++;
				coupons = 1;
			}
			else
				if(workingDollars > 0)
				{
					barCount++;
					coupons++;
					workingDollars--;
				}
		}
		System.out.printf("With $%d you were able to purchase %d candy bars and you have %d coupon(s) left. \n", inputDollars, barCount, coupons);

	}

	private static void winners() {
		int winnerOne = -1;
		int winnerTwo = -1;
		int winnerThree = -1;
		winnerOne = (int) (Math.random() * 10) + 1;
		do
		{
			winnerTwo = (int) (Math.random() * 10) + 1;
		}while(winnerOne == winnerTwo);
		do
		{
			winnerThree = (int) (Math.random() * 10) + 1;
		}while(winnerOne == winnerThree || winnerTwo == winnerThree);
		System.out.printf("The winners are %d, %d, and %d\n", winnerOne, winnerTwo, winnerThree);
	}

	private static void mwBMRChocolate() {
		double BMRMale = 0.0;
		double BMRFemale = 0.0;
		double manCandy = 0.0;
		double womanCandy = 0.0;
		double weightInPounds = 0.0;
		double heightInInches = 0.0;
		double ageInYears = 0.0;
		double caloriesInCandyBar = 230.0;
		String gender = "F";

		System.out.println("Please enter your gender \"M\" for male and \"F\" for female.");
		gender = keyboard.nextLine().trim();
		System.out.println("Please enter your weitht in pounds.");
		weightInPounds = keyboard.nextDouble();
		System.out.println("Please enter your height in inches.");
		heightInInches = keyboard.nextDouble();
		System.out.println("Please enter your age in years.");
		ageInYears = keyboard.nextDouble();
		keyboard.nextLine();

		if (gender.equalsIgnoreCase("f")) {
			BMRFemale = 655 + (4.3 * weightInPounds) + (4.7 * heightInInches) - (4.7 * ageInYears);
			womanCandy = BMRFemale / caloriesInCandyBar;
			System.out.printf(
					"It would take %4.2f calories or %4.2f candy bars to maintain your weight.\n\n",
					BMRFemale, womanCandy);
		} else {
			BMRMale = 66 + (6.3 * weightInPounds) + (12.9 * heightInInches) - (6.8 * ageInYears);

			manCandy = BMRMale / caloriesInCandyBar;

			System.out.printf(
					"It would take %4.2f calories or %4.2f candy bars to maintain your weight.\n",
					BMRMale, manCandy);
		}

	}

	private static void date() {
		String inputDateString = null;
		String dayString = null;
		String monthString = null;
		String yearString = null;
		int delimiterIndex = -1;
		int day = 0;
		boolean validDate = true;
		int year = 0;
		int divBy4 = 0;
		int divBy100 = 0;
		int divBy400 = 0;
		System.out.println("Please enter a date in the format \"mm/dd/yyyy\"");
		inputDateString = keyboard.nextLine().trim();
		delimiterIndex = inputDateString.indexOf("/");
		if (delimiterIndex != 2) {
			System.out.printf("Invalid date %s\n", inputDateString);
			validDate = false;
		} else {
			monthString = inputDateString.substring(0, delimiterIndex);
			if (!monthString.matches("[0-9]+")) {
				System.out.printf("Invalid month date %s\n", inputDateString);
				validDate = false;
			} else {
				delimiterIndex = inputDateString.indexOf("/", ++delimiterIndex);
				if (delimiterIndex != 5) {
					System.out.printf("Invalid month date %s\n", inputDateString);
					validDate = false;
				} else {
					dayString = inputDateString.substring(delimiterIndex - 2, delimiterIndex);
					if (!dayString.matches("[0-9]+")) {
						System.out.printf("Invalid day date %s\n", inputDateString);
						validDate = false;
					} else {
						yearString = inputDateString.substring(delimiterIndex + 1);
						if (yearString.length() != 4 || !yearString.matches("[0-9]+")) {
							System.out.printf("Invalid year date %s\n", inputDateString);
							validDate = false;
						} else {
							day = Integer.parseInt(dayString);
							switch (monthString) {
							case "01":
							case "03":
							case "05":
							case "07":
							case "08":
							case "10":
							case "12":
								if (day > 31) {
									System.out.printf("Invalid day date %s\n", inputDateString);
									validDate = false;
								}
								break;
							case "02":
								year = Integer.parseInt(yearString);
								divBy4 = year % 4;
								divBy100 = year % 100;
								divBy400 = year % 400;
								if ((divBy4 == 0 && divBy400 == 0) || (divBy4 == 0 && divBy100 != 0)) {
									if (day > 29) {
										System.out.printf("Invalid day date %s\n", inputDateString);
										validDate = false;
									}
								} else if (day > 28) {
									System.out.printf("Invalid day date %s\n", inputDateString);
									validDate = false;
								}

								break;
							case "04":
							case "06":
							case "09":
							case "11":
								if (day > 30) {
									System.out.printf("Invalid day date %s\n", inputDateString);
									validDate = false;
								}
								break;
							default:
								System.out.printf("Invalid month date %s\n", inputDateString);
								validDate = false;
							}
						}

					}

					if (validDate)
						System.out.println("good date");
				}
			}
		}

	}

	private static void oneSentence() {
		String inputString = null;
		int stringLength = 0;
		int oddEvenValue = 0;
		System.out.println("Please enter a sentence with punctuation.");
		inputString = keyboard.nextLine().trim();
		stringLength = inputString.length();
		if (stringLength > 0) {
			oddEvenValue = stringLength % 2;
			switch (inputString.charAt(stringLength - 1)) {
			case '?':
				if (oddEvenValue == 0)
					System.out.println("Yes");
				else
					System.out.println("No");
				break;
			case '!':
				System.out.println("Wow");
				break;
			default:
				System.out.printf("You always say \"%s\"\n", inputString);
			}
		}

	}

	private static void lexicographically() {
		String stringOne = null;
		String stringTwo = null;
		String stringThree = null;
		System.out.println("Please enter a string");
		stringOne = keyboard.nextLine();
		System.out.println("Please enter a second string");
		stringTwo = keyboard.nextLine();
		System.out.println("Please enter a third string");
		stringThree = keyboard.nextLine();
		if(stringOne.compareTo(stringTwo) < 0)
			if( stringTwo.compareTo(stringThree) < 0)
				System.out.printf("The second String \"%s\" is lexicographically second of the three strings\n", stringTwo);
			else
				if(stringTwo.compareTo(stringThree) > 0)
					if(stringOne.compareTo(stringThree) < 0)
						System.out.printf("The third String \"%s\" is lexicographically second of the three strings\n", stringThree);
					else
						if(stringOne.compareTo(stringThree) > 0)
							System.out.printf("The first String \"%s\" is lexicographically second of the three strings\n", stringOne);
						else
							System.out.println("The first and third Strings ar equal and the second String comes last");
				else
					System.out.println("String two and String three are equal and they both come after String one");
		else
			if(stringOne.compareTo(stringTwo) > 0)
				if( stringOne.compareTo(stringThree) < 0)
					System.out.printf("The first String \"%s\" is lexicographically second of the three strings\n", stringOne);
				else
					if(stringOne.compareTo(stringThree) > 0)
						if(stringTwo.compareTo(stringThree) < 0)
							System.out.printf("String three \"%s\" is lexicographically second of the three strings\n", stringThree);
						else
							if(stringTwo.compareTo(stringThree) > 0)
								System.out.printf("String two \"%s\" is lexicographically second of the three strings\n", stringTwo);
							else
								System.out.println("String one and String two are equal and come after String three");
					else
						System.out.println("String one and String three are equal and they both come after String two");
			else
				if(stringOne.compareTo(stringThree) < 0)
					System.out.println("String one and String two are equal and they both come before String three");
				else
					if(stringOne.compareTo(stringThree) > 0)
						System.out.println("String one and String two are equal and they bothe come after String three");
					else
						System.out.println("All three Strings are equal!");
		
	}


	private static void justBMRChocolate() {
		double BMRMale = 0.0;
		double BMRFemale = 0.0;
		double manCandy = 0.0;
		double womanCandy = 0.0;
		double weightInPounds = 0.0;
		double heightInInches = 0.0;
		double ageInYears = 0.0;
		double caloriesInCandyBar = 230.0;

		System.out.println("Please enter your weitht in pounds.");
		weightInPounds = keyboard.nextDouble();
		System.out.println("Please enter your height in inches.");
		heightInInches = keyboard.nextDouble();
		System.out.println("Please enter your age in years.");
		ageInYears = keyboard.nextDouble();
		keyboard.nextLine();

		BMRFemale = 655 + (4.3 * weightInPounds) + (4.7 * heightInInches) - (4.7 * ageInYears);
		BMRMale = 66 + (6.3 * weightInPounds) + (12.9 * heightInInches) - (6.8 * ageInYears);

		womanCandy = BMRFemale / caloriesInCandyBar;
		manCandy = BMRMale / caloriesInCandyBar;

		System.out.printf(
				"It would take %4.2f calories or %4.2f candy bars to maintain your weight if you are a male.\n",
				BMRMale, manCandy);
		System.out.printf(
				"It would take %4.2f calories or %4.2f candy bars to maintain your weight if you are a female.\n\n",
				BMRFemale, womanCandy);

	}

	private static void gallonsAmount() {
		double radius = 0.0;
		double Pi = 3.14159;
		double depth = 0.0;
		double cubicFeetToGallons = 7.48;
//		double cubicFeet = 0.0;
		double totalGallons = 0.0;
		System.out.println("Please enter the depth of the well in feet.");
		depth = keyboard.nextDouble();
		System.out.println("Please enter the radius of the well in inches.");
		radius = keyboard.nextDouble() * 1 / 12.0;
		totalGallons = (Pi * radius * radius * depth * cubicFeetToGallons);
		System.out.printf("This well will hold %.2f gallons of watter in the well shaft.\n", totalGallons);

	}

	private static void favorites() {
		String myColor = null;
		String myFood = null;
		String myAnimal = null;
		String myName = null;
		System.out.println("Please enter a favorite color.");
		myColor = keyboard.nextLine();
		System.out.println("Please enter a favorite food.");
		myFood = keyboard.nextLine();
		System.out.println("Please enter a favorite animal.");
		myAnimal = keyboard.nextLine();
		System.out.println("Please enter a friend's first name");
		myName = keyboard.nextLine();
		System.out.println(String.format("I had a dream that %s ate a %s %s and said it tasted like %s!", myName,
				myColor, myAnimal, myFood));

	}

	private static void nohatejustlove() {
		System.out.println("This code block converts the first occurance of \"hate\" into \"love\"");
		String myStringOne = null;
		System.out.println("Please enter a sentence that containes the String \"hate\" as many times as you like.");
		myStringOne = keyboard.nextLine();
		myStringOne = myStringOne.replaceFirst("hate", "love");
		System.out.println("I have rephrased that to read:");
		System.out.println(myStringOne);
	}

	private static void CombinedAndWidthAndLength() {
		String myStringOne = null;
		int lengthOne = 0;
		String myStringTwo = null;
		int lengthTwo = 0;
		String myStringThree = null;
		int lengthThree = 0;
		System.out.println(
				"Get two String \n Display them and their length\n Then combine them with a space between them and display the resulting String with its lemgth");
		System.out.println("Please enter a sentence");
		myStringOne = keyboard.nextLine();
		lengthOne = myStringOne.length();
		System.out.println("Please enter another sentence");
		myStringTwo = keyboard.nextLine();
		lengthTwo = myStringTwo.length();
		myStringThree = myStringOne.concat(" ".concat(myStringTwo));
		lengthThree = myStringThree.length();
		System.out.printf("Sentence One is \"%s\", and is %d characters long\n", myStringOne, lengthOne);
		System.out.printf("Sentence Two is \"%s\", and is %d characters long\n", myStringTwo, lengthTwo);
		System.out
				.println("I will combine Sentence One and Two into a single third sentence with a space between them.");
		System.out.printf("Sentence Three is \"%s\", and is %d characters long\n", myStringThree, lengthThree);
	}

}


	
