package TopLikedQuestion;

import java.util.*;
/**
 * 46. Permutations

 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * */
public class Permutations {

	public List<List<Integer>> permuteBFS(int[] nums) {
		int inputSize=nums.length;
		Queue<ArrayList<Integer>> queue=new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		Set<Integer> set=new HashSet<Integer>();
		List<List<Integer>> result= new ArrayList<List<Integer>>();

		if(inputSize==1){
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.add(nums[0]);
			result.add(list);
			return result;
		}

		for(int i:nums){
			ArrayList<Integer> list=new ArrayList<Integer>();
			set.add(i);
			list.add(i);
			queue.offer(list);
		}

		while(!queue.isEmpty()){
			ArrayList<Integer> list=queue.poll();
			for(int i:list){
				if(set.remove(i)){
					temp.add(i);
				}
			}
			for(int i:set){
				ArrayList<Integer> arr=new ArrayList<Integer>(list);
				arr.add(i);
				if(arr.size()==inputSize){
					result.add(arr);
				}else{
					queue.offer(arr);
				}
			}

			for(int i:temp){
				set.add(i);
			}
		}
		return result;
	}

	List<List<Integer>> result= new ArrayList<List<Integer>>();
	boolean[] status;
	int size=0;
	public List<List<Integer>> permuteDFS(int[] nums) {
		size=nums.length;
		status=new boolean[nums.length];
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for(boolean i:status){
			i=false;
		}
		recursion(nums,0,temp);
		return result;

	}

	public void recursion(int[] nums,int currDeep,ArrayList<Integer> arr){
		if(currDeep==size){
			result.add(new ArrayList<Integer>(arr));
			return;
		}

		for(int i=0;i<size;i++){
			if(!status[i]){
				arr.add(nums[i]);
				status[i]=true;
				currDeep++;
				recursion(nums,currDeep,arr);
				currDeep--;
				status[i]=false;
				arr.remove(arr.size()-1);
			}
		}
	}
}
