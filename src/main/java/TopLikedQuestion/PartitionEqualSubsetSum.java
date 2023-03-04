package TopLikedQuestion;
/**
 * 416. Partition Equal Subset Sum
 * Medium
 * 10K
 * 174
 * company
 * Expedia
 * company
 * Facebook
 * company
 * Apple
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * */
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int target=0;
		for(int i:nums){
			target+=i;
		}
		if(target%2!=0){return false;
		}

		target=target/2;

		boolean[] memo=new boolean[target+1];
		memo[0]=true;
		for(int num:nums){
			for(int i=target;i>0;i--){
				if((i-num)>=0){
					memo[i]=memo[i]||memo[i-num];
				}
			}
		}

		return memo[target];
	}

}
