//java class template

public class Factorial {

//instance variables


//static constants/variables
	private static int nFact;

//constructors


//accessors & mutators


//helper methods
	private static int factorialHelper(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return n * factorialHelper(n+1);
		} else {
			return n * factorialHelper(n-1);
		}
	}

//public methods

	public static void main(String[] args) {
		System.out.println(factorialHelper(-5));
	}
}

/* Notes

*/