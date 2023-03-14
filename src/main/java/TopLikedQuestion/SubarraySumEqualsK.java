/**
 * 560. Subarray Sum Equals K
 * Medium
 * 17.5K
 * 513
 * company
 * Facebook
 * company
 * Mathworks
 * company
 * TikTok
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * Accepted
 * 943.5K
 * Submissions
 * 2.2M
 * Acceptance Rate
 * 43.7%
 * */
package TopLikedQuestion;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		if(nums.length==1){
			if (k==nums[0]){return 1;}else{
				return 0;
			}
		}
		int result=0;
		int currentSum=0;
		Map<Integer,Integer> resultset=new HashMap<Integer,Integer>();
		resultset.put(0,1);
		for(int i=0;i<nums.length;i++){
			currentSum+=nums[i];
			int temp=currentSum-k;
			if(resultset.containsKey(temp)){
				result+=resultset.get(temp);
			}

			if(resultset.containsKey(currentSum)){
				resultset.put(currentSum,resultset.get(currentSum)+1);
			}else{
				resultset.put(currentSum,1);
			}
		}

		return result;

	}
}
