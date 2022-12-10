package TopLikedQuestion;

import java.util.HashSet;
import java.util.Stack;

/**
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * **/
public class JumpGame1 {
	int target;
	HashSet<Integer> set=new HashSet<Integer>();
	public boolean bottomToUp(int[] nums){
		if(nums==null||nums.length==1){return true;}
		int current=nums.length-1;
		boolean[] memo=new boolean[current+1];
		memo[current]=true;
		while(current>0){
			current--;
			boolean temp=false;
			for(int i=0;i<=nums[current];i++){
				if(memo[current+i]){
					temp=true;
					break;
				}
			}
			memo[current]=temp;
		}
		return memo[0];
	}

	public boolean TopToDown(int[] nums) {
		target=nums.length-1;
		if(target==0){return true;}
		return calculate(nums,0);
	}

	private boolean calculate(int[] nums,int start){
		int maxiSteps=nums[start];
		for(int i=1;i<=maxiSteps;i++){
			int nextStep=start+i;
			if(nextStep==target){
				return true;
			}else if(nextStep>target){
				set.add(nextStep);
				return false;
			}

			if(set.contains(nextStep)){
				continue;
			}else{
				boolean flag=calculate(nums,nextStep);
				if(flag){return true;}
				set.add(nextStep);
			}
		}
		set.add(start);
		return false;
	}

}
