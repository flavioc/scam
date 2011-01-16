
public aspect ClassTrace extends Trace {
	pointcut myClass(): within(MyClass);
}
