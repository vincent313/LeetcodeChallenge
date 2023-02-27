package TopLikedQuestion;

import java.util.ArrayList;

/**
 * 300. Longest Increasing Subsequence
 * Medium
 * 16.5K
 * 306
 * company
 * Google
 * company
 * Amazon
 * company
 * Apple
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int max=1;
		if (nums.length==1){return max;}
		ArrayList<Integer> memo= new ArrayList<Integer>();
		memo.add(0);
		memo.add(nums[0]);
		for(int i=1;i<nums.length;i++){
			max=addElement(memo,nums[i],max);
		}
		return max;
	}

	private int addElement(ArrayList<Integer> memo,int currentvalue,int max){
		if(currentvalue>memo.get(max)){
			memo.add(currentvalue);
			return max+1;
		}else if(currentvalue==memo.get(max)){
			return max;
		}

		if(currentvalue<=memo.get(1)){
			memo.set(1,currentvalue);
			return max;
		}

		int index=max;
		while(index>1){
			if(currentvalue>memo.get(index-1)){
				memo.set(index,currentvalue);
				return max;
			}else if(currentvalue==memo.get(index-1)){
				return max;
			}else{
				index--;
			}
		}

		return max;
	}
}
