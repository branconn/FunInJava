//Module 4, Lesson 9: Methods

//We're going to create a search method:

public class ArraySearch {
	public static void main(String args[]) {
		String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};
		String[] checkConcepts = {"abstraction", "polymorphism", "inheritance", "encapsulation", "juggling", "bravery"};
		for (String concept: checkConcepts) {
			if (searchStringArray(concept, concepts)) {
				System.out.println(concept+ " was found");
			}
			else {
				System.out.println(concept+ " was not found");
			}
			
		}
	}

//return method(input)

	public static boolean searchArray(String target, String[] array) {
		boolean result = false;
		for (String element : array ) {
			if ((element != null) && element.equals(target) ) {
				result = true;
				break;
			}
		}
		return result;
		//this would be an unreachable statement;
	}
	public static boolean searchArray(int target, int[] array) {
		boolean result = false;
		for (int element : array ) {
			if (element == target ) {
				result = true;
				break;
			}
		}
		return result;
	}

	
}


/* Notes:

Recall that a method allows a programmer to group related statements together and give them a name. One of the main reasons to do this is to modularize programs.

public: visibility modifier - public will allow us to write this outside of the parent Class

We don't want to make new methods for every permutation of the same task (such as searchTypeArray). An alternative is to OVERLOAD the method with two versions. These versions can differ on Type, Order, and/or number of formal params. 



*/