package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;
/**
 * 78. Subsets
*
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]*/
public class Subset {

	List<List<Integer>> result=new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Subset s=new Subset();
		int[] nums={1,2,3};
		s.subsets(nums);
	}
	public List<List<Integer>> subsets(int[] nums) {
		result.add(new ArrayList<Integer>());
		if(nums.length==0){return result;}
		ArrayList<Integer> temp=new ArrayList<Integer>();
		recursionDFS(nums,0,temp);
		return result;
	}

	private void recursionDFS(int[] nums,int index,ArrayList<Integer> temp){
		if(index>nums.length-1){
			return;
		}

		for(int i=index;i<nums.length;i++){
			temp.add(nums[i]);
			ArrayList<Integer> tempresult=new ArrayList<Integer>(temp);
			result.add(tempresult);
			recursionDFS(nums,i+1,temp);
			temp.remove(temp.size()-1);
		}
	}
}
