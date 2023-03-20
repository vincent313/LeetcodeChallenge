package TopLikedQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *763. Partition Labels
 * Medium
 * 9.3K
 * 344
 * company
 * Amazon
 * company
 * Facebook
 * company
 * Uber
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * */
public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		int[] start=new int[26];
		int[] end =new int[26];
		for(int i=0;i<26;i++){
			start[i]=-1;
			end[i]=-1;
		}

		char[] input=s.toCharArray();
		for(int i=0;i<input.length;i++){
			char c=input[i];
			if(start[c-'a']==-1){
				start[c-'a']=i;
				end[c-'a']=i;
			}else{
				end[c-'a']=i;
			}
		}

		List<int[]> list=new ArrayList<>();
		for(int i=0;i<26;i++){
			if(start[i]==-1){
				continue;
			}

			if(list.isEmpty()){
				int[] array=new int[2];
				array[0]=start[i];
				array[1]=end[i];
				list.add(array);
				continue;
			}

			int[] temp=new int[2];
			temp[0]=start[i];
			temp[1]=end[i];
			ArrayList<int[]> templist=new ArrayList<>();
			for(int[] array:list){
				if(temp[0]<array[0]&&temp[1]>array[1]){
					templist.add(array);
					continue;

				}else if(temp[0]>array[0]&&temp[1]<array[1]){
					temp[0]=array[0];
					temp[1]=array[1];
					templist.add(array);
					break;
				}else if(temp[0]<array[0]&&temp[1]<array[1]&&temp[1]>array[0]){
					temp[1]=array[1];
					templist.add(array);
					continue;

				}else if(temp[0]>array[0]&&temp[0]<array[1]&&temp[1]>array[1]){
					temp[0]=array[0];
					templist.add(array);
					continue;
				}
			}
			for(int[] array:templist){
				list.remove(array);
			}
			list.add(temp);

		}

		Collections.sort(list,new Comparator<int[]>(){
			@Override
			public int compare(int[] i1,int[] i2){
				if(i1[0]>i2[0]){
					return 1;
				}else{
					return -1;
				}
			}
		});

		List<Integer> result=new ArrayList<>();
		for(int [] array:list){
			result.add(array[1]-array[0]+1);
		}

		return result;
	}
}
