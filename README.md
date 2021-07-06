# Bremerton
 Example application for a code challenge.
 
 The code has to solve the following problem:
 Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.
 
 Extra instructions go as follows:
 - Ranges may be provided in arbitrary order
 - Ranges may or may not overlap
 
 To solve this problem I used an algorithm that compares each superior limit with the next inferior limit after sorting the provided zip codes. The process to solve the problem is depicted in the following pseudo code:
 
 1. Read the input as a String. -1 method
 2. Split the String in different strings on a list with this format: [Inferior limit, Superior limit] - another method
 3. Validate that the inferior limit always is smaller than its superior limit.
 4. Set the list size
 5. Pass each inferior limit to a inferiorLimit array. Sort it
 6. Pass each superior limit to a superiorLimit array. Sort it
 7. Compare the first superior limit with the second inferior limit.
	   a. If the next inferior limit is smaller than the first superior limit, pass both first limit to the initial list as the first element of the new list.
	   b. If the next inferior limit is bigger than the first superior limit, repeat the last method with the new limits. Until it will eventually result in the "a" option.
	   c. In case of error handle it and return a response.
 8. When all the elements have been checked, return the new array object with the new ranges.

The project is composed of two classes.

* Main class Bremerton, that includes the main method and the algorithm methods:
- welcomeMessage() A simple method to print a welcome message so the user can follow easy instructions.
- validateInput() Returns an Array of Strings with the different zip code ranges.
- splitZipCodes() Returns a RangeList object that includes the inferior and superior limits of the zip codes.
- seekAndDestroy() Transforms the RangeList object to remove overlapping zip codes.
- showList() Rearranges the RangeList object to print the result in the desired format.

* RangeList Class, a class used to process the zip code ranges.
  + Variables:
  -  List<Integer> inferiorLimit - A list containing all the inferior limits of the different zip code ranges. 
  -  List<Integer> superiorLimit - A list containing all the superior limits of the different zip code ranges.
  + Methods:
  - asynchronicSize() - returns the size element of the list that is smaller.
  - printElement() - prints each of the code ranges in the manner described.
 
 Notes: 
  - The project works for any number of ranges as long as they're provided in the format specified.
  - There is a validation that in case different information is provided, it will catch the exception and send an error message to the user.
 
 
