
public class Circle extends Shape
{
	private int radius;

	public Circle(int _radius)
	{
		radius = _radius;
	}

	public void draw(Coord coord)
	{
		System.out.println("Drawing a circle(radius=" + radius + ") in " + coord);
	}
}
