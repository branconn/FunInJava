//java class acting as client for Java review


public class OverviewClient {

//instance variables


//static constants/variables


//constructors


//accessors & mutators


//helper methods


//public methods

	public static void main(String[] args) {
		//Overview<String> c1 = new Overview<String>();
		//Overview<String> c1 = new Overview<>(); is another valid form
		//c1.set("hello");
		//System.out.println(c1);
		//String s = (String)c1.get(); //must cast to String here because c1 is type Object
		//String s = c1.get(); //using generics we don't need to cast here
		//System.out.println(s);


		Overview item1 = new Overview("cheesesteak", 4);
		Overview item2 = new Overview("cheesecake", 7);
		System.out.println(item1.compareTo(item2));
	}
}

/* Notes

*/