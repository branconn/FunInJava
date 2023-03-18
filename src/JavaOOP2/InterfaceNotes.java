//java class template

public class Template {

//instance variables

//static constants/variables

//constructors

//accessors & mutators

//helper methods

//public methods
	public static void main(String[] args) {
		
	}
}

/*
How do you write a method, loop, func that can apply to multiple classes that share no relationship through inheritance? Interfaces.

Interfaces allow one to declare an abstract method that is expected to be defined by the classes in their own way.

You do not execute interfaces but bind them to classes. You include an implements clause to the class header, and you reference the interfaces as a type in executing methods.

Implements clauses are inherited. If the superclass is abstract there does not need to be a reference to the interface method in the superclass.

Sorting Arrays of Objs
	Merge Sort
	Insertion Sort
	Bubble Sort
	Quicksort
	Selection Sort

	How to sort objects of any class with their different rankinkg parameters? 

public void quickSort(Object[] arr) {
	...
	((someType)arr[someIndex]).compareTo(arr[anotherIndex])
	...
}

	How do we ensure the compareTo method is defined in the class? We use an interface! An interface is a contract. Built-in:
	java.lang.Comparable

	Java also has Arrays.sort() method. It treats the objects in the array as Comparable

Exercise implemented in the Wolf/Dog/Canine java files.

*/