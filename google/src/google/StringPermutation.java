package google;

public class StringPermutation {
	
	
	public static void moveTower (int n, String start, String temp, String finish) {
		
		if (n == 1) {
			System.out.println(start + " -> " + finish);
		}
		else {
			moveTower (n - 1, start, temp, finish);
			System.out.println(start + " -> " + finish);
			moveTower (n - 1, temp, finish, start);
		}
	}
	
	
	public static void listPermutations (String s) {
		listPermutationsHelper("", s);
	}
	
	public static void listPermutationsHelper (String prefix, String s) {
		
		if (s.length() == 0) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < s.length(); i++) {
				String c = s.charAt(i) + "";
				String rest = s.substring(0, i) + s.substring(i + 1, s.length());
				listPermutationsHelper(prefix + c, rest);
			}
		}
	}
	
	
	public static void main (String [] args) {
		
		System.out.println(" ----- StringPermutation.java ----- ");
		
		StringPermutation.listPermutations("ABCD");
		
		System.out.println("\n" + " ----- Tower Algo ----- " + "\n");
		
		StringPermutation.moveTower(4, "A", "B", "C");
		
	}

}
