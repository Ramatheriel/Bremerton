package minami.bremerton.zipCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bremerton {
	
//	========================================================================================================================================
//	Main Method.
//	========================================================================================================================================
	public static void main( String[] args ) {		
		welcomeMessage();
		Scanner scn = new Scanner(System.in);
		String zipCodes = scn.nextLine();
		
		String[] zipArray = validateInput(zipCodes);
		
		if(zipArray[0].equals("INPUT ERROR")) {
			
		} else {
			RangeList zipRanges = seekAndDestroy(splitZipCodes(zipArray));
			
			System.out.print("The least amount of zip code ranges are as follows: ");
			System.out.println(Arrays.toString(showList(zipRanges)));
		}		
	}
//	========================================================================================================================================
//	Prints the welcome message for the application.
//	========================================================================================================================================
	public static void welcomeMessage() {
		System.out.println("Hi, welcome to test program Bremerton. This test application will return the least amount of zip code ranges based on an input you give to me.");
		System.out.println("Please insert the input as indicated.");
		System.out.println("Format:[xxxxx,xxxxx] [xxxxx,xxxxx] [xxxxx,xxxxx]...");
		System.out.println("You can enter any number of ranges as long as you enter them the correct way.\n");
		System.out.print("Please enter your input: ");
	}
//	========================================================================================================================================
//	Validates the input and splits the String into an array.
//	========================================================================================================================================	
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
//	========================================================================================================================================
//	Divides the array into an inferior limit and superior limit lists.
//	========================================================================================================================================	
	public static RangeList splitZipCodes(String[] zipCodes) {
		List<Integer> inferior_limit = new ArrayList<Integer>();
		List<Integer> superior_limit = new ArrayList<Integer>();
		
		for (String a : zipCodes) {
				superior_limit.add(Integer.parseInt(a.substring(7, 12)));
				inferior_limit.add(Integer.parseInt(a.substring(1, 6)));
		}
		return new RangeList(inferior_limit, superior_limit);
	}
//	========================================================================================================================================
//	Deletes overlapping ranges and reduces the size of the lists if possible.
//	========================================================================================================================================
	public static RangeList seekAndDestroy(RangeList zipRanges) {
		List<Integer> inferiorLimit = zipRanges.getInferiorLimit();
		List<Integer> superiorLimit = zipRanges.getSuperiorLimit();
		
		int cont = 0;
		if(inferiorLimit.size() > 1) {
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
		}
		return new RangeList(inferiorLimit, superiorLimit);
	}
//	========================================================================================================================================
//	Returns the result with the parameters required
//	========================================================================================================================================
	public static String[] showList(RangeList zipRanges) {
		String[] result = new String[zipRanges.asynchronicSize()];
		for(int i = 0; i < zipRanges.asynchronicSize(); i++) {
			result[i] = zipRanges.printElement(i);
		}
		return result;
	}
}
