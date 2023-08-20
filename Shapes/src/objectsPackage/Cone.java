/**
 * 
 */
package objectsPackage;

import interfacePackage.ShapesInterface;

/**
 * @author Larry Shannon
 *
 */
public class Cone implements ShapesInterface
{
	private final double RADIUS;
	private final double HEIGHT;
	private final double SLANT_LENGTH;
	private final double SURFACE_AREA;
	private final double VOLUME;
	private final String SHAPE = "Cone";
	private final double PI = Math.PI;
	private final double BASE_AREA;
	private final double CONE_AREA;
	public Cone()
	{
		this.RADIUS = Math.random() * 10;
		this.HEIGHT = Math.random() * 10;
		this.SLANT_LENGTH = calculateSlantLength();
		this.CONE_AREA = calculateConeArea();
		this.BASE_AREA = calculateBaseArea();
		this.SURFACE_AREA = calculateSurfaceArea();
		this.VOLUME = calculateVolume();
	}
	public Cone(double pHeight, double pRadius)
	{
		this.RADIUS = pRadius;
		this.HEIGHT = pHeight;
		this.SLANT_LENGTH = calculateSlantLength();
		this.CONE_AREA = calculateConeArea();
		this.BASE_AREA = calculateBaseArea();
		this.SURFACE_AREA = calculateSurfaceArea();
		this.VOLUME = calculateVolume();
	}
	
	private double calculateSlantLength()
	{
		return Math.sqrt(RADIUS * RADIUS + HEIGHT * HEIGHT);
	}
	private double calculateConeArea()
	{
		return PI * RADIUS * SLANT_LENGTH;
	}
	private double calculateBaseArea()
	{
		return PI * RADIUS * RADIUS;
	}
	private double calculateSurfaceArea()
	{
		return this.BASE_AREA + this.CONE_AREA;
	}
	private double calculateVolume()
	{
		return (BASE_AREA * HEIGHT) / 3;
	}

	@Override
	public double getArea()
	{
		return this.SURFACE_AREA;
	}

	@Override
	public double getVolume()
	{
		return this.VOLUME;
	}

	@Override
	public void displayArea()
	{
		System.out.printf("This is a %s with an area of %3.2f square units%n",SHAPE, SURFACE_AREA);

	}

	@Override
	public void displayVolume()
	{
		System.out.printf("This is a %s with a volume of %3.2f cubic units%n",SHAPE, VOLUME);

	}
	public String toString()
	{
		return SHAPE;
	}
}
