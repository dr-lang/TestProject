/**
 * 
 */


import interfacePackage.ShapesInterface;
import objectsPackage.Cone;
import objectsPackage.Pyramid4;
import objectsPackage.Triangle;
import objectsPackage.Pyramid3;
import objectsPackage.Square;
import objectsPackage.Cube;
import java.util.Scanner;
/**
 * @author Larry Shannon
 *
 */
public class ShapeGenerator
{
	private static Scanner keyboard = new Scanner(System.in);
	public static ShapesInterface getShape()
	{
		int numberOfShapes = 6; //Change this value to the number of current shapes as you add new shapes.
		int randomValue = (int)(Math.random() * numberOfShapes);
		ShapesInterface newShape = null;
		
		switch(randomValue)
		{
		case 0:
			newShape = new Triangle();
			break;
		case 1:
			newShape = new Cone();
			break;
		case 2:
			newShape = new Pyramid4();
			break;
		case 3:
			newShape = new Pyramid3();
			break;
	case 4:
			newShape = new Square();
			break;
		case 5:
			newShape = new Cube();
			break;
			
		}
		return newShape;
	}

	public static ShapesInterface selectShape()
	{
		ShapesInterface newShape = null;
		boolean shapeNotSelected = true;
		int menuValue = 0;
		double height = 0.0;
		double base = 0.0;
		double radius = 0.0;
		double baseLength = 0.0;
		double baseWidth = 0.0;
		double length = 0.0;
		double width = 0.0;
		do
		{
			shapeNotSelected = false;
		System.out.println("Select from the following shapes:");
		System.out.println("1) Triangle");
		System.out.println("2) Cone");
		System.out.println("3) Pyramid4");
		System.out.println("4) Pyramid3");
		System.out.println("5) Square");
		System.out.println("6) Cube");
		if(!keyboard.hasNextInt())
		{
			keyboard.nextLine();
			menuValue = 0;
		}
		else
		{
		menuValue = keyboard.nextInt();
		keyboard.nextLine();
		}
		switch(menuValue)
		{
		case 1:
			System.out.println("You selected a Triangle.");
			System.out.println("Please enter the length of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the length of the base.");
			}
			base = keyboard.nextDouble();
			System.out.println("Please enter the height of the triangle.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the height of the triangle.");
			}
			height = keyboard.nextDouble();
			keyboard.nextLine();
		
			newShape = new Triangle(height, base);
			break;
		case 2:
			System.out.println("You selected a cone.");
			System.out.println("Please enter the radius of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the radius of the base.");
			}
			radius = keyboard.nextDouble();
			System.out.println("Please enter the height of the cone.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the height of the cone.");
			}
			height = keyboard.nextDouble();
			keyboard.nextLine();
			newShape = new Cone(height, radius);
			break;
		case 3:
			System.out.println("You selected a Pyramid4");
			System.out.println("Please enter the Length of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the length of the base.");
			}
			baseLength = keyboard.nextDouble();
			System.out.println("Please enter the width of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the width of the base.");
			}
			baseWidth = keyboard.nextDouble();
			
			System.out.println("Please enter the height of the pyramid.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the height of the pyramid.");
			}
			height = keyboard.nextDouble();
			keyboard.nextLine();
			
			newShape = new Pyramid4(baseLength, baseWidth, height);
			break;
		case 4:
			System.out.println("You selected a Pyramid3");
			System.out.println("Please enter the Length of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the length of the base.");
			}
			baseLength = keyboard.nextDouble();
			System.out.println("Please enter the width of the base.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the width of the base.");
			}
			baseWidth = keyboard.nextDouble();
			
			System.out.println("Please enter the height of the pyramid.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the height of the pyramid.");
			}
			height = keyboard.nextDouble();
			keyboard.nextLine();
			newShape = new Pyramid3(baseLength, baseWidth, height);
			break;
		case 5:
			System.out.println("You selected a Square.");
			System.out.println("Please enter the length of the square.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the length of the square.");
			}
			length = keyboard.nextDouble();
			System.out.println("Please enter the Width of the square.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the Width of the Square.");
			}
			width = keyboard.nextDouble();
			keyboard.nextLine();
			newShape = new Square(length, width);
			break;
		case 6:
			System.out.println("You selected a cube.");
			System.out.println("Please enter the length of the cube.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the length of the cube.");
			}
			length = keyboard.nextDouble();
			System.out.println("Please enter the Width of the cube.");
			while(!keyboard.hasNextDouble())
			{
				keyboard.nextLine();
				System.out.println("Invalid entry.");;
				System.out.println("Please enter the Width of the cube.");
			}
			width = keyboard.nextDouble();
			keyboard.nextLine();
			newShape = new Cube(length, width);
			break;
			default:
				shapeNotSelected = true;

		}

		}while(shapeNotSelected);
		return newShape;
	}
}
