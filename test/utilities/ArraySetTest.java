/**
* Tests for the ArraySet class.
*
* @author Michael Thomas
* @date January 17, 2023
*/

package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	// test items
	private String[] testItems = new String[] {
		"shark",
		"whale",
		"dog",
		"fox",
		"shark",
		"elephant",
		"donkey",
		"dog"
	};

	// test items without duplicates
	private String[] testItemsSet = new String[] {
		"shark",
		"whale",
		"dog",
		"fox",
		"elephant",
		"donkey"
	};

	@Test
	void testArraySetCollectionOfE() {
		ArraySet<String> test = new ArraySet<>(Arrays.asList(testItems));
		
		// make sure duplicate keys are removed
		assertEquals(testItemsSet.length, test.size(), "duplicate keys were not removed");

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray(), "items in set do not match expected value");
	}

	@Test
	void testAddE() {
		ArraySet<String> test = new ArraySet<>();

		// add all test items
		for (String item : testItems)
			test.add(item);

		// make sure duplicate keys are removed
		assertEquals(testItemsSet.length, test.size(), "duplicate keys were not removed");

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray(), "items in set do not match expected value");
	}

	@Test
	void testAddEDoubles() {
		ArraySet<Double> test = new ArraySet<>();

		List<Double> testDoubles = List.of(1.0, Math.PI, 2.00, Math.PI);

		// add all test items
		for (Double item : testDoubles)
			test.add(item);

		// make sure duplicate keys are removed
		assertEquals(3, test.size(), "duplicate keys were not removed");

		// make sure the lists are equal
		assertEquals(List.of(1.0, Math.PI, 2.00), test._list, "items in set do not match expected value");
	}

	@Test
	void testAddAllCollectionOfQextendsE() {
		ArraySet<String> test = new ArraySet<>();

		test.addAll(Arrays.asList(testItems));
		
		// make sure duplicate keys are removed
		assertEquals(testItemsSet.length, test.size(), "duplicate keys were not removed");

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray(), "items in set do not match expected value");
	}

	@Test
	void testRetainAll() {
		ArraySet<String> test = new ArraySet<>(Arrays.asList(testItems));

		List<String> retainItems = List.of("shark", "whale", "dog");
		
		test.retainAll(retainItems);

		// make sure only three items were preserved
		assertEquals(3, test.size(), "incorrect amount of items preserved");

		// make sure the test items match
		assertEquals(retainItems, test._list, "items in set do not match expected value");
	}

	@Test
	void testRemoveAll() {
		ArraySet<String> test = new ArraySet<>(Arrays.asList(testItems));

		List<String> removeItems = List.of("shark", "whale", "dog");
		
		test.removeAll(removeItems);

		// make sure there are only three values remaining
		assertEquals(3, test.size(), "incorrect amount of items remaining");

		// make sure all of the specified values are no longer present
		for (String item : removeItems)
			assertFalse(test.contains(item), "removed items were still present in the set");
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		ArraySet<Integer> test = new ArraySet<>();

		test.addAll(List.of(1, 2, 3, 4, 5, 6, 1, 2, 3));
		
		// make sure duplicate keys are removed
		assertEquals(6, test.size(), "duplicate keys were not removed");

		// make sure the lists are equal
		assertEquals(List.of(1, 2, 3, 4, 5, 6), test._list, "items in set do not match expected value");
	}
}