package TopLikedQuestion;
/**
 * 206.Reverse the Linked List
 *
 *Given the head of a singly linked list, reverse the list, and return the reversed list.
 **/

import java.util.ArrayList;

/**
 * 1.if head == null,......
 * 2.if head.next ==null,....
 * 3.if current.next==null,.....
 *
 * */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null){return null;}
		if(head.next==null){return head;}
		if(head.next.next==null){
			ListNode temp=head.next;
			temp.next=head;
			head.next=null;
			return temp;
		}
/**
 * current->next->temp  ====> null<-current  nextNode=current.next    temp=next.next
 * **/
		ListNode currentNode=head;
		ListNode nextNode=currentNode.next;
		ListNode tempNode=nextNode.next;
		currentNode.next=null;

		/** if temp->not null
		 * null<-somenode<-current(next)  current=nextNode next(temp)=temp  temp=temp.next
		 * */
		while(tempNode.next!=null){
			nextNode.next=currentNode;
			currentNode=nextNode;
			nextNode=tempNode;
			tempNode=tempNode.next;
		}
		ArrayList<Integer> arr=new ArrayList<>();
		ArrayList<Integer>acc =new ArrayList<>();
		arr.equals(acc);
		nextNode.next=currentNode;
		tempNode.next=nextNode;
		return tempNode;
	}
}

public class ListNode {
int val;
ListNode next;
 ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
