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
		pad.put(1,  "github took a dump today");
		pad.put(2,  "Dr. Alvin");
		pad.put(3,  "igloo");
		pad.put(4,  "alienware");
		pad.put(5,  "eclipse");
		
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
		pad.put(1,  "github took a dump today");
		pad.put(2,  "Dr. Alvin");
		pad.put(3,  "igloo");
		pad.put(4,  "alienware");
		pad.put(5,  "eclipse");
		
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
		anotherPAD.put(6,  "dingus");
		anotherPAD.put(7,  "an kitchen table");
		anotherPAD.put(8,  "is it gif or jif?");
		anotherPAD.put(9,  "purple telletubby");
		anotherPAD.put(10,  "this is the last one, i promise");
		
		pad.putAll(anotherPAD);
		
		assertEquals(5, pad.size());
		
		pad.put(1,  "github took a dump today");
		pad.put(2,  "Dr. Alvin");
		pad.put(3,  "igloo");
		pad.put(4,  "alienware");
		pad.put(5,  "eclipse");
		
		assertEquals(10, pad.size());
		
		pad.clear();
		
		pad.put(1,  "github took a dump today");
		pad.put(2,  "Dr. Alvin");
		pad.put(3,  "igloo");
		pad.put(4,  "alienware");
		pad.put(5,  "eclipse");
		
		pad.putAll(anotherPAD);
		
		assertEquals(10, pad.size());
	}

	@Test
	void testClear() {
		ParallelArrayDictionary<Integer, String> pad = new ParallelArrayDictionary<>();
		pad.put(1,  "github took a dump today");
		pad.put(2,  "Dr. Alvin");
		pad.put(3,  "igloo");
		pad.put(4,  "alienware");
		pad.put(5,  "eclipse");
		
		assertEquals(5, pad.size());
		
		pad.clear();
		
		assertEquals(0, pad.size());
		
		pad.put(1,  "test");
		
		pad.clear();
		
		assertEquals(0, pad.size());
	}
}