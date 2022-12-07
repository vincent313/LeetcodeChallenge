package TopLikedQuestion;
/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)*/
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null){return head;}
		ListNode firstNode=null;
		ListNode currentNode=head;
		ListNode previousNode=null;
		ListNode nextNode=null;
		while(true){
			if(currentNode==null||currentNode.next==null){break;}
			nextNode=currentNode.next;
			if(previousNode==null){
				firstNode=currentNode.next;
			}else{previousNode.next=nextNode;}
			currentNode.next=nextNode.next;
			nextNode.next=currentNode;
			previousNode=currentNode;
			currentNode=currentNode.next;
		}

		return firstNode;
	}
}
