package objectsPackage;
import java.io.Serializable;

public class Student extends Person implements Serializable, Comparable<Student>{
	private static final long serialVersionUID = 1L;
	private final String university;
	private final int credits;
	private final char instate;
	private final char healthPlan;
	private final char foodPlan;
	private final char lateFees;
	private final String ID;
	private double tuition = 0.0;
	private double foodCost = 0.0;
	private double lateFee = 0.0;
	private double healthCare = 0.0;
	private double incidentalFees = 0.0;
	private double totalCosts = 0.0;

	public Student(String pFirstName, String pMiddleName, String pLastName, int pAge, char pGender,
			String pStreetAddress, String pCity, String pState, int pZip, String pPhone,
			String pUniversity, String pStudentId, int pCredits, char pInstate, char pHealthPlan,
			char pFoodPlan, char pLateFees)
	{
		super(pFirstName, pMiddleName, pLastName, pAge, pGender, pStreetAddress, pCity, pState, pZip, pPhone);
		
		university = pUniversity;
		ID = pStudentId;
		credits = pCredits;
		instate = pInstate;
		healthPlan = pHealthPlan;
		foodPlan = pFoodPlan;
		lateFees = pLateFees;
	}
	public void calculateCosts(University pUniversity)
	{
		if (this.instate == 'Y' || this.instate == 'y')
		{
			if(this.credits < 12)
				tuition = credits * pUniversity.getInstateTuition_1_To_11();
			else if (this.credits < 19)
				tuition = credits * pUniversity.getInstateTuition_12_To_18();
			else
				tuition = credits * pUniversity.getInstateTuitionOver18();
		}
		else
		{
			if (this.credits < 12)
				tuition = credits * pUniversity.getOutOfStateTuition_1_To_11();
			else if (this.credits < 19)
				tuition = credits * pUniversity.getOutOfStateTuition_12_To_18();
			else
				tuition = credits * pUniversity.getOutOfStateTuitionOver18();
			
		}
		if (this.lateFees == 'Y' || this.lateFees == 'y')
			lateFee = tuition * 0.1;
		    pUniversity.updateLateFees(lateFee);
		    
		this.incidentalFees = credits * pUniversity.getIncedentalFeeRate();
		if (this.incidentalFees > pUniversity.getIncedentalFeeMax())
			this.incidentalFees = pUniversity.getIncedentalFeeMax();
		    pUniversity.updateIncedentalFees(incidentalFees);
		if(this.healthPlan == 'Y' || this.healthPlan == 'y')
			if(this.credits < 11)
				this.healthCare = this.credits * pUniversity.getHealthCare_1_To_10();
			else if (this.credits <= 15)
				this.healthCare = this.credits * pUniversity.getHealthCare_11_To_15();
			else
				this.healthCare = this.credits * pUniversity.getHealthCareOver15();
		
		pUniversity.updateTotalHealthCare(this.healthCare);
		switch(this.foodPlan)
		{
		case 'A':
		case 'a':
			this.foodCost = pUniversity.getStudentCostMealPlanA();
			break;
		case 'B':
		case 'b':
			this.foodCost = pUniversity.getStudentCostMealPlanB();
			break;
		case 'C':
		case 'c':
			this.foodCost = pUniversity.getStudentCostMealPlanC();
			break;
		}
		this.totalCosts = this.tuition + this.foodCost + this.healthCare;
		
		pUniversity.updateTotalCosts(this.totalCosts);
		
		if (this.instate == 'Y' || this.instate == 'y')
		{
			pUniversity.updateInstate();
			
		}
		else
		{
			pUniversity.updateOutOfState();
		}
		
	}
		
	
	public double getTuition()
	{
		return tuition;
	}
	
	public double getFoodCost()
	{
		return foodCost;
	}
	
	public double getLateFee()
	{
		return lateFee;
	}
	
	public double getHealthCare()
	{
		return healthCare;
	}
	
	public double getIncidentalFees()
	{
		return incidentalFees;
	}
	
	public double getTotalCosts()
	{
		return totalCosts;
	}
	
	public String getUniversity()
	{
		return university;
	}
	
	
	public char getInstate()
	{
		return instate;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public char getHealthPlan()
	{
		return healthPlan;
	}
	
	public char getFoodPlan()
	{
		return foodPlan;
	}
	
	public char getLateFees()
	{
		return lateFees;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public int compareTo(Student pOther)
	{
		int sortValue = super.compareTo((Person) pOther);
		if (sortValue == 0)
		{
			sortValue = this.getID().compareTo(pOther.getID());
			
		}
		return sortValue;
	}
	
	public boolean equals(Object pObject)
	{
		Student pStudent = (Student) pObject;
		
		return this.compareTo(pStudent) == 0;
	}
	
	public String toString()
	{
		return String.format("%s", this.getFullName());
	}
	
	public String getAddress()
	{
		return super.getFullAddress();
	}
	
	public String getFormattedPhoneNumber()
	{
		return String.format("(%s)%s-%s", this.getPhone().substring(0,3), this.getPhone().substring(3,6),
			   this.getPhone().substring(6,9));
	}
	
	
}

