package stringWeights;

public class WeightedStrings {

	/**
	 * Create a WeightedStrings object that will hold Strings of the specified
	 * "weight"
	 * 
	 * @param weight
	 *            0 <= weight < 1013
	 * @throws IllegalArgumentException
	 *             if the argument violates requirements.
	 */
	public WeightedStrings(int weight) throws IllegalArgumentException {
		// TODO: implement this method
		;
	}

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
	public WeightedStrings(String[] strArray) throws IllegalArgumentException {
		// TODO: implement this method
		;
	}

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
	public static int getStringWeight(String str) {

		// TODO: implement this method
		return -1;

	}

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
	public boolean add(String str) {
		// TODO: Implement this method
		return false;
	}

	/**
	 * Compare two WeightedString objects. Two WeightedString objects are equal
	 * if they contain the same Strings. Note, as with the add() method, that adding the same string multiple times has no impact on equality relative to adding the string once. 
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		// TODO: Implement this method
		return true;
	}

	@Override
	public int hashCode() {
		// TODO: Implement this method
		// Follow the usual rules for hashCode
		return (int) (100 * Math.random());
	}

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
	public boolean equivalent(WeightedStrings other) {
		// TODO: Implement this method
		return true;
	}

}
