/**
 * 
 */
package numbersGamePackage;
import java.util.Scanner;
/**
 * @author Larry Shannon
 *
 */
public class gameDriver
{
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String newPlayer = "Sally";
		String yesOrNo = "yes";
		NumbersGame newGame = null;
		new NumbersGame();//This line used to load Scores from a file.
		do
		{
			System.out.println("What is your Name?");
			newPlayer = keyboard.next();
			newGame = new NumbersGame(newPlayer);
			newGame.playMasterMindNumbers();
			System.out.println("Is there another player who would like to play?");
			do
			{
				System.out.println("Please enter \"yes\" or \"no\".");
				yesOrNo = keyboard.next();
				keyboard.nextLine();
			}while(!yesOrNo.equals("yes") && !yesOrNo.equals("no"));
		}while(yesOrNo.equals("yes"));
		System.out.println("Good-bye!\nAnd thank you for playing the Numbers game!");
		NumbersGame.saveTopScores();
	}

}
