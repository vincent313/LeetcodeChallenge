package TopLikedQuestion;

import java.util.*;

/**
 * 01. two sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * */

public class TwoSum {
}
/**my solution*
 *1.copy int[] in to list
 * 2.sort list from small to big
 * 3.two pointer first is head,second is tail
 * 4.head+tail=> bigger than target, taill --
 * head +tail=>smaller than target,break inside loop--- head++ tail=list.size()-1
 *
 * repeat above
 * until head+tail==target
 * get index ,return index
 *
 */

class Solution {
	public int[] twoSum(int[] nums, int target) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i:nums){
			list.add(i);
		}
		Collections.sort(list);

		int head=0;
		int tail=list.size()-1;
		int x=0;
		int y=0;
		boolean flag=true;
		while(flag){
			x=list.get(head);
			while(true){
				y=list.get(tail);
				if(x+y>target){
					tail--;
				}else if(x+y<target){
					break;
				}else{
					flag=false;
					break;
				}
			}
			if(flag){head++;}
		}
		int index=0;
		int[] result=new int[2];
		for(int i=0;i<nums.length;i++){
			if (index==2){break;}
			if (nums[i]==x||nums[i]==y){
				result[index]=i;
				index++;
			}
		}
		return result;
	}
}

/**Leetcode example
 * 1.copy nums[] in to map key->value value->index
 * 2.Traverse nums[],using hashmap to determine whether the (target-value) is existed and index is different. if existed,and two index not equal ,return two index;
 * */
class Solution1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		// In case there is no solution, we'll just return null
		return null;
	}
}
/**
 * 1.don't need to copy nums[] first.
 * 2.Traverse nums,if (target-value) exist,return index
 *    else put (value index) in to hashmap
 * 3. time complex is O(n)
 * */
class BestSolution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		// In case there is no solution, we'll just return null
		return null;
	}
}