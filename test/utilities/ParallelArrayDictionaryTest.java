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
		ParallelArrayDictionary<Integer, Integer> dingus = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Double, String> ParallelArrayDictionary = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Object, Float> status = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Integer, Long> dingalingadingdong = new ParallelArrayDictionary<>();
	}

	ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
	
	@Test
	void testPut() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		
		assertEquals("github took a dump today", pad.put(1,  "github took a dump today"));
		
		assertEquals("Dr. Alvin", pad.put(2,  "Dr. Alvin"));
		
		assertEquals("igloo", pad.put(3,  "igloo"));
		
		assertEquals("alienware", pad.put(4, "alienware"));
		
		assertEquals("test", pad.put(1,  "test"));
		
		assertEquals("eclipse", pad.put(5, "eclipse"));
	}
	
	@Test
	void testGet() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		addTestItems(pad);
		
		assertEquals("github took a dump today", pad.get(1));
		
		assertEquals("Dr. Alvin", pad.get(2));
		
		assertEquals("igloo", pad.get(3));
		
		assertEquals("alienware", pad.get(4));
		
		assertEquals("eclipse", pad.get(5));
		
		pad.put(1,  "test");
		
		assertEquals("test", pad.get(1));
	}

	@Test
	void testRemove() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		addTestItems(pad);
		
		assertEquals("github took a dump today", pad.remove(1));
		
		assertEquals("Dr. Alvin", pad.remove(2));
		
		assertEquals("igloo", pad.remove(3));
		
		assertEquals("alienware", pad.remove(4));
		
		assertEquals("eclipse", pad.remove(5));
		
		pad.put(1,  "test");
		
		assertEquals("test", pad.remove(1));
	}

	@Test
	void testPutAll() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		
		ParallelArrayDictionary<Integer, String> anotherPAD = new ParallelArrayDictionary<>();
		addMoreTestItems(anotherPAD);
		
		pad.putAll(anotherPAD);
		
		assertEquals(5, pad.size());
		
		addTestItems(pad);
		
		assertEquals(10, pad.size());
		
		pad.clear();
		
		addTestItems(pad);
		
		pad.putAll(anotherPAD);
		
		assertEquals(10, pad.size());
	}

	@Test
	void testClear() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		addTestItems(pad);
		
		assertEquals(5, pad.size());
		
		pad.clear();
		
		assertEquals(0, pad.size());
		
		pad.put(1,  "test");
		
		pad.clear();
		
		assertEquals(0, pad.size());
	}
}