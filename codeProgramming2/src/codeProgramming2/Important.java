package codeProgramming2;
import java.util.*;
public class Important {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
    	//CombinedString();
    	//loveWithoutHate();
    	//fav();
    	//gallons();
    	bmrCalculator();
}
    private static void CombinedString() {
        String firstString = keyboard.nextLine();
        String secondString = keyboard.nextLine();
        String AlteredString1 = firstString.concat(" ");
        String newString = AlteredString1.concat(secondString);
        int newLength = newString.length();
        System.out.print(newString);
        System.out.print(newLength);
    }
    private static void loveWithoutHate() {
    	String sentence = keyboard.nextLine();
    	String newSentence = sentence.replaceFirst("hate", "love");
    	System.out.println(newSentence);
    	
    }
    private static void fav() {
        String favColor = keyboard.nextLine();
        String favFood = keyboard.nextLine();
        String favAnimal = keyboard.nextLine();
        String friend = keyboard.nextLine();
        System.out.printf("I had a dream that %s ate a %s %s and said it tasted like %s!\n", friend, favColor, favAnimal, favFood);
    }
    private static void gallons() {
        double radius = keyboard.nextInt();
        double depth = keyboard.nextInt();
        double radiusToFeet = radius / 12;
        double cubicFootGallons = 7.48;
        double pi = Math.PI;
        double volume = pi * (Math.pow(radiusToFeet, 2)) * depth;
        double Ingallons = volume * cubicFootGallons;
        System.out.printf("%.0f gallons", Ingallons, "\n");
    }
   private static void bmrCalculator() {
        
        }
   
   }

