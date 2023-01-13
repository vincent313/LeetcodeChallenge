package TopLikedQuestion;
/**
 * 155. Min Stack
 * Medium
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * */
public class MinStack {
	Node node;
	int currentNum;
	int minVal;
	class Node{
		int val;
		int min;
		Node next;
		Node(int val,int min,Node node){
			this.val=val;
			this.min=min;
			this.next=node;
		}
	}

	public MinStack() {
		currentNum=0;
		minVal=0;
		node=new Node(0,0,null);
	}

	public void push(int val) {
		if(currentNum==0){
			node.next=new Node(val,val,null);
			minVal=val;
			currentNum++;
			return;
		}

		if(val<minVal){
			minVal=val;
		}
		Node temp=new Node(val,minVal,node.next);
		node.next=temp;
		currentNum++;
	}

	public void pop() {
		if(currentNum==0){return;}

		currentNum--;
		Node temp=node.next.next;
		node.next=temp;
		if(temp!=null){minVal=temp.min;}
	}

	public int top() {
		return node.next.val;
	}

	public int getMin() {
		return minVal;
	}
}
