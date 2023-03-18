//HW01 Section 2

public class StringOperations {
	public static void main(String[] args) {
		String name = "Brandon";
		String Aame = "A" + name.substring(1);
		System.out.println(Aame);
		String AamZ = Aame.substring(0,Aame.length()-1) + "Z";
		System.out.println(AamZ);

		String url = "www.prawnhub.com";
		System.out.println(url);

		String newCourse = url.substring(url.indexOf(".")+1);
		String newCourse1 = newCourse.substring(0,newCourse.indexOf("."));
		String newCourse2 = newCourse1 + "1331";
		System.out.println(newCourse2);

		
	}
}
