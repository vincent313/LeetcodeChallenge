package TopLikedQuestion;

/**
 * 152. Maximum Product Subarray
 * Medium

 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * */
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		if(nums.length==1){return nums[0];}
		int maxValue=nums[0];
		int currentMax=nums[0];
		int currentMin=nums[0];

		for(int i=1;i<nums.length;i++){
			int mn=getMin(nums[i],currentMin,currentMax);
			int mx=getMax(nums[i],currentMin,currentMax);
			//  System.out.println(currentMax);
			currentMax=mx;
			currentMin=mn;
			if (currentMax>maxValue){
				maxValue=currentMax;

			}
		}
		return maxValue;
	}

	private int getMin(int current,int currentMin,int currentMax){
		int res=current;
		if(current*currentMin<res){res=current*currentMin;}
		if(current*currentMax<res){res=current*currentMax;}
		System.out.println("min "+res);
		return res;
	}

	private int getMax(int current,int currentMin,int currentMax){
		int res=current;
		if(current*currentMin>res){res=current*currentMin;}
		if(current*currentMax>res){res=current*currentMax;}
		return res;
	}
}
