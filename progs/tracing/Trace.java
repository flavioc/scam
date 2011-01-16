import org.aspectj.lang.Signature;

abstract aspect Trace {
	private static int callDepth = 0;

	private static void printMethod(Signature sign, Object[] args) {
		System.out.print(sign.getName() + "(");
		for(int i = 0; i < args.length; ++i) {
			System.out.print(args[i].toString());
			if(i != args.length - 1)
				System.out.print(", ");
		}

		System.out.print(")");
	}

	private static void printEntering(Signature sign, Object[] args) {
		printIndent();
		System.out.print("-> ");
	 	printMethod(sign, args);
		System.out.println("");
	}

	private static void printExiting(Signature sign, Object[] args, Object ret) {
		printIndent();
		System.out.print("<- ");
		printMethod(sign, args);
	 	System.out.println(" returning " + ret.toString());
	}

	private static void printIndent() {
		for(int i = 0; i < callDepth; ++i)
			System.out.print(" ");
	}

	abstract pointcut myClass();

	pointcut constructorPC(): myClass() && execution(new(..));
	pointcut methodPC(): myClass() && execution(* *(..));

	before(): constructorPC() || methodPC() {
		printEntering(thisJoinPoint.getSignature(),
				thisJoinPoint.getArgs());
		callDepth++;
	}

	after() returning (Object ret): constructorPC() || methodPC() {
		callDepth--;
		printExiting(thisJoinPoint.getSignature(), thisJoinPoint.getArgs(), ret);
	}
}
