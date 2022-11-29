package TopLikedQuestion;

import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {
}
/**
 * 1. using stack to solve this problem
 * 2.1 if char is ( { [,push to stack
 * 2.2 if not ,the char must pair with the element in the stack top
 * 2.3 if stack empty and first element is )}],return false
 * 3.when pointer traverse the whole String, and stack is not empty,return false.
 * */

class ValidParenthesesArraylist{
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

/**implement by stack*/
class ValidParenthesesStack {
	public boolean isValid(String s) {
		Stack<Character> stack=new Stack<Character>();
		int size=s.length();
		for(int i=0;i<size;i++){
			char c=s.charAt(i);
			if(c=='('||c=='{'||c=='['){
				stack.push(c);
			}else{
				if(stack.isEmpty()){
					return false;
				}

				char c1=stack.pop();
				if(c1=='('&&c!=')'||c1=='{'&&c!='}'||c1=='['&&c!=']'){
					return false;
				}
			}
		}
		if(stack.isEmpty()){return true;}
		return false;
	}
}

