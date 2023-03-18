//Module 5, Lession 12: Inheritance

public abstract class Canine {

//instance variables
	protected double size;

//static constants/variables
	
//constructors
	public Canine(double size) {
		this.size = size; //this.instVar = formal param
	}

//accessors & mutators

//helper methods

//public methods
	public void bark() {
		System.out.println("Woof woof");
	}

	public abstract void groom();

	public static void main(String[] args) {
		
	}
}

/* Notes
Inheritance: an "is a" relationship
A derived class is called a subclass or child class (interchangeable)
A class derived from is called a superclass or parent class

Insect
	YellowJacket
	HouseFly
	Ant
	Flea

Canine
	Dog
	Wolf


UML: Unified Modeling Language is used to visualize code bases including inheritance
There is a class called Object.. there is also a class called Class.
Object imbues some basic functionality to all classes such as toString()

Protected numbers lie between private and public. They are used for extending public access to inherited classes and the package without fully making the number public to any user.

Default accessibility is to Class and Package, but not Subclass nor World

Private numbers are not inherited.

Adding "final" prevents a method from being overwritten
Similarly, a final class cannot be subclassed

ABSTRACT MODIFIER!!
	An abstract class is a class with at least one abstract method
	An abstract method is a method that has a declaration but not definition
	If a class has an abstract method, it must be declared abstract

	This is useful when there is no default that makes sense to share as a base, but that it must still exist (compile error if undefined)

	A subclass of an abstract class must either define all abstract methods or itself be declared abstract to be valid.



*/