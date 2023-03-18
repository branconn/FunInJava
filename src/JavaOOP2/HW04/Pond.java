//this class is a driver, containing Frog and Fly objects and "driving" their values according to a sumulated set of actions. Can be used to test code.
/*
Methods:
	main{} create >= 4 Frogs, create >= 3 Flys, set species of a Frog, etc..
*/

public class Pond {

//instance variables

//static constants/variables

//constructors

//accessors & mutators

//helper methods

//public methods
	public static void main(String[] args) {
		Frog frog1 = new Frog("Peepo");
		Frog frog2 = new Frog("Pepe", 10, 15);
		Frog frog3 = new Frog("Peepaw", 4.6, 5);
		Frog frog4 = new Frog("Donkey Teeth");

		Fly fly1 = new Fly(1, 3);
		Fly fly2 = new Fly(6);
		Fly fly3 = new Fly();

		frog4.setSpecies("1331 Frogs");
		System.out.println(frog1);

		frog1.eat(fly2);
		System.out.println(fly2);

		frog1.grow(8);
		frog1.eat(fly2);
		System.out.println(fly2);
		System.out.println(frog1);
		System.out.println(frog4);

		frog3.grow(4);
		System.out.println(frog3);
		System.out.println(frog2);
		
	}
}