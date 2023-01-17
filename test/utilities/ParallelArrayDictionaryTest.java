package utilities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
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
		assertEquals("github took a dump today", pad.put(1,  "github took a dump today"));
		
		assertEquals("Dr. Alvin", pad.put(2,  "Dr. Alvin"));
		
		assertEquals("igloo", pad.put(3,  "igloo"));
		
		assertEquals("alienware", pad.put(4, "alienware"));
		
		assertEquals("test", pad.put(1,  "test"));
	}

	@Test
	void testGet() {
		
	}

	@Test
	void testRemove() {
		
	}

	@Test
	void testPutAll() {
		
	}

	@Test
	void testClear() {
		
	}
}