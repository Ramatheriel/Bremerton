package minami.bremerton.zipCode;

import java.util.Collections;
import java.util.List;

/**
* <h1>Zip Codes range simplifier - Bremerton</h1>
* Auxiliary Object - RangeList
* The Object provides two lists to arrange the different
* zip codes so it's easier to use them as return parameters.
* <p>
*
* @author  Meneses, Ricardo
* @version 1.2
* @since   2021-07-06
*/

public class RangeList {
	/**
	 * @param lowerLimit - contains all the lower limits of the zip code ranges
	 * @param upperLimit - contains all the upper limits of the zip code ranges
	 */
	private List<Integer> lowerLimit;
	private List<Integer> upperLimit;
	
	/**
	 * parametrized constructor.
	 */
	public RangeList(List<Integer> lowerLimit, List<Integer> upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	/**
	 * getters and setters for
	 * @param lowerLimit
	 * @param upperLimit
	 */
	public List<Integer> getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(List<Integer> lowerLimit) {
		Collections.sort(lowerLimit);
		this.lowerLimit = lowerLimit;
	}
	
	public List<Integer> getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(List<Integer> upperLimit) {
		Collections.sort(upperLimit);
		this.upperLimit = upperLimit;
	}
	/**
	   * Return the size of the lists based on the smaller list size.
	   * @return [Integer] returns the smaller size between the two lists.
	   */
	public Integer asynchronicSize() {
		if(this.lowerLimit.size() < this.upperLimit.size()) {
			return this.lowerLimit.size();
		} else {
			return this.upperLimit.size();
		}		
	}
	/**
	   * Transforms the elements to an accepted format.
	   * @return [String] returns a zip code range with the specified format.
	   */
	public String printElement(int i) {
		return "[" + this.lowerLimit.get(i) + "-" + this.upperLimit.get(i) + "]";
	}
}
