package test.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pt.pedrorijo91.utils.string.StringUtils;

public class StringUtilsTest {

	private static final String WHITESPACE_STRING = "WHITESPACE STRING";
	private static final String MULTI_WHITESPACE_STRING = "WHITESPACE     STRING";
	private static final String TAB_WHITESPACE_STRING = "WHITESPACE\tSTRING";
	private static final String NO_WHITESPACE_STRING = "WHITESPACESTRING";
	private static final String WHITESPACES_STRING = "  \t  \t  ";
	private static final String EMPTY_STRING = "";

	private static final String REMOVABLE_LAST_CHAR_STRING = "REMOVE LAST CHARR";
	private static final String REMOVED_LAST_CHAR_STRING = "REMOVE LAST CHAR";

	private static final String SEPARATOR = "-";
	private static final Object[] OBJECT_ARRAY_SINGLE_ELEM = { "elem1" };
	private static final Object[] OBJECT_ARRAY = { "elem1", "elem2", "elem3" };
	private static final String OBJECT_ARRAY_STRING = "elem1" + SEPARATOR
			+ "elem2" + SEPARATOR + "elem3";

	@Test
	public void testRemoveWhiteSpaceFromEmptyString() {
		assertEquals("Empty string without whitespaces", EMPTY_STRING,
				StringUtils.removeWhiteSpace(EMPTY_STRING));
	}

	@Test
	public void testRemoveWhiteSpace() {
		assertEquals("Whitespaces not removed", NO_WHITESPACE_STRING,
				StringUtils.removeWhiteSpace(WHITESPACE_STRING));
	}

	@Test
	public void testRemoveMultiWhiteSpace() {
		assertEquals("Whitespaces not removed", NO_WHITESPACE_STRING,
				StringUtils.removeWhiteSpace(MULTI_WHITESPACE_STRING));
	}

	@Test
	public void testRemoveTabWhiteSpace() {
		assertEquals("Whitespaces not removed", NO_WHITESPACE_STRING,
				StringUtils.removeWhiteSpace(TAB_WHITESPACE_STRING));
	}

	@Test
	public void testRemoveWhiteSpaceString() {
		assertEquals("Whitespaces string", EMPTY_STRING,
				StringUtils.removeWhiteSpace(WHITESPACES_STRING));
	}

	@Test
	public void testMakeStringArray() {
		assertEquals("Build string from array with given separator",
				OBJECT_ARRAY_STRING,
				StringUtils.makeString(OBJECT_ARRAY, SEPARATOR));
	}

	@Test
	public void testMakeStringArraySingle() {
		assertEquals("Array with one element should print it itself", "elem1",
				StringUtils.makeString(OBJECT_ARRAY_SINGLE_ELEM, SEPARATOR));
	}

	@Test
	public void testRemoveLastChar() {
		assertEquals("Remove only the last char", REMOVED_LAST_CHAR_STRING,
				StringUtils.removeLastChar(REMOVABLE_LAST_CHAR_STRING));
	}

}
