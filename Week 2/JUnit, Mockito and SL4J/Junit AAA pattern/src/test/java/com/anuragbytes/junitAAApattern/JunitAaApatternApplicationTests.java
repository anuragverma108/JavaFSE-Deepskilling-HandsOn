package com.anuragbytes.junitAAApattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JunitAaApatternApplicationTests {

	Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() {
		calculator = null;
	}

	@Test
	void testAdd() {
		int a = 5;
		int b = 3;

		int result = calculator.add(a, b);

		assertEquals(8, result, "5 + 3 should equal 8");
	}

	@Test
	void testSubtract() {
		int a = 10;
		int b = 4;

		int result = calculator.subtract(a, b);

		assertEquals(6, result, "10 - 4 should equal 6");
	}

}
