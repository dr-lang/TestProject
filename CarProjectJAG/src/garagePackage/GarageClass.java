//Author:Jason Alvarado-Gonzalez

//The work and code for this project are all of my work and it does not contain any
//code received from another source.

package garagePackage;


import java.util.Scanner;

import carPackage.Car;

public class GarageClass extends Car{
	public static Scanner keyboard = new Scanner(System.in);
	
	int parkedCars = 0;
	int size = 0;
	Car[] parking;
	String[] myCars;
	int parkingPosition;
	String createOrRandom;
	
	public  void garage() {
	System.out.println("Welcome to the Car and Garage program");
	System.out.println("Enter the number of parking space you would like to have in the garage.");
	System.out.println("The number should be between 1 and 10 inclusive.");
	Car[]parking = null;
	String stopOrNot = "y";
	while (!keyboard.hasNextInt()) {
		System.out.println("Enter a number.");
	    keyboard.next();
	    System.out.println("The number should be between 1 and 10 inclusive.");
	    
	}
	int size = keyboard.nextInt();
	while(size < 1 || size > 10) {
		System.out.println("The number should be between 1 and 10 inclusive.");
	    size = keyboard.nextInt();
	}
	
    this.size = size;
	parking = new Car[size];
	int index = size - 1;
	
	while (stopOrNot.equals("y")) {
	    System.out.println("A) Refuel a car");
	    System.out.println("B) Get a Car to drive");
	    System.out.println("C) Add a Car");
	    System.out.println("Q) Quit");
	    System.out.println(" select one of the above choices.");
	    String menuChoice = keyboard.next();
	    switch(menuChoice) {
	    
	    case "A":
	    case "a":
	    	if (parking[size - 1] == null) {
		    	  System.out.println("There are no cars currently in the garage.");
		    	  continue;
		    	  }
	    	System.out.println("Which car would you like to add fuel to?");
	    	System.out.println("Please enter the car's parking space number for your selection.");
	    	while (!keyboard.hasNextInt()) {
	    		System.out.println("Enter a number.");
	    	    keyboard.next();
	    	    
	    	}
	    	int spaceNumber = keyboard.nextInt();
	    	while (spaceNumber < 1 || spaceNumber > parking.length){
	    		System.out.println("Please enter a valid space Number between 1 and " + parking.length);
	    		spaceNumber = keyboard.nextInt();
	    	}
	    	
	    	System.out.print("Space " + spaceNumber + ": ");
	    	spaceNumber--;
	    	Car theCar = parking[spaceNumber];
	    	System.out.println(theCar.toString());
	    	System.out.println("How much fuel would you like to add?");
	    	double newFuel = keyboard.nextDouble();
	    	theCar.addFuelToTank(newFuel);
	    	
	    	if (theCar.getFuelLevel() == -1) {
	    		System.out.println("The tank is full. Can take no more gas.");
	    	}
	    	else {
	    	System.out.print(String.format("The tank is not full and can take %.2f more gallons of fuel.", (theCar.getFuelTankSize() - theCar.getFuelLevel())));
	    	System.out.println();
	    	}
	    	break;
	    	
	    case "B":
	    case "b":
	    	if (parking[size - 1] == null) {
	    	  System.out.println("There are no cars currently in the garage.");
	    	  continue;
	    	  }
	    	
	    	System.out.println("Enter space number to select car to drive");
	    	System.out.println("Enter an integer value between 1 and " + (parking.length) + " inclusive.");
	    	spaceNumber = keyboard.nextInt();
	    	spaceNumber--;
	    	Car carToGet = parking[spaceNumber];
	    	if (carToGet == null) {
	    		System.out.println("There is no car in that parking space");
	    		continue;
	    	}
	    	Car returnedCar = getCar(spaceNumber);
	    	System.out.println("How far would you like to drive?");
	    	int driveDistance = keyboard.nextInt();
	    	System.out.print("How fast would you like to drive?");
	    	int driveSpeed = keyboard.nextInt();
	    	carToGet.setUpTrip(driveSpeed, driveDistance);
	    	if (carToGet.driveCar() == true) {
	    		System.out.println("You drove the " + carToGet.getYEAR() +", " + carToGet.getMake() + ", " + carToGet.getModel() + " " + carToGet.getdistanceOfTravel() + " miles and returned it to its parking space.");
	    		parkCar(carToGet);
	    		
	    	}
	    	else {
	    	    System.out.println("The " + carToGet.getModel() + " ran out of fuel.");
	    	    System.out.println("It is parked somewhere on the side of the road.");
	    	}
	    	int copiedIndex = (parking.length) - 1;
    		int iterations = parking.length;
    		spaceNumber = parking.length;
    	    while(iterations > 0) {
    	    	if(parking[copiedIndex] != null) {
    	    	System.out.print("Space " + spaceNumber + ": ");
    	    	System.out.println(parking[copiedIndex].toString());
    	    	copiedIndex--;
    	    	iterations--;
    	    	spaceNumber--;
    	    	continue;
    	    	}
	    	
	    	}
	    	
	    case "C":
	    case "c":
	    	if (index < 0) {
	    		copiedIndex = (parking.length) - 1;
	    		iterations = parking.length;
	    		spaceNumber = parking.length;
	    		while(iterations > 0) {
	    	    	if(parking[copiedIndex] != null) {
	    	    	System.out.print("Space " + spaceNumber + ": ");
	    	    	System.out.println(parking[copiedIndex].toString());
	    	    	copiedIndex--;
	    	    	iterations--;
	    	    	spaceNumber--;
	    	    	continue;
	    	    	}
	    	    	
	    	    }
	    		System.out.println("There are no free parking spaces to add a new car.");
		    	continue;
		    }
	    	if (parking[index] == null) {
	    	    
	    	
	    	do {
	    		
	    		
	    	System.out.println("Would you like to input the data yourself or create a random car?");
	    	System.out.println("Please enter \"c\" for create yourself or \"r\" for random car.");
	    	createOrRandom = keyboard.next();
	    	this.createOrRandom = createOrRandom;
	    	if (createOrRandom.equals("c")) {
	    	    System.out.println("Input the year of the car?");
	    	    System.out.println("Please enter a date between 1920 and 2021.");
	    	    int year = keyboard.nextInt();
	    	    
	    	    System.out.println("Please enter the Make of the car.");
	    	    String make = keyboard.next();
	    	    System.out.println("Please enter the Model of the car.");
	    	    String model = keyboard.next();
	    	    System.out.println("Please enter the color of the car.");
	    	    String color = keyboard.next();
	    	    
	    	    System.out.println("Input the size of the car's fuel tank.");
	    	    System.out.println("Please enter a value between 8.0 and 34.99.");
	    	    double tankSize = keyboard.nextDouble();
	    	    
	    	    System.out.println("Input the car's optimal driving speed for best mileage.");
	    	    System.out.println("Please enter a value between 45.0 and 64.99.");
	    	    double optimalSpeed = keyboard.nextDouble();
	    	    
	    	    System.out.println("Input the car's fuel economy.");
	    	    System.out.println("Please enter a value between 15.0 and 54.99.");
	    	    double fuelEconomy = keyboard.nextDouble();
	    	    
	    	    Car createdCar = new Car(make, model, color, year, tankSize, fuelEconomy, optimalSpeed);
	    	    parking[index] = createdCar;
	    	    this.parking = parking;
	    	    index--;
	    	    
	    	
	    	    break;
	    	}
	    	else if(createOrRandom.equals("r")) {
	    		Car randomCar = new Car();
	    		parking[index] = randomCar;
	    		this.parking = parking;
	    		System.out.println(index);
	    		parkedCars++;
	    		index--;
	    		
	    		copiedIndex = (parking.length) - 1;
	    		iterations = parking.length;
	    		spaceNumber = parking.length;
	    	    while(iterations > 0) {
	    	    	if(parking[copiedIndex] != null) {
	    	    	System.out.print("Space " + spaceNumber + ": ");
	    	    	System.out.println(parking[copiedIndex].toString());
	    	    	copiedIndex--;
	    	    	iterations--;
	    	    	spaceNumber--;
	    	    	continue;
	    	    	}
	    	    	
	    	    break;
	    		}
	    	    
	    	}
	    	
	    	
	    	
	    	}while(!createOrRandom.equals("r") && !createOrRandom.equals("c"));
	    	
	    }
	    	continue;
	    	
	    case "Q":
	    case "q":
	    	System.out.print("Thank you for using this garage!");
	    	
	    	break;
	    	
	    default:
	    	System.out.println("Invalid menu choice");
	    }	
	    
	    
	    do {
	    System.out.println("Would you like to repeat this program?");
	    System.out.println("Please enter \"y\" for yes or \"n\" for no.");
	    stopOrNot = keyboard.next();
	    
	    }while(!stopOrNot.equals("y") && !stopOrNot.equals("n"));
	    
	    if (index < 0) {
	    	break;
	    }
	}
		
	

}
    public boolean parkCar(Car pCar) {
    	int index;
    	for(index = 0; index < parking.length; index++)
    	if (parking[index] == null) {
    		parking[index] = pCar;
    		parkedCars++;
    		return true;
    	}
    		System.out.println("Not enough space for car.");
    		
    		return false;
    	}
		
    
    public double refuelCar(double spaceNumber) {
		double newFuel = keyboard.nextInt();
		
		return addFuelToTank(newFuel);
	}
    public Car getCar(int pSlot) {
    	pSlot-= 1;
    	Car returnCar = parking[pSlot];
    	parkedCars--;
    	parking[pSlot] = null;
    	return returnCar;
    	
    }
    
    }
