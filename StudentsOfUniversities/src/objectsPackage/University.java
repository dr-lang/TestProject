package objectsPackage;

import java.io.Serializable;

public class University implements Serializable, Comparable<University>{
	
    private final String university;
	private final String streetAddress;
	private final String cityAddress;
	private final String stateAddress;
	private final int zip;
	private final String phoneNumber;
	private final double instateTuition_1_To_11;
	private final double instateTuition_12_To_18;
	private final double instateTuitionOver18;
	private final double outOfStateTuition_1_To_11;
	private final double outOfStateTuition_12_To_18;
	private final double outOfStateTuitionOver18;
	private double studentCostMealPlanA = 0.0;
	private double studentCostMealPlanB = 0.0;
	private double studentCostMealPlanC = 0.0;
	private double lateFeeRate = 0.0;
	private double incedentalFeeRate = 0.0;
	private double incedentalFeeMax = 0.0;
	private double healthCare_1_To_10 = 0.0;
	private double healthCare_11_To_15 = 0.0;
	private double healthCareOver15 = 0.0;
	private int totalStudents = 0;
	private int totalInstateStudents = 0;
	private int totalOutOfStateStudents = 0;
	private int totalMealsA = 0;
	private int totalMealsB = 0;
	private int totalMealsC = 0;
	private double totalCostOfMealsA = 0;
	private double totalCostOfMealsB = 0;
	private double totalCostOfMealsC = 0;
	private double costOfAllMeals = 0;
	private double totalTuition = 0;
	private double totalLateFees = 0;
	private double totalIncedentalFees = 0;
	private double totalHealthCare = 0;
	private double totalCosts = 0;
	
	public University(String pUniversityName,String pStreetAddress, String pCityAddress,String pStateAddress, int pZIPAddress,
			String pPhoneNumber, double pInstateTuition1To11, double pInstateTuition12To18, double pInstateTuitionOver18,
			double pOutOfStateTuition1To11, double pOutOfStateTuition12To18, double pOutOfStateTuitionOver18,double pStudentCostMealPlanA,
			double pStudentCostMealPlanB, double pStudentCostMealPlanC, double pHealthCare1To10, double pHealthCare11To15, double pHealthCareOver15,
			double pLateFeeRate, double pIncedentalFeeRate, double pIncedentalFeeMax)
	{
		university = pUniversityName;
		streetAddress = pStreetAddress;
		cityAddress = pCityAddress;
		stateAddress = pStateAddress;
		zip = pZIPAddress;
		phoneNumber = pPhoneNumber;
		instateTuition_1_To_11 = pInstateTuition1To11;
		instateTuition_12_To_18 = pInstateTuition12To18;
		instateTuitionOver18 = pInstateTuitionOver18;
		outOfStateTuition_1_To_11 = pOutOfStateTuition1To11;
		outOfStateTuition_12_To_18 = pOutOfStateTuition12To18;
		outOfStateTuitionOver18 = pOutOfStateTuitionOver18;
		studentCostMealPlanA = pStudentCostMealPlanA;
		studentCostMealPlanB = pStudentCostMealPlanB;
		studentCostMealPlanC = pStudentCostMealPlanC;
		lateFeeRate = pLateFeeRate;
		incedentalFeeRate = pIncedentalFeeRate;
		incedentalFeeMax = pIncedentalFeeMax;
		healthCare_1_To_10 = pHealthCare1To10;
		healthCare_11_To_15 = pHealthCare11To15;
		healthCareOver15 = pHealthCareOver15;
		
	}
	
	public double getInstateTuition_1_To_11()
	{
		return 102.50;
	}
		
	public double getInstateTuition_12_To_18()
	{
		return 75.45;
	}
	
	public double getInstateTuitionOver18()
	{
		return 93.00;
	}
	
	public double getOutOfStateTuition_1_To_11()
	{
		return 351.00;
	}
		
	public double getOutOfStateTuition_12_To_18()
	{
		return 255.00;
	}
	
	public double getOutOfStateTuitionOver18()
	{
		return 304.00;
	}
	
	public double getIncedentalFeeRate()
	{
		return 20;
	}
	
