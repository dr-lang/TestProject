//Author:Jason Alvarado-Gonzalez
//The work and code for this project are all of my work and it does not contain any
//code received from another source.

package carPackage;
import java.text.DecimalFormat;

import interfacePackage.CarInterface;

public class Car extends Object implements CarInterface{
    private static final String[][] MAKES_MODELS = {{"Mercedes-Benz", "A-Class"},{"Dodge", "Challenger"},{"Jeep", "Cherokee"}};
    private static final String[] colorOfCar = {"Silver", "White", "Black"};
    private final String MAKE;
    private final String MODEL;
    private final int YEAR;
    private final double tankSize;
    private final double fuelEconomy;
    private final double optimalSpeed;
    private double odometer = 0.0;
    private double tripOdometer = 0.0;
    private String color = null;
    private double fuelLevel = 0.0;
    private double speedOfTravel = 0.0;
    private double distanceOfTravel = 0.0;
    private int spaceNumber = 0;
	
	
    public Car() {
    	int randomMake = (int)(Math.random() * MAKES_MODELS.length);
    	int randomModel = (int)(Math.random() * MAKES_MODELS[randomMake].length - 1) + 1;
    	int randomColor = (int)(Math.random() * colorOfCar.length);
        this.fuelEconomy = Math.random() * 40 + 15;
        this.odometer = Math.random() * 6;
        this.tankSize = Math.random() * 27 + 8;
        this.MAKE = MAKES_MODELS[randomMake][0];
        this.MODEL = MAKES_MODELS[randomMake][randomModel];
        this.color = colorOfCar[randomColor];
        this.YEAR = (int)(Math.random() * 116) + 1908;
        this.optimalSpeed = Math.random() * 20 + 45;
        this.speedOfTravel = Math.random() * 65;
        this.distanceOfTravel = Math.random() * 300;
        this.fuelLevel = Math.random() * tankSize;
    }
    
    public Car(String make, String model, String color, int year, double tankSize, double fuelEconomy, double optimalSpeed) {
    	this.MAKE = make;
    	this.MODEL = model;
    	this.color = color;
    	this.YEAR = year;
    	this.tankSize = tankSize;
    	this.fuelEconomy = fuelEconomy;
    	this.optimalSpeed = optimalSpeed;
    	this.odometer = Math.random() * 6;
    	this.fuelLevel = Math.random() * tankSize;
    }
    
    public Car(Car original) {
    	this.MAKE = original.MAKE;
    	this.MODEL = original.MODEL;
    	this.color = original.color;
    	this.YEAR = original.YEAR;
    	this.tankSize = original.tankSize;
    	this.fuelEconomy = original.fuelEconomy;
    	this.optimalSpeed = original.optimalSpeed;
    	this.odometer = Math.random() * 6;
    	this.fuelLevel = Math.random() * tankSize;
    	
    }
    public Car(String color, String make, String model, double tankSize, double fuelEconomy) {
    	this.color = color;
    	this.MAKE = make;
    	this.MODEL = model;
    	this.color = color;
    	this.tankSize = tankSize;
    	this.fuelEconomy = fuelEconomy;
    	this.YEAR = (int)(Math.random() * 116) + 1908;
    	this.optimalSpeed = Math.random() * 20 + 45;
    	this.odometer = Math.random() * 6;
    	this.fuelLevel = Math.random() * tankSize;
    }
    
    
    @Override
	public double addFuelToTank(double newFuel) {
    	double storageLeft = tankSize - fuelLevel;
		if (newFuel <= storageLeft) {
			fuelLevel = fuelLevel + newFuel;
		}
		else {
			fuelLevel = -1;
		}
		return fuelLevel;
    }
    @Override
    public String toString() {
    	spaceNumber += 1;
    	return String.format("%d, %s, %s, %s, with %.2f gallons of gas in the tank, %.2f miles\non the odometer, and %.2f miles on the trip odometer.", YEAR, color, MAKE, MODEL, fuelLevel, odometer, tripOdometer);
    }
    
    public boolean equals(Car pCarObject) {
		boolean areEqual = false;
		if(this.YEAR == pCarObject.YEAR) {
			areEqual = true;
			if(this.MAKE == pCarObject.MAKE) {
				areEqual = true;
				if(this.MODEL == pCarObject.MODEL) {
					areEqual = true;
				}
			}
		}
		return areEqual;
	}
	@Override
	public boolean driveCar() {
		boolean enoughFuel = false;
		double fuelNeeded = (distanceOfTravel / fuelEconomy);
		double optimalMpg = (fuelEconomy / optimalSpeed);
        double minimumMpg = 3.0;
        double rangeMpg = 0.0;
        double fuelLeft = 0.0;
        
		if (speedOfTravel < optimalSpeed) {
			rangeMpg = optimalMpg - minimumMpg;
			fuelNeeded = rangeMpg / distanceOfTravel;
		    
		}
		else if (speedOfTravel > optimalSpeed){
			double maxSpeed = speedOfTravel;
			double alteredSpeed = maxSpeed - optimalSpeed;
			double maxMpg =  fuelNeeded/ alteredSpeed;
			rangeMpg = optimalMpg - maxMpg;
			fuelNeeded = rangeMpg / distanceOfTravel;
			
		}
		if (fuelLevel - fuelNeeded >= 0) {
			enoughFuel = true;
			fuelLeft = fuelLevel - fuelNeeded;
		}
		else if (fuelLevel - fuelNeeded < 0) { 
			enoughFuel = false;
			fuelLeft = -1;
			
		}
		return enoughFuel;
	}
	@Override
	public double getTripOdometer() {
		DecimalFormat newFormat = new DecimalFormat("#.#");
		newFormat.format(distanceOfTravel);
		return distanceOfTravel;
	}
	@Override
	public void clearTripOdometer() {
		tripOdometer = 0.0;	
	}
	@Override
	public double getOdometer() {
		DecimalFormat newFormat = new DecimalFormat("#.#");
		double totalOdometer = odometer + distanceOfTravel;
		newFormat.format(totalOdometer);
		return totalOdometer;
	}
	@Override
	public double getFuelLevel() {
		// TODO Auto-generated method stub
		return fuelLevel;
	}
	@Override
	public double getFuelTankSize() {
		// TODO Auto-generated method stub
		return tankSize;
	}
	@Override
	public void setUpTrip(double speedOfTravel, double distanceOfTravel) {
		this.speedOfTravel = speedOfTravel;
		this.distanceOfTravel = distanceOfTravel;
		
	}

	@Override
	public double getOptimalSpeed() {
		
		return optimalSpeed;
	}

	@Override
	public double getMPG() {
		// TODO Auto-generated method stub
		return (fuelEconomy / optimalSpeed);
	}

	@Override
	public int getYEAR() {
		// TODO Auto-generated method stub
		return YEAR;
	}

	@Override
	public String getMake() {
		// TODO Auto-generated method stub
		return MAKE;
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return MODEL;
	}

	@Override
	public double getdistanceOfTravel() {
		// TODO Auto-generated method stub
		return distanceOfTravel;
	}

	
}
