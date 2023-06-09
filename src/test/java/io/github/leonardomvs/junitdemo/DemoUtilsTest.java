package io.github.leonardomvs.junitdemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoUtilsTest {
	
	private DemoUtils demoUtils;	
	
	@BeforeEach
	void setupBeforeEach() {
		demoUtils = new DemoUtils();
		System.out.println("@BeforeEach executes before the execution of each test method");
	}
	
	@Test
	@DisplayName("Multiply")
	void testMultiply() {
		assertEquals(12, demoUtils.multiply(4, 3), "4 * 3 must be 12");
	}
	
	@Order(3)
	@Test
	@DisplayName("Timeout")
	void testTimeout() {
		
		assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
			demoUtils.checkTimeout();
		}, "Method should execute in 3 seconds");
		
	}	
	
	@Test
	@DisplayName("Throws and Does not Throw")
	void testThrowsAndDoesNotThrow() {
		
		assertThrows(Exception.class, () -> {
			demoUtils.throwException(-1);
		}, "Should throw exception");
		
		assertDoesNotThrow(() -> {
			demoUtils.throwException(5);
		}, "Should not throw exception");
		
	}
	
	@Test
	@DisplayName("Array Equals")
	void testArrayEquals() {
		String[] stringArray = { "A", "B", "C" };
		
		assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");		
	}
	
	@Test
	@DisplayName("Iterable Equals")
	void testIterableEquals() {
		List<String> theList = List.of("luv", "2", "code");
		
		assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
	}
	
	@Test
	@DisplayName("Lines match")
	void testLinesMatch() {
		List<String> theList = List.of("luv", "2", "code");
		
		assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
	}
	
	@Test
	@DisplayName("True and False")
	void testTrueFalse() {
		
		int gradeOne = 10;
		int gradeTwo = 5;
		
		assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
		assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
		
	}
	
	@Test
	@DisplayName("Same and Not Same")
	void testSameAndNotSame() {
		
		String str = "luv2code";
		
		assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
		assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
		
	}
			
	@Order(-7)
	@Test
	@DisplayName("Equals and Not Equals")
	void testEqualsAndNotEquals() {
								
		System.out.println("Running test: testEqualsAndNotEquals");
		
		// execute and assert
		assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
		assertNotEquals(8, demoUtils.add(2, 4), "2 + 4 must not be 8");
		
	}

	@Order(1)
	@Test
	@DisplayName("Null and Not Null")
	void testNullAndNotNull() {
		
		System.out.println("Running test: testNullAndNotNull");
		
		String str1 = null;
		String str2 = "luv2code";
		
		assertNull(demoUtils.checkNull(str1), "Object shoud be null");
		assertNotNull(demoUtils.checkNull(str2), "Object shoud not be null");
		
	}

	@AfterEach
	void tearDownAfterEach() {
		System.out.println("Running @AfterEach\n");
	}
	
	@BeforeAll
	static void setupBeforeAll() {
		System.out.println("@BeforeAll\n");
	}
	
	@AfterAll
	static void tearDownAfterAll() {
		System.out.println("@AfterAll");
	}
	
}