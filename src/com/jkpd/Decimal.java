package com.jkpd;

/**
 * @author Kyle Delima
 * September 19, 2018
 * This class handles Decimal inputs.
 */

public class Decimal extends ConverterInput{
	public static final int MIN_RANGE = 1;
	public static final int MAX_RANGE = 3999;
	// This method makes sure the input is a valid Decimal (repetitive check like the one in the main method but wanted to fill it regardless)
	@Override
	public boolean isValid(String input) {
		// Check input using regular expressions to see if it only contains digits
		if (input.matches("[0-9]+")) {
			return true;
		} else {
			return false;
		}
	}
	// This method makes sure the input Decimal is in Range
	@Override
	public boolean inRange(String input) {
		int inputInt = Integer.parseInt(input);
		// Check input if it is within the range
		if (inputInt >= MIN_RANGE && inputInt <= MAX_RANGE) {
			return true;
		} else {
			return false;
		}
	}
	// This method converts the Decimal value from input into Roman Numeral and prints the output
	public void toRoman(String input) {
		String output = "";
		for (int i=0; i < input.length(); i++) { // Iterate over string
			char ch = input.charAt(i); // Char value at smallest digit
			int pos = input.length() - i - 1; // Position of digit
			int val = Character.getNumericValue(ch);
			if (val==4 || val==9) {
				output = output + handle49(pos, val);
			} else if (val>=1) {
				output = output + handleOther(pos,val);
			} 
		}
		System.out.println(output);
	}
	// This method handles decimals that contain 4's or 9's, special cases
	private String handle49(int pos, int val) {
		String output = "";
		if (pos==0) {
			if (val==4) { output = "IV"; }
			else if (val==9) { output = "IX"; }
		} else if (pos==1) {
			if (val==4) { output = "XL"; }
			else if (val==9) { output = "XC"; }
		} else if (pos==2) {
			if (val==4) { output = "CD"; }
			else if (val==9) { output = "CM"; }
		}
		return output;
	}
	// This method handles numbers between 1 and 8 except 4
	private String handleOther(int pos, int val) {
		String output = "";
		if (pos==0) {
			if (val>=5) { 
				val = val - 5;
				output = "V"; // Add V if greater than 5
			}
			for (int i=0; i < val; i++) {
				output = output + "I"; // Add I's as needed
			}
		} else if (pos==1) {
			if (val>=5) { 
				val = val - 5;
				output = "L"; // Add L if greater than 5
			}
			for (int i=0; i < val; i++) {
				output = output + "X"; // Add X's as needed
			}
		} else if (pos==2) {
			if (val>=5) { 
				val = val - 5;
				output = "D"; // Add D if greater than 5
			}
			for (int i=0; i < val; i++) {
				output = output + "C"; // Add C's as needed
			}
		} else if (pos==3) {
			for (int i=0; i < val; i++) {
				output = output + "M"; // Add M's as needed, no need to check for greater than 5
			}
		}
		return output;
	}
}
