// a client that accesses insect.java

public class InsectClient {
	public static void main(String args[]) {
		System.out.println(Insect.produceRandomFact());
		//Insect bug1 = new Insect(13, 31, 0);
		Insect bug1 = new Insect(31);

		System.out.println("class default: " + Insect.DEFAULT_X);
		System.out.println("instance default: " + bug1.DEFAULT_X);

		double bug1Weight = bug1.getWeight();
		System.out.println(bug1Weight);
		//bug1.move(8, 9);

		// using accessors to get values (also called "getters")
		int bug1Y = bug1.getY();
		int bug1X = bug1.getX();
		System.out.println("X: " + bug1X + "; Y: " + bug1Y);

		// using setters to set vals and getters to check it was done
		bug1.setY(45);
		bug1.setX(-2);
		bug1Y = bug1.getY();
		bug1X = bug1.getX();
		System.out.println("X: " + bug1X + "; Y: " + bug1Y);

		//using toString() for a more concise approach. We needed to override the default
		//System.out.println(bug1.toString());
		//but we don't actually need to call toString in a print statement, since java
		//automatically does this when a nonString object is passed. We can just write
		System.out.println(bug1);
		System.out.println(Insect.getPopulation());
	}
}

/*
I noticed a class doesn't need to be recompiled for a client to use modifications
*/