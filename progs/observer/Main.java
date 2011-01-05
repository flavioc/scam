
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Starting!");

		Display display = new Display();
		Square sq = new Square(2);
		Circle circle = new Circle(5);

		ShapeObserverPattern.aspectOf(sq).addObserver(display);
		ShapeObserverPattern.aspectOf(circle).addObserver(display);

		sq.draw(new Coord(0, 0));
		circle.draw(new Coord(10, 5));
	}
}
