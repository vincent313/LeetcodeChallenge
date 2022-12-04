package TopLikedQuestion;
/**
 * 2. Add Two Numbers

 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *  */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result;
		ListNode head;
		int carry=0;
		int val=l1.val+l2.val;
		if (val>=10){
			result=new ListNode(val-10);
			carry=1;
		}else{
			result=new ListNode(val);
		}

		head=result;

		while(!(l1.next==null&&l2.next==null)){
			int i=0;
			if(l1.next==null){
				l2=l2.next;
				i=l2.val+carry;
			}else if(l2.next==null){
				l1=l1.next;
				i=l1.val+carry;
			}else{
				l1=l1.next;
				l2=l2.next;
				i=l1.val+l2.val+carry;
			}
			if (i>=10){
				result.next=new ListNode(i-10);
				carry=1;
			}else{
				result.next=new ListNode(i);
				carry=0;
			}
			result=result.next;
		}

		if (carry==1){
			result.next=new ListNode(1);
		}
		return head;
	}
}
