package TopLikedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams

 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.*/
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
		List<List<String>> result=new ArrayList<List<String>>();

		for(int i=0;i<strs.length;i++){
			char[] temp=strs[i].toCharArray();
			Arrays.sort(temp);
			String s=new String(temp);
			if(map.containsKey(s)){
				map.get(s).add(i);
			}else{
				ArrayList<Integer> arr=new ArrayList<Integer>();
				arr.add(i);
				map.put(s,arr);
			}
		}

		for(ArrayList<Integer> arr:map.values()){
			ArrayList<String> temp=new ArrayList<String>();
			for(int i:arr){
				temp.add(strs[i]);
			}
			result.add(temp);
		}
		return result;

	}
}
