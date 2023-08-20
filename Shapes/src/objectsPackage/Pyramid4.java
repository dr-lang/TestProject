package objectsPackage;

import interfacePackage.ShapesInterface;

public class Pyramid4 implements ShapesInterface {
	private final double BASE_LENGTH;
	private final double BASE_WIDTH;
	private final double HEIGHT;
	private final double SLANT_HEIGHT;
	private final double PERIMETER;
	private final double SURFACE_AREA;
	private final double LATERAL_SURFACE_AREA;
	private final double BASE_AREA;
	private final double VOLUME;
	private final String SHAPE = "Pyramid4";

	public Pyramid4()
	{
		this.BASE_LENGTH = Math.random() * 10;
		this.BASE_WIDTH = Math.random() * 10;
		this.HEIGHT = Math.random() * 10;
		this.SLANT_HEIGHT = Math.random() * 10;
		this.PERIMETER = calculatePerimeter();
		this.BASE_AREA = calculateBaseArea();
		this.LATERAL_SURFACE_AREA = calculateLateralSurfaceArea();
		this.SURFACE_AREA = calculateSurfaceArea();
	    this.VOLUME = calculateVolume();
	}
	
	public Pyramid4(double length, double width, double height)
	{
		this.BASE_LENGTH = length;
		this.BASE_WIDTH = width;
		this.HEIGHT = height;
		this.SLANT_HEIGHT = calculateSlantHeight();
		this.PERIMETER = calculatePerimeter();
		this.BASE_AREA = calculateBaseArea();
		this.LATERAL_SURFACE_AREA = calculateLateralSurfaceArea();
		this.SURFACE_AREA = calculateSurfaceArea();
		this.VOLUME = calculateVolume();
	}
	
	private double calculateBaseArea() {
		return this.BASE_LENGTH * this.BASE_WIDTH;
	}
	
	private double calculateVolume() {
		return (1.0/3.0) * Math.pow(this.BASE_LENGTH, 2) * this.HEIGHT;
	}
	
	private double calculateSlantHeight()
	{
		return Math.sqrt(Math.pow(HEIGHT, 2) + ((1.0/4.0) * Math.pow(BASE_LENGTH, 2)));
	}
	
	private double calculatePerimeter() {
		return (2 * this.BASE_LENGTH) + (2 * this.BASE_WIDTH);
	}
	
	private double calculateLateralSurfaceArea() {
		return (1.0/2.0) * this.PERIMETER * this.SLANT_HEIGHT;
	}
	
	private double calculateSurfaceArea() {
		return this.LATERAL_SURFACE_AREA + this.BASE_AREA;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.SURFACE_AREA;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return this.VOLUME;
	}

	@Override
	public void displayArea() {
		// TODO Auto-generated method stub
		System.out.printf("This is a %s with an area of %3.2f square units%n",SHAPE, SURFACE_AREA);
	}

	@Override
	public void displayVolume() {
		// TODO Auto-generated method stub
		System.out.printf("This is a %s with a volume of %3.2f cubic units%n",SHAPE, VOLUME);
	}
	
	public String toString()
	{
		return SHAPE;
	}

}
