//Author:Jason Alvarado-Gonzalez
//The work and code for this project are all of my work and it does not contain any
//code received from another source.

/**
 * 
 */
package interfacePackage;

import carPackage.Car;

/**
 * @author jason
 *
 */
public interface CarInterface {
	
    //Adds fuel to the car's fuel tank
    //Precondition: Car’s fuel tank contains form 0.0 to tank size gallons of fuel
    //Postcondition: Car's fuel tank may have added fuel
	//Parameter available fuel to add to fuel tank
	//returns:
	//    a: Negative number indicating the amount of fuel the tank will still take
	//    b: Positive (nonzero) value of the amount of argument fuel not used
	//    c: if 0 argument fuel just filled the tank
	double addFuelToTank(double newFuel);
	
	public String toString();
	/**
	*Converts the Car object's state variables to a String representation
	*Precondition: All state variables are initialized
	*Postcondition: no change
	*Returns a string representation of state variables
	*/


	public boolean equals(Car pCarObject);
	/**
	 *Checks to see if a select set of the calling Car’s and the argument Car’s state variables have the same values 
	 *Precondition: Both the calling Car and argument Car are fully initialized
	 *Postcondition: no change
	 *parameter pCarObject
	 *returns true if the calling Car and the argument Car have the same state values for year, make, and model, else returns false
     */
	
	public boolean driveCar();
	/**
	 *drives the Car a predefined distance and speed.
	 *Precondition: Car's trip state variables have been initialized
	 *Postcondition: Car's fuel is reduced proportional to the distance and speed driven or depleted if the distance and speed combination is too great. Odometer and trip odometer are updated with the miles traveled added. Car's trip state variables, distance of travel and speed of travel, are set to zero.
	 *Return: true if the car travels the distance, false if the car runs out of fuel before traveling the distance. 
	 *Hint: distance/fuel economy = fuel needed to make the trip.
	 */

	public double getTripOdometer();
	/**
	 *gets trip odometer
	 *Precondition: none
	 *Postcondition: no change of state
	 *Return: double value of trip odometer to tenth of mile precision
	 *Hint: value % .1 returns the remainder(values less than .1)
	 */

	public void clearTripOdometer();
	/**sets trip odometer mileage to 0.0
	 *Precondition: none
	 *Postcondition: trip odometer set to 0.0
	 */ 

	public double getOdometer();
	/**gets odometer mileage
	 *Precondition: none
	 *Postcondition: no change to state
	 *Return: double value of odometer to nearest tenth of mile ( See hint for trip odometer )
     */
	
	public double getFuelLevel();
	/**retrieves fuel level in gallons
	 *Precondition: fuel level is initialized
	 *Postcondition: no change in state
	 *Return: fuel level in gallons with decimal values
     */
	
	public double getFuelTankSize();
	/**retrieves fuel level in gallons
	 *Precondition: fuel level is initialized
	 *Postcondition: no change is state
	 *Return: fuel level in gallons with decimal values
	 */

	public void setUpTrip(double speedOfTravel, double distanceOfTravel);
	/**Car's state is set to hold the speed of travel and distance to travel at that speed
	 *Precondition: none
	 *Postcondition: Car's state holds information on distance to travel and speed to travel
	 *Parameters:  Average Speed to be driven, Distance to drive
     */
	public double getOptimalSpeed();
	/** Get the optimal speed.
     */
	
	public double getMPG();
	/**Gets the MPG.
     */
	
	public int getYEAR();
	/**Gets the year of the car.
     */
	
	public String getMake();
	/**Gets the make of the car.
     */
	
	public String getModel();
	/**gets the model of the car.
     */
	
	public double getdistanceOfTravel();
	/**gets the distance the car is going to travel or traveled.
     */
	
	
}