package TopLikedQuestion;
/***
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */

import java.util.HashMap;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		int n=nums.length/2;

		for(int i:nums){
			Integer num=hashMap.get(i);
			if(num==null){
				num=0;
			}
			num++;
			if (num>n){return i;}
			hashMap.put(i,num);
		}
		return 0;
	}
}
