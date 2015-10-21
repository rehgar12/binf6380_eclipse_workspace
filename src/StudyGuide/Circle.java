package StudyGuide;
import java.util.HashSet;
import java.util.Set;

public class Circle 
{
	private double radius;
	
	public Circle( double radius )
	{
		this.radius = radius;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		Circle other = (Circle) obj;
		
		return other.radius == this.radius;
	}
	
	public static void main(String[] args)
	{
		Set<Circle> set = new HashSet<Circle>();
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(5);
		System.out.println( c1.equals(c2) );
		
		set.add(c1);
		set.add(c2);
		
		System.out.println(set.size());
	}
}
