package io.github.leonardomvs.tdd;

public class FizzBuzz {

	// If number is divisible by 3, print Fizz
	// If number is divisible by 5, print Buzz
	// If number is divisible by 3 and 5, print FizzBuzz
	// IF number is NOT divisible by 3 or 5, then print the number
	
	public static String compute(int i) {
		StringBuilder str = new StringBuilder();				
		if(i % 3 == 0) { str.append("Fizz"); }
		if(i % 5 == 0) { str.append("Buzz"); }		
		if(str.isEmpty()) { str.append(i); }		
		return str.toString();
	}

}
