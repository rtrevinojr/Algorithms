package topcoder;

public class TestExceptions {

	
	public Integer testException () {
		
		Integer result = 0;
		
		try {
			result = 1;
			System.out.println("Test Exception");
			throw new NullPointerException("NULL POINTER E");
		}
		catch (Exception e) {
			result = 2;
			System.out.println(e);
		}
		result = 3;
		System.out.println(result);
		return result;
		
	}
	
	
	public static void main (String [] args) {
	
		
		System.out.println("Exceptions");
		
		TestExceptions e = new TestExceptions();
		e.testException();
		
		System.out.println("End of method");
	}
	
}
