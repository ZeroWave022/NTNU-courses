package assignment3.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RPNCalcTest {

	private RPNCalc calc;

	@BeforeEach
	public void setup() {
		calc = new RPNCalc();
	}

	@Test
	@DisplayName("Push")
	public void testPush() {
		calc.push(1.0);
		assertEquals(1.0, calc.peek(0));

		calc.push(2.0);
		assertEquals(2.0, calc.peek(0));

		calc.push(3.0);
		assertEquals(3.0, calc.peek(0));
	}

	@Test
	@DisplayName("Pop")
	public void testPop() {
		calc.push(1.0);
		calc.push(2.0);
		calc.push(3.0);
		assertEquals(3.0, calc.peek(0));
		assertEquals(3.0, calc.pop());

		assertEquals(2.0, calc.peek(0));
		assertEquals(2.0, calc.pop());

		assertEquals(1.0, calc.peek(0));

		calc.push(2.0);
		assertEquals(2.0, calc.peek(0));
		assertEquals(2.0, calc.pop());

		assertEquals(1.0, calc.peek(0));
		assertEquals(1.0, calc.pop());

		assertEquals(0, calc.getSize());
	}

	@Test
	@DisplayName("Peek")
	public void testPeek() {
		calc.push(0.0);
		calc.push(1.0);
		calc.push(2.0);
		assertEquals(2.0, calc.peek(0));
		assertEquals(1.0, calc.peek(1));
		assertEquals(0.0, calc.peek(2));
	}

	@Test
	@DisplayName("Empty stack")
	public void testEmptyStack() {
		assertEquals(Double.NaN, calc.peek(3));
		assertEquals(Double.NaN, calc.peek(-1));
	}

	@Test
	@DisplayName("Size")
	public void testGetSize() {
		assertEquals(0, calc.getSize());

		calc.push(1.0);
		assertEquals(1, calc.getSize());

		calc.push(2.0);
		assertEquals(2, calc.getSize());
	}

	@Test
	@DisplayName("Addition")
	public void testAddOperation() {
		calc.push(3.0);
		calc.push(4.0);
		calc.performOperation('+');
		assertEquals(1, calc.getSize());
		assertEquals(7.0, calc.peek(0));
	}

	@Test
	@DisplayName("Subtraction")
	public void testSubOperation() {
		calc.push(7.0);
		calc.push(2.0);
		calc.performOperation('-');
		assertEquals(1, calc.getSize());
		assertEquals(5.0, calc.peek(0));
	}

	@Test
	@DisplayName("Multiplication")
	public void testMultOperation() {
		calc.push(5.0);
		calc.push(2.0);
		calc.performOperation('*');
		assertEquals(1, calc.getSize());
		assertEquals(10.0, calc.peek(0));
	}

	@Test
	@DisplayName("Division")
	public void testDivOperation() {
		calc.push(10.0);
		calc.push(4.0);
		calc.performOperation('/');
		assertEquals(1, calc.getSize());
		assertEquals(2.5, calc.peek(0));
	}
}
