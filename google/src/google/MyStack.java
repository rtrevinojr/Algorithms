package google;

import java.util.EmptyStackException;

public class MyStack {
	
	
	public int [] stack;
	public int stackNum = 3;
	//public int stackSize;
	public int offset1;
	public int offset2;
	public int offset3;
	
	public MyStack(int stackSize) {
	
		stack = new int [stackNum * stackSize];
		offset1 = 0;
		offset2 = stackSize;
		offset3 = 2 * stackSize;
	}
	
	public void push (int stackNum, int value) {
		
		if (!isFull(stackNum)) {
			if (stackNum == 0) {
				stack[offset1++] = value;
			}
			else if (stackNum == 1) {
				stack[offset2++] = value;
			}
			else if (stackNum == 2) {
				stack[offset3++] = value;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int pop (int stackNum) {
		if (!isEmpty(stackNum)) {
			if (stackNum == 0) {
				return stack[--offset1];
			}
			else if (stackNum == 1) {
				return stack[--offset2];
			}
			else if (stackNum == 2) {
				return stack[--offset3];
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int peek (int stackNum) {
		
		if (!isEmpty(stackNum)) {
			if (stackNum == 0) {
				return stack[offset1 - 1];
			}
			else if (stackNum == 1) {
				return stack[offset2 - 1];
			}
			else if (stackNum == 2) {
				return stack[offset3 - 1];
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public boolean isEmpty (int stackNum) {
		if (stackNum == 0) {
			return offset1 <= 0;
		}
		if (stackNum == 1) {
			return offset2 <= 100;
		}
		if (stackNum == 2) {
			return offset3 <= 200;
		}
		throw new IllegalArgumentException();
	}
	
	public boolean isFull (int stackNum) {
		if (stackNum == 0) {
			return offset1 > 100;
		}
		if (stackNum == 1) {
			return offset2 > 200;
		}
		if (stackNum == 2) {
			return offset3 > 300;
		}
		throw new IllegalArgumentException();
	}
	
	public void printStack () {
	
		
		for (int i = 0; i < 100; i++) {
			
			System.out.print(stack[i] + " - ");
		}
		
		System.out.println();
		for (int i = 100; i < 200; i++) {
			
			System.out.print(stack[i] + " - ");
		}
		System.out.println();
		for (int i = 200; i < stack.length; i++) {
			
			System.out.print(stack[i] + " - ");
		}
		System.out.println();
		
	}
	
	public static void main (String [] args) {
		
		System.out.println("MyStack.java");
		
		MyStack mystack = new MyStack(100);
		
		mystack.push(0, 1);
		mystack.push(0, 2);
		mystack.push(0, 3);
		mystack.push(1, 1);
		mystack.push(1, 2);
		
		int pop1 = mystack.pop(0);
		System.out.println("pop 1 - " + pop1);
		
		mystack.push(0, 4);
		
		int peek1 = mystack.peek(0);
		System.out.println("peek 1 - " + peek1);
		
		mystack.printStack();
		
		System.out.println(mystack.stack.length);
		
	}

}
