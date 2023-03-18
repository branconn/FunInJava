//java class template

public class Dog extends Canine {
	
//instance variables
	protected String name;
//static constants/variables

//constructors
	public Dog(String name, double size) {
		super(size); //super is used to inherit the parent class constructor params. Without a super method, Java defaults to a parameterless constructor if one exists, otherwise argument count error
		this.name = name;
	}

//accessors & mutators

//helper methods

//public methods
	
	public boolean equals(Object o) {
		/*
		if (o == null) { //no longer needed with instanceof
			return false;
		}
		*/
		if (!(o instanceof Dog)) {
			return false;
		}
		Dog doggy = (Dog) o; //casting (Object) o to a (Dog) class here
		return ((doggy.size == size) && (doggy.name.equals(name)));

		
	}

	public void fetch() {
		System.out.println("Run");
		System.out.println("Clinch");
		System.out.println("Return");
	}

	public void groom() {}

	public static void main(String[] args) {
		Dog spot = new Dog("Spot", 9.6);
		spot.bark();
	}
}