package Shape;


public class Circle
{
	private final double radius;
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public double getArea()
	{
		return Math.PI * this.radius * this.radius;
	}

	
	public static void main(String[] args)
	{
		Circle c1 = new Circle(2);
		System.out.println(c1.getArea());
	}
	
}
