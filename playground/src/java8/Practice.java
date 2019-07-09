package java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class Practice {
	
	
	public static void testPredicate () {
		
		
		Predicate <Integer> pred = p -> p > 0;
		
		if (pred.test(-1)) {
			System.out.println("Negative");
		}
		else {
			System.out.println("Positive");
		}
		
	}
	
	public static void testFunction () {
		
		
		Function <Integer, Integer> func = t -> t + 1;
		
		Integer result = func.apply(0);
		
		System.out.println("Result = " + result);
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("main");
		
		testFunction();
		
	}

}
