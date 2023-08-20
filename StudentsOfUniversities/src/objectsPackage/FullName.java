package objectsPackage;

public class FullName {

	private final String FIRST_NAME;
	private final String MIDDLE_NAME;
	private final String LAST_NAME;
	
	public FullName(String pfName, String pmName, String plName)
	{
		FIRST_NAME = pfName;
		MIDDLE_NAME = pmName;
		LAST_NAME = plName;
		
	}
	
	public boolean equals(FullName pName)
	{
		if (this.LAST_NAME.equals(pName.LAST_NAME))
		{
			if (this.FIRST_NAME.equals(pName.FIRST_NAME))
			{
				return this.MIDDLE_NAME.equals(pName.MIDDLE_NAME);
			}
		}
		return false;
	}
	
    @Override
	public String toString()
	{
		return String.format("%s %s %s", this.FIRST_NAME, this.MIDDLE_NAME, this.LAST_NAME);
	}
	
	public String getFirstName()
	{
		return FIRST_NAME;
	}
	
	public String getMiddleName()
	{
		return MIDDLE_NAME;
	}
	
	public String getLastName()
	{
		return LAST_NAME;
	}
}
