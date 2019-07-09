package topcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class Telephone {
	
	
	public static HashMap <Integer, String> phone;
	
	public static HashSet <String> dictionary;
	
	public int comboCounter = 0; 
	
	
	public Telephone () {
		
		dictionary = new HashSet <String> ();
		
		phone = new HashMap <Integer, String> ();
		phone.put(0, "");
		phone.put(1, "");
		phone.put(2, "ABC");
		phone.put(3, "DEF");
		phone.put(4, "GHI");
		phone.put(5, "JKL");
		phone.put(6, "MNO");
		phone.put(7, "PQRS");
		phone.put(8, "TUV");
		phone.put(9, "WXYZ");
		
		String fileName = "D:\\google_prac\\topcoder\\src\\topcoder\\dictionary.txt";
		
		try (Stream <String> stream = Files.lines(Paths.get(fileName))) {
			
			stream.forEach(word -> dictionary.add(word.toUpperCase()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void combos (int num) {
		
		assert num >= 0;
		
		combosHelper (num, "");
	}
	
	/*
	 * O(log n * 3-4) => O(log n)
	 */
	public void combosHelper (int num, String word) {
		
		if (num == 0 && dictionary.contains(word)) {
			comboCounter++;
			System.out.println(word);
			return;
		}
		
		int digit = num % 10;
		String letters = phone.get(digit);
		for (int i = 0; i < letters.length(); i++) {
			char ch = letters.charAt(i);
			combosHelper (num / 10, String.valueOf(ch) + word);
		}
		
	}
	
	
	
	
	public static void main (String [] args) {
		
		System.out.println("Telephone.java\n");
		
		Telephone tele = new Telephone();
		
		int x = 3434;
		
		
		tele.combos(x);
		
		System.out.println("\n Combinations = " + tele.comboCounter);
	}

}
