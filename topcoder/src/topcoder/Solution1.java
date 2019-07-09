package topcoder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution1 {
	
	
	
	public static String removeHigh9Digits (String number) {
		
		int count = 0;
		
		boolean isNine = false;
		
		char [] chArr = number.toCharArray();
		
		List<Character> charList = new ArrayList <Character>();
	    for (char c : chArr) {
	        charList.add(c);
	    }
		
		for (char i = '9'; i > 47 && !isNine; i--) {
			
			Iterator <Character> it = charList.iterator();
			while (it.hasNext()) {
				Character ch = it.next();
				if (ch.equals(new Character(i)) && !isNine) {
					it.remove();
					count++;
				}
				if (count >= 9) {
					isNine = true;
					break;
				}
				
			}

		}

		return charList.stream().map(e->e.toString()).collect(Collectors.joining());
	}

	
	public static void main (String [] args) {
		System.out.println("Solution3");
		
		try {
			Scanner scan = new Scanner (new File ("LowestNumber.csv"));
						
			while (scan.hasNext()) {
				
				String line = scan.next();
				String result = removeHigh9Digits(line);
				System.out.println(result);

			}

		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("done.");
	}
}
