package io.github.leonardomvs.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
	
	// If number is divisible by 3, print Fizz
	// If number is divisible by 5, print Buzz
	// If number is divisible by 3 and 5, print FizzBuzz
	// IF number is NOT divisible by 3 or 5, then print the number

	@Test
	@DisplayName("Divisible by Three")
	@Order(1)
	void testForDivisibleByThree() {
		String expected = "Fizz";
		assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");		
	}
	
	@Test
	@DisplayName("Divisible by Five")
	@Order(2)
	void testForDivisibleByFive() {
		String expected = "Buzz";
		assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");		
	}
	
	@Test
	@DisplayName("Divisible by Three and Five")
	@Order(3)
	void testForDivisibleByThreeAndFive() {
		String expected = "FizzBuzz";
		assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");		
	}
	
	@Test
	@DisplayName("Not Divisible by Three or Five")
	@Order(4)
	void testForNotDivisibleByThreeOrFive() {
		String expected = "1";
		assertEquals(expected, FizzBuzz.compute(1), "Should return 1");		
	}
	
	@DisplayName("Testing with Small data file")
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources ="/small-test-data.csv")
	@Order(5)
	void testSmallDataFile(int value, String expected) {
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
	@DisplayName("Testing with Medium data file")
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources ="/medium-test-data.csv")
	@Order(6)
	void testMediumDataFile(int value, String expected) {
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
	@DisplayName("Testing with Large data file")
	@ParameterizedTest(name="value={0}, expected={1}")
	@CsvFileSource(resources ="/large-test-data.csv")
	@Order(7)
	void testLargeDataFile(int value, String expected) {
		assertEquals(expected, FizzBuzz.compute(value));
	}
	
}
