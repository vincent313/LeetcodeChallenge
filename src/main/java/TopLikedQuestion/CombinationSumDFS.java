package TopLikedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumDFS {
	public static void main(String[] args) {

		CombinationSumBFS cs=new CombinationSumBFS();
		int [] arr={2,3,6,7};
		cs.combinationSum(arr,7);
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
		ArrayList<Integer> tempList=new ArrayList<Integer>();
		Arrays.sort(candidates);
		for(int i=0;i<candidates.length;i++){
			calculateCombination(candidates,target,result,tempList,i);
			tempList.clear();
		}
		return result;
	}

	public void calculateCombination(int[] dict,int target,ArrayList<List<Integer>> result,ArrayList<Integer> tempList,int start){

		tempList.add(dict[start]);
		if(target==dict[start]){
			ArrayList<Integer> temp=new ArrayList<Integer>(tempList);
			result.add(temp);
			return ;
		}else if(target<dict[start]){
			return ;
		}

		int value=target-dict[start];

		for(int i=start;i<dict.length;i++){
			calculateCombination(dict,value,result,tempList,i);
			tempList.remove(tempList.size()-1);
		}
	}
}
