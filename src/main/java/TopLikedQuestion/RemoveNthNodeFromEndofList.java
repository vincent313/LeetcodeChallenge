package TopLikedQuestion;

import java.util.HashMap;

/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *  */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int count=1;
		ListNode node=head;
		HashMap<Integer,ListNode> list=new HashMap<Integer,ListNode>();
		list.put(count,node);
		while(node.next!=null){
			count++;
			node=node.next;
			list.put(count,node);
		}

		int target=count-n;
		if(target==0){
			if(count==1){return null;}
			head=list.get(2);
			return head;
		}
		list.get(target).next=list.get(target+2);
		return head;
	}
}
