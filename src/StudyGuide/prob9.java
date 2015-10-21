package StudyGuide;

public class prob9 {
	public abstract class Shape
	{
		abstract public double getArea();
		abstract public String getShapeName();
	}

	public class Circle extends Shape
	{
		private final double radius;
		
		public double getRadius()
		{
			return this.radius;
		}
		
		public Circle(double radius)
		{
			this.radius = radius;
		}

		@Override
		public double getArea()
		{
			return Math.PI * radius * radius;
		}
		
		@Override
		public String getShapeName()
		{
			return "Circle";
		}
	}
	
	public void main(String[] args)
	{
		Shape shape = new Circle(5);
		System.out.println(shape.getShapeName());
	}

}
