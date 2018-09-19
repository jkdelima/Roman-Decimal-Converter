package com.jkpd;

/**
 * @author Kyle Delima
 * September 4, 2018
 * Amalto Technical Test
 * This class handles Roman Numeral inputs.
 */

public class RomanNumeral extends ConverterInput{
	// This method makes sure the input is a valid Roman Numeral
	@Override
	public boolean isValid(String input) {
		// Check input using regular expressions to pattern match with Roman Numeral requirements
		// Used the following as reference (with minor edits for case insensitivity and allow white space after for this case):
		// https://www.safaribooksonline.com/library/view/regular-expressions-cookbook/9780596802837/ch06s09.html
		if (input.matches("(?i)(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})\\s*")){
			return true;
		} else {
			return false;
		}
	}
	// This method makes sure the input Roman Numeral is in Range
	@Override
	public boolean inRange(String input) {
		// Check input to see if there are 4 or more consecutive M's (greater than 3999) using regular expressions
		if (input.matches("(?i)M{4,}.*")) {
			return false;
		} else {
			return true;
		}
	}
	// This method converts the Roman Numeral value from input into Decimal and prints the output
	public void toDecimal(String input) {
		String output = "";
		String container = input.toUpperCase(); // Make input string all upper case
		int size = container.length(); // Size of input
		int outputInt = 0; // Will hold our decimal value
		for (int i=0; i < size; i++) { // Iterate over string
			char ch = container.charAt(i); // Char value on current digit
			if (ch=='M') {
				outputInt += ROMAN_M;
			} else if (ch=='D') {
				outputInt += ROMAN_D;
			} else if (ch=='C') {
				if (i+1==size) { // Check if last char
					outputInt += ROMAN_C;
				} else if (container.charAt(i+1)=='M') {
					outputInt += ROMAN_M - ROMAN_C;
					i++;
				} else if (container.charAt(i+1)=='D') {
					outputInt += ROMAN_D - ROMAN_C;
					i++;
				} else {
					outputInt += ROMAN_C;
				}
			} else if (ch=='L') {
				outputInt += ROMAN_L;
			} else if (ch=='X') {
				if (i+1==size) { // Check if last char
					outputInt += ROMAN_X;
				} else if (container.charAt(i+1)=='C') {
					outputInt += ROMAN_C - ROMAN_X;
					i++;
				} else if (container.charAt(i+1)=='L') {
					outputInt += ROMAN_L - ROMAN_X;
					i++;
				} else {
					outputInt += ROMAN_X;
				}
			} else if (ch=='V') {
				outputInt += ROMAN_V;
			} else if (ch=='I') {
				if (i+1==size) { // Check if last char
					outputInt += ROMAN_I;
				} else if (container.charAt(i+1)=='X') {
					outputInt += ROMAN_X - ROMAN_I;
					i++;
				} else if (container.charAt(i+1)=='V') {
					outputInt += ROMAN_V - ROMAN_I;
					i++;
				} else {
					outputInt += ROMAN_I;
				}
			}
		}
		output = Integer.toString(outputInt); // Convert int to string
		System.out.println(output);
	}
}
