package utilities;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(testItemsSet.length, test.size());

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray());
	}

	@Test
	void testAddE() {
		ArraySet<String> test = new ArraySet<>();

		// add all test items
		for (String item : testItems)
			test.add(item);

		// make sure duplicate keys are removed
		assertEquals(testItemsSet.length, test.size());

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray());
	}

	@Test
	void testAddAllCollectionOfQextendsE() {
		ArraySet<String> test = new ArraySet<>();

		test.addAll(Arrays.asList(testItems));
		
		// make sure duplicate keys are removed
		assertEquals(testItemsSet.length, test.size());

		// make sure the lists are equal
		assertArrayEquals(testItemsSet, test._list.toArray());
	}

	@Test
	void testRetainAll() {
		ArraySet<String> test = new ArraySet<>(Arrays.asList(testItems));

		List<String> retainItems = List.of("shark", "whale", "dog");
		
		test.retainAll(retainItems);

		assertEquals(3, test.size());

		assertEquals(retainItems, test._list);
	}

	@Test
	void testRemoveAll() {
		
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		
	}
}