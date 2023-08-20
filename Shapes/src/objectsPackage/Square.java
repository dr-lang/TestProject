package objectsPackage;

import interfacePackage.ShapesInterface;

public class Square implements ShapesInterface {
	private final double LENGTH;
	private final double WIDTH;
	private final double SURFACE_AREA;
	private final String SHAPE = "Square";
	public Square()
	{
		this.LENGTH = Math.random() * 10;
		this.WIDTH = Math.random() * 10;
		this.SURFACE_AREA = (this.LENGTH * this.WIDTH);
	}
	public Square(double length, double width)
	{
		this.LENGTH = length;
		this.WIDTH = width;
		this.SURFACE_AREA = calculateSurfaceArea();
	}
	
	private double calculateSurfaceArea()
	{
		return (this.LENGTH * this.WIDTH);
	}
	@Override
	public double getArea()
	{
		// TODO Auto-generated method stub
		return this.SURFACE_AREA;
	}

	@Override
	public double getVolume()
	{
		// A Square does not have a volume
		return 0;
	}
	@Override
	public void displayArea()
	{
		System.out.printf("This is a %s with an area of %3.2f square units%n",SHAPE, SURFACE_AREA);
	}
	@Override
	public void displayVolume()
	{
		System.out.printf("This is a %s and it has no volume!%n",SHAPE);
	}

	public String toString()
	{
		return SHAPE;
	}
}
