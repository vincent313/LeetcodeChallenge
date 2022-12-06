package TopLikedQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 17. Letter Combinations of a Phone Number

 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.*/
public class LetterCombinationsOfaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		if(digits.length()==0){return new ArrayList<>();}
		Queue<String> queue=new LinkedList<String>();
		queue.offer("");
		char[][] dict={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		for(int i=0;i<digits.length();i++){
			char[] letters=dict[digits.charAt(i)-'0'];
			while(queue.peek().length()==i){
				String current=queue.poll();
				for(char c:letters){
					queue.offer(current+c);
				}
			}
		}
		List<String> result=new ArrayList<String>();
		while(!queue.isEmpty()){
			result.add(queue.poll());
		}
		return result;
	}
}
