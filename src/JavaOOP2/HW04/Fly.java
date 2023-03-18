//this class defines fly objects that exists within the pond
/* Directions:
 - all vars must be immutable outside of the class in which they're declared (private) unless otherwise stated
DONE: var - double mass
DONE: var - double speed
DONE: constructor - mass, speed inputs
DONE: constructor - mass input; default 10 speed
DONE: constructor - no params,; default 5 mass, 10 speed
TODO: helper - grow {addedMass}
*/
public class Fly {

//instance variables
	private double mass;
	private double speed;

//static constants/variables
	public static final double DEFAULT_SPEED = 10;
	public static final double DEFAULT_MASS = 5;

//constructors
	public Fly(double mass, double speed) {
		this.mass = mass;
		this.speed = speed;
	}
	public Fly(double mass) {
		this(mass, DEFAULT_SPEED);
	}
	public Fly() {
		this(DEFAULT_MASS, DEFAULT_SPEED);
	}

//accessors & mutators
//TODO: getters and setters for all variables
	public double getMass() {
		return mass;
	}
	public double getSpeed() {
		return speed;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
//helper methods

//public methods
//DONE: toString - (mass==0) ? print "I'm dead, but I used to be a fly with a speed of X", "I’m a speedy fly with [speed] speed and [mass] mass.”
	public String toString() {
		if (mass == 0) {
			return "I'm dead, but I used to be a fly with a speed of " + 
			Math.round(speed*100.0)/100.0 + ".";
		} else {
			return "I'm a speedy fly with " + Math.round(speed*100.0)/100.0 + 
			" speed and " + Math.round(mass*100.0)/100.0 + " mass.";
		}
	}

	public void grow(int addedMass) {
		mass += addedMass;
		if (mass < 20) {
			speed += addedMass;
		} else {
			if (mass - addedMass < 20) {
				speed += (20 + mass - addedMass);
			}
			speed -= 0.5 * (mass - 20);
		}
	}

	public boolean isDead() {
		return (mass == 0);
	}
	/*
	public static void main(String[] args) { //BURN AFTER USING
		Fly fly1 = new Fly(1, 3.333);
		Fly fly2 = new Fly(6);
		Fly fly3 = new Fly();

		System.out.println(fly1);
		System.out.println(fly2);
		System.out.println(fly3);

		fly1.grow(13);
		fly2.grow(24);
		fly3.grow((int)-DEFAULT_MASS);

		System.out.println(fly1);
		System.out.println(fly2);
		System.out.println(fly3);
	}
	*/
}