	public double getIncedentalFeeMax()
	{
		return 250.00;
	}
	public double getHealthCare_1_To_10()
	{
		return 25.00;
	}
	
	public double getHealthCare_11_To_15()
	{
		return 20.00;
	}
	
	public double getHealthCareOver15()
	{
		return 15.00;
	}
	
	public double getStudentCostMealPlanA()
	{
		totalMealsA++;
		
		return 4999.00;
	}
	
	public double getStudentCostMealPlanB()
	{
		totalMealsB++;
		
		return 3499.00;
	}
	
	public double getStudentCostMealPlanC()
	{
		totalMealsC++;
		
		return 2599.00;
	}
	
	public int getTotalMealsA()
	{
		return totalMealsA;
	}
	
	public int getTotalMealsB()
	{
		return totalMealsB;
	}
	
	public int getTotalMealsC()
	{
		return totalMealsC;
	}
	
	public double getTotalCostOfMealA()
	{
		totalCostOfMealsA = totalMealsA * 4999.00;
		
		return totalCostOfMealsA;
	}
	
	public double getTotalCostOfMealsB()
	{
		totalCostOfMealsB = totalMealsB * 3499.00;
		
		return totalCostOfMealsB;
	}
	
	public double getTotalCostOfMealsC()
	{
		totalCostOfMealsC = totalMealsC * 2599.00;
		return totalCostOfMealsC;
	}
	
	public double getTotalCostOfAllMeals()
	{
		totalCostOfMealsA = totalMealsA * 4999.00;
		totalCostOfMealsB = totalMealsB * 3499.00;
		totalCostOfMealsC = totalMealsC * 2599.00;
		costOfAllMeals = totalCostOfMealsA + totalCostOfMealsB + totalCostOfMealsC;
		
		return costOfAllMeals;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String toString()
	{
		return String.format("%s", university);
	}
	
	public String getUniversityName()
	{
		return university;
	}
	
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	public String getCityAddress()
	{
		return cityAddress;
	}
	
	public String getStateAddress()
	{
		return stateAddress;
	}
	
	public int getZip()
	{
		return zip;
	}
	
	public void updateTotals(Student pCurStudent)
	{
		totalStudents++;
	}
	
	public void updateTotalTuition(double pTuition)
	{
		this.totalTuition = this.totalTuition + pTuition;
			
	}
	
	public double getTotalTuition()
	{
		return totalTuition;
	}
	
	public void updateLateFees(double pLateFee)
	{
		totalLateFees = totalLateFees + pLateFee;
		
	}
	
	public double getTotalLateFees()
	{
		return totalLateFees;
	}
	
	public void updateIncedentalFees(double pIncedentalFee)
	{
		this.totalIncedentalFees = this.totalIncedentalFees + pIncedentalFee;
	}
	
	public double getTotalIncedentalFees()
	{
		return totalIncedentalFees;
	}
	
	public void updateTotalHealthCare(double pHealthCare)
	{
		this.totalHealthCare = this.totalHealthCare + pHealthCare;
	}
	
	public double getTotalHealthCare()
	{
		return totalHealthCare;
	}
	
	public void updateTotalCosts(double pTotalCosts)
	{
		this.totalCosts = this.totalCosts + pTotalCosts;
	}
	
	public double getTotalCosts()
	{
		return totalCosts;
	}
	
	public void updateInstate()
	{
		totalInstateStudents++;
	}
	
	public void updateOutOfState()
	{
		totalOutOfStateStudents++;
	}
	
	public int getTotalStudents()
	{
		return totalStudents;
	}
	
	public int getTotalOutOfState()
	{
		return totalOutOfStateStudents;
	}
	
	public int getTotalInstate()
	{
	return totalInstateStudents;
	}
	
	public int compareTo(University pUniversity)
	{
		int sortValue = this.getUniversityName().compareTo(pUniversity.getUniversityName());
		return sortValue;
		
	}
	public boolean equals(University pObject) 
	{
		boolean trueOrFalse = false;
		if (this.getUniversityName() == pObject.getUniversityName())
			trueOrFalse = true;
		return trueOrFalse;
		
	}
}
