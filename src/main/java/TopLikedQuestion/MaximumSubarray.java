package TopLikedQuestion;
/**
 * 53. Maximum Subarray
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1*/
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int index=0;
		int currentValue=nums[0];
		int maxValue=nums[0];
		int size=nums.length;
		if(size==1){return nums[0];}

		while(index<size-1) {
			index++;
			if(currentValue<0){currentValue=0;}
			currentValue=currentValue+nums[index];
			if(currentValue>maxValue){maxValue=currentValue;}
		}

		return maxValue;
	}
}
