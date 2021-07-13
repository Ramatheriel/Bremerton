package minami.bremerton.zipCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
* <h1>Zip Codes range simplifier - Bremerton</h1>
* This sample code The code solves the following problem: 
* Given a collection of 5-digit ZIP code ranges 
* (each range includes both their upper and lower bounds), provide an algorithm 
* that produces the minimum number of ranges required to represent the same 
* restrictions as the input.
* <p>
*
* @author  Meneses, Ricardo
* @version 1.2
* @since   2021-07-06
*/

public class Bremerton {
	
	/**
	   * This is the main method which makes use of the core logic.
	   * @param args Unused.
	   */
	public static void main( String[] args ) {		
		
		welcomeMessage();
		Scanner scn = new Scanner(System.in);
		String zipCodes = scn.nextLine();
		
		String[] zipArray = validateInput(zipCodes);
		
		if(zipArray[0].equals("INPUT ERROR")) {
			
		} else {
			RangeList zipRanges = reduceRanges(splitZipCodes(zipArray));
			
			System.out.print("The least amount of zip code ranges are as follows: ");
			System.out.println(Arrays.toString(showList(zipRanges)));
		}		
	}
	/**
	   * Prints the welcome message for the application.
	   */
	public static void welcomeMessage() {
		System.out.println("Hi, welcome to test program Bremerton. This test application will return the least amount of zip code ranges based on an input you give to me.");
		System.out.println("Please insert the input as indicated.");
		System.out.println("Format:[xxxxx,xxxxx] [xxxxx,xxxxx] [xxxxx,xxxxx]...");
		System.out.println("You can enter any number of ranges as long as you enter them the correct way.\n");
		System.out.print("Please enter your input: ");
	}
	
	/**
	   * Validates the input and splits the String into an array.
	   * @param zipCodeRanges [String] parameter containing all the
	   * zip code ranges.
	   * @return [String (Array)] returns an array with the different ranges.
	   */
	public static String[] validateInput(String zipCodeRanges) {
		try {
			String zipCodes = zipCodeRanges.replaceAll("\\s+"," ").trim();
			String[] zipArray = zipCodes.split(" ", 0);
			return zipArray;
		} catch(Exception e) {
			String[] zipArray = {"INPUT ERROR"};
			return zipArray;
		}		
		
	}
	
	/**
	   * Divides the array into an "lower" limit and "upper" limit lists.
	   * @param [String (Array)] zipCodes String parameter containing all the
	   * zip code ranges. Each array refers a zip code range.
	   * @return [RangeList] returns an object with a list with all the "upper limits" and 
	   * another list with all the "lower limits".
	   */
	public static RangeList splitZipCodes(String[] zipCodes) {
		List<Integer> inferior_limit = new ArrayList<Integer>();
		List<Integer> superior_limit = new ArrayList<Integer>();
		
		for (String a : zipCodes) {
			if(a.length() == 13) {
				superior_limit.add(Integer.parseInt(a.substring(7, 12)));
				inferior_limit.add(Integer.parseInt(a.substring(1, 6)));
			}
		}
		return new RangeList(inferior_limit, superior_limit);
	}
	/**
	   * Deletes overlapping ranges and reduces the size of the lists if possible.
	   * @param [RangeList] contains a list with all the "upper limits" and 
	   * another list with all the "lower limits".
	   * @return [RangeList] returns an object with a list with all the "upper limits" and 
	   * another list with all the "lower limits".
	   */
	public static RangeList reduceRanges(RangeList zipRanges) {
		List<Integer> inferiorLimit = zipRanges.getLowerLimit();
		List<Integer> superiorLimit = zipRanges.getUpperLimit();
		
		int cont = 0;
		if(inferiorLimit.size() > 1) {
			if(inferiorLimit.get(cont) <= superiorLimit.get(cont)) {
				do {
					if(cont+1 < inferiorLimit.size()) {
						if(inferiorLimit.get(cont+1) > superiorLimit.get(cont)) {
							cont++;
						} else {
							inferiorLimit.remove(cont+1);
							superiorLimit.remove(cont);
						}
					} else {
						cont++;
					}
				} while(cont < inferiorLimit.size());
			} else {
				inferiorLimit.remove(cont);
				superiorLimit.remove(cont);
			}
		}
		return new RangeList(inferiorLimit, superiorLimit);
	}
	/**
	   * Returns the result with the parameters required, inverted method of 
	   * splitZipCodes.
	   * @param [RangeList] contains a list with all the "upper limits" and 
	   * another list with all the "lower limits".
	   * @return [String (Array)] return an array containing all the
	   * zip code ranges. Each element refers a zip code range.
	   */
	public static String[] showList(RangeList zipRanges) {
		String[] result = new String[zipRanges.asynchronicSize()];
		for(int i = 0; i < zipRanges.asynchronicSize(); i++) {
			result[i] = zipRanges.printElement(i);
		}
		return result;
	}
}
