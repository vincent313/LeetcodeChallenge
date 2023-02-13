package TopLikedQuestion;
/**
 *238. Product of Array Except Self
 * Medium
 * 16.4K
 * 906
 * company
 * Amazon
 * company
 * Microsoft
 * company
 * Adobe
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 * */
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int size=nums.length;
		int[] result=new int[size];
		if(size==2){
			result[0]=nums[1];
			result[1]=nums[0];
			return result;
		}
		int[] forward=new int[size];
		int[] backward=new int[size];
		forward[0]=nums[0];
		for(int i=1;i<size-1;i++){
			forward[i]=forward[i-1]*nums[i];
		}

		backward[size-1]=nums[size-1];
		for(int i=size-2;i>=1;i--){
			backward[i]=backward[i+1]*nums[i];
		}
		result[0]=backward[1];
		result[size-1]=forward[size-2];
		for(int i=1;i<size-1;i++){
			result[i]=forward[i-1]*backward[i+1];
		}
		return result;
	}
}
