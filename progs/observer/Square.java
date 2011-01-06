
public class Square extends Shape
{
	private int side;

	public Square(int _side)
	{
		side = _side;
	}

	public void draw(Coord coord)
	{
		System.out.println("Drawing square(side=" + side + ") in " + coord);
	}
}
