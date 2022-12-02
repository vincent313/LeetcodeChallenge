package TopLikedQuestion;
/**
 * 35. Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
**/
public class SearchInsertNode {
	public int searchInsert(int[] nums, int target) {
		int result=findIndex(0,nums.length-1,nums,target);
		return result;
	}

	public int findIndex(int left,int right,int []nums,int target){
		int result;
		if(left==right){
			if(target<nums[left]){
				result=left;
			}else if(target>nums[right])
			{result=left+1;}
			else{result=left;}
			return result;
		}
		int mid=(left+right)/2;
		if(nums[mid]==target){return mid;}
		if(target<nums[mid]){
			result=findIndex(left,mid,nums,target);
		}else{
			result=findIndex(mid+1,right,nums,target);
		}
		return result;
	}
}

