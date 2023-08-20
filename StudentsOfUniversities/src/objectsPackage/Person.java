package objectsPackage;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private final FullName FULL_NAME;
	private int age = 17;
	private final char gender;
	private final String streetAddress;
	private final String city;
	private final String state;
	private final int zip;
	private String phone;
	public Person(String fName, String mName, String lName, int pAge, char pGender, String pStreetAddress,
			String pCity, String pState, int pZip, String pPhone)
	{
		FULL_NAME = new FullName(fName, mName, lName);
		this.age = pAge;
		gender = pGender;
		streetAddress = pStreetAddress;
		city = pCity;
		state = pState;
		zip = pZip;
		phone = pPhone;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public static long getSerialversionUID()
	{
		return serialVersionUID;
	}
	
	public String getFullName()
	{
		return FULL_NAME.toString();
	}
	
	public String getFirstName()
	{
		return FULL_NAME.getFirstName();
	}
	
	public String getMiddleName()
	{
		return FULL_NAME.getMiddleName();
	}
	
	public String getLastName() {
		return FULL_NAME.getLastName();
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public char getGender()
	{
		return gender;
	}

	public String getFullAddress()
	{
		return String.format("%s, %s, %s %s", this.streetAddress, this.city, this.state, this.zip);
	}
	
	public String toString()
	{
		return String.format("%s", this.FULL_NAME);
	}
	
	public int compareTo(Person pOther)
	{
		int sortValue = this.getFirstName().compareTo(pOther.getFirstName());
		
		if (sortValue == 0)
		{
				sortValue = this.getMiddleName().compareTo(pOther.getMiddleName());
			if (sortValue == 0) 
			{
				sortValue = this.getLastName().compareTo(pOther.getLastName());
			
			    if (sortValue == 0)
			    {
				    if(this.getAge() > pOther.getAge())
					    sortValue = 1;
				    else if(this.getAge() < pOther.getAge())
					    sortValue = -1;
			
			
			        if (sortValue == 0)
			        {   
				        if (this.getGender() > pOther.getGender())
				        {
					        sortValue = 1;
				        }
				        else if (this.getGender() < pOther.getGender())
				        {
					        sortValue = -1;
				        }
			        }
			    }
			}
			
		}
		return sortValue;
	}
	
	public String equals()
	{
		return null;
	}
}
