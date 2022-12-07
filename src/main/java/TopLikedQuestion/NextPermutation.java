package TopLikedQuestion;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/**
 * 31. Next Permutation
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *  */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums.length==1){return;}
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		int lastIndex=nums.length-1;
		boolean found=false;
		map.put(nums[lastIndex],lastIndex);
		for(int i=lastIndex-1;i>=0;i--){
			int iValue=nums[i];
			for(int j:map.keySet()){
				if(j>iValue){
					int jIndex=map.get(j);
					nums[i]=j;
					nums[jIndex]=iValue;
					found=true;
					lastIndex=i;
					break;
				}
			}
			if(found){break;}
			map.put(iValue,i);
		}
		if(!found){
			Arrays.sort(nums);
		}else{
			Arrays.sort(nums,lastIndex+1,nums.length);
		}
	}
}
