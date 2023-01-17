/**
* 
*
*
* @author Michael Leiby
* @date January 17, 2023
*/

package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	void addTestItems(ParallelArrayDictionary<Integer, String> dict) {
		dict.put(1,  "github took a dump today");
		dict.put(2,  "Dr. Alvin");
		dict.put(3,  "igloo");
		dict.put(4,  "alienware");
		dict.put(5,  "eclipse");
	}

	void addMoreTestItems(ParallelArrayDictionary<Integer, String> dict) {
		dict.put(6,  "dingus");
		dict.put(7,  "an kitchen table");
		dict.put(8,  "is it gif or jif?");
		dict.put(9,  "purple telletubby");
		dict.put(10,  "this is the last one, i promise");
	}

	@Test
	void testParallelArrayDictionary() {
		// creating several new ParallelArrayDictionaries to make sure the constructor works
		ParallelArrayDictionary<Integer, Integer> dingus = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Double, String> ParallelArrayDictionary = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Object, Float> status = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Integer, Long> dingalingadingdong = new ParallelArrayDictionary<>();
	}

	ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
	
	@Test
	void testPut() {
		// create a parallelarraydictionary and add several items to it to make sure the put method works
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		
		assertEquals("github took a dump today", pad.put(1,  "github took a dump today"));
		
		assertEquals("Dr. Alvin", pad.put(2,  "Dr. Alvin"));
		
		assertEquals("igloo", pad.put(3,  "igloo"));
		
		assertEquals("alienware", pad.put(4, "alienware"));
		
		// adding an item at a key with a preassigned value
		assertEquals("test", pad.put(1,  "test"));
		
		assertEquals("eclipse", pad.put(5, "eclipse"));
	}
	
	@Test
	void testGet() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		// add several items to the dictionary to run the get method with
		addTestItems(pad);
		
		// test the get method with each item in the parallelarraydictionary
		assertEquals("github took a dump today", pad.get(1));
		
		assertEquals("Dr. Alvin", pad.get(2));
		
		assertEquals("igloo", pad.get(3));
		
		assertEquals("alienware", pad.get(4));
		
		assertEquals("eclipse", pad.get(5));
		
		// add an item where there's already a key, value pair and test the get method
		pad.put(1,  "test");
		
		assertEquals("test", pad.get(1));
	}

	@Test
	void testRemove() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		// add several items to the dictionary to run the get method with
		addTestItems(pad);
		
		// test the remove method with each item in the parallelarraydictionary
		assertEquals("github took a dump today", pad.remove(1));
		
		assertEquals("Dr. Alvin", pad.remove(2));
		
		assertEquals("igloo", pad.remove(3));
		
		assertEquals("alienware", pad.remove(4));
		
		assertEquals("eclipse", pad.remove(5));
		
		// add an item where there's already a key, value pair and test the remove method
		pad.put(1,  "test");
		
		assertEquals("test", pad.remove(1));
	}

	@Test
	void testPutAll() {
		// create two different parallelarraydictonaries for testing the method
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Integer, String> anotherPAD = new ParallelArrayDictionary<>();
		
		// adds items to anotherPAD, put them all into pad, tests to make sure they were added
		addMoreTestItems(anotherPAD);
		
		pad.putAll(anotherPAD);
		
		assertEquals(5, pad.size());
		
		// adds items directly to the pad and checks that they were added
		addTestItems(pad);
		
		assertEquals(10, pad.size());
		
		// clears pad and does the reverse of the previous test (add items to pad, then uses putAll from anotherPAD
		pad.clear();
		
		addTestItems(pad);
		
		pad.putAll(anotherPAD);
		
		assertEquals(10, pad.size());
	}

	@Test
	void testClear() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		// add several items to the dictionary to run the clear method with
		addTestItems(pad);
		
		assertEquals(5, pad.size());
		
		pad.clear();
		
		assertEquals(0, pad.size());
		
		// adds an item back to the parallelarraydictionary and clears it
		pad.put(1,  "test");
		
		pad.clear();
		
		assertEquals(0, pad.size());
	}
}