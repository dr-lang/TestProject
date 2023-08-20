package numbersGamePackage;
/**
 * Larry Shannon
 * 
 * This program Builds a sequence of 5 numbers (1-9) and asks the user to find it
 * 
 * SET UP GAME a game by building a sequence of 5 numbers and storing them in a 
 * String called testPattern
 * The String is built by randomly selecting a number and concatenating that number to the 
 * end of the String. This is repeated 5 times to build a String of length 5.
 * initialize the totalTries variable
 * 
 * ASK THE USER to input a string of 5 numbers
 * store the user's input into a String called userPattern
 * initialize the hits, and totalValue variables
 * check to see if the patterns match by checking character by character in the two Strings
 * If a character matches add one to hits and add the value of the character's integer to totalValue
 * If all characters match (hits == 5) then the user has solved the problem
 *     Ask if they would like to play again
 *     if so loop to SET UP GAME
 *     else exit
 * If all characters did not match print out Hits and totalValue
 * 		Loop to ASK THE USER
 * 
 */
//needed to complete the practical
//import java.io.PrintWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class NumbersGame 
{
	private String playerOne = "";
	private String testPattern = "";
	private Scanner keyboard = new Scanner(System.in);
	private static Score[] bestScores = new Score[5];
	private String firstScore = null;
	private String secondScore = null;
	private String thirdScore = null;
	private String fourthScore = null;
	private String fifthScore = null;
	public NumbersGame()
	{
		setTopScores();
	}
	void setTopScores()
	{
		//To do: open saved Scores and load to bestScores array
		
		File curfile = null;
		Scanner fileReader = null;
		String fileName = "bestScores.txt";
		try
		{
			fileReader = new Scanner(fileName);
			fileReader.useDelimiter("[,\n\r]+");
			
		}
		catch(FileNotFoundException fileError)
		{
			System.out.println("File was not found");
			System.exit(0);
		}
		firstScore = fileReader.next();
		secondScore = fileReader.next();
		thirdScore = fileReader.next();
		fourthScore = fileReader.next();
		fifthScore = fileReader.next();
		
	}
	static void saveTopScores()
	{
		FileOutputStream outfile  = null;
		PrintWriter filePrinter= null;
		fileName = "outfile.txt";
		try
		{
			outfile = new FileOutputStream(fileName);
			filePrinter = new PrintWriter(outfile);
			for(Score curScore: bestScores)
			{
				filePrinter.println("Saved score.");
				filePrinter.println(curScore);
			}
				
		}
		catch(FileNotFoundException fileError)
		{
			System.out.println("The file was not found");
			System.exit(0);
		}
	}
	/**
	 * Description - inner class to hold the name and the score of a single play
	 * @author Larry
	 *
	 */
	protected class Score implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String name = null;
		int score = 0;
		/**
		 * Description - Score constructor accepts the player's name and score of a successful game
		 * @param newPlayerOne
		 * @param pScore
		 * precondition - none
		 * postcondition - a new Score object is created and its reference returned to the calling code
		 */
		public Score(String newPlayerOne, int pScore)
		{
			if(newPlayerOne.equals(playerOne))
				System.out.println("Your score is one of the top five best scores!!");
			name = newPlayerOne;
			score = pScore;
		}
		public int getScore()
		{
			return score;
		}
		public String toString()
		{
			return String.format("%s: %d", name, score);
		}
		
	}
	/**
	 * @description 
	 * @param newPlayer
	 */
	public NumbersGame(String newPlayer)
	{
		playerOne = newPlayer;
		setTopScores();
	}
	public void playMasterMindNumbers()
  {
		String yesOrNo = "yes";
		System.out.printf("Hello %s\n",playerOne);
		System.out.println("Welcome to the Numbers version of the MasterMind game.");
		do
		{
			System.out.println("I will generate a new five digit number for you to guess.");
			System.out.println("For each of your guesses I will resopnd with:");
			System.out.println("The number of correct digits in the correct locations, and thier sum.");
			setupGame();
			guessNumber();
			System.out.printf("Would like to play again, %s?\n",playerOne);
			do
			{
				System.out.println("Please enter \"yes\" or \"no\".");
				yesOrNo = keyboard.next();
				keyboard.nextLine();
			}while(!yesOrNo.equals("yes") && !yesOrNo.equals("no"));
		}while(yesOrNo.equals("yes"));
		
		System.out.printf("Thank you for playing %s!\nGood-bye!\n",playerOne);
	}
	/**
	 * Description - This module generates a string of five base 10 numeric characters.
	 * Algorithm
	 * BEGIN METHOD setupGame():RETURNS nothing
	 *   initialize the state variable testPattern to an empty string
	 *   FOR five times
	 *     generate a random number
	 *     append that random number to the end of testPattern
	 *   END FOR
	 * END METHOD
	 */
	private void setupGame()
	{
		testPattern = "";
		
		for(int count =0; count < 5; count++)
		{
			testPattern = testPattern + ((int)(Math.random() * 10));
//			System.out.println("Pattern = " + testPattern);
		}
	}
