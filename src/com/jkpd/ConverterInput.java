package com.jkpd;

/**
 * @author Kyle Delima
 * September 19, 2018
 * This is the interface for different kinds of inputs for a converter.
 */

public abstract class ConverterInput {
	// Roman Numeral constants
	public static final int ROMAN_I = 1;
	public static final int ROMAN_V = 5;
	public static final int ROMAN_X = 10;
	public static final int ROMAN_L = 50;
	public static final int ROMAN_C = 100;
	public static final int ROMAN_D = 500;
	public static final int ROMAN_M = 1000;
	// Methods for converter inputs
	public abstract boolean isValid(String input);
	public abstract boolean inRange(String input);
	public void toDecimal(String input) {
		System.out.println("Convert to Decimal");
	}
	public void toRoman(String input) {
		System.out.println("Convert to Roman");
	}
}
