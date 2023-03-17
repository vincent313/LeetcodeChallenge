package TopLikedQuestion;

import java.util.HashMap;
import java.util.Map;
/**
 *567. Permutation in String
 * Medium
 * 9.5K
 * 301
 * company
 * Yandex
 * company
 * Amazon
 * company
 * Microsoft
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 * ***/
public class PermutationinString {
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length()>s2.length()){return false;}
		Map<Character,Integer> target=new HashMap<Character,Integer>();
		Map<Character,Integer> current=new HashMap<Character,Integer>();
		int tarInt=s1.length();
		int curInt=0;
		char[] s1CharArray=s1.toCharArray();
		char[] s2CharArray=s2.toCharArray();
		for(char c:s1CharArray){
			if(target.containsKey(c)){
				target.put(c,target.get(c)+1);
			}else{
				target.put(c,1);
			}
		}

		for(int i=0;i<tarInt;i++){
			if(!target.containsKey(s2CharArray[i])){
				continue;
			}
			if(addChar(s2CharArray[i],current,target.get(s2CharArray[i]))){
				curInt++;
				if(curInt==tarInt){
					return true;
				}
			}
		}



		int tail=0;
		int head=tarInt-1;
		while(head<s2CharArray.length-1){
			head++;
			if(target.containsKey(s2CharArray[head])){
				if(addChar(s2CharArray[head],current,target.get(s2CharArray[head]))){
					curInt++;
				}
			}

			if(target.containsKey(s2CharArray[tail])){
				if(deleteChar(s2CharArray[tail],current,target.get(s2CharArray[tail]))){
					curInt--;
				}
			}

			tail++;

			if(curInt==tarInt){
				return true;
			}
		}
		return false;


	}

	private boolean addChar(char c,Map<Character,Integer> dic,int i){
		int temp;
		if(!dic.containsKey(c)){
			temp=0;
		}else{
			temp=dic.get(c);
		}

		dic.put(c,temp+1);
		if(temp<i){
			return true;
		}else{
			return false;
		}
	}

	private boolean deleteChar(char c,Map<Character,Integer> dic,int i){
		int temp=dic.get(c);
		dic.put(c,temp-1);
		if(temp<=i){
			return true;
		}else{
			return false;
		}
	}
}
