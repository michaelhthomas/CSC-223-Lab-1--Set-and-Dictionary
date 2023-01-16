package utilities;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		ArraySet<String> test = new ArraySet<>();
		// not really sure what he wants us to do here
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
		
	}

	@Test
	void testRetainAll() {
		
	}

	@Test
	void testRemoveAll() {
		
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		
	}
}