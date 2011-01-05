import java.util.Vector;
import java.util.Iterator;

public abstract aspect ObserverPattern perthis(subjectConstructed(Subject))
{
	public interface Observer {}
	public interface Subject {}

	private Vector observers = new Vector();

	public void addObserver(Observer o)
	{
		observers.add(o);
	}

	protected pointcut subjectConstructed(Subject s) :
		this(s) && execution(Subject+.new(..));

	abstract protected pointcut subjectChanged(Subject s);

	after(Subject s) : subjectChanged(s)
	{
		Iterator itr = observers.iterator();

		while(itr.hasNext()) {
			updateObserver((Observer)itr.next(), s);
		}
	}

	public abstract void updateObserver(Observer o, Subject s);
}
