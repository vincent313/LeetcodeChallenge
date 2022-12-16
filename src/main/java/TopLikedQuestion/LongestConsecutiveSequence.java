package TopLikedQuestion;

import java.util.Arrays;
/***
 128. Longest Consecutive Sequence
 Medium

 Example 1:

 Input: nums = [100,4,200,1,3,2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 Example 2:

 Input: nums = [0,3,7,2,5,8,4,6,0,1]
 Output: 9
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		Arrays.sort(nums);
		int highest=0;
		int current=0;
		int previous=nums[0];
		for(int i:nums){
			if(i-previous==1){
				current++;
				if(current>highest){
					highest=current;
				}
			}else if(i==previous){
				continue;
			}else{
				current=0;
			}
			previous=i;
		}
		return highest+1;
	}
}
