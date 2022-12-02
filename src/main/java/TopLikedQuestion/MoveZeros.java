package TopLikedQuestion;

import java.util.HashSet;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * */
public class MoveZeros {
	public static void main(String[] args) {
		int[] arr={0,1,0,3,12};
		moveZeroes(arr);
		for(int i:arr){
			System.out.print(" "+i);
		}
	}

	public static void moveZeroes(int[] nums) {
		if(nums==null){return;}
		int ptr_All=0;
		int ptr_NoZero=0;

		while(ptr_All<nums.length){
			if(nums[ptr_All]!=0){
				nums[ptr_NoZero]=nums[ptr_All];
				ptr_NoZero++;
			}
			ptr_All++;
		}

		for(int i=ptr_NoZero;i<nums.length;i++){
			nums[i]=0;
		}

	}
	}


