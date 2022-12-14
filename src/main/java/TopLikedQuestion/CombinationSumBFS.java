package TopLikedQuestion;

import java.util.*;

public class CombinationSumBFS {
	List<List<Integer>> result= new ArrayList<List<Integer>>();
	Queue<ArrayList<Integer>> queue=new LinkedList<ArrayList<Integer>>();
	HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();

	public static void main(String[] args) {
		CombinationSumBFS cs=new CombinationSumBFS();
		int[] a={8,7,4,3};
		List<List<Integer>> list=cs.combinationSum(a,11);
	boolean[][] test= new boolean[5][5];
		System.out.println(test[3][3]);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		for(int i=0;i<candidates.length;i++){
			hashmap.put(candidates[i],i);
			System.out.println(candidates[i]+" "+i);
		}

		for(int i=0;i<candidates.length;i++){

			if(candidates[i]==target){
				ArrayList<Integer> arr=new ArrayList<Integer>();
				arr.add(candidates[i]);
				result.add(arr);
				continue;
			}else if(candidates[i]>target){
				break;
			}

			getCombination(candidates,target,i);
		}
		return result;
	}

	public void getCombination(int[] candi,int target,int start){
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		arr1.add(candi[start]);
		queue.offer(arr1);
		while(!queue.isEmpty()){
			ArrayList<Integer> arr=queue.poll();
			int currentValue=0;

			for(int i:arr){
				currentValue+=i;
			}
			int startIndex=hashmap.get(arr.get(arr.size()-1));
			for(int i=startIndex;i<candi.length;i++){
				int newValue=currentValue+candi[i];
				if(newValue<target){
					ArrayList<Integer> array=new ArrayList<Integer>(arr);
					array.add(candi[i]);
					queue.offer(array);
				}else if(newValue==target){
					ArrayList<Integer> array=new ArrayList<Integer>(arr);
					array.add(candi[i]);
					result.add(array);
				}else{
					break;
				}

			}
		}
	}
}
