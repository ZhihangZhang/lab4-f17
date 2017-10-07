package stringWeights;



import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeightedStringsTest {

	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		WeightedStrings ws1 = new WeightedStrings(1014);
	}

	@Test
	public void test2() {
		// A = 65, n = 110, e = 101, w = 119
		// string weight = 65 + 2*100 + 3*101 + 4*119 = 1064
		// 1064 % 1013 = 51
		WeightedStrings ws1 = new WeightedStrings(51);
		assertTrue(ws1.add("Anew"));
	}

	@Test
	public void test3() {
		// A = 65, N = 78, e = 69, w = 87
		// string weight = 65 + 2*100 + 3*101 + 4*119 = 776
		// 776 % 1013 = 776
		WeightedStrings ws1 = new WeightedStrings(51);
		assertEquals(false, ws1.add("ANEW"));
	}

	@Test
	public void test4() {
		assertEquals(159, WeightedStrings.getStringWeight("Que sera sera!"));
	}

	@Test
	public void test5() {
		assertEquals(WeightedStrings.getStringWeight("Que sera sera!"),
				WeightedStrings.getStringWeight("Que sera sera"));
	}
	
	@Test
	public void test6() {
		String[] strArray1 = { "AC", "CB" };
		WeightedStrings ws1 = new WeightedStrings(strArray1);
		String[] strArray2 = { "QZZYA" };
		WeightedStrings ws2 = new WeightedStrings(strArray2);
		assertTrue(ws1.equivalent(ws2));
	}
	
	@Test
	public void test7() {
		String[] strArray1 = { "AC", "CB" };
		WeightedStrings ws1 = new WeightedStrings(strArray1);
		String[] strArray2 = { "QZZYA" };
		WeightedStrings ws2 = new WeightedStrings(strArray2);
		assertEquals(false, ws1.equals(ws2));		
	}
	
	@Test
	public void test8() {
		String[] strArray1 = { "AC", "CB" };
		WeightedStrings ws1 = new WeightedStrings(strArray1);
		String[] strArray2 = { "CB", "AC" };
		WeightedStrings ws2 = new WeightedStrings(strArray2);
		assertEquals(ws1.hashCode(), ws2.hashCode());				
	}
	
	@Test
	public void test9() {
		String[] strArray1 = { "ABCDB" };
		WeightedStrings ws1 = new WeightedStrings(strArray1);
		assertTrue(ws1.add("accf1000!"));
	}
	
	@Test
	public void test10() {
		String[] strArray1 = { "ABCDB" };
		WeightedStrings ws1 = new WeightedStrings(strArray1);
		assertEquals(false, ws1.add("0ABCDB"));
	}
}
