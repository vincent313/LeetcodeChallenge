package TopLikedQuestion;
/**
 * 56. Merge Intervals

 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * */
import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if(intervals.length==1){return intervals;}
		Arrays.sort(intervals,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){return o1[1]-o2[1];}
				return o1[0]-o2[0];
			}
		});

		ArrayList<int[]> arr=new ArrayList<int[]>();
		for(int[] i:intervals){
			if(arr.size()==0){
				arr.add(i);
				continue;
			}
			int[] j=arr.get(arr.size()-1);
			if(i[0]<=j[1]){
				int[] temp={j[0],Math.max(i[1],j[1])};
				arr.remove(arr.get(arr.size()-1));
				arr.add(temp);
				continue;
			}
			arr.add(i);
		}

		int[][] result=new int[arr.size()][2];
		for(int i=0;i<arr.size();i++){
			result[i]=arr.get(i);
		}
		return result;

	}
}
