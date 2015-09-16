package binf6380_20150916;

public class classRectangle
{
	//initialization
	private final double width;
	private final double height;
	
	//constructor
	public classRectangle( double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	//returns width*height
	public double getArea()
	{
		return width*height;
	}
	
	//returns 2*width + 2*height
	public double getPerimeter()
	{
		return (2*width)+(2*height);
	}
	
	public static void main(String[] args) throws Exception
	{
		classRectangle r = new classRectangle(10, 5);
		System.out.println(r.getArea());
		System.out.println(r.getPerimeter());
	}
}
