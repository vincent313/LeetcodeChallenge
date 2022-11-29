package TopLikedQuestion;

import java.util.ArrayList;

public class ValidParentheses {
}
/**
 * 1. using stack to solve this problem
 * 2.1 if char is ( { [,push to stack
 * 2.2 if not ,the char must pair with the element in the stack top
 * 2.3 if stack empty and first element is )}],return false
 * 3.when pointer traverse the whole String, and stack is not empty,return false.
 * */

class ValidParenthesesSolution {
	public boolean isValid(String s) {
		ArrayList<Character> arr=new ArrayList<Character>();
		int size=s.length();
		int index=-1;
		for(int i=0;i<size;i++){
			char c=s.charAt(i);
			if(c=='('||c=='['||c=='{')
			{
				arr.add(c);
				index++;
				continue;
			}
			if(index==-1){return false;}
			char c1=arr.get(index);
			if(c1=='('&&c!=')'||c1=='['&&c!=']'||c1=='{'&&c!='}'){
				return false;
			}
			arr.remove(index);
			index--;
		}
		if(index!=-1){return false;}
		return true;
	}
}
