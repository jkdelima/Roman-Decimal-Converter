package com.jkpd;

import java.util.Scanner;

/**
 * @author Kyle Delima
 * September 19, 2018
 * This is the main class.
 */

public class RomanDecimalConverter {
	public static void main(String[] args) {
		System.out.println("Welcome to the Roman-Decimal Converter. Enter quit to end the program.");
		// Main execution loop
		while(true) {
			// Prompt user to input a value
			System.out.println("Enter a Roman Numeral or Decimal value between 1 and 3999:");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			// If user enters "quit" then the program ends
			if (input.equals("quit")) {
				System.out.println("Program End");
				break;
			}
			// If input is a valid Roman Numeral or Decimal then convert it 
			ConverterInput roman = new RomanNumeral();
			ConverterInput decimal = new Decimal();
			if (roman.isValid(input) && roman.inRange(input)) {
				roman.toDecimal(input); 
			} else if (decimal.isValid(input) && decimal.inRange(input)) {
				decimal.toRoman(input);
			} else { 
				System.out.println("Invalid input, please try again...");
			}	
		}	
	}
}
