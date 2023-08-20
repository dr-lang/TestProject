/**I could not fix this issue of the CarTester not working.
 * 
 */
package testerPackage;

import carPackage.Car;

/**
 * @author Larry Shannon
 *
 */
public class CarTester
{

	/**
	 * @param args
	 * This test program uses simple sequential logic to test some of the methods and fields of the Car class.
	 * if statements are used to check object creation and equality.
	 */
	public static void main(String[] args)
	{
		Car[] parkingSpaces = new Car[3];
		Car myCarOne = null;
		Car myCarTwo = null;
		Car myCarThree = null;
		Car myCloneCar = null;
		Car mySameCar = null;
		double drivingDistance = 0.0;
		double drivingSpeed = 0.0;
		parkingSpaces[0] = new Car();// Create a new default Car object.
		mySameCar = parkingSpaces[0];
		System.out.printf("Car One: %s \n", parkingSpaces[0]);// Uses the .toString() method.
		System.out.printf("Same Car: %s \n", mySameCar);// Uses the .toString() method.

		if (parkingSpaces[0].equals((Object) mySameCar))
			System.out.println("The the two cars are in fact the same Car object.");
		else
			System.out.println("The the two cars are different Car objects.");
		parkingSpaces[1] = new Car();// Create a new default Car object.
		System.out.printf("Car One: %s \n", parkingSpaces[0]);// Uses the .toString() method.
		System.out.printf("Car Two: %s \n", parkingSpaces[1]);// Uses the .toString() method.

		if (parkingSpaces[0].equals((Object) parkingSpaces[1]))
			System.out.println("The the two cars are in fact the same Car object.");
		else
			System.out.println("The the two cars are different Car objects.");

		if (parkingSpaces[0].equals(parkingSpaces[1]))
		{
			System.out.println("The the two cars are the same make, model, color, and year.");
		} else
			System.out.println("The the two cars are not the same make, model, color, and year.");
		parkingSpaces[2] = new Car("Red", "Ford", "Model T", 20.0, 25.0);// Create a new "red" Car object.
		System.out.printf("Car One: %s \n", parkingSpaces[0]);// Uses the .toString() method.
		System.out.printf("Car Three: %s \n", parkingSpaces[2]);// Uses the .toString() method.

		if (parkingSpaces[0].equals((Object) parkingSpaces[2]))
			System.out.println("The the two cars are in fact the same Car object.");
		else
			System.out.println("The the two cars are different Car objects.");
		if (parkingSpaces[0].equals(parkingSpaces[2]))
		{
			System.out.println("The the two cars are the same make, model, color, and year.");
		} else
			System.out.println("The the two cars are not the same make, model, color, and year.");
		myCloneCar = new Car(parkingSpaces[0]);// Uses the Car objects state date to create a new Car object.
		System.out.printf("Car One: %s \n", parkingSpaces[0]);// Uses the .toString() method.
		System.out.printf("Car Clone: %s \n", myCloneCar);// Uses the .toString() method.

		if (parkingSpaces[0].equals((Object) myCloneCar))
			System.out.println("The the two cars are in fact the same Car object.");
		else
			System.out.println("The the two cars are different Car objects.");

		if (parkingSpaces[0].equals(myCloneCar))
		{
			System.out.println("The the two cars are the same make, model, color, and year.");
		} else
			System.out.println("The the two cars are not the same make, model, color, and year.");
		mySameCar = parkingSpaces[0];// Copy the memory ID of the Car object stored in myCarOne into myExtraCar.
		System.out.printf("Car One: %s \n", parkingSpaces[0]);// Uses the .toString() method.
		System.out.printf("Same Car object: %s \n", mySameCar);// Uses the .toString() method.

		if (parkingSpaces[0].equals((Object) mySameCar))
			System.out.println("The the two cars are in fact the same Car object.");
		else
			System.out.println("The the two cars are different Car objects.");

		if (parkingSpaces[0].equals(mySameCar))
		{
			System.out.println("The the two cars are the same make, model, color, and year.");
		} else
			System.out.println("The the two cars are not the same make, model, color, and year.");

		System.out.printf("%s\n",parkingSpaces[0]);
		System.out.printf("%s\n",parkingSpaces[1]);
		System.out.printf("%s\n",parkingSpaces[2]);
		System.out.println("Let's take a car out for a drive!");
		System.out.printf("I have chosen to drive the %s.\n", parkingSpaces[0]);
		System.out.printf("That car only has %.1f gallons of fuel.\n", parkingSpaces[0].getFuelLevel());
		System.out.println("We will fill the gas tank, with 3 gallons of fuel.");
		parkingSpaces[0].addFuelToTank(3.0);
		System.out.printf("That car now has %.1f gallons of fuel.\n", parkingSpaces[0].getFuelLevel());
		drivingDistance = parkingSpaces[0].getFuelLevel() * parkingSpaces[0].getMPG();
		drivingSpeed = parkingSpaces[0].getOptimalSpeed();
		System.out.printf("We can drive that car %.1f miles at its optamal speed of %.1f MPH.\n", drivingDistance,
				drivingSpeed);

		parkingSpaces[0].setUpTrip(drivingSpeed, drivingDistance - 10);
		System.out.printf("We drove that car %.1f miles.\n", drivingDistance -10);

		System.out.printf("And made it back to the garage with %.1f gallons of fuel.\n", parkingSpaces[0].getFuelLevel());
		System.out.println("The state of the cars are now.");
		System.out.printf("%s\n",parkingSpaces[0]);
		System.out.printf("%s\n",parkingSpaces[1]);
		System.out.printf("%s\n",parkingSpaces[2]);




	}

}
