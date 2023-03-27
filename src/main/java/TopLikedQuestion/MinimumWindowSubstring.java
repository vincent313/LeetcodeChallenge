package TopLikedQuestion;

import java.util.HashMap;
import java.util.Map;
/**
 *76. Minimum Window Substring
 * Hard
 * 14.6K
 * 621
 * company
 * Airbnb
 * company
 * Lyft
 * company
 * Amazon
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * Hard
 * 14.6K
 * 621
 * company
 * Airbnb
 * company
 * Lyft
 * company
 * Amazon
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(t.length()>s.length()){
			return "";
		}
		Map<Character,Integer> target=new HashMap<>();
		Map<Character,Integer> current=new HashMap<>();
		int targetNum=t.length();
		int currentNum=0;

		for(int i=0;i<t.length();i++){
			char c=t.charAt(i);
			Integer temp=target.get(c);
			if(temp==null){
				target.put(c,1);
				current.put(c,0);
			}else{
				target.put(c,temp+1);
			}
		}
		int currentSize=-1;
		int headPointer=0;
		int tailPointer=0;
		String result="";
		while(true){

			if(currentNum<targetNum){
				if(headPointer==s.length()){
					break;
				}
				currentNum+=moveHead(target,current,s.charAt(headPointer));
				headPointer++;
				continue;
			}
			// System.out.println("head:"+headPointer+" tail:"+tailPointer+" currentsize:"+currentSize);
			if(tailPointer==s.length()){break;}
			if(currentSize==-1||(headPointer-tailPointer)<currentSize){
				currentSize=headPointer-tailPointer;
				result=s.substring(tailPointer,headPointer);
			}

			currentNum+=moveTail(target,current,s.charAt(tailPointer));
			tailPointer++;


		}
		return result;
	}

	private int moveHead(Map<Character,Integer> target, Map<Character,Integer> current,char c){
		int temp=0;
		if(!target.containsKey(c)){return temp;}
		if(current.get(c)<target.get(c)){
			temp=1;
		}
		current.put(c,current.get(c)+1);
		return temp;

	}

	private int moveTail(Map<Character,Integer> target, Map<Character,Integer> current,char c){
		if(!target.containsKey(c)){return 0;}
		current.put(c,current.get(c)-1);
		if(current.get(c)<target.get(c)){
			return -1;
		}

		return 0;
	}
}
