package SortQuestion;
/**
 *
 * 27. Remove Element
 * Easy
 * 5.6K
 * 7.5K
 * company
 * Amazon
 * company
 * Facebook
 * company
 * Apple
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * */
public class Q27RemoveElement {
	class Solution {
		public int removeElement(int[] nums, int val) {
			if(nums.length==0){return 0;}
			int leftPointer=0;
			int rightPointer=nums.length-1;
			boolean leftFlag=false;
			boolean rightFlag=false;

			while(leftPointer<=rightPointer){
				if(nums[leftPointer]==val){
					leftFlag=true;
				}else{
					leftFlag=false;
					leftPointer++;
				}

				if(nums[rightPointer]!=val){
					rightFlag=true;
				}else{
					rightPointer--;
					rightFlag=false;
				}

				if(leftFlag&&rightFlag){
					nums[leftPointer]=nums[rightPointer];
					nums[rightPointer]=val;
				}
			}
			System.out.print(leftPointer);
			return rightPointer+1;
		}
	}
}
