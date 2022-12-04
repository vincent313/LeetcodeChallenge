/**3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *  */
package TopLikedQuestion;

import java.util.HashMap;

public class LongestSubstringWithoutRepatingCharacters {
	public static void main(String[] args) {
	int i=lengthOfLongestSubstring("eeydgwdykpv");
		System.out.println(i);
	}

	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> map= new HashMap<Character,Integer>();
		int head=0;
		int tail=0;
		int end=s.length();
		int maxlength=0;
		while(head<end){
			if(!map.containsKey(s.charAt(head))){
				if((head-tail+1)>maxlength){maxlength=(head-tail+1);}
			}else{
				int newtail=map.get(s.charAt(head))+1;
				for(int i=tail;i<newtail;i++){
					map.remove(s.charAt(i));
				}
				tail=newtail;
			}
			map.put(s.charAt(head),head);
			head++;
		}
		return maxlength;
	}
}
