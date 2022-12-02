package TopLikedQuestion;

import java.util.Arrays;
/**136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *  */
public class SingleNumber {
	public static void main(String[] args) {
		int[] arr={1,9,3,7,5,5,7,3,9,1,8,8};
		int a=singleNumber(arr);
		System.out.println(a);
	}
		public static int singleNumber(int[] nums) {
			if(nums.length==1){
				return nums[0];
			}
			int num=0;
			Arrays.sort(nums);

			for(int i=0;i<nums.length;i+=2){
				if(i==nums.length-1){
					return nums[i-1];

				}
				if(nums[i]!=nums[i+1]){
					return nums[i];
				}
			}
			return num;
		}

}
