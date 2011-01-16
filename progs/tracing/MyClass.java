
public class MyClass {
	private int ab;

	private int doFactorial(int n) {
		if(n <= 1)
			return 1;
		return n * doFactorial(n-1);
	}
	public int factorial() {
		return doFactorial(ab);
	}

	private int doFib(int n) {
		if(n <= 1)
			return n;
		return doFib(n-1) + doFib(n-2);
	}
	public int fib() {
		return doFib(ab);
	}

	public MyClass(int a, int b) {
		ab = a * b;
	}
}
