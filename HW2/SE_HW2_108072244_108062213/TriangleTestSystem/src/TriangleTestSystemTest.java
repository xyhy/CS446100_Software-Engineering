import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleTestSystemTest {

	TriangleTestSystem triangle = null;
	@BeforeEach
	void setUp() throws Exception {
		triangle = new TriangleTestSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		triangle = null;
	}

	@Test
	void testGetInput() {
		String result = "Invalid format for an integer. Please input the value again:\n";
		String data = "5.5";
		String data2 = "3";
//		ByteArrayOutputStream tryOut = new ByteArrayOutputStream();
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(data2.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(tryOut));
		System.setIn(testIn2);
		int testOut=triangle.GetInput();
//		assertEquals(result, tryOut.toString());
		assertEquals(Integer.valueOf(data2), testOut);

		
		data = "y";
		data2 = "4";
//		tryOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		testIn2 = new ByteArrayInputStream(data2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
//		System.setOut(new PrintStream(tryOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data2), testOut);
		
		data = "n";
		data2 = "5";
//		tryOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		testIn2 = new ByteArrayInputStream(data2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
//		System.setOut(new PrintStream(tryOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data2), testOut);
		
		data = "q";
		data2 = "6";
//		tryOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		testIn2 = new ByteArrayInputStream(data2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
//		System.setOut(new PrintStream(tryOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data2), testOut);
		
		data = " ";
		data2 = "7";
//		tryOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		testIn2 = new ByteArrayInputStream(data2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
//		System.setOut(new PrintStream(tryOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data2), testOut);
		
		
		data = "-1";
//		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(testOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data), testOut);
		
		data = "1";
//		testOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(testOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data), testOut);
		
		data = "0";
//		testOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(testOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data), testOut);
		
		data = "200";
//		testOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(testOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data), testOut);
		
		data = "201";
//		testOut = new ByteArrayOutputStream();
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
//		System.setOut(new PrintStream(testOut));
		testOut=triangle.GetInput();
		assertEquals(Integer.valueOf(data), testOut);
	}

	
	@Test
	void testCheckLen() {
		assertFalse(triangle.checkLen(-1, 2, 2));
		assertFalse(triangle.checkLen(2, -1, 2));
		assertFalse(triangle.checkLen(2, 2, -1));
		
		assertFalse(triangle.checkLen(-1, -1, 2));
		assertFalse(triangle.checkLen(-1, 2, -1));
		assertFalse(triangle.checkLen(2, -1, -1));
		
		assertFalse(triangle.checkLen(-1, -1, -1));
		
		assertFalse(triangle.checkLen(0, 2, 2));
		assertFalse(triangle.checkLen(2, 0, 2));
		assertFalse(triangle.checkLen(2, 2, 0));
		
		assertFalse(triangle.checkLen(0, 0, 2));
		assertFalse(triangle.checkLen(0, 2, 0));
		assertFalse(triangle.checkLen(2, 0, 0));
		
		assertFalse(triangle.checkLen(0, 0, 0));
		
		assertFalse(triangle.checkLen(201, 200, 200));
		assertFalse(triangle.checkLen(200, 201, 200));
		assertFalse(triangle.checkLen(200, 200, 201));
		
		assertFalse(triangle.checkLen(201, 201, 200));
		assertFalse(triangle.checkLen(201, 200, 201));
		assertFalse(triangle.checkLen(200, 201, 201));
		
		assertFalse(triangle.checkLen(201, 201, 201));
		
		assertFalse(triangle.checkLen(-1, 201, 200));
		assertFalse(triangle.checkLen(-1, 200, 201));
		assertFalse(triangle.checkLen(200, -1, 201));
		assertFalse(triangle.checkLen(201, -1, 200));
		assertFalse(triangle.checkLen(201, 200, -1));
		assertFalse(triangle.checkLen(200, 201, -1));
		
		assertFalse(triangle.checkLen(-1, 201, 201));
		assertFalse(triangle.checkLen(-1, -1, 201));
		assertFalse(triangle.checkLen(201, -1, 201));
		assertFalse(triangle.checkLen(201, -1, -1));
		assertFalse(triangle.checkLen(201, 201, -1));
		assertFalse(triangle.checkLen(-1, 201, -1));
		
		assertTrue(triangle.checkLen(60, 60, 120));
		assertTrue(triangle.checkLen(60, 120, 60));
		assertTrue(triangle.checkLen(120, 60, 60));
		
		assertTrue(triangle.checkLen(200, 200, 200));
		assertTrue(triangle.checkLen(100, 100, 100));
		assertTrue(triangle.checkLen(1, 1, 1));
		
	}
	
	@Test
	void testCheckTraingle() {
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		
		String str = "Equilateral\n";
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(1, 1, 1);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(50, 50, 50);
		assertEquals(str, testOut.toString());

		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 100, 100);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 200, 200);
		assertEquals(str, testOut.toString());
		
		
		str = "Isosceles\n";
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 2, 3);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 3, 2);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(3, 2, 2);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 200, 199);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 199, 200);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(199, 200, 200);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 100, 125);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 125, 100);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(125, 100, 100);
		assertEquals(str, testOut.toString());

		
		str = "Scalene\n";
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 3, 4);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 4, 3);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(3, 2, 4);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(3, 4, 2);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(4, 2, 3);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(4, 3, 2);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 199, 198);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 198, 199);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(199, 200, 198);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(199, 198, 200);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(198, 200, 199);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(198, 199, 200);
		assertEquals(str, testOut.toString());
		
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 120, 80);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 80, 120);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(120, 100, 80);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(120, 80, 100);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(80, 100, 120);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(80, 120, 100);
		assertEquals(str, testOut.toString());
		
		
		str = "NotATriangle\n";
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(1, 1, 2);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(1, 2, 1);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 1, 1);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(1, 2, 3);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(1, 3, 2);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 1, 3);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(2, 3, 1);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(3, 1, 2);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(3, 2, 1);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 100, 200);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(100, 200, 100);
		assertEquals(str, testOut.toString());
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(200, 100, 100);
		assertEquals(str, testOut.toString());
	}
	
	@Test
	void testIntegration() {
		String dataA = "0";
		String dataB = "1";
		String dataC = "2";
		String dataA2 = "1";
		ByteArrayInputStream testIn = new ByteArrayInputStream(dataA.getBytes());
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(dataA2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
		int a=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataB.getBytes());
		System.setIn(testIn);
		int b=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataC.getBytes());
		System.setIn(testIn);
		int c=triangle.GetInput();
		boolean linelength = triangle.checkLen(a,b,c);
		assertTrue(linelength);
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		String result = "NotATriangle\n";
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(a, b, c);
		assertEquals(result, testOut.toString());
		assertNotEquals("Equilateral\n", testOut.toString());
		assertNotEquals("Scalene\n", testOut.toString());
		assertNotEquals("Isosceles\n", testOut.toString());
		
		
		
		dataA = "199";
		dataB = "200";
		dataC = "201";
		String dataC2 = "200";
		testIn = new ByteArrayInputStream(dataA.getBytes());
		System.setIn(testIn);
		a=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataB.getBytes());
		System.setIn(testIn);
		b=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataC.getBytes());
		testIn2 = new ByteArrayInputStream(dataC2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
		c=triangle.GetInput();
		linelength = triangle.checkLen(a,b,c);
		assertTrue(linelength);
		testOut = new ByteArrayOutputStream();
		result = "Isosceles\n";
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(a, b, c);
		assertEquals(result, testOut.toString());
		assertNotEquals("Equilateral\n", testOut.toString());
		assertNotEquals("Scalene\n", testOut.toString());
		assertNotEquals("NotATriangle\n", testOut.toString());
		
		
		
		dataA = "60";
		dataB = "-100";
		String dataB2 = "60";
		dataC = "60";
		testIn = new ByteArrayInputStream(dataA.getBytes());
		System.setIn(testIn);
		a=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataB.getBytes());
		testIn2 = new ByteArrayInputStream(dataB2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
		b=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataC.getBytes());
		System.setIn(testIn);
		c=triangle.GetInput();
		linelength = triangle.checkLen(a,b,c);
		assertTrue(linelength);
		testOut = new ByteArrayOutputStream();
		result = "Equilateral\n";
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(a, b, c);
		assertEquals(result, testOut.toString());
		assertNotEquals("Isosceles\n", testOut.toString());
		assertNotEquals("Scalene\n", testOut.toString());
		assertNotEquals("NotATriangle\n", testOut.toString());
		
		
		
		dataA = "30";
		dataB = "50";
//		String dataB2 = "60";
		dataC = "40";
		testIn = new ByteArrayInputStream(dataA.getBytes());
		System.setIn(testIn);
		a=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataB.getBytes());
//		testIn2 = new ByteArrayInputStream(dataB2.getBytes());
		System.setIn(testIn);
//		System.setIn(testIn2);
		b=triangle.GetInput();
		testIn = new ByteArrayInputStream(dataC.getBytes());
		System.setIn(testIn);
		c=triangle.GetInput();
		linelength = triangle.checkLen(a,b,c);
		assertTrue(linelength);
		testOut = new ByteArrayOutputStream();
		result = "Scalene\n";
		System.setOut(new PrintStream(testOut));
		triangle.checkTriangle(a, b, c);
		assertEquals(result, testOut.toString());
		assertNotEquals("Isosceles\n", testOut.toString());
		assertNotEquals("Equilateral\n", testOut.toString());
		assertNotEquals("NotATriangle\n", testOut.toString());
		
	}
	
}
