package SortQuestion;
/**
* 75. Sort Colors
 * Medium
 * 14.7K
 * 525
 * company
 * Yahoo
 * company
 * Apple
 * company
 * Amazon
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
* */
public class Q75SortColors {
	public void sortColors(int[] nums) {
		int index=sortTwoColor(nums,0,nums.length-1,0,2);
		sortTwoColor(nums,0,index-1,0,1);
		sortTwoColor(nums,index,nums.length-1,1,2);
	}

	private int sortTwoColor(int[] nums,int startIndex,int endIndex ,int smallNum,int largeNum){
		int start=startIndex;
		int end=endIndex;
		int temp;
		while(start<end){
			if(nums[start]==largeNum&&nums[end]==smallNum){
				temp=nums[start];
				nums[start]=nums[end];
				nums[end]=temp;
			}
			while(start<=endIndex&&nums[start]!=largeNum){
				start++;
			}
			while(end>=startIndex&&nums[end]!=smallNum){
				end--;
			}
		}
		return start;
	}
}
