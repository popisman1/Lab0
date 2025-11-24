package se.hig.aod.lab0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

	private LinkedList<Integer> listUnderTest;
	private final int[] fixture = { 1, 2, 3, 4, 5 };

	/**
	 * Resets list to a new empty LinkedList-instance before each test method is
	 * executed.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTest = new LinkedList<Integer>();
	}

	/**
	 * Sets list to null after each test method is executed.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTest = null;
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testEmptyListIsEmpty() {
		assertTrue(listUnderTest.isEmpty(), "An empty list instance should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testInitializedListIsNotEmpty() {
		initializeList();
		assertFalse(listUnderTest.isEmpty(), "A list instance containing elements should not be empty");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearOnEmptyList() {
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty(), "An empty list instance that is cleared should not contain any item");
	}

	/*
	 * Skriv fler test-metoder själv........................
	 */

	/**
	 * Test method for numberOfElements() on empty list.
	 */
	@Test
	public void testNumberOfElementsOnEmptyList() {
		assertEquals(0, listUnderTest.numberOfElements(), "Empty list should contain 0 elements");
	}

	/**
	 * Test method for numberOfElements() on initialized list.
	 */
	@Test
	public void testNumberOfElementsOnInitializedList() {
		initializeList();
		assertEquals(fixture.length, listUnderTest.numberOfElements(),
				"Initialized list should contain fixture.length elements");
	}

	/**
	 * Test clear() on initialized list.
	 */
	@Test
	public void testClearOnInitializedList() {
		initializeList();
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty(), "Cleared list should be empty");
		assertEquals(0, listUnderTest.numberOfElements(), "Cleared list should contain 0 elements");
	}

	/**
	 * Test insertFirst() on empty list.
	 */
	@Test
	public void testInsertFirstOnEmptyList() {
		listUnderTest.insertFirst(10);
		assertFalse(listUnderTest.isEmpty(), "List should not be empty after insertFirst");
		assertEquals(1, listUnderTest.numberOfElements(),
				"List should contain 1 element after insertFirst on empty list");
		assertEquals(10, listUnderTest.getFirst(), "First element should be the one just inserted");
	}

	/**
	 * Test insertFirst() on initialized list.
	 */
	@Test
	public void testInsertFirstOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		listUnderTest.insertFirst(99); // [99, 1, 2, 3, 4, 5]

		assertEquals(99, listUnderTest.getFirst(), "First element should be the one inserted at the front");
		assertEquals(fixture.length + 1, listUnderTest.numberOfElements(),
				"List size should increase by 1 after insertFirst");
	}

	/**
	 * Test insertLast() on empty list.
	 */
	@Test
	public void testInsertLastOnEmptyList() {
		listUnderTest.insertLast(20);
		assertFalse(listUnderTest.isEmpty(), "List should not be empty after insertLast");
		assertEquals(1, listUnderTest.numberOfElements(),
				"List should contain 1 element after insertLast on empty list");
		assertEquals(20, listUnderTest.getFirst(), "First element should be the one just inserted");
		assertEquals(20, listUnderTest.getLast(), "Last element should be the one just inserted");
	}

	/**
	 * Test insertLast() on initialized list.
	 */
	@Test
	public void testInsertLastOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		listUnderTest.insertLast(99); // [1, 2, 3, 4, 5, 99]

		assertEquals(1, listUnderTest.getFirst(), "First element should stay the same after insertLast");
		assertEquals(99, listUnderTest.getLast(), "Last element should be the one inserted at the end");
		assertEquals(fixture.length + 1, listUnderTest.numberOfElements(),
				"List size should increase by 1 after insertLast");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(),
				"GetFirst() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnInitializedList() {
		initializeList();
		assertEquals(1, listUnderTest.getFirst(), "GetFirst() should return first element in list");
	}

	/*
	 * Skriv fler test-metoder själv........................
	 */

	/**
	 * Test getLast() on empty list.
	 */
	@Test
	public void testGetLastOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getLast(),
				"getLast() on empty list should throw ListEmptyException");
	}

	/**
	 * Test getLast() on initialized list.
	 */
	@Test
	public void testGetLastOnInitializedList() {
		initializeList();
		assertEquals(5, listUnderTest.getLast(), "getLast() should return last element in list");
	}

	/**
	 * Test removeFirst() on empty list.
	 */
	@Test
	public void testRemoveFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.removeFirst(),
				"removeFirst() on empty list should throw ListEmptyException");
	}

	/**
	 * Test removeFirst() on initialized list.
	 */
	@Test
	public void testRemoveFirstOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		int removed = listUnderTest.removeFirst(); // [2, 3, 4, 5]

		assertEquals(1, removed, "removeFirst() should return the first element");
		assertEquals(2, listUnderTest.getFirst(), "New first element should be the second element from original list");
		assertEquals(fixture.length - 1, listUnderTest.numberOfElements(),
				"List size should decrease by 1 after removeFirst()");
	}

	/**
	 * Test removeLast() on empty list.
	 */
	@Test
	public void testRemoveLastOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.removeLast(),
				"removeLast() on empty list should throw ListEmptyException");
	}

	/**
	 * Test removeLast() on initialized list.
	 */
	@Test
	public void testRemoveLastOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		int removed = listUnderTest.removeLast(); // [1, 2, 3, 4]

		assertEquals(5, removed, "removeLast() should return the last element");
		assertEquals(1, listUnderTest.getFirst(), "First element should remain unchanged after removeLast()");
		assertEquals(4, listUnderTest.getLast(), "New last element should be the element before the removed one");
		assertEquals(fixture.length - 1, listUnderTest.numberOfElements(),
				"List size should decrease by 1 after removeLast()");
	}

	private void initializeList() {
		for (int i = 0; i < fixture.length; i++) {
			listUnderTest.insertLast(fixture[i]);
		}
	}

	/**
	 * Test toStringRecursive() on empty list.
	 */
	@Test
	public void testToStringRecursiveOnEmptyList() {
		assertEquals("[]", listUnderTest.toStringRecursive(), "toStringRecursive() on empty list should return []");
	}

	/**
	 * Test toStringRecursive() on initialized list.
	 */
	@Test
	public void testToStringRecursiveOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		assertEquals("[1, 2, 3, 4, 5]", listUnderTest.toStringRecursive(),
				"toStringRecursive() should return elements in insertion order");
	}

	/**
	 * Test toStringReverseRecursive() on empty list.
	 */
	@Test
	public void testToStringReverseRecursiveOnEmptyList() {
		assertEquals("[]", listUnderTest.toStringReverseRecursive(),
				"toStringReverseRecursive() on empty list should return []");
	}

	/**
	 * Test toStringReverseRecursive() on initialized list.
	 */
	@Test
	public void testToStringReverseRecursiveOnInitializedList() {
		initializeList(); // [1, 2, 3, 4, 5]
		assertEquals("[5, 4, 3, 2, 1]", listUnderTest.toStringReverseRecursive(),
				"toStringReverseRecursive() should return elements in reverse order");
	}
	// test commit

}
