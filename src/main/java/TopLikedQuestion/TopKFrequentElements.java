package TopLikedQuestion;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Medium
 * 12.8K
 * 473
 * company
 * Amazon
 * company
 * Facebook
 * company
 * Google
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * */
public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i:nums){
			if(map.containsKey(i)){
				int value=map.get(i);
				map.put(i,value+1);
			}else{
				map.put(i,1);
			}
		}
		int size=map.size();
		ArrayList <Map.Entry<Integer,Integer>> arraylist=new ArrayList<Map.Entry<Integer,Integer>>();
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){
			arraylist.add(entry);
		}
		Collections.sort(arraylist,

				new Comparator<Map.Entry<Integer,Integer>>(){
					public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
						return o2.getValue()-o1.getValue();

					}
				}
		);

		int [] result=new int[k]   ;
		for(int i=0;i<k;i++){
			result[i]=arraylist.get(i).getKey();
		}

		return result;
	}
}
