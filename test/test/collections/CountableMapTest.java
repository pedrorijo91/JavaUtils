package test.collections;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.pedrorijo91.utils.collections.CountableMap;
import pt.pedrorijo91.utils.exception.NegativeNumberException;

public class CountableMapTest {

	private static final String UNEXISTENT_STRING = "UNEXISTENT_STRING";
	private static final Integer UNEXISTENT_STRING_INCREMENT = 2;
	private static final String EXISTENT_STRING = "EXISTENT_STRING";
	private static final Integer EXISTENT_STRING_COUNT = 3;
	private static final Integer POSITIVE_INCREMENT = 4;
	private static final Integer NEGATIVE_INCREMENT = -1;

	private CountableMap<String> countMap;

	@Before
	public void setUp() throws Exception {
		countMap = new CountableMap<String>();
		countMap.inc(EXISTENT_STRING, EXISTENT_STRING_COUNT);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDefaultCount() {
		assertEquals("Unexistent values should have 0 counting",
				new Integer(0), countMap.get(UNEXISTENT_STRING));
	}

	@Test
	public void testGetExistentCount() {
		assertEquals("Existent object not returning existent counting",
				EXISTENT_STRING_COUNT, countMap.get(EXISTENT_STRING));
	}

	@Test
	public void testIncEmpty() throws NegativeNumberException {
		countMap.inc(UNEXISTENT_STRING, UNEXISTENT_STRING_INCREMENT);
		assertEquals("Default increment should start from 0",
				UNEXISTENT_STRING_INCREMENT, countMap.get(UNEXISTENT_STRING));
	}

	@Test
	public void testIncDefaultExistent() throws NegativeNumberException {
		countMap.inc(EXISTENT_STRING);
		assertEquals("Default increment should start from previous counting",
				new Integer(EXISTENT_STRING_COUNT + 1),
				countMap.get(EXISTENT_STRING));
	}

	@Test
	public void testIncExistent() throws NegativeNumberException {
		countMap.inc(EXISTENT_STRING, POSITIVE_INCREMENT);
		assertEquals("Increment should start from previous counting",
				new Integer(EXISTENT_STRING_COUNT + POSITIVE_INCREMENT),
				countMap.get(EXISTENT_STRING));
	}

	@Test(expected = NegativeNumberException.class)
	public void testIncNegative() throws NegativeNumberException {
		countMap.inc(EXISTENT_STRING, NEGATIVE_INCREMENT);
	}

	@Test
	public void testDecExistent() throws NegativeNumberException {
		countMap.dec(EXISTENT_STRING, POSITIVE_INCREMENT);
		assertEquals("Decrement should start from previous counting",
				new Integer(EXISTENT_STRING_COUNT - POSITIVE_INCREMENT),
				countMap.get(EXISTENT_STRING));
	}

	@Test
	public void testDecDefaultExistent() throws NegativeNumberException {
		countMap.dec(EXISTENT_STRING);
		assertEquals("Default decrement should start from previous counting",
				new Integer(EXISTENT_STRING_COUNT - 1),
				countMap.get(EXISTENT_STRING));
	}

	@Test
	public void testDecEmpty() throws NegativeNumberException {
		countMap.dec(UNEXISTENT_STRING, UNEXISTENT_STRING_INCREMENT);
		assertEquals("Default decrement should start from 0", new Integer(
				-UNEXISTENT_STRING_INCREMENT), countMap.get(UNEXISTENT_STRING));
	}

	@Test(expected = NegativeNumberException.class)
	public void testDecNegative() throws NegativeNumberException {
		countMap.dec(EXISTENT_STRING, NEGATIVE_INCREMENT);
	}
}
