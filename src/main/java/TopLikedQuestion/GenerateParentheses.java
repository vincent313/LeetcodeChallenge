package TopLikedQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 22. Generate Parentheses

 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *  */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		Queue<String> queue=new LinkedList<String>();
		queue.offer("(");
		for(int i=1;i<2*n;i++){
			while(queue.peek().length()==i){
				String current=queue.poll();
				int flag=determineParenthesis(current,n);
				if(flag==0){
					queue.offer(current+')');
				}else if(flag==1){
					queue.offer(current+'(');
					queue.offer(current+')');
				}else{
					queue.offer(current+'(');
				}
			}
		}

		List<String> result=new ArrayList<String>();
		while(!queue.isEmpty()){
			result.add(queue.poll());
		}
		return result;
	}

	public int determineParenthesis(String s,int n){
		if(s==""){
			return 2;
		}
		int leftCount=0;
		int rightCount=0;
		int max=n;
		for(char c:s.toCharArray()){
			if(c=='('){
				leftCount++;
			}else{
				rightCount++;
			}
		}
		// 'left' is full,'right'only
		if (leftCount==max){
			return 0;
		}
		// 'left' is more than 'right', and'left' is not full, 'left' and 'right'
		if(leftCount>rightCount){
			return 1;
		}
		//'left' equals right, left only
		return 2;
	}
}
