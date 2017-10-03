CPEN 221 Lab 4: Weighted Strings and 3D Paths
=========

## Question 1: Weighted Strings
> The skeleton source code for this question is in the package `stringWeights`. You have to implement the required methods in the class `WeightedStrings`.

Let us define the weight of a letter of the alphabet as its ASCII code. In this case, weight('A') = 65, weight('B') = 66, ..., weight('Z') = 90, weight('a') = 97, weight('b') = 98, ..., weight('z') = 122.

We can then define the weight of a string `str` in pseudocode as follows:

```
strWeight = 0;
for( int i = 0; i < str.length(); i++ ) {
    if character at index i in the string is a letter of the alphabet {
			strWeight = (strWeight + (i+1) * weight(character at index i in the string) ) % 1013;
		}
}
```

The weight computation ignores characters that are not in 'A'-'Z' and 'a'-'z'.

Our goal is to implement a datatype `WeightedStrings` that will hold a collection of strings of the same weight.

This datatype should permit the following operations, and **in this task you will implement these operations.**

+ **Constructors**

```java
/**
 * Create a WeightedStrings object that will hold Strings of the specified
 * "weight"
 *
 * @param weight
 *            0 <= weight < 1013
 * @throws IllegalArgumentException
 *             if the argument violates requirements.
 */
public WeightedStrings(int weight) throws IllegalArgumentException

/**
 * Create a WeightedStrings object using the given array of Strings. All
 * Strings should be of the same weight and the array should not be empty
 * otherwise an IllegalArgumentException should be thrown.
 *
 * @param strArray
 *            strArray.length > 0 and all Strings in this array should have
 *            the same "weight"
 * @throws IllegalArgumentException
 *             if the input arguments do not satisfy the requirements
 */
public WeightedStrings(String[] strArray) throws IllegalArgumentException
```

+ **A `static` helper method**

```java
/**
	 * Compute the "weight" of a given String. The weight is computed as the sum
	 * over i in [0, str.length()-1] of (i+1)*(weight of character at position
	 * i) modulo 1013 for all characters that are alphabets and other characters
	 * are ignored. The weight of a character is its ASCII value: weight(A) =
	 * 65, weight(B) = 66, ..., weight(Z) = 90, and weight(a) = 97, ...,
	 * weight(z) = 122.
	 *
	 * @param str
	 *            is not null
	 * @return weight of the given string
	 */
	public static int getStringWeight(String str)
```

+ **A mutator**

```java
/**
 * Add a new String to the WeightedStrings object. The new string should
 * have the same weight as other strings in this collection. Adding the same
 * String multiple times makes no difference when compared with adding that
 * String once.
 *
 * @param str
 *            to add to WeightedStrings. It should not be null and its
 *            weight should match the weight of other Strings in this
 *            object.
 * @returns true if str was added to this object (matches weight) and false
 *          otherwise.
 */
public boolean add(String str)
```

+ **Comparison operations**

```java
/**
 * Compare two WeightedString objects. Two WeightedString objects are equal
 * if they contain the same Strings. Note, as with the add() method, that
 * adding the same string multiple times has no impact on equality relative
 * to adding the string once.
 *
 */
@Override
public boolean equals(Object other)

/**
 * Implement hashCode using the usual rules
 */
@Override
public int hashCode()

/**
 * Verify if two WeightedStrings are equivalent. Two WeightedStrings are
 * equivalent if they are intended to contain Strings of the same weight
 * even if the actual strings they contain are different. One of the
 * WeightedStrings may not even contain any strings; only its weight may be
 * set but that is sufficient to perform the equivalence test.
 *
 * @param other
 * @return true if the other WeightedString is equivalent to this.
 */
public boolean equivalent(WeightedStrings other)
```

### Test Cases

```java
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
```

## Question 2: Counting 3D Paths

> The skeleton source code for this question is in the package `threeDpaths`. You have to implement the method `numPaths` in the `ThreeDWalks` class.

You want to walk from the origin (0, 0, 0) to the point (l, m, n) in three-dimensional space (the X-Y-Z space). Each step is along exactly one dimension.

At each step, you are permitted to move an integer number of units along the chosen direction. At each step, one can choose the direction of travel but the number of units moved is as follows. You always move in the positive direction along the chosen direction so you never move backwards.

At step _k_:
- if _k % 3 == 1_ then move 1 unit along the chosen direction/dimension.
- if _k % 3 == 2_ then move 2 units along the chosen direction/dimension.
- if _k % 3 == 0_ then move 3 units along the chosen direction/dimension.

Naturally the first step is _k = 1_ (not _k = 0_).

The only exception to the above rule is the last step, when one can move fewer than the number of units dictated above. For example, if it took 29 steps to get to (l, m, n-1) then we can move 1 unit along the Z dimension even though this is the 30th step and one would have normally had to move 3 units.

Implement a method `numPaths` that returns the number of unique paths from the origin to (l, m, n) where l, m and n are arguments to `numPaths`.

### Examples

+ `numPaths(0, 0, 0)`
	+ Returns: 1
	+ There is one path, which involves no movement.

+ `numPaths(1, 1, 1)`
	+ Returns: 0
	+ There is no path given that the special rule regarding the number of units moved applies only to the last step. Here, after the first step, we cannot move in any direction without overshooting (1, 1, 1) but we cannot also reach (1, 1, 1) from, say, (1, 0, 0) in 1 step.

+ `numPaths(1, 1, 2)`
	+ Returns: 2
	+ There are two paths. The first path involves 1 unit along the X axis, 2 units along the Z axis and then 1 unit along the Y axis. The second path involves 1 unit along the Y axis, 2 units along the Z axis and 1 unit along the X axis.

+ `numPaths(0, 5, 0)`
	+ Returns: 1
	+ There is one path, which involves taking all steps along the Y axis: 1 unit, 2 units and then 2 more units.

+ `numPaths(1, 2, 3)`
	+ Returns: 1

+ `numPaths(2, 2, 2)`
	+ Returns: 0

+ `numPaths(3, 3, 3)`
	+ Returns: 12

+ `numPaths(4, 4, 4)`
	+ Returns: 12



## What Should You Implement / Guidelines

These questions can be considered practice for the programming proficiency tests so you should take note of the following:

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.
