package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;
/**
 * 438. Find All Anagrams in a String
 * Medium
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 * */
public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
		int[] dict = new int[26];
		int[] curr = new int[26];
		List<Integer> res = new ArrayList<>();

		for(int i = 0; i < s.length(); i++){
			curr[s.charAt(i) - 'a']++;

			if(i < p.length()) {
				dict[p.charAt(i) - 'a']++;

				if(i == p.length() - 1 && helper(dict, curr)) {
					res.add(0);
				}
			} else {
				curr[s.charAt(i - p.length()) - 'a']--;

				if(helper(dict, curr)) {
					res.add(i - p.length() + 1);
				}
			}
		}

		return res;
	}

	private boolean helper(int[] dict, int[] curr) {
		for(int i = 0; i < 26; i++) {
			if(dict[i] != curr[i]) return false;
		}

		return true;
	}
}