//see algorithm at top
	private void guessNumber()
	{
		String userPattern = "";
		int hits;
		int totalValue;
		int numTrys = 0;
		boolean notFound= true;
		System.out.println("Your guess should be a 5 digit number which may include 0s.");
		System.out.println("Please enter your guess.");
		do 
		{
			numTrys++;
			hits = 0;
			totalValue = 0;
			do
			{
				if(numTrys > 1)
					System.out.println("Please enter your next guess.");
				userPattern = keyboard.nextLine();
			}while(userPattern.length() != 5);
			for (int count = 0; count < 5; count++) 
			{
				if (testPattern.charAt(count) == userPattern.charAt(count))
				{
					hits++;
					totalValue += (int)userPattern.charAt(count) - (int)'0';
				}
			}
			if (hits == userPattern.length()) 
			{
				System.out.println("Congratulations!! You guessed the pattern in "
								+ numTrys + " trys.");
				notFound = false;
				checkScore(numTrys);
			}
			else
			{
				System.out.println(hits + " numbers are correct and their total value is: " + totalValue);
			}
		} while(notFound);
		displayBestScores();
	}
	/**
	 * Description - displays the best palyer's names and scores contained in bestScores[] 
	 * precondition - bestScores[] must exist and contain valid data
	 * postcondition - no change in the state
	 * Algorithm
	 * BEGIN METHOD displayBestScores():RETURNS nothing
	 *   DISPLAY "The best scores are:"
	 *   FOR EACH score object in bestScores[]
	 *     DISPLAY player name and score
	 *   END FOR
	 * END METHOD
	 */
	private void displayBestScores()
	{
		System.out.println("The best scores are:");
		for(Score currentScore: bestScores)
		{
			if(currentScore != null)
			{
				System.out.println(currentScore);
			}
		}
		
	}
	/**
	 * Description - checks the winning score against the saved scores and saves the new score if it is better than any of the saved scores
	 * @param pNumTrys
	 * precondition - state variables bestScore[] and playerOne must exist and have valid data
	 * postcondition - saved score array is updated with up to the current best 5 scores
	 * Algorithm
	 * BEGIN METHOD checkScore(INTEGER newScore):RETURNS nothing
	 *   DECLARE local variables
	 *   Score currentScore
	 *   INTEGER index
	 *   FOR index = 0, index is less than 5, index = index + 1
	 *     SET currentScore to the value at index in the best score array
	 *     IF currentScore is not equal to NULL THEN
	 *       IF currentScore.getScore() is greater than newScore THEN
	 *         make room in the best scores array by shifting the old scores down one
	 *         FOR INTEGER index2 = 4, index2 > index, index2 = index2 - 1
	 *           bestScores[index2] = bestScores[index2 -1]
	 *         END FOR
	 *         bestScores[index] = NEW Score(playerOne, newScore)
	 *         index = 4
	 *       END IF
	 *     ELSE
	 *       bestScores[index] = NEW Score(playerOne, newScore);
	 *       index = 4;
	 *     END IF
	 *   END FOR
	 * END METHOD
	 */
	private void checkScore(int pNumTrys)
	{
		Score currentScore = null;
		for(int index = 0; index < 5; index++)
		{
			currentScore = bestScores[index];
			if(currentScore != null)
			{
				if(currentScore.getScore() > pNumTrys )
				{
					for(int index2 = 4; index2 > index; index2--)
					{
						bestScores[index2] = bestScores[index2 - 1];
					}
					bestScores[index] = new Score(playerOne, pNumTrys);
					index = 4;
				}
			}
			else
			{
			bestScores[index] = new Score(playerOne, pNumTrys);
			index = 4;
			}

		}
		
	}
}
