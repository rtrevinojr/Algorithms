package test;

public class TestReference {
	
	
	public class MyObject {
		public int value;
		public MyObject () {
			value = 0;
		}
	}
	
	public void test (MyObject obj) {
		obj.value = 1;
	}
	
	public static void teststatic (MyObject obj) {
		obj.value = 2;
	}
	
	public static void main (String [] args) {
		
		TestReference testReference = new TestReference();
		
		MyObject obj1 = testReference.new MyObject ();
		
		//teststatic(obj1);
		
		testReference.test(obj1);
		
		System.out.println("obj1 = " + obj1.value);
	}

}
