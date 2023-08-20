package objectsPackage;

import interfacePackage.ShapesInterface;

public class Cube implements ShapesInterface{
	private final double LENGTH;
	private final double WIDTH;
	private final double SURFACE_AREA;
	private final double VOLUME;
	private final String SHAPE = "Cube";
	public Cube()
	{
		this.LENGTH = Math.random() * 10;
		this.WIDTH = Math.random() * 10;
		this.SURFACE_AREA = calculateSurfaceArea();
		this.VOLUME = calculateVolume();
	}
	public Cube(double length, double width)
	{
		this.LENGTH = length;
		this.WIDTH = width;
		this.SURFACE_AREA = calculateSurfaceArea();
		this.VOLUME = calculateVolume();
	}
	
	
	
	private double calculateSurfaceArea()
	{
		return (6 * Math.pow(LENGTH, 2));
	}
	private double calculateVolume()
	{
		return (Math.pow(LENGTH, 3));
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
