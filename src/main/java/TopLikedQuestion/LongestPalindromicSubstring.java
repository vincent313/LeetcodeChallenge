package TopLikedQuestion;
/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * */
public class LongestPalindromicSubstring {
	int front=0;
	int back=0;
	int max=0;
	int size;
	public String longestPalindrome(String s) {
		size=s.length();
		if(s.length()==1){return s;}
		for(int mid=0;mid<size-1;mid++){
			if(s.charAt(mid)==s.charAt(mid+1)){
				getMirrorNum(s,mid);
			}

			if(mid+2<size&&s.charAt(mid)==s.charAt(mid+2)){
				getMirrorByAxis(s,mid+1);
			}
		}
		return s.substring(back,front+1);
	}
	public void getMirrorNum(String s,int i){
		int head=i+1;
		int tail=i;
		while(true){
			if(head==size||tail<0){break;}
			if(s.charAt(head)==s.charAt(tail)){
				if(head-tail+1>max){
					max=head-tail+1;
					front=head;
					back=tail;
				}
				head++;
				tail--;
			}else{
				break;
			}
		}
	}

	public void getMirrorByAxis(String s,int axis){
		int head=axis+1;
		int tail=axis-1;
		while(true){
			if(head==size||tail<0){break;}
			if(s.charAt(head)==s.charAt(tail)){
				if(head-tail+1>max){
					max=head-tail+1;
					front=head;
					back=tail;
				}
				head++;
				tail--;
			}else{
				break;
			}
		}
	}
}
