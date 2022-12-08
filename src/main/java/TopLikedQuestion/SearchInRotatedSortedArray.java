package TopLikedQuestion;
/**
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.*/
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums==null||nums.length==0){return -1;}
		if(nums[0]<=nums[nums.length-1]){
			return getMidValue(0,nums.length-1,nums,target);
		}
		int leftIndex=0;
		int rightIndex=nums.length-1;
		int midIndex=0;
		while(leftIndex<rightIndex){
			midIndex=(leftIndex+rightIndex)/2;
			if(nums[midIndex]>nums[rightIndex]){
				leftIndex=midIndex+1;
			}else{
				rightIndex=midIndex;
			}
		}
		midIndex=leftIndex;
		if(target>nums[nums.length-1]){
			return getMidValue(0,midIndex-1,nums,target);
		}else{
			return getMidValue(midIndex,nums.length-1,nums,target);
		}

	}

	public int getMidValue(int leftIndex,int rightIndex,int[]nums,int target){
		while(leftIndex<=rightIndex){
			int midIndex=(leftIndex+rightIndex)/2;
			if(target==nums[midIndex]){
				return midIndex;
			}else if(target>nums[midIndex]){
				leftIndex=midIndex+1;
			}else{
				rightIndex=midIndex-1;
			}
		}
		return -1;
	}
}
