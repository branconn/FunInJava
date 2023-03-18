//java class housing overview concepts for Java

//public class Overview<T> { //declaring a generic T
public class Overview implements Comparable<Overview> {

//instance variables
	//private T t;
	private String name;
	private int price;

//static constants/variables


//constructors
	public Overview(String name, int price) {
		this.name = name;
		this.price = price;
	}

//accessors & mutators
	/*
	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	} */
	public int getPrice() {
		return price;
	}

//helper methods


//public methods
	public int compareTo(Overview otherItem) {
		return this.price - otherItem.getPrice();
	}
	public static void main(String[] args) {
		/*
		//String equality
		String literal = "This is a string.";
		String literal2 = "This is a string.";
		String object = new String("This is a string.");

		System.out.println("String equality checks:");	
		System.out.println(literal == object); 		//false
		System.out.println(literal == literal2); 	//true
		System.out.println(literal.equals(literal2));	//true
		System.out.println(object.equals(literal2));	//true

		//Null Pointer Exceptions
		String nullObject = null;
		String normalObject = "normal";
		String emptyString = "";

		System.out.println("Null checks:");		
		System.out.println(nullObject == null);		//true
		System.out.println(normalObject == null);	//false
		System.out.println(emptyString == null);	//false
		normalObject.equals(nullObject);		//false
		normalObject.equals(null);			//false
	//	nullObject.equals(*) this would throw an NPE
		*/
		
	}
}

/* Notes
Primitive types in Java (int, long, double, char, etc.) do not extend the Object class as most types do. This omission is an optimization.
*/