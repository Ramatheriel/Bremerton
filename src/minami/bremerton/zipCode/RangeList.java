package minami.bremerton.zipCode;

import java.util.Collections;
import java.util.List;

public class RangeList {
	
	private List<Integer> inferiorLimit;
	private List<Integer> superiorLimit;
	
	public RangeList(List<Integer> inferiorLimit, List<Integer> superiorLimit) {
		this.inferiorLimit = inferiorLimit;
		this.superiorLimit = superiorLimit;
	}
	
	public List<Integer> getInferiorLimit() {
		return inferiorLimit;
	}
	public void setInferiorLimit(List<Integer> inferiorLimit) {
		Collections.sort(inferiorLimit);
		this.inferiorLimit = inferiorLimit;
	}
	
	public List<Integer> getSuperiorLimit() {
		return superiorLimit;
	}
	public void setSuperiorLimit(List<Integer> superiorLimit) {
		Collections.sort(superiorLimit);
		this.superiorLimit = superiorLimit;
	}
//	========================================================================================================================================
//	Return the size of the lists based on the smaller list size.
//	========================================================================================================================================	
	public Integer asynchronicSize() {
		if(this.inferiorLimit.size() < this.superiorLimit.size()) {
			return this.inferiorLimit.size();
		} else {
			return this.superiorLimit.size();
		}		
	}
//	========================================================================================================================================
//	Transforms the elements to an accepted format.
//	========================================================================================================================================
	public String printElement(int i) {
		return "[" + this.inferiorLimit.get(i) + "-" + this.superiorLimit.get(i) + "]";
	}
}
