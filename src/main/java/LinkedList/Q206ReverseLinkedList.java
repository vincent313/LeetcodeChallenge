package LinkedList;

public class Q206ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null){return null;}
		if(head.next==null){return head;}
		ListNode current=head;
		ListNode last=current.next;
		current.next=null;
		while(true){
			ListNode temp=current;
			current=last;
			if(current.next==null){
				current.next=temp;
				break;
			}
			last=last.next;
			current.next=temp;
		}
		return last;
	}
}

