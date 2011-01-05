
public aspect ShapeObserverPattern extends ObserverPattern
{
	declare parents: Shape implements Subject;
	declare parents: Display implements Observer;

	protected pointcut subjectChanged(Subject s) :
		this(s) && execution(void Shape.draw(Coord));

	public void updateObserver(Observer o, Subject s)
	{
		((Display)o).update();
	}
}
