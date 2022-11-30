package TopLikedQuestion;

import java.util.ArrayList;

/**234. Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * A palindrome is a sequence that reads the same forward and backward.*/



//implement by Arraylist . time O(2n)->O(n) ,space O(n)
	//using arraylist store linked list. two pointer begin++ ,end--. when begin==end, or begin > end, return true
public class PalindromeLinkedList {
	boolean isPalindrome(ListNode head){
		if(head==null){return true;}
		if(head.next==null){return true;}
		ArrayList<ListNode> arr=new ArrayList<ListNode>();
		while(head!=null){
			arr.add(head);
			head=head.next;
		}

		int frontIndex=0;
		int backIndex=arr.size()-1;
		while(frontIndex<=backIndex){
			if (arr.get(frontIndex).val!=arr.get(backIndex).val){
				return false;
			}
			frontIndex++;
			backIndex--;
		}
		return true;
	}
}

/** Time O(1.5n)=O(n), Space O(1)
 * Implement by reverse linked list
 * find the middle of the linked, slow index and quick index
 * reverse the half back of linked list
 * compare half front and half back
**/
 class PalindromeLinkedList1 {

	boolean isPalindrome(ListNode head){
		if(head==null){return true;}
		if(head.next==null){return true;}
		if(head.next.next==null){
			if(head.val==head.next.val){
				return true;
			}
			return false;
		}
		if(head.next.next.next==null){
			if(head.val==head.next.next.val){return true;}
			return false;
		}
		ListNode slowIndex=head;
		ListNode quickIndex=head;
		boolean isEven;
		while(true){
			if(quickIndex.next==null){
				isEven=false;
				break;
			}else if(quickIndex.next.next==null){
				isEven=true;
				break;
			}
			quickIndex=quickIndex.next.next;
			slowIndex=slowIndex.next;
		}

		ListNode halfHead;
		if(isEven){
			halfHead=slowIndex.next;
		}else{
			halfHead=slowIndex;
		}

		ListNode previous=halfHead;
		ListNode current=previous.next;
		ListNode temp=current.next;

		previous.next=null;
		current.next=previous;
		while(temp!=null){
			current.next=previous;
			previous=current;
			current=temp;
			temp=temp.next;
		}
		current.next=previous;
		while(current.next!=null){
			if(head.val!=current.val){return false;}
			head=head.next;
			current=current.next;
		}
		if(head.val!=current.val){return false;}
		return true;

	}
}