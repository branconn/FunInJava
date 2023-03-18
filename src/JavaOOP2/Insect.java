//Module 5, Lesson 10-11: Intro to Writing Classes Pt.1 & 2

//Insect class example
public class Insect {

	//instance variables

	//in Java anything declared at this level is called a class member
	private double weight;
	private int x; //private allows access control (by classes)
	private int y; //i.e enforcing encapsulation
	

	//static constants/variables

	public static final int DEFAULT_X = 0;
	public static final int DEFAULT_Y = 0;	
	public static final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
	//static lets it be equal across instances
	private static int population = 0;
	private static final String[] FACTS = {
		"The two main groups of..",
		"There are more than 1 mill..",
		"Insects are cold-bloo..",
		"Spiders are not considered in.."
	};

	//constructors

	/* constructor notes
		we want other classes to be able to make instances of insect,
		so the constructor is public. Constructors have no return type		


		DRY = Don't Repeat Yourself
		constructor chaining: there's one "base" constructor that sets shared values
		a more specific constructor is called by less specific by this()

		this() can also be used as a reference within a constructor or non-static method

		when using this.[var], we say that the instance variable is the "shadow" of 
		the formal parameter since the latter has precedence over the name
	*/

	public Insect(double initWeight) {
		this(initWeight, DEFAULT_X, DEFAULT_Y); //an example of constructor chaining
	}

	public Insect(double weight, int x, int y) {
		//weight = initWeight;
		//x = initX;
		//y = initY;
		//we'll make us of the this() operator for initilizes var assignment
		this.x = x;
		this.y = y;
		this.weight = weight;
		population++; //conveniently increments instantiations
	}


	//methods

	/* method notes
		public methods of a class are collectively called its INTERFACE

		within a method's body, any use of an identifier that is also
		the name of a formal parameter represents that formal parameter
	*/

	//accessors

	public double getWeight() {
		return weight;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public static int getPopulation() {
		return population;
	}

	//mutators

	//public void setX(int newX) {    this is the old way
		//if (isLegalPos(newX)) {
			//x = newX;
		//}
	//}
	public void setX(int x) {
		if (isLegalPos(x)) {
			this.x = x;
		}
	}
	public void setY(int y) {
		if (isLegalPos(y)) {
			this.y = y;
		}
	}
	public static boolean isLegalPos(int pos) {
		return (pos >= 0 ? true : false);
	}

	//public functional methods

	public void eat(double amount) {
		System.out.println("Nibble nibble");
		weight = weight + amount;
	}
	public void move(int newX, int newY) {
		double distance = calculateDistance(x, y, newX, newY);
		if (distance > 0 ) {
			x = newX;
			y = newY;
			weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
			System.out.printf("Moved %.2f units\n", distance);
		}
		else //I did not know this syntax was valid, maybe if it's a 1-liner
			System.out.println("Staying put");
	}
	public static String produceRandomFact() {
		int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
		return FACTS[index];
	}
	public String toString() {
		return "weight: " + weight + ", x: " + x + ", y: " + y;
	}

	//private helper methods

	/* helper method notes
		helper method used internally by one more other methods, typically static
	*/

	private static double calculateDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
	}
	
	//main method
	public static void main(String[] args) {
		//Insect buzz1 = new Insect();
		//Insect buzz2 = new Insect();
		System.out.println("Insect Population: " + population);
		Insect bug1 = new Insect(10, 100, 90);
		System.out.println("Insect Population: " + population);
		Insect bug2 = new Insect(4, -300, 400);
		System.out.println("Insect Population: " + population);

		bug1.move(1,10);
		bug2.move(-300,400);

		System.out.println(produceRandomFact());
	}

}


/* Notes
insect behaviors: eat, move
weight changes with eating and moving
data/state: weight, location (x,y)

instance variables
	attribute whose value is particular to the instance of the class
instances in the "heap"

to test on instances of a class, rather than creatinga client class to instantiate this class, we instead write our test code in the main method of the class itself

classes have default constructors that give default values to instance variables
	numeric primitive: 0
	boolean: false
	class (object type): null

as soon as we create a constructor it overrides the default constructor, and we can no longer instatiate classes without parameters
~~~~~~~~~~~~~~~PT 2~~~~~~~~~~~~~~~
accessors and mutators allow us to overcome the seemingly inherent access limitation of private vars
accessors: also called getters; public methods that allow read access to private variables
mutators: also called setters; public methods that allow write access to private variables

*/