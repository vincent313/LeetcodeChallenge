package TopLikedQuestion;

import java.util.List;
/***
 *139. Word Break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int strLength=s.length();
		boolean[] dp=new boolean[strLength+1];
		dp[strLength]=true;
		for(int i=strLength-1;i>=0;i--){
			for(String str:wordDict){
				if((i+str.length())<=strLength&&s.substring(i,i+str.length()).equals(str)){
					if(dp[i+str.length()]==true){
						dp[i]=true;
					}
				}
			}
		}
		return dp[0];
	}
}
