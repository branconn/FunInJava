//java class template

public class Repeater {

//instance variables


//static constants/variables


//constructors


//accessors & mutators


//helper methods


//public methods
	
	//intentionally triggering StackOverflowError

	public static void repeatString(String toRepeat, int times) {
		System.out.println(times);
		try { repeatString(toRepeat, times + 1);
		} catch(Exception e) { System.out.println("reached end");
		} finally { System.out.println("finally"); }
	}


	public static void main(String[] args) {
		repeatString("I <3 Java", 0);
	}
}

/* Notes

*/