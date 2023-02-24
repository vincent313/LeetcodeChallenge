package TopLikedQuestion;
/**
 * 287. Find the Duplicate Number
 * Medium
 * 18.2K
 * 2.6K
 * company
 * Amazon
 * company
 * Adobe
 * company
 * Microsoft
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *  */
public class FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int fast=nums[nums[0]];
		fast=nums[fast];
		int slow=nums[nums[0]];

		while(fast!=slow){
			slow=nums[slow];
			fast=nums[fast];
			fast=nums[fast];

		}

		slow=nums[0];
		while(slow!=fast){
			slow=nums[slow];
			fast=nums[fast];
		}

		return slow;
	}
}
