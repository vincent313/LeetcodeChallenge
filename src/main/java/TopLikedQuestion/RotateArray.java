package TopLikedQuestion;
/**
 * 189. Rotate Array
 * Medium
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * */
public class RotateArray {
	public void rotate(int[] nums, int s) {
		int length=nums.length;
		int k=s%nums.length;
		if(nums==null||length==1){return;}
		if(k==0||k==length){return;}
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
	}

	private void reverse(int[] nums,int start,int end){
		while(end>start){
			int temp;
			temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start ++;
			end--;
		}
	}
}
