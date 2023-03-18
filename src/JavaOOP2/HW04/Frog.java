//this class defines Frog objects that exist within the Pond
/* Directions:
Variables: string name, int age *months*, double tongueSpeed, boolean isFroglet, string species
Constructors: Frog(name, age, tongueSpeed), Frog(name, ageInYears, toungeSpeed), Frog(name)
	defaults: age = 5, tongueSpeed = 5
Methods: 
	overloaded grow{int months}, grow{} default 1 month
	eat{Fly} check if caught
	toString{} conditional print
*/
public class Frog {

//instance variables
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet = (age > 1 && age < 7);
	private static String species = "Rare Pepe";

//static constants/variables
	public static final int DEFAULT_AGE = 5;
	public static final double DEFAULT_TONGUESPEED = 5;

//constructors
	public Frog(String name, int age, double tongueSpeed) {
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
		this.isFroglet = isFroglet;
		this.species = species;
	}
	public Frog(String name, double ageInYears, double tongueSpeed) {
		this(name, (int)(ageInYears * 12), tongueSpeed);	
	}
	public Frog(String name) {
		this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
	}


//accessors & mutators
	public String getSpecies() { return species; }
	public void setSpecies(String species) { this.species = species; }
//helper methods

//public methods
	public void grow(int months) {
		for (int i=0; i < months; i++) {
			age++;
			if (age <= 12) { tongueSpeed++; }
			else if (age > 30 && tongueSpeed >= 6) {tongueSpeed--; }
		}
		isFroglet = (age > 1 && age < 7);
	}
	public void grow() {
		age++;
		if (age <= 12) { tongueSpeed++; }
		else if (age > 30 && tongueSpeed >= 6) {tongueSpeed--; }
		isFroglet = (age > 1 && age < 7);
	}
	public void eat(Fly fly) {
		double flyMass = fly.getMass();
		double flySpeed = fly.getSpeed();
		if (!fly.isDead()) { //fly is alive
			if (flySpeed < tongueSpeed) { //fly is caught
				if (flyMass >= 0.5 * age) { //fly is a hearty meal
					grow();
					fly.setMass(0);
				}
			} else {
				fly.grow(1);
			}
		}
	}
	public String toString() {
		if (isFroglet) {
			return "My name is " + name + " and I'm a rare froglet! I'm " + age + 
			" months old and my tonge has a speed of " + 
			Math.round(tongueSpeed * 100.0)/100.0 + ".";
		} else {
			return "My name is " + name + " and I'm a rare frog. I'm " + age + 
			" months old and my tonge has a speed of " + 
			Math.round(tongueSpeed * 100.0)/100.0 + ".";
		}
	}
	/*
	public static void main(String[] args) {
		Frog frog1 = new Frog("Dogmeat", 13, 45);
		Frog frog2 = new Frog("Bubba", 1.0, 8);
		Frog frog3 = new Frog("Youngling");

		frog1.grow(41);
		frog2.grow(41);
		frog3.grow();

		System.out.println(frog1);
		System.out.println(frog2);
		System.out.println(frog3);
	}
	*/
}